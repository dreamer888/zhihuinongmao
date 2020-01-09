package com.wqwy.zhnm.base.service.job;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.ConvertUtils;
import com.wqwy.zhnm.base.component.utils.DateUtils;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.component.utils.StringUtil;
import com.wqwy.zhnm.base.component.utils.wxpay.WXPay;
import com.wqwy.zhnm.base.entity.Refund;
import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.entity.ShopUserCoupon;
import com.wqwy.zhnm.base.service.RefundService;
import com.wqwy.zhnm.base.service.SellerGoodsService;
import com.wqwy.zhnm.base.service.ShopOrderDetailService;
import com.wqwy.zhnm.base.service.ShopOrderService;
import com.wqwy.zhnm.base.service.ShopUserCouponService;
import com.wqwy.zhnm.base.service.base.WechatPayPerformance;

public class CancelOnlineOrderJob implements Job {
	
	private static final Logger logger = LoggerFactory.getLogger(CancelOnlineOrderJob.class);

	@Autowired
	private ShopOrderService shopOrderService;
	
	@Autowired
	private ShopOrderDetailService shopOrderDetailService;
	
	@Autowired
	private SellerGoodsService sellerGoodsService;
	
	@Autowired
	private WechatPayPerformance wechatPayPerformance;
	
	@Autowired
	private RefundService refundService;
	
	@Autowired
	private ShopUserCouponService shopUserCouponService;
	
	/**
	 * TODO 事务
	 * 1,2可归于一个业务的事务
	 */
	@Autowired(required = false)
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataLoadMap = context.getJobDetail().getJobDataMap();
		String shopOrderId = dataLoadMap.getString(DefaultConstants.JOB_DETAIL_ONLINE_SHOPORDER_ID);
		logger.info("execute online order: " + shopOrderId + " cancel operation. ");
		/*
		 * 1.将订单改为超时取消状态
		 * 2.将商户订单商品改为超时取消状态(已有商户抢的订单商品)
		 * 3.用户退款
		 */
		/*
		 * 1
		 */
		ShopOrder so = new ShopOrder();
		so.setOrderId(shopOrderId);
		so = shopOrderService.get(shopOrderId);
		
		/*
		 * 仅有待接单的订单可以被取消
		 * (可能存在订单在改变状态后没来得及删除定时任务,任务被触发)
		 * TODO 考虑锁表
		 */
		if (!DefaultConstants.ShopOrderEnum.SHOPORDER_PAYED_NEED_ACCEPT_ORDER.getShopOrderEnum().equals(so.getStatus()))
			return;
		
		so.setStatus(DefaultConstants.ShopOrderEnum.SHOPORDER_AUTOMATIC_CANCEL.getShopOrderEnum());
		so.setCancelTime(new Date());
		shopOrderService.updateForJob(so);
		
		/*
		 * 2.
		 * 	2.1将订单商品
		 * 	2.2将所有订单商品中有商户抢的商品的库存退回商户
		 */
		ShopOrderDetail sod = new ShopOrderDetail();
		sod.setOrderId(shopOrderId);
		List<ShopOrderDetail> sodList = shopOrderDetailService.findList(sod);
		
		sod.setStatus(DefaultConstants.ShopOrderEnum.SHOPORDER_AUTOMATIC_CANCEL.getShopOrderEnum());
		if (sodList != null && !sodList.isEmpty())
			shopOrderDetailService.update(sod);
		
		sodList = sodList.stream().filter(s -> s.getSellerId()!=null).collect(Collectors.toList());//TODO s.getSellerId()!=null 可能需要修改
		sodList.forEach(s -> {
			SellerGoods sg = new SellerGoods();
			sg.setSellerId(s.getSellerId());
			sg.setGoodsId(s.getGoodsId());
			sg = sellerGoodsService.findList(sg).get(0);//一个商户只能添加一个同种商品
			sg.setCurrentStock(sg.getCurrentStock().add(s.getGoodsCount()));
			sellerGoodsService.update(sg);
		});
		
		//取消订单时，优惠劵回滚
		handleCoupon(so);
		
		/*
		 * 3
		 * 	用户微信退款
		 * note: out_trade_no为线上订单的订单编号(ShopOrder.orderId) {@link com.weixin.util.Package#getPackage}
		 */
		logger.info("do refund in job");
		BigDecimal orderTotal = so.getOrderTotal();
		orderTotal = new BigDecimal(orderTotal.toString()); // TODO 暂时使用1分钱用来测试0.01
		
		try {
			wechatPayPerformance.doRefund(shopOrderId, ConvertUtils.DoubleMoneyUnitYuanToLongMoneyUnitFen(orderTotal).toString());
		} catch (Exception e) {
			/*
			 * TODO
			 * 微信退款失败,记录需要被记录
			 */
			logger.error("start handle refund fail order");
			//处理退款失败的订单
			handleRefund(shopOrderId, orderTotal);
		}
	}
	
	//取消订单时，优惠劵回滚
	private void handleCoupon(ShopOrder shopOrder) {
		if(StringUtil.isValid(shopOrder.getCouponId()) && !shopOrder.getCouponId().equals("0")) {
	    	ShopUserCoupon shopUserCoupon = new ShopUserCoupon(); 
	    	shopUserCoupon.setStatus(0);
	    	shopUserCoupon.setCouponId(shopOrder.getCouponId());
	    	shopUserCoupon.setUserId(shopOrder.getUserId());
	    	List<ShopUserCoupon> list = shopUserCouponService.findList(shopUserCoupon);
	    	logger.info("handleCoupon-->list-->"+list.size());
	        if(list!=null && list.size()>0){
	        	ShopUserCoupon userCoupon = list.get(0);
	        	userCoupon.setStatus(1); //1、启用
	        	userCoupon.setUsercouponId(userCoupon.getUsercouponId());
	        	shopUserCouponService.update(userCoupon);
	        	logger.info("handleCoupon-->update-->ok");
	        }
	    }
	}
	
	//处理退款失败的订单
	private void handleRefund(String shopOrderId,BigDecimal orderTotal) {
		Refund refund = getRefund(shopOrderId);
		if(refund == null) { 
			saveRefund(shopOrderId, orderTotal);
		}
		//退款失败可延时发起3次
		for (int i = 0; i <3; i++) {
			logger.info("延时发起退款-->"+i++);
		    Refund refundo = getRefund(shopOrderId);
			try {
				Thread.sleep(1000*10);  //延时10秒
				//status： 0、未处理  1、已处理  time：发起退款请求次数
				if(refundo != null && refundo.getStatus()==0 && refundo.getTime()<=3) { 
					wechatPayPerformance.doRefund(shopOrderId, ConvertUtils.DoubleMoneyUnitYuanToLongMoneyUnitFen(orderTotal).toString());
					refundo.setStatus(1); //1、已处理
					refundService.update(refundo);
					logger.info("延时发起退款成功");
					break;
				}
			} catch (InterruptedException e1) {
				refundo.setTime(refundo.getTime()+1); //次数叠加
				refundService.update(refundo);
				logger.error("延时发起退款超时-->"+e1.getMessage());
			}
		}
	}
    
    //记录退款失败的订单	
	private void saveRefund(String orderId,BigDecimal orderTotal) {
		Refund refund = new Refund(); 
		refund.setRefundId(StringUtil.get32UUID());
		refund.setOrderId(orderId);
		refund.setRefundPrice(orderTotal.toString());
		refund.setRefundExplain("退款失败!");
		refund.setAddTime(DateUtils.datetimeFormat.format(new Date()));
		refund.setStatus(0);               // 状态(0、未处理 1、已处理)
		refundService.insert(refund);      //写入退款金额
	}
	
	//检索当前退款失败订单是否存在
	private Refund getRefund(String orderId) {
		Refund refund = new Refund();
		refund.setOrderId(orderId);
		List<Refund> list = refundService.findList(refund);
		if(list==null || list.size()==0) {
			return null;
		}
		return list.get(0);
	}
	
	public static void main(String[] args) {
		   WXPay wxpay =null;
		   try {
			    HashMap<String, String> data = new HashMap<String, String>();
	            Map<String, String> responseMap = wxpay.refund(data);
	            logger.info("do ShopOrder refund response map: " + responseMap);
	            String returnCode = responseMap.get("return_code");// 通信标识，非交易标识，交易是否成功需要查看result_code来判断
//	    		String returnMsg = responseMap.get("return_msg");
	    		String resultCode = responseMap.get("result_code");
	            if (!DefaultConstants.SUCCESS.equals(returnCode) || !DefaultConstants.SUCCESS.equals(resultCode));
	            	throw new BusinessException("responseMap: " + JsonUtils.AsJsonString(responseMap));
	        } catch (Exception e) {
	        	throw new BusinessException(e.getMessage());
	        }
	}
}

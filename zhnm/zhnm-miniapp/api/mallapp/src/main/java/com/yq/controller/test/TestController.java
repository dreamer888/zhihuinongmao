package com.yq.controller.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.change.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.utils.ConvertUtils;
import com.wqwy.zhnm.base.component.utils.DateUtils;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.component.utils.StringUtil;
import com.wqwy.zhnm.base.entity.Refund;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopUserCoupon;
import com.wqwy.zhnm.base.service.MarketService;
import com.wqwy.zhnm.base.service.RefundService;
import com.wqwy.zhnm.base.service.ShopUserCouponService;
import com.wqwy.zhnm.base.service.base.WechatPayPerformance;

@Controller
public class TestController extends BaseController{
	
	@Autowired
	private RefundService refundService;
	
	@Autowired
	private WechatPayPerformance wechatPayPerformance; 
	
	@Autowired
	private MarketService marketService;
	
	@Autowired
	private ShopUserCouponService shopUserCouponService;
	
	@ResponseBody
	@RequestMapping(value = {"/refundHandle", "/", "/test/refundHandle" }, produces = "application/json;charset=UTF-8")
	public JsonResponse<?> refundHandle(HttpServletRequest request){
		String shopOrderId = "101010";
		BigDecimal orderTotal = new BigDecimal("0.01"); 
		Refund refund = getRefund(shopOrderId);
		if(refund == null) { 
			saveRefund(shopOrderId, orderTotal);
		}
			//退款失败可延时发起3次
			for (int i = 0; i <=3; i++) {
						try {
							Thread.sleep(1000*10);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Refund refundo = getRefund(shopOrderId);
						if(refundo != null && refundo.getStatus()==0 && refundo.getTime()<3) { 
							try {
								wechatPayPerformance.doRefund(shopOrderId, ConvertUtils.DoubleMoneyUnitYuanToLongMoneyUnitFen(orderTotal).toString());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								refundo.setStatus(1); //1、已处理
								refundo.setTime(refundo.getTime()+1); //次数叠加;
								refundService.update(refundo);
								e.printStackTrace();
							}
						}
			}
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
	//写入失败的退款记录	
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
	
	//检索当前订单是否存在
	private Refund getRefund(String orderId) {
		Refund refund = new Refund();
		refund.setOrderId(orderId);
		List<Refund> list = refundService.findList(refund);
		if(list==null || list.size()==0) {
			return null;
		}
		return list.get(0);
	}
	
	
	@ResponseBody
	@RequestMapping(value = {"/handleCoupon", "/", "/test/handleCoupon" }, produces = "application/json;charset=UTF-8")
	public JsonResponse<?> handleCoupon(HttpServletRequest request){
		logger.info("handleCoupon-->test");
		ShopOrder shopOrder = new ShopOrder();
		shopOrder.setCouponId("a38d54cea2084529b87042b8b47d2cf6");
		shopOrder.setUserId("9a2e21fc0c1d411ab7024c5d1a14b51d");
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
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

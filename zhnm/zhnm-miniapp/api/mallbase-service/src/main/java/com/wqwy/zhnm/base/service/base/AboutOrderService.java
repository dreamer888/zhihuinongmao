package com.wqwy.zhnm.base.service.base;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailDTO;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.request.GeoGetLocationByAddressStringRequest;
import com.wqwy.zhnm.base.component.utils.DateUtils;
import com.wqwy.zhnm.base.component.utils.GeoDeUtils;
import com.wqwy.zhnm.base.component.utils.StringUtil;
import com.wqwy.zhnm.base.dao.ShopOrderMapper;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.service.ShopOrderDetailService;
import com.wqwy.zhnm.base.service.ShopOrderService;
import com.wqwy.zhnm.base.service.async.RabbitMQAsyncJobService;
import com.wqwy.zhnm.base.service.job.CancelOnlineOrderJob;
import com.wqwy.zhnm.base.service.job.SingleOnlineOrderJob;

@Component
public class AboutOrderService {
	
	private static final Logger logger = LoggerFactory.getLogger(AboutOrderService.class);

	@Autowired
	private QuartzManager quartzManager;
	
	@Autowired
	private ShopOrderService shopOrderService;
	
	@Autowired
	private ShopOrderDetailService shopOrderDetailService;
	
	@Autowired
	private RabbitMQAsyncJobService rabbitMQAsyncJobService;
	
	@Autowired
	private ShopOrderMapper shopOrderMapper;
	
	public static final String JOB_NAME = "job_orderCancel_";
	public static final String TRIGGER_NAME = "trigger_orderCancel_";
	public static final String JOB_GROUP_NAME = "job_order_orderCancel";
	public static final String TRIGGER_GROUP_NAME = "trigger_order_orderCancel";
	
	
	public static final String SINGLE_JOB_NAME = "job_orderSingle_";
	public static final String SINGLE_TRIGGER_NAME = "trigger_orderSingle_";
	public static final String SINGLE_JOB_GROUP_NAME = "job_order_orderSingle";
	public static final String SINGLE_TRIGGER_GROUP_NAME = "trigger_order_orderSingle";
	
	public static final long OrderTimeLimit = 10*60*1000;// 3*60*1000/10*60*1000
	
	public static final long ProlongPiesTime = 5000; // 延长5秒触发派单
	
	public static final BigDecimal DefaultDeliveryCost = new BigDecimal(5.0);// 配送费用默认值
	
	/**
	 * 
	 * @Title: doAfterUserCreateOnlineOrder  
	 * @Description: 用户创建线上订单操作完成后  
	 * @date 15 May 2018 4:57:47 PM  
	 * @param @param onlineOrderId  
	 * @return void  
	 * @throws
	 */
	/*
	 * 1.同步创建定时任务，在规定时间到达后取消线上订单
	 * 2.异步发送消息到商户MQ
	 */
	public int doAfterUserCreateOnlineOrder(String onlineOrderId,String deliveryTimeSlice) {
		logger.info("create onlineOrderId: " + onlineOrderId);
		
//		ShopOrder shopOrder = shopOrderService.get(onlineOrderId);
		ShopOrderDTO shopOrder = new ShopOrderDTO();
		shopOrder.setOrderId(onlineOrderId);
		List<ShopOrderDTO> shopOrderDTOList = shopOrderService.findShopOrders(shopOrder);
		if (shopOrderDTOList==null || shopOrderDTOList.isEmpty())
			throw new BusinessException();
		shopOrder = shopOrderDTOList.get(0);
		
		/*
		 * 用户下单后直接添加 1.配送费用 2.配送到达时间段
		 */
		shopOrder.setDeliveryCost(DefaultDeliveryCost);
		if(!StringUtil.isValid(deliveryTimeSlice)) {
			deliveryTimeSlice = DateUtils.GetDeliveryTimeSlice();
		}
		shopOrder.setDeliveryTimeSlice(deliveryTimeSlice);
		shopOrderMapper.update(shopOrder);
		
		/*
		 * -1
		 * 
		 * 用户 地理位置信息(location) 需要放入订单
		 */
//		GeoGetLocationByAddressStringRequest gglbasRequest = new GeoGetLocationByAddressStringRequest();
////		gglbasRequest.setCity(shopOrder.getAddrCity().trim()); // Geode地图不能获取包含省的city信息
//		gglbasRequest.setAddress(shopOrder.getAddrCity().trim() + shopOrder.getAddress().trim());
//		String location = null;
//		try {
//			location = GeoDeUtils.getLocationByAddressByGeoMap(gglbasRequest).getLocation();
//			logger.info("提交地理位置坐标: ");
//			logger.info("city: " + gglbasRequest.getCity());
//			logger.info("address: " + gglbasRequest.getAddress());
//			logger.info("location: " + location);
//		} catch (Exception e1) {
//			//throw new BusinessException();
//			return 3;//收货位置不在任何菜市场范围之内
//		}
//		shopOrder.setLocation(location);
//		
//		/*
//		 * 0
//		 * 
//		 * 判断订单能否有可能完成
//		 * (订单中有存在最近的一家市场的所有商户都没有的(包括没有库存的)商品)
//		 */
//		
//		ShopOrderDetail shopOrderDetail = new ShopOrderDetail();
//		shopOrderDetail.setOrderId(onlineOrderId);
//		List<ShopOrderDetail> shopOrderDetailList = shopOrderDetailService.findList(shopOrderDetail);
//		List<Integer> shopOrderDetailGoodsIdList = shopOrderDetailList.stream().map(ShopOrderDetail::getGoodsId).collect(Collectors.toList());
//		
//		Integer marketId = shopOrderService.getOneNearMarketByShopOrder(shopOrder);
//		if(null==marketId) {
//			return 3; //收货位置不在任何菜市场范围之内
//		}
//		
//		shopOrder.setMarketId(marketId);
//		shopOrderMapper.update(shopOrder);
//		
//		/*
//		 * 通过marketId 和shopOrderDetail 搜索出符合条件的商户
//		 * 1.商户属于marketId对应的market
//		 * 2.商户有shopOrderDetail.goodsId的商品 且 商品库存满足用户条件(sellerGoods.currentStock > shopOrderDetail.goodsCount)
//		 */
//		ShopOrderDetailDTO shopOrderDetailDTO = new ShopOrderDetailDTO();
//		shopOrderDetailDTO.setMarketId(marketId);
//		shopOrderDetailDTO.setOrderId(onlineOrderId);
//		shopOrderDetailDTO.setPreSellerGoodsStatus(DefaultConstants.SellerGoodsEnum.ON_SALE.getSellerGoodsEnum());
//		List<ShopOrderDetailDTO> shopOrderDetailDTOList = shopOrderDetailService.findListByCondition(shopOrderDetailDTO);
//		List<Integer> shopOrderDetailDTOGoodsIdList = shopOrderDetailDTOList.stream().map(ShopOrderDetailDTO::getGoodsId).collect(Collectors.toList());
//		
//		if (!shopOrderDetailDTOGoodsIdList.containsAll(shopOrderDetailGoodsIdList)){
//			return 2;// 已售订单中的商品在最近的市场已售罄
//			//throw new BusinessException(ResultUtils.SHOP_ORDER_GOODS_STOCK_OVER, ResultUtils.SHOP_ORDER_GOODS_STOCK_OVER_MSG);
//		}
		return 1;//创建订单成功
	}
	
	
	/**
	 * 
	 * @Title: doAfterUserPayedOnlineOrder  
	 * @Description: 用户支付线上订单操作完成后  
	 * @date 9 Jun 2018 5:03:26 PM  
	 * @param @param onlineOrderId  
	 * @return void  
	 * @throws
	 */
	public void doAfterUserPayedOnlineOrder(String onlineOrderId) {
		logger.info("payed onlineOrderId: " + onlineOrderId);
		
		ShopOrderDTO shopOrder = new ShopOrderDTO();
		shopOrder.setOrderId(onlineOrderId);
		List<ShopOrderDTO> shopOrderDTOList = shopOrderService.findShopOrders(shopOrder);
		if (shopOrderDTOList==null || shopOrderDTOList.isEmpty())
			throw new BusinessException();
		shopOrder = shopOrderDTOList.get(0);
		
		Integer marketId = shopOrderService.getOneNearMarketByShopOrder(shopOrder);
		if(marketId==null)
			throw new BusinessException();
		
		ShopOrderDetailDTO shopOrderDetailDTO = new ShopOrderDetailDTO();
		shopOrderDetailDTO.setMarketId(marketId);
		shopOrderDetailDTO.setOrderId(onlineOrderId);
		shopOrderDetailDTO.setPreSellerGoodsStatus(DefaultConstants.SellerGoodsEnum.ON_SALE.getSellerGoodsEnum());
		List<ShopOrderDetailDTO> shopOrderDetailDTOList = shopOrderDetailService.findListByCondition(shopOrderDetailDTO);
		
		/*
		 * 2
		 * 
		 * note:
		 * 1.消息发送失败或者部分失败后，操作继续(即使订单没有通知任何商户，可以依赖定时任务取消订单)
		 * 2.10:00-19:00区间，立即推送给商户;19:00-第二天9：00,推单时间为9:00
		 */
		try {
			ShopOrder order = shopOrderService.get(onlineOrderId);
		    String deliveryTime = order.getDeliveryTimeSlice();
			SimpleDateFormat fmt=new SimpleDateFormat("MM-dd");
            Date newdeliveryTime = fmt.parse(deliveryTime);
		    boolean sameDay = fmt.format(newdeliveryTime).equals(fmt.format(new Date()).toString());
			Calendar c = Calendar.getInstance();
			
			DateUtils.NINE_AM.set(Calendar.YEAR, c.get(Calendar.YEAR));
			DateUtils.NINE_AM.set(Calendar.MONTH,c.get(Calendar.MONTH));
			DateUtils.NINE_AM.set(Calendar.DATE,c.get(Calendar.DAY_OF_MONTH));
			
			DateUtils.NINETEEN_PM.set(Calendar.YEAR, c.get(Calendar.YEAR));
			DateUtils.NINETEEN_PM.set(Calendar.MONTH,c.get(Calendar.MONTH));
			DateUtils.NINETEEN_PM.set(Calendar.DATE,c.get(Calendar.DAY_OF_MONTH));
			
			String currTime = DateUtils.datetimeFormat.format(c.getTime());
		    String startTime = DateUtils.datetimeFormat.format(DateUtils.TEN_AM.getTime());
		    String endTime = DateUtils.datetimeFormat.format(DateUtils.NINETEEN_PM.getTime());
		    
		    logger.info("doAfterUserPayedOnlineOrder-->currTime:"+currTime);
		    logger.info("doAfterUserPayedOnlineOrder-->startTime:"+startTime);
		    logger.info("doAfterUserPayedOnlineOrder-->endTime:"+endTime);	
		    
			if (c.after(DateUtils.NINE_AM) && c.before(DateUtils.NINETEEN_PM) && sameDay) {  //追加验证配送时间是否当天
				
				cancelOnlineOrderJob(onlineOrderId);  //3分钟未接单自动取消订单
				
				logger.info("do send message to MQ for online order: " + onlineOrderId);
				rabbitMQAsyncJobService.doSendOrderGoodsMessageToMQBalanceQueue(shopOrder, shopOrderDetailDTOList);
				rabbitMQAsyncJobService.doSendOrderGoodsMessageToMQSellerQueue(shopOrder, shopOrderDetailDTOList);
				//订单记录推单时间
			    if(null!=order) {
			    	order.setSingleTime(new Date());
			    	
			    	//10点-19点下单按付款时间刷新配送时间
					if (c.after(DateUtils.TEN_AM) && c.before(DateUtils.NINETEEN_PM)) {
						 try {
							String s = new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HH:mm").parse(c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)))+
							"-"
							+new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HH:mm").parse((c.get(Calendar.HOUR_OF_DAY)+1)+":"+c.get(Calendar.MINUTE)));
							s = DateUtils.getDate_(0) +" " +s;
							order.setDeliveryTimeSlice(s);
							logger.info("doAfterUserPayedOnlineOrder-->付款后刷新配送时间: " + order.getDeliveryTimeSlice());
						 } catch (ParseException e) {
							 logger.info("doAfterUserPayedOnlineOrder-->付款后刷新配送时间开小差");
						 }
					}
					
			    	shopOrderMapper.update(order);
			    }
			}else {
				//派单时间 = 配送时间-1小时
				logger.info("配送时间-1小时 do create task for online order: " + onlineOrderId);
				//TODO
				Map<String, String> dataLoadMap = new HashMap<String, String>();
				dataLoadMap.put(DefaultConstants.JOB_DETAIL_ONLINE_SHOPORDER_ID, onlineOrderId);
			
				deliveryTime = deliveryTime.substring(0, 8).toString();
				Calendar calendar = Calendar.getInstance();
		    	String year = String.valueOf(calendar.get(Calendar.YEAR));
		    	deliveryTime = year + "-" +deliveryTime+":00:00";
		    	
		    	logger.info("doAfterUserPayedOnlineOrder-->deliveryTime:"+deliveryTime);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date= sdf.parse(deliveryTime);
				date.setHours(date.getHours()-1);
				
				Date triggerTime = new Date(date.getTime() + ProlongPiesTime);
				String triggerTimeString = DateUtils.GetCron(triggerTime);
				
				logger.info("doAfterUserPayedOnlineOrder-->triggerTimeString:"+triggerTimeString);
				quartzManager.addJob(SINGLE_JOB_NAME + onlineOrderId, SINGLE_JOB_GROUP_NAME, SINGLE_TRIGGER_NAME + onlineOrderId,
						SINGLE_TRIGGER_GROUP_NAME, SingleOnlineOrderJob.class, triggerTimeString, dataLoadMap);
			}
			
		} 
		catch (Exception e) {
			logger.warn("do send message to quartzJob/MQ for online order " + onlineOrderId + " failed");
			logger.warn(e.getMessage());
		}
	}
	
	/*
	 * 1.定时任务创建失败，用户下单&生成订单 操作需要终止(订单自动取消依赖定时任务)
	 * 2.商户3分钟未接单，自动取消订单
	 */
	
	private void cancelOnlineOrderJob(String onlineOrderId) {
		
		logger.info("do create task for online order: " + onlineOrderId +"start");
		
		//TODO
		Map<String, String> dataLoadMap = new HashMap<String, String>();
		dataLoadMap.put(DefaultConstants.JOB_DETAIL_ONLINE_SHOPORDER_ID, onlineOrderId);
		Date triggerTime = new Date(new Date().getTime() + OrderTimeLimit);
		String triggerTimeString = DateUtils.GetCron(triggerTime);
		quartzManager.addJob(JOB_NAME + onlineOrderId, JOB_GROUP_NAME, TRIGGER_NAME + onlineOrderId,
				TRIGGER_GROUP_NAME, CancelOnlineOrderJob.class, triggerTimeString, dataLoadMap);
		
		logger.info("do create task for online order: " + onlineOrderId +"end");
		
	}
}

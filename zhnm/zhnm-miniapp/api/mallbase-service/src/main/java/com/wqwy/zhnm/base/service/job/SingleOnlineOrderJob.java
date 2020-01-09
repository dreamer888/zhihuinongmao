package com.wqwy.zhnm.base.service.job;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailDTO;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.DateUtils;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.service.ShopOrderDetailService;
import com.wqwy.zhnm.base.service.ShopOrderService;
import com.wqwy.zhnm.base.service.async.RabbitMQAsyncJobService;
import com.wqwy.zhnm.base.service.base.AboutOrderService;
import com.wqwy.zhnm.base.service.base.QuartzManager;

public class SingleOnlineOrderJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(SingleOnlineOrderJob.class);

	@Autowired
	private ShopOrderService shopOrderService;
	
	@Autowired
	private ShopOrderDetailService shopOrderDetailService;
	
	@Autowired
	private RabbitMQAsyncJobService rabbitMQAsyncJobService;
	
	@Autowired
	private QuartzManager quartzManager;
	
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDataMap dataLoadMap = context.getJobDetail().getJobDataMap();
		String onlineOrderId = dataLoadMap.getString(DefaultConstants.JOB_DETAIL_ONLINE_SHOPORDER_ID);
		logger.info("execute online order: " + onlineOrderId + " single operation. ");
		
		cancelOnlineOrderJob(onlineOrderId);  //3分钟未接单自动取消订单
		
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
		
		logger.info("SingleOnlineOrderJob send message to MQ for online order: " + onlineOrderId);
		rabbitMQAsyncJobService.doSendOrderGoodsMessageToMQBalanceQueue(shopOrder, shopOrderDetailDTOList);
		rabbitMQAsyncJobService.doSendOrderGoodsMessageToMQSellerQueue(shopOrder, shopOrderDetailDTOList);
		
		/*
		 * 1.订单写入派单时间
		 */
		//订单记录推单时间
		ShopOrder order = shopOrderService.get(onlineOrderId);
	    if(null!=order) {
	    	order.setSingleTime(new Date());
	    	shopOrderService.updateForJob(order);
	    }
		logger.info("execute online order: " + onlineOrderId + " single operation successed. ");
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
		Date triggerTime = new Date(new Date().getTime() + AboutOrderService.OrderTimeLimit);
		String triggerTimeString = DateUtils.GetCron(triggerTime);
		quartzManager.addJob(AboutOrderService.JOB_NAME + onlineOrderId, AboutOrderService.JOB_GROUP_NAME, AboutOrderService.TRIGGER_NAME + onlineOrderId,
				AboutOrderService.TRIGGER_GROUP_NAME, CancelOnlineOrderJob.class, triggerTimeString, dataLoadMap);
		
		logger.info("do create task for online order: " + onlineOrderId +"end");
		
	}
	
}

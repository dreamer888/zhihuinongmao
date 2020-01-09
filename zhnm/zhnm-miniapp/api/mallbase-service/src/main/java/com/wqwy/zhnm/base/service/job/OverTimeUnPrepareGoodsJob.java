package com.wqwy.zhnm.base.service.job;

import java.util.List;

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
import com.wqwy.zhnm.base.service.ShopOrderDetailService;
import com.wqwy.zhnm.base.service.ShopOrderService;
import com.wqwy.zhnm.base.service.async.RabbitMQAsyncJobService;

public class OverTimeUnPrepareGoodsJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(OverTimeUnPrepareGoodsJob.class);

	@Autowired
	private ShopOrderService shopOrderService;
	
	@Autowired
	private ShopOrderDetailService shopOrderDetailService;
	
	@Autowired
	private RabbitMQAsyncJobService rabbitMQAsyncJobService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDataMap dataLoadMap = context.getJobDetail().getJobDataMap();
		String onlineOrderId = dataLoadMap.getString(DefaultConstants.JOB_DETAIL_ONLINE_SHOPORDER_ID);
		String unPrepareMsgType = dataLoadMap.getString(DefaultConstants.JOB_UNPREPARE_MSG_TYPE);
		logger.info("execute online orderId: " + onlineOrderId + " OverTimePrepareGoodsJob operation. ");
		logger.info("execute online unPrepareMsgType: " + unPrepareMsgType + " OverTimePrepareGoodsJob operation. ");
		
        ShopOrderDTO shopOrder = new ShopOrderDTO();
		shopOrder.setOrderId(onlineOrderId);
		List<ShopOrderDTO> shopOrderDTOList = shopOrderService.findShopOrders(shopOrder);
		if (shopOrderDTOList==null || shopOrderDTOList.isEmpty())
			throw new BusinessException();
		shopOrder = shopOrderDTOList.get(0);
		
		ShopOrderDetailDTO shopOrderDetailDTO = new ShopOrderDetailDTO();
		shopOrderDetailDTO.setMarketId(shopOrder.getMarketId());
		shopOrderDetailDTO.setOrderId(onlineOrderId);
		shopOrderDetailDTO.setPreSellerGoodsStatus(DefaultConstants.SellerGoodsEnum.ON_SALE.getSellerGoodsEnum());
		List<ShopOrderDetailDTO> shopOrderDetailDTOList = shopOrderDetailService.findListByCondition(shopOrderDetailDTO);
		
	    if(null!=shopOrder) {
	    	if(shopOrder.getStatus()==DefaultConstants.ShopOrderEnum.SHOPORDER_WAIT_SELLER_PREPARE_GOODS.getShopOrderEnum()) {
	    		//发送mq 
	    		logger.info("OverTimeUnPrepareGoodsJob send message to MQ for online order: " + onlineOrderId);
	    		rabbitMQAsyncJobService.doSendUnPrepareGoodsMessageToMQBalanceQueue(shopOrder, shopOrderDetailDTOList,unPrepareMsgType);
	    		rabbitMQAsyncJobService.doSendUnPrepareGoodsMessageToMQSellerQueue(shopOrder, shopOrderDetailDTOList,unPrepareMsgType);
	    		logger.info("OverTimeUnPrepareGoodsJob online order: " + onlineOrderId + " successed. ");
	    	}
	    }
		
	}
	
}

package com.wqwy.zhnm.base.service.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.service.ShopOrderDetailService;
import com.wqwy.zhnm.base.service.ShopOrderService;

public class FinishOnlineOrderJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(FinishOnlineOrderJob.class);

	@Autowired
	private ShopOrderService shopOrderService;
	
	@Autowired
	private ShopOrderDetailService shopOrderDetailService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataLoadMap = context.getJobDetail().getJobDataMap();
		String shopOrderId = dataLoadMap.getString(DefaultConstants.JOB_DETAIL_ONLINE_SHOPORDER_ID);
		logger.info("execute online order: " + shopOrderId + " finish operation. ");
		/*
		 * 1.将订单改为完成
		 * 2.将订单商品改为完成
		 */
		ShopOrder shopOrder = new ShopOrder();
		shopOrder.setOrderId(shopOrderId);
		shopOrder.setStatus(DefaultConstants.ShopOrderEnum.SHOPORDER_PAYED_WAIT_EVALUATE.getShopOrderEnum());
		shopOrderService.updateForJob(shopOrder);
		ShopOrderDetail sod = new ShopOrderDetail();
		sod.setOrderId(shopOrderId);
		sod.setStatus(DefaultConstants.ShopOrderEnum.SHOPORDER_PAYED_WAIT_EVALUATE.getShopOrderEnum());
		shopOrderDetailService.updateMultipleByShopOrder(sod);
		logger.info("execute online order: " + shopOrderId + " finish operation successed. ");
	}
	
}

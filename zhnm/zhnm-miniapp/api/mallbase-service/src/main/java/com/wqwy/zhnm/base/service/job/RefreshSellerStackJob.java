package com.wqwy.zhnm.base.service.job;

import java.math.BigDecimal;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.service.SellerGoodsService;

public class RefreshSellerStackJob implements Job{
	
	private static final Logger logger = LoggerFactory.getLogger(RefreshSellerStackJob.class);

	@Autowired
	private SellerGoodsService sellerGoodsService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		logger.info("RefreshSellerStackJob execute. ");
//		SellerGoods sg = new SellerGoods();
//		sg.setCurrentStock(BigDecimal.ZERO);
//		Integer updateCount = sellerGoodsService.updateAllStock(sg);
//		logger.info("update " + updateCount + " sellers stock finished. ");
	}

}

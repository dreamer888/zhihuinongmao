package com.wqwy.zhnm.base.service.config;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * 
 * @ClassName: JobAfterContextRefreshedService  
 * @Description: do some job after context loaded  
 * @author seven  
 * @date 22 May 2018 12:06:43 PM  
 *
 */
@Service
public class JobAfterContextRefreshedService implements ApplicationListener<ContextRefreshedEvent>{
	
	private static final Logger logger = LoggerFactory.getLogger(JobAfterContextRefreshedService.class);
			
	@Autowired(required = false)
	@Qualifier(value = "dataSourceScheduler")
	private Scheduler scheduler;
	
	@Autowired(required = false)
	@Qualifier(value = "refreshSellerStackTrigger")
	private Trigger refreshSellerStackTrigger;
	
	@Autowired(required = false)
	@Qualifier(value = "refreshSellerStackJobDetail")
	private JobDetail refreshSellerStackJobDetail;

	@Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // do what you want - you can use all spring beans (this is the difference between init-method and @PostConstructor where you can't)
        // this class can be annotated as spring service, and you can use @Autowired in it
		logger.info("onApplicationEvent");
		if (refreshSellerStackTrigger != null && refreshSellerStackJobDetail != null)
			doScheduleRefreshSellerStackJob();
    }
	
	private void doScheduleRefreshSellerStackJob() {
		if (this.scheduler == null)
			return;
		try {
			if (scheduler.checkExists(refreshSellerStackJobDetail.getKey()))
				scheduler.resumeJob(refreshSellerStackJobDetail.getKey());
			else {
				scheduler.deleteJob(refreshSellerStackJobDetail.getKey());
				scheduler.scheduleJob(refreshSellerStackJobDetail, refreshSellerStackTrigger);
			}
		} catch (SchedulerException e) {
			logger.error(e.getMessage());
		}
	}
    
}
package com.wqwy.zhnm.base.service.config;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.wqwy.zhnm.base.service.job.RefreshSellerStackJob;

@Configuration
@ConditionalOnProperty(name = "quartz.enabled.refreshSellerStack", havingValue = "true")
public class SchedulerSellerConfig {
	
	@Bean(name = "refreshSellerStackJobDetailFactory")
    public JobDetailFactoryBean refreshSellerStackJobDetailFactory() {
        return createJobDetail(RefreshSellerStackJob.class);
    }
	
	@Bean(name = "refreshSellerStackJobDetail")
	public JobDetail getJobDetail(@Qualifier("refreshSellerStackJobDetailFactory") JobDetailFactoryBean jobDetailFactoryBean) {
		return jobDetailFactoryBean.getObject();
	}
    
    @Bean(name = "refreshSellerStackTrigger")
    public CronTriggerFactoryBean refreshSellerStackTrigger(@Qualifier("refreshSellerStackJobDetail") JobDetail jobDetail,
                                                     @Value("${quartzjob.refreshSellerStack.cronExpression}") String cronExpression) {
        return createCronTrigger(jobDetail, cronExpression);
    }
    
//    @Bean(name = "sampleCronJobTrigger2")
//    public CronTriggerFactoryBean sampleCronJobTrigger2(@Qualifier("simulationJobDetail2") JobDetail jobDetail,
//                                                     @Value("${quartzjob.cron-expression.simulation2}") String cronExpression) {
//        return createCronTrigger(jobDetail, cronExpression);
//    }

    private static JobDetailFactoryBean createJobDetail(Class<? extends Job> jobClass) {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(jobClass);
        factoryBean.setGroup("group_for_job_on_start_seller");
        // job has to be durable to be stored in DB:
        factoryBean.setDurability(true);
//        factoryBean.setBeanName("refreshSellerStackJobDetail");
        return factoryBean;
    }

//    private static SimpleTriggerFactoryBean createTrigger(JobDetail jobDetail, long pollFrequencyMs) {
//        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
//        factoryBean.setJobDetail(jobDetail);
//        factoryBean.setStartDelay(0L);
//        factoryBean.setRepeatInterval(pollFrequencyMs);
//        factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
//        factoryBean.setGroup("group_for_job_on_start_lawstore");
//        // in case of misfire, ignore all missed triggers and continue :
//        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
//        return factoryBean;
//    }

    // Use this method for creating cron triggers instead of simple triggers:
    private static CronTriggerFactoryBean createCronTrigger(JobDetail jobDetail, String cronExpression) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setCronExpression(cronExpression);
        factoryBean.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
        factoryBean.setGroup("group_for_job_on_start_seller");
        return factoryBean;
    }

}

package com.wqwy.zhnm.base.service.config;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 
 * @ClassName: SchedulerConfig
 * @Description: scheduler初始化
 * @author seven
 * @date 23 Dec 2017 3:18:40 PM
 *
 */
@Configuration
@ConditionalOnProperty(name = "quartz.enabled", havingValue = "true")
public class SchedulerConfig{
	
	private static final Logger logger = LoggerFactory.getLogger(SchedulerConfig.class);
	
	@Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
	
	@Bean
    public JobFactory jobFactory(ApplicationContext applicationContext)
    {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

//	@Bean
//	public SchedulerFactoryBean getScheulerFactoryBean() {
//		return new SchedulerFactoryBean();
//	}
	
	/**
	 * 
	 * @date 23 Dec 2017 3:20:31 PM
	 * @Title: schedulerFactoryBean 
	 * @Description: 初始化scheduler
	 * @param @param dataSource
	 * @param @param jobFactory
	 * @param @param sampleJobTrigger
	 * @param @return
	 * @param @throws Exception
	 * @return Scheduler
	 * @throws
	 */
    @Bean(name = "dataSourceScheduler")
    public Scheduler schedulerFactoryBean(@Qualifier("quartzDataSource") DataSource dataSource, JobFactory jobFactory, SchedulerFactoryBean factory) throws Exception {
//        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // this allows to update triggers in DB when updating settings in config file:
        factory.setOverwriteExistingJobs(true);
        factory.setDataSource(dataSource);
        factory.setJobFactory(jobFactory);
        
        // https://stackoverflow.com/a/49763132/5751473
        factory.setTaskExecutor(null);

        factory.setQuartzProperties(quartzProperties());
        factory.afterPropertiesSet();

        Scheduler scheduler = factory.getScheduler();
        scheduler.setJobFactory(jobFactory);
        scheduler.start();
        return scheduler;
    }
    
}
package com.wqwy.zhnm.base.component.config;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * async support
 * @ClassName: AsyncConfiguration
 * @Description: async support
 * @author seven
 * @date Nov 27, 2017 9:56:02 PM
 *
 */
@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer{
	
	private final Logger log = LoggerFactory.getLogger(AsyncConfiguration.class);

	private final ComponentProperties componentProperties;
	
	public AsyncConfiguration(ComponentProperties componentProperties) {
		this.componentProperties = componentProperties;
	}
	
	@Override
    @Bean(name = "taskExecutor")
    public Executor getAsyncExecutor() {
        log.debug("Creating Async Task Executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(componentProperties.getAsync().getCorePoolSize());
        executor.setMaxPoolSize(componentProperties.getAsync().getMaxPoolSize());
        executor.setQueueCapacity(componentProperties.getAsync().getQueueCapacity());
        executor.setThreadNamePrefix("zhnm-wqwy-component-Executor-");
        return new ExceptionHandlingAsyncTaskExecutor(executor);
    }

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}

}
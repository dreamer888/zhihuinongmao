package com.wqwy.zhnm.base.service.config;

import java.util.Properties;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
@EnableAutoConfiguration
public class TransactionConfig {

    @Bean(name = "transactionInterceptorFor")
    public TransactionInterceptor transactionInterceptor(
            PlatformTransactionManager platformTransactionManager) {
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        
        transactionInterceptor
                .setTransactionManager(platformTransactionManager);
        Properties transactionAttributes = new Properties();
		
        transactionAttributes.setProperty("insert*",
                "PROPAGATION_REQUIRED,-Throwable");
        transactionAttributes.setProperty("update*",
                "PROPAGATION_REQUIRED,-Throwable");
        transactionAttributes.setProperty("delete*",
                "PROPAGATION_REQUIRED,-Throwable");
        transactionAttributes.setProperty("add*",
                "PROPAGATION_REQUIRED,-Throwable");
        transactionAttributes.setProperty("modify*",
                "PROPAGATION_REQUIRED,-Throwable");
        transactionAttributes.setProperty("change*",
                "PROPAGATION_REQUIRED,-Throwable");
        transactionAttributes.setProperty("remove*",
                "PROPAGATION_REQUIRED,-Throwable");
        
        transactionAttributes.setProperty("select*",
                "PROPAGATION_SUPPORTS,-Throwable,readOnly");
        transactionAttributes.setProperty("find*",
                "PROPAGATION_SUPPORTS,-Throwable,readOnly");
        transactionAttributes.setProperty("get*",
                "PROPAGATION_SUPPORTS,-Throwable,readOnly");

        transactionInterceptor.setTransactionAttributes(transactionAttributes);
        return transactionInterceptor;
    }
    
    @Bean
    public BeanNameAutoProxyCreator transactionAutoProxy() {
        BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
        transactionAutoProxy.setProxyTargetClass(true);
        transactionAutoProxy.setBeanNames("*ServiceImpl");
        transactionAutoProxy.setInterceptorNames("transactionInterceptorFor");
        return transactionAutoProxy;
    }
}

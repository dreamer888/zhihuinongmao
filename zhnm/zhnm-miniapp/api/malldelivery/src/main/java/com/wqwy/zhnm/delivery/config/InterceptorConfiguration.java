package com.wqwy.zhnm.delivery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author seven
 *
 */
@Component
public class InterceptorConfiguration implements WebMvcConfigurer {
	
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册拦截器
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/*/login")
                .excludePathPatterns("/*/register")
                .excludePathPatterns("/*/deliverers/password")
                
                .excludePathPatterns("/*/aliyun/oss/securityToken")
                .excludePathPatterns("/*/validateCodes")
                
                .excludePathPatterns("/*/forgotPassword")
	        	.excludePathPatterns("/*/sms")
	        	.excludePathPatterns("/*/versionControl")
	        	.excludePathPatterns("/versionInfo")
                .excludePathPatterns("/*/getVersions");

        // 还可以在这里注册其它的拦截器
        //registry.addInterceptor(new OtherInterceptor()).addPathPatterns("/**");
    }

}

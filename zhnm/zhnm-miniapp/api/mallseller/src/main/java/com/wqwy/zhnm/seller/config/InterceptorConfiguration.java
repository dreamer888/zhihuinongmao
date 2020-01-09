package com.wqwy.zhnm.seller.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
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

        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**")
              /*
               * 权限校验不拦截/{version}/login接口
               */
                .excludePathPatterns("/*/login")
                .excludePathPatterns("/*/register")
                .excludePathPatterns("/*/sellers/password")
                .excludePathPatterns("/*/balances")
                
                .excludePathPatterns("/*/shopCategories")
                .excludePathPatterns("/*/markets")
                
                .excludePathPatterns("/*/validateCodes")
                .excludePathPatterns("/*/aliyun/oss/securityToken")
                .excludePathPatterns("/wxpay/notify")
                .excludePathPatterns("/ccbpay/notify")
                .excludePathPatterns("/v1/ccbOnePointPay")
                .excludePathPatterns("/v1/afterOrderPayedTest")
                
                .excludePathPatterns("/*/forgotPassword")
	        	.excludePathPatterns("/*/sms")
	        	.excludePathPatterns("/*/versionControl")
	        	.excludePathPatterns("/versionInfo")
                .excludePathPatterns("/*/getVersions");
    }
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    	resolvers.add(new CurrentUserResolver());
	}

}

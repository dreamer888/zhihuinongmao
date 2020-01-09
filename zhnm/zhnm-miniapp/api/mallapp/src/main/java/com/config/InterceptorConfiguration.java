package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yq.interceptor.LoginInterceptor;

/**
 * 
 * @author seven
 *
 */
@Component
public class InterceptorConfiguration implements WebMvcConfigurer {
	
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册拦截器
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/app/**")
                
                .excludePathPatterns("/test/**")// 仅测试使用
                
                .excludePathPatterns("/automate/**")// 自动化测试
                
                .excludePathPatterns("/weixin/**");
    }

}

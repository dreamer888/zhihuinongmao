package com.wqwy.zhnm.seller.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: CurrentUser  
 * @Description: TODO  
 * @author seven  
 * @date 26 May 2018 10:48:44 AM  
 *
 */
/*
 * 获取当前的User,需要mapping被 AuthorizationInterceptor 拦截 由
 * com.wqwy.zhnm.seller.config.CurrentUserResolver 处理
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {
}

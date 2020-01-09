package com.wqwy.zhnm.seller.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @ClassName: RequestMethodGetInterceptor  
 * @Description: TODO  
 * @author seven  
 * @date 17 May 2018 3:40:56 PM  
 *
 */
@Component
public class RequestMethodGetInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (RequestMethod.GET.toString().equals(request.getMethod()))
			return true;
		return false;
	}
	
}

package com.wqwy.zhnm.seller.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.seller.annotation.CurrentUser;

/**
 * 
 * @ClassName: CurrentUserResolver  
 * @Description: TODO  
 * @author seven  
 * @date 26 May 2018 10:55:59 AM  
 *
 */
@Component
public class CurrentUserResolver implements HandlerMethodArgumentResolver {

	private static final Logger logger = LoggerFactory.getLogger(CurrentUserResolver.class);
	
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        return nativeWebRequest.getAttribute(DefaultConstants.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
    }
}

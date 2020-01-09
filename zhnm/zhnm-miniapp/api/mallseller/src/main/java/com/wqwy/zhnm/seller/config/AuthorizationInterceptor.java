package com.wqwy.zhnm.seller.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.Seller;
import com.wqwy.zhnm.base.service.SellerService;

/**
 * 
 * @ClassName: AuthorizationInterceptor  
 * @Description: TODO  
 * @author seven  
 * @date 17 May 2018 3:41:11 PM  
 *
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);
	
	@Autowired
	private SellerService sellerService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept,token,contenttype");
		logger.info(request.getRequestURL().toString());
		
		// 如果不是映射到方法直接通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		
		// 角色是称,直接跳过
		String role = request.getHeader(DefaultConstants.ROLE);
		if (DefaultConstants.LoginEnum.ROLE_BALANCE.toString().equals(role))
			return true;
		
		String token = request.getHeader(DefaultConstants.TOKEN);
		if (StringUtils.isBlank(token)) {
			throw new BusinessException(ResultUtils.AUTHORIZATION_FAIL, ResultUtils.AUTHORIZATION_FAIL_MSG);
		}
		
		Seller currentUser = new Seller();
		currentUser.setToken(token);
		List<Seller> sList = sellerService.findList(currentUser);
		if (sList == null || sList.isEmpty()) {
			throw new BusinessException(ResultUtils.NO_REGISTER_EXIST, ResultUtils.NO_REGISTER_EXIST_MSG);
		}
		currentUser = sList.get(0);
		request.setAttribute(DefaultConstants.CURRENT_USER, currentUser);
		return true;
	}
}

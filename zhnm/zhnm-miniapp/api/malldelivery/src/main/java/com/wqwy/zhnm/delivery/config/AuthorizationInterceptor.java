package com.wqwy.zhnm.delivery.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.Deliverer;
import com.wqwy.zhnm.base.service.DelivererService;

/**
 * Created by robin on 2/23/17.
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private DelivererService delivererService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept,token,contenttype");
		// 如果不是映射到方法直接通过
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		
		String token = request.getHeader(DefaultConstants.TOKEN);
		if (StringUtils.isBlank(token)) {
			throw new BusinessException(ResultUtils.AUTHORIZATION_FAIL, ResultUtils.AUTHORIZATION_FAIL_MSG);
		}
		
		Deliverer currentUser = new Deliverer();
		currentUser.setToken(token);
		List<Deliverer> sList = delivererService.findList(currentUser);
		if (sList == null || sList.isEmpty()) {
			throw new BusinessException(ResultUtils.NO_REGISTER_EXIST, ResultUtils.NO_REGISTER_EXIST_MSG);
		}
		currentUser = sList.get(0);
		request.setAttribute(DefaultConstants.CURRENT_USER, currentUser);
		return true;
	}
}

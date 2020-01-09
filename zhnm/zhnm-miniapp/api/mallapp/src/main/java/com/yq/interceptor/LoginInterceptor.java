package com.yq.interceptor;

import java.util.Enumeration;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.yq.listener.MySessionContext;
import com.yq.service.cart.CartManager;
import com.yq.service.user.ShopUserManager;



/**
 * 登陆拦截器.
 *
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Resource(name = "shopUserService")
	private ShopUserManager shopUserService;
	@Resource(name = "cartService")
	private CartManager cartService;
	
	private static Gson gson = new Gson();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("requestURI is :" + request.getRequestURI());
		boolean flag = false;
		Enumeration<String> es = request.getHeaderNames();
		String cookie = request.getHeader("cookie");
//		if(cookie!=null){
//			String session_id = cookie.split("=")[1];
//			HttpSession session = MySessionContext.getSession(session_id);
//			if(session==null){
//				map.put("result", 1005);
//				map.put("message", "尚未登录，跳转中...");
//				response.setContentType("text/json;charset=utf-8");
//				response.setCharacterEncoding("UTF-8");
//				response.getWriter().write(gson.toJson(map));
//			}
//			else{
//				flag=true ;
//			}
//		}
//		
//		return flag;
		if (cookie == null)
			return flag;
		String session_id = cookie.split("=")[1];
		HttpSession session = MySessionContext.getSession(session_id);
//		if (session != null)
		flag = true;
//		HttpSession currentRequestSession = request.getSession(false);
//		System.out.println(currentRequestSession == null);
//		System.out.println(!request.isRequestedSessionIdValid());
		try {
			if (session != null && session.getAttribute("shopUser") != null)
				return flag;
		} catch (IllegalStateException e) {
			logger.info("session invalidated");
		}
//		if (session != null) {
//			return flag;
//		}
//		String session_str = gson.toJson(session);
//		
//		logger.info("根据session_id获取MySessionContext中的HttpSession: " + session_str);
//		
//		Map<String, Object> strMap = gson.fromJson(session_str, new TypeToken<Map<String, Object>>() {
//		}.getType());
//		Map<String, Object> session_map = (Map<String, Object>) strMap.get("session");
//		Map<String, Object> attributes_map = (Map<String, Object>) session_map.get("attributes");
//		Map<String, Object> shopUser = (Map<String, Object>) attributes_map.get("shopUser");
//		
//		if (shopUser!=null)
//			return flag;
		
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(DefaultConstants.MiniAppLoginRedirectStr);
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
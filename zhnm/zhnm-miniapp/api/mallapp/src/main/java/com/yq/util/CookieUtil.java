package com.yq.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieUtil{

	/**
	 * 存cookie
	 */
	public static void cookieadd(HttpServletResponse response ,String key, String val) {
		try {
			// request.setCharacterEncoding("utf-8");
			// new一个Cookie对象,键值对为参数
			Cookie cookie = new Cookie(key, URLEncoder.encode(val, "utf-8"));// 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码，使用
			// 设置Cookie最大生存时间,以秒为单位,负数的话为浏览器进程,关闭浏览器Cookie消失
			cookie.setMaxAge(24 * 60 * 60 * 365 * 10); // 10年
			cookie.setPath("/");
			// 将Cookie添加到Response中,使之生效
			response.addCookie(cookie); // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 取cookie
	 */
	public List<Object> cookieout(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			Cookie[] cookies = request.getCookies();
			List<Object> list = new ArrayList<Object>();
			// 然后迭代之
			if (cookies != null && cookies.length > 0) { // 如果没有设置过Cookie会返回null
				
				Object w = new Object();
				for (Cookie cookie : cookies) {
					if (!"JSESSIONID".equals(cookie.getName())) {
					}
				}
				

			}
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	public static void cookiedelete(HttpServletRequest request,HttpServletResponse response) {
		// 删除Cookie的话,只需要将Cookie的生存期设为0即可
		Cookie jidCookie = new Cookie("JSESSIONID", null);
		jidCookie.setMaxAge(0);
		response.addCookie(jidCookie);
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = new Cookie(cookies[i].getName(), null);
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}
}

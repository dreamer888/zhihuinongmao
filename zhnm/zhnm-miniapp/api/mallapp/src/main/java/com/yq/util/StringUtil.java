package com.yq.util;

import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yq.listener.MySessionContext;

public class StringUtil {

	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
	
	public static String success_result = "1";
	public static String except_result = "0";
	public static String success_message = "提交成功";
	public static String error_message = "提交失败";
	public static String except_message = "服务器异常";
	public static String max_message = "已超出数量";
	public static String had_message = "您已经领取过啦";
	private static Gson gson = new Gson();
    
	public static boolean isInteger(String str) {  
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	        return pattern.matcher(str).matches();  
	}
	 
	@SuppressWarnings("unchecked")
	public static Map<String, Object> shopUser(HttpServletRequest request) { // 获取用户信息
		// setShopUser(session);//模拟用户信息
		// return (PageData) session.getAttribute("shopUser");
		String cookie = request.getHeader("cookie");
		if (StringUtils.isEmpty(cookie))
			return null;
		String session_id = cookie.split("=")[1];
		HttpSession session = MySessionContext.getSession(session_id);
		String session_str = gson.toJson(session);
		
		logger.info("根据session_id获取MySessionContext中的HttpSession: " + session_str);
		
		Map<String, Object> strMap = gson.fromJson(session_str, new TypeToken<Map<String, Object>>() {
		}.getType());
		Map<String, Object> session_map = (Map<String, Object>) strMap.get("session");
		Map<String, Object> attributes_map = (Map<String, Object>) session_map.get("attributes");
		Map<String, Object> shopUser = (Map<String, Object>) attributes_map.get("shopUser");
		return shopUser;
	}
	
	public static HttpSession session(HttpServletRequest request) {
		String cookie = request.getHeader("cookie");
		if (StringUtils.isEmpty(cookie))
			return null;
		String session_id = cookie.split("=")[1];
		return MySessionContext.getSession(session_id);
	}
	
	public static int cart_count(HttpServletRequest request) { // 获取用户购物车数量
		String cookie = request.getHeader("cookie");
		if (StringUtils.isEmpty(cookie))
			return 0;
		Map<String, Object> shopUser = shopUser(request);
		int cart_count = (new Double((double) shopUser.get("cart_count"))).intValue();
		return cart_count;
	}
	
	public static void add_session(HttpSession session){
		MySessionContext.AddSession(session);
	}
	
	public static void remove_session(HttpServletRequest request){
		HttpSession session = MySessionContext.getSession(get_session_id(request));
		MySessionContext.DelSession(session);
	}

//	@SuppressWarnings("unchecked")
//	public static int cart_count(HttpServletRequest request) { // 获取用户购物车数量
//		String cookie = request.getHeader("cookie");
//		if (StringUtils.isEmpty(cookie))
//			return 0;
//		String session_id = cookie.split("=")[1];
//		HttpSession session = MySessionContext.getSession(session_id);
//		String session_str = gson.toJson(session);
//		Map<String, Object> strMap = gson.fromJson(session_str, new TypeToken<Map<String, Object>>() {
//		}.getType());
//		Map<String, Object> session_map = (Map<String, Object>) strMap.get("session");
//		Map<String, Object> attributes_map = (Map<String, Object>) session_map.get("attributes");
//		Map<String, Object> session_id_map = (Map<String, Object>) attributes_map.get(session_id);
//		System.err.println("session_id_map-->" + session_id_map);
//
//		int cart_count = (new Double((double) session_id_map.get("cart_count"))).intValue();
//		return cart_count;
//	}

	public static String get_session_id(HttpServletRequest request) {
		String cookie = request.getHeader("cookie");
		String session_id = "";
		if (cookie == null) {
			/**
			 * 生成sessionId,而获取httpSession来生成sessionId仅仅用于获取不重复的随机字符串,可替换为其他实现方式
			 * TODO
			 */
			System.err.println("...request.getSession()=" +gson.toJson(request.getSession()));
			session_id = request.getSession().getId();
		} else {
			session_id = cookie.split("=")[1];
		}
		return session_id;
	}
//	/**
//	 * 组合存入session
//	 * @param session_id
//	 * @param map
//	 */
//	public static void set_session(String session_id,int cart_count, Map<String, Object> map,HttpServletRequest request) {
//		Map<String, Object> session = new HashMap<String, Object>();
//		Map<String, Object> attributes = new HashMap<String, Object>();
////		Map<String, Object> session_user = new HashMap<String, Object>();
//		map.put("session_id", session_id);
////		attributes.put(session_id, map);
////		session.put("id", session_id);
////		session.put("attributes", attributes);
//		System.err.println("重编session->"+gson.toJson(map));
//		request.getSession().setAttribute(session_id, gson.toJson(map));
//		System.err.println("重编->"+gson.toJson(MySessionContext.getSession(session_id)));
//	}

//	public static void setShopUser(HttpSession session) { // 模拟用户信息
//		PageData shopUser = new PageData();
//		shopUser.put("user_id", "dc4c0243eb694bbf9ece88b715460998");
//		shopUser.put("phone", "13800138000");
//		shopUser.put("username", "千派网络");
//		shopUser.put("openid", "oa-8a0cdWhvD_SFJLp16EM75hzHs");
//		shopUser.put("head_img",
//				"http://wx.qlogo.cn/mmopen/H2EOvRxc9g1UaDT9FTajN4HS7c6ueZ0ZzUl3uzzQ9HAeibxmKSTiczKreh5SNPjpEMfMOSVbeXm61V0LzTf9SudnDI2pyGuMNd/0");
//		session.setAttribute("cart_count", 5);
//		session.setAttribute("shopUser", shopUser);
//	}

	public static String getId() {
		// int random_num = (int) ((Math.random() * 9 + 1) * 100000);
		return new Date().getTime() + "";
	}

	// public static int toInt(String str){
	// int result = 0;
	// if(str.contains(".")){
	// result = Integer.parseInt(str.split("\\.")[0]);
	// }else{
	// result = Integer.parseInt(str);
	// }
	// return result;
	// }

	public static void main(String[] args) {
//		Double a = 0.0;
//		int b = (new Double(a)).intValue();
//		;
//
//		System.err.println(b);
		
		System.out.println("-->"+getId());
	}

}

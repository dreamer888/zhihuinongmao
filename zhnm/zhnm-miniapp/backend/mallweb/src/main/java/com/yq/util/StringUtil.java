package com.yq.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.change.util.PageData;

public class StringUtil {
	
	public static String success_message = "提交成功" ;
	public static String error_message = "提交失败" ;
	public static String except_message = "服务器异常" ;
	public static String max_message = "已超出数量" ;
	public static String had_message = "您已经领取过啦" ;
	
	public static PageData shopUser(HttpSession session){ //获取用户信息
		return  (PageData) session.getAttribute("shopUser");
	}
	public static String getId(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sf.format(new Date())+(int) ((Math.random() * 9 + 1) * 100000);
	}
	
	/**
	 * 公共的方法
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean checkObj(Object obj) {
		boolean bool = true;
		if (obj == null || "".equals(obj.toString().trim()))
			bool = false;
		return bool;
	}

	public static boolean checkStr(String str) {
		boolean bool = true;
		if (str == null || "".equals(str.trim()))
			bool = false;
		return bool;
	}

	public static String toString(Object obj) {
		return obj != null ? obj.toString() : "";
	}
	
	public static Long toLong(Object obj) {
		String str = toString(obj);
		return str != "" ? Long.parseLong(str) :0L;
	}
	
}

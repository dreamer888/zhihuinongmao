package com.weixin.util;

import java.util.Calendar;
import java.util.Date;

import com.wqwy.zhnm.base.component.utils.DateUtils;

public class StringUtil {
	private final static String token = "qianpai" ;
	
	public static String token (){
		return token;
	}
    
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		if (c.after(DateUtils.TEN_AM) && c.before(DateUtils.NINETEEN_PM)) {
			System.out.println("ok");
		}else {
			System.out.println("unok");
		}
	}
}

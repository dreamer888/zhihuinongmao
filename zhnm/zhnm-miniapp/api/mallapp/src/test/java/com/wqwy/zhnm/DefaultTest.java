package com.wqwy.zhnm;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;

public class DefaultTest {
	
	@Test
	public void t1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", 1005);
		map.put("message", "尚未登录，跳转中...");
		System.out.println(new Gson().toJson(map));
		System.out.println(DefaultConstants.MiniAppLoginRedirectStr);
	}
    
	public static void main(String[] args) {
		BigDecimal order_total = new BigDecimal("0.005");
		order_total=order_total.setScale(2, BigDecimal.ROUND_HALF_UP); 
		
		System.out.println("order_total--------->"+order_total);
	}
}

//package com.yq.util;
//
//import com.google.gson.Gson;
//import com.yq.entity.JsonBean;
//
//public class SscUtil {
//	private static Gson gson = new Gson();
//
//	public static String sschm() {
//		try {
//			String url = "http://f.apiplus.cn/cqssc-1.json";
//			String str = HttpRequest.sendGet(url, "");
//			JsonBean data = gson.fromJson(str, JsonBean.class);
//			return data.getList().get(0).getOpencode().replace(",", "");
//		} catch (Exception e) {
//			return "000000";
//		}
//	}
//
//	public static void main(String[] args) {
//
//		SscUtil sscUtil = new SscUtil();
//		System.out.println(sscUtil.sschm());
//
//	}
//
//}

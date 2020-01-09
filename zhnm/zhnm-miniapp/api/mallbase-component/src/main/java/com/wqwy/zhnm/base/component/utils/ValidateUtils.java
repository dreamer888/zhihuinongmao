package com.wqwy.zhnm.base.component.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
//
//import org.apache.tomcat.util.codec.binary.Base64;

public class ValidateUtils {
	
	private static final int SIXNUM_RANDOM_NUMBER_MIN = 100000;
	
	private static final int SIXNUM_RANDOM_NUMBER_MAX = 900000;
	
	public static String getSign(Map<String, Object> param){
		if(param == null || param.size() == 0)
			return null;
		List<String> list = new ArrayList<String>();
		for(Map.Entry<String, Object> entry: param.entrySet()){
			if(entry.getValue() != null){
				list.add(entry.getKey() + entry.getValue());
			}
		}
		Collections.sort(list);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<list.size();i++){
			sb.append(list.get(i));
		}
		sb.append("&ruicehudong");
		
		String md5Str = MD5Utils.getMD5String(sb.toString());
		
		return md5Str;
	}
	
	public static String getRandomString(){
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i < 10 ; i++){
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	/**
	 * 获取从最小值min 到最大值 max 之间的一个随机数
	 * @date Sep 23, 2017 9:59:37 AM
	 * @Title: getRandNum 
	 * @Description: 获取从最小值min 到最大值 max 之间的一个随机数
	 * @param @param min
	 * @param @param max
	 * @param @return
	 * @return int
	 * @throws
	 */
	public static int GetRandNum(int min, int max) {
	    int randNum = min + (int)(Math.random() * ((max - min) + 1));
	    return randNum;
	}
	
	/**
	 * 获取六位验证码
	 * @date Sep 23, 2017 9:59:52 AM
	 * @Title: get6NumRandomNumber 
	 * @Description: 获取六位数字验证码
	 * @param @return
	 * @return int
	 * @throws
	 */
	public static String Get6NumRandomNumber(){
		int randNum = SIXNUM_RANDOM_NUMBER_MIN + (int)(Math.random() * SIXNUM_RANDOM_NUMBER_MAX);
		return String.valueOf(randNum);
	}
	
	/**
	 * 发送短信验证码
	 * @date Sep 23, 2017 10:03:46 AM
	 * @Title: sendValificationCodeForPhone 
	 * @Description: 发送短信验证码
	 * @param @param phone
	 * @param @param valificationCode
	 * @return void
	 * @throws
	 */
	public static void sendValificationCodeForPhone(String phone, String valificationCode){
		//TODO 未实现，发送短信接口  调用 alidayu
	}
	
	public static String GetToken(String phone, String password){
		String md5 = ValidateUtils.getRandomString()+phone+password;
		return MD5Utils.getMD5String(md5);
	}
	
}

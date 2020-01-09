package com.wqwy.zhnm.base.component.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.OrderedJSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wqwy.zhnm.base.component.constant.UMSApiConstants;

public class UnionPayQRCodeUtils {

	private static final Logger logger = LoggerFactory.getLogger(UnionPayQRCodeUtils.class);
	
	/**
	 * 
	 * @Title: GetSignString  
	 * @Description: 获取sign  
	 * @date 14 May 2018 10:28:39 AM  
	 * @param @param s
	 * @param @return
	 * @param @throws JSONException  
	 * @return String  
	 * @throws
	 */
	public static final String GetSignString(Object o) throws JSONException {
		return GetSignMD5StringByCanSignStringAndKey(GetCanSignString(o));
	}
	
	public static final String GetSignString(String s) throws JSONException {
		return GetSignMD5StringByCanSignStringAndKey(GetCanSignString(s));
	}
	
	public static final String GetSignString(String s, String key) throws JSONException {
		return GetSignMD5StringByCanSignStringAndKey(GetCanSignString(s), key);
	}
	
	/**
	 * 
	 * @Title: GetSignMD5StringByCanSignStringAndKey  
	 * @Description: 获取md5签名字符串 通过待加密sign和key  
	 * @date 14 May 2018 10:24:34 AM  
	 * @param @param canSignString
	 * @param @param key
	 * @param @return  
	 * @return String  
	 * @throws
	 */
	public static final String GetSignMD5StringByCanSignStringAndKey(String canSignString) {
		return GetSignMD5StringByCanSignStringAndKey(canSignString, UMSApiConstants.UMS_SIGN_KEY);
	}
	public static final String GetSignMD5StringByCanSignStringAndKey(String canSignString, String key) {
		String needSignString = canSignString + key;
		logger.info("needSign String: " + needSignString);
		String sign = MD5Utils.getMD5String(needSignString).toUpperCase();
		logger.info("sign: " + sign);
		return sign;
	}
	
	/**
	 * 
	 * @Title: GetCanSignString  
	 * @Description: 将json类型的String转换获取可用于生成unionpay使用的sign的String  
	 * @date 11 May 2018 3:21:16 PM  
	 * @param @param s
	 * @param @return
	 * @param @throws JSONException  
	 * @return String  
	 * @throws
	 */
	/*
	 * 没有值（包含空字符串）的参数无需传递，也不需包含到待签名数据中；
	 * 根据HTTP协议要求，传递参数的值中如果存在特殊字符（如：&、@等），则该值需要做URL Encoding，
	 * 这样请求接收方才能接收到正确的参数值。
	 * 注意：这种情况下，待签名数据应该是原始值而不是encoding之后的值
	 */
	public static final String GetCanSignString(String s) throws JSONException {
		// 字符串转jsonobject
		OrderedJSONObject jObject = new OrderedJSONObject(s);
		// 取出jsonobject的key放入List<String>
		JSONArray ja = jObject.names();
		List<String> jaList = new ArrayList<String>();
		for (int i=0; i<ja.length(); i++) {
			jaList.add(ja.getString(i));
		}
		Collections.sort(jaList);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<jaList.size(); i++) {
			Object o = jObject.get(jaList.get(i));
			// 为空的key不需包含到待签名数据中
			if (o==null)
				continue;
			String str = o.toString();
			if (StringUtils.isBlank(str))
				continue;
			str = StringEscapeUtils.unescapeJava(str);
			sb.append(jaList.get(i) + "=" + str);
			sb.append("&");
		}
		int last = sb.lastIndexOf("&");
		logger.debug("can sign String: " + sb.toString().substring(0, last-1));
		return sb.toString().substring(0, last-1);
	}
	
	public static final String GetCanSignString(Object o) throws JSONException {
		return GetCanSignString(JsonUtils.AsJsonString(o));
	}
	
	public static final String GetQRCodeIdOrBillNo() {
		return GetQRCodeIdOrBillNo(UMSApiConstants.UMS_QRCODE_MSGSRCID);
	}
	
	public static final String GetQRCodeIdOrBillNo(String msgSrcId) {
//		对于一次性二维码，商户需自行生成billNo。此时billNo需要符合银商规范，以银商分配的4位来源编号（msgSrcId）作为账单号的前4位，且在商户系统中此账单号保证唯一。总长度需大于6位，小于28位。银商的推荐规则为（无特殊情况下，建议遵守此规则）：
//		{来源编号(4位)}{时间(yyyyMMddmmHHssSSS)(17位)}{7位随机数}
//		qrCodeId = {来源编号(4位)}{时间(yyyyMMddmmHHssSSS)(17位)}{7位随机数}
		assert(msgSrcId.length()==4);
		return msgSrcId 
				+ DateUtils.datetimeFormat2.format(new Date())
				+ ValidateUtils.GetRandNum(1000000, 9999999);
	}
	
}

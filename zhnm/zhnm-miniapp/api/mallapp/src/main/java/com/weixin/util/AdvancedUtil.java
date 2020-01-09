package com.weixin.util;

import org.change.util.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * 高级接口工具类
 * 
 * @author liufeng
 * @date 2013-11-9
 */
public class AdvancedUtil {
	private static Logger log = LoggerFactory.getLogger(AdvancedUtil.class);


	
	/**
	 * 获取用户信息
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param openId
	 *            用户标识
	 * @return WeixinUserInfo
	 */
	public static PageData getUserInfo(String accessToken, String openId) {
		PageData pd = new PageData();
		// 拼接请求地址
		// String requestUrl =
		// "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
		String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 获取用户信息
		JSONObject jsonObject = Accesstoken.httpsRequest(requestUrl, "GET", null);
		log.info("获取用户信息>>>>>>>>>>>>>>>>>>>>>>>>");
		log.info(jsonObject.toString());
		
		try {
		
				// 用户的标识
				pd.put("openid",jsonObject.getString("openid"));
//				// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
//				weixinUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
//				// 用户关注时间
//				weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
				// 昵称
				pd.put("nickname",jsonObject.getString("nickname"));
				// 用户的性别（1是男性，2是女性，0是未知）
				pd.put("sex",jsonObject.getInt("sex"));
				// 用户所在国家
				pd.put("country",jsonObject.getString("country"));
				// 用户所在省份
				pd.put("province",jsonObject.getString("province"));
				// 用户所在城市
				pd.put("city",jsonObject.getString("city"));
				// 用户的语言，简体中文为zh_CN
				pd.put("language",jsonObject.getString("language"));
				// 用户头像
				pd.put("headimgurl",jsonObject.getString("headimgurl"));
				
			
		}catch(Exception e){
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
		}
	
		return pd;
	}
	
	
	
	
}

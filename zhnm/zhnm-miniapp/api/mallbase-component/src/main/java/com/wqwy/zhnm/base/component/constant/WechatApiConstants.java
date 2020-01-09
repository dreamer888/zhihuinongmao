package com.wqwy.zhnm.base.component.constant;

import com.wqwy.zhnm.base.component.utils.PropertyUtil;

public class WechatApiConstants {

	/*
	 *  wechat pay
	 */
	// 微信支付分配的公众账号ID（企业号corpid即为此appId）
	public static final String PUBLIC_COUNT_ID = PropertyUtil.getProperty("wechat.public_count_id");
	// 微信支付分配的商户号
	public static final String MCH_ID = PropertyUtil.getProperty("wechat.mch_id");
	// sign key
	public static final String WECHAT_APPID = PropertyUtil.getProperty("wechat.appid");
	public static final String WECHAT_APPSECRET = PropertyUtil.getProperty("wechat.appsecret");
	public static final String SIGN_KEY = PropertyUtil.getProperty("wechat.sign_key");
	public static final String WECHAT_NOTIFYURL = PropertyUtil.getProperty("wechat.notify_url");
	public static final String WECHAT_NOTIFYURL_REFUND = PropertyUtil.getProperty("wechat.notify_url_refund");
	
	public static final String WECHAT_REDIRECT_PREFIX = PropertyUtil.getProperty("wechat.redirect_prefix");
	
}

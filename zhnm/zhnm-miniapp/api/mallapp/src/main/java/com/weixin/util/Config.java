package com.weixin.util;

import org.change.controller.base.BaseController;
import org.change.util.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.weixin.service.config.impl.ConfigService;

public class Config  {
	private static final Logger logger = LoggerFactory.getLogger(Config.class);

	public static PageData getconfig() {
		PageData pd = new PageData();
		try {
			BaseController bc = new BaseController();
			if (bc.getApp().getAttribute("config") == null) {
				WebApplicationContext webctx = ContextLoader.getCurrentWebApplicationContext();
				ConfigService configService = (ConfigService) webctx.getBean("configService");
				pd.put("config_id", "2");
				pd = configService.findById(pd);
				bc.getApp().setAttribute("config",pd);
			}else{
				pd  = (PageData) bc.getApp().getAttribute("config");
			}

		} catch (Exception e) {
			logger.info("获取config失败--->" + e.getMessage());

		}
		return pd;
	}
	// public static void update_access_token(PageData pd) {
	// try {
	// WebApplicationContext
	// webctx=ContextLoader.getCurrentWebApplicationContext();
	// ConfigService configService =
	// (ConfigService)webctx.getBean("configService");
	// pd.put("config_id", "1");
	// configService.edit(pd);
	// } catch (Exception e) {
	// log.info("更新access_token失败--->"+e.getMessage());
	// }
	// }

	static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";// 创建菜单
	static String token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code"; // 网页授权获取用户信息接口
	static String token_url2 = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";// 全局accesstoken接口
	static String template_id_1 = "C6YRjqsvDLYFuVQbVHfAWKWPbXD8Ca_lSwiXG8cQQNY"; // 订单支付成功信息推送模板
	static String template_id_2 = "tjqPjlrB1vbXatR7_HhEefzjG1UNbacVTotD85J_ZR8	"; // 商品已发出通知

}

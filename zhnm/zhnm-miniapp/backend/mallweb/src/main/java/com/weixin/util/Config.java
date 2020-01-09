package com.weixin.util;


import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import org.change.util.PageData;
import com.weixin.service.config.ConfigManager;
import com.weixin.service.config.impl.ConfigService;

public class Config {
	private static Logger log = Logger.getLogger(Config.class);
	private static AbstractApplicationContext ctx;
	
	public static PageData getconfig() {
		PageData pd = new PageData();
		try {
//			ctx = new ClassPathXmlApplicationContext(
//					new String[] { "classpath:spring/ApplicationContext.xml"});
//			ConfigManager configService = (ConfigManager) ctx.getBean("configService");
			WebApplicationContext webctx=ContextLoader.getCurrentWebApplicationContext();
			ConfigService configService = (ConfigService)webctx.getBean("configService");
			pd.put("config_id", "1");
			pd = configService.findById(pd);
		} catch (Exception e) {
			log.info("获取config失败--->"+e.getMessage());
			
		}
		return pd;
	}
//	public static void update_access_token(PageData pd) {
//		try {
//			WebApplicationContext webctx=ContextLoader.getCurrentWebApplicationContext();
//			ConfigService configService = (ConfigService)webctx.getBean("configService");
//			pd.put("config_id", "1");
//			configService.edit(pd);
//		} catch (Exception e) {
//			log.info("更新access_token失败--->"+e.getMessage());
//		}
//	}
	
	static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";// 创建菜单
	static String token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code"; // 网页授权获取用户信息接口
	static String token_url2 = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";// 全局accesstoken接口
	static String template_id_1 = "C6YRjqsvDLYFuVQbVHfAWKWPbXD8Ca_lSwiXG8cQQNY"; // 订单支付成功信息推送模板
	static String template_id_2 = "tjqPjlrB1vbXatR7_HhEefzjG1UNbacVTotD85J_ZR8	"; // 商品已发出通知
	
}

////package com.weixin.util;
////
////import java.util.List;
////import java.util.Map;
////
////
////
////
////
////
////import net.sf.json.JSONObject;
////
////import org.apache.log4j.Logger;
////
////import com.google.gson.Gson;
////import com.weixin.entity.Button;
////import com.weixin.entity.ComplexButton;
////import com.weixin.entity.Menu;
////import com.weixin.entity.Token;
////import com.weixin.entity.ViewButton;
////
////public class ButtonUtil {
////	private static Logger log = Logger.getLogger(ButtonUtil.class);
////	
////	public static Menu getMenu(Map<String,Object> map) {
////		String jsonMenu = JSONObject.fromObject(map).toString();
////		log.info("map-jsonStr="+jsonMenu);
////		
////		menu.setButton(cb);//性创建三个主菜单 及其子菜单
////		
//////		ComplexButton mainBtn = new ComplexButton();//一级主菜单
//////		mainBtn.setName("我的商城");
//////		
//////		mainBtn.setSub_button(new Button[] {btn});
////		
////		return menu;
////	}
////	public Menu cMenu(){
////		
////		
////		Menu menu = new Menu();
//////		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });//一次性创建三个主菜单 及其子菜单
////		return menu;
////	}
//////	public static void main(String[] args) {
////////	public static void cMenu(Map<String,Object> map) {//可以直接在本地创建菜单  到 公众平台里面
//////		// 第三方用户唯一凭证
//////		String appId = "wxed2eb85e7b84ad3c";//appid
//////		// 第三方用户唯一凭证密钥
//////		String appSecret = "6363ca5d21ac55df1f6abe91d8065e37";//app秘钥
//////		
//////		// 调用接口获取凭证
//////		CommonUtil commonUtil = new CommonUtil();
//////		Token token = commonUtil.getToken(appId, appSecret);
//////
//////		if (null != token) {
//////			// 创建菜单
//////			boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
//////
//////			// 判断菜单创建结果
//////			if (result){
//////				log.info("菜单创建成功！");
//////				System.out.println("菜单创建成功！");
//////			}else{
//////				log.info("菜单创建失败！");
//////				System.out.println("菜单创建失败！");
//////			}
//////		}
//////	}
//	public static void cMenu(Map<String,Object> map) {//可以直接在本地创建菜单  到 公众平台里面
//		// 第三方用户唯一凭证
//		String appId = "wxed2eb85e7b84ad3c";//appid
//		// 第三方用户唯一凭证密钥
//		String appSecret = "6363ca5d21ac55df1f6abe91d8065e37";//app秘钥
//		
//		// 调用接口获取凭证
//		CommonUtil commonUtil = new CommonUtil();
//		Token token = commonUtil.getToken(appId, appSecret);
//
//		if (null != token) {
//			// 创建菜单
//			boolean result = MenuUtil.createMenu(getMenu(map), token.getAccessToken());
//			log.info("result="+result);
//			// 判断菜单创建结果
//			if (result){
//				log.info("菜单创建成功！");
//			}else{
//				log.info("菜单创建失败！");
//			}
//		}
//	}
//}

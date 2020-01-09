package com.weixin.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * �Զ���˵�������
 * 
 * @author liufeng
 * @date 2013-10-17
 */
public class MenuUtil{
	private static Logger log = LoggerFactory.getLogger(MenuUtil.class);

//	// �˵�������POST��
	public  static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
//	// �˵���ѯ��GET��
//	public final static String menu_get_url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
//	// �˵�ɾ����GET��
//	public final static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	// 调用接口获取凭证
	public static  Map<String,Object>  createMenu(Map<String,Object> map) throws Exception {
		boolean result = false;
		
		String url = menu_create_url.replace("ACCESS_TOKEN", Accesstoken.getaccesstoken());
		System.err.println("url="+url);
		String jsonMenu = JSONObject.fromObject(map).toString();
		log.info("生成需传给微信的菜单jsonStr="+jsonMenu);
		JSONObject jsonObject = Accesstoken.httpsRequest(url, "POST", jsonMenu);
		log.info("jsonObject="+jsonObject);
		String msg = "";
		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			
			if (0 == errorCode) {
				result = true;
				msg = "生成菜单成功!";
			} else {
				result = false;
				msg = "生成菜单失败，错误信息 is errcode:{} errmsg:{}"+ errorCode+ errorMsg;
			}
		}
		Map<String,Object> rsMap = new HashMap<String, Object>();
		rsMap.put("result", result);
		rsMap.put("message", msg);
		return rsMap;
	}

//	/**
//	 * ��ѯ�˵�
//	 * 
//	 * @param accessToken ƾ֤
//	 * @return
//	 */
//	public static String getMenu(String accessToken) {
//		String result = null;
//		String requestUrl = menu_get_url.replace("ACCESS_TOKEN", accessToken);
//		// ����GET�����ѯ�˵�
//		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
//
//		if (null != jsonObject) {
//			result = jsonObject.toString();
//		}
//		return result;
//	}
//
//	/**
//	 * ɾ���˵�
//	 * 
//	 * @param accessToken ƾ֤
//	 * @return true�ɹ� falseʧ��
//	 */
//	public static boolean deleteMenu(String accessToken) {
//		boolean result = false;
//		String requestUrl = menu_delete_url.replace("ACCESS_TOKEN", accessToken);
//		// ����GET����ɾ���˵�
//		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
//
//		if (null != jsonObject) {
//			int errorCode = jsonObject.getInt("errcode");
//			String errorMsg = jsonObject.getString("errmsg");
//			if (0 == errorCode) {
//				result = true;
//			} else {
//				result = false;
//				log.error("ɾ���˵�ʧ�� errcode:{} errmsg:{}", errorCode, errorMsg);
//				System.out.println("--------------------------�˵�ɾ��ʧ������----------------------");
//			}
//		}
//		return result;
//	}
}
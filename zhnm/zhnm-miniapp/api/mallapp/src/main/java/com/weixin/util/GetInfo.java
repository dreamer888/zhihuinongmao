package com.weixin.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.change.util.PageData;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wqwy.zhnm.base.component.constant.WechatApiConstants;
import com.yq.util.AesCbcUtil;

import net.sf.json.JSONObject;

public class GetInfo {
	// @Autowired
	// private static UserInfoService userInfoService = new UserInfoService();
	private static final Logger logger = LoggerFactory.getLogger(GetInfo.class);

	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request) {
		try {
			// 将解析结果存储在HashMap中
			Map<String, String> map = new HashMap<String, String>();

			// 从request中取得输入流
			InputStream inputStream = request.getInputStream();
			// 读取输入流
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputStream);
			// 得到xml根元素
			Element root = document.getRootElement();
			// 得到根元素的所有子节点
			List<Element> elementList = root.elements();

			// 遍历所有子节点
			for (Element e : elementList)
				map.put(e.getName(), e.getText());

			// 释放资源
			inputStream.close();
			inputStream = null;
			return map;
		} catch (Exception e) {
			return null;
		}
	}

	public static PageData baseInfo(PageData pd, HttpServletRequest request) {
		String openid = "";
		String code = "";
		// String unionid = "";
		String access_token = "";
		PageData config = Config.getconfig();
		code = pd.getString("code");// 获取code值
		logger.info("通过确认授权获取信息>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		logger.info(pd.toString());
		if (code != null) {
			String token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WechatApiConstants.PUBLIC_COUNT_ID
					+ "&secret=" + WechatApiConstants.WECHAT_APPSECRET + "&code=" + code + "&grant_type=authorization_code";
			// 获取用户的openid
			JSONObject json = new JSONObject();
			// CommonUtil commonUtil=new CommonUtil();
			json = Accesstoken.httpsRequest(token_url, "GET", null);
			logger.info("通过code获取信息>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			logger.info(json.toString());
			if (json != null) {
				openid = json.getString("openid");
				access_token = json.getString("access_token");
				// unionid = json.getString("unionid");
			}
		}
		pd.put("openid", openid);
		// pd.put("unionid", unionid);
		pd.put("access_token", access_token);
		logger.info("code==" + code);
		logger.info("WXUTIL 96 --oppen_id==" + openid);
		return pd;
	}

	public static PageData userInfo(PageData pd, HttpServletRequest request) {
		PageData userInfo = new PageData();
		String iv = pd.getString("iv");
		String session_key = pd.getString("session_key");
		String encryptedData = pd.getString("encryptedData");
		try {
			String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
			System.err.println(result);
			if (null != result && result.length() > 0) {
				JSONObject userInfoJSON = JSONObject.fromObject(result);
				userInfo.put("openId", userInfoJSON.get("openId"));
				userInfo.put("nickName", userInfoJSON.get("nickName"));
				userInfo.put("gender", userInfoJSON.get("gender"));
				userInfo.put("city", userInfoJSON.get("city"));
				userInfo.put("province", userInfoJSON.get("province"));
				userInfo.put("country", userInfoJSON.get("country"));
				userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
				// userInfo.put("unionId", userInfoJSON.get("unionId"));
			}

		} catch (Exception e) {
			e.getStackTrace();
			logger.info("--------------------");
			logger.info("获取用户信息出错 ---> " + e.getMessage());
			userInfo =null;
		}
		return userInfo;

	}

}

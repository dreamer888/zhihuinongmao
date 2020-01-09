package com.weixin.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.change.util.PageData;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.weixin.service.accesstoken.AccesstokenManager;
import com.wqwy.zhnm.base.component.constant.WechatApiConstants;

import net.sf.json.JSONObject;

public class Accesstoken {
//	private static final Logger logger = LoggerFactory.getLogger(Accesstoken.class);
	
	public static String getaccesstoken() throws Exception {
		PageData pd = new PageData();
		Long nowtime =new Date().getTime();
		
		WebApplicationContext webctx=ContextLoader.getCurrentWebApplicationContext();
		AccesstokenManager accesstokenService  = (AccesstokenManager)webctx.getBean("accesstokenService");
		String accesstoken = "";
		pd.put("accesstoken_id", "1");
		PageData  token  =  accesstokenService.findById(pd);;
		Long add_time = Long.parseLong(token.get("add_time")+"");
	//	Token token = new Token();
	//如果数据库保存得时间加上7200秒（2小时）<=当前时间，说明token已经过期，需重新获取，并更新到数据库
		if(add_time+(7200*1000) <= nowtime){ 
//		PageData config = Config.getconfig();
		String token_url = Config.token_url2.replace("APPID",WechatApiConstants.WECHAT_APPID).replace("APPSECRET",WechatApiConstants.WECHAT_APPSECRET);
		JSONObject jsonObject = httpsRequest(token_url, "GET", null);
//		log.info("jsonObject=="+jsonObject);
			try {
				accesstoken = jsonObject.getString("access_token");
				token.put( "accesstoken",accesstoken);
				token.put("accesstoken_id", 1);
				token.put("add_time", nowtime);
				accesstokenService.edit(token);
				//System.out.println(jsonObject.getString("access_token"));
			} catch (Exception e) {
				// 获取token失败
//				log.info("获取token失败 errcode:{} errmsg:{}"+ jsonObject.getInt("errcode")+" - " +jsonObject.getString("errmsg"));
			}
		
		}else{
			accesstoken = token.getString("access_token");
			
		}
		return accesstoken;
	}
	/**
	 * 发送https请求
	 * 
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr 提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			//BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
//			log.error("连接超时：{}", ce);
		} catch (Exception e) {
//			log.info("请求微信 异常------ "+e.getMessage());
//			log.error("https请求异常：{}", e);
		}
		return jsonObject;
	}
	
}

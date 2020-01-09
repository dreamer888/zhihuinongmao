package com.weixin.util;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.change.controller.base.BaseController;
import org.change.util.MD5;
import org.change.util.PageData;
import org.change.util.UuidUtil;

import com.google.gson.Gson;
import com.yq.util.DatetimeUtil;

public class Refund {
	private static Gson gson = new Gson();
	/**
	 * 微信公众号申请退款
	 * 
	 * @param orderId
	 *            订单id
	 * @param total_fee
	 *            退款金额
	 * @param refund_fee
	 *            退款金额
	 * @param response
	 * @return
	 * @throws KeyStoreException 
	 * @throws Exception
	 */
	// public String refund(HttpServletRequest request,HttpServletResponse
	// response) throws Exception{
	// PageData pd = new PageData();
	// /*--------1.初始化数据参数----------*/
	// String appId= "wxfd7c065eee11112222";
	// String secret= "b5b3a627f5d1f8888888888888";
	// String shh= "111111111";
	// String key= "mmmmmmmmmmmmmmm";
	// String filePath = "E:\\apiclient_cert.p12"; //退款需要提供证书数据，所以需要根据证书路径读取证书
	// //需要退款的商户订单号，对应提交订单中的out_trade_no
	// String orderId = request.getParameter("orderId").toString();
	// String total_fee=""; //也可以根据业务场景从数据库中获取总金额和退款金额
	// String refund_fee= ""; //
	// Map<String,String> result = (Map<String, String>)
	// wxRefund(request,response,appId,secret,shh,key,orderId,total_fee,refund_fee,filePath);
	//
	// /*
	// 根据result的返回状态，处理你的业务逻辑
	// .....
	// */
	// return "";
	// }
	private static Logger log = Logger.getLogger(Refund.class);
	//@SuppressWarnings("deprecation")
	public static PageData refund(PageData pd, HttpServletRequest request, HttpServletResponse response) throws Exception {
		PageData config = Config.getconfig();
		String appid = config.getString("appid");
		String appsecret = config.getString("appsecret");
		String partner = config.getString("partner");
		String partnerkey = config.getString("partnerkey");
		String path = config.getString("path");

		String order_id = pd.getString("order_id");
		String refund_id = DatetimeUtil.getDatetimemslong() ;//pd.getString("refund_id");
		BigDecimal order_total = (BigDecimal) pd.get("order_total");
		BigDecimal refund_price = (BigDecimal) pd.get("refund_price");
		String total_fee  = (order_total.multiply(new BigDecimal(100))).intValue()+"";
		String refund_fee = (refund_price.multiply(new BigDecimal(100))).intValue()+"";


		PageData data = new PageData();
		String currTime = TenpayUtil.getCurrTime();
		// 8位日期
		String strTime = currTime.substring(8, currTime.length());
		// 四位随机数
		String strRandom = TenpayUtil.buildRandom(4) + "";
		// 10位序列号,可以自行调整。
		String nonce_str = strTime + strRandom;

		/*-----  1.生成预支付订单需要的的package数据-----*/
		SortedMap<String, Object> packageParams = new TreeMap<String, Object>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", partner);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("op_user_id", partner);
		packageParams.put("out_trade_no", order_id);
		packageParams.put("out_refund_no", refund_id);
		packageParams.put("total_fee", total_fee);
		packageParams.put("refund_fee", refund_fee);
		/*----2.根据package生成签名sign---- */
		RequestHandler reqHandler = new RequestHandler(request, response);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign = reqHandler.createSign(packageParams);

		/*----3.拼装需要提交到微信的数据xml---- */
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>" + partner + "</mch_id>" + "<nonce_str>"
				+ nonce_str + "</nonce_str>" + "<op_user_id>" + partner + "</op_user_id>" + "<out_trade_no>" + order_id
				+ "</out_trade_no>" + "<out_refund_no>" + refund_id + "</out_refund_no>" + "<refund_fee>" + refund_fee
				+ "</refund_fee>" + "<total_fee>" + total_fee + "</total_fee>" + "<sign>" + sign + "</sign>"
				+ "</xml>";
//		try {
			/*----4.读取证书文件,这一段是直接从微信支付平台提供的demo中copy的，所以一般不需要修改---- */
		
			
		
		
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(new File(path));
			try {
				keyStore.load(instream, partner.toCharArray());
			} finally {
				instream.close();
			}
			// Trust own CA and all self-signed certs
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, partner.toCharArray()).build();
			// Allow TLSv1 protocol only
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

			/*----5.发送数据到微信的退款接口---- */
			String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
			
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(new StringEntity(xml, "UTF-8"));
			HttpResponse weixinResponse = httpClient.execute(httppost);
			String jsonStr = EntityUtils.toString(weixinResponse.getEntity(), "UTF-8");
			log.info("weixin_tuikuan - > " + jsonStr);
			Map map = XmlUtil.xml2Map(jsonStr);
//			Map map = GetWxOrderno.doXMLParse(jsonStr);
			log.info("map - > " + gson.toJson(map));
			log.info("Map.get(return_code) - > " + map.get("return_code"));
			if ("SUCCESS".equalsIgnoreCase((String) map.get("return_code"))) {
				if("SUCCESS".equalsIgnoreCase((String) map.get("result_code"))){
					data.put("result", 1);
					data.put("message", "退款成功");
				}else {
					data.put("result", 0);
					data.put("message",  map.get("err_code_des"));
				}
				
			} else {
				data.put("result", 0);
				data.put("message", "退款失败");
			}
//		} catch (Exception e) {
//			e.getStackTrace();
//			data.put("result", 0);
//			data.put("message", "退款失败");
//		}
		return data;

	}
	public static void main(String[] args) {
		PageData pd = new PageData();
		
		BigDecimal pay_total = new BigDecimal("0.01");
		pd.put("pay_total", pay_total);
		BigDecimal a = (BigDecimal)pd.get("pay_total");
		String total_fee  = (a.multiply(new BigDecimal(100))).intValue()+"";
		
		System.err.println(total_fee);
	}
}

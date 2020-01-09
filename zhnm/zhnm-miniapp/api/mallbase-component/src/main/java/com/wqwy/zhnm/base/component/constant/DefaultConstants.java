
package com.wqwy.zhnm.base.component.constant;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.wqwy.zhnm.base.entity.ThirdPartNotify;
import com.wqwy.zhnm.base.entity.ThirdPartNotify.PayEnum;

public class DefaultConstants {

	public static final String CURRENT_USER = "current_user";
	public static final String TOKEN = "token";
	
	public static final String ROLE = "role";
	
	public static final String BalanceQueuePrefix = "balanceQ";
	public static final String BalanceRoutingKeyPrefix = "balanceRK";
	
	public static final String SellerQueuePrefix = "sellerQ";
	public static final String SellerRoutingKeyPrefix = "sellerRK";
	
	public static final String DelivererQueuePrefix = "delivererQ";
	public static final String DelivererRoutingKeyPrefix = "delivererRK";
	
	public static final Integer ZERO_INTEGER = 0;
	
	public static final Integer BIGDECIMAL_SHOW_DIGIT = 2;
	
	public static final Long VALIDATE_CODE_VALID_TIME = 3*60*1000L;
	
	public static final Long BANK_VALIDATE_CODE_VALID_TIME = 1*60*1000L;
	
	public static final String JOB_DETAIL_ONLINE_SHOPORDER_ID = "shopOrderId";
	
	public static final String JOB_UNPREPARE_MSG_TYPE = "unPrepareMsgType";
	
	public static final String SUCCESS = "SUCCESS";
	public static final String FAIL = "FAIL";
	
	public static final String TELEPHONE = "0755-23719069";
	public static final String COMPANY = "深圳市万擎伟业通信服务有限公司";
	
	public static final String PRINTORDERURL = "http://www.wqwy2014.com/mallweb/print/printOrder.jsp?order_id=";
	public static final String BALANCEPRINTORDERURL = "http://www.wqwy2014.com/mallweb/print/printOfflineOrder.jsp?order_id=";
	
//	public static final String PRINTORDERURL = "http://192.168.1.233/mallweb/print/printOrder.jsp?order_id=";
//	public static final String BALANCEPRINTORDERURL = "http://192.168.1.233/mallweb/print/printOfflineOrder.jsp?order_id=";
	
	public static final String CCB_BANK_PAY_URL = "https://ibsbjstar.ccb.com.cn/CCBIS/ccbMain";
	
	public static final String  WQWY_IMG_SERVER= "http://img.wqwy2014.com/seller/";
	
	public static enum WechatResponseEnum {
		SUCCESS, FAIL
	}
	
	/**
	 * 
	 * @ClassName: OrderTypeEnum  
	 * @Description: 订单类型  
	 * @author seven  
	 * @date 31 May 2018 1:41:59 PM  
	 *
	 */
	public static enum OrderTypeEnum {
		OFFLINE, ONLINE
	}
	
	public static enum BalanceEnum {
		// 是否使用：0.false 未使用 1.true 使用
		NOT_USED(false),
		USED(true);
		private boolean balanceEnum;
		BalanceEnum(boolean balanceEnum){
			this.balanceEnum = balanceEnum;
		}
		public boolean getBalanceEnum() {
			return balanceEnum;
		}
	}
	
	/**
	 * 
	 * @ClassName: ThirdPartPayNotifyEnum  
	 * @Description: 第三方支付notify  
	 * @author seven  
	 * @date 31 May 2018 5:14:53 PM  
	 *
	 */
	public static enum ThirdPartPayNotifyEnum {
		
		STATUS_CREATED(1),
		STATUS_SUCCESS(3),
		STATUS_FAIL(5);
		
		private Integer thirdPartPayNotifyEnum;
		ThirdPartPayNotifyEnum(Integer thirdPartPayNotifyEnum){
			this.thirdPartPayNotifyEnum = thirdPartPayNotifyEnum;
		}
		public Integer getThirdPartPayNotifyEnum() {
			return thirdPartPayNotifyEnum;
		}
	}

	/**
	 * 
	 * @ClassName: HelpAndFeedbackEnum  
	 * @Description: 帮助&反馈 enum  
	 * @author seven  
	 * @date 23 May 2018 2:03:21 PM  
	 *
	 */
	public static enum HelpAndFeedbackEnum {
		
		OBJECT_TYPE_USER(1),
		OBJECT_TYPE_SELLER(2),
		OBJECT_TYPE_DELIVERER(3);
		
		private Integer helpAndFeedbackEnum;
		HelpAndFeedbackEnum(Integer helpAndFeedbackEnum){
			this.helpAndFeedbackEnum = helpAndFeedbackEnum;
		}
		public Integer getHelpAndFeedbackEnum() {
			return helpAndFeedbackEnum;
		}
	}
	
	/**
	 * 
	 * @ClassName: LoginEnum  
	 * @Description: 登录相关enum  
	 * @author seven  
	 * @date 14 May 2018 12:08:26 PM  
	 *
	 */
	public static enum LoginEnum {
		/*
		 * 角色: 0.称 1.商户
		 * 2.配送 3.用户
		 */
		ROLE_BALANCE(0),
		ROLE_SELLER(1);
		private Integer loginEnum;
		LoginEnum(Integer loginEnum){
			this.loginEnum = loginEnum;
		}
		public Integer getLoginEnum() {
			return loginEnum;
		}
	}
	
	/**
	 * 
	 * @ClassName: SellerGoodsEnum  
	 * @Description: 商户商品enum  
	 * @author seven  
	 * @date 24 May 2018 10:19:42 AM  
	 *
	 */
	public static enum SellerGoodsEnum {
		/*
		 * 商户商品状态
		 * 状态：0上架，1下架
		 */
		ON_SALE(0),
		NOT_ON_SALE(1);
		private Integer sellerGoodsEnum;
		SellerGoodsEnum(Integer sellerGoodsEnum){
			this.sellerGoodsEnum = sellerGoodsEnum;
		}
		public Integer getSellerGoodsEnum() {
			return sellerGoodsEnum;
		}
	}
	
	/**
	 * 
	 * @ClassName: BalanceOfflineOrderEnum  
	 * @Description: 线下订单相关Enum  
	 * @author seven  
	 * @date 14 May 2018 11:19:06 AM  
	 *
	 */
	public static enum BalanceOfflineOrderEnum {
		
		/*
		 * 支付方式:1支付宝 2微信 3现金 4建行聚合支付5建行静态二维码
		 */
		PAY_WAY_ALIPAY(1),
		PAY_WAY_WECHATPAY(2),
		PAY_WAY_CASH(3),
		PAY_WAY_CCB_DRAGON(4),
		PAY_WAY_CCB_STATIC(5),
		
		/*
		 * 状态: 0未支付，5交易成功,待评价，6评价完成
		 */
		BALANCEOFFLINEORDER_NOT_PAY(0),
		BALANCEOFFLINEORDER_PAYED_WAIT_EVALUATE(5),
		BALANCEOFFLINEORDER_EVALUATED(6);
		
		private Integer balanceOfflineOrderEnum;
		
		BalanceOfflineOrderEnum(Integer balanceOfflineOrderEnum){
			this.balanceOfflineOrderEnum = balanceOfflineOrderEnum;
		}
		
		public Integer getBalanceOfflineOrderEnum() {
			return balanceOfflineOrderEnum;
		}
	}
	
	/**
	 * 
	 * @ClassName: ShopOrderEnum  
	 * @Description: 线上订单相关Enum  
	 * @author seven  
	 * @date 18 May 2018 3:18:00 PM  
	 *
	 */
	public static enum ShopOrderEnum {
		/*
		 * original:
		 * 状态,0未支付，1已支付，2已发货，3待退款，4退款成功，5交易成功,待评价，6评价完成, 
		 * 
		 * new:
		 * 11待接单->1
//		 * 13已接单->15
		 * 15待备货
		 * 17待取货
		 * 19配送中
		 * 21已送达
		 * (23待用户确认)
		 * 25已完成
		 * 27已取消
		 * 29商户已抢单,seller_id不为空
		 * 37订单超时未接单 系统自动取消
		 */
		SHOPORDER_NOT_PAY(0),
		SHOPORDER_PAYED(1),
		SHOPORDER_PAYED_WAIT_EVALUATE(5),
		SHOPORDER_EVALUATED(6),
		
		SHOPORDER_PAYED_NEED_ACCEPT_ORDER(11),
		SHOPORDER_WAIT_SELLER_PREPARE_GOODS(15),
		SHOPORDER_WAIT_DELIVERER_RECEIVE_GOODS(17),
		SHOPORDER_SHIPPING(19),
		SHOPORDER_SHIPPED(21),
		SHOPORDER_FINISHED(25),
		SHOPORDER_SELLER_PREEMPTED(29),
		SHOPORDER_AUTOMATIC_CANCEL(37);
		
		private Integer shopOrderEnum;
		
		ShopOrderEnum(Integer shopOrderEnum){
			this.shopOrderEnum = shopOrderEnum;
		}
		
		public Integer getShopOrderEnum() {
			return shopOrderEnum;
		}
	}
	
	/**
	 * 
	 * @ClassName: DelivererEnum  
	 * @Description: 配送人员enum  
	 * @author seven  
	 * @date 30 May 2018 3:21:48 PM  
	 *
	 */
	public static enum DelivererEnum {
		
		STATUS_NOMAL(0),
		STATUS_FREEZED(1),
		STATUS_CLOSED(2);
		
		private Integer delivererEnum;
		DelivererEnum(Integer delivererEnum){
			this.delivererEnum = delivererEnum;
		}
		public Integer getDelivererEnum() {
			return delivererEnum;
		}
	}
	
	/**
	 * 队列分隔符
	 * 
	 * routingkey分隔符
	 * 
	 * 1.称扫码登录队列内消息时效
	 * 30s
	 * 
	 * 2.用户下单通知商户消息时效
	 * 30s
	 * 
	 * 3.配送人员消息暂不设置时效(暂时不存在配送人员抢单)
	 */
	/*
	 * https://www.rabbitmq.com/ttl.html
	 */
	public static final String QueueSpliter = "-";
	public static final String RoutingKeySpliter = ".";
	public static final Map<String, Object> BalanceQRLoginArgsMap;
	public static final Map<String, Object> SellerPreemptArgsMap;
	static {
		Map<String, Object> tempMap1 = new HashMap<String, Object>();
		tempMap1.put("x-message-ttl", 300000);
		BalanceQRLoginArgsMap = Collections.unmodifiableMap(tempMap1);
		Map<String, Object> tempMap2 = new HashMap<String, Object>();
		tempMap2.put("x-message-ttl", 300000);
		SellerPreemptArgsMap = Collections.unmodifiableMap(tempMap2);
	}
	
	public enum RoleName {
		USER, BALANCE, SELLER, DELIVERER
	}
	
	/**
	 * 称按键map
	 * key 称上按键数字
	 * value 商户商品出现个数
	 * (e.g.: key="A" value=1  ->  A键出现一次 最高一次 0代表没使用)
	 */
	public static final Map<String, Integer> BalanceSellerGoodsHotkeyMap;
	static {
		Map<String, Integer> tempMap1 = new HashMap<String, Integer>();
		tempMap1.put("A", 0);tempMap1.put("B", 0);tempMap1.put("C", 0);tempMap1.put("D", 0);tempMap1.put("E", 0);
		tempMap1.put("F", 0);tempMap1.put("G", 0);tempMap1.put("H", 0);tempMap1.put("I", 0);tempMap1.put("J", 0);
		tempMap1.put("K", 0);tempMap1.put("L", 0);tempMap1.put("M", 0);tempMap1.put("N", 0);tempMap1.put("O", 0);
		BalanceSellerGoodsHotkeyMap = Collections.unmodifiableMap(tempMap1);
	}
	
	public static final Map<BalanceOfflineOrderEnum, ThirdPartNotify.PayEnum> BalanceOfflinePayMap;
	static {
		Map<BalanceOfflineOrderEnum, ThirdPartNotify.PayEnum> tempMap1 = new HashMap<BalanceOfflineOrderEnum, ThirdPartNotify.PayEnum>();
		tempMap1.put(BalanceOfflineOrderEnum.PAY_WAY_ALIPAY, PayEnum.ALIPAY);
		tempMap1.put(BalanceOfflineOrderEnum.PAY_WAY_WECHATPAY, PayEnum.WECHAT);
		BalanceOfflinePayMap = Collections.unmodifiableMap(tempMap1);
	}
	
	public static final Map<WechatResponseEnum, String> WechatResponseXmlMap;
	static {
		String WechatSuccessResponseXmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" + 
				"<xml>\n" + 
				"<return_msg>OK</return_msg>\n" + 
				"<return_code>SUCCESS</return_code>\n" + 
				"</xml>\n";
		String WechatFailResponseXmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" + 
				"<xml>\n" + 
				"<return_msg>FAIL</return_msg>\n" + 
				"<return_code>FAIL</return_code>\n" + 
				"</xml>\n";
		Map<WechatResponseEnum, String> tempMap1 = new HashMap<WechatResponseEnum, String>();
		tempMap1.put(WechatResponseEnum.SUCCESS, WechatSuccessResponseXmlString);
		tempMap1.put(WechatResponseEnum.FAIL, WechatFailResponseXmlString);
		WechatResponseXmlMap = Collections.unmodifiableMap(tempMap1);
	}
	
	
//	static {
//		Map<String, String> tempMap1 = new HashMap<String, String>();
//		tempMap1.put("return_code", "SUCCESS");
//		tempMap1.put("return_msg", "OK");
//	}
	public static final String MiniAppLoginRedirectStr = "{\"result\":1005,\"message\":\"尚未登录，跳转中...\"}";
	
}

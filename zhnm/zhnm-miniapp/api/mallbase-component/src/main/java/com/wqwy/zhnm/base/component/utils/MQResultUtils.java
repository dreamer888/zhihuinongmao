package com.wqwy.zhnm.base.component.utils;

public class MQResultUtils {
	
	public static final Integer SELLER_BALANCE_LOGIN = 30200;
	public static final String SELLER_BALANCE_LOGIN_MSG = "商户扫码登录称";
	
	public static final Integer MQ_PREEMPT_SHOP_ORDER_GOODS = 30300;
	public static final String MQ_PREEMPT_SHOP_ORDER_GOODS_MSG = "您有一条新的订单";
	
	public static final Integer MQ_PREPARE_SHOP_ORDER_GOODS = 30301;
	public static final String MQ_PREPARE_SHOP_ORDER_GOODS_MSG = "您有待备货订单";

	public static final Integer MQ_DELIVERY_SHOP_ORDER = 30305;
	public static final String MQ_DELIVERY_SHOP_ORDER_MSG = "您有一条待配送订单";
	
	public static final Integer MQ_OFFLINE_ORDER_NOTIFY_RESULT_TO_BALANCE = 30309;
	//public static final String MQ_OFFLINE_ORDER_NOTIFY_RESULT_TO_BALANCE_MSG = "支付回调消息";
	public static final String MQ_OFFLINE_ORDER_NOTIFY_RESULT_TO_BALANCE_MSG = "建行收款";
	
	public static final Integer MQ_SHORTCUT_SELLER_GOODS = 30400;
	public static final String MQ_SHORTCUT_SELLER_GOODS_MSG = "商户商品详情(更新快捷键)";
	
	public static final Integer MQ_PRINT_ORDER_GOODS = 30401;
	public static final String MQ_PRINT_ORDER_GOODS_MSG = "打印订单信息(备货完成)";
	
	public static final Integer MQ_UPDATE_SELLER_GOODS = 30402;
	public static final String MQ_UPDATE_SELLER_GOODS_MSG = "商户编辑商品";
	
	public static final String MQ_TEN_UN_PREPARE_GOODS_MSG = "您有订单需及时备货";
	public static final String MQ_TWENTY_UN_PREPARE_GOODS_MSG = "您有订单需马上备货，10分钟内未备货将启动人工售后服务";
	
	
}

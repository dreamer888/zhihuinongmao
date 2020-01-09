package com.wqwy.zhnm.base.component.utils;

public class ResultUtils {
//	public static final String data = "data";
//	public static final String code = "code";
//	public static final String msg = "message";
	
	public static final Integer AUTHORIZATION_FAIL = 10401;
	public static final String AUTHORIZATION_FAIL_MSG = "登录已过期，请重新登录";
	
	public static final Integer DEFAULT_EXCEPTION_CODE = 10001;
	
	public static final Integer SUCCESS = 200;
	public static final String SUCCESS_MSG = "成功";
	
	public static final Integer FAIL = 201;
	public static final String FAIL_MSG = "失败";
	
//	public static final Integer fail = 201;
//	public static final String failMsg = "失败";
//	
//	public static final Integer noSupportBank = 499;
//	public static final String noSupportBankMsg = "不支持的银行";
//	
//	public static final Integer confirmBank = 497;
//	public static final String confirmBankMsg = "请填写正确银行卡信息"; 
	
	public static final Integer USER_ALREADY_EXIST = 10021;
	public static final String USER_ALREADY_EXIST_MSG = "用户已存在"; 
	
	public static final Integer NO_REGISTER_EXIST = 10022;
	public static final String NO_REGISTER_EXIST_MSG = "登录信息已过期"; 
	
//	public static final Integer userpwd = 23;
//	public static final String userpwdMsg = "密码不对";
//	
//	public static final Integer SHIPPINGACCOUNTLOCKED = 25;
//	public static final String SHIPPINGACCOUNTLOCKEDMSG = "配送账户被禁用,请联系管理员"; 
	
	public static final Integer ACCOUNT_NOT_EXIST = 10026;
	public static final String ACCOUNT_NOT_EXIST_MSG = "账户不存在"; 
	
	public static final Integer PASSWORD_WRONG = 10029;
	public static final String PASSWORD_WRONG_MSG = "密码错误"; 
	
	public static final Integer ACCOUNT_STATUS_EXCEPTION = 10033;
	public static final String ACCOUNT_STATUS_EXCEPTION_MSG = "账户异常,请联系管理员";
	
	public static final Integer NOT_SELF_ACCOUNT = 10089;
	public static final String NOT_SELF_ACCOUNT_MSG = "请输入当前账户绑定手机号码";
	
	public static final Integer NO_VERIFYCODE_AVALIABLE = 10090;
	public static final String NO_VERIFYCODE_AVALIABLE_MSG = "输入验证码有误";
	
	public static final Integer VERIFYCODE_TIME_OUT = 10091;
	public static final String VERIFYCODE_TIME_OUT_MSG = "验证码已过期,请重新获取";
	
	public static final Integer VERIFYCODE_FAIL = 10092;
	public static final String VERIFYCODE_FAIL_MSG = "验证码错误";
	
	public static final Integer BALANCE_ALREADY_BINDED_SELLER = 10327;
	public static final String BALANCE_ALREADY_BINDED_SELLER_MSG = "称已绑定其他的商户"; 
	
	public static final Integer BALANCE_IMEI_WRONG = 10328;
	public static final String BALANCE_IMEI_WRONG_MSG = "称IMEI号输入错误";
	
	public static final Integer SELLER_ALREADY_BINDED_BALANCE = 10329;
	public static final String SELLER_ALREADY_BINDED_BALANCE_MSG = "商户已绑定其他的称";
	
//	public static final Integer SHIPPINGASSETSOPERATIONFAIL = 27;
//	public static final String SHIPPINGASSETSOPERATIONFAILMSG = "资产操作失败,请重试"; 
//	
//	public static final Integer TASKFINISHEDOREXCEPTION = 28;
//	public static final String TASKFINISHEDOREXCEPTIONMSG = "任务不存在或已结束"; 
//	
//	public static final Integer BANKCARDALREADYEXISTS = 29;
//	public static final String BANKCARDALREADYEXISTSMSG = "卡号已存在"; 
//	
//	public static final Integer BALANCENOTENOUGH = 30;
//	public static final String BALANCENOTENOUGHMSG = "余额不足"; 
//	
//	public static final Integer VALIDATIONCODEVALIDATEFAIL = 31;
//	public static final String VALIDATIONCODEVALIDATEFAILMSG = "验证失败"; 
//	
//	public static final Integer BANKCARDNOTEXISTS = 32;
//	public static final String BANKCARDNOTEXISTSMSG = "银行卡不存在"; 
//	
//	public static final Integer SHIPPINGACCOUNTAUDITING = 33;
//	public static final String SHIPPINGACCOUNTAUDITINGMSG = "配送账户在审核中"; 
//	
//	public static final String SHIPPING_LONGTITUDE_NOT_EMPTYMSG = "配送人员位置不为空";
//	
//	public static final Integer ORDERNOTEXISTSORNOTAVALIABLE = 77;
//	public static final String ORDERNOTEXISTSORNOTAVALIABLEMSG = "订单不存在或不可用";
//	
//	public static final Integer ORDERFINISHEDOREXCEPTION = 78;
//	public static final String ORDERFINISHEDOREXCEPTIONMSG = "订单结束或异常";
//	
//	public static final Integer unOneMinute = 490;
//	public static final String unOneMinuteMsg = "不足一分钟";
//	
//	public static final Integer unFiveMinute = 492;
//	public static final String unFiveMinuteMsg = "超过5分钟";
//	
//	public static final Integer PASSWORDNOTEQUAL = 13;
//	public static final String PASSWORDNOTEQUALMSG = "两次输入密码不匹配";
//	
	
	public static final Integer RECEIVE_LOCATION_NOT_INVALID = 10330;
	public static final String RECEIVE_LOCATION_NOT_INVALID_MSG = "订单配送位置无法获取准确定位";
	
	public static final Integer RECEIVE_LOCATION_NOT_AVALIABLE = 10231;
	public static final String RECEIVE_LOCATION_NOT_AVALIABLE_MSG = "订单配送位置附近没有支持的菜市场";
	
	public static final Integer SHOP_ORDER_GOODS_PREEMPTED = 10339;
	public static final String SHOP_ORDER_GOODS_PREEMPTED_MSG = "订单中您有库存的在售商品已全部被抢";
	
	public static final Integer SHOP_ORDER_GOODS_STOCK_OVER = 10349;
	public static final String SHOP_ORDER_GOODS_STOCK_OVER_MSG = "订单中的商品在最近的市场已售罄";
	
	public static final Integer MARKET_HAS_NO_DELIVERER = 10391;
	public static final String MARKET_HAS_NO_DELIVERER_MSG = "市场不存在配送人员";

	public static final Integer DUPLICATE_ENTRY_SELLER_GOOD = 10603;
	public static final String DUPLICATE_ENTRY_SELLER_GOOD_MSG = "请勿重复添加相同的商品";

	public static final Integer WECHAT_PAY_GENERATE_WQ_CODE_FAIL = 10803;
	public static final String WECHAT_PAY_GENERATE_WQ_CODE_FAIL_MSG = "二维码生成失败";
	
	public static final Integer VALIDATE_CODE_SEND_FAIL = 10809;
	public static final String VALIDATE_CODE_SEND_FAIL_MSG = "验证码发送失败";
	
	public static final Integer PAY_METHOD_NOT_SUPPORT = 11030;
	public static final String PAY_METHOD_NOT_SUPPORT_MSG = "不支持的支付类型";

	public static final Integer ORDER_SHIPPING_STATUS_SHOULD_ONLY_USED_IN_PREPARED_ORDER = 13030;
	public static final String ORDER_SHIPPING_STATUS_SHOULD_ONLY_USED_IN_PREPARED_ORDER_MSG = "仅有待取货的订单才能开始配送";

	public static final Integer ORDER_SHIPPRD_STATUS_SHOULD_ONLY_USED_IN_SHIPPING_ORDER = 13033;
	public static final String ORDER_SHIPPRD_STATUS_SHOULD_ONLY_USED_IN_SHIPPING_ORDER_MSG = "仅有配送中的订单才能完成";
	
	/*
	 * 次报错信息表示高德云图中的数据与DB中的数据不匹配
	 * 出现的情况极有可能是因为云图中的数据并未与DB中的数据一一对应
	 * Note: 在后台维护云图与db关系后,该报错不应该发生
	 */
	public static final Integer GEODE_MAP_CONFLICT_WITH_DB = 14000;
	public static final String GEODE_MAP_CONFLICT_WITH_DB_MSG = "云图数据未同步";
	
	public static final Integer BAD_REQUEST_TO_OBSERVER = 10400;
	public static final String BAD_REQUEST_TO_OBSERVER_MSG = "操作失败，请重试";
	
	public static final Integer ERROR_CONNECT_TO_OBSERVER = 10500;
	public static final String ERROR_CONNECT_TO_OBSERVER_MSG = "未知错误，请稍后再试";
//	
//	/*
//	 * 请求外部资源失败, 可能为服务器网络问题, 需要重试
//	 */
//	public static final Integer REQUEST_FAIL_TRY_AGAIN_LATER = 12;
//	public static final String REQUEST_FAIL_TRY_AGAIN_LATER_MSG = "请求失败，请稍后重试";
//	
//	public static final Integer REQUEST_FAIL_DATA_FORMAT_NOT_SUPPORT = 13;
//	public static final String REQUEST_FAIL_DATA_FORMAT_NOT_SUPPORT_MSG = "请求失败，请联系系统管理员";
//	
//	public static final Integer WECHAT_GET_SIGN_FAIL = 14;
//	public static final String WECHAT_GET_SIGN_FAIL_MSG = "获取sign失败,来源错误";
//	
//	public static final Integer WECHAT_USER_NOT_EXISTS = 15;
//	public static final String WECHAT_USER_NOT_EXISTS_MSG = "微信用户不存在";
//	
//	public static final Integer WECHAT_USER_UNIONID_NOT_EXISTS = 16;
//	public static final String WECHAT_USER_UNIONID_NOT_EXISTS_MSG = "无法获取微信unionId或openid, 操作失败";
//	
//	public static final Integer WECHAT_USER_ALREADY_EXISTS = 17;
//	public static final String WECHAT_USER_ALREADY_EXISTS_MSG = "微信用户已存在";
//	
//	public static final String CLIENT_NEED_UPDATE = "客户端需要更新,请更新后使用";
	
//	public static JSONObject getResultData(Object data,Integer code,String msg){
//		JSONObject jo = new JSONObject();
//		jo.put(ResultUtils.data, data);
//		jo.put(ResultUtils.code, code);
//		jo.put(ResultUtils.msg, msg);
//		return jo;
//	}
	
	public static final String ERROR_CCB_TO_IDENTIFICATION_MSG = "建行二维码支付回调标识失败";
	public static final String ERROR_CCB_TO_SIGN_MSG = "建行二维码支付回调验签失败";
	public static final String ERROR_NOT_PUBKEY_MSG = "商户公钥不存在";
	
	public static final String WAIT_PREPARED_MSG = "等待其他商户备货";
	
}

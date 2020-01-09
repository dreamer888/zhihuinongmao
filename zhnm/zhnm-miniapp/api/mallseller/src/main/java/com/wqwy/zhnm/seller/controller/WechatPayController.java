package com.wqwy.zhnm.seller.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wqwy.zhnm.base.component.component.BalanceOfflineOrderNotifyToMQComponent;
import com.wqwy.zhnm.base.component.constant.ConstantsFileProperties;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.constant.WechatApiConstants;
import com.wqwy.zhnm.base.component.constant.DefaultConstants.WechatResponseEnum;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.exception.WechatException;
import com.wqwy.zhnm.base.component.utils.ConvertUtils;
import com.wqwy.zhnm.base.component.utils.wxpay.WXPayUtil;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrder;
import com.wqwy.zhnm.base.service.BalanceOfflineOrderService;
import com.wqwy.zhnm.base.service.async.RabbitMQAsyncJobService;

@RestController
public class WechatPayController {

	private static final Logger logger = LoggerFactory.getLogger(WechatPayController.class);
	
	/**
	 * 
	 * @Title: wechatPayNofity  
	 * @Description: 微信扫码支付回调  仅支持商户的称的线下订单支付  TODO
	 * @date 31 May 2018 12:01:50 PM  
	 * @param @param request
	 * @param @param response
	 * @param @return  
	 * @return String  
	 * @throws
	 */
	/*
	 * 回调参数格式为xml method为post
	 * 回调中部分参数名称不确定 e.g.:coupon_type_$n coupon_id_$n coupon_fee_$n
	 * 难以封装到单个对象
	 * 使用map获取参数 取出需要操作的key
	 */
	// TODO 封装
	@RequestMapping(value = "/wxpay/notify", method = RequestMethod.POST)
	protected String wechatPayNofity(HttpServletRequest request, HttpServletResponse response) {
		logger.info("do wxpay notify...");
		String str = null;
		Map<String, String> requestMap = new HashMap<String, String>();
		try {
			str = request.getReader().lines().collect(Collectors.joining());
			requestMap = WXPayUtil.xmlToMap(str);
		} catch (Exception e) {
			logger.error("wxpay notify response wrong, str: " + str);
			throw new WechatException();
		}
		logger.debug("str: " + str);
		logger.debug("requestMap: " + requestMap.toString());
		/**
		 * 获取回调参数后
		 * 0.判断是否成功
		 * 1.校验签名
		 * 2.查询订单 校验金额
		 */
		/*
		 * 0
		 */
		String returnCode = requestMap.get("return_code");// 通信标识，非交易标识，交易是否成功需要查看result_code来判断
		String returnMsg = requestMap.get("return_msg");
		String resultCode = requestMap.get("result_code");
		if (!DefaultConstants.SUCCESS.equals(returnCode) || !DefaultConstants.SUCCESS.equals(resultCode)) {
			logger.error("return_code or result_code not SUCCESS");
			throw new WechatException(returnMsg);
		}
		
		/*
		 * 1
		 */
		try {
			Boolean isValidSign = WXPayUtil.isSignatureValid(str, WechatApiConstants.SIGN_KEY);
			if (!isValidSign)
				throw new WechatException("data " + str + " sign invalid");
		} catch (Exception e1) {
			logger.error(e1.getMessage());
			throw new WechatException();
		}
		
		/*
		 * 2
		 */
		String outTradeNo = requestMap.get("out_trade_no");
		String totalFee = requestMap.get("total_fee");
		doWechatNotifyOfflineOrderOperation(outTradeNo, totalFee);
		
//		Map<String, String> resultMap = new HashMap<String, String>();
//		resultMap.put("return_code", "SUCCESS");
//		resultMap.put("return_msg", "OK");
//		String xmlStr = null;
//		try {
//			xmlStr = WXPayUtil.mapToXml(resultMap);
//		} catch (Exception e) {
//			logger.info(e.getMessage());
//			throw new BusinessException();
//		}
		return DefaultConstants.WechatResponseXmlMap.get(WechatResponseEnum.SUCCESS);
	}
	
	@Autowired
	private BalanceOfflineOrderService balanceOfflineOrderService;
	
	@Autowired
	private RabbitMQAsyncJobService rabbitMQAsyncJobService;
	
	private void doWechatNotifyOfflineOrderOperation(String orderNumber, String totalFee) {
		// 1.check fee
		BalanceOfflineOrder balanceOfflineOrder = new BalanceOfflineOrder();
		balanceOfflineOrder.setOrderNumber(orderNumber);
		balanceOfflineOrder = balanceOfflineOrderService.findList(balanceOfflineOrder).get(0);
		String totalPriceFen = ConvertUtils.DoubleMoneyUnitYuanToLongMoneyUnitFen(balanceOfflineOrder.getTotalPrice()).toString();
//		// 测试屏蔽金额校验 TODO
//		if (!totalPriceFen.equals(totalFee))
//			throw new WechatException("totalPriceFen: " + totalPriceFen + " not equals notify totalFee: " + totalFee);
		// 2.修改订单信息到已完成支付
		if (DefaultConstants.BalanceOfflineOrderEnum.BALANCEOFFLINEORDER_PAYED_WAIT_EVALUATE.getBalanceOfflineOrderEnum().equals(balanceOfflineOrder.getStatus()))
			return;
		balanceOfflineOrder.setStatus(DefaultConstants.BalanceOfflineOrderEnum.BALANCEOFFLINEORDER_PAYED_WAIT_EVALUATE.getBalanceOfflineOrderEnum());
		balanceOfflineOrderService.update(balanceOfflineOrder);
		// 3.发送支付成功信息到MQ
		BalanceOfflineOrderNotifyToMQComponent boonomqc = new BalanceOfflineOrderNotifyToMQComponent();
		boonomqc.setBalanceId(balanceOfflineOrder.getBalanceId());
		boonomqc.setOrderId(balanceOfflineOrder.getId());
		boonomqc.setUrl(ConstantsFileProperties.BALANCEOFFLINEORDER_TICKET_URL_PREFIX +balanceOfflineOrder.getId());
		boonomqc.setOrderTotal(balanceOfflineOrder.getTotalPrice());
		rabbitMQAsyncJobService.doSendBalanceOfflineOrderMessageToMQBalanceQueueForPayNotify(boonomqc);
	}
	
}

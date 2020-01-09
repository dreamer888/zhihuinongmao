package com.wqwy.zhnm.seller.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.jfinal.kit.HttpKit;
import com.wqwy.zhnm.base.component.component.BalanceOfflineOrderNotifyToMQComponent;
import com.wqwy.zhnm.base.component.constant.ConstantsFileProperties;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.ConvertUtils;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.component.utils.StringUtil;
import com.wqwy.zhnm.base.component.utils.ccb.RSASig;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrder;
import com.wqwy.zhnm.base.entity.SellerBalance;
import com.wqwy.zhnm.base.entity.SellerBankAccount;
import com.wqwy.zhnm.base.service.BalanceOfflineOrderService;
import com.wqwy.zhnm.base.service.SellerBalanceService;
import com.wqwy.zhnm.base.service.SellerBankAccountService;
import com.wqwy.zhnm.base.service.async.RabbitMQAsyncJobService;

@RestController
public class CcbPayController {
	
	private static final Logger logger = LoggerFactory.getLogger(CcbPayController.class);
	
	@Autowired
	private BalanceOfflineOrderService balanceOfflineOrderService;
	
	@Autowired
	private RabbitMQAsyncJobService rabbitMQAsyncJobService;
	
	@Autowired
	private SellerBankAccountService sellerBankAccountService;
	
	@Autowired
	private SellerBalanceService sellerBalanceService;
	
	private String PUBKEY = "";
	
	/**
	 * 
	 * @Title: wechatPayNofity  
	 * @Description: 建行扫码支付回调  仅支持商户的称的线下订单支付  TODO
	 * @date 31 May 2018 12:01:50 PM  
	 * @param @param request
	 * @param @param response
	 * @param @return  
	 * @return String  
	 * @throws
	 */
	/*
	 * 回调参数格式json method为post
	 * 回调中部分参数名称不确定 
	 * 难以封装到单个对象
	 */
	@RequestMapping(value = "/ccbpay/notify", method = RequestMethod.POST)
	protected String ccbPayNofity(HttpServletRequest request, HttpServletResponse response) {
		        logger.info("do ccbpay notify...");
				/**
				 * 获取回调参数后
				 * 0.判断是否成功
				 * 1.校验签名
				 * 2.查询订单 校验金额
				 */
		        String POSID = request.getParameter("POSID");
		        String BRANCHID = request.getParameter("BRANCHID");
		        String ORDERID = request.getParameter("ORDERID");
		        String PAYMENT = request.getParameter("PAYMENT");
		        String CURCODE = request.getParameter("CURCODE");
		        String REMARK1 = request.getParameter("REMARK1");
		        String REMARK2 = request.getParameter("REMARK2");
		        String ACC_TYPE = request.getParameter("ACC_TYPE");
		        String SUCCESS = request.getParameter("SUCCESS");
		        
		        String TYPE = request.getParameter("TYPE");
		        String REFERER = request.getParameter("REFERER");
		        String CLIENTIP = request.getParameter("CLIENTIP");
		        String ACCDATE = request.getParameter("ACCDATE");
		        String USRMSG = request.getParameter("USRMSG");
		        String USRINFO = request.getParameter("USRINFO");
		        String PAYTYPE = request.getParameter("PAYTYPE");
		        String SIGN = request.getParameter("SIGN");
		        
		        logger.info("后续字段-->"+TYPE+","+REFERER+","+CLIENTIP+","+ACCDATE+","+USRMSG+","+USRINFO+","+PAYTYPE);
		        logger.info("POSID:"+POSID);
		        logger.info("BRANCHID:"+BRANCHID);
		        logger.info("ORDERID:"+ORDERID);
		        logger.info("PAYMENT:"+PAYMENT);
		        logger.info("CURCODE:"+CURCODE);
		        logger.info("REMARK1:"+REMARK1);
		        logger.info("REMARK2:"+REMARK2);
		        logger.info("ACC_TYPE:"+ACC_TYPE);
		        logger.info("SUCCESS:"+SUCCESS);
		        logger.info("TYPE:"+TYPE);
		        logger.info("REFERER:"+REFERER);
		        logger.info("CLIENTIP:"+CLIENTIP);
		        logger.info("ACCDATE:"+ACCDATE);
		        logger.info("USRMSG:"+USRMSG);
		        logger.info("USRINFO:"+USRINFO);
		        logger.info("PAYTYPE:"+PAYTYPE);
		        logger.info("SIGN:"+SIGN);
		        
		        //一分钱测试
		        if(ORDERID.contains("op")) {
		        	logger.info("do one point testing");
		        	SellerBankAccount account = new SellerBankAccount();
		        	account.setPosid(POSID);
		        	SellerBalance sellerBalance = sellerBalanceService.findByMerchantId(account);
		        	// 3.发送支付成功信息到MQ
		     		BalanceOfflineOrderNotifyToMQComponent boonomqc = new BalanceOfflineOrderNotifyToMQComponent();
		     		boonomqc.setBalanceId(sellerBalance.getBalanceId());
		     		//boonomqc.setOrderId(balanceOfflineOrder.getId());
		     		//boonomqc.setUrl(ConstantsFileProperties.BALANCEOFFLINEORDER_TICKET_URL_PREFIX +balanceOfflineOrder.getId());
		     		boonomqc.setOrderTotal(new BigDecimal("0.01"));
		     		//boonomqc.setPayWay(payWay);
		     		rabbitMQAsyncJobService.doSendBalanceOfflineOrderMessageToMQBalanceQueueForPayNotify(boonomqc);
		     		return "one point testing";
		        }
		        
		        
		        try {
					BalanceOfflineOrder balanceOfflineOrder = new BalanceOfflineOrder();
					balanceOfflineOrder.setOrderNumber(ORDERID);
					List<BalanceOfflineOrder> offlist = balanceOfflineOrderService.findList(balanceOfflineOrder);
					SellerBankAccount account = new SellerBankAccount();
					account.setSellerId(offlist.get(0).getSellerId());
					List<SellerBankAccount> acclist = sellerBankAccountService.findList(account);
					
					PUBKEY = acclist.get(0).getPublickey();  //商户公钥
					if(!StringUtil.isValid(PUBKEY)) {
						throw new BusinessException(ResultUtils.FAIL, ResultUtils.ERROR_NOT_PUBKEY_MSG, ResultUtils.ERROR_NOT_PUBKEY_MSG);
					}
					
				} catch (Exception e) {
					throw new BusinessException(ResultUtils.FAIL, ResultUtils.ERROR_NOT_PUBKEY_MSG, ResultUtils.ERROR_NOT_PUBKEY_MSG);
				}
	    		
		    	/*
				 * 0.判断是否成功  Y-->成功  N-->失败
				 */
		        if(SUCCESS.equals("N")) {
		        	logger.error("return_code or result_code not SUCCESS");
		        	throw new BusinessException(ResultUtils.FAIL, ResultUtils.ERROR_CCB_TO_IDENTIFICATION_MSG, ResultUtils.ERROR_CCB_TO_IDENTIFICATION_MSG);
		        }
		        
		        StringBuffer tmp = new StringBuffer(); //验签字段
		        tmp.append("POSID=");
		        tmp.append(POSID);
		        tmp.append("&BRANCHID=");
		        tmp.append(BRANCHID);
		        tmp.append("&ORDERID=");
		        tmp.append(ORDERID);
		        tmp.append("&PAYMENT=");
		        tmp.append(PAYMENT);
		        tmp.append("&CURCODE=");
		        tmp.append(CURCODE);
		        tmp.append("&REMARK1=");
		        tmp.append(REMARK1);
		        tmp.append("&REMARK2=");
		        tmp.append(REMARK2);
		        tmp.append("&ACC_TYPE=");
		        tmp.append(ACC_TYPE);
		        tmp.append("&SUCCESS=");
		        tmp.append(SUCCESS);
		        
		        if(StringUtil.isValid(TYPE)) {
		        	 tmp.append("&TYPE=");
		        	 if(StringUtil.isValid(TYPE)) {
		        		 tmp.append(TYPE);
		        	 }
		        }
		        	 
		        //if(StringUtil.isValid(REFERER)) {
		        	 tmp.append("&REFERER=");
		        	 if(StringUtil.isValid(REFERER)) {
				        tmp.append(REFERER);
		        	 }
		        //}
		        	 
		        if(StringUtil.isValid(CLIENTIP)) {
		        	 tmp.append("&CLIENTIP=");
		        	 if(StringUtil.isValid(CLIENTIP)) {
				        tmp.append(CLIENTIP);
		        	 }
		        }
		        if(StringUtil.isValid(ACCDATE)) {
		        	 tmp.append("&ACCDATE=");
		        	 if(StringUtil.isValid(ACCDATE)) {
				        tmp.append(ACCDATE);
		        	 }
		        }
		        if(StringUtil.isValid(USRMSG)) {
		        	 tmp.append("&USRMSG=");
		        	 if(StringUtil.isValid(USRMSG)) {
				        tmp.append(USRMSG);
		        	 }
		        }
		        if(StringUtil.isValid(USRINFO)) {
		        	 tmp.append("&USRINFO=");
		        	 if(StringUtil.isValid(USRINFO)) {
				        tmp.append(USRINFO);
				     }
		        }
		        if(StringUtil.isValid(PAYTYPE)) {
		        	 tmp.append("&PAYTYPE=");
		        	 if(StringUtil.isValid(PAYTYPE)) {
				        tmp.append(PAYTYPE);
		        	 }
		        }
		  
		        String strSrc = tmp.toString();
		        String strSign = SIGN;
		        RSASig rsa=new RSASig();
		        rsa.setPublicKey(PUBKEY);
		        
		        logger.info("strSrc-->"+strSrc);
		        logger.info("strSign-->"+strSign);
		        logger.info("pubkey-->"+PUBKEY);
		        logger.info("verifySigature-->"+rsa.verifySigature(strSign, strSrc));
		        
		        /*
				 * 1.校验签名 //true-->验签成功  false-->验签失败
				 */
//		        if(!rsa.verifySigature(strSign, strSrc)){ 
//		        	throw new BusinessException(ResultUtils.FAIL, ResultUtils.ERROR_CCB_TO_SIGN_MSG, ResultUtils.ERROR_CCB_TO_SIGN_MSG);
//		        }
		        
		        /*
				 * 2.查询订单 校验金额
				 */
				doWechatNotifyOfflineOrderOperation(ORDERID,PAYMENT,PAYTYPE);
				
		return strSrc;
	}
	
	
	private void doWechatNotifyOfflineOrderOperation(String orderNumber, String totalFee,String payWay) {
		
		// 1.check fee
		BalanceOfflineOrder balanceOfflineOrder = new BalanceOfflineOrder();
		balanceOfflineOrder.setOrderNumber(orderNumber);
		balanceOfflineOrder = balanceOfflineOrderService.findList(balanceOfflineOrder).get(0);
		String totalPriceFen = ConvertUtils.DoubleMoneyUnitYuanToLongMoneyUnitFen(balanceOfflineOrder.getTotalPrice()).toString();
		
		// 测试屏蔽金额校验 TODO
//		if (!totalPriceFen.equals(totalFee))
//			throw new WechatException("totalPriceFen: " + totalPriceFen + " not equals notify totalFee: " + totalFee);
		
		// 2.修改订单信息到已完成支付
		if (DefaultConstants.BalanceOfflineOrderEnum.BALANCEOFFLINEORDER_PAYED_WAIT_EVALUATE.getBalanceOfflineOrderEnum().equals(balanceOfflineOrder.getStatus()))
			return;
		
//		Integer payWay =getPayWay(payType); 
		//balanceOfflineOrder.setPayWay(payWay);
		balanceOfflineOrder.setStatus(DefaultConstants.BalanceOfflineOrderEnum.BALANCEOFFLINEORDER_PAYED_WAIT_EVALUATE.getBalanceOfflineOrderEnum());
		balanceOfflineOrderService.update(balanceOfflineOrder);
		
		// 3.发送支付成功信息到MQ
		BalanceOfflineOrderNotifyToMQComponent boonomqc = new BalanceOfflineOrderNotifyToMQComponent();
		boonomqc.setBalanceId(balanceOfflineOrder.getBalanceId());
		boonomqc.setOrderId(balanceOfflineOrder.getId());
		boonomqc.setUrl(ConstantsFileProperties.BALANCEOFFLINEORDER_TICKET_URL_PREFIX +balanceOfflineOrder.getId());
		boonomqc.setOrderTotal(balanceOfflineOrder.getTotalPrice());
		boonomqc.setPayWay(payWay);
		rabbitMQAsyncJobService.doSendBalanceOfflineOrderMessageToMQBalanceQueueForPayNotify(boonomqc);
	}
	
	//ALIPAY:支付宝,WEIXIN：微信,为空：建行龙支付
	private Integer getPayWay(String payType) {
		Integer payWay = DefaultConstants.BalanceOfflineOrderEnum.PAY_WAY_CASH.getBalanceOfflineOrderEnum();
		if(!StringUtil.isValid(payType)) {
			payWay = DefaultConstants.BalanceOfflineOrderEnum.PAY_WAY_CCB_DRAGON.getBalanceOfflineOrderEnum();
		}
		
		if(StringUtil.isValid(payType) && payType.equals("ALIPAY")) {
			payWay = DefaultConstants.BalanceOfflineOrderEnum.PAY_WAY_ALIPAY.getBalanceOfflineOrderEnum();
		}
		
		if(StringUtil.isValid(payType) && payType.equals("WEIXIN")) {
			payWay = DefaultConstants.BalanceOfflineOrderEnum.PAY_WAY_WECHATPAY.getBalanceOfflineOrderEnum();
		}
		
		return payWay;
	}
	
	
}

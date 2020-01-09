/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.response.QRCodeGenerateResponseToClient;
import com.wqwy.zhnm.base.component.response.WechatQRCodeGenerateResponseToClient;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.component.utils.StringUtil;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrder;
import com.wqwy.zhnm.base.entity.SellerBankAccount;
import com.wqwy.zhnm.base.service.SellerBalanceService;
import com.wqwy.zhnm.base.service.SellerBankAccountService;
import com.wqwy.zhnm.base.service.base.CcbOnePointPayPerformance;

/**
 * createTime: 2018-05-08 18:51:06
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class CcbOnePointPayControllerController{
	
	private static final Logger logger = LoggerFactory.getLogger(CcbOnePointPayControllerController.class);

	@Autowired
	private SellerBalanceService  sellerBalanceService;
	
	@Autowired
	private SellerBankAccountService  sellerBankAccountService;
	
    @Autowired(required = false)
    private CcbOnePointPayPerformance ccbOnePointPayPerformance;
	  
	/**
	 * 
	 * @date 2018-05-08 18:51:06
	 * @Title: ccbOnePointPay 
	 * @Description: TODO
	 * @param @param sellerBalance
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerBalance>
	 * @throws
	 */
	@RequestMapping(value="ccbOnePointPay", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<QRCodeGenerateResponseToClient> ccbOnePointPay(BalanceOfflineOrder balanceOfflineOrder, HttpServletRequest request){
	    
		logger.info("ccbOnePointPay-->sellerId:"+balanceOfflineOrder.getSellerId());
		logger.info("ccbOnePointPay-->balanceId:"+balanceOfflineOrder.getBalanceId());
		logger.info("ccbOnePointPay-->remark:"+balanceOfflineOrder.getRemark());
		//一分钱下单逻辑
		//建行二维码
		QRCodeGenerateResponseToClient qrcgrtc = new WechatQRCodeGenerateResponseToClient();
		SellerBankAccount account = new SellerBankAccount();
		account.setSellerId(balanceOfflineOrder.getSellerId());
		List<SellerBankAccount> acclist = sellerBankAccountService.findList(account);
		SellerBankAccount sellerBankAccount = acclist.get(0);
		String orderNumber = "op"+StringUtil.getId();
		balanceOfflineOrder.setOrderNumber(orderNumber);
		//区分动态，静态二维码 4动态  5静态
		if(balanceOfflineOrder.getRemark().equals(5)) {
			WechatQRCodeGenerateResponseToClient w = new WechatQRCodeGenerateResponseToClient();
	 		w.setTelephone(DefaultConstants.TELEPHONE);
	 		w.setCompany(DefaultConstants.COMPANY);
	 		w.setOrderNumber(orderNumber);
	 	    w.setCodeUrl(DefaultConstants.WQWY_IMG_SERVER+sellerBankAccount.getStaticcode());
	 	    qrcgrtc = w;
		}else {
			qrcgrtc = ccbOnePointPayPerformance.doQRcodeOrder(balanceOfflineOrder, sellerBankAccount);
		}
		
		return new JsonResponse<QRCodeGenerateResponseToClient>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, qrcgrtc);
	}
	
}

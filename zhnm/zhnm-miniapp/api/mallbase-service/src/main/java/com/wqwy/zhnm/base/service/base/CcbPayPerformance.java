package com.wqwy.zhnm.base.service.base;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.PayURL;
import com.wqwy.zhnm.base.component.dto.QrURL;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.response.WechatQRCodeGenerateResponseToClient;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.component.utils.ccb.HttpClientUtil;
import com.wqwy.zhnm.base.component.utils.ccb.MD5;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrder;
import com.wqwy.zhnm.base.entity.SellerBankAccount;

@Service
public class CcbPayPerformance {

	private static final Logger logger = LoggerFactory.getLogger(CcbPayPerformance.class);
	
	/**
     * 扫码支付  下单
     */
    public WechatQRCodeGenerateResponseToClient doQRcodeOrder(BalanceOfflineOrder balanceOfflineOrder,SellerBankAccount account){
    	logger.info("CcbPayPerformance-->orderId:"+balanceOfflineOrder.getId());
        WechatQRCodeGenerateResponseToClient client = new WechatQRCodeGenerateResponseToClient();
    
    	String bankURL=DefaultConstants.CCB_BANK_PAY_URL;
		String MERCHANTID = account.getMerchantid();
        String POSID = account.getPosid();
        String BRANCHID =account.getBranchid();
        String ORDERID = balanceOfflineOrder.getOrderNumber();
        BigDecimal PAYMENT= balanceOfflineOrder.getTotalPrice();
        PAYMENT=PAYMENT.setScale(2, BigDecimal.ROUND_HALF_UP); 
        String CURCODE="01";       //01－人民币
        String TXCODE = "530550";  //由建行统一分配为530550
        String REMARK1 = ""; 
        String REMARK2 = ""; 
        String RETURNTYPE="3";     //3：返回聚合扫码JSON格式【二维码信息串】
        String TIMEOUT = "";       //空值则不判断超时 
        String PUB32TR2= account.getPublickey();  //公钥后30
        PUB32TR2 = PUB32TR2.substring(PUB32TR2.length()-30, PUB32TR2.length());
        
        logger.info("CcbPayPerformance-->PUB32TR2:"+PUB32TR2);
        
        StringBuffer tmp = new StringBuffer(); //验签字段
        tmp.append("MERCHANTID=");
        tmp.append(MERCHANTID);
        tmp.append("&POSID=");
        tmp.append(POSID);
        tmp.append("&BRANCHID=");
        tmp.append(BRANCHID);
        tmp.append("&ORDERID=");
        tmp.append(ORDERID);
        tmp.append("&PAYMENT=");
        tmp.append(PAYMENT.toString());
        tmp.append("&CURCODE=");
        tmp.append(CURCODE);
        tmp.append("&TXCODE=");
        tmp.append(TXCODE);
        tmp.append("&REMARK1=");
        tmp.append(REMARK1);
        tmp.append("&REMARK2=");
        tmp.append(REMARK2);
        tmp.append("&RETURNTYPE=");
        tmp.append(RETURNTYPE);
        tmp.append("&TIMEOUT=");
        tmp.append(TIMEOUT);
        tmp.append("&PUB=");
        tmp.append(PUB32TR2);
        
        Map map = new HashMap();
        map.put("CCB_IBSVersion","V6");	//必输项
        map.put("MERCHANTID",MERCHANTID);
        map.put("BRANCHID",BRANCHID);
        map.put("POSID",POSID);
        map.put("ORDERID",ORDERID);
        map.put("PAYMENT",PAYMENT.toString());
        map.put("CURCODE",CURCODE);
        map.put("TXCODE",TXCODE);
        map.put("REMARK1",REMARK1);
        map.put("REMARK2",REMARK2);
        map.put("RETURNTYPE",RETURNTYPE);
        map.put("TIMEOUT",TIMEOUT);
        map.put("MAC",MD5.md5Str(tmp.toString()));
        
    	try {
	        String ret = HttpClientUtil.httpPost(bankURL, map); 	//请求二维码生成链接串
            
			Gson gson = new Gson();
			PayURL payurl = (PayURL) gson.fromJson(ret, PayURL.class);
			logger.info("二维码生成参数::"+payurl.getPAYURL());
			
			ret = HttpClientUtil.httpGet(payurl.getPAYURL(), "UTF-8"); //获取二维码串
			
			QrURL result = (QrURL) gson.fromJson(ret, QrURL.class);
			String qrurl = URLDecoder.decode(result.getQRURL(), "UTF-8");   //解码
			
			logger.info("二维码返回结果::"+qrurl);
			
			client.setOrderId(balanceOfflineOrder.getId());
			client.setOrderNumber(balanceOfflineOrder.getOrderNumber());
			client.setCcbsuccess(result.getSUCCESS());
			client.setCodeUrl(qrurl);
			client.setCcbmac(MD5.md5Str(tmp.toString()));
			client.setUrl(DefaultConstants.BALANCEPRINTORDERURL+balanceOfflineOrder.getId());
			client.setTelephone(DefaultConstants.TELEPHONE);
			client.setCompany(DefaultConstants.COMPANY);
		} catch (JsonSyntaxException e) {
			logger.error(e.getMessage());
			throw new BusinessException(ResultUtils.WECHAT_PAY_GENERATE_WQ_CODE_FAIL, ResultUtils.WECHAT_PAY_GENERATE_WQ_CODE_FAIL_MSG,e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			throw new BusinessException(ResultUtils.WECHAT_PAY_GENERATE_WQ_CODE_FAIL, ResultUtils.WECHAT_PAY_GENERATE_WQ_CODE_FAIL_MSG,e.getMessage());
		}
       return client;
    }
    
    /**
     * 
     * @Title: doRefund  
     * @Description: 用户退款  
     * @date 12 Jun 2018 5:30:35 PM  
     * @param @param out_trade_no
     * @param @param total_fee  
     * @return void  
     * @throws
     */
    /*
     * 与付款不同,退款可考虑近返回成功与否
     */
    public void doRefund(String outTradeNo, String totalFee) {
    	logger.info("do ShopOrder Refund : outTradeNo: " + outTradeNo + " totalFee: " + totalFee);

    }

}

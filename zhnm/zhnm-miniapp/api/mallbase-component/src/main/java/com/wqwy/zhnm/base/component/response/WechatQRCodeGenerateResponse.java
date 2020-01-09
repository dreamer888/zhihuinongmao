package com.wqwy.zhnm.base.component.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WechatQRCodeGenerateResponse {

	/*
	 * {
	 * nonce_str=HM1xtmlPBg0Hyico, 
	 * code_url=weixin://wxpay/bizpayurl?pr=fxL010V, 
	 * appid=wx993fa013a962f5de, 
	 * sign=6D4292EC3F2A17F037D68DF48B54DC4EF3F405C63EDE592B27F020FE8D79B3E3, 
	 * trade_type=NATIVE, 
	 * return_msg=OK, 
	 * result_code=SUCCESS, 
	 * mch_id=1503478341, 
	 * return_code=SUCCESS, 
	 * prepay_id=wx30183037431786f35dca5d030146336904
	 * }
	 */
	@JsonProperty("nonce_str")
	private String nonceStr;
	
	@JsonProperty("code_url")
	private String codeUrl;
	
	@JsonProperty("appid")
	private String appId;
	
	@JsonProperty("sign")
	private String sign;
	
	@JsonProperty("trade_type")
	private String tradeType;
	
	@JsonProperty("return_msg")
	private String returnMsg;
	
	@JsonProperty("result_code")
	private String resultCode;
	
	@JsonProperty("mch_id")
	private String mchId;
	
	@JsonProperty("return_code")
	private String returnCode;
	
	@JsonProperty("prepay_id")
	private String prepayId;

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	
}

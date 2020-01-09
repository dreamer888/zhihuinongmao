package com.wqwy.zhnm.base.component.response;

//@JsonIgnoreProperties(allowGetters = true)
//@JsonAutoDetect(setterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class WechatQRCodeGenerateResponseToClient implements QRCodeGenerateResponseToClient {

	private Integer orderId;

	private String nonceStr;
	
	private String codeUrl;
	
	private String appId;
	
	private String sign;
	
	private String tradeType;
	
	private String returnMsg;
	
	private String resultCode;
	
	private String mchId;
	
	private String returnCode;
	
	private String prepayId;
	
	private String url;
	
	private String telephone;
	
	private String company;
	
	private String ccbsuccess;
	
	private String ccbmac;
	
	public String getCcbmac() {
		return ccbmac;
	}

	public void setCcbmac(String ccbmac) {
		this.ccbmac = ccbmac;
	}

	public String getCcbsuccess() {
		return ccbsuccess;
	}

	public void setCcbsuccess(String ccbsuccess) {
		this.ccbsuccess = ccbsuccess;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	private String orderNumber;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

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
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}

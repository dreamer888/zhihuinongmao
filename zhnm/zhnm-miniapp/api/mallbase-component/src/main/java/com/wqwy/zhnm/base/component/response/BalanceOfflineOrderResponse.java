package com.wqwy.zhnm.base.component.response;

import java.math.BigDecimal;

public class BalanceOfflineOrderResponse {

	private Integer orderId;
	private Integer status;
	private Integer payWay;
	private String  url;
	private BigDecimal totalPrice;
	private String orderNumber;
	private String payMsg;
	
	public String getPayMsg() {
		return payMsg;
	}
	public void setPayMsg(String payMsg) {
		this.payMsg = payMsg;
	}
	private QRCodeGenerateResponseToClient qrCodeGenerateResponseToClient;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
	public Integer getPayWay() {
		return payWay;
	}
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	
	public QRCodeGenerateResponseToClient getQrCodeGenerateResponseToClient() {
		return qrCodeGenerateResponseToClient;
	}
	public void setQrCodeGenerateResponseToClient(QRCodeGenerateResponseToClient qrCodeGenerateResponseToClient) {
		this.qrCodeGenerateResponseToClient = qrCodeGenerateResponseToClient;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
}

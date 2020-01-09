package com.wqwy.zhnm.base.component.dto;

import java.math.BigDecimal;

public class ShopOrderPrintDTO{
    
	/**
	 * 订单编号
	 */
	private String orderId;
	/**
	 * 订单价格
	 */
	private BigDecimal orderPrice;
	
	/**
	 * 支付时间
	 */
	private String payTime;
	
	/**
	 * 服务监督电话
	 */
	private String telephone;
	
	/**
	 * 技术支持
	 */
	private String company;
	
	/**
	 * 二维码
	 */
	private String qrCode;
	
	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
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

package com.wqwy.zhnm.base.component.component;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: BalanceOfflineOrderNotifyToMQComponent  
 * @author seven  
 * @date 9 Jun 2018 10:15:57 AM  
 *
 */
public class BalanceOfflineOrderNotifyToMQComponent {
	
	private Integer balanceId;
	
	private Integer orderId;
	
	private String url;
	
	private BigDecimal orderTotal;
	
	private String payWay;

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Integer getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(Integer balanceId) {
		this.balanceId = balanceId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

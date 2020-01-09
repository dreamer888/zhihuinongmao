package com.wqwy.zhnm.base.component.response;

public class UnionPayQRCodeGenerateResponseToClient extends UnionPayQRCodeGenerateResponse implements QRCodeGenerateResponseToClient {
	
	private Integer orderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "UnionPayQRCodeGenerateResponseToClient [orderId=" + orderId + ", toString()=" + super.toString() + "]";
	}

}

package com.wqwy.zhnm.base.component.request;

public class SellerLoginRequest extends LoginRequest {

	//登录的角色是 称的终端 还是 商户的终端 0:称 1.商户
	private Integer role;
	
	//商户扫码，称登录 商户id
	private Integer sellerId;
	
	//商户扫码，称登录 称id
	private Integer balanceId;
	
	//商户扫码，IMEI
	private String androidIMEI;

	public String getAndroidIMEI() {
		return androidIMEI;
	}

	public void setAndroidIMEI(String androidIMEI) {
		this.androidIMEI = androidIMEI;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(Integer balanceId) {
		this.balanceId = balanceId;
	}

	@Override
	public String toString() {
		return "SellerLoginRequest [role=" + role + ", sellerId=" + sellerId + ", balanceId=" + balanceId
				+ ",androidIMEI=" + androidIMEI + ", toString()=" + super.toString() + "]";
	}
	
}

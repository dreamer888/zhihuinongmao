package com.wqwy.zhnm.base.component.request;

public class LoginRequest {

	private String account;
	
	private String password;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [account=" + account + ", password=" + password + "]";
	}
	
}

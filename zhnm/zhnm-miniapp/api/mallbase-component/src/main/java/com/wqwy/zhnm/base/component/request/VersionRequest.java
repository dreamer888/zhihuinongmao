package com.wqwy.zhnm.base.component.request;

public class VersionRequest {

	private Integer appType;
	
	public Integer getAppType() {
		return appType;
	}



	public void setAppType(Integer appType) {
		this.appType = appType;
	}



	public String getVersionCode() {
		return versionCode;
	}



	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}



	private String versionCode;

	

	@Override
	public String toString() {
		return "VersionRequest [appType=" + appType + ", versionCode=" + versionCode + "]";
	}
	
}

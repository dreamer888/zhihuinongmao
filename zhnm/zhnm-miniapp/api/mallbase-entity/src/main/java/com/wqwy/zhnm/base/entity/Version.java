/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

/**
 * createTime: 2018-07-18 17:47:07
 * @author zss
 * @version
 */
public class Version{

    /**
     * 自增ID
     */
    private Integer id;

	/**
     * app名称
     */
    private String appName;

    /**
     * 版本编号
     */
    private String versionCode;

	/**
     * app类型：1.称  2.商户端 3.配送端
     */
    private Integer appType;

    /**
     * 称上app版本
     */
    private Integer lastForce;
    
    /**
     * app访问地址
     */
    private String upgradeUrl;
    
    /**
     * 升级描述
     */
    private String upgradeInfo;
    

    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }
    
    public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public Integer getAppType() {
		return appType;
	}

	public void setAppType(Integer appType) {
		this.appType = appType;
	}

	public Integer getLastForce() {
		return lastForce;
	}

	public void setLastForce(Integer lastForce) {
		this.lastForce = lastForce;
	}

	public String getUpgradeUrl() {
		return upgradeUrl;
	}

	public void setUpgradeUrl(String upgradeUrl) {
		this.upgradeUrl = upgradeUrl;
	}

	public String getUpgradeInfo() {
		return upgradeInfo;
	}

	public void setUpgradeInfo(String upgradeInfo) {
		this.upgradeInfo = upgradeInfo;
	}

	  @Override
		public String toString() {
			return "Version [id=" + id + ", appName=" + appName + ", versionCode=" + versionCode + ", appType=" + appType
					+ ", lastForce=" + lastForce + ", upgradeUrl=" + upgradeUrl + ", upgradeInfo=" + upgradeInfo + "]";
		}
}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 17:47:07
 * @author seven
 * @version
 */
public class Balance{

    /**
     * 
     */
    private Integer id;

    /**
     * 称IMEI号
     */
    private String balanceImei;

    /**
     * 型号
     */
    private String balanceModel;

    /**
     * 是否使用：0.未使用 1.已使用
     */
    private Boolean used;

    /**
     * 称上app版本
     */
    private String version;

    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }

    public void setBalanceImei(String value){
        this.balanceImei = value;
    }

    public String getBalanceImei(){
        return this.balanceImei;
    }

    public void setBalanceModel(String value){
        this.balanceModel = value;
    }

    public String getBalanceModel(){
        return this.balanceModel;
    }

    public void setUsed(Boolean value){
        this.used = value;
    }

    public Boolean getUsed(){
        return this.used;
    }

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Balance [id=" + id + ", balanceImei=" + balanceImei + ", balanceModel=" + balanceModel + ", used="
				+ used + ", version=" + version + "]";
	}

}

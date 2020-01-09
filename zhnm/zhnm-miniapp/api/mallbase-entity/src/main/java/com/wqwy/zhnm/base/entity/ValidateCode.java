/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * createTime: 2018-05-25 13:03:49
 * @author seven
 * @version
 */
public class ValidateCode{

	public static enum OperationTypeEnum {
		FORGOT_PASSWORD, BINDING, LOGIN, REGISTER
	}
	
	public static enum UserTypeEnum {
		USER, SELLER, DELIVERER, SYSTEM, OTHER
	}
	
    /**
     * 
     */
    private Integer id;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 验证码值
     */
    private String code;

    /**
     * 操作类型
     */
    private OperationTypeEnum operationType;
    
    /**
     * 发送请求方类型
     */
    private UserTypeEnum userType;

    /**
     * 发送时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date sendTime;


    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }

    public void setPhone(String value){
        this.phone = value;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setCode(String value){
        this.code = value;
    }

    public String getCode(){
        return this.code;
    }

    public void setOperationType(OperationTypeEnum value){
        this.operationType = value;
    }

    public OperationTypeEnum getOperationType(){
        return this.operationType;
    }

    public UserTypeEnum getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}

	public void setSendTime(java.util.Date value){
        this.sendTime = value;
    }

    public java.util.Date getSendTime(){
        return this.sendTime;
    }

}

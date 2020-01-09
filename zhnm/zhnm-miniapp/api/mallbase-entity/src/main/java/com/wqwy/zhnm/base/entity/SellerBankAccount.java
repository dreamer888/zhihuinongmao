/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wqwy.zhnm.base.entity.ValidateCode.OperationTypeEnum;
import com.wqwy.zhnm.base.entity.ValidateCode.UserTypeEnum;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 18:51:07
 * @author seven
 * @version
 */
public class SellerBankAccount{

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer sellerId;

    /**
     * 开户行
     */
    private String accountBank;

    /**
     * 银行账号
     */
    private String account;

    /**
     * 户名
     */
    private String accountName;
    
    /**
     * 银行卡账户开户行
     */
    private String accountPhone;

	/**
     * 验证码
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
     * 商户代码
     */
    private String merchantid;
    
    /**
     * 商户柜台代码
     */
    private String posid;
    
    /**
     * 分行代码
     */
    private String branchid;
    
    /**
     * 公钥
     */
    private String publickey;
    
    /**
     * 静态二维码
     */
    private String staticcode;
    
    public String getStaticcode() {
		return staticcode;
	}

	public void setStaticcode(String staticcode) {
		this.staticcode = staticcode;
	}

	public String getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}

	public String getPosid() {
		return posid;
	}

	public void setPosid(String posid) {
		this.posid = posid;
	}

	public String getBranchid() {
		return branchid;
	}

	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}

	public String getPublickey() {
		return publickey;
	}

	public void setPublickey(String publickey) {
		this.publickey = publickey;
	}

    public OperationTypeEnum getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationTypeEnum operationType) {
		this.operationType = operationType;
	}

	public UserTypeEnum getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }

    public void setSellerId(Integer value){
        this.sellerId = value;
    }

    public Integer getSellerId(){
        return this.sellerId;
    }

    public void setAccountBank(String value){
        this.accountBank = value;
    }

    public String getAccountBank(){
        return this.accountBank;
    }

    public void setAccount(String value){
        this.account = value;
    }

    public String getAccount(){
        return this.account;
    }

    public void setAccountName(String value){
        this.accountName = value;
    }

    public String getAccountName(){
        return this.accountName;
    }

	public String getAccountPhone() {
		return accountPhone;
	}

	public void setAccountPhone(String accountPhone) {
		this.accountPhone = accountPhone;
	}

}

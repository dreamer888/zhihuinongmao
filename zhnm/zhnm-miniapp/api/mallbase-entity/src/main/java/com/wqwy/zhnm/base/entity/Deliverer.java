/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 18:50:56
 * @author seven
 * @version
 */
public class Deliverer{

    /**
     * 
     */
    private Integer id;

    /**
     * token
     */
    private String token;
    
    /**
     * 账号：手机号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 账户状态：0正常，1冻结，2关闭
     */
    private Integer status;

    /**
     * 保证金
     */
    private java.math.BigDecimal credit;

    /**
     * 姓名
     */
    private String cnname;

    /**
     * 性别: 0男, 1女
     */
    private Boolean gender;

    /**
     * 年龄
     */
    private Integer age;

    private String delivererIco;


    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setAccount(String value){
        this.account = value;
    }

    public String getAccount(){
        return this.account;
    }

    public void setPassword(String value){
        this.password = value;
    }

    public String getPassword(){
        return this.password;
    }

    public void setIdCard(String value){
        this.idCard = value;
    }

    public String getIdCard(){
        return this.idCard;
    }

    public void setStatus(Integer value){
        this.status = value;
    }

    public Integer getStatus(){
        return this.status;
    }

    public void setCredit(java.math.BigDecimal value){
        this.credit = value;
    }

    public java.math.BigDecimal getCredit(){
        return this.credit;
    }

    public void setCnname(String value){
        this.cnname = value;
    }

    public String getCnname(){
        return this.cnname;
    }

    public void setGender(Boolean value){
        this.gender = value;
    }

    public Boolean getGender(){
        return this.gender;
    }

    public void setAge(Integer value){
        this.age = value;
    }

    public Integer getAge(){
        return this.age;
    }

    public String getDelivererIco() {
        return delivererIco;
    }

    public void setDelivererIco(String delivererIco) {
        this.delivererIco = delivererIco;
    }

    @Override
	public String toString() {
		return "Deliverer [id=" + id + ", token=" + token + ", account=" + account + ", password=" + password
				+ ", idCard=" + idCard + ", status=" + status + ", credit=" + credit + ", cnname=" + cnname
				+ ", gender=" + gender + ", age=" + age + "]";
	}

}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 18:51:02
 * @author seven
 * @version
 */
public class Seller{

    /**
     * 
     */
    private Integer id;
    
    /**
     * token
     */
    private String token;
    
    /**
     * 名称
     */
    private String name;

    /**
     * 商户账号：手机号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 店铺号
     */
    private String shopCode;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 营业执照照片
     */
    private String businessLicenseImg;

    /**
     * 所属农贸市场
     */
    private Integer belongMarket;

    /**
     * 身份证后六位
     */
    private String idCardLast;

    /**
     * 营业执照号码
     */
    private String businessLicenseCode;

    /**
     * 商户头像
     */
    private String sellerIco;

    /**
     * 商户分类
     */
    private String sellerCategory;


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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

    public void setShopCode(String value){
        this.shopCode = value;
    }

    public String getShopCode(){
        return this.shopCode;
    }

    public void setShopName(String value){
        this.shopName = value;
    }

    public String getShopName(){
        return this.shopName;
    }

    public void setBusinessLicenseImg(String value){
        this.businessLicenseImg = value;
    }

    public String getBusinessLicenseImg(){
        return this.businessLicenseImg;
    }

    public void setBelongMarket(Integer value){
        this.belongMarket = value;
    }

    public Integer getBelongMarket(){
        return this.belongMarket;
    }

    public void setIdCardLast(String value){
        this.idCardLast = value;
    }

    public String getIdCardLast(){
        return this.idCardLast;
    }

    public void setBusinessLicenseCode(String value){
        this.businessLicenseCode = value;
    }

    public String getBusinessLicenseCode(){
        return this.businessLicenseCode;
    }

    public void setSellerIco(String value){
        this.sellerIco = value;
    }

    public String getSellerIco(){
        return this.sellerIco;
    }

    public void setSellerCategory(String value){
        this.sellerCategory = value;
    }

    public String getSellerCategory(){
        return this.sellerCategory;
    }

	@Override
	public String toString() {
		return "Seller [id=" + id + ", token=" + token + ", name=" + name + ", account=" + account + ", password="
				+ password + ", shopCode=" + shopCode + ", shopName=" + shopName + ", businessLicenseImg="
				+ businessLicenseImg + ", belongMarket=" + belongMarket + ", idCardLast=" + idCardLast
				+ ", businessLicenseCode=" + businessLicenseCode + ", sellerIco=" + sellerIco + ", sellerCategory="
				+ sellerCategory + "]";
	}

}

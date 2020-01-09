/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * createTime: 2018-05-15 16:05:57
 * @author seven
 * @version
 */
public class ShopOrder{

    /**
     * 
     */
    private String orderId;

    /**
     * 下单时间
     */
    private String addtime;

    /**
     * 商品总价 
     */
    private java.math.BigDecimal totalPrice;

    /**
     * 订单总价
     */
    private java.math.BigDecimal orderTotal;

    /**
     * 
     */
    private java.math.BigDecimal couponPrice;

    /**
     * 
     */
    private String couponId;

    /**
     * 
     */
    private java.math.BigDecimal freightPrice;

    /**
     * 支付方式1支付宝2微信3商城币
     */
    private String payWay;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 
     */
    private String addrRealname;

    /**
     * 
     */
    private String addrPhone;

    /**
     * 
     */
    private String addrCity;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String ipAddress;

    /**
     * 用户ip
     */
    private String userIp;

    /**
     * 状态,0未支付，1 已支付，2已发货，3待退款，4退款成功，5交易成功,待评价，6评价完成
     */
    private Integer status;

    /**
     * 快递编号
     */
    private String expressTitle;

    /**
     * 快递名称
     */
    private String expressName;

    /**
     * 快递号码
     */
    private String expressNum;

    /**
     * 微信支付id
     */
    private String transactionId;

    /**
     * 菜市场id
     */
    private Integer marketId;

    /**
     * 配送员id
     */
    private Integer delivererId;

    private java.math.BigDecimal deliveryCost;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date cancelTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date deliveryFinishTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date finishTime;
    
    /**
     * 用户收获位置locaiton 经度,纬度
     */
    private String location;
    
    /**
     * 配送时间段
     */
    private String deliveryTimeSlice;

	/**
     * 备注
     */
    private String remark;
    
	/**
     * 派单时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date singleTime;
    
    
    public Date getSingleTime() {
		return singleTime;
	}

	public void setSingleTime(Date singleTime) {
		this.singleTime = singleTime;
	}

	public void setOrderId(String value){
        this.orderId = value;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public void setAddtime(String value){
        this.addtime = value;
    }

    public String getAddtime(){
        return this.addtime;
    }

    public void setTotalPrice(java.math.BigDecimal value){
        this.totalPrice = value;
    }

    public java.math.BigDecimal getTotalPrice(){
        return this.totalPrice;
    }

    public void setOrderTotal(java.math.BigDecimal value){
        this.orderTotal = value;
    }

    public java.math.BigDecimal getOrderTotal(){
        return this.orderTotal;
    }

    public void setCouponPrice(java.math.BigDecimal value){
        this.couponPrice = value;
    }

    public java.math.BigDecimal getCouponPrice(){
        return this.couponPrice;
    }

    public void setCouponId(String value){
        this.couponId = value;
    }

    public String getCouponId(){
        return this.couponId;
    }

    public void setFreightPrice(java.math.BigDecimal value){
        this.freightPrice = value;
    }

    public java.math.BigDecimal getFreightPrice(){
        return this.freightPrice;
    }

    public void setPayWay(String value){
        this.payWay = value;
    }

    public String getPayWay(){
        return this.payWay;
    }

    public void setUserId(String value){
        this.userId = value;
    }

    public String getUserId(){
        return this.userId;
    }

    public void setAddrRealname(String value){
        this.addrRealname = value;
    }

    public String getAddrRealname(){
        return this.addrRealname;
    }

    public void setAddrPhone(String value){
        this.addrPhone = value;
    }

    public String getAddrPhone(){
        return this.addrPhone;
    }

    public void setAddrCity(String value){
        this.addrCity = value;
    }

    public String getAddrCity(){
        return this.addrCity;
    }

    public void setAddress(String value){
        this.address = value;
    }

    public String getAddress(){
        return this.address;
    }

    public void setIpAddress(String value){
        this.ipAddress = value;
    }

    public String getIpAddress(){
        return this.ipAddress;
    }

    public void setUserIp(String value){
        this.userIp = value;
    }

    public String getUserIp(){
        return this.userIp;
    }

    public void setStatus(Integer value){
        this.status = value;
    }

    public Integer getStatus(){
        return this.status;
    }

    public void setExpressTitle(String value){
        this.expressTitle = value;
    }

    public String getExpressTitle(){
        return this.expressTitle;
    }

    public void setExpressName(String value){
        this.expressName = value;
    }

    public String getExpressName(){
        return this.expressName;
    }

    public void setExpressNum(String value){
        this.expressNum = value;
    }

    public String getExpressNum(){
        return this.expressNum;
    }

    public void setTransactionId(String value){
        this.transactionId = value;
    }

    public String getTransactionId(){
        return this.transactionId;
    }

    public void setMarketId(Integer value){
        this.marketId = value;
    }

    public Integer getMarketId(){
        return this.marketId;
    }

    public void setDelivererId(Integer value){
        this.delivererId = value;
    }

    public Integer getDelivererId(){
        return this.delivererId;
    }

	public java.math.BigDecimal getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(java.math.BigDecimal deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Date getDeliveryFinishTime() {
		return deliveryFinishTime;
	}

	public void setDeliveryFinishTime(Date deliveryFinishTime) {
		this.deliveryFinishTime = deliveryFinishTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDeliveryTimeSlice() {
		return deliveryTimeSlice;
	}

	public void setDeliveryTimeSlice(String deliveryTimeSlice) {
		this.deliveryTimeSlice = deliveryTimeSlice;
	}
     
    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}

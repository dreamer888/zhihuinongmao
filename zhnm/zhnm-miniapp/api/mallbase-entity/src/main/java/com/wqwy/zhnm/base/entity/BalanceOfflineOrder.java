/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * createTime: 2018-05-08 18:51:13
 * @author seven
 * @version
 */
public class BalanceOfflineOrder{

    /**
     * 
     */
    private Integer id;

    /**
     * 称ID
     */
    private Integer balanceId;

    /**
     * 下单时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date addtime;

    /**
     * 总价
     */
    private java.math.BigDecimal totalPrice;

    /**
     * 支付方式:1支付宝 2微信 3现金
     */
    private Integer payWay;

    /**
     * 状态,0未支付，1 已支付，2已发货，3待退款，4退款成功，5交易成功,待评价，6评价完成
     */
    private Integer status;

    /**
     * 评价0-100，每颗星20
     */
    private Integer remark;

    /**
     * 商户id
     */
    private Integer sellerId;
    
    /**
     * 订单编号
     */
    private String orderNumber;
    
    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }

    public void setBalanceId(Integer value){
        this.balanceId = value;
    }

    public Integer getBalanceId(){
        return this.balanceId;
    }

    public void setAddtime(Date value){
        this.addtime = value;
    }

    public Date getAddtime(){
        return this.addtime;
    }

    public void setTotalPrice(java.math.BigDecimal value){
        this.totalPrice = value;
    }

    public java.math.BigDecimal getTotalPrice(){
        return this.totalPrice;
    }

    public void setPayWay(Integer value){
        this.payWay = value;
    }

    public Integer getPayWay(){
        return this.payWay;
    }

    public void setStatus(Integer value){
        this.status = value;
    }

    public Integer getStatus(){
        return this.status;
    }

    public void setRemark(Integer value){
        this.remark = value;
    }

    public Integer getRemark(){
        return this.remark;
    }

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * createTime: 2018-05-15 11:51:43
 * @author seven
 * @version
 */
public class ShopOrderDetail{

    /**
     * 
     */
    private String orderDetailId;

    /**
     * 
     */
    private Integer goodsId;

    /**
     * 
     */
    private String goodsPic;

    /**
     * 
     */
    private String goodsName;

    /**
     * 
     */
    private java.math.BigDecimal goodsPrice;

    /**
     * 
     */
    private java.math.BigDecimal goodsCount;

    /**
     * 
     */
    private java.math.BigDecimal goodsTotal;

    /**
     * 
     */
    private String attributeDetailId;

    /**
     * 
     */
    private String attributeDetailName;

    /**
     * 
     */
    private java.math.BigDecimal payTotal;

    /**
     * 
     */
    private String orderId;

    /**
     * 
     */
    private Integer sort;

    /**
     * 状态,0未支付，1 已支付，2已发货，3待退款，4退款成功，5交易成功,待评价，6评价完成
     */
    private Integer status;

    /**
     * 已抢单的商户的id
     */
    private Integer sellerId;

    /**
     * 已抢单的商户的抢单时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date sellerSeizeTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date sellerPrepareTime;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date delivererReceiveTime;
    
    /**
     * 
     */
    private java.math.BigDecimal avgPrice;

    public java.math.BigDecimal getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(java.math.BigDecimal avgPrice) {
		this.avgPrice = avgPrice;
	}

	public void setOrderDetailId(String value){
        this.orderDetailId = value;
    }

    public String getOrderDetailId(){
        return this.orderDetailId;
    }

    public void setGoodsId(Integer value){
        this.goodsId = value;
    }

    public Integer getGoodsId(){
        return this.goodsId;
    }

    public void setGoodsPic(String value){
        this.goodsPic = value;
    }

    public String getGoodsPic(){
        return this.goodsPic;
    }

    public void setGoodsName(String value){
        this.goodsName = value;
    }

    public String getGoodsName(){
        return this.goodsName;
    }

    public void setGoodsPrice(java.math.BigDecimal value){
        this.goodsPrice = value;
    }

    public java.math.BigDecimal getGoodsPrice(){
        return this.goodsPrice;
    }

    public void setGoodsCount(java.math.BigDecimal value){
        this.goodsCount = value;
    }

    public java.math.BigDecimal getGoodsCount(){
        return this.goodsCount;
    }

    public void setGoodsTotal(java.math.BigDecimal value){
        this.goodsTotal = value;
    }

    public java.math.BigDecimal getGoodsTotal(){
        return this.goodsTotal;
    }

    public void setAttributeDetailId(String value){
        this.attributeDetailId = value;
    }

    public String getAttributeDetailId(){
        return this.attributeDetailId;
    }

    public void setAttributeDetailName(String value){
        this.attributeDetailName = value;
    }

    public String getAttributeDetailName(){
        return this.attributeDetailName;
    }

    public void setPayTotal(java.math.BigDecimal value){
        this.payTotal = value;
    }

    public java.math.BigDecimal getPayTotal(){
        return this.payTotal;
    }

    public void setOrderId(String value){
        this.orderId = value;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public void setSort(Integer value){
        this.sort = value;
    }

    public Integer getSort(){
        return this.sort;
    }

    public void setStatus(Integer value){
        this.status = value;
    }

    public Integer getStatus(){
        return this.status;
    }

    public void setSellerId(Integer value){
        this.sellerId = value;
    }

    public Integer getSellerId(){
        return this.sellerId;
    }

    public void setSellerSeizeTime(java.util.Date value){
        this.sellerSeizeTime = value;
    }

    public java.util.Date getSellerSeizeTime(){
        return this.sellerSeizeTime;
    }

	public Date getSellerPrepareTime() {
		return sellerPrepareTime;
	}

	public void setSellerPrepareTime(Date sellerPrepareTime) {
		this.sellerPrepareTime = sellerPrepareTime;
	}

	public Date getDelivererReceiveTime() {
		return delivererReceiveTime;
	}

	public void setDelivererReceiveTime(Date delivererReceiveTime) {
		this.delivererReceiveTime = delivererReceiveTime;
	}

}

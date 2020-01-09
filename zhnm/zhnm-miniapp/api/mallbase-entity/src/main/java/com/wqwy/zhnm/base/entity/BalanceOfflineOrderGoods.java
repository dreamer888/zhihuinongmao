/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 18:52:23
 * @author seven
 * @version
 */
//@JsonInclude(value = Include.NON_EMPTY)
public class BalanceOfflineOrderGoods{

    /**
     * 
     */
    private Integer id;

    /**
     * 商品编号
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品单价
     */
    private java.math.BigDecimal goodsPrice;

    /**
     * 商品数量
     */
    private java.math.BigDecimal goodsCount;

    /**
     * 总额
     */
    private java.math.BigDecimal payTotal;

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 排序
     */
    private Integer sort;


    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }

    public void setGoodsId(Integer value){
        this.goodsId = value;
    }

    public Integer getGoodsId(){
        return this.goodsId;
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

    public void setPayTotal(java.math.BigDecimal value){
        this.payTotal = value;
    }

    public java.math.BigDecimal getPayTotal(){
        return this.payTotal;
    }

    public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setSort(Integer value){
        this.sort = value;
    }

    public Integer getSort(){
        return this.sort;
    }

}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 18:51:10
 * @author seven
 * @version
 */
public class SellerGoods{

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer sellerId;

    /**
     * 商品编号
     */
    private Integer goodsId;

    /**
     * 状态：0上架，1下架
     */
    private Integer status;

    /**
     * 初始库存
     */
    private java.math.BigDecimal startStock;

    /**
     * 当前库存
     */
    private java.math.BigDecimal currentStock;

    /**
     * 单价
     */
    private java.math.BigDecimal price;
    
	/**
     * 称快捷键
     */
    private String balanceHotkey;
    
    /**
     * 菜市场id(冗余字段,仅为查询方便)
     */
    private Integer marketId;


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

    public void setGoodsId(Integer value){
        this.goodsId = value;
    }

    public Integer getGoodsId(){
        return this.goodsId;
    }

    public void setStatus(Integer value){
        this.status = value;
    }

    public Integer getStatus(){
        return this.status;
    }

    public void setStartStock(java.math.BigDecimal value){
        this.startStock = value;
    }

    public java.math.BigDecimal getStartStock(){
        return this.startStock;
    }

    public void setCurrentStock(java.math.BigDecimal value){
        this.currentStock = value;
    }

    public java.math.BigDecimal getCurrentStock(){
        return this.currentStock;
    }

    public void setPrice(java.math.BigDecimal value){
        this.price = value;
    }

    public java.math.BigDecimal getPrice(){
        return this.price;
    }

    public void setBalanceHotkey(String value){
        this.balanceHotkey = value;
    }

    public String getBalanceHotkey(){
        return this.balanceHotkey;
    }

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-09 11:52:16
 * @author seven
 * @version
 */
public class ShopGoods{

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
    private String goodsTitle;

    /**
     * 价格
     */
    private java.math.BigDecimal goodsPrice;

    /**
     * 总量
     */
    private Integer goodsNum;

    /**
     * 属性/规格 名称
     */
    private String specName;

    /**
     * 具体内容
     */
    private String specTitle;

    /**
     * 规格对应的价格
     */
    private String specPrice;

    /**
     * 
     */
    private String goodsDetail;

    /**
     * 销量
     */
    private Integer goodsSales;

    /**
     * 
     */
    private Integer sort;

    /**
     * 
     */
    private String categoryId;

    /**
     * 
     */
    private String tuijian;

    /**
     * 是否七天无理由
     */
    private Integer reasonReturn;

    /**
     * 
     */
    private Integer sellCount;


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

    public void setGoodsTitle(String value){
        this.goodsTitle = value;
    }

    public String getGoodsTitle(){
        return this.goodsTitle;
    }

    public void setGoodsPrice(java.math.BigDecimal value){
        this.goodsPrice = value;
    }

    public java.math.BigDecimal getGoodsPrice(){
        return this.goodsPrice;
    }

    public void setGoodsNum(Integer value){
        this.goodsNum = value;
    }

    public Integer getGoodsNum(){
        return this.goodsNum;
    }

    public void setSpecName(String value){
        this.specName = value;
    }

    public String getSpecName(){
        return this.specName;
    }

    public void setSpecTitle(String value){
        this.specTitle = value;
    }

    public String getSpecTitle(){
        return this.specTitle;
    }

    public void setSpecPrice(String value){
        this.specPrice = value;
    }

    public String getSpecPrice(){
        return this.specPrice;
    }

    public void setGoodsDetail(String value){
        this.goodsDetail = value;
    }

    public String getGoodsDetail(){
        return this.goodsDetail;
    }

    public void setGoodsSales(Integer value){
        this.goodsSales = value;
    }

    public Integer getGoodsSales(){
        return this.goodsSales;
    }

    public void setSort(Integer value){
        this.sort = value;
    }

    public Integer getSort(){
        return this.sort;
    }

    public void setCategoryId(String value){
        this.categoryId = value;
    }

    public String getCategoryId(){
        return this.categoryId;
    }

    public void setTuijian(String value){
        this.tuijian = value;
    }

    public String getTuijian(){
        return this.tuijian;
    }

    public void setReasonReturn(Integer value){
        this.reasonReturn = value;
    }

    public Integer getReasonReturn(){
        return this.reasonReturn;
    }

    public void setSellCount(Integer value){
        this.sellCount = value;
    }

    public Integer getSellCount(){
        return this.sellCount;
    }

}

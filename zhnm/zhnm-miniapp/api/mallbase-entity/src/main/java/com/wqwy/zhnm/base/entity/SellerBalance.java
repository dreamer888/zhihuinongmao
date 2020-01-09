/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 18:51:06
 * @author seven
 * @version
 */
public class SellerBalance{

    /**
     * 
     */
    private Integer id;

    /**
     * 商户编号
     */
    private Integer sellerId;

    /**
     * 称id
     */
    private Integer balanceId;


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

    public void setBalanceId(Integer value){
        this.balanceId = value;
    }

    public Integer getBalanceId(){
        return this.balanceId;
    }

}

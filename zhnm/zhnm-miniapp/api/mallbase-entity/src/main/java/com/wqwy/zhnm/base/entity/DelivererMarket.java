/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 18:50:59
 * @author seven
 * @version
 */
public class DelivererMarket{

    /**
     * 
     */
    private Integer id;

    /**
     * 配送员编号
     */
    private Integer delivererId;

    /**
     * 农贸市场编号
     */
    private Integer marketId;


    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }

    public void setDelivererId(Integer value){
        this.delivererId = value;
    }

    public Integer getDelivererId(){
        return this.delivererId;
    }

    public void setMarketId(Integer value){
        this.marketId = value;
    }

    public Integer getMarketId(){
        return this.marketId;
    }

}

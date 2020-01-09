/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.component.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-06-01 10:24:21
 *
 * @author seven
 */
public class DelivererCostView {

    /**
     *
     */
    private String typeId;

    /**
     * 配送员编号
     */
    private Integer delivererId;

    /**
     *
     */
    private Integer status;

    /**
     *
     */
    private java.math.BigDecimal cost;

    /**
     *
     */
    private String type;

    /**
     *
     */
    private String addtime;


    /**
     * 是否为今天
     */
    private Boolean isToday;
    private int query;

    public void setTypeId(String value) {
        this.typeId = value;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public void setDelivererId(Integer value) {
        this.delivererId = value;
    }

    public Integer getDelivererId() {
        return this.delivererId;
    }

    public void setStatus(Integer value) {
        this.status = value;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setCost(java.math.BigDecimal value) {
        this.cost = value;
    }

    public java.math.BigDecimal getCost() {
        return this.cost;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getType() {
        return this.type;
    }

    public void setAddtime(String value) {
        this.addtime = value;
    }

    public String getAddtime() {
        return this.addtime;
    }

    public Boolean getIsToday() {
        return isToday;
    }

    public void setIsToday(Boolean isToday) {
        this.isToday = isToday;
    }

    public int getQuery() {
        return query;
    }

    public void setQuery(int query) {
        this.query = query;
    }
}

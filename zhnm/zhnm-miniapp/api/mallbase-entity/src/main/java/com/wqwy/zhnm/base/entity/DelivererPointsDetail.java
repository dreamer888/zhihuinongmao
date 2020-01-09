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
public class DelivererPointsDetail{

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer delivererId;

    /**
     * 变动积分
     */
    private java.math.BigDecimal pointsChanged;

    /**
     * 变动时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date updateTime;

    /**
     * 变动原因
     */
    private String changedReason;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date createTime;

    /**
     * 审核人
     */
    private String auditor;

    /**
     * 审核时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date auditTime;


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

    public void setPointsChanged(java.math.BigDecimal value){
        this.pointsChanged = value;
    }

    public java.math.BigDecimal getPointsChanged(){
        return this.pointsChanged;
    }

    public void setUpdateTime(java.util.Date value){
        this.updateTime = value;
    }

    public java.util.Date getUpdateTime(){
        return this.updateTime;
    }

    public void setChangedReason(String value){
        this.changedReason = value;
    }

    public String getChangedReason(){
        return this.changedReason;
    }

    public void setOperator(String value){
        this.operator = value;
    }

    public String getOperator(){
        return this.operator;
    }

    public void setCreateTime(java.util.Date value){
        this.createTime = value;
    }

    public java.util.Date getCreateTime(){
        return this.createTime;
    }

    public void setAuditor(String value){
        this.auditor = value;
    }

    public String getAuditor(){
        return this.auditor;
    }

    public void setAuditTime(java.util.Date value){
        this.auditTime = value;
    }

    public java.util.Date getAuditTime(){
        return this.auditTime;
    }

}

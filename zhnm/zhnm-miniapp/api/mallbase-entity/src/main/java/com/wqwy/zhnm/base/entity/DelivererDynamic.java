/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 18:50:58
 * @author seven
 * @version
 */
public class DelivererDynamic{

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer delivererId;

    /**
     * 积分
     */
    private Integer points;

    /**
     * 余额
     */
    private java.math.BigDecimal wallet;

    /**
     * 信用等级(总分)
     */
    private Integer evaluationTotal;
    
    /**
     * 信用等级(评分次数)
     */
    private Integer evaluationCount;


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

    public void setPoints(Integer value){
        this.points = value;
    }

    public Integer getPoints(){
        return this.points;
    }

    public void setWallet(java.math.BigDecimal value){
        this.wallet = value;
    }

    public java.math.BigDecimal getWallet(){
        return this.wallet;
    }

	public Integer getEvaluationTotal() {
		return evaluationTotal;
	}

	public void setEvaluationTotal(Integer evaluationTotal) {
		this.evaluationTotal = evaluationTotal;
	}

	public Integer getEvaluationCount() {
		return evaluationCount;
	}

	public void setEvaluationCount(Integer evaluationCount) {
		this.evaluationCount = evaluationCount;
	}

}

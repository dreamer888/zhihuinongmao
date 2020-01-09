/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 18:51:09
 * @author seven
 * @version
 */
public class SellerDynamic{

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer sellerId;

    /**
     * 信用等级(总分)
     */
    private Integer evaluationTotal;
    
    /**
     * 信用等级(评分次数)
     */
    private Integer evaluationCount;

    /**
     * 商户积分
     */
    private Integer sellerPoints;

    /**
     * 钱包余额
     */
    private java.math.BigDecimal sellerWallet;


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

	public void setSellerPoints(Integer value){
        this.sellerPoints = value;
    }

    public Integer getSellerPoints(){
        return this.sellerPoints;
    }

    public void setSellerWallet(java.math.BigDecimal value){
        this.sellerWallet = value;
    }

    public java.math.BigDecimal getSellerWallet(){
        return this.sellerWallet;
    }

}

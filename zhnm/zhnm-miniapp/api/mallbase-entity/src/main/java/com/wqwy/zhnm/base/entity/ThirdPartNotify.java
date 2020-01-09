/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * createTime: 2018-05-31 15:05:28
 * @author seven
 * @version
 */
public class ThirdPartNotify{

	/**
	 * 
	 * @ClassName: PAYEnum  
	 * @Description: 支付相关enum  
	 * @author seven  
	 * @date 31 May 2018 1:43:40 PM  
	 *
	 */
	public static enum PayEnum {
		// notify type
		WECHAT,
		ALIPAY,
		
		// notify operation type
		QR_PAY
	}
	
    /**
     * 
     */
    private Integer id;

    /**
     * 第三方交易回调商户系统内部订单号
     */
    private String tradeNo;

    /**
     * notify类型
     */
    private PayEnum notifyType;

    /**
     * 操作类型
     */
    private PayEnum operationType;

    /**
     * notify时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date notifyTime;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date createTime;
    
    /**
     * notify状态 1.创建 3.成功 5.失败 (第三方支付notify可能为失败)
     */
    private Integer notifyStatus;


    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }

    public void setTradeNo(String value){
        this.tradeNo = value;
    }

    public String getTradeNo(){
        return this.tradeNo;
    }

    public PayEnum getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(PayEnum notifyType) {
		this.notifyType = notifyType;
	}

	public PayEnum getOperationType() {
		return operationType;
	}

	public void setOperationType(PayEnum operationType) {
		this.operationType = operationType;
	}

	public void setNotifyTime(java.util.Date value){
        this.notifyTime = value;
    }

    public java.util.Date getNotifyTime(){
        return this.notifyTime;
    }

    public void setCreateTime(java.util.Date value){
        this.createTime = value;
    }

    public java.util.Date getCreateTime(){
        return this.createTime;
    }

	public Integer getNotifyStatus() {
		return notifyStatus;
	}

	public void setNotifyStatus(Integer notifyStatus) {
		this.notifyStatus = notifyStatus;
	}

}

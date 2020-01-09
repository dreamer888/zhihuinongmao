/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

/**
 * createTime: 2018-05-08 18:51:01
 * @author zss
 * @version
 */
public class Refund{
    
	/**
     * 
     */
    private String refundId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 详情ID
     */
    private String orderDetailId;

    /**
     * 退款金额
     */
    private String refundPrice;

    /**
     * 退款说明
     */
    private String refundExplain;

    /**
     * 时间
     */
    private String addTime;
    
    /**
     * 状态(0、未处理 1、已处理)
     */
    private int status;
    
    /**
     * 次数
     */
    private int time;
    
    public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getRefundPrice() {
		return refundPrice;
	}

	public void setRefundPrice(String refundPrice) {
		this.refundPrice = refundPrice;
	}

	public String getRefundExplain() {
		return refundExplain;
	}

	public void setRefundExplain(String refundExplain) {
		this.refundExplain = refundExplain;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
    
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
    

}

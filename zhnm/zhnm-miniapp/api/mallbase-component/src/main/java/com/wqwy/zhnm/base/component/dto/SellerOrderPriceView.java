package com.wqwy.zhnm.base.component.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;

public class SellerOrderPriceView {

	/**
	 * 订单id
	 * online -> Integer
	 * offline -> String
	 */
	private String orderId;
	
	/**
	 * 商户id
	 */
	private Integer sellerId;
	
	/**
	 * 总额
	 */
	private BigDecimal totalPrice;
	
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date addtime;
	
	/**
	 * 订单类型 offline or online
	 */
	private DefaultConstants.OrderTypeEnum type;
	
	
	
	/**
	 * 是否为今天
	 */
//	private Boolean isToday;
//	
	
	/**
	 * longpeng写的查询本月本周昨天上月今天
	 * 
	 */
	
	private int query;
	//以上
	public int getQuery() {
		return query;
	}

	public void setQuery(int query) {
		this.query = query;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public DefaultConstants.OrderTypeEnum getType() {
		return type;
	}

	public void setType(DefaultConstants.OrderTypeEnum type) {
		this.type = type;
	}


//	public Boolean getIsToday() {
//		return isToday;
//	}
//
//	public void setIsToday(Boolean isToday) {
//		this.isToday = isToday;
//	}
//	

}

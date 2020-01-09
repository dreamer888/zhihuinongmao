package com.wqwy.zhnm.base.component.dto;

import java.math.BigDecimal;
import java.util.List;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;

/**
 * 
 * @ClassName: OrderDTO  
 * @Description: online order & offline order  
 * @author seven  
 * @date 28 May 2018 1:55:26 PM  
 *
 */
public class OrderDTO {

	/**
	 * 订单编号
	 */
	private String orderNumber;
	
	/**
     * 下单时间
     */
    private String addtime;
    
    /**
     * 订单类型
     */
    private DefaultConstants.OrderTypeEnum orderType;
    
    /**
     * 订单下当前商品的总价格
     */
    private BigDecimal currentGoodsTotalPrice;
    
    /**
     * 支付方式1支付宝2微信3商城币
     */
    private String payWay;
    
    /**
     * 商户id
     */
    private Integer sellerId;
    
    /**
     * 支付状态
     */
    private Integer status;
    
    /**
     * 配送时间
     */
    private String deliveryTimeSlice;
    
    /**
     * 备注
     */
    private String remark;
    
    
    public String getDeliveryTimeSlice() {
		return deliveryTimeSlice;
	}

	public void setDeliveryTimeSlice(String deliveryTimeSlice) {
		this.deliveryTimeSlice = deliveryTimeSlice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
     * 搜索字符串
     * 根据字符串进行搜索
     * 暂时支持: 1.订单编号 2.用户手机号码(仅线下订单)
     */
    private String searchString;
    
    private List<?> orderDetailList;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public DefaultConstants.OrderTypeEnum getOrderType() {
		return orderType;
	}

	public void setOrderType(DefaultConstants.OrderTypeEnum orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getCurrentGoodsTotalPrice() {
		return currentGoodsTotalPrice;
	}

	public void setCurrentGoodsTotalPrice(BigDecimal currentGoodsTotalPrice) {
		this.currentGoodsTotalPrice = currentGoodsTotalPrice;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public List<?> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<?> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

}

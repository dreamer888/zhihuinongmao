package com.wqwy.zhnm.base.component.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wqwy.zhnm.base.component.component.SellerMarketComponent;
import com.wqwy.zhnm.base.component.component.SellerShopOrderDetailComponent;
import com.wqwy.zhnm.base.entity.Market;
import com.wqwy.zhnm.base.entity.Seller;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.entity.ShopUser;

public class ShopOrderDTO extends ShopOrder{

	private Integer sellerId;
	
	/**
     * 已抢单的商户的抢单时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date sellerSeizeTime;
    
    private List<ShopOrderDetail> shopOrderDetailList;
    
    private List<ShopOrderDetailDTO> shopOrderDetailDTOList;

    /**
     * 是否近查询当天数据
     */
    private Boolean isToday;
    
    /**
     * 订单下当前商品的总价格
     */
    private BigDecimal currentGoodsTotalPrice;
    
    /**
     * 配送人员名称
     */
    private String delivererName;
    
    /**
     * 配送人员手机号码
     */
    private String delivererPhone;
    
    private String errorMessage;
    
    /**
     * 订单下单人信息
     */
    private ShopUser shopUser;
    
    /**
     * 订单商户含商户market信息列表
     */
    private Set<SellerMarketComponent> smcSet;
    
    /**
     * 商户基本信息 和 商户订单商品列表 列表
     */
    private Set<SellerShopOrderDetailComponent> ssodcSet;
    
    /**
     * 搜索字符串
     */
    private String searchString;
    
    /**
     * 推单时间
     */
    private Long pushTime;
    
	
	public Long getPushTime() {
		return pushTime;
	}

	public void setPushTime(Long pushTime) {
		this.pushTime = pushTime;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public java.util.Date getSellerSeizeTime() {
		return sellerSeizeTime;
	}

	public void setSellerSeizeTime(java.util.Date sellerSeizeTime) {
		this.sellerSeizeTime = sellerSeizeTime;
	}

	public List<ShopOrderDetail> getShopOrderDetailList() {
		return shopOrderDetailList;
	}

	public void setShopOrderDetailList(List<ShopOrderDetail> shopOrderDetailList) {
		this.shopOrderDetailList = shopOrderDetailList;
	}

	public List<ShopOrderDetailDTO> getShopOrderDetailDTOList() {
		return shopOrderDetailDTOList;
	}

	public void setShopOrderDetailDTOList(List<ShopOrderDetailDTO> shopOrderDetailDTOList) {
		this.shopOrderDetailDTOList = shopOrderDetailDTOList;
	}

	public Boolean getIsToday() {
		return isToday;
	}

	public void setIsToday(Boolean isToday) {
		this.isToday = isToday;
	}

	public BigDecimal getCurrentGoodsTotalPrice() {
		return currentGoodsTotalPrice;
	}

	public void setCurrentGoodsTotalPrice(BigDecimal currentGoodsTotalPrice) {
		this.currentGoodsTotalPrice = currentGoodsTotalPrice;
	}

	public String getDelivererName() {
		return delivererName;
	}

	public void setDelivererName(String delivererName) {
		this.delivererName = delivererName;
	}

	public String getDelivererPhone() {
		return delivererPhone;
	}

	public void setDelivererPhone(String delivererPhone) {
		this.delivererPhone = delivererPhone;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ShopUser getShopUser() {
		return shopUser;
	}

	public void setShopUser(ShopUser shopUser) {
		this.shopUser = shopUser;
	}

	public Set<SellerMarketComponent> getSmcSet() {
		return smcSet;
	}

	public void setSmcSet(Set<SellerMarketComponent> smcSet) {
		this.smcSet = smcSet;
	}

	public Set<SellerShopOrderDetailComponent> getSsodcSet() {
		return ssodcSet;
	}

	public void setSsodcSet(Set<SellerShopOrderDetailComponent> ssodcSet) {
		this.ssodcSet = ssodcSet;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
}

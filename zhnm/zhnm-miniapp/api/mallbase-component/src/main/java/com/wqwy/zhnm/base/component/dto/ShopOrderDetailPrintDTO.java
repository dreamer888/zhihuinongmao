package com.wqwy.zhnm.base.component.dto;

import java.math.BigDecimal;

public class ShopOrderDetailPrintDTO{

	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品单价
	 */
	private BigDecimal goodsPrice;
	
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	/**
	 * 商品重量
	 */
	private BigDecimal goodsCount;
	
	/**
	 * 一种商品总价
	 */
	private BigDecimal totalPrice;
	
	
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	public BigDecimal getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(BigDecimal goodsCount) {
		this.goodsCount = goodsCount;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}

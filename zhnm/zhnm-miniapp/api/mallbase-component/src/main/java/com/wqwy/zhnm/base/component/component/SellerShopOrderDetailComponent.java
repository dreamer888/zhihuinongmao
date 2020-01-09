package com.wqwy.zhnm.base.component.component;

import java.math.BigDecimal;
import java.util.List;

import com.wqwy.zhnm.base.entity.ShopOrderDetail;

public class SellerShopOrderDetailComponent extends SellerMarketComponent {

	private BigDecimal totalPrice;
	
	private List<ShopOrderDetail> sodList;

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<ShopOrderDetail> getSodList() {
		return sodList;
	}

	public void setSodList(List<ShopOrderDetail> sodList) {
		this.sodList = sodList;
	}
	
}

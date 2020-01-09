package com.wqwy.zhnm.base.component.request;

import java.util.List;

import com.wqwy.zhnm.base.entity.ShopOrderDetail;

public class SellerPreemptRequest {

	private List<ShopOrderDetail> shopOrderDetailList;

	public List<ShopOrderDetail> getShopOrderDetailList() {
		return shopOrderDetailList;
	}

	public void setShopOrderDetailList(List<ShopOrderDetail> shopOrderDetailList) {
		this.shopOrderDetailList = shopOrderDetailList;
	}
	
}

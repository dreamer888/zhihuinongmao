package com.wqwy.zhnm.base.component.component;

import com.wqwy.zhnm.base.entity.ShopOrderDetail;

public class ShopOrderDetailWithGoodsComponent extends ShopOrderDetail {
	
	private String goodsName;
	
	private String specName;
	
	private String specTitle;
	
	private String specPrice;

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSpecTitle() {
		return specTitle;
	}

	public void setSpecTitle(String specTitle) {
		this.specTitle = specTitle;
	}

	public String getSpecPrice() {
		return specPrice;
	}

	public void setSpecPrice(String specPrice) {
		this.specPrice = specPrice;
	}

}

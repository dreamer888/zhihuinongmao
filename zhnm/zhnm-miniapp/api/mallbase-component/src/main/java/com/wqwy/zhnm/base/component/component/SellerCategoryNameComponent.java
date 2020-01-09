package com.wqwy.zhnm.base.component.component;

import com.wqwy.zhnm.base.entity.Seller;

public class SellerCategoryNameComponent extends Seller {

	//商户品类名称
	private String categoryName;
	
	//商户所属菜市场名称
	private String marketName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	
}

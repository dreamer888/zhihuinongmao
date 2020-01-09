package com.wqwy.zhnm.base.component.dto;

import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.entity.ShopGoods;

public class ShopGoodsDTO extends ShopGoods {

	private Integer sellerId;
	
//	private Boolean hasThisGoods;
	
	private SellerGoods sellerGoods;
	
	private String searchGoodsName;

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public SellerGoods getSellerGoods() {
		return sellerGoods;
	}

	public void setSellerGoods(SellerGoods sellerGoods) {
		this.sellerGoods = sellerGoods;
	}

	public String getSearchGoodsName() {
		return searchGoodsName;
	}

	public void setSearchGoodsName(String searchGoodsName) {
		this.searchGoodsName = searchGoodsName;
	}

//	public Boolean getHasThisGoods() {
//		return hasThisGoods;
//	}
//
//	public void setHasThisGoods(Boolean hasThisGoods) {
//		this.hasThisGoods = hasThisGoods;
//	}
	
}

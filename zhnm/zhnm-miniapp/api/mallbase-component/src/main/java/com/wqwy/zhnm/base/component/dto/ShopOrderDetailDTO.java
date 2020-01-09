package com.wqwy.zhnm.base.component.dto;

import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;

public class ShopOrderDetailDTO extends ShopOrderDetail {

	/**
	 * 待抢单(待发送消息)的商户的id
	 */
	private Integer preSellerId;
	
	private Integer marketId;
	
	/**
	 * 待抢单的商户的商品的状态
	 */
	private Integer preSellerGoodsStatus;
	
	private SellerGoods sellerGoods;

	public Integer getPreSellerId() {
		return preSellerId;
	}

	public void setPreSellerId(Integer preSellerId) {
		this.preSellerId = preSellerId;
	}

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public SellerGoods getSellerGoods() {
		return sellerGoods;
	}

	public void setSellerGoods(SellerGoods sellerGoods) {
		this.sellerGoods = sellerGoods;
	}

	public Integer getPreSellerGoodsStatus() {
		return preSellerGoodsStatus;
	}

	public void setPreSellerGoodsStatus(Integer preSellerGoodsStatus) {
		this.preSellerGoodsStatus = preSellerGoodsStatus;
	}
	
}

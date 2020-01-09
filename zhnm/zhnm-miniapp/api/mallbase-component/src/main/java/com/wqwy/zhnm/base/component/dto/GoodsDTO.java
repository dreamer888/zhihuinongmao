package com.wqwy.zhnm.base.component.dto;

import java.math.BigDecimal;

public class GoodsDTO{

    /**
     * 市场Id
     */
    private Integer marketId;
    
    /**
     * 商品Id
     */
    private Integer goodsId;
    
	/**
     * 市场的一种商品库存
     */
    private BigDecimal currentStock;
    
	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}
		
	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public BigDecimal getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(BigDecimal currentStock) {
		this.currentStock = currentStock;
	}
}

package com.wqwy.zhnm.base.component.component;

import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.entity.ShopGoods;

public class SellerGoodsComponent extends SellerGoods {

	private ShopGoods shopGoods;
	
	  /**
     * 称更改前的快捷键
     */
    private String oldBalanceHotkey;

    public String getOldBalanceHotkey() {
		return oldBalanceHotkey;
	}

	public void setOldBalanceHotkey(String oldBalanceHotkey) {
		this.oldBalanceHotkey = oldBalanceHotkey;
	}

	public ShopGoods getShopGoods() {
		return shopGoods;
	}

	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}
	
}

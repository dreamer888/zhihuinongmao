package com.wqwy.zhnm.base.component.component;

import java.math.BigDecimal;
import java.util.List;

import com.wqwy.zhnm.base.component.dto.SellerOrderPriceView;

public class SellerOrderPriceViewComponent{

	private BigDecimal totalPrice;
	
	private List<SellerOrderPriceView> sopvList;

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<SellerOrderPriceView> getSopvList() {
		return sopvList;
	}

	public void setSopvList(List<SellerOrderPriceView> sopvList) {
		this.sopvList = sopvList;
	}
	
}

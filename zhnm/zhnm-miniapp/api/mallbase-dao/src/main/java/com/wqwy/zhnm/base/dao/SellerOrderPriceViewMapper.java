package com.wqwy.zhnm.base.dao;

import java.math.BigDecimal;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.dto.SellerOrderPriceView;

public interface SellerOrderPriceViewMapper {

	public Page<SellerOrderPriceView> findListByPage(SellerOrderPriceView sellerOrderPriceView);
	
	public BigDecimal getTotalPrice(SellerOrderPriceView sellerOrderPriceView);
	
}

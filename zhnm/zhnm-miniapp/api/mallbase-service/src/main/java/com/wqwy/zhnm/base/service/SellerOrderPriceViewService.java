package com.wqwy.zhnm.base.service;

import java.math.BigDecimal;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.SellerOrderPriceView;

public interface SellerOrderPriceViewService {

	public Page<SellerOrderPriceView> findListByPage(SellerOrderPriceView sellerOrderPriceView, Pagenation pagenation);
	
	public BigDecimal getTotalPrice(SellerOrderPriceView sellerOrderPriceView);
	
}

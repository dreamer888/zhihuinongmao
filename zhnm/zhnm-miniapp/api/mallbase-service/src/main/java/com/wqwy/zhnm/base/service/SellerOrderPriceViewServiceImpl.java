package com.wqwy.zhnm.base.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.SellerOrderPriceView;
import com.wqwy.zhnm.base.dao.SellerOrderPriceViewMapper;

@Service
public class SellerOrderPriceViewServiceImpl implements SellerOrderPriceViewService {
	
	@Autowired
	private SellerOrderPriceViewMapper sellerOrderPriceViewMapper;

	@Override
	public Page<SellerOrderPriceView> findListByPage(SellerOrderPriceView sellerOrderPriceView, Pagenation pagenation) {
		PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return sellerOrderPriceViewMapper.findListByPage(sellerOrderPriceView);
	}

	@Override
	public BigDecimal getTotalPrice(SellerOrderPriceView sellerOrderPriceView) {
		return sellerOrderPriceViewMapper.getTotalPrice(sellerOrderPriceView);
	}

}

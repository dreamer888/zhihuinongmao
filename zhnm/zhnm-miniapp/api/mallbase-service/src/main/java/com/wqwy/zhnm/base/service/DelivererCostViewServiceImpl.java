/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.DelivererCostView;
import com.wqwy.zhnm.base.component.dto.SellerOrderPriceView;
import com.wqwy.zhnm.base.dao.DelivererCostViewMapper;

/**
 * createTime: 2018-06-01 10:24:21
 * @author seven
 * @version
 */
@Service
public class DelivererCostViewServiceImpl implements DelivererCostViewService {

    @Autowired
    private DelivererCostViewMapper delivererCostViewMapper;

    private static final Logger logger = LoggerFactory.getLogger(DelivererCostViewServiceImpl.class);

    @Override
    public DelivererCostView get(String typeId) {
        return delivererCostViewMapper.get(typeId);
    }

    @Override
	public Integer getCountByCondition(DelivererCostView delivererCostViewComponent ) {
    	return delivererCostViewMapper.getCountByCondition(delivererCostViewComponent);
	}
	
    @Override
    public List<DelivererCostView> findList(DelivererCostView delivererCostViewComponent) {
        return delivererCostViewMapper.findList(delivererCostViewComponent);
    }

    @Override
    public Page<DelivererCostView> findListByPage(DelivererCostView delivererCostViewComponent, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return delivererCostViewMapper.findListByPage(delivererCostViewComponent);
    }
    
    @Override
	public BigDecimal getTotalPrice(DelivererCostView delivererCostView) {
		return delivererCostViewMapper.getTotalPrice(delivererCostView);
	}
    
}

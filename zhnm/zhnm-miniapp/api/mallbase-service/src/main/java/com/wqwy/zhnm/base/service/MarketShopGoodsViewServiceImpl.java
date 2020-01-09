/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.MarketShopGoodsView;
import com.wqwy.zhnm.base.dao.MarketShopGoodsViewMapper;

/**
 * createTime: 2018-06-09 11:24:07
 * @author seven
 * @version
 */
@Service
public class MarketShopGoodsViewServiceImpl implements MarketShopGoodsViewService {

    @Autowired
    private MarketShopGoodsViewMapper marketShopGoodsViewMapper;

    private static final Logger logger = LoggerFactory.getLogger(MarketShopGoodsViewServiceImpl.class);

    @Override
	public Integer getCountByCondition(MarketShopGoodsView marketShopGoodsView ) {
    	return marketShopGoodsViewMapper.getCountByCondition(marketShopGoodsView);
	}
	
    @Override
    public List<MarketShopGoodsView> findList(MarketShopGoodsView marketShopGoodsView) {
        return marketShopGoodsViewMapper.findList(marketShopGoodsView);
    }

    @Override
    public Page<MarketShopGoodsView> findListByPage(MarketShopGoodsView marketShopGoodsView, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return marketShopGoodsViewMapper.findListByPage(marketShopGoodsView);
    }

}

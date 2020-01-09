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
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.dao.SellerGoodsMapper;
import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.service.SellerGoodsService;

/**
 * createTime: 2018-05-08 18:51:10
 * @author seven
 * @version
 */
@Service
public class SellerGoodsServiceImpl implements SellerGoodsService {

    @Autowired
    private SellerGoodsMapper sellerGoodsMapper;

    private static final Logger logger = LoggerFactory.getLogger(SellerGoodsServiceImpl.class);

    @Override
    public SellerGoods get(String id) {
        return sellerGoodsMapper.get(id);
    }

    @Override
	public Integer getCountByCondition(SellerGoods sellerGoods ) {
    	return sellerGoodsMapper.getCountByCondition(sellerGoods);
	}
    
    @Override
    public List<SellerGoods> findList(SellerGoods sellerGoods) {
        return sellerGoodsMapper.findList(sellerGoods);
    }

    @Override
    public Page<SellerGoods> findListByPage(SellerGoods sellerGoods, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return sellerGoodsMapper.findListByPage(sellerGoods);
    }

    @Override
    public Integer insert(SellerGoods sellerGoods) {
//        sellerGoods.setCreateTime(new Date());
    	SellerGoods sgForSearch = new SellerGoods();
    	sgForSearch.setSellerId(sellerGoods.getSellerId());
    	sgForSearch.setGoodsId(sellerGoods.getGoodsId());
    	List<SellerGoods> sgList = sellerGoodsMapper.findList(sgForSearch);
    	if (sgList!=null && !sgList.isEmpty())
    		throw new BusinessException(ResultUtils.DUPLICATE_ENTRY_SELLER_GOOD, ResultUtils.DUPLICATE_ENTRY_SELLER_GOOD_MSG);
        return sellerGoodsMapper.insert(sellerGoods);
    }

    @Override
    public Integer update(SellerGoods sellerGoods) {
//        sellerGoods.setUpdateTime(new Date());
        return sellerGoodsMapper.update(sellerGoods);
    }

    @Override
    public Integer updateAllStock(SellerGoods sellerGoods) {
    	return sellerGoodsMapper.updateAllStock(sellerGoods);
    }
    
    @Override
    public Integer delete(String id) {
        return sellerGoodsMapper.delete(id);
    }
}

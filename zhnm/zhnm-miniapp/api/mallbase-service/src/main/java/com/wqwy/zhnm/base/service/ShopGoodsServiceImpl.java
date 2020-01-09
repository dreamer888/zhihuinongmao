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
import com.wqwy.zhnm.base.component.dto.ShopGoodsDTO;
import com.wqwy.zhnm.base.dao.ShopGoodsMapper;
import com.wqwy.zhnm.base.entity.ShopGoods;

/**
 * createTime: 2018-05-09 11:52:16
 * @author seven
 * @version
 */
@Service
public class ShopGoodsServiceImpl implements ShopGoodsService {

    @Autowired
    private ShopGoodsMapper shopGoodsMapper;

    private static final Logger logger = LoggerFactory.getLogger(ShopGoodsServiceImpl.class);

    @Override
    public ShopGoods get(String goodsId) {
        return shopGoodsMapper.get(goodsId);
    }

    @Override
	public Integer getCountByCondition(ShopGoods shopGoods ) {
    	return shopGoodsMapper.getCountByCondition(shopGoods);
	}
    
    @Override
    public List<ShopGoods> findList(ShopGoods shopGoods) {
        return shopGoodsMapper.findList(shopGoods);
    }

    @Override
    public Page<ShopGoods> findListByPage(ShopGoodsDTO shopGoods, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return shopGoodsMapper.findListByPage(shopGoods);
    }

    @Override
    public Integer insert(ShopGoods shopGoods) {
//        shopGoods.setCreateTime(new Date());
        return shopGoodsMapper.insert(shopGoods);
    }

    @Override
    public Integer update(ShopGoods shopGoods) {
//        shopGoods.setUpdateTime(new Date());
        return shopGoodsMapper.update(shopGoods);
    }

    @Override
    public Integer delete(String goodsId) {
        return shopGoodsMapper.delete(goodsId);
    }
}

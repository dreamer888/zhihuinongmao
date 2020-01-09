/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.wqwy.zhnm.base.dao.BalanceOfflineOrderGoodsMapper;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrderGoods;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderGoodsDTO;
import com.wqwy.zhnm.base.service.BalanceOfflineOrderGoodsService;

/**
 * createTime: 2018-05-08 18:52:23
 * @author seven
 * @version
 */
@Service
public class BalanceOfflineOrderGoodsServiceImpl implements BalanceOfflineOrderGoodsService {

    @Autowired
    private BalanceOfflineOrderGoodsMapper balanceOfflineOrderGoodsMapper;

    private static final Logger logger = LoggerFactory.getLogger(BalanceOfflineOrderGoodsServiceImpl.class);

    @Override
    public BalanceOfflineOrderGoods get(String id) {
        return balanceOfflineOrderGoodsMapper.get(id);
    }

    @Override
    public List<BalanceOfflineOrderGoods> findList(BalanceOfflineOrderGoods balanceOfflineOrderGoods) {
        return balanceOfflineOrderGoodsMapper.findList(balanceOfflineOrderGoods);
    }
    
    public List<BalanceOfflineOrderGoodsDTO> findListSpecial(BalanceOfflineOrderGoodsDTO balanceOfflineOrderGoods) {
    	return balanceOfflineOrderGoodsMapper.findListSpecial(balanceOfflineOrderGoods);
    }

    @Override
    public Page<BalanceOfflineOrderGoods> findListByPage(BalanceOfflineOrderGoods balanceOfflineOrderGoods, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return balanceOfflineOrderGoodsMapper.findListByPage(balanceOfflineOrderGoods);
    }

    @Override
    public Integer insert(BalanceOfflineOrderGoods balanceOfflineOrderGoods) {
//        balanceOfflineOrderGoods.setCreateTime(new Date());
        return balanceOfflineOrderGoodsMapper.insert(balanceOfflineOrderGoods);
    }

    @Override
    public Integer update(BalanceOfflineOrderGoods balanceOfflineOrderGoods) {
//        balanceOfflineOrderGoods.setUpdateTime(new Date());
        return balanceOfflineOrderGoodsMapper.update(balanceOfflineOrderGoods);
    }

    @Override
    public Integer delete(String id) {
        return balanceOfflineOrderGoodsMapper.delete(id);
    }
}

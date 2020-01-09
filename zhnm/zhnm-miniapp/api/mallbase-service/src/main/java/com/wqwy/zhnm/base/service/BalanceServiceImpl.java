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

import com.wqwy.zhnm.base.dao.BalanceMapper;
import com.wqwy.zhnm.base.entity.Balance;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.BalanceService;

/**
 * createTime: 2018-05-08 17:47:07
 * @author seven
 * @version
 */
@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceMapper balanceMapper;

    private static final Logger logger = LoggerFactory.getLogger(BalanceServiceImpl.class);

    @Override
    public Balance get(String id) {
        return balanceMapper.get(id);
    }

    @Override
    public List<Balance> findList(Balance balance) {
        return balanceMapper.findList(balance);
    }

    @Override
    public Page<Balance> findListByPage(Balance balance, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        logger.info("balance : " + balance.toString());
        return balanceMapper.findListByPage(balance);
    }

    @Override
    public Integer insert(Balance balance) {
//        balance.setCreateTime(new Date());
        return balanceMapper.insert(balance);
    }

    @Override
    public Integer update(Balance balance) {
//        balance.setUpdateTime(new Date());
        return balanceMapper.update(balance);
    }

    @Override
    public Integer delete(String id) {
        return balanceMapper.delete(id);
    }
}

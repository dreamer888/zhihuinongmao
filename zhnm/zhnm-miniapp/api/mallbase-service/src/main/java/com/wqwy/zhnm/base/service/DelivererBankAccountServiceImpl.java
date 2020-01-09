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

import com.wqwy.zhnm.base.dao.DelivererBankAccountMapper;
import com.wqwy.zhnm.base.entity.DelivererBankAccount;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.DelivererBankAccountService;

/**
 * createTime: 2018-05-08 18:50:57
 * @author seven
 * @version
 */
@Service
public class DelivererBankAccountServiceImpl implements DelivererBankAccountService {

    @Autowired
    private DelivererBankAccountMapper delivererBankAccountMapper;

    private static final Logger logger = LoggerFactory.getLogger(DelivererBankAccountServiceImpl.class);

    @Override
    public DelivererBankAccount get(String id) {
        return delivererBankAccountMapper.get(id);
    }

    @Override
    public List<DelivererBankAccount> findList(DelivererBankAccount delivererBankAccount) {
        return delivererBankAccountMapper.findList(delivererBankAccount);
    }

    @Override
    public Page<DelivererBankAccount> findListByPage(DelivererBankAccount delivererBankAccount, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return delivererBankAccountMapper.findListByPage(delivererBankAccount);
    }

    @Override
    public Integer insert(DelivererBankAccount delivererBankAccount) {
//        delivererBankAccount.setCreateTime(new Date());
        return delivererBankAccountMapper.insert(delivererBankAccount);
    }

    @Override
    public Integer update(DelivererBankAccount delivererBankAccount) {
//        delivererBankAccount.setUpdateTime(new Date());
        return delivererBankAccountMapper.update(delivererBankAccount);
    }

    @Override
    public Integer delete(String id) {
        return delivererBankAccountMapper.delete(id);
    }
}

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

import com.wqwy.zhnm.base.dao.SellerBankAccountMapper;
import com.wqwy.zhnm.base.entity.SellerBankAccount;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.SellerBankAccountService;

/**
 * createTime: 2018-05-08 18:51:07
 * @author seven
 * @version
 */
@Service
public class SellerBankAccountServiceImpl implements SellerBankAccountService {

    @Autowired
    private SellerBankAccountMapper sellerBankAccountMapper;

    private static final Logger logger = LoggerFactory.getLogger(SellerBankAccountServiceImpl.class);

    @Override
    public SellerBankAccount get(String id) {
        return sellerBankAccountMapper.get(id);
    }

    @Override
    public List<SellerBankAccount> findList(SellerBankAccount sellerBankAccount) {
        return sellerBankAccountMapper.findList(sellerBankAccount);
    }

    @Override
    public Page<SellerBankAccount> findListByPage(SellerBankAccount sellerBankAccount, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return sellerBankAccountMapper.findListByPage(sellerBankAccount);
    }

    @Override
    public Integer insert(SellerBankAccount sellerBankAccount) {
//        sellerBankAccount.setCreateTime(new Date());
        return sellerBankAccountMapper.insert(sellerBankAccount);
    }

    @Override
    public Integer update(SellerBankAccount sellerBankAccount) {
//        sellerBankAccount.setUpdateTime(new Date());
        return sellerBankAccountMapper.update(sellerBankAccount);
    }

    @Override
    public Integer delete(String id) {
        return sellerBankAccountMapper.delete(id);
    }
}

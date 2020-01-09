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

import com.wqwy.zhnm.base.dao.SellerBalanceMapper;
import com.wqwy.zhnm.base.entity.SellerBalance;
import com.wqwy.zhnm.base.entity.SellerBankAccount;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.SellerBalanceService;

/**
 * createTime: 2018-05-08 18:51:06
 * @author seven
 * @version
 */
@Service
public class SellerBalanceServiceImpl implements SellerBalanceService {

    @Autowired
    private SellerBalanceMapper sellerBalanceMapper;

    private static final Logger logger = LoggerFactory.getLogger(SellerBalanceServiceImpl.class);

    @Override
    public SellerBalance get(String id) {
        return sellerBalanceMapper.get(id);
    }

    @Override
    public List<SellerBalance> findList(SellerBalance sellerBalance) {
        return sellerBalanceMapper.findList(sellerBalance);
    }

    @Override
    public Page<SellerBalance> findListByPage(SellerBalance sellerBalance, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return sellerBalanceMapper.findListByPage(sellerBalance);
    }

    @Override
    public Integer insert(SellerBalance sellerBalance) {
//        sellerBalance.setCreateTime(new Date());
        return sellerBalanceMapper.insert(sellerBalance);
    }

    @Override
    public Integer update(SellerBalance sellerBalance) {
//        sellerBalance.setUpdateTime(new Date());
        return sellerBalanceMapper.update(sellerBalance);
    }

    @Override
    public Integer delete(String id) {
        return sellerBalanceMapper.delete(id);
    }

	@Override
	public SellerBalance findByMerchantId(SellerBankAccount account) {
		return sellerBalanceMapper.findByMerchantId(account);
	}
}

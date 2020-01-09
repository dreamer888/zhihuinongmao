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

import com.wqwy.zhnm.base.dao.SellerWalletDetailMapper;
import com.wqwy.zhnm.base.entity.SellerWalletDetail;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.SellerWalletDetailService;

/**
 * createTime: 2018-05-08 18:51:12
 * @author seven
 * @version
 */
@Service
public class SellerWalletDetailServiceImpl implements SellerWalletDetailService {

    @Autowired
    private SellerWalletDetailMapper sellerWalletDetailMapper;

    private static final Logger logger = LoggerFactory.getLogger(SellerWalletDetailServiceImpl.class);

    @Override
    public SellerWalletDetail get(String id) {
        return sellerWalletDetailMapper.get(id);
    }

    @Override
    public List<SellerWalletDetail> findList(SellerWalletDetail sellerWalletDetail) {
        return sellerWalletDetailMapper.findList(sellerWalletDetail);
    }

    @Override
    public Page<SellerWalletDetail> findListByPage(SellerWalletDetail sellerWalletDetail, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return sellerWalletDetailMapper.findListByPage(sellerWalletDetail);
    }

    @Override
    public Integer insert(SellerWalletDetail sellerWalletDetail) {
        sellerWalletDetail.setCreateTime(new Date());
        return sellerWalletDetailMapper.insert(sellerWalletDetail);
    }

    @Override
    public Integer update(SellerWalletDetail sellerWalletDetail) {
        sellerWalletDetail.setUpdateTime(new Date());
        return sellerWalletDetailMapper.update(sellerWalletDetail);
    }

    @Override
    public Integer delete(String id) {
        return sellerWalletDetailMapper.delete(id);
    }
}

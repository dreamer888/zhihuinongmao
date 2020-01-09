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

import com.wqwy.zhnm.base.dao.SellerDynamicMapper;
import com.wqwy.zhnm.base.entity.SellerDynamic;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.SellerDynamicService;

/**
 * createTime: 2018-05-08 18:51:09
 * @author seven
 * @version
 */
@Service
public class SellerDynamicServiceImpl implements SellerDynamicService {

    @Autowired
    private SellerDynamicMapper sellerDynamicMapper;

    private static final Logger logger = LoggerFactory.getLogger(SellerDynamicServiceImpl.class);

    @Override
    public SellerDynamic get(String id) {
        return sellerDynamicMapper.get(id);
    }

    @Override
    public List<SellerDynamic> findList(SellerDynamic sellerDynamic) {
        return sellerDynamicMapper.findList(sellerDynamic);
    }

    @Override
    public Page<SellerDynamic> findListByPage(SellerDynamic sellerDynamic, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return sellerDynamicMapper.findListByPage(sellerDynamic);
    }

    @Override
    public Integer insert(SellerDynamic sellerDynamic) {
//        sellerDynamic.setCreateTime(new Date());
        return sellerDynamicMapper.insert(sellerDynamic);
    }

    @Override
    public Integer update(SellerDynamic sellerDynamic) {
//        sellerDynamic.setUpdateTime(new Date());
        return sellerDynamicMapper.update(sellerDynamic);
    }

    @Override
    public Integer delete(String id) {
        return sellerDynamicMapper.delete(id);
    }
}

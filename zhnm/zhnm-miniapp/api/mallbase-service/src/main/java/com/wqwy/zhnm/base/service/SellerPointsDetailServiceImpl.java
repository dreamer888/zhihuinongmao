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

import com.wqwy.zhnm.base.dao.SellerPointsDetailMapper;
import com.wqwy.zhnm.base.entity.SellerPointsDetail;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.SellerPointsDetailService;

/**
 * createTime: 2018-05-08 18:51:11
 * @author seven
 * @version
 */
@Service
public class SellerPointsDetailServiceImpl implements SellerPointsDetailService {

    @Autowired
    private SellerPointsDetailMapper sellerPointsDetailMapper;

    private static final Logger logger = LoggerFactory.getLogger(SellerPointsDetailServiceImpl.class);

    @Override
    public SellerPointsDetail get(String id) {
        return sellerPointsDetailMapper.get(id);
    }

    @Override
    public List<SellerPointsDetail> findList(SellerPointsDetail sellerPointsDetail) {
        return sellerPointsDetailMapper.findList(sellerPointsDetail);
    }

    @Override
    public Page<SellerPointsDetail> findListByPage(SellerPointsDetail sellerPointsDetail, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return sellerPointsDetailMapper.findListByPage(sellerPointsDetail);
    }

    @Override
    public Integer insert(SellerPointsDetail sellerPointsDetail) {
        sellerPointsDetail.setCreateTime(new Date());
        return sellerPointsDetailMapper.insert(sellerPointsDetail);
    }

    @Override
    public Integer update(SellerPointsDetail sellerPointsDetail) {
        sellerPointsDetail.setUpdateTime(new Date());
        return sellerPointsDetailMapper.update(sellerPointsDetail);
    }

    @Override
    public Integer delete(String id) {
        return sellerPointsDetailMapper.delete(id);
    }
}

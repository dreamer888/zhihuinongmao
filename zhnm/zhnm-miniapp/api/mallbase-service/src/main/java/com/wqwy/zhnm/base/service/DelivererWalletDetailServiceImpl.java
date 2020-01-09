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

import com.wqwy.zhnm.base.dao.DelivererWalletDetailMapper;
import com.wqwy.zhnm.base.entity.DelivererWalletDetail;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.DelivererWalletDetailService;

/**
 * createTime: 2018-05-08 18:51:00
 * @author seven
 * @version
 */
@Service
public class DelivererWalletDetailServiceImpl implements DelivererWalletDetailService {

    @Autowired
    private DelivererWalletDetailMapper delivererWalletDetailMapper;

    private static final Logger logger = LoggerFactory.getLogger(DelivererWalletDetailServiceImpl.class);

    @Override
    public DelivererWalletDetail get(String id) {
        return delivererWalletDetailMapper.get(id);
    }

    @Override
    public List<DelivererWalletDetail> findList(DelivererWalletDetail delivererWalletDetail) {
        return delivererWalletDetailMapper.findList(delivererWalletDetail);
    }

    @Override
    public Page<DelivererWalletDetail> findListByPage(DelivererWalletDetail delivererWalletDetail, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return delivererWalletDetailMapper.findListByPage(delivererWalletDetail);
    }

    @Override
    public Integer insert(DelivererWalletDetail delivererWalletDetail) {
        delivererWalletDetail.setCreateTime(new Date());
        return delivererWalletDetailMapper.insert(delivererWalletDetail);
    }

    @Override
    public Integer update(DelivererWalletDetail delivererWalletDetail) {
        delivererWalletDetail.setUpdateTime(new Date());
        return delivererWalletDetailMapper.update(delivererWalletDetail);
    }

    @Override
    public Integer delete(String id) {
        return delivererWalletDetailMapper.delete(id);
    }
}

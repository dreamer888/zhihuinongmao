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

import com.wqwy.zhnm.base.dao.DelivererPointsDetailMapper;
import com.wqwy.zhnm.base.entity.DelivererPointsDetail;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.DelivererPointsDetailService;

/**
 * createTime: 2018-05-08 18:50:59
 * @author seven
 * @version
 */
@Service
public class DelivererPointsDetailServiceImpl implements DelivererPointsDetailService {

    @Autowired
    private DelivererPointsDetailMapper delivererPointsDetailMapper;

    private static final Logger logger = LoggerFactory.getLogger(DelivererPointsDetailServiceImpl.class);

    @Override
    public DelivererPointsDetail get(String id) {
        return delivererPointsDetailMapper.get(id);
    }

    @Override
    public List<DelivererPointsDetail> findList(DelivererPointsDetail delivererPointsDetail) {
        return delivererPointsDetailMapper.findList(delivererPointsDetail);
    }

    @Override
    public Page<DelivererPointsDetail> findListByPage(DelivererPointsDetail delivererPointsDetail, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return delivererPointsDetailMapper.findListByPage(delivererPointsDetail);
    }

    @Override
    public Integer insert(DelivererPointsDetail delivererPointsDetail) {
        delivererPointsDetail.setCreateTime(new Date());
        return delivererPointsDetailMapper.insert(delivererPointsDetail);
    }

    @Override
    public Integer update(DelivererPointsDetail delivererPointsDetail) {
        delivererPointsDetail.setUpdateTime(new Date());
        return delivererPointsDetailMapper.update(delivererPointsDetail);
    }

    @Override
    public Integer delete(String id) {
        return delivererPointsDetailMapper.delete(id);
    }
}

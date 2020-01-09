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

import com.wqwy.zhnm.base.dao.DelivererDynamicMapper;
import com.wqwy.zhnm.base.entity.DelivererDynamic;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.DelivererDynamicService;

/**
 * createTime: 2018-05-08 18:50:58
 * @author seven
 * @version
 */
@Service
public class DelivererDynamicServiceImpl implements DelivererDynamicService {

    @Autowired
    private DelivererDynamicMapper delivererDynamicMapper;

    private static final Logger logger = LoggerFactory.getLogger(DelivererDynamicServiceImpl.class);

    @Override
    public DelivererDynamic get(String id) {
        return delivererDynamicMapper.get(id);
    }

    @Override
    public List<DelivererDynamic> findList(DelivererDynamic delivererDynamic) {
        return delivererDynamicMapper.findList(delivererDynamic);
    }

    @Override
    public Page<DelivererDynamic> findListByPage(DelivererDynamic delivererDynamic, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return delivererDynamicMapper.findListByPage(delivererDynamic);
    }

    @Override
    public Integer insert(DelivererDynamic delivererDynamic) {
//        delivererDynamic.setCreateTime(new Date());
        return delivererDynamicMapper.insert(delivererDynamic);
    }

    @Override
    public Integer update(DelivererDynamic delivererDynamic) {
//        delivererDynamic.setUpdateTime(new Date());
        return delivererDynamicMapper.update(delivererDynamic);
    }

    @Override
    public Integer delete(String id) {
        return delivererDynamicMapper.delete(id);
    }
}

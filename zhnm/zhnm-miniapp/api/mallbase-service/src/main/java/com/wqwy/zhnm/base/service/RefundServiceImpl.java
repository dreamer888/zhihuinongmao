/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.dao.RefundMapper;
import com.wqwy.zhnm.base.entity.Refund;

/**
 * createTime: 2018-08-23 18:51:01
 * @author zss
 * @version
 */
@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundMapper refundMapper;

    private static final Logger logger = LoggerFactory.getLogger(RefundServiceImpl.class);

    @Override
    public Refund get(String id) {
        return refundMapper.get(id);
    }

    @Override
    public List<Refund> findList(Refund Refund) {
        return refundMapper.findList(Refund);
    }
    
   
    @Override
    public Page<Refund> findListByPage(Refund Refund, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return refundMapper.findListByPage(Refund);
    }

    @Override
    public Integer insert(Refund Refund) {
        return refundMapper.insert(Refund);
    }

    @Override
    public Integer update(Refund Refund) {
        return refundMapper.update(Refund);
    }

    @Override
    public Integer delete(String id) {
        return refundMapper.delete(id);
    }
}

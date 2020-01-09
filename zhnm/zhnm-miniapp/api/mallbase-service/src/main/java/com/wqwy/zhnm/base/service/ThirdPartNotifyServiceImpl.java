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

import com.wqwy.zhnm.base.dao.ThirdPartNotifyMapper;
import com.wqwy.zhnm.base.entity.ThirdPartNotify;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.ThirdPartNotifyService;

/**
 * createTime: 2018-05-31 15:05:28
 * @author seven
 * @version
 */
@Service
public class ThirdPartNotifyServiceImpl implements ThirdPartNotifyService {

    @Autowired
    private ThirdPartNotifyMapper thirdPartNotifyMapper;

    private static final Logger logger = LoggerFactory.getLogger(ThirdPartNotifyServiceImpl.class);

    @Override
    public ThirdPartNotify get(String id) {
        return thirdPartNotifyMapper.get(id);
    }

    @Override
	public Integer getCountByCondition(ThirdPartNotify thirdPartNotify ) {
    	return thirdPartNotifyMapper.getCountByCondition(thirdPartNotify);
	}
	
    @Override
    public List<ThirdPartNotify> findList(ThirdPartNotify thirdPartNotify) {
        return thirdPartNotifyMapper.findList(thirdPartNotify);
    }

    @Override
    public Page<ThirdPartNotify> findListByPage(ThirdPartNotify thirdPartNotify, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return thirdPartNotifyMapper.findListByPage(thirdPartNotify);
    }

    @Override
    public Integer insert(ThirdPartNotify thirdPartNotify) {
        thirdPartNotify.setCreateTime(new Date());
        return thirdPartNotifyMapper.insert(thirdPartNotify);
    }

    @Override
    public Integer update(ThirdPartNotify thirdPartNotify) {
//        thirdPartNotify.setUpdateTime(new Date());
        return thirdPartNotifyMapper.update(thirdPartNotify);
    }

    @Override
    public Integer delete(String id) {
        return thirdPartNotifyMapper.delete(id);
    }
}

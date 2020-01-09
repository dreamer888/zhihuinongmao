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

import com.wqwy.zhnm.base.dao.ShopUserMapper;
import com.wqwy.zhnm.base.entity.ShopUser;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.ShopUserService;

/**
 * createTime: 2018-06-01 14:12:29
 * @author seven
 * @version
 */
@Service
public class ShopUserServiceImpl implements ShopUserService {

    @Autowired
    private ShopUserMapper shopUserMapper;

    private static final Logger logger = LoggerFactory.getLogger(ShopUserServiceImpl.class);

    @Override
    public ShopUser get(String userId) {
        return shopUserMapper.get(userId);
    }

    @Override
	public Integer getCountByCondition(ShopUser shopUser ) {
    	return shopUserMapper.getCountByCondition(shopUser);
	}
	
    @Override
    public List<ShopUser> findList(ShopUser shopUser) {
        return shopUserMapper.findList(shopUser);
    }

    @Override
    public Page<ShopUser> findListByPage(ShopUser shopUser, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return shopUserMapper.findListByPage(shopUser);
    }

    @Override
    public Integer insert(ShopUser shopUser) {
//        shopUser.setCreateTime(new Date());
        return shopUserMapper.insert(shopUser);
    }

    @Override
    public Integer update(ShopUser shopUser) {
//        shopUser.setUpdateTime(new Date());
        return shopUserMapper.update(shopUser);
    }

    @Override
    public Integer delete(String userId) {
        return shopUserMapper.delete(userId);
    }
}

/**
 * Copyright (c) 2015-2017 <a href="">caishigou</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.dao.SysUserMapper;
import com.wqwy.zhnm.base.entity.SysUser;
import com.wqwy.zhnm.base.service.SysUserService2;

/**
 * createTime: 2018-05-05 17:58:46
 * @author seven
 * @version
 */
@Service
public class SysUserServiceImpl2 implements SysUserService2 {

    @Autowired
    private SysUserMapper sysUserMapper;

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl2.class);

    @Override
    public SysUser get(String userId) {
        return sysUserMapper.get(userId);
    }

    @Override
    public List<SysUser> findList(SysUser sysUser) {
        return sysUserMapper.findList(sysUser);
    }

    @Override
    public Page<SysUser> findListByPage(SysUser sysUser, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        logger.info("sysUser : " + sysUser.toString());
        return sysUserMapper.findListByPage(sysUser);
    }

    @Override
    public Integer insert(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public Integer update(SysUser sysUser) {
        return sysUserMapper.update(sysUser);
    }

    @Override
    public Integer delete(String userId) {
        return sysUserMapper.delete(userId);
    }
}

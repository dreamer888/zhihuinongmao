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
import com.wqwy.zhnm.base.dao.VersionManager;
import com.wqwy.zhnm.base.entity.ShopUser;
import com.wqwy.zhnm.base.entity.Version;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.ShopUserService;

/**
 * createTime: 2018-06-01 14:12:29
 * @author seven
 * @version
 */
@Service
public class VersionServiceImpl implements VersionService {

    @Autowired
    private VersionManager versionMapper;

    private static final Logger logger = LoggerFactory.getLogger(VersionServiceImpl.class);

    public List<Version> findByType(Integer appType) {
        return versionMapper.findByType(appType);
    }
}

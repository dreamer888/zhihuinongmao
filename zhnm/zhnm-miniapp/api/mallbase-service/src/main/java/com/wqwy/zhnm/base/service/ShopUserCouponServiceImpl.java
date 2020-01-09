/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wqwy.zhnm.base.dao.ShopUserCouponMapper;
import com.wqwy.zhnm.base.entity.ShopUserCoupon;

/**
 * createTime: 2018-08-25 14:12:29
 * @author zss
 * @version
 */
@Service
public class ShopUserCouponServiceImpl implements ShopUserCouponService {

    @Autowired
    private ShopUserCouponMapper shopUserCouponMapper;

    private static final Logger logger = LoggerFactory.getLogger(ShopUserCouponServiceImpl.class);

    @Override
    public ShopUserCoupon get(String userId) {
        return shopUserCouponMapper.get(userId);
    }
	
    @Override
    public List<ShopUserCoupon> findList(ShopUserCoupon shopUserCoupon) {
        return shopUserCouponMapper.findList(shopUserCoupon);
    }

    @Override
    public Integer update(ShopUserCoupon shopUserCoupon) {
        return shopUserCouponMapper.update(shopUserCoupon);
    }

}

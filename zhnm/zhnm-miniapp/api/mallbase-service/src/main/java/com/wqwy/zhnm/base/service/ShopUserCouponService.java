/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.util.List;

import com.wqwy.zhnm.base.entity.ShopUserCoupon;

/**
 * createTime: 2018-06-01 14:12:29
 * @author seven
 * @version
 */
public interface ShopUserCouponService {

	/**
	 * query
	 * @param userCouponId
	 * @return ShopUserCoupon
	 */
	public ShopUserCoupon get(String userCouponId);
	
	/**
	 * query
	 * @param ShopUserCoupon
	 * @return List<ShopUserCoupon>
	 */
	public List<ShopUserCoupon> findList(ShopUserCoupon shopUserCoupon);

	/**
	 * update
	 * @param ShopUserCoupon
	 * @return
	 */
	public Integer update(ShopUserCoupon shopUserCoupon);


	



}

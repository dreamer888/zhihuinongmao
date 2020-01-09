/**
 * Copyright (c) 2015-2017 <a href="">caishigou</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import java.util.List;

import com.wqwy.zhnm.base.entity.ShopUserCoupon;

/**
 * createTime: 2018-08-25 17:58:46
 * @author zss
 * @version
 */
public interface ShopUserCouponMapper {

	/**
	 * query by userId
	 * @param userId
	 * @return SysUser
	 */
	public ShopUserCoupon get(String couponId );

	/**
	 * query by condition
	 * @param sysUser
	 * @return List<SysUser>
	 */
	public List<ShopUserCoupon> findList(ShopUserCoupon shopUserCoupon);

	/**
	 * update
	 * @param sysUser
	 * @return if success then != 0 else =0
	 */
	public Integer update(ShopUserCoupon shopUserCoupon);

}

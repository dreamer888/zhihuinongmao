/**
 * Copyright (c) 2015-2017 <a href="">caishigou</a> All rights reserved.
 */
package com.wqwy.zhnm.base.entity;

/**
 * createTime: 2018-05-05 17:58:46
 * 
 * @author seven
 * @version
 */
public class ShopUserCoupon {


	/**
	 * 自增Id
	 */
	private String usercouponId;
	/**
	 * 增加时间
	 */
	private String addTime;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 状态(0、已使用  1 、未使用)
	 */
	private int status;

	/**
	 * 代金券公版ID
	 */
	private String couponId;
	
	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsercouponId() {
		return usercouponId;
	}

	public void setUsercouponId(String usercouponId) {
		this.usercouponId = usercouponId;
	}

	
}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.ShopUser;

import java.util.List;

/**
 * createTime: 2018-06-01 14:12:29
 * @author seven
 * @version
 */
public interface ShopUserService {

	/**
	 * query
	 * @param userId
	 * @return ShopUser
	 */
	public ShopUser get(String userId);

	/**
	 * query by condition
	 * @param shopUser
	 * @return Integer
	 */
	public Integer getCountByCondition(ShopUser shopUser );
	
	/**
	 * query
	 * @param shopUser
	 * @return List<ShopUser>
	 */
	public List<ShopUser> findList(ShopUser shopUser);

	/**
	 * query
	 * @param shopUser
	 * @return Page<ShopUser>
	 */
	public Page<ShopUser> findListByPage(ShopUser shopUser, Pagenation pagenation);

	/**
	 * insert
	 * @param shopUser
	 * @return
	 */
	public Integer insert(ShopUser shopUser);


	/**
	 * update
	 * @param shopUser
	 * @return
	 */
	public Integer update(ShopUser shopUser);


	/**
	 * delete
	 * @param userId
	 * @return
	 */
	public Integer delete(String userId);



}

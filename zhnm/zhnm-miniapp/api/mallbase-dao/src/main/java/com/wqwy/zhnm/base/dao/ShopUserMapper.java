/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.ShopUser;
import java.util.List;

/**
 * createTime: 2018-06-01 14:12:29
 * @author seven
 * @version
 */
public interface ShopUserMapper {

	/**
	 * query by userId
	 * @param userId
	 * @return ShopUser
	 */
	public ShopUser get(String userId );
	
	/**
	 * query by condition
	 * @param shopUser
	 * @return Integer
	 */
	public Integer getCountByCondition(ShopUser shopUser );

	/**
	 * query by condition
	 * @param shopUser
	 * @return List<ShopUser>
	 */
	public List<ShopUser> findList(ShopUser shopUser);

	/**
	 * query by paging
	 * @param shopUser
	 * @return Page<ShopUser>
	 */
	public Page<ShopUser> findListByPage(ShopUser shopUser);

	/**
	 * insert
	 * @param shopUser
	 * @return if success then != 0 else =0
	 */
	public Integer insert(ShopUser shopUser);


	/**
	 * update
	 * @param shopUser
	 * @return if success then != 0 else =0
	 */
	public Integer update(ShopUser shopUser);


	/**
	 * delete
	 * @param userId
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String userId);

}

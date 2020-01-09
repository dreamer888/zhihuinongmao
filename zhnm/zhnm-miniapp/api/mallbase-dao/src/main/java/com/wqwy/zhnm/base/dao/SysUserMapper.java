/**
 * Copyright (c) 2015-2017 <a href="">caishigou</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.SysUser;

import java.util.List;

/**
 * createTime: 2018-05-05 17:58:46
 * @author seven
 * @version
 */
public interface SysUserMapper {

	/**
	 * query by userId
	 * @param userId
	 * @return SysUser
	 */
	public SysUser get(String userId );

	/**
	 * query by condition
	 * @param sysUser
	 * @return List<SysUser>
	 */
	public List<SysUser> findList(SysUser sysUser);

	/**
	 * query by paging
	 * @param sysUser
	 * @return Page<SysUser>
	 */
	public Page<SysUser> findListByPage(SysUser sysUser);

	/**
	 * insert
	 * @param sysUser
	 * @return if success then != 0 else =0
	 */
	public Integer insert(SysUser sysUser);


	/**
	 * update
	 * @param sysUser
	 * @return if success then != 0 else =0
	 */
	public Integer update(SysUser sysUser);


	/**
	 * delete
	 * @param userId
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String userId);

}

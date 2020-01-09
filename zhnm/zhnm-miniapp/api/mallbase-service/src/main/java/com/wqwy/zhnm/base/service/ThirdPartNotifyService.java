/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.ThirdPartNotify;

import java.util.List;

/**
 * createTime: 2018-05-31 15:05:28
 * @author seven
 * @version
 */
public interface ThirdPartNotifyService {

	/**
	 * query
	 * @param id
	 * @return ThirdPartNotify
	 */
	public ThirdPartNotify get(String id);

	/**
	 * query by condition
	 * @param thirdPartNotify
	 * @return Integer
	 */
	public Integer getCountByCondition(ThirdPartNotify thirdPartNotify );
	
	/**
	 * query
	 * @param thirdPartNotify
	 * @return List<ThirdPartNotify>
	 */
	public List<ThirdPartNotify> findList(ThirdPartNotify thirdPartNotify);

	/**
	 * query
	 * @param thirdPartNotify
	 * @return Page<ThirdPartNotify>
	 */
	public Page<ThirdPartNotify> findListByPage(ThirdPartNotify thirdPartNotify, Pagenation pagenation);

	/**
	 * insert
	 * @param thirdPartNotify
	 * @return
	 */
	public Integer insert(ThirdPartNotify thirdPartNotify);


	/**
	 * update
	 * @param thirdPartNotify
	 * @return
	 */
	public Integer update(ThirdPartNotify thirdPartNotify);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

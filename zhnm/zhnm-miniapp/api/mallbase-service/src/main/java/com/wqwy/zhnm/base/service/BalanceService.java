/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.Balance;

import java.util.List;

/**
 * createTime: 2018-05-08 17:47:07
 * @author seven
 * @version
 */
public interface BalanceService {

	/**
	 * query
	 * @param id
	 * @return Balance
	 */
	public Balance get(String id);

	/**
	 * query
	 * @param balance
	 * @return List<Balance>
	 */
	public List<Balance> findList(Balance balance);

	/**
	 * query
	 * @param balance
	 * @return Page<Balance>
	 */
	public Page<Balance> findListByPage(Balance balance, Pagenation pagenation);

	/**
	 * insert
	 * @param balance
	 * @return
	 */
	public Integer insert(Balance balance);


	/**
	 * update
	 * @param balance
	 * @return
	 */
	public Integer update(Balance balance);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

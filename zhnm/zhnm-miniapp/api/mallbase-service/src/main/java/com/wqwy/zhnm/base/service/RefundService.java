/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.Refund;

import java.util.List;

/**
 * createTime: 2018-05-08 18:51:01
 * @author zss
 * @version
 */
public interface RefundService {

	/**
	 * query
	 * @param id
	 * @return Refund
	 */
	public Refund get(String id);

	/**
	 * query
	 * @param Refund
	 * @return List<Refund>
	 */
	public List<Refund> findList(Refund Refund);

	/**
	 * query
	 * @param Refund
	 * @return Page<Refund>
	 */
	public Page<Refund> findListByPage(Refund Refund, Pagenation pagenation);

	/**
	 * insert
	 * @param Refund
	 * @return
	 */
	public Integer insert(Refund Refund);


	/**
	 * update
	 * @param Refund
	 * @return
	 */
	public Integer update(Refund Refund);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

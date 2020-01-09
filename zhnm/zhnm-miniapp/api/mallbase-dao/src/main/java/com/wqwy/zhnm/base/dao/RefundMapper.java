/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.Refund;

/**
 * createTime: 2018-08-23 18:51:01
 * @author zss
 * @version
 */
public interface RefundMapper {

	/**
	 * query by id
	 * @param id
	 * @return Refund
	 */
	public Refund get(String id );

	/**
	 * query by condition
	 * @param Refund
	 * @return List<Refund>
	 */
	public List<Refund> findList(Refund Refund);

	/**
	 * query by paging
	 * @param Refund
	 * @return Page<Refund>
	 */
	public Page<Refund> findListByPage(Refund Refund);

	/**
	 * insert
	 * @param Refund
	 * @return if success then != 0 else =0
	 */
	public Integer insert(Refund Refund);


	/**
	 * update
	 * @param Refund
	 * @return if success then != 0 else =0
	 */
	public Integer update(Refund Refund);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

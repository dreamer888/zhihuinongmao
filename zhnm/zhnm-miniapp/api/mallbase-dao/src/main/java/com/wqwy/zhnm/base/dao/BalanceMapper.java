/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.Balance;
import java.util.List;

/**
 * createTime: 2018-05-08 17:47:07
 * @author seven
 * @version
 */
public interface BalanceMapper {

	/**
	 * query by id
	 * @param id
	 * @return Balance
	 */
	public Balance get(String id );

	/**
	 * query by condition
	 * @param balance
	 * @return List<Balance>
	 */
	public List<Balance> findList(Balance balance);

	/**
	 * query by paging
	 * @param balance
	 * @return Page<Balance>
	 */
	public Page<Balance> findListByPage(Balance balance);

	/**
	 * insert
	 * @param balance
	 * @return if success then != 0 else =0
	 */
	public Integer insert(Balance balance);


	/**
	 * update
	 * @param balance
	 * @return if success then != 0 else =0
	 */
	public Integer update(Balance balance);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderDTO;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrder;

/**
 * createTime: 2018-05-08 18:51:13
 * @author seven
 * @version
 */
public interface BalanceOfflineOrderMapper {

	/**
	 * query by id
	 * @param id
	 * @return BalanceOfflineOrder
	 */
	public BalanceOfflineOrder get(String id );

	/**
	 * query by condition
	 * @param balanceOfflineOrder
	 * @return List<BalanceOfflineOrder>
	 */
	public List<BalanceOfflineOrder> findList(BalanceOfflineOrder balanceOfflineOrder);

	/**
	 * query by paging
	 * @param balanceOfflineOrder
	 * @return Page<BalanceOfflineOrder>
	 */
	public Page<BalanceOfflineOrderDTO> findListByPage(BalanceOfflineOrderDTO balanceOfflineOrder);

	/**
	 * insert
	 * @param balanceOfflineOrder
	 * @return if success then != 0 else =0
	 */
	public Integer insert(BalanceOfflineOrder balanceOfflineOrder);


	/**
	 * update
	 * @param balanceOfflineOrder
	 * @return if success then != 0 else =0
	 */
	public Integer update(BalanceOfflineOrder balanceOfflineOrder);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

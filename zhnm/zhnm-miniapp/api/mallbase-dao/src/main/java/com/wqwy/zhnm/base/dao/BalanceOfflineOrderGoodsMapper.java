/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderGoodsDTO;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrderGoods;

/**
 * createTime: 2018-05-08 18:52:23
 * @author seven
 * @version
 */
public interface BalanceOfflineOrderGoodsMapper {

	/**
	 * query by id
	 * @param id
	 * @return BalanceOfflineOrderGoods
	 */
	public BalanceOfflineOrderGoods get(String id );

	/**
	 * query by condition
	 * @param balanceOfflineOrderGoods
	 * @return List<BalanceOfflineOrderGoods>
	 */
	public List<BalanceOfflineOrderGoods> findList(BalanceOfflineOrderGoods balanceOfflineOrderGoods);
	
	public List<BalanceOfflineOrderGoodsDTO> findListSpecial(BalanceOfflineOrderGoodsDTO balanceOfflineOrderGoods);
	
	/**
	 * query by paging
	 * @param balanceOfflineOrderGoods
	 * @return Page<BalanceOfflineOrderGoods>
	 */
	public Page<BalanceOfflineOrderGoods> findListByPage(BalanceOfflineOrderGoods balanceOfflineOrderGoods);

	/**
	 * insert
	 * @param balanceOfflineOrderGoods
	 * @return if success then != 0 else =0
	 */
	public Integer insert(BalanceOfflineOrderGoods balanceOfflineOrderGoods);


	/**
	 * update
	 * @param balanceOfflineOrderGoods
	 * @return if success then != 0 else =0
	 */
	public Integer update(BalanceOfflineOrderGoods balanceOfflineOrderGoods);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

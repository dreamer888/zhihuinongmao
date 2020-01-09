/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderGoodsDTO;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrderGoods;

import java.util.List;

/**
 * createTime: 2018-05-08 18:52:23
 * @author seven
 * @version
 */
public interface BalanceOfflineOrderGoodsService {

	/**
	 * query
	 * @param id
	 * @return BalanceOfflineOrderGoods
	 */
	public BalanceOfflineOrderGoods get(String id);

	/**
	 * query
	 * @param balanceOfflineOrderGoods
	 * @return List<BalanceOfflineOrderGoods>
	 */
	public List<BalanceOfflineOrderGoods> findList(BalanceOfflineOrderGoods balanceOfflineOrderGoods);
	
	public List<BalanceOfflineOrderGoodsDTO> findListSpecial(BalanceOfflineOrderGoodsDTO balanceOfflineOrderGoods);

	/**
	 * query
	 * @param balanceOfflineOrderGoods
	 * @return Page<BalanceOfflineOrderGoods>
	 */
	public Page<BalanceOfflineOrderGoods> findListByPage(BalanceOfflineOrderGoods balanceOfflineOrderGoods, Pagenation pagenation);

	/**
	 * insert
	 * @param balanceOfflineOrderGoods
	 * @return
	 */
	public Integer insert(BalanceOfflineOrderGoods balanceOfflineOrderGoods);


	/**
	 * update
	 * @param balanceOfflineOrderGoods
	 * @return
	 */
	public Integer update(BalanceOfflineOrderGoods balanceOfflineOrderGoods);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);

	

}

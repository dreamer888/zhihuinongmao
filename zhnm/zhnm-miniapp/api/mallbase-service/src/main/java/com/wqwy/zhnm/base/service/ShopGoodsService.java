/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.ShopGoodsDTO;
import com.wqwy.zhnm.base.entity.ShopGoods;

/**
 * createTime: 2018-05-09 11:52:16
 * @author seven
 * @version
 */
public interface ShopGoodsService {

	/**
	 * query
	 * @param goodsId
	 * @return ShopGoods
	 */
	public ShopGoods get(String goodsId);
	
	/**
	 * query by condition
	 * @param shopGoods
	 * @return Integer
	 */
	public Integer getCountByCondition(ShopGoods shopGoods );

	/**
	 * query
	 * @param shopGoods
	 * @return List<ShopGoods>
	 */
	public List<ShopGoods> findList(ShopGoods shopGoods);

	/**
	 * query
	 * @param shopGoods
	 * @return Page<ShopGoods>
	 */
	public Page<ShopGoods> findListByPage(ShopGoodsDTO shopGoods, Pagenation pagenation);

	/**
	 * insert
	 * @param shopGoods
	 * @return
	 */
	public Integer insert(ShopGoods shopGoods);


	/**
	 * update
	 * @param shopGoods
	 * @return
	 */
	public Integer update(ShopGoods shopGoods);


	/**
	 * delete
	 * @param goodsId
	 * @return
	 */
	public Integer delete(String goodsId);



}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.dto.ShopGoodsDTO;
import com.wqwy.zhnm.base.entity.ShopGoods;

/**
 * createTime: 2018-05-09 11:52:16
 * @author seven
 * @version
 */
public interface ShopGoodsMapper {

	/**
	 * query by goodsId
	 * @param goodsId
	 * @return ShopGoods
	 */
	public ShopGoods get(String goodsId );
	
	/**
	 * query by condition
	 * @param shopGoods
	 * @return Integer
	 */
	public Integer getCountByCondition(ShopGoods shopGoods );

	/**
	 * query by condition
	 * @param shopGoods
	 * @return List<ShopGoods>
	 */
	public List<ShopGoods> findList(ShopGoods shopGoods);

	/**
	 * query by paging
	 * @param shopGoods
	 * @return Page<ShopGoods>
	 */
	public Page<ShopGoods> findListByPage(ShopGoodsDTO shopGoods);

	/**
	 * insert
	 * @param shopGoods
	 * @return if success then != 0 else =0
	 */
	public Integer insert(ShopGoods shopGoods);


	/**
	 * update
	 * @param shopGoods
	 * @return if success then != 0 else =0
	 */
	public Integer update(ShopGoods shopGoods);


	/**
	 * delete
	 * @param goodsId
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String goodsId);

}

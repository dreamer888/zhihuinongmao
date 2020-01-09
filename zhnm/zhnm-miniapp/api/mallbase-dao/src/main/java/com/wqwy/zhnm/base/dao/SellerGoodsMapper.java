/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.SellerGoods;
import java.util.List;

/**
 * createTime: 2018-05-08 18:51:10
 * @author seven
 * @version
 */
public interface SellerGoodsMapper {

	/**
	 * query by id
	 * @param id
	 * @return SellerGoods
	 */
	public SellerGoods get(String id );
	
	/**
	 * query by condition
	 * @param sellerGoods
	 * @return Integer
	 */
	public Integer getCountByCondition(SellerGoods sellerGoods );

	/**
	 * query by condition
	 * @param sellerGoods
	 * @return List<SellerGoods>
	 */
	public List<SellerGoods> findList(SellerGoods sellerGoods);
	
	public List<SellerGoods> findListForUpdate(SellerGoods sellerGoods);

	/**
	 * query by paging
	 * @param sellerGoods
	 * @return Page<SellerGoods>
	 */
	public Page<SellerGoods> findListByPage(SellerGoods sellerGoods);

	/**
	 * insert
	 * @param sellerGoods
	 * @return if success then != 0 else =0
	 */
	public Integer insert(SellerGoods sellerGoods);


	/**
	 * update
	 * @param sellerGoods
	 * @return if success then != 0 else =0
	 */
	public Integer update(SellerGoods sellerGoods);
	
	public Integer updateAllStock(SellerGoods sellerGoods);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

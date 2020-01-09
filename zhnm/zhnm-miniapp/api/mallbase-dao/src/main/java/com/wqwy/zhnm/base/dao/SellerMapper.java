/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.SellerMarketComponent;
import com.wqwy.zhnm.base.entity.Seller;

/**
 * createTime: 2018-05-08 18:51:02
 * @author seven
 * @version
 */
public interface SellerMapper {

	/**
	 * query by id
	 * @param id
	 * @return Seller
	 */
	public Seller get(String id );
	
	public SellerMarketComponent getWithMarket(String id);

	/**
	 * query by condition
	 * @param seller
	 * @return List<Seller>
	 */
	public List<Seller> findList(Seller seller);

	/**
	 * query by paging
	 * @param seller
	 * @return Page<Seller>
	 */
	public Page<Seller> findListByPage(Seller seller);

	/**
	 * insert
	 * @param seller
	 * @return if success then != 0 else =0
	 */
	public Integer insert(Seller seller);


	/**
	 * update
	 * @param seller
	 * @return if success then != 0 else =0
	 */
	public Integer update(Seller seller);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

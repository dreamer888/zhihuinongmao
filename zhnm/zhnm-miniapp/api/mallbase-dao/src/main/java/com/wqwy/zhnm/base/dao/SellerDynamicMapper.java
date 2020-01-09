/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.SellerDynamic;
import java.util.List;

/**
 * createTime: 2018-05-08 18:51:09
 * @author seven
 * @version
 */
public interface SellerDynamicMapper {

	/**
	 * query by id
	 * @param id
	 * @return SellerDynamic
	 */
	public SellerDynamic get(String id );

	/**
	 * query by condition
	 * @param sellerDynamic
	 * @return List<SellerDynamic>
	 */
	public List<SellerDynamic> findList(SellerDynamic sellerDynamic);

	/**
	 * query by paging
	 * @param sellerDynamic
	 * @return Page<SellerDynamic>
	 */
	public Page<SellerDynamic> findListByPage(SellerDynamic sellerDynamic);

	/**
	 * insert
	 * @param sellerDynamic
	 * @return if success then != 0 else =0
	 */
	public Integer insert(SellerDynamic sellerDynamic);


	/**
	 * update
	 * @param sellerDynamic
	 * @return if success then != 0 else =0
	 */
	public Integer update(SellerDynamic sellerDynamic);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

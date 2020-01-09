/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.DelivererMarket;
import java.util.List;

/**
 * createTime: 2018-05-08 18:50:59
 * @author seven
 * @version
 */
public interface DelivererMarketMapper {

	/**
	 * query by id
	 * @param id
	 * @return DelivererMarket
	 */
	public DelivererMarket get(String id );

	/**
	 * query by condition
	 * @param delivererMarket
	 * @return List<DelivererMarket>
	 */
	public List<DelivererMarket> findList(DelivererMarket delivererMarket);

	/**
	 * query by paging
	 * @param delivererMarket
	 * @return Page<DelivererMarket>
	 */
	public Page<DelivererMarket> findListByPage(DelivererMarket delivererMarket);

	/**
	 * insert
	 * @param delivererMarket
	 * @return if success then != 0 else =0
	 */
	public Integer insert(DelivererMarket delivererMarket);


	/**
	 * update
	 * @param delivererMarket
	 * @return if success then != 0 else =0
	 */
	public Integer update(DelivererMarket delivererMarket);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.Market;
import java.util.List;

/**
 * createTime: 2018-05-08 18:51:01
 * @author seven
 * @version
 */
public interface MarketMapper {

	/**
	 * query by id
	 * @param id
	 * @return Market
	 */
	public Market get(String id );

	/**
	 * query by condition
	 * @param market
	 * @return List<Market>
	 */
	public List<Market> findList(Market market);

	/**
	 * query by paging
	 * @param market
	 * @return Page<Market>
	 */
	public Page<Market> findListByPage(Market market);

	/**
	 * insert
	 * @param market
	 * @return if success then != 0 else =0
	 */
	public Integer insert(Market market);


	/**
	 * update
	 * @param market
	 * @return if success then != 0 else =0
	 */
	public Integer update(Market market);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

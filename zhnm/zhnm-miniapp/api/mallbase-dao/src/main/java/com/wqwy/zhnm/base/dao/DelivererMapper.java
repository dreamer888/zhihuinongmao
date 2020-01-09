/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.Deliverer;
import java.util.List;

/**
 * createTime: 2018-05-08 18:50:56
 * @author seven
 * @version
 */
public interface DelivererMapper {

	/**
	 * query by id
	 * @param id
	 * @return Deliverer
	 */
	public Deliverer get(String id );

	/**
	 * query by condition
	 * @param deliverer
	 * @return List<Deliverer>
	 */
	public List<Deliverer> findList(Deliverer deliverer);

	/**
	 * query by paging
	 * @param deliverer
	 * @return Page<Deliverer>
	 */
	public Page<Deliverer> findListByPage(Deliverer deliverer);

	/**
	 * insert
	 * @param deliverer
	 * @return if success then != 0 else =0
	 */
	public Integer insert(Deliverer deliverer);


	/**
	 * update
	 * @param deliverer
	 * @return if success then != 0 else =0
	 */
	public Integer update(Deliverer deliverer);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

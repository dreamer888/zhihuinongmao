/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.DelivererDynamic;
import java.util.List;

/**
 * createTime: 2018-05-08 18:50:58
 * @author seven
 * @version
 */
public interface DelivererDynamicMapper {

	/**
	 * query by id
	 * @param id
	 * @return DelivererDynamic
	 */
	public DelivererDynamic get(String id );

	/**
	 * query by condition
	 * @param delivererDynamic
	 * @return List<DelivererDynamic>
	 */
	public List<DelivererDynamic> findList(DelivererDynamic delivererDynamic);

	/**
	 * query by paging
	 * @param delivererDynamic
	 * @return Page<DelivererDynamic>
	 */
	public Page<DelivererDynamic> findListByPage(DelivererDynamic delivererDynamic);

	/**
	 * insert
	 * @param delivererDynamic
	 * @return if success then != 0 else =0
	 */
	public Integer insert(DelivererDynamic delivererDynamic);


	/**
	 * update
	 * @param delivererDynamic
	 * @return if success then != 0 else =0
	 */
	public Integer update(DelivererDynamic delivererDynamic);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

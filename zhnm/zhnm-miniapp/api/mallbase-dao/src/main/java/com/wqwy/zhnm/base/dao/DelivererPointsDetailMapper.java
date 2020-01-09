/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.DelivererPointsDetail;
import java.util.List;

/**
 * createTime: 2018-05-08 18:50:59
 * @author seven
 * @version
 */
public interface DelivererPointsDetailMapper {

	/**
	 * query by id
	 * @param id
	 * @return DelivererPointsDetail
	 */
	public DelivererPointsDetail get(String id );

	/**
	 * query by condition
	 * @param delivererPointsDetail
	 * @return List<DelivererPointsDetail>
	 */
	public List<DelivererPointsDetail> findList(DelivererPointsDetail delivererPointsDetail);

	/**
	 * query by paging
	 * @param delivererPointsDetail
	 * @return Page<DelivererPointsDetail>
	 */
	public Page<DelivererPointsDetail> findListByPage(DelivererPointsDetail delivererPointsDetail);

	/**
	 * insert
	 * @param delivererPointsDetail
	 * @return if success then != 0 else =0
	 */
	public Integer insert(DelivererPointsDetail delivererPointsDetail);


	/**
	 * update
	 * @param delivererPointsDetail
	 * @return if success then != 0 else =0
	 */
	public Integer update(DelivererPointsDetail delivererPointsDetail);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

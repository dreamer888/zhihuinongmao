/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.DelivererPointsDetail;

import java.util.List;

/**
 * createTime: 2018-05-08 18:50:59
 * @author seven
 * @version
 */
public interface DelivererPointsDetailService {

	/**
	 * query
	 * @param id
	 * @return DelivererPointsDetail
	 */
	public DelivererPointsDetail get(String id);

	/**
	 * query
	 * @param delivererPointsDetail
	 * @return List<DelivererPointsDetail>
	 */
	public List<DelivererPointsDetail> findList(DelivererPointsDetail delivererPointsDetail);

	/**
	 * query
	 * @param delivererPointsDetail
	 * @return Page<DelivererPointsDetail>
	 */
	public Page<DelivererPointsDetail> findListByPage(DelivererPointsDetail delivererPointsDetail, Pagenation pagenation);

	/**
	 * insert
	 * @param delivererPointsDetail
	 * @return
	 */
	public Integer insert(DelivererPointsDetail delivererPointsDetail);


	/**
	 * update
	 * @param delivererPointsDetail
	 * @return
	 */
	public Integer update(DelivererPointsDetail delivererPointsDetail);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

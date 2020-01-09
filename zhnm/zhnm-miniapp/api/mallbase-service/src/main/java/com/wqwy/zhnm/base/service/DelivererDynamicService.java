/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.DelivererDynamic;

import java.util.List;

/**
 * createTime: 2018-05-08 18:50:58
 * @author seven
 * @version
 */
public interface DelivererDynamicService {

	/**
	 * query
	 * @param id
	 * @return DelivererDynamic
	 */
	public DelivererDynamic get(String id);

	/**
	 * query
	 * @param delivererDynamic
	 * @return List<DelivererDynamic>
	 */
	public List<DelivererDynamic> findList(DelivererDynamic delivererDynamic);

	/**
	 * query
	 * @param delivererDynamic
	 * @return Page<DelivererDynamic>
	 */
	public Page<DelivererDynamic> findListByPage(DelivererDynamic delivererDynamic, Pagenation pagenation);

	/**
	 * insert
	 * @param delivererDynamic
	 * @return
	 */
	public Integer insert(DelivererDynamic delivererDynamic);


	/**
	 * update
	 * @param delivererDynamic
	 * @return
	 */
	public Integer update(DelivererDynamic delivererDynamic);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

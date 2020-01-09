/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.request.DelivererRegisterRequest;
import com.wqwy.zhnm.base.component.response.DelivererDetailResponse;
import com.wqwy.zhnm.base.entity.Deliverer;

/**
 * createTime: 2018-05-08 18:50:56
 * @author seven
 * @version
 */
public interface DelivererService {

	/**
	 * query
	 * @param id
	 * @return Deliverer
	 */
	public Deliverer get(String id);

	/**
	 * query
	 * @param deliverer
	 * @return List<Deliverer>
	 */
	public List<Deliverer> findList(Deliverer deliverer);

	/**
	 * query
	 * @param deliverer
	 * @return Page<Deliverer>
	 */
	public Page<Deliverer> findListByPage(Deliverer deliverer, Pagenation pagenation);

	/**
	 * insert
	 * @param deliverer
	 * @return
	 */
	public DelivererDetailResponse insert(DelivererRegisterRequest deliverer);


	/**
	 * update
	 * @param deliverer
	 * @return
	 */
	public Integer update(Deliverer deliverer);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);
	
}

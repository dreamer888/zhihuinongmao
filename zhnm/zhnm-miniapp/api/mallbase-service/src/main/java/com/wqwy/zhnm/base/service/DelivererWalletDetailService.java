/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.DelivererWalletDetail;

import java.util.List;

/**
 * createTime: 2018-05-08 18:51:00
 * @author seven
 * @version
 */
public interface DelivererWalletDetailService {

	/**
	 * query
	 * @param id
	 * @return DelivererWalletDetail
	 */
	public DelivererWalletDetail get(String id);

	/**
	 * query
	 * @param delivererWalletDetail
	 * @return List<DelivererWalletDetail>
	 */
	public List<DelivererWalletDetail> findList(DelivererWalletDetail delivererWalletDetail);

	/**
	 * query
	 * @param delivererWalletDetail
	 * @return Page<DelivererWalletDetail>
	 */
	public Page<DelivererWalletDetail> findListByPage(DelivererWalletDetail delivererWalletDetail, Pagenation pagenation);

	/**
	 * insert
	 * @param delivererWalletDetail
	 * @return
	 */
	public Integer insert(DelivererWalletDetail delivererWalletDetail);


	/**
	 * update
	 * @param delivererWalletDetail
	 * @return
	 */
	public Integer update(DelivererWalletDetail delivererWalletDetail);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

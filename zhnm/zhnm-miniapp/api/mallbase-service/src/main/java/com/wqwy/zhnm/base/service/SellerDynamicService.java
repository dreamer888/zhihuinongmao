/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.SellerDynamic;

import java.util.List;

/**
 * createTime: 2018-05-08 18:51:09
 * @author seven
 * @version
 */
public interface SellerDynamicService {

	/**
	 * query
	 * @param id
	 * @return SellerDynamic
	 */
	public SellerDynamic get(String id);

	/**
	 * query
	 * @param sellerDynamic
	 * @return List<SellerDynamic>
	 */
	public List<SellerDynamic> findList(SellerDynamic sellerDynamic);

	/**
	 * query
	 * @param sellerDynamic
	 * @return Page<SellerDynamic>
	 */
	public Page<SellerDynamic> findListByPage(SellerDynamic sellerDynamic, Pagenation pagenation);

	/**
	 * insert
	 * @param sellerDynamic
	 * @return
	 */
	public Integer insert(SellerDynamic sellerDynamic);


	/**
	 * update
	 * @param sellerDynamic
	 * @return
	 */
	public Integer update(SellerDynamic sellerDynamic);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

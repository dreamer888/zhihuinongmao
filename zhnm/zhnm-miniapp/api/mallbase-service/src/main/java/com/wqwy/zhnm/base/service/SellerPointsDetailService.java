/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.SellerPointsDetail;

import java.util.List;

/**
 * createTime: 2018-05-08 18:51:11
 * @author seven
 * @version
 */
public interface SellerPointsDetailService {

	/**
	 * query
	 * @param id
	 * @return SellerPointsDetail
	 */
	public SellerPointsDetail get(String id);

	/**
	 * query
	 * @param sellerPointsDetail
	 * @return List<SellerPointsDetail>
	 */
	public List<SellerPointsDetail> findList(SellerPointsDetail sellerPointsDetail);

	/**
	 * query
	 * @param sellerPointsDetail
	 * @return Page<SellerPointsDetail>
	 */
	public Page<SellerPointsDetail> findListByPage(SellerPointsDetail sellerPointsDetail, Pagenation pagenation);

	/**
	 * insert
	 * @param sellerPointsDetail
	 * @return
	 */
	public Integer insert(SellerPointsDetail sellerPointsDetail);


	/**
	 * update
	 * @param sellerPointsDetail
	 * @return
	 */
	public Integer update(SellerPointsDetail sellerPointsDetail);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

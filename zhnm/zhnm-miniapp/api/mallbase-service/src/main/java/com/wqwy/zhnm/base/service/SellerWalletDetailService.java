/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.SellerWalletDetail;

import java.util.List;

/**
 * createTime: 2018-05-08 18:51:12
 * @author seven
 * @version
 */
public interface SellerWalletDetailService {

	/**
	 * query
	 * @param id
	 * @return SellerWalletDetail
	 */
	public SellerWalletDetail get(String id);

	/**
	 * query
	 * @param sellerWalletDetail
	 * @return List<SellerWalletDetail>
	 */
	public List<SellerWalletDetail> findList(SellerWalletDetail sellerWalletDetail);

	/**
	 * query
	 * @param sellerWalletDetail
	 * @return Page<SellerWalletDetail>
	 */
	public Page<SellerWalletDetail> findListByPage(SellerWalletDetail sellerWalletDetail, Pagenation pagenation);

	/**
	 * insert
	 * @param sellerWalletDetail
	 * @return
	 */
	public Integer insert(SellerWalletDetail sellerWalletDetail);


	/**
	 * update
	 * @param sellerWalletDetail
	 * @return
	 */
	public Integer update(SellerWalletDetail sellerWalletDetail);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

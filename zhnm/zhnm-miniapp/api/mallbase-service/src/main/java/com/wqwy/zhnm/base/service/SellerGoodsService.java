/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.SellerGoods;

import java.util.List;

/**
 * createTime: 2018-05-08 18:51:10
 * @author seven
 * @version
 */
public interface SellerGoodsService {

	/**
	 * query
	 * @param id
	 * @return SellerGoods
	 */
	public SellerGoods get(String id);
	
	/**
	 * query by condition
	 * @param sellerGoods
	 * @return Integer
	 */
	public Integer getCountByCondition(SellerGoods sellerGoods );

	/**
	 * query
	 * @param sellerGoods
	 * @return List<SellerGoods>
	 */
	public List<SellerGoods> findList(SellerGoods sellerGoods);

	/**
	 * query
	 * @param sellerGoods
	 * @return Page<SellerGoods>
	 */
	public Page<SellerGoods> findListByPage(SellerGoods sellerGoods, Pagenation pagenation);

	/**
	 * insert
	 * @param sellerGoods
	 * @return
	 */
	public Integer insert(SellerGoods sellerGoods);


	/**
	 * update
	 * @param sellerGoods
	 * @return
	 */
	public Integer update(SellerGoods sellerGoods);
	
	public Integer updateAllStock(SellerGoods sellerGoods);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

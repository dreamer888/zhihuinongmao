/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.component.SellerMarketComponent;
import com.wqwy.zhnm.base.component.request.SellerRegisterRequest;
import com.wqwy.zhnm.base.component.response.SellerDetailResponse;
import com.wqwy.zhnm.base.entity.Seller;

/**
 * createTime: 2018-05-08 18:51:02
 * @author seven
 * @version
 */
public interface SellerService {

	/**
	 * query
	 * @param id
	 * @return Seller
	 */
	public Seller get(String id);
	
	public SellerMarketComponent getWithMarket(String id);

	/**
	 * query
	 * @param seller
	 * @return List<Seller>
	 */
	public List<Seller> findList(Seller seller);

	/**
	 * query
	 * @param seller
	 * @return Page<Seller>
	 */
	public Page<Seller> findListByPage(Seller seller, Pagenation pagenation);

	/**
	 * insert
	 * @param seller
	 * @return SellerDetailResponse
	 */
	/**
	 * 
	 * @Title: insert  
	 * @Description: 商户注册  
	 * @date 20 May 2018 10:38:46 AM  
	 * @param @param seller
	 * @param @return  
	 * @return SellerDetailResponse  
	 * @throws
	 */
	public SellerDetailResponse insert(SellerRegisterRequest seller);


	/**
	 * update
	 * @param seller
	 * @return
	 */
	public Integer update(Seller seller);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);


}

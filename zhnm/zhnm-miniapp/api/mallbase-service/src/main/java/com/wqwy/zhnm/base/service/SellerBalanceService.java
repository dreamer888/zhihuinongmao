/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.SellerBalance;
import com.wqwy.zhnm.base.entity.SellerBankAccount;

import java.util.List;

/**
 * createTime: 2018-05-08 18:51:06
 * @author seven
 * @version
 */
public interface SellerBalanceService {

	/**
	 * query
	 * @param id
	 * @return SellerBalance
	 */
	public SellerBalance get(String id);

	/**
	 * query
	 * @param sellerBalance
	 * @return List<SellerBalance>
	 */
	public List<SellerBalance> findList(SellerBalance sellerBalance);

	/**
	 * query
	 * @param sellerBalance
	 * @return Page<SellerBalance>
	 */
	public Page<SellerBalance> findListByPage(SellerBalance sellerBalance, Pagenation pagenation);

	/**
	 * insert
	 * @param sellerBalance
	 * @return
	 */
	public Integer insert(SellerBalance sellerBalance);


	/**
	 * update
	 * @param sellerBalance
	 * @return
	 */
	public Integer update(SellerBalance sellerBalance);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);
	
	/**
	 * findByMerchantId
	 * @param merchantId
	 * @return
	 */
	public SellerBalance findByMerchantId(SellerBankAccount sellerBankAccount);



}

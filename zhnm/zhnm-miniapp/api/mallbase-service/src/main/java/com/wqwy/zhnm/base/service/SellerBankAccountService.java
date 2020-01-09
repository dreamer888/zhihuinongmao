/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.SellerBankAccount;

import java.util.List;

/**
 * createTime: 2018-05-08 18:51:07
 * @author seven
 * @version
 */
public interface SellerBankAccountService {

	/**
	 * query
	 * @param id
	 * @return SellerBankAccount
	 */
	public SellerBankAccount get(String id);

	/**
	 * query
	 * @param sellerBankAccount
	 * @return List<SellerBankAccount>
	 */
	public List<SellerBankAccount> findList(SellerBankAccount sellerBankAccount);

	/**
	 * query
	 * @param sellerBankAccount
	 * @return Page<SellerBankAccount>
	 */
	public Page<SellerBankAccount> findListByPage(SellerBankAccount sellerBankAccount, Pagenation pagenation);

	/**
	 * insert
	 * @param sellerBankAccount
	 * @return
	 */
	public Integer insert(SellerBankAccount sellerBankAccount);


	/**
	 * update
	 * @param sellerBankAccount
	 * @return
	 */
	public Integer update(SellerBankAccount sellerBankAccount);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

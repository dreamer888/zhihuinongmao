/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.DelivererBankAccount;

import java.util.List;

/**
 * createTime: 2018-05-08 18:50:57
 * @author seven
 * @version
 */
public interface DelivererBankAccountService {

	/**
	 * query
	 * @param id
	 * @return DelivererBankAccount
	 */
	public DelivererBankAccount get(String id);

	/**
	 * query
	 * @param delivererBankAccount
	 * @return List<DelivererBankAccount>
	 */
	public List<DelivererBankAccount> findList(DelivererBankAccount delivererBankAccount);

	/**
	 * query
	 * @param delivererBankAccount
	 * @return Page<DelivererBankAccount>
	 */
	public Page<DelivererBankAccount> findListByPage(DelivererBankAccount delivererBankAccount, Pagenation pagenation);

	/**
	 * insert
	 * @param delivererBankAccount
	 * @return
	 */
	public Integer insert(DelivererBankAccount delivererBankAccount);


	/**
	 * update
	 * @param delivererBankAccount
	 * @return
	 */
	public Integer update(DelivererBankAccount delivererBankAccount);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

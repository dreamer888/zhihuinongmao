/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.SellerBankAccount;
import java.util.List;

/**
 * createTime: 2018-05-08 18:51:07
 * @author seven
 * @version
 */
public interface SellerBankAccountMapper {

	/**
	 * query by id
	 * @param id
	 * @return SellerBankAccount
	 */
	public SellerBankAccount get(String id );

	/**
	 * query by condition
	 * @param sellerBankAccount
	 * @return List<SellerBankAccount>
	 */
	public List<SellerBankAccount> findList(SellerBankAccount sellerBankAccount);

	/**
	 * query by paging
	 * @param sellerBankAccount
	 * @return Page<SellerBankAccount>
	 */
	public Page<SellerBankAccount> findListByPage(SellerBankAccount sellerBankAccount);

	/**
	 * insert
	 * @param sellerBankAccount
	 * @return if success then != 0 else =0
	 */
	public Integer insert(SellerBankAccount sellerBankAccount);


	/**
	 * update
	 * @param sellerBankAccount
	 * @return if success then != 0 else =0
	 */
	public Integer update(SellerBankAccount sellerBankAccount);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

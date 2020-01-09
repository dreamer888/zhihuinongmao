/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.DelivererBankAccount;
import java.util.List;

/**
 * createTime: 2018-05-08 18:50:57
 * @author seven
 * @version
 */
public interface DelivererBankAccountMapper {

	/**
	 * query by id
	 * @param id
	 * @return DelivererBankAccount
	 */
	public DelivererBankAccount get(String id );

	/**
	 * query by condition
	 * @param delivererBankAccount
	 * @return List<DelivererBankAccount>
	 */
	public List<DelivererBankAccount> findList(DelivererBankAccount delivererBankAccount);

	/**
	 * query by paging
	 * @param delivererBankAccount
	 * @return Page<DelivererBankAccount>
	 */
	public Page<DelivererBankAccount> findListByPage(DelivererBankAccount delivererBankAccount);

	/**
	 * insert
	 * @param delivererBankAccount
	 * @return if success then != 0 else =0
	 */
	public Integer insert(DelivererBankAccount delivererBankAccount);


	/**
	 * update
	 * @param delivererBankAccount
	 * @return if success then != 0 else =0
	 */
	public Integer update(DelivererBankAccount delivererBankAccount);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

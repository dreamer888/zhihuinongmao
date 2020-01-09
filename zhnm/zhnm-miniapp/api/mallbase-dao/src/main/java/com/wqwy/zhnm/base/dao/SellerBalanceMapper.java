/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.SellerBalance;
import com.wqwy.zhnm.base.entity.SellerBankAccount;

import java.util.List;

/**
 * createTime: 2018-05-08 18:51:06
 * @author seven
 * @version
 */
public interface SellerBalanceMapper {

	/**
	 * query by id
	 * @param id
	 * @return SellerBalance
	 */
	public SellerBalance get(String id );

	/**
	 * query by condition
	 * @param sellerBalance
	 * @return List<SellerBalance>
	 */
	public List<SellerBalance> findList(SellerBalance sellerBalance);

	/**
	 * query by paging
	 * @param sellerBalance
	 * @return Page<SellerBalance>
	 */
	public Page<SellerBalance> findListByPage(SellerBalance sellerBalance);

	/**
	 * insert
	 * @param sellerBalance
	 * @return if success then != 0 else =0
	 */
	public Integer insert(SellerBalance sellerBalance);


	/**
	 * update
	 * @param sellerBalance
	 * @return if success then != 0 else =0
	 */
	public Integer update(SellerBalance sellerBalance);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);
	
	/**
	 * findByMerchantId
	 * @param merchantId
	 */
	public SellerBalance findByMerchantId(SellerBankAccount account);
	

}

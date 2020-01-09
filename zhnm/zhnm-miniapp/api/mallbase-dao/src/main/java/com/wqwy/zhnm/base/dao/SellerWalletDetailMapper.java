/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.SellerWalletDetail;
import java.util.List;

/**
 * createTime: 2018-05-08 18:51:12
 * @author seven
 * @version
 */
public interface SellerWalletDetailMapper {

	/**
	 * query by id
	 * @param id
	 * @return SellerWalletDetail
	 */
	public SellerWalletDetail get(String id );

	/**
	 * query by condition
	 * @param sellerWalletDetail
	 * @return List<SellerWalletDetail>
	 */
	public List<SellerWalletDetail> findList(SellerWalletDetail sellerWalletDetail);

	/**
	 * query by paging
	 * @param sellerWalletDetail
	 * @return Page<SellerWalletDetail>
	 */
	public Page<SellerWalletDetail> findListByPage(SellerWalletDetail sellerWalletDetail);

	/**
	 * insert
	 * @param sellerWalletDetail
	 * @return if success then != 0 else =0
	 */
	public Integer insert(SellerWalletDetail sellerWalletDetail);


	/**
	 * update
	 * @param sellerWalletDetail
	 * @return if success then != 0 else =0
	 */
	public Integer update(SellerWalletDetail sellerWalletDetail);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

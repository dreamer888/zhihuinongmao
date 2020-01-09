/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.DelivererWalletDetail;
import java.util.List;

/**
 * createTime: 2018-05-08 18:51:00
 * @author seven
 * @version
 */
public interface DelivererWalletDetailMapper {

	/**
	 * query by id
	 * @param id
	 * @return DelivererWalletDetail
	 */
	public DelivererWalletDetail get(String id );

	/**
	 * query by condition
	 * @param delivererWalletDetail
	 * @return List<DelivererWalletDetail>
	 */
	public List<DelivererWalletDetail> findList(DelivererWalletDetail delivererWalletDetail);

	/**
	 * query by paging
	 * @param delivererWalletDetail
	 * @return Page<DelivererWalletDetail>
	 */
	public Page<DelivererWalletDetail> findListByPage(DelivererWalletDetail delivererWalletDetail);

	/**
	 * insert
	 * @param delivererWalletDetail
	 * @return if success then != 0 else =0
	 */
	public Integer insert(DelivererWalletDetail delivererWalletDetail);


	/**
	 * update
	 * @param delivererWalletDetail
	 * @return if success then != 0 else =0
	 */
	public Integer update(DelivererWalletDetail delivererWalletDetail);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.SellerPointsDetail;
import java.util.List;

/**
 * createTime: 2018-05-08 18:51:11
 * @author seven
 * @version
 */
public interface SellerPointsDetailMapper {

	/**
	 * query by id
	 * @param id
	 * @return SellerPointsDetail
	 */
	public SellerPointsDetail get(String id );

	/**
	 * query by condition
	 * @param sellerPointsDetail
	 * @return List<SellerPointsDetail>
	 */
	public List<SellerPointsDetail> findList(SellerPointsDetail sellerPointsDetail);

	/**
	 * query by paging
	 * @param sellerPointsDetail
	 * @return Page<SellerPointsDetail>
	 */
	public Page<SellerPointsDetail> findListByPage(SellerPointsDetail sellerPointsDetail);

	/**
	 * insert
	 * @param sellerPointsDetail
	 * @return if success then != 0 else =0
	 */
	public Integer insert(SellerPointsDetail sellerPointsDetail);


	/**
	 * update
	 * @param sellerPointsDetail
	 * @return if success then != 0 else =0
	 */
	public Integer update(SellerPointsDetail sellerPointsDetail);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

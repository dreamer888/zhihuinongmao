/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.ShopCategory;
import java.util.List;

/**
 * createTime: 2018-05-09 11:52:14
 * @author seven
 * @version
 */
public interface ShopCategoryMapper {

	/**
	 * query by categoryId
	 * @param categoryId
	 * @return ShopCategory
	 */
	public ShopCategory get(String categoryId );

	/**
	 * query by condition
	 * @param shopCategory
	 * @return List<ShopCategory>
	 */
	public List<ShopCategory> findList(ShopCategory shopCategory);

	/**
	 * query by paging
	 * @param shopCategory
	 * @return Page<ShopCategory>
	 */
	public Page<ShopCategory> findListByPage(ShopCategory shopCategory);

	/**
	 * insert
	 * @param shopCategory
	 * @return if success then != 0 else =0
	 */
	public Integer insert(ShopCategory shopCategory);


	/**
	 * update
	 * @param shopCategory
	 * @return if success then != 0 else =0
	 */
	public Integer update(ShopCategory shopCategory);


	/**
	 * delete
	 * @param categoryId
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String categoryId);

}

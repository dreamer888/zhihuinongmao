/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.ShopCategoryLevelOneDTO;
import com.wqwy.zhnm.base.entity.ShopCategory;

/**
 * createTime: 2018-05-09 11:52:14
 * @author seven
 * @version
 */
public interface ShopCategoryService {

	/**
	 * query
	 * @param categoryId
	 * @return ShopCategory
	 */
	public ShopCategory get(String categoryId);

	/**
	 * query
	 * @param shopCategory
	 * @return List<ShopCategory>
	 */
	public List<ShopCategory> findList(ShopCategory shopCategory);

	/**
	 * query
	 * @param shopCategory
	 * @return Page<ShopCategory>
	 */
	public Page<ShopCategory> findListByPage(ShopCategory shopCategory, Pagenation pagenation);

	/**
	 * insert
	 * @param shopCategory
	 * @return
	 */
	public Integer insert(ShopCategory shopCategory);


	/**
	 * update
	 * @param shopCategory
	 * @return
	 */
	public Integer update(ShopCategory shopCategory);


	/**
	 * delete
	 * @param categoryId
	 * @return
	 */
	public Integer delete(String categoryId);

	/**
	 * 
	 * @Title: findAllShopCategoriesWithLevel  
	 * @Description: 搜索所有shopCategory并按照layer&sort组合返回  
	 * @date 22 May 2018 4:41:17 PM  
	 * @param @return  
	 * @return List<ShopCategoryLevelOneDTO>  
	 * @throws
	 */
	public List<ShopCategoryLevelOneDTO> findAllShopCategoriesWithLevel();


}

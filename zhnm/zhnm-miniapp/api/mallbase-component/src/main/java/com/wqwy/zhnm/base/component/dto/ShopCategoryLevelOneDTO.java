package com.wqwy.zhnm.base.component.dto;

import java.util.List;

import com.wqwy.zhnm.base.entity.ShopCategory;

/**
 * 
 * @ClassName: ShopCategoryLevelOneDTO  
 * @Description: shopCategory only have two layers now  
 * @author seven  
 * @date 22 May 2018 4:36:02 PM  
 *
 */
public class ShopCategoryLevelOneDTO extends ShopCategory{

	private List<ShopCategory> shopCategories;

	public List<ShopCategory> getShopCategories() {
		return shopCategories;
	}

	public void setShopCategories(List<ShopCategory> shopCategories) {
		this.shopCategories = shopCategories;
	}
	
}

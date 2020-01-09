/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.ShopCategoryLevelOneDTO;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.ShopCategory;
import com.wqwy.zhnm.base.service.ShopCategoryService;
import com.wqwy.zhnm.seller.config.SellerJobAfterContextRefreshedService;

/**
 * createTime: 2018-05-09 11:52:14
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class ShopCategoryController {

	@Autowired
	private ShopCategoryService  shopCategoryService;
	
	@Autowired
	private SellerJobAfterContextRefreshedService sellerJobAfterContextRefreshedService;

	/**
	 * 
	 * @date 2018-05-09 11:52:14
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param shopCategory
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<ShopCategory>>
	 * @throws
	 */
	@RequestMapping(value="shopCategories", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<ShopCategory>> findByPage(ShopCategory shopCategory, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<ShopCategory> queryResultList = shopCategoryService.findListByPage(shopCategory, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<ShopCategory>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}
	
	/**
	 * 
	 * @Title: findByPageCollected  
	 * @Description: 获取已经排序组合好了的list  
	 * @date 22 May 2018 5:30:31 PM  
	 * @param @param request
	 * @param @param model
	 * @param @return  
	 * @return JsonResponse<List<ShopCategoryLevelOneDTO>>  
	 * @throws
	 */
	@RequestMapping(value="shopCategoriesCollected", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<List<ShopCategoryLevelOneDTO>> findByPageCollected(HttpServletRequest request, Model model) {
		//return new JsonResponse<List<ShopCategoryLevelOneDTO>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerJobAfterContextRefreshedService.getScloDTOList());
		return new JsonResponse<List<ShopCategoryLevelOneDTO>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerJobAfterContextRefreshedService.getShopCategoryLevelImmediately());
	}


	/**
	 * 
	 * @date 2018-05-09 11:52:14
	 * @Title: findShopCategoryDetail 
	 * @Description: TODO
	 * @param @param shopCategory
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopCategory>
	 * @throws
	 */
	@RequestMapping(value="shopCategories/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopCategory> findShopCategoryDetail(@PathVariable("id")Integer id, ShopCategory shopCategory, HttpServletRequest request){
		shopCategory = shopCategoryService.get(id.toString());
		return new JsonResponse<ShopCategory>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopCategory);
	}

	
	/**
	 * 
	 * @date 2018-05-09 11:52:14
	 * @Title: modifyShopCategoryDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param shopCategory
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopCategory>
	 * @throws
	 */
	@RequestMapping(value="shopCategories/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopCategory> modifyShopCategoryDetail(@PathVariable("id")String id, @RequestBody ShopCategory shopCategory, HttpServletRequest request){
		shopCategory.setCategoryId(id);
		shopCategoryService.update(shopCategory);
		return new JsonResponse<ShopCategory>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopCategoryService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-09 11:52:14
	 * @Title: addShopCategory 
	 * @Description: TODO
	 * @param @param shopCategory
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopCategory>
	 * @throws
	 */
	@RequestMapping(value="shopCategories", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopCategory> addShopCategory(@RequestBody ShopCategory shopCategory, HttpServletRequest request){
		shopCategoryService.insert(shopCategory);
		return new JsonResponse<ShopCategory>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopCategoryService.findList(shopCategory).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-09 11:52:14
	 * @Title: removeShopCategory 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="shopCategories/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeShopCategory(@PathVariable("id")Integer id, HttpServletRequest request){
		shopCategoryService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

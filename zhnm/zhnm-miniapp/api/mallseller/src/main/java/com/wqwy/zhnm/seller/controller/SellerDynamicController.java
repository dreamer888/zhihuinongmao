/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import com.github.pagehelper.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.wqwy.zhnm.base.entity.SellerDynamic;
import com.wqwy.zhnm.base.service.SellerDynamicService;
import com.wqwy.zhnm.seller.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:51:09
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class SellerDynamicController extends BaseController {

	@Autowired
	private SellerDynamicService  sellerDynamicService;

	/**
	 * 
	 * @date 2018-05-08 18:51:09
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param sellerDynamic
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<SellerDynamic>>
	 * @throws
	 */
	@RequestMapping(value="sellerDynamics", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<SellerDynamic>> findByPage(SellerDynamic sellerDynamic, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<SellerDynamic> queryResultList = sellerDynamicService.findListByPage(sellerDynamic, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<SellerDynamic>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:51:09
	 * @Title: findSellerDynamicDetail 
	 * @Description: TODO
	 * @param @param sellerDynamic
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerDynamic>
	 * @throws
	 */
	@RequestMapping(value="sellerDynamics/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerDynamic> findSellerDynamicDetail(@PathVariable("id")Integer id, SellerDynamic sellerDynamic, HttpServletRequest request){
		sellerDynamic = sellerDynamicService.get(id.toString());
		return new JsonResponse<SellerDynamic>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerDynamic);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:51:09
	 * @Title: modifySellerDynamicDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param sellerDynamic
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerDynamic>
	 * @throws
	 */
	@RequestMapping(value="sellerDynamics/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerDynamic> modifySellerDynamicDetail(@PathVariable("id")Integer id, @RequestBody SellerDynamic sellerDynamic, HttpServletRequest request){
		sellerDynamic.setId(id);
		sellerDynamicService.update(sellerDynamic);
		return new JsonResponse<SellerDynamic>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerDynamicService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:51:09
	 * @Title: addSellerDynamic 
	 * @Description: TODO
	 * @param @param sellerDynamic
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerDynamic>
	 * @throws
	 */
	@RequestMapping(value="sellerDynamics", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerDynamic> addSellerDynamic(@RequestBody SellerDynamic sellerDynamic, HttpServletRequest request){
		sellerDynamicService.insert(sellerDynamic);
		return new JsonResponse<SellerDynamic>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerDynamicService.findList(sellerDynamic).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:09
	 * @Title: removeSellerDynamic 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="sellerDynamics/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeSellerDynamic(@PathVariable("id")Integer id, HttpServletRequest request){
		sellerDynamicService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

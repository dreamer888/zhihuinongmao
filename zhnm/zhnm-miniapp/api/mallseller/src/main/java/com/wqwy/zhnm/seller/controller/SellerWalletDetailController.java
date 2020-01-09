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

import com.wqwy.zhnm.base.entity.SellerWalletDetail;
import com.wqwy.zhnm.base.service.SellerWalletDetailService;
import com.wqwy.zhnm.seller.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:51:12
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class SellerWalletDetailController extends BaseController {

	@Autowired
	private SellerWalletDetailService  sellerWalletDetailService;

	/**
	 * 
	 * @date 2018-05-08 18:51:12
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param sellerWalletDetail
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<SellerWalletDetail>>
	 * @throws
	 */
	@RequestMapping(value="sellerWalletDetails", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<SellerWalletDetail>> findByPage(SellerWalletDetail sellerWalletDetail, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<SellerWalletDetail> queryResultList = sellerWalletDetailService.findListByPage(sellerWalletDetail, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<SellerWalletDetail>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:51:12
	 * @Title: findSellerWalletDetailDetail 
	 * @Description: TODO
	 * @param @param sellerWalletDetail
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerWalletDetail>
	 * @throws
	 */
	@RequestMapping(value="sellerWalletDetails/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerWalletDetail> findSellerWalletDetailDetail(@PathVariable("id")Integer id, SellerWalletDetail sellerWalletDetail, HttpServletRequest request){
		sellerWalletDetail = sellerWalletDetailService.get(id.toString());
		return new JsonResponse<SellerWalletDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerWalletDetail);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:51:12
	 * @Title: modifySellerWalletDetailDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param sellerWalletDetail
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerWalletDetail>
	 * @throws
	 */
	@RequestMapping(value="sellerWalletDetails/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerWalletDetail> modifySellerWalletDetailDetail(@PathVariable("id")Integer id, @RequestBody SellerWalletDetail sellerWalletDetail, HttpServletRequest request){
		sellerWalletDetail.setId(id);
		sellerWalletDetailService.update(sellerWalletDetail);
		return new JsonResponse<SellerWalletDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerWalletDetailService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:51:12
	 * @Title: addSellerWalletDetail 
	 * @Description: TODO
	 * @param @param sellerWalletDetail
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerWalletDetail>
	 * @throws
	 */
	@RequestMapping(value="sellerWalletDetails", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerWalletDetail> addSellerWalletDetail(@RequestBody SellerWalletDetail sellerWalletDetail, HttpServletRequest request){
		sellerWalletDetailService.insert(sellerWalletDetail);
		return new JsonResponse<SellerWalletDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerWalletDetailService.findList(sellerWalletDetail).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:12
	 * @Title: removeSellerWalletDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="sellerWalletDetails/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeSellerWalletDetail(@PathVariable("id")Integer id, HttpServletRequest request){
		sellerWalletDetailService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

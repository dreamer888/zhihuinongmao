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

import com.wqwy.zhnm.base.entity.SellerPointsDetail;
import com.wqwy.zhnm.base.service.SellerPointsDetailService;
import com.wqwy.zhnm.seller.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:51:11
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class SellerPointsDetailController extends BaseController {

	@Autowired
	private SellerPointsDetailService  sellerPointsDetailService;

	/**
	 * 
	 * @date 2018-05-08 18:51:11
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param sellerPointsDetail
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<SellerPointsDetail>>
	 * @throws
	 */
	@RequestMapping(value="sellerPointsDetails", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<SellerPointsDetail>> findByPage(SellerPointsDetail sellerPointsDetail, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<SellerPointsDetail> queryResultList = sellerPointsDetailService.findListByPage(sellerPointsDetail, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<SellerPointsDetail>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:51:11
	 * @Title: findSellerPointsDetailDetail 
	 * @Description: TODO
	 * @param @param sellerPointsDetail
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerPointsDetail>
	 * @throws
	 */
	@RequestMapping(value="sellerPointsDetails/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerPointsDetail> findSellerPointsDetailDetail(@PathVariable("id")Integer id, SellerPointsDetail sellerPointsDetail, HttpServletRequest request){
		sellerPointsDetail = sellerPointsDetailService.get(id.toString());
		return new JsonResponse<SellerPointsDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerPointsDetail);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:51:11
	 * @Title: modifySellerPointsDetailDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param sellerPointsDetail
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerPointsDetail>
	 * @throws
	 */
	@RequestMapping(value="sellerPointsDetails/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerPointsDetail> modifySellerPointsDetailDetail(@PathVariable("id")Integer id, @RequestBody SellerPointsDetail sellerPointsDetail, HttpServletRequest request){
		sellerPointsDetail.setId(id);
		sellerPointsDetailService.update(sellerPointsDetail);
		return new JsonResponse<SellerPointsDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerPointsDetailService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:51:11
	 * @Title: addSellerPointsDetail 
	 * @Description: TODO
	 * @param @param sellerPointsDetail
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerPointsDetail>
	 * @throws
	 */
	@RequestMapping(value="sellerPointsDetails", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerPointsDetail> addSellerPointsDetail(@RequestBody SellerPointsDetail sellerPointsDetail, HttpServletRequest request){
		sellerPointsDetailService.insert(sellerPointsDetail);
		return new JsonResponse<SellerPointsDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerPointsDetailService.findList(sellerPointsDetail).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:11
	 * @Title: removeSellerPointsDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="sellerPointsDetails/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeSellerPointsDetail(@PathVariable("id")Integer id, HttpServletRequest request){
		sellerPointsDetailService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

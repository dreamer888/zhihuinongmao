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

import com.wqwy.zhnm.base.entity.SellerBalance;
import com.wqwy.zhnm.base.service.SellerBalanceService;
import com.wqwy.zhnm.seller.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:51:06
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class SellerBalanceController extends BaseController {

	@Autowired
	private SellerBalanceService  sellerBalanceService;

	/**
	 * 
	 * @date 2018-05-08 18:51:06
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param sellerBalance
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<SellerBalance>>
	 * @throws
	 */
	@RequestMapping(value="sellerBalances", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<SellerBalance>> findByPage(SellerBalance sellerBalance, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<SellerBalance> queryResultList = sellerBalanceService.findListByPage(sellerBalance, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<SellerBalance>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:51:06
	 * @Title: findSellerBalanceDetail 
	 * @Description: TODO
	 * @param @param sellerBalance
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerBalance>
	 * @throws
	 */
	@RequestMapping(value="sellerBalances/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerBalance> findSellerBalanceDetail(@PathVariable("id")Integer id, SellerBalance sellerBalance, HttpServletRequest request){
		sellerBalance = sellerBalanceService.get(id.toString());
		return new JsonResponse<SellerBalance>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerBalance);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:51:06
	 * @Title: modifySellerBalanceDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param sellerBalance
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerBalance>
	 * @throws
	 */
	@RequestMapping(value="sellerBalances/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerBalance> modifySellerBalanceDetail(@PathVariable("id")Integer id, @RequestBody SellerBalance sellerBalance, HttpServletRequest request){
		sellerBalance.setId(id);
		sellerBalanceService.update(sellerBalance);
		return new JsonResponse<SellerBalance>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerBalanceService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:51:06
	 * @Title: addSellerBalance 
	 * @Description: TODO
	 * @param @param sellerBalance
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerBalance>
	 * @throws
	 */
	@RequestMapping(value="sellerBalances", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerBalance> addSellerBalance(@RequestBody SellerBalance sellerBalance, HttpServletRequest request){
		sellerBalanceService.insert(sellerBalance);
		return new JsonResponse<SellerBalance>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerBalanceService.findList(sellerBalance).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:06
	 * @Title: removeSellerBalance 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="sellerBalances/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeSellerBalance(@PathVariable("id")Integer id, HttpServletRequest request){
		sellerBalanceService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

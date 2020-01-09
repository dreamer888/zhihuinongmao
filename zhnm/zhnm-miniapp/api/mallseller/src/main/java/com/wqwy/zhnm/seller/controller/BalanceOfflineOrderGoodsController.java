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

import com.wqwy.zhnm.base.entity.BalanceOfflineOrderGoods;
import com.wqwy.zhnm.base.service.BalanceOfflineOrderGoodsService;
import com.wqwy.zhnm.seller.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:52:23
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class BalanceOfflineOrderGoodsController extends BaseController {

	@Autowired
	private BalanceOfflineOrderGoodsService  balanceOfflineOrderGoodsService;

	/**
	 * 
	 * @date 2018-05-08 18:52:23
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param balanceOfflineOrderGoods
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<BalanceOfflineOrderGoods>>
	 * @throws
	 */
	@RequestMapping(value="balanceOfflineOrderGoodss", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<BalanceOfflineOrderGoods>> findByPage(BalanceOfflineOrderGoods balanceOfflineOrderGoods, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<BalanceOfflineOrderGoods> queryResultList = balanceOfflineOrderGoodsService.findListByPage(balanceOfflineOrderGoods, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<BalanceOfflineOrderGoods>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:52:23
	 * @Title: findBalanceOfflineOrderGoodsDetail 
	 * @Description: TODO
	 * @param @param balanceOfflineOrderGoods
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<BalanceOfflineOrderGoods>
	 * @throws
	 */
	@RequestMapping(value="balanceOfflineOrderGoodss/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<BalanceOfflineOrderGoods> findBalanceOfflineOrderGoodsDetail(@PathVariable("id")Integer id, BalanceOfflineOrderGoods balanceOfflineOrderGoods, HttpServletRequest request){
		balanceOfflineOrderGoods = balanceOfflineOrderGoodsService.get(id.toString());
		return new JsonResponse<BalanceOfflineOrderGoods>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, balanceOfflineOrderGoods);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:52:23
	 * @Title: modifyBalanceOfflineOrderGoodsDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param balanceOfflineOrderGoods
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<BalanceOfflineOrderGoods>
	 * @throws
	 */
	@RequestMapping(value="balanceOfflineOrderGoodss/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<BalanceOfflineOrderGoods> modifyBalanceOfflineOrderGoodsDetail(@PathVariable("id")Integer id, @RequestBody BalanceOfflineOrderGoods balanceOfflineOrderGoods, HttpServletRequest request){
		balanceOfflineOrderGoods.setId(id);
		balanceOfflineOrderGoodsService.update(balanceOfflineOrderGoods);
		return new JsonResponse<BalanceOfflineOrderGoods>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, balanceOfflineOrderGoodsService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:52:23
	 * @Title: addBalanceOfflineOrderGoods 
	 * @Description: TODO
	 * @param @param balanceOfflineOrderGoods
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<BalanceOfflineOrderGoods>
	 * @throws
	 */
	@RequestMapping(value="balanceOfflineOrderGoodss", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<BalanceOfflineOrderGoods> addBalanceOfflineOrderGoods(@RequestBody BalanceOfflineOrderGoods balanceOfflineOrderGoods, HttpServletRequest request){
		balanceOfflineOrderGoodsService.insert(balanceOfflineOrderGoods);
		return new JsonResponse<BalanceOfflineOrderGoods>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, balanceOfflineOrderGoodsService.findList(balanceOfflineOrderGoods).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:52:23
	 * @Title: removeBalanceOfflineOrderGoods 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="balanceOfflineOrderGoodss/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeBalanceOfflineOrderGoods(@PathVariable("id")Integer id, HttpServletRequest request){
		balanceOfflineOrderGoodsService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.delivery.controller;

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

import com.wqwy.zhnm.base.entity.DelivererMarket;
import com.wqwy.zhnm.base.service.DelivererMarketService;
import com.wqwy.zhnm.delivery.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:50:59
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class DelivererMarketController extends BaseController {

	@Autowired
	private DelivererMarketService  delivererMarketService;

	/**
	 * 
	 * @date 2018-05-08 18:50:59
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param delivererMarket
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<DelivererMarket>>
	 * @throws
	 */
	@RequestMapping(value="delivererMarkets", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<DelivererMarket>> findByPage(DelivererMarket delivererMarket, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<DelivererMarket> queryResultList = delivererMarketService.findListByPage(delivererMarket, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<DelivererMarket>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:50:59
	 * @Title: findDelivererMarketDetail 
	 * @Description: TODO
	 * @param @param delivererMarket
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererMarket>
	 * @throws
	 */
	@RequestMapping(value="delivererMarkets/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererMarket> findDelivererMarketDetail(@PathVariable("id")Integer id, DelivererMarket delivererMarket, HttpServletRequest request){
		delivererMarket = delivererMarketService.get(id.toString());
		return new JsonResponse<DelivererMarket>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererMarket);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:50:59
	 * @Title: modifyDelivererMarketDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param delivererMarket
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererMarket>
	 * @throws
	 */
	@RequestMapping(value="delivererMarkets/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererMarket> modifyDelivererMarketDetail(@PathVariable("id")Integer id, @RequestBody DelivererMarket delivererMarket, HttpServletRequest request){
		delivererMarket.setId(id);
		delivererMarketService.update(delivererMarket);
		return new JsonResponse<DelivererMarket>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererMarketService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:50:59
	 * @Title: addDelivererMarket 
	 * @Description: TODO
	 * @param @param delivererMarket
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererMarket>
	 * @throws
	 */
	@RequestMapping(value="delivererMarkets", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererMarket> addDelivererMarket(@RequestBody DelivererMarket delivererMarket, HttpServletRequest request){
		delivererMarketService.insert(delivererMarket);
		return new JsonResponse<DelivererMarket>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererMarketService.findList(delivererMarket).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:50:59
	 * @Title: removeDelivererMarket 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="delivererMarkets/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeDelivererMarket(@PathVariable("id")Integer id, HttpServletRequest request){
		delivererMarketService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

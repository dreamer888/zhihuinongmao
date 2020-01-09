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

import com.wqwy.zhnm.base.entity.Market;
import com.wqwy.zhnm.base.service.MarketService;
import com.wqwy.zhnm.seller.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:51:01
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class MarketController extends BaseController {

	@Autowired
	private MarketService  marketService;

	/**
	 * 
	 * @date 2018-05-08 18:51:01
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param market
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<Market>>
	 * @throws
	 */
	@RequestMapping(value="markets", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<Market>> findByPage(Market market, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<Market> queryResultList = marketService.findListByPage(market, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<Market>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:51:01
	 * @Title: findMarketDetail 
	 * @Description: TODO
	 * @param @param market
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Market>
	 * @throws
	 */
	@RequestMapping(value="markets/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Market> findMarketDetail(@PathVariable("id")Integer id, Market market, HttpServletRequest request){
		market = marketService.get(id.toString());
		return new JsonResponse<Market>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, market);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:51:01
	 * @Title: modifyMarketDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param market
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Market>
	 * @throws
	 */
	@RequestMapping(value="markets/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Market> modifyMarketDetail(@PathVariable("id")Integer id, @RequestBody Market market, HttpServletRequest request){
		market.setId(id);
		marketService.update(market);
		return new JsonResponse<Market>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, marketService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:51:01
	 * @Title: addMarket 
	 * @Description: TODO
	 * @param @param market
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Market>
	 * @throws
	 */
	@RequestMapping(value="markets", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Market> addMarket(@RequestBody Market market, HttpServletRequest request){
		marketService.insert(market);
		return new JsonResponse<Market>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, marketService.findList(market).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:01
	 * @Title: removeMarket 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="markets/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeMarket(@PathVariable("id")Integer id, HttpServletRequest request){
		marketService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

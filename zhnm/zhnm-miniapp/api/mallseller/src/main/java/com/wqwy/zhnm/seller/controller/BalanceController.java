/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.wqwy.zhnm.base.component.component.BalanceSellerGoodsHotKeyComponent;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.Balance;
import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.service.BalanceService;
import com.wqwy.zhnm.base.service.SellerGoodsService;
import com.wqwy.zhnm.seller.base.BaseController;

/**
 * createTime: 2018-05-08 17:47:07
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class BalanceController extends BaseController {

	@Autowired
	private BalanceService  balanceService;
	
	@Autowired
	private SellerGoodsService sellerGoodsService;

	/**
	 * 
	 * @date 2018-05-08 17:47:07
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param balance
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<Balance>>
	 * @throws
	 */
	@RequestMapping(value="balances", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<Balance>> findByPage(Balance balance, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<Balance> queryResultList = balanceService.findListByPage(balance, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<Balance>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}
	
	/**
	 * 
	 * @Title: getBalanceSellerGoodsHotKeys  
	 * @Description: 返回商户的称的快捷键的使用情况  
	 * @date 25 May 2018 7:41:49 PM  
	 * @param @param sellerId
	 * @param @param sellerGoods
	 * @param @return  
	 * @return JsonResponse<List<BalanceSellerGoodsHotKeyComponent>>  
	 * @throws
	 */
	@RequestMapping(value="balances/seller/{sellerId}/hotkey", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<List<BalanceSellerGoodsHotKeyComponent>> getBalanceSellerGoodsHotKeys(@PathVariable("sellerId") Integer sellerId, SellerGoods sellerGoods) {
		sellerGoods.setSellerId(sellerId);
		List<String> hotKeyList = sellerGoodsService.findList(sellerGoods).stream().map(SellerGoods::getBalanceHotkey).collect(Collectors.toList());
		Map<String, Integer> m2 = new HashMap<String, Integer>(DefaultConstants.BalanceSellerGoodsHotkeyMap);
		new HashSet<String>(hotKeyList).stream().forEach(s -> {
			if (m2.get(s)!=null)
				m2.put(s, m2.get(s)+1);
		});
		List<BalanceSellerGoodsHotKeyComponent> lr = new ArrayList<BalanceSellerGoodsHotKeyComponent>();
		m2.forEach((k,v) -> {
			BalanceSellerGoodsHotKeyComponent r = new BalanceSellerGoodsHotKeyComponent();
			r.setName(k);
			r.setStatus(v);
			lr.add(r);
		});
		return new JsonResponse<List<BalanceSellerGoodsHotKeyComponent>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, lr);
	}


	/**
	 * 
	 * @date 2018-05-08 17:47:07
	 * @Title: findBalanceDetail 
	 * @Description: TODO
	 * @param @param balance
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Balance>
	 * @throws
	 */
	@RequestMapping(value="balances/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Balance> findBalanceDetail(@PathVariable("id")Integer id, Balance balance, HttpServletRequest request){
		balance = balanceService.get(id.toString());
		return new JsonResponse<Balance>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, balance);
	}

	
	/**
	 * 
	 * @date 2018-05-08 17:47:07
	 * @Title: modifyBalanceDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param balance
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Balance>
	 * @throws
	 */
	@RequestMapping(value="balances/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Balance> modifyBalanceDetail(@PathVariable("id")Integer id, @RequestBody Balance balance, HttpServletRequest request){
		balance.setId(id);
		balanceService.update(balance);
		return new JsonResponse<Balance>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, balanceService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 17:47:07
	 * @Title: addBalance 
	 * @Description: TODO
	 * @param @param balance
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Balance>
	 * @throws
	 */
	@RequestMapping(value="balances", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Balance> addBalance(@RequestBody Balance balance, HttpServletRequest request){
		balanceService.insert(balance);
		return new JsonResponse<Balance>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, balanceService.findList(balance).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 17:47:07
	 * @Title: removeBalance 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="balances/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeBalance(@PathVariable("id")Integer id, HttpServletRequest request){
		balanceService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

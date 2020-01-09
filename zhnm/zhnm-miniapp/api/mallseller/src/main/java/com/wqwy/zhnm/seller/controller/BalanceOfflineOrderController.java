/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import java.math.BigDecimal;
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
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderDTO;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderGoodsDTO;
import com.wqwy.zhnm.base.component.request.BalanceOfflineOrderWithGoodsRequest;
import com.wqwy.zhnm.base.component.response.UnionPayQRCodeGenerateResponseToClient;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrder;
import com.wqwy.zhnm.base.service.BalanceOfflineOrderGoodsService;
import com.wqwy.zhnm.base.service.BalanceOfflineOrderService;
import com.wqwy.zhnm.seller.base.BaseController;

/**
 * createTime: 2018-05-08 18:51:13
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class BalanceOfflineOrderController extends BaseController {

	@Autowired
	private BalanceOfflineOrderService  balanceOfflineOrderService;
	
	@Autowired
	private BalanceOfflineOrderGoodsService  balanceOfflineOrderGoodsService;

	/**
	 * 
	 * @date 2018-05-08 18:51:13
	 * @Title: findByPage 
	 * @Description: 线下订单列表
	 * @param @param balanceOfflineOrder
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<BalanceOfflineOrder>>
	 * @throws
	 */
	@RequestMapping(value="balanceOfflineOrders", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<BalanceOfflineOrderDTO>> findByPage(BalanceOfflineOrderDTO balanceOfflineOrder, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<BalanceOfflineOrderDTO> queryResultList = balanceOfflineOrderService.findListByPage(balanceOfflineOrder, pagenation);
		/*
		 * 列表商品
		 */
		queryResultList.stream().forEach(q -> {
			BalanceOfflineOrderGoodsDTO boogDTO = new BalanceOfflineOrderGoodsDTO();
			boogDTO.setOrderNumber(q.getOrderNumber());
			List<BalanceOfflineOrderGoodsDTO> boogDTOList = balanceOfflineOrderGoodsService.findListSpecial(boogDTO);
			q.setBoogList(boogDTOList);
			q.setCurrentGoodsTotalPrice(new BigDecimal(boogDTOList.stream().filter(b -> b.getGoodsPrice()!=null&&b.getGoodsCount()!=null).mapToDouble(b -> b.getGoodsCount().multiply(b.getGoodsPrice()).doubleValue()).sum()).setScale(DefaultConstants.BIGDECIMAL_SHOW_DIGIT, BigDecimal.ROUND_HALF_UP));
		});
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<BalanceOfflineOrderDTO>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:51:13
	 * @Title: findBalanceOfflineOrderDetail 
	 * @Description: TODO
	 * @param @param balanceOfflineOrder
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<BalanceOfflineOrder>
	 * @throws
	 */
	@RequestMapping(value="balanceOfflineOrders/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<BalanceOfflineOrder> findBalanceOfflineOrderDetail(@PathVariable("id")Integer id, BalanceOfflineOrder balanceOfflineOrder, HttpServletRequest request){
		balanceOfflineOrder = balanceOfflineOrderService.get(id.toString());
		return new JsonResponse<BalanceOfflineOrder>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, balanceOfflineOrder);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:51:13
	 * @Title: modifyBalanceOfflineOrderDetail 
	 * @Description: 1.用户评价订单(remark不为null)
	 * @param @param id
	 * @param @param balanceOfflineOrder
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<BalanceOfflineOrder>
	 * @throws
	 */
	@RequestMapping(value="balanceOfflineOrders/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<BalanceOfflineOrder> modifyBalanceOfflineOrderDetail(@PathVariable("id")Integer id, @RequestBody BalanceOfflineOrder balanceOfflineOrder, HttpServletRequest request){
		balanceOfflineOrder.setId(id);
		balanceOfflineOrderService.update(balanceOfflineOrder);
		return new JsonResponse<BalanceOfflineOrder>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, balanceOfflineOrderService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:51:13
	 * @Title: addBalanceOfflineOrder 
	 * @Description: 线下订单添加
	 * @param @param balanceOfflineOrder
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<BalanceOfflineOrder>
	 * @throws
	 */
	/*
	 * 用户线下订单生成,返回客户端 二维码
	 */
	@RequestMapping(value="balanceOfflineOrders", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> addBalanceOfflineOrder(@RequestBody BalanceOfflineOrderWithGoodsRequest balanceOfflineOrder, HttpServletRequest request){
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, balanceOfflineOrderService.insert(balanceOfflineOrder));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:13
	 * @Title: removeBalanceOfflineOrder 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="balanceOfflineOrders/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeBalanceOfflineOrder(@PathVariable("id")Integer id, HttpServletRequest request){
		balanceOfflineOrderService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:13
	 * @Title: findBalanceOfflineOrderDetail 
	 * @Description: TODO
	 * @param @param balanceOfflineOrder
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<BalanceOfflineOrder>
	 * @throws
	 */
	@RequestMapping(value="getBalanceOfflineOrder/{orderId}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> getBalanceOfflineOrder(@PathVariable("orderId")Integer orderId, HttpServletRequest request){
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, balanceOfflineOrderService.getBalanceOfflineOrder(orderId));
	}
	
}

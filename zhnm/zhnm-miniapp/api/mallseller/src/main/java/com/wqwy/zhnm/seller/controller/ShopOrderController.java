/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderGoodsDTO;
import com.wqwy.zhnm.base.component.dto.OrderDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.service.BalanceOfflineOrderGoodsService;
import com.wqwy.zhnm.base.service.ShopOrderDetailService;
import com.wqwy.zhnm.base.service.ShopOrderService;
import com.wqwy.zhnm.base.service.base.RedisService;

/**
 * createTime: 2018-05-15 14:11:17
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class ShopOrderController {

	@Autowired
	private ShopOrderService  shopOrderService;
	
	@Autowired
	private ShopOrderDetailService shopOrderDetailService;
	
	@Autowired
	private BalanceOfflineOrderGoodsService  balanceOfflineOrderGoodsService;

	/**
	 * 
	 * @Title: findSellerShopOrdersByPage  
	 * @Description: 查询一个商户的所有订单  
	 * @date 23 May 2018 6:05:50 PM  
	 * @param @param id
	 * @param @param pagenation
	 * @param @param request
	 * @param @param model
	 * @param @return  
	 * @return PageJsonResponse<List<ShopOrderDTO>>  
	 * @throws
	 */
	@RequestMapping(value="shopOrders/seller/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<ShopOrderDTO>> findSellerShopOrdersByPage(@PathVariable("id")Integer id, ShopOrderDTO shopOrder, Pagenation pagenation, HttpServletRequest request, Model model) {
		shopOrder.setSellerId(id);
		Page<ShopOrderDTO> queryResultList = shopOrderService.findShopOrdersByPage(shopOrder, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		/*
		 * 结果list中每个订单添加子订单信息
		 */
		queryResultList.stream().forEach(q -> {
			ShopOrderDetail sod = new ShopOrderDetail();
			sod.setOrderId(q.getOrderId());
			sod.setSellerId(id);
			List<ShopOrderDetail> sodList = shopOrderDetailService.findList(sod);
			q.setShopOrderDetailList(sodList);
			q.setCurrentGoodsTotalPrice(new BigDecimal(sodList.stream().mapToDouble(s -> s.getPayTotal().doubleValue()).sum()).setScale(DefaultConstants.BIGDECIMAL_SHOW_DIGIT, BigDecimal.ROUND_HALF_UP));
		});
		return new PageJsonResponse<List<ShopOrderDTO>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}
	
	/**
	 * 
	 * @Title: findSellerShopOrdersByPage  
	 * @Description: 查询一个商户的所有订单(包含线上&线下)  
	 * @date 23 May 2018 6:05:50 PM  
	 * @param @param id
	 * @param @param pagenation
	 * @param @param request
	 * @param @param model
	 * @param @return  
	 * @return 
	 * @throws
	 */
	@RequestMapping(value="orders/seller/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<OrderDTO>> findSellerAllOrdersByPage(@PathVariable("id")Integer id, OrderDTO orderDTO, Pagenation pagenation, HttpServletRequest request, Model model) {
		orderDTO.setSellerId(id);
		Page<OrderDTO> queryResultList = shopOrderService.findAllOrdersByPage(orderDTO, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		/*
		 * 结果list中每个订单添加子订单信息
		 */
		queryResultList.stream().forEach(q -> {
			if (DefaultConstants.OrderTypeEnum.ONLINE.equals(q.getOrderType())) {
				ShopOrderDetail sod = new ShopOrderDetail();
				sod.setOrderId(q.getOrderNumber());
				sod.setSellerId(id);
				List<ShopOrderDetail> sodList = shopOrderDetailService.findList(sod);
				q.setOrderDetailList(sodList);
				q.setCurrentGoodsTotalPrice(new BigDecimal(sodList.stream().mapToDouble(s -> s.getPayTotal().doubleValue()).sum()).setScale(DefaultConstants.BIGDECIMAL_SHOW_DIGIT, BigDecimal.ROUND_HALF_UP));
			} else if (DefaultConstants.OrderTypeEnum.OFFLINE.equals(q.getOrderType())) {
				BalanceOfflineOrderGoodsDTO boogDTO = new BalanceOfflineOrderGoodsDTO();
				boogDTO.setOrderNumber(q.getOrderNumber());
				List<BalanceOfflineOrderGoodsDTO> boogDTOList = balanceOfflineOrderGoodsService.findListSpecial(boogDTO);
				q.setOrderDetailList(boogDTOList);
				q.setCurrentGoodsTotalPrice(new BigDecimal(boogDTOList.stream().mapToDouble(b -> b.getGoodsCount().multiply(b.getPayTotal()).doubleValue()).sum()).setScale(DefaultConstants.BIGDECIMAL_SHOW_DIGIT, BigDecimal.ROUND_HALF_UP));
			}
		});
		return new PageJsonResponse<List<OrderDTO>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}
	
//	/**
//	 * 
//	 * @date 2018-05-15 14:11:17
//	 * @Title: findByPage 
//	 * @Description: TODO
//	 * @param @param shopOrder
//	 * @param @param pagenation
//	 * @param @param request
//	 * @param @return
//	 * @return PageJsonResponse<List<ShopOrder>>
//	 * @throws
//	 */
//	@RequestMapping(value="shopOrders", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
//	public PageJsonResponse<List<ShopOrder>> findByPage(ShopOrder shopOrder, Pagenation pagenation, HttpServletRequest request, Model model) {
//		Page<ShopOrder> queryResultList = shopOrderService.findListByPage(shopOrder, pagenation);
//		pagenation.setTotal(queryResultList.getTotal());
//		return new PageJsonResponse<List<ShopOrder>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
//	}


	/**
	 * 
	 * @date 2018-05-15 14:11:17
	 * @Title: findShopOrderDetail 
	 * @Description: TODO
	 * @param @param shopOrder
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopOrder>
	 * @throws
	 */
	@RequestMapping(value="shopOrders/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopOrder> findShopOrderDetail(@PathVariable("id")Integer id, ShopOrder shopOrder, HttpServletRequest request){
		shopOrder = shopOrderService.get(id.toString());
		return new JsonResponse<ShopOrder>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopOrder);
	}

	
	/**
	 * 
	 * @date 2018-05-15 14:11:17
	 * @Title: modifyShopOrderDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param shopOrder
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopOrder>
	 * @throws
	 */
	@RequestMapping(value="shopOrders/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopOrder> modifyShopOrderDetail(@PathVariable("id")String id, @RequestBody ShopOrder shopOrder, HttpServletRequest request){
		shopOrder.setOrderId(id);
		shopOrderService.update(shopOrder);
		return new JsonResponse<ShopOrder>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopOrderService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-15 14:11:17
	 * @Title: addShopOrder 
	 * @Description: TODO
	 * @param @param shopOrder
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopOrder>
	 * @throws
	 */
	@RequestMapping(value="shopOrders", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopOrder> addShopOrder(@RequestBody ShopOrder shopOrder, HttpServletRequest request){
		shopOrderService.insert(shopOrder);
		return new JsonResponse<ShopOrder>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopOrderService.findList(shopOrder).get(0));
	}
	
//	/**
//	 * 
//	 * @date 2018-05-15 14:11:17
//	 * @Title: removeShopOrder 
//	 * @Description: TODO
//	 * @param @param id
//	 * @param @param request
//	 * @param @return
//	 * @return JsonResponse<>
//	 * @throws
//	 */
//	@RequestMapping(value="shopOrders/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
//	public JsonResponse<?> removeShopOrder(@PathVariable("id")Integer id, HttpServletRequest request){
//		shopOrderService.delete(id.toString());
//		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
//	}
	
	@Autowired(required=false)
	private RedisService redisService;
	
	@RequestMapping(value="shopOrders/preemptOrder/{sellerId}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> preemptShopOrder(@PathVariable("sellerId")Integer id, HttpServletRequest request){
//		shopOrderService.delete(id.toString());
		List<ShopOrderDTO> s = new ArrayList<ShopOrderDTO>();
		if (redisService != null)
			s = redisService.findSellerPreemptOrderList(id);
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, s);
	}
	
}

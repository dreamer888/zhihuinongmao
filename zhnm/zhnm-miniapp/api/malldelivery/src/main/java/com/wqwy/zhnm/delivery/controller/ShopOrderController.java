/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.delivery.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
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
import com.wqwy.zhnm.base.component.component.SellerMarketComponent;
import com.wqwy.zhnm.base.component.component.SellerShopOrderDetailComponent;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.entity.ShopUser;
import com.wqwy.zhnm.base.service.SellerService;
import com.wqwy.zhnm.base.service.ShopOrderDetailService;
import com.wqwy.zhnm.base.service.ShopOrderService;
import com.wqwy.zhnm.base.service.ShopUserService;

/**
 * createTime: 2018-06-01 13:57:38
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
	private SellerService sellerService;
	
	@Autowired
	private ShopUserService shopUserService;
	
	/**
	 * 
	 * @date 2018-06-01 13:57:38
	 * @Title: findByPage 
	 * @Description: 配送人员查询订单列表
	 * @param @param shopOrder
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<ShopOrder>>
	 * @throws
	 */
	@RequestMapping(value="shopOrders/deliverer/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<ShopOrderDTO>> findByPage(@PathVariable("id")Integer id, ShopOrderDTO shopOrder, Pagenation pagenation, HttpServletRequest request, Model model) {
		shopOrder.setDelivererId(id);
		Page<ShopOrderDTO> queryResultList = shopOrderService.findListByPage(shopOrder, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		/*
		 * 结果list中每个订单添加子订单信息
		 */
		queryResultList.stream().forEach(q -> {
			ShopOrderDetail sod = new ShopOrderDetail();
			sod.setOrderId(q.getOrderId());
			ShopUser su = shopUserService.get(q.getUserId());
			List<ShopOrderDetail> sodList = shopOrderDetailService.findList(sod);
			Set<SellerMarketComponent> smcSet = sodList.stream()
					.map(ShopOrderDetail::getSellerId)
					.filter(s -> s!=null).distinct()
					.map(s -> {
						SellerMarketComponent seller = sellerService.getWithMarket(s.toString());
						if(null!=seller) {
							seller.setPassword(null);
						}
						return seller;
					}).collect(Collectors.toSet());
			q.setShopUser(su);
			Set<SellerMarketComponent> newSmcSet = new HashSet<SellerMarketComponent>(); 
			if(null!=smcSet && !smcSet.isEmpty()) {
				for(SellerMarketComponent component : smcSet) {
				   if(null!=component) {
					   newSmcSet.add(component);
				   }
				}
			}
			if(null!=newSmcSet && newSmcSet.size()>0) {
				q.setSmcSet(newSmcSet);
			}
		});
		return new PageJsonResponse<List<ShopOrderDTO>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-06-01 13:57:38
	 * @Title: findShopOrderDetail 
	 * @Description: 配送员查询单个订单的详情
	 * @param @param shopOrder
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopOrder>
	 * @throws
	 */
	@RequestMapping(value="shopOrders/{orderId}/deliverer/{delivererId}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopOrderDTO> findShopOrderDetail(
			@PathVariable("orderId")String orderId, 
			@PathVariable("delivererId")String delivererId, 
			ShopOrder shopOrder, HttpServletRequest request){
		ShopOrderDTO soDTO = new ShopOrderDTO();
		shopOrder = shopOrderService.get(orderId);
		if (!delivererId.equals(shopOrder.getDelivererId().toString()))
			throw new BusinessException();// 订单与配送人员不匹配
		BeanUtils.copyProperties(shopOrder, soDTO);
		
		Set<SellerShopOrderDetailComponent> ssodcSet = new HashSet<SellerShopOrderDetailComponent>();
		ShopOrderDetail sod = new ShopOrderDetail();
		sod.setOrderId(shopOrder.getOrderId());
		shopOrderDetailService.findList(sod).stream()
			.filter(s -> s.getSellerId()!=null).collect(Collectors.groupingBy(ShopOrderDetail::getSellerId))
			.forEach((k, v) -> {
				SellerMarketComponent seller = sellerService.getWithMarket(k.toString());
				if(null!=seller) {
					seller.setPassword(null);
					SellerShopOrderDetailComponent ssodc = new SellerShopOrderDetailComponent();
					BeanUtils.copyProperties(seller, ssodc);
					ssodc.setSodList(v);
					ssodc.setTotalPrice(new BigDecimal(v.stream().mapToDouble(s -> s.getPayTotal().doubleValue()).sum()).setScale(DefaultConstants.BIGDECIMAL_SHOW_DIGIT, BigDecimal.ROUND_HALF_UP));
					ssodcSet.add(ssodc);
				}
			});
		soDTO.setSsodcSet(ssodcSet);
		return new JsonResponse<ShopOrderDTO>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, soDTO);
	}

	
	/**
	 * 
	 * @date 2018-06-01 13:57:38
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
		if(shopOrder.getStatus()==DefaultConstants.ShopOrderEnum.SHOPORDER_SHIPPED.getShopOrderEnum()) {
			shopOrder.setDeliveryFinishTime(new Date());
		}
		if(shopOrder.getStatus()==DefaultConstants.ShopOrderEnum.SHOPORDER_FINISHED.getShopOrderEnum()) {
			shopOrder.setFinishTime(new Date());
		}
		shopOrderService.update(shopOrder);
		return new JsonResponse<ShopOrder>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopOrderService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-06-01 13:57:38
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
	
	/**
	 * 
	 * @date 2018-06-01 13:57:38
	 * @Title: removeShopOrder 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="shopOrders/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeShopOrder(@PathVariable("id")Integer id, HttpServletRequest request){
		shopOrderService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

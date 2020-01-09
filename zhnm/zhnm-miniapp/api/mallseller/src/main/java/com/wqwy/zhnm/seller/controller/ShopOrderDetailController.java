/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import java.math.BigDecimal;
import java.util.List;

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
import com.wqwy.zhnm.base.component.component.ShopOrderPrintComponent;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailPrintDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderPrintDTO;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.request.SellerPreemptRequest;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.DelivererMarket;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.service.DelivererMarketService;
import com.wqwy.zhnm.base.service.ShopOrderDetailService;
import com.wqwy.zhnm.base.service.ShopOrderService;
import com.wqwy.zhnm.base.service.async.RabbitMQAsyncJobService;

/**
 * createTime: 2018-05-15 11:51:43
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class ShopOrderDetailController {

	@Autowired
	private ShopOrderDetailService  shopOrderDetailService;
	
	@Autowired
	private RabbitMQAsyncJobService rabbitMQAsyncJobService; 
    
	@Autowired
	private ShopOrderService  shopOrderService;
	
	@Autowired
	private DelivererMarketService delivererMarketService;
	
	/**
	 * 
	 * @date 2018-05-15 11:51:43
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param shopOrderDetail
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<ShopOrderDetail>>
	 * @throws
	 */
	@RequestMapping(value="shopOrderDetails", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<ShopOrderDetail>> findByPage(ShopOrderDetail shopOrderDetail, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<ShopOrderDetail> queryResultList = shopOrderDetailService.findListByPage(shopOrderDetail, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<ShopOrderDetail>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-15 11:51:43
	 * @Title: findShopOrderDetailDetail 
	 * @Description: TODO
	 * @param @param shopOrderDetail
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopOrderDetail>
	 * @throws
	 */
	@RequestMapping(value="shopOrderDetails/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopOrderDetail> findShopOrderDetailDetail(@PathVariable("id")Integer id, ShopOrderDetail shopOrderDetail, HttpServletRequest request){
		shopOrderDetail = shopOrderDetailService.get(id.toString());
		return new JsonResponse<ShopOrderDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopOrderDetail);
	}

	
	/**
	 * 
	 * @date 2018-05-15 11:51:43
	 * @Title: modifyShopOrderDetailDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param shopOrderDetail
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopOrderDetail>
	 * @throws
	 */
	@RequestMapping(value="shopOrderDetails/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopOrderDetail> modifyShopOrderDetailDetail(@PathVariable("id")String id, @RequestBody ShopOrderDetail shopOrderDetail, HttpServletRequest request){
		shopOrderDetail.setOrderDetailId(id);
		shopOrderDetailService.update(shopOrderDetail);
		return new JsonResponse<ShopOrderDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopOrderDetailService.get(id.toString()));
	}
	
	/**
	 * 
	 * @Title: modifyMultipleShopOrderDetailDetail  
	 * @Description: 商户抢单  
	 * @date 23 May 2018 2:20:20 PM  
	 * @param @param sellerPreemptRequest
	 * @param @param request
	 * @param @return  
	 * @return JsonResponse<ShopOrderDetail>  
	 * @throws
	 */
	@RequestMapping(value="shopOrderDetails", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopOrderDTO> modifyMultipleShopOrderDetailForPreempt(@RequestBody SellerPreemptRequest sellerPreemptRequest, HttpServletRequest request){
		/**
		 * 前端要求code必须200?
		 * message成功
		 * 报错message放入data? :(
		 */
		ShopOrderDTO shopOrderDTO = new ShopOrderDTO();
		try {
			shopOrderDTO = shopOrderDetailService.updateMultipleForPreempt(sellerPreemptRequest);
		} catch (BusinessException e) {
			shopOrderDTO = (ShopOrderDTO) e.getData();
			shopOrderDTO.setErrorMessage(e.getMessage());
			return new JsonResponse<ShopOrderDTO>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopOrderDTO);
		}
		return new JsonResponse<ShopOrderDTO>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopOrderDTO);
	}
	
	/**
	 * 
	 * @Title: modifyMultipleShopOrderDetailForPrepared  
	 * @Description: 商户在某个订单中备货完成  
	 * @date 23 May 2018 6:04:04 PM  
	 * @param @param sellerId
	 * @param @param shopOrderId
	 * @param @param shopOrderDetail
	 * @param @param request
	 * @param @return  
	 * @return JsonResponse<Integer>  
	 * @throws
	 */
	@RequestMapping(value="shopOrderDetails/seller/{sellerId}/shopOrder/{shopOrderId}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Integer> modifyMultipleShopOrderDetailForPrepared(@PathVariable("sellerId")Integer sellerId, @PathVariable("shopOrderId")String shopOrderId, ShopOrderDetail shopOrderDetail, HttpServletRequest request){
		shopOrderDetail.setSellerId(sellerId);
		shopOrderDetail.setOrderId(shopOrderId);
		
		ShopOrder so = new ShopOrder();
		so.setOrderId(shopOrderId);
		so = shopOrderService.findList(so).get(0);
		DelivererMarket delivererMarket = delivererMarketService.getOneDelivererByShopOrder(so.getMarketId());
		
		if(null==delivererMarket) {
			return new JsonResponse<Integer>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, null);
		}
		//发送mq打印小票
		List<ShopOrderPrintDTO> orderList = shopOrderDetailService.printOrder(shopOrderDetail);
	    List<ShopOrderDetailPrintDTO> orderDetailList = shopOrderDetailService.printOrderDetail(shopOrderDetail);
	    
		BigDecimal totalPrice = new BigDecimal(0);// 订单总价
	    for(ShopOrderDetailPrintDTO detailPrintDTO : orderDetailList) {
	    	totalPrice = totalPrice.add(detailPrintDTO.getTotalPrice());
	    }
	    
	    ShopOrderPrintComponent sop = new ShopOrderPrintComponent();
		BeanUtils.copyProperties(orderList.get(0), sop);
		sop.setOrderPrice(totalPrice);
		sop.setOrderDetailPrintDTOs(orderDetailList);
		sop.setTelephone(DefaultConstants.TELEPHONE);
		sop.setCompany(DefaultConstants.COMPANY);
		sop.setSellerId(sellerId);
		sop.setQrCode(DefaultConstants.PRINTORDERURL+shopOrderId+"&seller_id="+sellerId);
		rabbitMQAsyncJobService.doSendPrintOrderMessage(sop); //发送打印订单消息到称
		
		Integer resultCount = shopOrderDetailService.updateMultipleForPrepared(shopOrderDetail);
		
		ShopOrderDetail sodForSearch = new ShopOrderDetail();
		sodForSearch.setOrderId(shopOrderId);
		List<ShopOrderDetail> sodAllList = shopOrderDetailService.findList(sodForSearch);
		if (sodAllList.stream().allMatch(s -> DefaultConstants.ShopOrderEnum.SHOPORDER_WAIT_DELIVERER_RECEIVE_GOODS
				.getShopOrderEnum().equals(s.getStatus()))) {
		}else {
			return new JsonResponse<Integer>(ResultUtils.SUCCESS, ResultUtils.WAIT_PREPARED_MSG, resultCount);
		}
		
		return new JsonResponse<Integer>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, resultCount);
	}
	
	/**
	 * 
	 * @date 2018-05-15 11:51:43
	 * @Title: addShopOrderDetail 
	 * @Description: TODO
	 * @param @param shopOrderDetail
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopOrderDetail>
	 * @throws
	 */
	@RequestMapping(value="shopOrderDetails", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopOrderDetail> addShopOrderDetail(@RequestBody ShopOrderDetail shopOrderDetail, HttpServletRequest request){
		shopOrderDetailService.insert(shopOrderDetail);
		return new JsonResponse<ShopOrderDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopOrderDetailService.findList(shopOrderDetail).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-15 11:51:43
	 * @Title: removeShopOrderDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="shopOrderDetails/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeShopOrderDetail(@PathVariable("id")Integer id, HttpServletRequest request){
		shopOrderDetailService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

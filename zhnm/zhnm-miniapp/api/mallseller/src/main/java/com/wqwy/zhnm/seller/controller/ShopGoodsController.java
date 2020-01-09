/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
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
import com.wqwy.zhnm.base.component.dto.ShopGoodsDTO;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.entity.ShopGoods;
import com.wqwy.zhnm.base.service.SellerGoodsService;
import com.wqwy.zhnm.base.service.ShopGoodsService;

/**
 * createTime: 2018-05-09 11:52:16
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class ShopGoodsController {

	@Autowired
	private ShopGoodsService  shopGoodsService;
	
	@Autowired
	private SellerGoodsService sellerGoodsService;

	/**
	 * 
	 * @date 2018-05-09 11:52:16
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param shopGoods
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<ShopGoods>>
	 * @throws
	 */
	@RequestMapping(value="shopGoods", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<ShopGoodsDTO>> findByPage(ShopGoodsDTO shopGoods, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<ShopGoods> queryResultList = shopGoodsService.findListByPage(shopGoods, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		
		Integer sellerId = shopGoods.getSellerId();
		SellerGoods sg = new SellerGoods();
		sg.setSellerId(sellerId);
		Assert.notNull(sellerId, "sellerId not null");
		
//		@SuppressWarnings("unchecked")
//		List<ShopGoodsDTO> sgDTOList = (List<ShopGoodsDTO>)(List<?>)queryResultList;
//				queryResultList.stream().map(s -> (ShopGoodsDTO)s).collect(Collectors.toList());
//		sgDTOList.forEach(q -> {
//			sg.setGoodsId(q.getGoodsId());
//			q.setHasThisGoods(sellerGoodsService.getCountByCondition(sg) > DefaultConstants.ZERO_INTEGER);
//		});
		List<ShopGoodsDTO> sgDTOList = new ArrayList<ShopGoodsDTO>();
		queryResultList.stream().forEach(q -> {
			ShopGoodsDTO sgDTO = new ShopGoodsDTO();
			BeanUtils.copyProperties(q, sgDTO);
			sg.setGoodsId(q.getGoodsId());
			List<SellerGoods> sgList = sellerGoodsService.findList(sg);
			if (sgList!=null && !sgList.isEmpty())
				sgDTO.setSellerGoods(sgList.get(0));
//			sgDTO.setHasThisGoods(sellerGoodsService.getCountByCondition(sg)>DefaultConstants.ZERO_INTEGER);
			sgDTOList.add(sgDTO);
		});
		return new PageJsonResponse<List<ShopGoodsDTO>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sgDTOList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-09 11:52:16
	 * @Title: findShopGoodsDetail 
	 * @Description: TODO
	 * @param @param shopGoods
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopGoods>
	 * @throws
	 */
	@RequestMapping(value="shopGoods/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopGoods> findShopGoodsDetail(@PathVariable("id")String id, ShopGoods shopGoods, HttpServletRequest request){
		shopGoods = shopGoodsService.get(id.toString());
		return new JsonResponse<ShopGoods>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopGoods);
	}

	
	/**
	 * 
	 * @date 2018-05-09 11:52:16
	 * @Title: modifyShopGoodsDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param shopGoods
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopGoods>
	 * @throws
	 */
	@RequestMapping(value="shopGoods/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopGoods> modifyShopGoodsDetail(@PathVariable("id")Integer id, @RequestBody ShopGoods shopGoods, HttpServletRequest request){
		shopGoods.setGoodsId(id);
		shopGoodsService.update(shopGoods);
		return new JsonResponse<ShopGoods>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopGoodsService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-09 11:52:16
	 * @Title: addShopGoods 
	 * @Description: TODO
	 * @param @param shopGoods
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ShopGoods>
	 * @throws
	 */
	@RequestMapping(value="shopGoods", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ShopGoods> addShopGoods(@RequestBody ShopGoods shopGoods, HttpServletRequest request){
		shopGoodsService.insert(shopGoods);
		return new JsonResponse<ShopGoods>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopGoodsService.findList(shopGoods).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-09 11:52:16
	 * @Title: removeShopGoods 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="shopGoods/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeShopGoods(@PathVariable("id")String id, HttpServletRequest request){
		shopGoodsService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

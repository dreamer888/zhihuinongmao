/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.wqwy.zhnm.base.component.component.SellerGoodsComponent;
import com.wqwy.zhnm.base.component.dto.ShopGoodsDTO;
import com.wqwy.zhnm.base.component.response.SellerDetailResponse;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.component.utils.StringUtil;
import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.entity.ShopGoods;
import com.wqwy.zhnm.base.service.SellerGoodsService;
import com.wqwy.zhnm.base.service.ShopGoodsService;
import com.wqwy.zhnm.base.service.async.RabbitMQAsyncJobService;
import com.wqwy.zhnm.seller.base.BaseController;

/**
 * createTime: 2018-05-08 18:51:10
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class SellerGoodsController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(SellerGoodsController.class);
	@Autowired
	private SellerGoodsService  sellerGoodsService;
	
	@Autowired
	private ShopGoodsService shopGoodsService;
    
	@Autowired
	private RabbitMQAsyncJobService rabbitMQAsyncJobService;
	
	/**
	 * 
	 * @date 2018-05-08 18:51:10
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param sellerGoods
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<SellerGoods>>
	 * @throws
	 */
	@RequestMapping(value="sellerGoods", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<SellerGoodsComponent>> findByPage(SellerGoods sellerGoods, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<SellerGoods> queryResultList = sellerGoodsService.findListByPage(sellerGoods, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		List<SellerGoodsComponent> sgDTOPage = new ArrayList<SellerGoodsComponent>();
		queryResultList.stream().forEach(q -> {
			ShopGoods sg = shopGoodsService.get(q.getGoodsId().toString());
			SellerGoodsComponent sgc = new SellerGoodsComponent();
			BeanUtils.copyProperties(q, sgc);
			sgc.setShopGoods(sg);
			sgDTOPage.add(sgc);
			
		});
		return new PageJsonResponse<List<SellerGoodsComponent>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sgDTOPage, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:51:10
	 * @Title: findSellerGoodsDetail 
	 * @Description: TODO
	 * @param @param sellerGoods
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerGoods>
	 * @throws
	 */
	@RequestMapping(value="sellerGoods/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerGoods> findSellerGoodsDetail(@PathVariable("id")Integer id, SellerGoods sellerGoods, HttpServletRequest request){
		sellerGoods = sellerGoodsService.get(id.toString());
		return new JsonResponse<SellerGoods>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerGoods);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:51:10
	 * @Title: modifySellerGoodsDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param sellerGoods
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerGoods>
	 * @throws
	 */
	@RequestMapping(value="sellerGoods/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SellerGoods> modifySellerGoodsDetail(@PathVariable("id")Integer id, @RequestBody SellerGoods sellerGoods, HttpServletRequest request){
		
		
		boolean flag = false;
		SellerGoods sellerGood = new SellerGoods();
		sellerGood.setId(id);
		List<SellerGoods> list = sellerGoodsService.findList(sellerGood);
		SellerGoods seg = list.get(0);
		
		if(sellerGoods.getPrice()!=null) {
			BigDecimal oprice =  new BigDecimal(sellerGoods.getPrice().toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
			BigDecimal tprice =  new BigDecimal(seg.getPrice().toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
			if(!oprice.equals(tprice)) {
				 flag = true;
			}
		}
		
		if(sellerGoods.getBalanceHotkey()!=null) {
			if(!seg.getBalanceHotkey().equals(sellerGoods.getBalanceHotkey())) {
				 flag = true;
			}
		}
		
		sellerGoods.setId(id);
		logger.info("sellerGoods: " + JsonUtils.AsJsonString(sellerGoods));
		sellerGoodsService.update(sellerGoods);
		
		//更新价格、快捷键、上架发mq通知到称
		if(flag || (StringUtil.isValid(sellerGoods.getStatus()) && sellerGoods.getStatus()==0)) {//Status 0 :上架  1：下架 
			//发送快捷键更新通知
			//TODO	
			List<SellerGoods> sgList = sellerGoodsService.findList(sellerGoods);
			SellerGoods sg = sgList.get(0);
			SellerGoodsComponent sgc = new SellerGoodsComponent();
			BeanUtils.copyProperties(sg, sgc);
			ShopGoods shopG = shopGoodsService.get(sg.getGoodsId().toString());//TODO 缓存
			sgc.setShopGoods(shopG);
			sgc.setOldBalanceHotkey(seg.getBalanceHotkey());
			rabbitMQAsyncJobService.doSendUpdateShortcutMessage(sgc); //发送快捷键消息到称
		}
		
		if(StringUtil.isValid(sellerGoods.getStatus()) && sellerGoods.getStatus()==1) { //Status 0 :上架  1：下架 
			//下架
			//TODO	
			List<SellerGoods> sgList = sellerGoodsService.findList(sellerGoods);
			SellerGoods sg = sgList.get(0);
			SellerGoodsComponent sgc = new SellerGoodsComponent();
			BeanUtils.copyProperties(sg, sgc);
			ShopGoods shopG = shopGoodsService.get(sg.getGoodsId().toString());//TODO 缓存
			sgc.setShopGoods(shopG);
			rabbitMQAsyncJobService.doSendUpdateGoodsMessage(sgc); //发送消息到称
		}
		
		return new JsonResponse<SellerGoods>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerGoodsService.get(id.toString()));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:10
	 * @Title: addSellerGoods 
	 * @Description: TODO
	 * @param @param sellerGoods
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SellerGoods>
	 * @throws
	 */
	@RequestMapping(value="sellerGoods", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> addSellerGoods(@RequestBody SellerGoods sellerGoods, HttpServletRequest request){
		sellerGoodsService.insert(sellerGoods);
		
		//发送快捷键更新通知
		//TODO	
		List<SellerGoods> sgList = sellerGoodsService.findList(sellerGoods);
		SellerGoods sg = sgList.get(0);
		SellerGoodsComponent sgc = new SellerGoodsComponent();
		BeanUtils.copyProperties(sg, sgc);
		ShopGoods shopG = shopGoodsService.get(sg.getGoodsId().toString());//TODO 缓存
		//sgc.setShopGoods(shopG);
		
		rabbitMQAsyncJobService.doSendUpdateShortcutMessage(sgc); //发送快捷键消息到称
		
		ShopGoodsDTO shopGoodsDTO= new ShopGoodsDTO();  
		shopGoodsDTO.setSellerGoods(sg);
		BeanUtils.copyProperties(shopG, shopGoodsDTO);
		
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, shopGoodsDTO);
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:10
	 * @Title: removeSellerGoods 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="sellerGoods/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeSellerGoods(@PathVariable("id")Integer id, HttpServletRequest request){
		
		SellerGoods sellerGood = new SellerGoods();
		sellerGood.setId(id);
		//发送快捷键更新通知
		//TODO	
		List<SellerGoods> sgList = sellerGoodsService.findList(sellerGood);
		SellerGoods sg = sgList.get(0);
		SellerGoodsComponent sgc = new SellerGoodsComponent();
		BeanUtils.copyProperties(sg, sgc);
		ShopGoods shopG = shopGoodsService.get(sg.getGoodsId().toString());//TODO 缓存
		sgc.setShopGoods(shopG);
		rabbitMQAsyncJobService.doSendUpdateGoodsMessage(sgc); //发送消息到称
		
		sellerGoodsService.delete(id.toString());
		
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

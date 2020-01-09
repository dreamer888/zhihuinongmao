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

import com.wqwy.zhnm.base.entity.DelivererWalletDetail;
import com.wqwy.zhnm.base.service.DelivererWalletDetailService;
import com.wqwy.zhnm.delivery.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:51:00
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class DelivererWalletDetailController extends BaseController {

	@Autowired
	private DelivererWalletDetailService  delivererWalletDetailService;

	/**
	 * 
	 * @date 2018-05-08 18:51:00
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param delivererWalletDetail
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<DelivererWalletDetail>>
	 * @throws
	 */
	@RequestMapping(value="delivererWalletDetails", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<DelivererWalletDetail>> findByPage(DelivererWalletDetail delivererWalletDetail, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<DelivererWalletDetail> queryResultList = delivererWalletDetailService.findListByPage(delivererWalletDetail, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<DelivererWalletDetail>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:51:00
	 * @Title: findDelivererWalletDetailDetail 
	 * @Description: TODO
	 * @param @param delivererWalletDetail
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererWalletDetail>
	 * @throws
	 */
	@RequestMapping(value="delivererWalletDetails/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererWalletDetail> findDelivererWalletDetailDetail(@PathVariable("id")Integer id, DelivererWalletDetail delivererWalletDetail, HttpServletRequest request){
		delivererWalletDetail = delivererWalletDetailService.get(id.toString());
		return new JsonResponse<DelivererWalletDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererWalletDetail);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:51:00
	 * @Title: modifyDelivererWalletDetailDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param delivererWalletDetail
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererWalletDetail>
	 * @throws
	 */
	@RequestMapping(value="delivererWalletDetails/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererWalletDetail> modifyDelivererWalletDetailDetail(@PathVariable("id")Integer id, @RequestBody DelivererWalletDetail delivererWalletDetail, HttpServletRequest request){
		delivererWalletDetail.setId(id);
		delivererWalletDetailService.update(delivererWalletDetail);
		return new JsonResponse<DelivererWalletDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererWalletDetailService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:51:00
	 * @Title: addDelivererWalletDetail 
	 * @Description: TODO
	 * @param @param delivererWalletDetail
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererWalletDetail>
	 * @throws
	 */
	@RequestMapping(value="delivererWalletDetails", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererWalletDetail> addDelivererWalletDetail(@RequestBody DelivererWalletDetail delivererWalletDetail, HttpServletRequest request){
		delivererWalletDetailService.insert(delivererWalletDetail);
		return new JsonResponse<DelivererWalletDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererWalletDetailService.findList(delivererWalletDetail).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:00
	 * @Title: removeDelivererWalletDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="delivererWalletDetails/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeDelivererWalletDetail(@PathVariable("id")Integer id, HttpServletRequest request){
		delivererWalletDetailService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

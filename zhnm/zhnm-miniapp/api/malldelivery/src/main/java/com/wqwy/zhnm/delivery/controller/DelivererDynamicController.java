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

import com.wqwy.zhnm.base.entity.DelivererDynamic;
import com.wqwy.zhnm.base.service.DelivererDynamicService;
import com.wqwy.zhnm.delivery.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:50:58
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class DelivererDynamicController extends BaseController {

	@Autowired
	private DelivererDynamicService  delivererDynamicService;

	/**
	 * 
	 * @date 2018-05-08 18:50:58
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param delivererDynamic
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<DelivererDynamic>>
	 * @throws
	 */
	@RequestMapping(value="delivererDynamics", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<DelivererDynamic>> findByPage(DelivererDynamic delivererDynamic, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<DelivererDynamic> queryResultList = delivererDynamicService.findListByPage(delivererDynamic, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<DelivererDynamic>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:50:58
	 * @Title: findDelivererDynamicDetail 
	 * @Description: TODO
	 * @param @param delivererDynamic
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererDynamic>
	 * @throws
	 */
	@RequestMapping(value="delivererDynamics/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererDynamic> findDelivererDynamicDetail(@PathVariable("id")Integer id, DelivererDynamic delivererDynamic, HttpServletRequest request){
		delivererDynamic = delivererDynamicService.get(id.toString());
		return new JsonResponse<DelivererDynamic>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererDynamic);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:50:58
	 * @Title: modifyDelivererDynamicDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param delivererDynamic
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererDynamic>
	 * @throws
	 */
	@RequestMapping(value="delivererDynamics/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererDynamic> modifyDelivererDynamicDetail(@PathVariable("id")Integer id, @RequestBody DelivererDynamic delivererDynamic, HttpServletRequest request){
		delivererDynamic.setId(id);
		delivererDynamicService.update(delivererDynamic);
		return new JsonResponse<DelivererDynamic>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererDynamicService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:50:58
	 * @Title: addDelivererDynamic 
	 * @Description: TODO
	 * @param @param delivererDynamic
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererDynamic>
	 * @throws
	 */
	@RequestMapping(value="delivererDynamics", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererDynamic> addDelivererDynamic(@RequestBody DelivererDynamic delivererDynamic, HttpServletRequest request){
		delivererDynamicService.insert(delivererDynamic);
		return new JsonResponse<DelivererDynamic>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererDynamicService.findList(delivererDynamic).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:50:58
	 * @Title: removeDelivererDynamic 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="delivererDynamics/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeDelivererDynamic(@PathVariable("id")Integer id, HttpServletRequest request){
		delivererDynamicService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

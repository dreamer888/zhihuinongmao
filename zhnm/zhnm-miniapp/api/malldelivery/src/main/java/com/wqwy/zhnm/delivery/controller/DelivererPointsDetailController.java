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

import com.wqwy.zhnm.base.entity.DelivererPointsDetail;
import com.wqwy.zhnm.base.service.DelivererPointsDetailService;
import com.wqwy.zhnm.delivery.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:50:59
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class DelivererPointsDetailController extends BaseController {

	@Autowired
	private DelivererPointsDetailService  delivererPointsDetailService;

	/**
	 * 
	 * @date 2018-05-08 18:50:59
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param delivererPointsDetail
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<DelivererPointsDetail>>
	 * @throws
	 */
	@RequestMapping(value="delivererPointsDetails", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<DelivererPointsDetail>> findByPage(DelivererPointsDetail delivererPointsDetail, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<DelivererPointsDetail> queryResultList = delivererPointsDetailService.findListByPage(delivererPointsDetail, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<DelivererPointsDetail>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:50:59
	 * @Title: findDelivererPointsDetailDetail 
	 * @Description: TODO
	 * @param @param delivererPointsDetail
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererPointsDetail>
	 * @throws
	 */
	@RequestMapping(value="delivererPointsDetails/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererPointsDetail> findDelivererPointsDetailDetail(@PathVariable("id")Integer id, DelivererPointsDetail delivererPointsDetail, HttpServletRequest request){
		delivererPointsDetail = delivererPointsDetailService.get(id.toString());
		return new JsonResponse<DelivererPointsDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererPointsDetail);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:50:59
	 * @Title: modifyDelivererPointsDetailDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param delivererPointsDetail
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererPointsDetail>
	 * @throws
	 */
	@RequestMapping(value="delivererPointsDetails/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererPointsDetail> modifyDelivererPointsDetailDetail(@PathVariable("id")Integer id, @RequestBody DelivererPointsDetail delivererPointsDetail, HttpServletRequest request){
		delivererPointsDetail.setId(id);
		delivererPointsDetailService.update(delivererPointsDetail);
		return new JsonResponse<DelivererPointsDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererPointsDetailService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:50:59
	 * @Title: addDelivererPointsDetail 
	 * @Description: TODO
	 * @param @param delivererPointsDetail
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererPointsDetail>
	 * @throws
	 */
	@RequestMapping(value="delivererPointsDetails", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererPointsDetail> addDelivererPointsDetail(@RequestBody DelivererPointsDetail delivererPointsDetail, HttpServletRequest request){
		delivererPointsDetailService.insert(delivererPointsDetail);
		return new JsonResponse<DelivererPointsDetail>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererPointsDetailService.findList(delivererPointsDetail).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:50:59
	 * @Title: removeDelivererPointsDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="delivererPointsDetails/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeDelivererPointsDetail(@PathVariable("id")Integer id, HttpServletRequest request){
		delivererPointsDetailService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

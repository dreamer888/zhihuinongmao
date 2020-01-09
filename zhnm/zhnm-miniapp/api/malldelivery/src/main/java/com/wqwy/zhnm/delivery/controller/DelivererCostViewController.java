/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.delivery.controller;

import javax.servlet.http.HttpServletRequest;

import com.wqwy.zhnm.base.component.dto.SellerOrderPriceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.DelivererCostViewComponent;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.DelivererCostView;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.service.DelivererCostViewService;

import java.util.Collections;
import java.util.Comparator;

/**
 * createTime: 2018-06-01 10:24:21
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class DelivererCostViewController {

	@Autowired
	private DelivererCostViewService  delivererCostViewService;

	/**
	 * 
	 * @date 2018-06-01 10:24:21
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param delivererCostViewComponent
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<DelivererCostViewComponent>>
	 * @throws
	 */
	@RequestMapping(value="delivererCostViews", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<DelivererCostViewComponent> findByPage(DelivererCostView delivererCostView, DelivererCostViewComponent delivererCostViewComponent, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<DelivererCostView> queryResultList = delivererCostViewService.findListByPage(delivererCostView, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		Collections.sort(queryResultList, Comparator.comparing(DelivererCostView::getAddtime).reversed());
		delivererCostViewComponent.setDcvList(queryResultList);
		delivererCostViewComponent.setTotalPrice(delivererCostViewService.getTotalPrice(delivererCostView));
		return new PageJsonResponse<DelivererCostViewComponent>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererCostViewComponent, pagenation);
	}

}

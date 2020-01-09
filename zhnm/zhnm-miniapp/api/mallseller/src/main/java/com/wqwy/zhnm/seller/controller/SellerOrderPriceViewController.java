package com.wqwy.zhnm.seller.controller;

import java.util.Collections;
import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.component.SellerOrderPriceViewComponent;
import com.wqwy.zhnm.base.component.dto.SellerOrderPriceView;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.service.SellerOrderPriceViewService;
import com.wqwy.zhnm.seller.base.BaseController;

/**
 * 
 * @ClassName: SellerOrderPriceViewController  
 * @author seven  
 * @date 24 May 2018 6:31:54 PM  
 *
 */
@RestController
@RequestMapping("/v1/")
public class SellerOrderPriceViewController extends BaseController {

	@Autowired
	private SellerOrderPriceViewService sellerOrderPriceViewService;
	
	/**
	 * 
	 * @Title: findByPage  
	 * @Description: 商户-订单-金额  
	 * @date 24 May 2018 6:45:18 PM  
	 * @param @param sellerOrderPriceView
	 * @param @param pagenation
	 * @param @param request
	 * @param @param model
	 * @param @return  
	 * @return PageJsonResponse<List<SellerOrderPriceView>>  
	 * @throws
	 */
	@RequestMapping(value="sellerOrderPriceViews", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<SellerOrderPriceViewComponent> findByPage(SellerOrderPriceView sellerOrderPriceView, SellerOrderPriceViewComponent sellerOrderPriceViewComponent, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<SellerOrderPriceView> queryResultList = sellerOrderPriceViewService.findListByPage(sellerOrderPriceView, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		Collections.sort(queryResultList, Comparator.comparing(SellerOrderPriceView::getAddtime).reversed());
		sellerOrderPriceViewComponent.setSopvList(queryResultList);
		sellerOrderPriceViewComponent.setTotalPrice(sellerOrderPriceViewService.getTotalPrice(sellerOrderPriceView));
		return new PageJsonResponse<SellerOrderPriceViewComponent>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerOrderPriceViewComponent, pagenation);
	}
	
}

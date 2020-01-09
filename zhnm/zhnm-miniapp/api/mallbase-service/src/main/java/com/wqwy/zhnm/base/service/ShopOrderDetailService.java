/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.component.ShopOrderDetailWithGoodsComponent;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailPrintDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderPrintDTO;
import com.wqwy.zhnm.base.component.request.SellerPreemptRequest;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;

/**
 * createTime: 2018-05-15 11:51:43
 * @author seven
 * @version
 */
public interface ShopOrderDetailService {

	/**
	 * query
	 * @param orderDetailId
	 * @return ShopOrderDetail
	 */
	public ShopOrderDetail get(String orderDetailId);

	/**
	 * query
	 * @param shopOrderDetail
	 * @return List<ShopOrderDetail>
	 */
	public List<ShopOrderDetail> findList(ShopOrderDetail shopOrderDetail);
	
	public List<ShopOrderDetailWithGoodsComponent> findListWithGoods(ShopOrderDetailWithGoodsComponent shopOrderDetail);

	/**
	 * query
	 * @param shopOrderDetail
	 * @return Page<ShopOrderDetail>
	 */
	public Page<ShopOrderDetail> findListByPage(ShopOrderDetail shopOrderDetail, Pagenation pagenation);

	/**
	 * insert
	 * @param shopOrderDetail
	 * @return
	 */
	public Integer insert(ShopOrderDetail shopOrderDetail);


	/**
	 * update
	 * @param shopOrderDetail
	 * @return
	 */
	public Integer update(ShopOrderDetail shopOrderDetail);
	
	/**
	 * 
	 * @Title: updateMultipleForPreempt  
	 * @Description: 商户抢单,发送准备抢的商品 返回抢成功的商品  
	 * @date 23 May 2018 3:43:59 PM  
	 * @param @param sellerPreemptRequest
	 * @param @return  
	 * @return List<ShopOrderDetail>  
	 * @throws
	 */
	public ShopOrderDTO updateMultipleForPreempt(SellerPreemptRequest sellerPreemptRequest);
	
	/**
	 * 
	 * @Title: updateMultipleForPrepared  
	 * @Description: 商户备货完成(修改一个商户在一个订单下的所有子订单)  
	 * @date 23 May 2018 4:03:51 PM  
	 * @param @param sellerPreemptRequest
	 * @param @return  
	 * @return Integer  
	 * @throws
	 */
	public Integer updateMultipleForPrepared(ShopOrderDetail shopOrderDetail);
	

	public Integer updateMultipleByShopOrder(ShopOrderDetail shopOrderDetail);
	
	/**
	 * delete
	 * @param orderDetailId
	 * @return
	 */
	public Integer delete(String orderDetailId);


	public List<ShopOrderDetailDTO> findListByCondition(ShopOrderDetailDTO shopOrderDetail);
	
	public List<ShopOrderDetailPrintDTO> printOrderDetail(ShopOrderDetail shopOrderDetail);
	
	public List<ShopOrderPrintDTO> printOrder(ShopOrderDetail shopOrderDetail);
	

}

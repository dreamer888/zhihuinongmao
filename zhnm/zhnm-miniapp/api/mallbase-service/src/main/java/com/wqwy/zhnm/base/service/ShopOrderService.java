/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.OrderDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.entity.ShopOrder;

/**
 * createTime: 2018-05-15 14:11:17
 * @author seven
 * @version
 */
public interface ShopOrderService {

	/**
	 * query
	 * @param orderId
	 * @return ShopOrder
	 */
	public ShopOrder get(String orderId);
	
	public List<ShopOrderDTO> findShopOrders(ShopOrderDTO shopOrder);

	/**
	 * query
	 * @param shopOrder
	 * @return List<ShopOrder>
	 */
	public List<ShopOrder> findList(ShopOrder shopOrder);

	/**
	 * query
	 * @param shopOrder
	 * @return Page<ShopOrder>
	 */
	public Page<ShopOrderDTO> findListByPage(ShopOrderDTO shopOrder, Pagenation pagenation);
	
	public Page<ShopOrderDTO> findShopOrdersByPage(ShopOrderDTO shopOrder, Pagenation pagenation);
	
	public Page<OrderDTO> findAllOrdersByPage(OrderDTO shopOrder, Pagenation pagenation);

	/**
	 * insert
	 * @param shopOrder
	 * @return
	 */
	public Integer insert(ShopOrder shopOrder);


	/**
	 * update
	 * @param shopOrder
	 * @return
	 */
	public Integer update(ShopOrder shopOrder);
	
	public Integer updateForJob(ShopOrder shopOrder);


	/**
	 * delete
	 * @param orderId
	 * @return
	 */
	public Integer delete(String orderId);


	/**
	 * 
	 * @Title: getOneNearMarketByShopOrder  
	 * @Description: 获取订单最近的菜市场  
	 * @date 17 May 2018 6:24:25 PM  
	 * @param @param shopOrder
	 * @param @return  
	 * @return Integer  
	 * @throws
	 */
	public Integer getOneNearMarketByShopOrder(ShopOrder shopOrder);

}

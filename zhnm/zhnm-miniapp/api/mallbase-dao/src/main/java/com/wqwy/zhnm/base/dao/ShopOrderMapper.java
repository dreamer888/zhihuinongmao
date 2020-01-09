/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

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
public interface ShopOrderMapper {

	/**
	 * query by orderId
	 * @param orderId
	 * @return ShopOrder
	 */
	public ShopOrder get(String orderId );

	/**
	 * query by condition
	 * @param shopOrder
	 * @return List<ShopOrder>
	 */
	public List<ShopOrder> findList(ShopOrder shopOrder);

	/**
	 * query by paging
	 * @param shopOrder
	 * @return Page<ShopOrder>
	 */
	public Page<ShopOrderDTO> findListByPage(ShopOrderDTO shopOrder);
	
	public Page<ShopOrderDTO> findShopOrdersByPage(ShopOrderDTO shopOrder);
	
	public Page<OrderDTO> findAllOrdersByPage(OrderDTO shopOrder);

	/**
	 * insert
	 * @param shopOrder
	 * @return if success then != 0 else =0
	 */
	public Integer insert(ShopOrder shopOrder);


	/**
	 * update
	 * @param shopOrder
	 * @return if success then != 0 else =0
	 */
	public Integer update(ShopOrder shopOrder);


	/**
	 * delete
	 * @param orderId
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String orderId);

}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.Deliverer;
import com.wqwy.zhnm.base.entity.DelivererMarket;
import com.wqwy.zhnm.base.entity.ShopOrder;

import java.util.List;

/**
 * createTime: 2018-05-08 18:50:59
 * @author seven
 * @version
 */
public interface DelivererMarketService {

	/**
	 * query
	 * @param id
	 * @return DelivererMarket
	 */
	public DelivererMarket get(String id);

	/**
	 * query
	 * @param delivererMarket
	 * @return List<DelivererMarket>
	 */
	public List<DelivererMarket> findList(DelivererMarket delivererMarket);

	/**
	 * query
	 * @param delivererMarket
	 * @return Page<DelivererMarket>
	 */
	public Page<DelivererMarket> findListByPage(DelivererMarket delivererMarket, Pagenation pagenation);

	/**
	 * insert
	 * @param delivererMarket
	 * @return
	 */
	public Integer insert(DelivererMarket delivererMarket);


	/**
	 * update
	 * @param delivererMarket
	 * @return
	 */
	public Integer update(DelivererMarket delivererMarket);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);


	/**
	 * 
	 * @Title: getOneDelivererByMarketId  
	 * @Description: 获取一个配送人员配送某个订单(订单中包含marketId)  
	 * @date 23 May 2018 5:25:43 PM  
	 * @param @param marketId
	 * @param @return  
	 * @return Deliverer  
	 * @throws
	 * 
	 * @deprecated 修改为配送人员抢单模式后将不再需要
	 */
	@Deprecated
	public DelivererMarket getOneDelivererByShopOrder(Integer marketId);

}

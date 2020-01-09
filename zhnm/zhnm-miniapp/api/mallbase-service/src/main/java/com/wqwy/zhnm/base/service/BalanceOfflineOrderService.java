/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderDTO;
import com.wqwy.zhnm.base.component.request.BalanceOfflineOrderWithGoodsRequest;
import com.wqwy.zhnm.base.component.response.BalanceOfflineOrderResponse;
import com.wqwy.zhnm.base.component.response.QRCodeGenerateResponseToClient;
import com.wqwy.zhnm.base.component.response.UnionPayQRCodeGenerateResponseToClient;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrder;

/**
 * createTime: 2018-05-08 18:51:13
 * @author seven
 * @version
 */
public interface BalanceOfflineOrderService {

	/**
	 * query
	 * @param id
	 * @return BalanceOfflineOrder
	 */
	public BalanceOfflineOrder get(String id);

	/**
	 * query
	 * @param balanceOfflineOrder
	 * @return List<BalanceOfflineOrder>
	 */
	public List<BalanceOfflineOrder> findList(BalanceOfflineOrder balanceOfflineOrder);

	/**
	 * query
	 * @param balanceOfflineOrder
	 * @return Page<BalanceOfflineOrder>
	 */
	public Page<BalanceOfflineOrderDTO> findListByPage(BalanceOfflineOrderDTO balanceOfflineOrder, Pagenation pagenation);

	/**
	 * insert
	 * @param balanceOfflineOrder
	 * @return
	 */
	public QRCodeGenerateResponseToClient insert(BalanceOfflineOrderWithGoodsRequest balanceOfflineOrder);


	/**
	 * update
	 * @param balanceOfflineOrder
	 * @return
	 */
	public Integer update(BalanceOfflineOrder balanceOfflineOrder);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);
	
	/**
	 * 二次发起支付二维码
	 * @param balanceOfflineOrderWithGoodsRequest
	 * @return
	 */
	public BalanceOfflineOrderResponse getBalanceOfflineOrder(Integer orderId);


}

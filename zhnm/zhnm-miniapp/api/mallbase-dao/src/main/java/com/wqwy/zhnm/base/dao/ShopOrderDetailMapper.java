/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.ShopOrderDetailWithGoodsComponent;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailPrintDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderPrintDTO;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;

/**
 * createTime: 2018-05-15 11:51:43
 * @author seven
 * @version
 */
public interface ShopOrderDetailMapper {

	/**
	 * query by orderDetailId
	 * @param orderDetailId
	 * @return ShopOrderDetail
	 */
	public ShopOrderDetail get(String orderDetailId );
	
	public ShopOrderDetail getForUpdate(String orderDetailId );

	/**
	 * query by condition
	 * @param shopOrderDetail
	 * @return List<ShopOrderDetail>
	 */
	public List<ShopOrderDetail> findList(ShopOrderDetail shopOrderDetail);
	
	public List<ShopOrderDetailWithGoodsComponent> findListWithGoods(ShopOrderDetailWithGoodsComponent shopOrderDetail);
	
	/**
	 * query by paging
	 * @param shopOrderDetail
	 * @return Page<ShopOrderDetail>
	 */
	public Page<ShopOrderDetail> findListByPage(ShopOrderDetail shopOrderDetail);

	/**
	 * insert
	 * @param shopOrderDetail
	 * @return if success then != 0 else =0
	 */
	public Integer insert(ShopOrderDetail shopOrderDetail);


	/**
	 * update
	 * @param shopOrderDetail
	 * @return if success then != 0 else =0
	 */
	public Integer update(ShopOrderDetail shopOrderDetail);
	
	public Integer updateBySellerShopOrder(ShopOrderDetail shopOrderDetail);
	
	public Integer updateByShopOrder(ShopOrderDetail shopOrderDetail);


	/**
	 * delete
	 * @param orderDetailId
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String orderDetailId);
	
	public List<ShopOrderDetailDTO> findListByCondition(ShopOrderDetailDTO shopOrderDetail);
	
	public List<ShopOrderPrintDTO> printOrder(ShopOrderDetail shopOrderDetail);
	
	public List<ShopOrderDetailPrintDTO> printOrderDetail(ShopOrderDetail shopOrderDetail);

}

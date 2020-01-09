/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.math.BigDecimal;
import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.DelivererCostView;

/**
 * createTime: 2018-06-01 10:24:21
 * @author seven
 * @version
 */
public interface DelivererCostViewService {

	/**
	 * query
	 * @param typeId
	 * @return DelivererCostViewComponent
	 */
	public DelivererCostView get(String typeId);

	/**
	 * query by condition
	 * @param delivererCostViewComponent
	 * @return Integer
	 */
	public Integer getCountByCondition(DelivererCostView delivererCostViewComponent );
	
	/**
	 * query
	 * @param delivererCostViewComponent
	 * @return List<DelivererCostViewComponent>
	 */
	public List<DelivererCostView> findList(DelivererCostView delivererCostViewComponent);

	/**
	 * query
	 * @param delivererCostViewComponent
	 * @return Page<DelivererCostViewComponent>
	 */
	public Page<DelivererCostView> findListByPage(DelivererCostView delivererCostViewComponent, Pagenation pagenation);
	
	public BigDecimal getTotalPrice(DelivererCostView delivererCostView);

}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.dto.MarketShopGoodsView;

/**
 * createTime: 2018-06-09 11:24:07
 * @author seven
 * @version
 */
public interface MarketShopGoodsViewService {

	/**
	 * query by condition
	 * @param marketShopGoodsView
	 * @return Integer
	 */
	public Integer getCountByCondition(MarketShopGoodsView marketShopGoodsView );
	
	/**
	 * query
	 * @param marketShopGoodsView
	 * @return List<MarketShopGoodsView>
	 */
	public List<MarketShopGoodsView> findList(MarketShopGoodsView marketShopGoodsView);

	/**
	 * query
	 * @param marketShopGoodsView
	 * @return Page<MarketShopGoodsView>
	 */
	public Page<MarketShopGoodsView> findListByPage(MarketShopGoodsView marketShopGoodsView, Pagenation pagenation);


}

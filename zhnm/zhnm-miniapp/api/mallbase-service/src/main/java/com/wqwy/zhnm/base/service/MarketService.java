/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.Market;

import java.util.List;

/**
 * createTime: 2018-05-08 18:51:01
 * @author seven
 * @version
 */
public interface MarketService {

	/**
	 * query
	 * @param id
	 * @return Market
	 */
	public Market get(String id);

	/**
	 * query
	 * @param market
	 * @return List<Market>
	 */
	public List<Market> findList(Market market);
	
	/**
	 * 
	 * @Title: findListMarketByLocation  
	 * @Description: 获取当前locaiton周边的菜市场列表  
	 * @date 13 Jun 2018 2:19:09 PM  
	 * @param @param location
	 * @param @return  
	 * @return List<Market>  
	 * @throws
	 */
	public List<Market> findListMarketByLocation(String location);

	/**
	 * query
	 * @param market
	 * @return Page<Market>
	 */
	public Page<Market> findListByPage(Market market, Pagenation pagenation);

	/**
	 * insert
	 * @param market
	 * @return
	 */
	public Integer insert(Market market);


	/**
	 * update
	 * @param market
	 * @return
	 */
	public Integer update(Market market);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

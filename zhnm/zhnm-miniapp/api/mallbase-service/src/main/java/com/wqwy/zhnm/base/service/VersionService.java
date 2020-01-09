/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import java.util.List;

import com.wqwy.zhnm.base.entity.Version;

/**
 * createTime: 2018-06-01 14:12:29
 * @author seven
 * @version
 */
public interface VersionService {

	/**
	 * query
	 * @param Version
	 * @return List<ShopUser>
	 */
	public List<Version> findByType(Integer appType);


}

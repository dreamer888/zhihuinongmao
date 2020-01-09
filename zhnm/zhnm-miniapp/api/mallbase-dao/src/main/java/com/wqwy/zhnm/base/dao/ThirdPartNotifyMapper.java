/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.ThirdPartNotify;
import java.util.List;

/**
 * createTime: 2018-05-31 15:05:28
 * @author seven
 * @version
 */
public interface ThirdPartNotifyMapper {

	/**
	 * query by id
	 * @param id
	 * @return ThirdPartNotify
	 */
	public ThirdPartNotify get(String id );
	
	/**
	 * query by condition
	 * @param thirdPartNotify
	 * @return Integer
	 */
	public Integer getCountByCondition(ThirdPartNotify thirdPartNotify );

	/**
	 * query by condition
	 * @param thirdPartNotify
	 * @return List<ThirdPartNotify>
	 */
	public List<ThirdPartNotify> findList(ThirdPartNotify thirdPartNotify);

	/**
	 * query by paging
	 * @param thirdPartNotify
	 * @return Page<ThirdPartNotify>
	 */
	public Page<ThirdPartNotify> findListByPage(ThirdPartNotify thirdPartNotify);

	/**
	 * insert
	 * @param thirdPartNotify
	 * @return if success then != 0 else =0
	 */
	public Integer insert(ThirdPartNotify thirdPartNotify);


	/**
	 * update
	 * @param thirdPartNotify
	 * @return if success then != 0 else =0
	 */
	public Integer update(ThirdPartNotify thirdPartNotify);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.HelpAndFeedback;
import java.util.List;

/**
 * createTime: 2018-05-23 12:05:29
 * @author seven
 * @version
 */
public interface HelpAndFeedbackMapper {

	/**
	 * query by id
	 * @param id
	 * @return HelpAndFeedback
	 */
	public HelpAndFeedback get(String id );

	/**
	 * query by condition
	 * @param helpAndFeedback
	 * @return List<HelpAndFeedback>
	 */
	public List<HelpAndFeedback> findList(HelpAndFeedback helpAndFeedback);

	/**
	 * query by paging
	 * @param helpAndFeedback
	 * @return Page<HelpAndFeedback>
	 */
	public Page<HelpAndFeedback> findListByPage(HelpAndFeedback helpAndFeedback);

	/**
	 * insert
	 * @param helpAndFeedback
	 * @return if success then != 0 else =0
	 */
	public Integer insert(HelpAndFeedback helpAndFeedback);


	/**
	 * update
	 * @param helpAndFeedback
	 * @return if success then != 0 else =0
	 */
	public Integer update(HelpAndFeedback helpAndFeedback);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

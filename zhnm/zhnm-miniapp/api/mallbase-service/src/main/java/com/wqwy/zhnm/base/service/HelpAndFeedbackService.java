/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.HelpAndFeedback;

import java.util.List;

/**
 * createTime: 2018-05-23 12:05:29
 * @author seven
 * @version
 */
public interface HelpAndFeedbackService {

	/**
	 * query
	 * @param id
	 * @return HelpAndFeedback
	 */
	public HelpAndFeedback get(String id);

	/**
	 * query
	 * @param helpAndFeedback
	 * @return List<HelpAndFeedback>
	 */
	public List<HelpAndFeedback> findList(HelpAndFeedback helpAndFeedback);

	/**
	 * query
	 * @param helpAndFeedback
	 * @return Page<HelpAndFeedback>
	 */
	public Page<HelpAndFeedback> findListByPage(HelpAndFeedback helpAndFeedback, Pagenation pagenation);

	/**
	 * insert
	 * @param helpAndFeedback
	 * @return
	 */
	public Integer insert(HelpAndFeedback helpAndFeedback);


	/**
	 * update
	 * @param helpAndFeedback
	 * @return
	 */
	public Integer update(HelpAndFeedback helpAndFeedback);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

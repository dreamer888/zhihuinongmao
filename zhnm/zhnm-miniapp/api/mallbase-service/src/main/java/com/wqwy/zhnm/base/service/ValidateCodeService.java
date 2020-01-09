/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;

import com.github.pagehelper.Page;

import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.entity.ValidateCode;

import java.util.List;

/**
 * createTime: 2018-05-25 13:03:49
 * @author seven
 * @version
 */
public interface ValidateCodeService {

	/**
	 * query
	 * @param id
	 * @return ValidateCode
	 */
	public ValidateCode get(String id);

	/**
	 * query
	 * @param validateCode
	 * @return List<ValidateCode>
	 */
	public List<ValidateCode> findList(ValidateCode validateCode);

	/**
	 * query
	 * @param validateCode
	 * @return Page<ValidateCode>
	 */
	public Page<ValidateCode> findListByPage(ValidateCode validateCode, Pagenation pagenation);

	/**
	 * insert
	 * @param validateCode
	 * @return
	 */
	public Integer insert(ValidateCode validateCode);
	
	public Integer insertOrUpdate(ValidateCode validateCode);


	/**
	 * update
	 * @param validateCode
	 * @return
	 */
	public Integer update(ValidateCode validateCode);


	/**
	 * delete
	 * @param id
	 * @return
	 */
	public Integer delete(String id);



}

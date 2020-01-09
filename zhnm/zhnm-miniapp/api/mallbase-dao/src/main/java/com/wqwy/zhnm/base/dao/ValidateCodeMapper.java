/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.dao;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.entity.ValidateCode;
import java.util.List;

/**
 * createTime: 2018-05-25 13:03:49
 * @author seven
 * @version
 */
public interface ValidateCodeMapper {

	/**
	 * query by id
	 * @param id
	 * @return ValidateCode
	 */
	public ValidateCode get(String id );

	/**
	 * query by condition
	 * @param validateCode
	 * @return List<ValidateCode>
	 */
	public List<ValidateCode> findList(ValidateCode validateCode);

	/**
	 * query by paging
	 * @param validateCode
	 * @return Page<ValidateCode>
	 */
	public Page<ValidateCode> findListByPage(ValidateCode validateCode);

	/**
	 * insert
	 * @param validateCode
	 * @return if success then != 0 else =0
	 */
	public Integer insert(ValidateCode validateCode);


	/**
	 * update
	 * @param validateCode
	 * @return if success then != 0 else =0
	 */
	public Integer update(ValidateCode validateCode);


	/**
	 * delete
	 * @param id
	 * @return if success then != 0 else =0
	 */
	public Integer delete(String id);

}

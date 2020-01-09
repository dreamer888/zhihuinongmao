package com.wqwy.zhnm.base.dao;

import java.util.List;

import com.wqwy.zhnm.base.entity.Version;

/** 
 * 说明： app自动更新接口
 * 创建人：万擎伟业科技 
 * 创建时间：2018-07-18
 * @version
 */
public interface VersionManager{

	/**通过appType获取数据
	 * @param pd
	 * @throws Exception
	 */
	public List<Version> findByType(Integer type);

}


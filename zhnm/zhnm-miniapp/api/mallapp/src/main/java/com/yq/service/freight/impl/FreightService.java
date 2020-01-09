package com.yq.service.freight.impl;

import javax.annotation.Resource;

import org.change.util.PageData;
import org.springframework.stereotype.Service;

import com.yq.dao.DaoSupport;
import com.yq.service.freight.FreightManager;

/** 
 * 说明： 运费
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-05-14
 * @version
 */
@Service("freightService")
public class FreightService implements FreightManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("FreightMapper.findById", pd);
	}

}


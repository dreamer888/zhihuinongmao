package com.yq.service.freight;

import org.change.util.PageData;

/** 
 * 说明： 运费接口
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-05-14
 * @version
 */
public interface FreightManager{
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
}


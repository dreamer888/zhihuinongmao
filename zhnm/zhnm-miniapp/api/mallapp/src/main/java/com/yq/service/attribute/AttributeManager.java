package com.yq.service.attribute;

import java.util.List;

import org.change.entity.Page;
import org.change.util.PageData;

/** 
 * 说明： 商品属性接口
 * 创建人：千派网络 www.qanpai.com
 * 创建时间：2017-06-22
 * @version
 */
public interface AttributeManager{

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save_th(PageData pd)throws Exception;
	
	public void save_td(PageData pd)throws Exception;
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception;
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception;
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll(PageData pd)throws Exception;
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception;
	
}


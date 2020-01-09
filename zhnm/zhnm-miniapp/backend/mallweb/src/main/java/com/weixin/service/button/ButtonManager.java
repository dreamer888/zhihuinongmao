package com.weixin.service.button;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

/** 
 * 说明： 微信菜单接口
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-04-10
 * @version
 */
public interface ButtonManager{

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public int save(PageData pd);
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public int delete(PageData pd);
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public int edit(PageData pd);
	
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
	
	public int selectCount(PageData pd)throws Exception;
	
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


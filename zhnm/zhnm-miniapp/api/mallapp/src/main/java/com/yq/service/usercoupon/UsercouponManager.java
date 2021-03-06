package com.yq.service.usercoupon;

import java.util.List;

import org.change.entity.Page;
import org.change.util.PageData;

/** 
 * 说明： 用户优惠券接口
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-05-12
 * @version
 */
public interface UsercouponManager{

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception;
	
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
	
	public int count(PageData pd)throws Exception;
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception;
	
	/** 用户已使用的代金劵
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> userListAll(PageData pd)throws Exception;
	
}


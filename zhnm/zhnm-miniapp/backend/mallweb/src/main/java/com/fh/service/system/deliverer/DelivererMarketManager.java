/**
 * 
 */
package com.fh.service.system.deliverer;

import java.util.List;

import org.change.entity.Page;
import org.change.util.PageData;

import com.fh.entity.system.Deliverer;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
public interface DelivererMarketManager {

	
	/**
	 * @param page
	 * @return
	 */
	List<PageData> listDelivererMs(Page page) throws Exception;
	
	/**
	 * @param page
	 * @return
	 */
	List<Deliverer> listDelivererAll(Page page) throws Exception;
	
	/**通过Account获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByName(PageData pd)throws Exception;
	
	/**通过Account获取数据
	 * @param pd
	 * @return
	 * @throws Exception 
	 */
	public PageData findByAccount(PageData pd)throws Exception;
	
	/**通过Account获取数据
	 * @param pd
	 * @return
	 * @throws Exception queryDelivererMarket
	 */
	public PageData queryDelivererMarket(PageData pd)throws Exception;
	
	
	
	
	/**保存
	 * @param pd
	 * @throws Exception
	 */
	public void saveD(PageData pd)throws Exception;
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void deleteDM(PageData pd)throws Exception;
	
}

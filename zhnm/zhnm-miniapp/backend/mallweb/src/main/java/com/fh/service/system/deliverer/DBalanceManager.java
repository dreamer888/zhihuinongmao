package com.fh.service.system.deliverer;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
public interface DBalanceManager {
	
	/**
	 * @param page
	 * @return
	 */
	List<PageData> listDelivererDBalances(Page page) throws Exception;
	
	/**通过Account获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**
	 * @param pd
	 * @throws Exception
	 */
	public void editD(PageData pd)throws Exception;
}

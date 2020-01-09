package com.fh.service.system.market;

import java.util.List;

import org.change.entity.Page;
import org.change.util.PageData;

import com.fh.entity.system.Market;

/**
 * @author zangmaoyuan
 *2018-5-10
 * 
 */
public interface MarketManager {

	 /**
	 * @param page
	 * @return
	 */
	List<PageData> listmarkets(Page page) throws Exception;
	
	/**
	* @param page
	* @return
	*/
	List<Market> listmarketAll(Page page) throws Exception;
		
	
	
	/**删除市场
	 * @param pd
	 * @throws Exception
	 */
	public void deleteM(PageData pd)throws Exception;

	/**
	 * @param arrayMARKET_IDS
	 */
	public void deleteAllM(String[] arrayMARKET_IDS)throws Exception;
	
	/**
	 * @param page
	 * @return
	 */
	public PageData findById(PageData page) throws Exception;
	
	/**
	 * @param pd
	 * @throws Exception
	 */
	public void editB(PageData pd)throws Exception;
	
	/**保存
	 * @param pd
	 * @throws Exception
	 */
	public void saveM(PageData pd)throws Exception;
	
	
}

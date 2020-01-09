package com.fh.service.system.balance;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

/**
 * @author zangmaoyuan
 *2018-5-15
 * 
 */
public interface BalanceManager {

	/**
	 * @param page
	 * @return
	 */
	public List<PageData> listBalances(Page page) throws Exception;
	
	/**
	 * @param page
	 * @return
	 */
	public PageData findById(PageData page) throws Exception;
	
	/**
	 * @param pd
	 * @throws Exception
	 */
	public void deleteB(PageData pd)throws Exception;
	
	/**
	 * @param pd
	 * @throws Exception
	 */
	public void editB(PageData pd)throws Exception;
	
	/**保存
	 * @param pd
	 * @throws Exception
	 */
	public void saveB(PageData pd)throws Exception;
	
	/**批量删除
	 * @param BALANCE_IDS
	 * @throws Exception
	 */
	public void deleteAllB(String[] BALANCE_IDS)throws Exception;
	
	/**通过imei获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByImei(PageData pd)throws Exception;
}

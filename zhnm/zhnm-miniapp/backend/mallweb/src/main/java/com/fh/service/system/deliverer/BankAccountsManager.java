package com.fh.service.system.deliverer;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
public interface BankAccountsManager {

	/**
	 * @param page
	 * @return
	 */
	List<PageData> listDelivererBankAccounts(Page page) throws Exception;
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void deleteDB(PageData pd)throws Exception;
	
	/**通过获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByDBId(PageData pd)throws Exception;
	
	/**
	 * @param pd
	 * @throws Exception
	 */
	public void editD(PageData pd)throws Exception;
}

/**
 * 
 */
package com.fh.service.system.seller;

import java.util.List;

import org.change.entity.Page;
import org.change.util.PageData;

import com.fh.entity.system.Balance;
import com.fh.entity.system.Seller;

/**
 * @author zangmaoyuan
 *2018-6-4
 * 
 */
public interface SellerBlanceManager {

	
	/**liebiao
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listBlances(Page page)throws Exception;
	
	/**liebiao
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Seller> listSellerAll(Page page)throws Exception;
	
	
	/**通过id获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void editSB(PageData pd)throws Exception;
	
	/**修改秤状态
	 * @param pd
	 * @throws Exception
	 */
	public void changeStatus(PageData pd)throws Exception;
	
	/**修改秤状态
	 * @param pd
	 * @throws Exception
	 */
	public void changeBStatus(PageData pd)throws Exception;
	
	
	/**保存
	 * @param pd
	 * @throws Exception
	 */
	public void saveSB(PageData pd)throws Exception;
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void deleteSB(PageData pd)throws Exception;

	
	/**
	 * @param pd
	 * @return
	 */
	public List<Balance> getBalanceAll(Page page)throws Exception;
	
	
	/**
	 * @param pd
	 * @return
	 */
	public PageData findBySellerId(PageData pd)throws Exception;

	
}

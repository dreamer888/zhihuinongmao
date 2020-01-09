package com.fh.service.system.seller;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
public interface SellerCreditAndWalletManager {

	/**信用及钱包
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listcreditAndWallet(Page page)throws Exception;
	
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

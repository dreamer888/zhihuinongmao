package com.fh.service.system.seller;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
public interface SellerWalletDetailManager {
	/**钱包明细
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listWalletDetail(Page page)throws Exception;
	
}

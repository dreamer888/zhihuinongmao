package com.fh.service.system.deliverer;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
public interface BalanceDetailManager {
	
	/**
	 * @param page
	 * @return
	 */
	List<PageData> listDelivererBalanceDetails(Page page) throws Exception;
}

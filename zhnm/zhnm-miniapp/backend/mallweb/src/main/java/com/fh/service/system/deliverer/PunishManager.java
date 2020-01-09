/**
 * 
 */
package com.fh.service.system.deliverer;

import java.util.List;

import org.change.entity.Page;
import org.change.util.PageData;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
public interface PunishManager {

	/**
	 * @param page
	 * @return
	 */
	List<PageData> listDelivererPs(Page page) throws Exception;
	
	
}

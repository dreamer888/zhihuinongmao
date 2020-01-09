package com.fh.service.system.deliverer;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

import com.fh.entity.system.Deliverer;

/**
 * @author zangmaoyuan
 *2018-5-11
 * 
 */
public interface DelivererManager {
	
	/**
	 * @param page
	 * @return
	 */
	List<PageData> listDeliverers(Page page) throws Exception;
	
	
	/**
	 * listBankAccount
	 */
	List<PageData> listBankAccount(Page page) throws Exception;
	
	/**
	 * listPunish
	 */
	List<PageData> listPunish(Page page) throws Exception;
	
	/**
	 * listBonus
	 */
	List<PageData> listBonus(Page page) throws Exception;
	
	
	/**
	 * 
	 */
	List<PageData> listBalance(Page page) throws Exception;
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void deleteM(PageData pd)throws Exception;
	
	/**通过Account获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByAccount(PageData pd)throws Exception;
	
	/**保存
	 * @param pd
	 * @throws Exception
	 */
	public void saveD(PageData pd)throws Exception;
	
	/**批量删除
	 * @param BALANCE_IDS
	 * @throws Exception
	 */
	public void deleteAllD(String[] DELIVERER_IDS)throws Exception;
	
	/**
	 * @param pd
	 * @throws Exception
	 */
	public void editD(PageData pd)throws Exception;
}

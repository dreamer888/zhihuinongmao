package com.fh.service.system.deliverer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.deliverer.BankAccountsManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Service("bankAccountsService")
public class BankAccountsService  implements BankAccountsManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listDelivererBankAccounts(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("BankAccountMapper.BankAccountlistPage", page);
	}

	/**
	 * 
	 */
	@Override
	public void deleteDB(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("BankAccountMapper.deleteDB", pd);
	}

	/**
	 * 
	 */
	@Override
	public PageData findByDBId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("BankAccountMapper.findByDBId", pd);
	}

	/**
	 * 
	 */
	@Override
	public void editD(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("BankAccountMapper.editD", pd);
	}
}

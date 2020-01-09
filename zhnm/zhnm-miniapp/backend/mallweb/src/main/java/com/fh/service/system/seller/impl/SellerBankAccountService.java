package com.fh.service.system.seller.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.seller.SellerBankAccountManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
@Service("sellerBankAccountService")
public class SellerBankAccountService implements SellerBankAccountManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listBankAccount(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("SellerBankAccountMapper.BankAccountlistPage", page);
	}
	
	/**
	 * 
	 */
	@Override
	public void deleteSDB(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("SellerBankAccountMapper.deleteSDB", pd);
	}
	
	/**
	 * 
	 */
	@Override
	public PageData findByDBId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("SellerBankAccountMapper.findByDBId", pd);
	}

	/**
	 * 
	 */
	@Override
	public void editD(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("SellerBankAccountMapper.editD", pd);
	}
}

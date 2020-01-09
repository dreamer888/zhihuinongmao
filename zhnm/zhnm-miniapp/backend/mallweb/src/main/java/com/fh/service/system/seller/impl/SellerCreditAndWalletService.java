package com.fh.service.system.seller.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.seller.SellerCreditAndWalletManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
@Service("sellerCreditAndWalletService")
public class SellerCreditAndWalletService  implements SellerCreditAndWalletManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listcreditAndWallet(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("SellerCreditAndWalletMapper.creditAndWalletlistPage", page);
	}
	
	/**
	 *
	 */
	@Override
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("SellerCreditAndWalletMapper.findById", pd);
	}

	/**
	 * 
	 */
	@Override
	public void editD(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("SellerCreditAndWalletMapper.editD", pd);
	}
}

package com.fh.service.system.seller.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;

import com.fh.entity.system.Balance;
import com.fh.entity.system.Seller;
import com.fh.service.system.seller.SellerBlanceManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-6-4
 * 
 */
@Service("sellerBlaneceService")
public class SellerBlaneceService implements SellerBlanceManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listBlances(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("SellerBlanceMapper.listBlanceslistPage", page);
	}
	
	/**
	 *
	 */
	@Override
	public void deleteSB(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("SellerBlanceMapper.deleteSB", pd);
	}

	/**
	 *
	 */
	@Override
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("SellerBlanceMapper.findById", pd);
	}

	/**
	 * 
	 */
	@Override
	public PageData findBySellerId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("SellerBlanceMapper.findBySellerId", pd);
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Balance> getBalanceAll(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Balance>) dao.findForList("SellerBlanceMapper.BalanceAll", page);
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Seller> listSellerAll(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Seller>) dao.findForList("SellerBlanceMapper.listSellerAll", page);
	}
	
	/**
	 *
	 */
	@Override
	public void editSB(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("SellerBlanceMapper.editSB", pd);
	}

	/**
	 *
	 */
	@Override
	public void changeStatus(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("SellerBlanceMapper.changeBalanceStatus1", pd);
	}
	
	/**
	 *
	 */
	@Override
	public void changeBStatus(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("SellerBlanceMapper.changeBalanceStatus0", pd);
	}
	
	/**
	 *
	 */
	@Override
	public void saveSB(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.save("SellerBlanceMapper.saveSB", pd);
	}	
}

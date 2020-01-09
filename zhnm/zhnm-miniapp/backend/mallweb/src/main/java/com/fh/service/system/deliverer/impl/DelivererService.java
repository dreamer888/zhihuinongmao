package com.fh.service.system.deliverer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;

import com.fh.entity.system.Deliverer;
import com.fh.service.system.deliverer.DelivererManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-11
 * 
 */
@Service("delivererService")
public class DelivererService implements DelivererManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listDeliverers(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("DelivererMapper.DelivererlistPage", page);
	}

	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listBankAccount(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("DelivererMapper.listBankAccounts", page);
	}

	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listPunish(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("DelivererMapper.listPunish", page);
	}

	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listBonus(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("DelivererMapper.listBonus", page);
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listBalance(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("DelivererMapper.listBalance", page);
	}

	/** 
	 * 
	 */
	@Override
	public void deleteM(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("DelivererMapper.deleteD", pd);
	}

	/** 
	 * 
	 */
	@Override
	public PageData findByAccount(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("DelivererMapper.findByAccount", pd);
	}

	/** 
	 * 
	 */
	@Override
	public void saveD(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.save("DelivererMapper.saveD", pd);
	}

	/** 
	 * 
	 */
	@Override
	public void deleteAllD(String[] DELIVERER_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("DelivererMapper.deleteAllD", DELIVERER_IDS);
	}

	/** 
	 * 
	 */
	@Override
	public void editD(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("DelivererMapper.editD", pd);
	}

}

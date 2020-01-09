package com.fh.service.system.deliverer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;

import com.fh.entity.system.Deliverer;
import com.fh.service.system.deliverer.DelivererMarketManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Service("delivererMarketService")
public class DelivererMarketService implements DelivererMarketManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listDelivererMs(Page page) throws Exception {
		// TODO Auto-generated method stub  
		return (List<PageData>) dao.findForList("DelivererMarketMapper.MarketlistPage", page);
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Deliverer> listDelivererAll(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Deliverer>) dao.findForList("DelivererMarketMapper.listDelivererAll", page);
	}
	/**
	 * 
	 */
	@Override
	public PageData findByName(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("DelivererMarketMapper.findByName", pd);
	}

	/**
	 * 
	 */
	@Override
	public PageData findByAccount(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("DelivererMarketMapper.findByAccount", pd);
	}

	/**
	 * 
	 */
	@Override
	public PageData queryDelivererMarket(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("DelivererMarketMapper.queryDelivererMarket", pd);
	}
	
	/**
	 * 
	 */
	@Override
	public void saveD(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("DelivererMarketMapper.saveD", pd);
	}

	/**
	 * 
	 */
	@Override
	public void deleteDM(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("DelivererMarketMapper.deleteDM", pd);
	}
}

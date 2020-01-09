package com.fh.service.system.deliverer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.deliverer.DBalanceManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Service("dBalanceService")
public class DBalanceService  implements DBalanceManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listDelivererDBalances(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("DBalanceMapper.DBalancelistPage", page);
	}

	/**
	 *
	 */
	@Override
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("DBalanceMapper.findById", pd);
	}

	/**
	 * 
	 */
	@Override
	public void editD(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("DBalanceMapper.editD", pd);
	}
}

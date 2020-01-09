package com.fh.service.system.balance.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.balance.BalanceManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-15
 * 
 */
@Service("balanceService")
public class BalanceService implements BalanceManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listBalances(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("BalanceMapper.BalancelistPage", page);
	}

	/**
	 * 
	 */
	@Override
	public void deleteB(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("BalanceMapper.deleteBalance", pd);
	}

	/** 
	 * 
	 */
	@Override
	public void editB(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("BalanceMapper.editB", pd);
	}

	/** 
	 * 
	 */
	@Override
	public void saveB(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.save("BalanceMapper.saveB", pd);
	}

	/** 
	 * 
	 */
	@Override
	public void deleteAllB(String[] BALANCE_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("BalanceMapper.deleteAllB", BALANCE_IDS);
	}

	/** ID查询
	 * 
	 */
	@Override
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findForObject("BalanceMapper.findById", pd);
	}

	/** 
	 * IMEI号查询
	 */
	@Override
	public PageData findByImei(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findForObject("BalanceMapper.findByImei", pd);
	}
}

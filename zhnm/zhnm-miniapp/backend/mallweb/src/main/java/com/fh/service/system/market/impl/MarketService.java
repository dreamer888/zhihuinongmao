package com.fh.service.system.market.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;

import com.fh.entity.system.Market;
import com.fh.service.system.market.MarketManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-10
 * 
 */
@Service("marketService")
public class MarketService implements MarketManager {
	
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listmarkets(Page page)  throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("MarketMapper.MarketlistPage", page);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Market> listmarketAll(Page page)  throws Exception {
		// TODO Auto-generated method stub
		return (List<Market>) dao.findForList("MarketMapper.listmarketAll", page);
	}
	
	/** 
	 * 删除市场
	 */
	@Override
	public void deleteM(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("MarketMapper.deleteM", pd);
	}

	/** 批量删除市场
	 * 
	 */
	@Override
	public void deleteAllM(String[] arrayMARKET_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("MarketMapper.deleteAllM", arrayMARKET_IDS);
	}

	/** 
	 * 
	 */
	@Override
	public PageData findById(PageData page) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findForObject("MarketMapper.findById", page);
	}

	/**
	 * 
	 */
	@Override
	public void editB(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("MarketMapper.editM", pd);
	}

	/** 
	 *
	 */
	@Override
	public void saveM(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.save("MarketMapper.saveM", pd);
	}

	
}

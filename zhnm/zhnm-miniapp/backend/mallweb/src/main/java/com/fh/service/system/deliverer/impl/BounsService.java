package com.fh.service.system.deliverer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.deliverer.BounsManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Service("bounsService")
public class BounsService implements BounsManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listDelivererBs(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("BounsMapper.BounslistPage", page);
	}
}

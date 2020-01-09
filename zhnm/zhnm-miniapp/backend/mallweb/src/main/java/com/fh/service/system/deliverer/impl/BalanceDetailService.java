package com.fh.service.system.deliverer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.deliverer.BalanceDetailManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Service("balanceDetailService")
public class BalanceDetailService  implements BalanceDetailManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**
	 * @see 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listDelivererBalanceDetails(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("BalanceDetailMapper.BDetaillistPage", page);
	}
}

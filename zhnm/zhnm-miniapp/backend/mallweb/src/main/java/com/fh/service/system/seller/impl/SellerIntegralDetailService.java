package com.fh.service.system.seller.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.seller.SellerIntegralDetailManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
@Service("sellerIntegralDetailService")
public class SellerIntegralDetailService implements SellerIntegralDetailManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listIntegralDetail(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("SellerIntegralDetailMapper.IntegralDetaillistPage", page);
	}
}

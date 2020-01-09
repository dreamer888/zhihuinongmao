package com.fh.service.system.seller.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.seller.SellerWalletDetailManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
@Service("sellerWalletDetailService")
public class SellerWalletDetailService implements SellerWalletDetailManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listWalletDetail(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("SellerWalletDetailMapper.WalletDetaillistPage", page);
	}
}

package com.fh.service.system.seller.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.seller.SellerGoodsManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
@Service("sellerGoodsService")
public class SellerGoodsService  implements SellerGoodsManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listGoods(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("SellerGoodsMapper.GoodslistPage", page);
	}
	
	/**
	 *
	 */
	@Override
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("SellerGoodsMapper.findById", pd);
	}

	/**
	 * 
	 */
	@Override
	public void editGoods(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("SellerGoodsMapper.editD", pd);
	}
}

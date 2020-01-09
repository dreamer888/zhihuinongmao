package com.fh.service.system.seller.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yq.dao.DaoSupport;
import org.change.entity.Page;

import com.fh.entity.system.Category;
import com.fh.service.system.seller.SellerManager;
import org.change.util.PageData;

/** 系统商户
 * @author zangmaoyuan
 * 修改时间：2018.05.8
 */
@Service("sellerService")
public class SellerService implements SellerManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/** 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listSellers(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("SellerMapper.SellerlistPage", page);
	}
	
	/**
	 * 分类
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategoryAll(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Category>) dao.findForList("SellerMapper.listCategoryAll", page);
	}
	
	
	/**
	 * 
	 */
	@Override
	public PageData findByCategorySortName(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("SellerMapper.findByCategorySortName", pd);
	}
	
	/** 返回 商户所有分类
	 * 
	 */
	@Override
	public List<PageData> categoryListAll(PageData pd) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * 
	 */
	@Override
	public void deleteS(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("SellerMapper.deleteS", pd);
	}
	
	/**
	 * 
	 */
	@Override
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("SellerMapper.findById", pd);
	}

	/** 
	 * 
	 */
	@Override
	public void editS(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("SellerMapper.editS", pd);
	}
	
	
	/** 
	 * 
	 */
	@Override
	public PageData findSellerByAccount(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (PageData)dao.findForObject("SellerMapper.findSellerByAccount", pd);
	}
	
	/**
	 * 
	 */
	@Override
	public void saveS(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.save("SellerMapper.saveS", pd);
	}


	
	
}

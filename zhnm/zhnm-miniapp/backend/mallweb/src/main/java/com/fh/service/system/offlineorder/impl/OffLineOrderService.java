package com.fh.service.system.offlineorder.impl;

import java.util.List;
import javax.annotation.Resource;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import com.fh.service.system.offlineorder.OffLineOrderManager;
import com.yq.dao.DaoSupport;

/**
 * @author zangmaoyuan
 *2018-5-11
 * 
 */
@Service
public class OffLineOrderService implements OffLineOrderManager{
	
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listOffLineOrders(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("OffLineOrderMapper.OffLineOrderlistPage", page);
	}
	
	/**
	 * 
	 */
	@Override
	public void deleteO(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("OffLineOrderMapper.deleteO", pd);
	}

	/**
	 * 删除附表信息
	 */
	@Override
	public void deleteAppendix(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("OffLineOrderMapper.deleteAppendix", pd);
	}
	
	/**
	 * 批量删除主表信息
	 */
	@Override
	public void deleteAllO(String[] ORDER_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("OffLineOrderMapper.deleteAllO", ORDER_IDS);
		
	}
	
	/**
	 * 批量删除附表信息
	 */
	@Override
	public void deleteAllAppendix(String[] ORDERNUMBER_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("OffLineOrderMapper.deleteAllAppendix", ORDERNUMBER_IDS);
	}
	
	/** 
	 * 获取订单商品详情
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listAllOrderGoods(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("OffLineOrderMapper.listAllOrderGoods", pd);
	}
	
	/**
	 * 通过id获取数据
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public PageData printOfflineOrder(PageData pd) throws Exception {
		return (PageData) dao.findForObject("OffLineOrderMapper.printOfflineOrder", pd);
	}
	
	/**
	 * 通过id获取数据
	 * 
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> printOfflineOrderDetail(PageData pd) throws Exception {
		return  (List<PageData>) dao.findForObject("OffLineOrderMapper.printOfflineOrderDetail", pd); 
	}
	
	
}

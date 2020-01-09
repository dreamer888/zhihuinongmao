package com.yq.service.order.impl;

import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.yq.dao.DaoSupport;
import org.change.entity.Page;
import org.change.util.PageData;
import com.yq.service.order.OrderManager;

/**
 * 说明： 订单 创建人：易钱科技 qq 357788906 创建时间：2017-01-05
 * 
 * @version
 */

@Service("orderService")
@Transactional(propagation=Propagation.REQUIRED)
public class OrderService implements OrderManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**
	 * 新增
	 * 
	 * @param pd
	 * @throws Exception
	 */
	
	public int save(PageData pd) {
		int result = 0 ;
		try {
			dao.save("OrderMapper.save", pd);
			dao.save("OrderDetailMapper.save", pd);
			dao.save("RecordMapper.save", pd);
			String cart_id = pd.getString("cart_id");
			if (StringUtils.isNotEmpty(cart_id)) {
				String[] idsArray = null ;
				if (cart_id.contains(",")) {// 多个商品
					idsArray = cart_id.split(",");
					dao.delete("CartMapper.deleteAll", idsArray);
				}else{
					dao.delete("CartMapper.delete", pd);
				}
			}
			
			result=1;
		} catch (Exception e) {
			e.getStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}

	/**
	 * 删除
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public int delete(PageData pd) throws Exception {
		
		int result = 0 ;
		try {
			dao.delete("OrderMapper.delete", pd);
			dao.delete("OrderDetailMapper.delete", pd);
			
			result=1;
		} catch (Exception e) {
			e.getStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}

	/**
	 * 修改
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public int edit(PageData pd) throws Exception {
		int result = 0 ;
		try {
			dao.update("OrderMapper.edit", pd);
			dao.update("OrderDetailMapper.edit_order_id", pd);
			if((int)pd.get("status")==1){
				dao.update("RecordMapper.save", pd);
			}
			result=1;
		} catch (Exception e) {
			e.getStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
		
	}
	
	public int refund(PageData pd) throws Exception {
		int result = 0 ;
		try {
			dao.update("OrderDetailMapper.edit_order_id", pd);
			if((int)pd.get("status")==4){
				dao.update("RecordMapper.save", pd);
			}
			result=1;
		} catch (Exception e) {
			e.getStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
		
	}
	
	/**
	 * 列表
	 * 
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page) throws Exception {
		return (List<PageData>) dao.findForList("OrderMapper.datalistPage", page);
	}


	/**
	 * 列表(全部)
	 * 
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("OrderMapper.listAll", pd);
	}

	public int count(PageData pd) throws Exception{
		return (int) dao.findForObject("OrderMapper.count", pd);				 
	}
	
	public int order_count(PageData pd) throws Exception{
		return (int) dao.findForObject("OrderMapper.order_count", pd);				 
	}
	
	/**
	 * 通过id获取数据
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd) throws Exception {
		return (PageData) dao.findForObject("OrderMapper.findById", pd);
	}

	/**
	 * 批量删除
	 * 
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS) throws Exception {
		dao.delete("OrderMapper.deleteAll", ArrayDATA_IDS);
	}
    
	/**
	 * 订单流水
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> orderFlow(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("OrderMapper.orderFlow", pd);
	}
	
	/**
	 * 订单结算
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> orderSellerSettle(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("OrderMapper.orderSellerSettle", pd);
	}
	
	/**
	 * 商户结算
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> sellerSettle(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("OrderMapper.sellerSettle", pd);
	}
	
	
}

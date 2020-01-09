package com.yq.service.comment.impl;

import java.util.List;

import javax.annotation.Resource;

import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yq.dao.DaoSupport;
import com.yq.service.comment.CommentManager;

/** 
 * 说明： 评价
 * 创建人：易钱科技 qq 357788906
 * 创建时间：2017-01-05
 * @version
 */
@Service("commentService")
@Transactional(propagation = Propagation.REQUIRED)
public class CommentService implements CommentManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public int save(List<PageData> list,PageData pd)throws Exception{
		int result = 0 ;
		try {
		dao.update("OrderMapper.edit", pd);
		dao.save("CommentMapper.save", list);
		result=1;
		} catch (Exception e) {
			e.getStackTrace();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("CommentMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("CommentMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("CommentMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("CommentMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("CommentMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("CommentMapper.deleteAll", ArrayDATA_IDS);
	}
	
}


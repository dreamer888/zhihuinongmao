package com.weixin.service.button.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yq.dao.DaoSupport;
import org.change.entity.Page;
import org.change.util.PageData;
import com.weixin.service.button.ButtonManager;

/** 
 * 说明： 微信菜单
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-04-10
 * @version
 */
@Service("buttonService")
public class ButtonService implements ButtonManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public int save(PageData pd){
		try {
			dao.save("ButtonMapper.save", pd);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public int delete(PageData pd){
		try {
			dao.delete("ButtonMapper.delete", pd);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public int edit(PageData pd){
		
		try {
			dao.update("ButtonMapper.edit", pd);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
		
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("ButtonMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ButtonMapper.listAll", pd);
	}
	public int selectCount(PageData pd)throws Exception{
		return (int) dao.findForObject("ButtonMapper.selectCount", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("ButtonMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("ButtonMapper.deleteAll", ArrayDATA_IDS);
	}
	
}


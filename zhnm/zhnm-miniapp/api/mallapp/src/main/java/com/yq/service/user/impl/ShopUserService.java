package com.yq.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;

import com.yq.dao.DaoSupport;
import com.yq.service.user.ShopUserManager;

/** 
 * 说明： 会员用户
 * 创建人：壹仟科技 qq 357788906
 * 创建时间：2016-12-28
 * @version
 */
@Service("shopUserService")
public class ShopUserService implements ShopUserManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("ShopUserMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("ShopUserMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("ShopUserMapper.edit", pd);
	}
	
	public void update_phone(PageData pd)throws Exception{
		dao.update("ShopUserMapper.update_phone", pd);
	}
	
	public void setpassword(PageData pd)throws Exception{
		dao.update("ShopUserMapper.setpassword", pd);
	}
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("ShopUserMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ShopUserMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("ShopUserMapper.findById", pd);
	}
	
	
	public PageData findByPhone(PageData pd)throws Exception{
		return (PageData)dao.findForObject("ShopUserMapper.findByPhone", pd);
	}
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("ShopUserMapper.deleteAll", ArrayDATA_IDS);
	}
	
}


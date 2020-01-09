package com.yq.service.address.impl;

import java.util.List;

import javax.annotation.Resource;

import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;

import com.yq.dao.DaoSupport;
import com.yq.service.address.AddressManager;

/** 
 * 说明： 收货地址
 * 创建人：易钱科技 qq 357788906
 * 创建时间：2017-02-21
 * @version
 */
@Service("addressService")
public class AddressService implements AddressManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("AddressMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("AddressMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("AddressMapper.edit", pd);
	}
	public void updatedefault(PageData pd)throws Exception{
		dao.update("AddressMapper.updatedefault", pd);
	}
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("AddressMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("AddressMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("AddressMapper.findById", pd);
	}
	
	public PageData finddefault(PageData pd)throws Exception{
		return (PageData)dao.findForObject("AddressMapper.finddefault", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("AddressMapper.deleteAll", ArrayDATA_IDS);
	}
	
}


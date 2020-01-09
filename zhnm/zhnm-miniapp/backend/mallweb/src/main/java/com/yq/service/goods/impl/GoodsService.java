package com.yq.service.goods.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yq.dao.DaoSupport;
import org.change.entity.Page;
import org.change.util.PageData;
import com.yq.service.goods.GoodsManager;

/**
 * 说明： 商品管理 创建人：易钱科技 创建时间：2016-12-19
 * 
 * @version
 */
@Service("goodsService")
public class GoodsService implements GoodsManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**
	 * 新增
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd) throws Exception {
		List<PageData> thead_th_list = (List<PageData>) pd.get("thead_th_list");
		if (thead_th_list.size() != 0) {
			dao.save("AttributeMapper.save_th", pd);
			dao.save("AttributeMapper.save_td", pd);
			dao.save("Attribute_detailMapper.save", pd);
		}
		dao.save("GoodsMapper.save", pd);
	}

	/**
	 * 删除
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd) throws Exception {
		dao.delete("GoodsMapper.delete", pd);
	}

	/**
	 * 删除
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public void deleteSellerGoods(PageData pd) throws Exception {
		dao.delete("GoodsMapper.deleteSellerGoods", pd);
	}
	
	/**
	 * 修改
	 * 
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void edit(PageData pd) throws Exception {
		String detail_type = pd.getString("detail_type");
		if (detail_type.equals("1")) {
			List<PageData> thead_th_list = (List<PageData>) pd.get("thead_th_list");
			if (thead_th_list.size() != 0) {
				dao.delete("AttributeMapper.delete", pd);
				dao.delete("Attribute_detailMapper.delete", pd);
				dao.save("AttributeMapper.save_th", pd);
				dao.save("AttributeMapper.save_td", pd);
				dao.save("Attribute_detailMapper.save", pd);
			}
		}
		dao.update("GoodsMapper.edit", pd);
	}

	/**
	 * 列表
	 * 
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page) throws Exception {
		return (List<PageData>) dao.findForList("GoodsMapper.datalistPage", page);
	}

	/**
	 * 列表(全部)
	 * 
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("GoodsMapper.listAll", pd);
	}

	/**
	 * 通过id获取数据
	 * 
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd) throws Exception {
		return (PageData) dao.findForObject("GoodsMapper.findById", pd);
	}

	/**
	 * 批量删除
	 * 
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS) throws Exception {
		dao.delete("GoodsMapper.deleteAll", ArrayDATA_IDS);
	}

	/**
	 * 批量删除
	 * 
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAllSellerGoods(String[] ArrayDATA_IDS) throws Exception {
		dao.delete("GoodsMapper.deleteAllSellerGoods", ArrayDATA_IDS);
	}
}

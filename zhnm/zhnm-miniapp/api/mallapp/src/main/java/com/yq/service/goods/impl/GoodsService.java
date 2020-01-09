package com.yq.service.goods.impl;

import java.util.List;

import javax.annotation.Resource;

import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Service;

import com.wqwy.zhnm.base.component.dto.GoodsDTO;
import com.yq.dao.DaoSupport;
import com.yq.service.goods.GoodsManager;

/** 
 * 说明： 商品管理
 * 创建人：易钱科技
 * 创建时间：2016-12-19
 * @version
 */
@Service("goodsService")
public class GoodsService implements GoodsManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("GoodsMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("GoodsMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("GoodsMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("GoodsMapper.datalistPage", page);
	}
	
	@SuppressWarnings("unchecked")
	public List<PageData> listSpecialMarket(Page page)throws Exception{
		return (List<PageData>)dao.findForList("GoodsMapper.datalistSpecialMarketPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("GoodsMapper.listAll", pd);
	}
	
	@SuppressWarnings("unchecked")
	public List<PageData> listSpecialMarketAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("GoodsMapper.listSpecialMarketAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("GoodsMapper.findById", pd);
	}
	public PageData findByGSId(PageData pd)throws Exception{
		return (PageData)dao.findForObject("GoodsMapper.findByGSId", pd);
	}
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("GoodsMapper.deleteAll", ArrayDATA_IDS);
	}
	
	/**根据农贸市场获取商品库存
	 * @param pd
	 * @throws Exception
	 */
	public GoodsDTO getCurrentStock(GoodsDTO goodsDTO)throws Exception{
		return (GoodsDTO)dao.findForObject("GoodsMapper.getCurrentStock", goodsDTO);
	}
	
	
}


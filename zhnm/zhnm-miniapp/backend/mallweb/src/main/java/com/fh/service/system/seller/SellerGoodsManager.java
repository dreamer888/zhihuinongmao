package com.fh.service.system.seller;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
public interface SellerGoodsManager {
	
	/**商品列表
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listGoods(Page page)throws Exception;
	/**通过Account获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	/**
	 * @param pd
	 * @throws Exception
	 */
	public void editGoods(PageData pd)throws Exception;	
}

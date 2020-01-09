package com.fh.service.system.seller;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

import com.fh.entity.system.Category;
import com.fh.entity.system.Seller;

/**
 * @author zangmaoyuan
 *2018-5-8
 * 
 */
public interface SellerManager {
	
	/**用户列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listSellers(Page page)throws Exception;
	
	
	/**所有分类列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Category> listCategoryAll(Page page)throws Exception;
	
	
	/**通过id获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**修改用户
	 * @param pd
	 * @throws Exception
	 */
	public void editS(PageData pd)throws Exception;
	
	/**保存用户
	 * @param pd
	 * @throws Exception
	 */
	public void saveS(PageData pd)throws Exception;
	
	/**通过CategorySortName获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findByCategorySortName(PageData pd)throws Exception;
	
	/**删除用户
	 * @param pd
	 * @throws Exception
	 */
	public void deleteS(PageData pd)throws Exception;
	
	/**
	 * @param pd
	 * @return
	 */
	public List<PageData> categoryListAll(PageData pd);

	/**通过CategorySortName获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData findSellerByAccount(PageData pd)throws Exception;	
}












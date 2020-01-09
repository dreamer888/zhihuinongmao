package com.fh.service.system.offlineorder;

import java.util.List;
import org.change.entity.Page;
import org.change.util.PageData;

/**
 * @author zangmaoyuan
 *2018-5-11
 * 
 */
public interface OffLineOrderManager {

	/**线下订单列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listOffLineOrders(Page page)throws Exception;
	
	/**删除线下订单
	 * @param pd
	 * @throws Exception
	 */
	public void deleteO(PageData pd)throws Exception;
	
	/**删除附表信息
	 * @param pd
	 */
	public void deleteAppendix(PageData pd)throws Exception;
	
	/**批量删除
	 * @param 
	 * @throws Exception
	 */
	public void deleteAllO(String[] OffLineOrder_IDS)throws Exception;
	
	/**批量删除附表信息
	 * 
	 */
	public void deleteAllAppendix(String[] OffLineOrder_IDS)throws Exception;
	
	/**获取订单商品详情
	 * 
	 */
	public List<PageData> listAllOrderGoods(PageData pd)throws Exception;
	
	/**打印线下订单
	 * @param pd
	 * @throws Exception
	 */
	public PageData printOfflineOrder(PageData pd)throws Exception;
	
	/**线下订单明细
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> printOfflineOrderDetail(PageData pd)throws Exception;
	
}

package com.wqwy.zhnm.base.service.async;

import java.util.List;
import java.util.concurrent.Future;

import com.wqwy.zhnm.base.component.component.BalanceOfflineOrderNotifyToMQComponent;
import com.wqwy.zhnm.base.component.component.SellerGoodsComponent;
import com.wqwy.zhnm.base.component.component.ShopOrderPrintComponent;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailDTO;
import com.wqwy.zhnm.base.component.response.SellerDetailResponse;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;

public interface RabbitMQAsyncJobService {

	/**
	 * 
	 * @Title: doSendOrderGoodsMessageToMQSellerQueue  
	 * @Description: 发送订单商品列表信息到seller的队列通知其抢单  
	 * @date 20 May 2018 10:36:17 AM  
	 * @param @param shopOrderDetailDTOList
	 * @param @return  
	 * @return Future<String>  
	 * @throws
	 */
	public Future<String> doSendOrderGoodsMessageToMQSellerQueue(ShopOrderDTO shopOrder, List<ShopOrderDetailDTO> shopOrderDetailDTOList);
	
	/**
	 * 
	 * @Title: doSendOrderGoodsPrepareMessageToMQSellerQueue  
	 * @Description: 发送订单商品列表信息到seller的队列通知其备货  
	 * @date 21 May 2018 10:09:20 AM  
	 * @param @param shopOrderDetailDTOList
	 * @param @return  
	 * @return Future<String>  
	 * @throws
	 */
	public Future<String> doSendOrderGoodsPrepareMessageToMQSellerQueue(ShopOrderDTO shopOrder, List<ShopOrderDetail> shopOrderDetailList);
	
	/**
	 * 
	 * @Title: doSendOrderMessageToMQDelivererQueue  
	 * @Description: 发送订单信息到配送员通知其去商户取货  
	 * @date 23 May 2018 4:32:05 PM  
	 * @param @param shopOrderDetailList
	 * @param @return  
	 * @return Future<String>  
	 * @throws
	 */
	public Future<String> doSendOrderMessageToMQDelivererQueue(ShopOrder... shopOrders);
	
	/**
	 * 
	 * @Title: sendRegisterOrLoginMessage  
	 * @Description: 发送 商户或称 注册或登录 消息到队列  
	 * @date 17 May 2018 3:08:15 PM  
	 * @param @param sellerDetailResponse  
	 * @return void  
	 * @throws
	 */
	public Future<String> doSendRegisterOrLoginMessage(SellerDetailResponse sellerDetailResponse);
	
	public Future<String> doSendOrderGoodsMessageToMQBalanceQueue(ShopOrderDTO shopOrder, List<ShopOrderDetailDTO> shopOrderDetailDTOList);
	
	public Future<String> doSendBalanceOfflineOrderMessageToMQBalanceQueueForPayNotify(BalanceOfflineOrderNotifyToMQComponent balanceOfflineOrderNotifyToMQComponent);
	
	/**
	 * 
	 * @Title: doSendUpdateShortcutMessage  
	 * @Description: 发送 商户更新快捷键消息到队列  
	 * @date 9 Jul 2018 3:08:15 PM  
	 * @param @param sellerDetailResponse  
	 * @return void  
	 * @throws
	 */
	public Future<String> doSendUpdateShortcutMessage(SellerGoodsComponent sellerGoodsComponent);
	
	/**
	 * 
	 * @Title: doSendUpdateGoodsMessage  
	 * @Description: 发送 商户修改商品消息到队列  
	 * @date 9 Jul 2018 3:08:15 PM  
	 * @param @param sellerDetailResponse  
	 * @return void  
	 * @throws
	 */
	public Future<String> doSendUpdateGoodsMessage(SellerGoodsComponent sellerGoodsComponent); 
	
	/**
	 * 
	 * @Title: doSendPrintOrderMessage  
	 * @Description: 发送打印订单消息到队列  
	 * @date 11 Jul 2018 2:01:15 PM  
	 * @param @param sellerDetailResponse  
	 * @return void  
	 * @throws
	 */
	public Future<String> doSendPrintOrderMessage(ShopOrderPrintComponent shopOrderPrintComponent);
	
	/**
	 * 
	 * @Title: doSendUnPrepareGoodsMessageToMQBalanceQueue  
	 * @Description: 10,20分钟未备货发送mq到称  
	 * @date 11 Jul 2018 2:01:15 PM  
	 * @param @param ShopOrder  
	 * @return void  
	 * @throws
	 */
	public Future<String> doSendUnPrepareGoodsMessageToMQBalanceQueue(ShopOrderDTO shopOrder, List<ShopOrderDetailDTO> shopOrderDetailDTOList,String msgType);
	
	/**
	 * 
	 * @Title: doSendUnPrepareGoodsMessageToMQSellerQueue  
	 * @Description: 10,20分钟未备货发送mq到称  
	 * @date 11 Jul 2018 2:01:15 PM  
	 * @param @param ShopOrder  
	 * @return void  
	 * @throws
	 */
	public Future<String> doSendUnPrepareGoodsMessageToMQSellerQueue(ShopOrderDTO shopOrder, List<ShopOrderDetailDTO> shopOrderDetailDTOList,String msgType);
	
}

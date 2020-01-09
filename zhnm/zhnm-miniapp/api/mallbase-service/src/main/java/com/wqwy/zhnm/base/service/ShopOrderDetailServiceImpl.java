/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.base.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.component.ShopOrderDetailWithGoodsComponent;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailPrintDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderPrintDTO;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.request.SellerPreemptRequest;
import com.wqwy.zhnm.base.component.utils.DateUtils;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.dao.SellerGoodsMapper;
import com.wqwy.zhnm.base.dao.ShopOrderDetailMapper;
import com.wqwy.zhnm.base.dao.ShopOrderMapper;
import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.service.async.RabbitMQAsyncJobService;
import com.wqwy.zhnm.base.service.base.AboutOrderService;
import com.wqwy.zhnm.base.service.base.QuartzManager;
import com.wqwy.zhnm.base.service.job.OverTimeUnPrepareGoodsJob;

/**
 * createTime: 2018-05-15 11:51:43
 * 
 * @author seven
 * @version
 */
@Service
public class ShopOrderDetailServiceImpl implements ShopOrderDetailService {
	
	public static final String TEN_UNPREPAREGOODS_JOB_NAME = "job_ten_orderunpreparegoods_";
	public static final String TEN_UNPREPAREGOODS_TRIGGER_NAME = "trigger_ten_orderUnPrepareGoods_";
	public static final String TEN_UNPREPAREGOODS_JOB_GROUP_NAME = "job_order_ten_orderUnPrepareGoods";
	public static final String TEN_UNPREPAREGOODS_TRIGGER_GROUP_NAME = "trigger_ten_order_orderUnPrepareGoods";
	
	public static final String TWENTY_UNPREPAREGOODS_JOB_NAME = "job_twenty_orderUnPrepareGoods_";
	public static final String TWENTY_UNPREPAREGOODS_TRIGGER_NAME = "trigger_twenty_orderUnPrepareGoods_";
	public static final String TWENTY_UNPREPAREGOODS_JOB_GROUP_NAME = "job_order_twenty_orderUnPrepareGoods";
	public static final String TWENTY_UNPREPAREGOODS_TRIGGER_GROUP_NAME = "trigger_twenty_order_orderUnPrepareGoods";
    
	public static final long reparegoodstimelimitone = 10*60*1000;// 10*60*1000  ；10分钟未备货通知称、商户端
	public static final long reparegoodstimelimittwo = 20*60*1000;// 20*60*1000  ；20分钟未备货通知称、商户端
	
	public static final String tenminunpreparegoodsmsgtype = "10"; // 10分钟未备货消息类型
	public static final String twentyminunpreparegoodsmsgtype = "20"; //20分钟未备货消息类型 
	
	@Autowired
	private ShopOrderDetailMapper shopOrderDetailMapper;

	@Autowired
	private SellerGoodsMapper sellerGoodsMapper;

	@Autowired
	private ShopOrderMapper shopOrderMapper;

	@Autowired
	private RabbitMQAsyncJobService rabbitMQAsyncJobService;

	@Autowired
	private DelivererMarketService delivererMarketService;
	
	@Autowired
	private ShopOrderService shopOrderService;
	
	@Autowired
	private ShopOrderDetailService shopOrderDetailService; 

	@Autowired
	private QuartzManager quartzManager;
    
	private static final Logger logger = LoggerFactory.getLogger(ShopOrderDetailServiceImpl.class);

	@Override
	public ShopOrderDetail get(String orderDetailId) {
		return shopOrderDetailMapper.get(orderDetailId);
	}

	@Override
	public List<ShopOrderDetail> findList(ShopOrderDetail shopOrderDetail) {
		return shopOrderDetailMapper.findList(shopOrderDetail);
	}

	@Override
	public List<ShopOrderDetailWithGoodsComponent> findListWithGoods(
			ShopOrderDetailWithGoodsComponent shopOrderDetail) {
		return shopOrderDetailMapper.findListWithGoods(shopOrderDetail);
	}

	@Override
	public Page<ShopOrderDetail> findListByPage(ShopOrderDetail shopOrderDetail, Pagenation pagenation) {
		PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
		return shopOrderDetailMapper.findListByPage(shopOrderDetail);
	}

	@Override
	public Integer insert(ShopOrderDetail shopOrderDetail) {
		// shopOrderDetail.setCreateTime(new Date());
		return shopOrderDetailMapper.insert(shopOrderDetail);
	}

	@Override
	public Integer update(ShopOrderDetail shopOrderDetail) {
		return shopOrderDetailMapper.update(shopOrderDetail);
	}

	@Override
	public ShopOrderDTO updateMultipleForPreempt(SellerPreemptRequest sellerPreemptRequest) {
		// return shopOrderDetailMapper.update(shopOrderDetail);
		Integer hasNoChoice = DefaultConstants.ZERO_INTEGER;
		List<ShopOrderDetail> sodList = sellerPreemptRequest.getShopOrderDetailList();
		Assert.notEmpty(sodList, "updateMultipleForPreempt list cannot empty");
		/*
		 * shopOrderDetail list 中仅有可能为一个shopOrder
		 */
		String shopOrderId = StringUtils.EMPTY;
		List<ShopOrderDetail> sodPreemptedList = new ArrayList<ShopOrderDetail>();
		for (ShopOrderDetail shopOrderDetail : sodList) {
			/*
			 * 1.check 商户可抢该商品 2.减少商户库存 3.修改商品被该商户抢
			 */
			String shopOrderDetailId = shopOrderDetail.getOrderDetailId();
			Integer sellerId = shopOrderDetail.getSellerId();
			// Integer status = shopOrderDetail.getStatus();
			/*
			 * 1
			 */
			ShopOrderDetail sod = shopOrderDetailMapper.getForUpdate(shopOrderDetailId);
			shopOrderId = sod.getOrderId();

			// 已被抢了
			if (sod.getSellerId() != null)
				continue;
			SellerGoods sellerGoods = new SellerGoods();
			sellerGoods.setSellerId(shopOrderDetail.getSellerId());
			sellerGoods.setGoodsId(sod.getGoodsId());

			Assert.notNull(shopOrderDetail.getSellerId(), "sellerId not null not empty");
			Assert.notNull(sod.getGoodsId(), "goodsId not null not empty");

			/*
			 * 2
			 */
			List<SellerGoods> sgList = sellerGoodsMapper.findListForUpdate(sellerGoods);
			if (sgList == null || sgList.isEmpty())
				continue;
			sellerGoods = sgList.get(0);
			// 商户该商品不在售卖状态
			if (!DefaultConstants.SellerGoodsEnum.ON_SALE.getSellerGoodsEnum().equals(sellerGoods.getStatus()))
				continue;
			// 商户库存不足了
			if (sellerGoods.getCurrentStock().compareTo(sod.getGoodsCount()) < 0)
				continue;
			sellerGoods.setCurrentStock(sellerGoods.getCurrentStock().subtract(sod.getGoodsCount()));
			sellerGoodsMapper.update(sellerGoods);

			/*
			 * 3
			 */
			sod.setStatus(DefaultConstants.ShopOrderEnum.SHOPORDER_SELLER_PREEMPTED.getShopOrderEnum());
			sod.setSellerId(sellerId);
			sod.setSellerSeizeTime(new Date());
			shopOrderDetailMapper.update(sod);

			hasNoChoice += 1;
			// 将已经抢成功的商品加入list
			sodPreemptedList.add(sod);
		}

		ShopOrderDTO shopOrder = new ShopOrderDTO();
		shopOrder.setOrderId(shopOrderId);
		List<ShopOrderDTO> shopOrderDTOList = shopOrderMapper.findShopOrdersByPage(shopOrder);
		shopOrder = shopOrderDTOList.get(0);
		if (shopOrderDTOList == null || shopOrderDTOList.isEmpty())
			throw new BusinessException();
		if (hasNoChoice == DefaultConstants.ZERO_INTEGER)
			throw new BusinessException(ResultUtils.SHOP_ORDER_GOODS_PREEMPTED,
					ResultUtils.SHOP_ORDER_GOODS_PREEMPTED_MSG, shopOrder);
		/*
		 * 4.查询是否所有商品全被抢 5.全被抢后修改 订单&子订单 状态 并发送消息到所有商户通知备货 6.删除取消订单任务
		 */
		ShopOrderDetail sodForSearch = new ShopOrderDetail();
		sodForSearch.setOrderId(shopOrderId);
		List<ShopOrderDetail> sodAllList = shopOrderDetailMapper.findList(sodForSearch);
		if (sodAllList.stream().allMatch(s -> s.getSellerId() != null)) {
			shopOrder.setStatus(DefaultConstants.ShopOrderEnum.SHOPORDER_WAIT_SELLER_PREPARE_GOODS.getShopOrderEnum());
			shopOrderMapper.update(shopOrder);
			sodAllList.stream().forEach(s -> {
				s.setStatus(DefaultConstants.ShopOrderEnum.SHOPORDER_WAIT_SELLER_PREPARE_GOODS.getShopOrderEnum());
				shopOrderDetailMapper.update(s);
			});
			// 发送消息通知备货
			rabbitMQAsyncJobService.doSendOrderGoodsPrepareMessageToMQSellerQueue(shopOrder, sodAllList);
			// 删除取消订单任务
			quartzManager.removeJob(AboutOrderService.JOB_NAME + shopOrder.getOrderId(),
					AboutOrderService.JOB_GROUP_NAME, AboutOrderService.TRIGGER_NAME + shopOrder.getOrderId(),
					AboutOrderService.TRIGGER_GROUP_NAME);
		}
        
		//10分钟未备货发送mq到称、商户端
		if(shopOrder.getStatus()==DefaultConstants.ShopOrderEnum.SHOPORDER_WAIT_SELLER_PREPARE_GOODS.getShopOrderEnum()){
			  //mq
			  Date triggerTime = new Date(new Date().getTime() + reparegoodstimelimitone);
			  String triggerTimeString = DateUtils.GetCron(triggerTime);
			  Map<String, String> dataLoadMap = new HashMap<String, String>();
			  dataLoadMap.put(DefaultConstants.JOB_DETAIL_ONLINE_SHOPORDER_ID, shopOrder.getOrderId());
			  dataLoadMap.put(DefaultConstants.JOB_UNPREPARE_MSG_TYPE, tenminunpreparegoodsmsgtype); 
			  quartzManager.addJob(TEN_UNPREPAREGOODS_JOB_NAME + shopOrder.getOrderId(), TEN_UNPREPAREGOODS_JOB_GROUP_NAME, TEN_UNPREPAREGOODS_TRIGGER_NAME + shopOrder.getOrderId(),
			  TEN_UNPREPAREGOODS_TRIGGER_GROUP_NAME, OverTimeUnPrepareGoodsJob.class, triggerTimeString, dataLoadMap);
		}
		//20分钟未备货发送mq到称、商户端
		if(shopOrder.getStatus()==DefaultConstants.ShopOrderEnum.SHOPORDER_WAIT_SELLER_PREPARE_GOODS.getShopOrderEnum()){
			  //mq
			  Date triggerTime = new Date(new Date().getTime() + reparegoodstimelimittwo);
			  String triggerTimeString = DateUtils.GetCron(triggerTime);
			  Map<String, String> dataLoadMap = new HashMap<String, String>(); //
			  dataLoadMap.put(DefaultConstants.JOB_DETAIL_ONLINE_SHOPORDER_ID, shopOrder.getOrderId());
			  dataLoadMap.put(DefaultConstants.JOB_UNPREPARE_MSG_TYPE, twentyminunpreparegoodsmsgtype); 
			  quartzManager.addJob(TWENTY_UNPREPAREGOODS_JOB_NAME + shopOrder.getOrderId(), TWENTY_UNPREPAREGOODS_JOB_GROUP_NAME, TWENTY_UNPREPAREGOODS_TRIGGER_NAME + shopOrder.getOrderId(),
			  TWENTY_UNPREPAREGOODS_TRIGGER_GROUP_NAME, OverTimeUnPrepareGoodsJob.class, triggerTimeString, dataLoadMap);
		}
				
		shopOrder.setShopOrderDetailList(sodPreemptedList);
		return shopOrder;
	}

	@Override
	public Integer updateMultipleForPrepared(ShopOrderDetail shopOrderDetail) {
		Integer sellerId = shopOrderDetail.getSellerId();
		String shopOrderId = shopOrderDetail.getOrderId();
		assert (sellerId != null);
		assert (shopOrderId != null);
		shopOrderDetail
				.setStatus(DefaultConstants.ShopOrderEnum.SHOPORDER_WAIT_DELIVERER_RECEIVE_GOODS.getShopOrderEnum());
		shopOrderDetail.setSellerSeizeTime(new Date());
		Integer resultCount = shopOrderDetailMapper.updateBySellerShopOrder(shopOrderDetail);
		/*
		 * 如果该订单下的所有商户都备货完成, 1.修改订单为待配送状态 2.修改所有子订单到待配送状态(上步已经完成) 2.5.分配一个配送人员
		 * 3.通知配送人员可以开始配送了
		 */
		ShopOrderDetail sodForSearch = new ShopOrderDetail();
		sodForSearch.setOrderId(shopOrderId);
		List<ShopOrderDetail> sodAllList = shopOrderDetailMapper.findList(sodForSearch);
		if (sodAllList.stream().allMatch(s -> DefaultConstants.ShopOrderEnum.SHOPORDER_WAIT_DELIVERER_RECEIVE_GOODS
				.getShopOrderEnum().equals(s.getStatus()))) {
			/*
			 * 1, 2.5
			 */
			ShopOrder so = new ShopOrder();
			so.setOrderId(shopOrderId);
			so = shopOrderMapper.findList(so).get(0);
			Integer delivererId = delivererMarketService.getOneDelivererByShopOrder(so.getMarketId()).getDelivererId();
			so.setStatus(DefaultConstants.ShopOrderEnum.SHOPORDER_WAIT_DELIVERER_RECEIVE_GOODS.getShopOrderEnum());
			so.setDelivererId(delivererId);
			shopOrderMapper.update(so);
			
			for(ShopOrderDetail detail : sodAllList) {
				detail.setSellerPrepareTime(new Date());
				shopOrderDetailMapper.update(shopOrderDetail);
			}
			
			/*
			 * 3
			 */
			rabbitMQAsyncJobService.doSendOrderMessageToMQDelivererQueue(so);
		}
		return resultCount;
	}

	@Override
	public Integer updateMultipleByShopOrder(ShopOrderDetail shopOrderDetail) {
		return shopOrderDetailMapper.updateByShopOrder(shopOrderDetail);
	}

	@Override
	public Integer delete(String orderDetailId) {
		return shopOrderDetailMapper.delete(orderDetailId);
	}

	@Override
	public List<ShopOrderDetailDTO> findListByCondition(ShopOrderDetailDTO shopOrderDetail) {
		return shopOrderDetailMapper.findListByCondition(shopOrderDetail);
	}

	public List<ShopOrderDetailPrintDTO> printOrderDetail(ShopOrderDetail shopOrderDetail){
		return shopOrderDetailMapper.printOrderDetail(shopOrderDetail);
	}
	
	public List<ShopOrderPrintDTO> printOrder(ShopOrderDetail shopOrderDetail){
		return shopOrderDetailMapper.printOrder(shopOrderDetail);
	}
	
}

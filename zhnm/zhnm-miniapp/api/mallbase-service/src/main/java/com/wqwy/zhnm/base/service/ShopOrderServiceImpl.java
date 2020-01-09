/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.OrderDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDTO;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.request.GeodeYuntuDatasearchAroundRequest;
import com.wqwy.zhnm.base.component.response.GeodeYuntuDatasearchAroundResponse;
import com.wqwy.zhnm.base.component.response.GeodeYuntuDatasearchAroundResponseLocationComponent;
import com.wqwy.zhnm.base.component.utils.DateUtils;
import com.wqwy.zhnm.base.component.utils.GeoDeUtils;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.dao.MarketMapper;
import com.wqwy.zhnm.base.dao.ShopOrderDetailMapper;
import com.wqwy.zhnm.base.dao.ShopOrderMapper;
import com.wqwy.zhnm.base.entity.Market;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.service.base.QuartzManager;
import com.wqwy.zhnm.base.service.job.FinishOnlineOrderJob;

/**
 * createTime: 2018-05-15 14:11:17
 * @author seven
 * @version
 */
@Service
public class ShopOrderServiceImpl implements ShopOrderService {

	public static final String JOB_NAME = "job_orderFinished_";
	public static final String TRIGGER_NAME = "trigger_orderFinished_";
	public static final String JOB_GROUP_NAME = "job_order_orderFinished";
	public static final String TRIGGER_GROUP_NAME = "trigger_order_orderFinished";
	
	public static final long OrderTimeLimit = 5*60*1000;//3*60*1000
	
    @Autowired
    private ShopOrderMapper shopOrderMapper;
    
    @Autowired
    private MarketMapper marketMapper;
    
    @Autowired
    private MarketService marketService;
    
    @Autowired
    private ShopOrderDetailMapper shopOrderDetailMapper;
    
    @Autowired
    private QuartzManager quartzManager;

    private static final Logger logger = LoggerFactory.getLogger(ShopOrderServiceImpl.class);

    @Override
    public ShopOrder get(String orderId) {
        return shopOrderMapper.get(orderId);
    }
    
    @Override
    public List<ShopOrderDTO> findShopOrders(ShopOrderDTO shopOrder) {
        return shopOrderMapper.findShopOrdersByPage(shopOrder);
    }

    @Override
    public List<ShopOrder> findList(ShopOrder shopOrder) {
        return shopOrderMapper.findList(shopOrder);
    }

    @Override
    public Page<ShopOrderDTO> findListByPage(ShopOrderDTO shopOrder, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return shopOrderMapper.findListByPage(shopOrder);
    }
    
    @Override
    public Page<ShopOrderDTO> findShopOrdersByPage(ShopOrderDTO shopOrder, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return shopOrderMapper.findShopOrdersByPage(shopOrder);
    }
    
    @Override
    public Page<OrderDTO> findAllOrdersByPage(OrderDTO shopOrder, Pagenation pagenation) {
    	PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return shopOrderMapper.findAllOrdersByPage(shopOrder);
    }
    
    @Override
    public Integer insert(ShopOrder shopOrder) {
//        shopOrder.setCreateTime(new Date());
        return shopOrderMapper.insert(shopOrder);
    }

    @Override
    public Integer update(ShopOrder shopOrder) {
    	Integer status = shopOrder.getStatus();
    	Assert.notNull(status, "status not null");
    	shopOrder = shopOrderMapper.get(shopOrder.getOrderId());
    	String onlineOrderId = shopOrder.getOrderId();
    	
    	boolean needUpdate = false;
    	/*
    	 * 配送人员操作
    	 * 1.取货
    	 * 2.送达
    	 */
    	if (DefaultConstants.ShopOrderEnum.SHOPORDER_SHIPPING.getShopOrderEnum().equals(status)) {
    		// 仅有 待取货 的订单才能开始配送
    		if (!DefaultConstants.ShopOrderEnum.SHOPORDER_WAIT_DELIVERER_RECEIVE_GOODS.getShopOrderEnum().equals(shopOrder.getStatus()))
    			throw new BusinessException(ResultUtils.ORDER_SHIPPING_STATUS_SHOULD_ONLY_USED_IN_PREPARED_ORDER, ResultUtils.ORDER_SHIPPING_STATUS_SHOULD_ONLY_USED_IN_PREPARED_ORDER_MSG);
    		/*
    		 * 1
    		 * 
    		 * 1.子订单标识为已取货
    		 * 2.订单标识为已取货
    		 */
    		needUpdate = true;
    	} else if (DefaultConstants.ShopOrderEnum.SHOPORDER_SHIPPED.getShopOrderEnum().equals(status)) {
    		// 仅有 配送中 的订单才能配送完成
    		if (!DefaultConstants.ShopOrderEnum.SHOPORDER_SHIPPING.getShopOrderEnum().equals(shopOrder.getStatus()))
    			throw new BusinessException(ResultUtils.ORDER_SHIPPRD_STATUS_SHOULD_ONLY_USED_IN_SHIPPING_ORDER, ResultUtils.ORDER_SHIPPRD_STATUS_SHOULD_ONLY_USED_IN_SHIPPING_ORDER_MSG);
    		/*
    		 * 2
    		 * 
    		 * 1.子订单标识为已送达
    		 * 2.订单标识为送达
    		 * 3.添加定时任务
    		 */
    		needUpdate = true;
    		// 3 TODO
    		try {
    			logger.info("do create task for online order: " + onlineOrderId);
    			//TODO
    			Map<String, String> dataLoadMap = new HashMap<String, String>();
    			dataLoadMap.put(DefaultConstants.JOB_DETAIL_ONLINE_SHOPORDER_ID, onlineOrderId);
    			Date triggerTime = new Date(new Date().getTime() + OrderTimeLimit);
    			String triggerTimeString = DateUtils.GetCron(triggerTime);
    			quartzManager.addJob(JOB_NAME + onlineOrderId, JOB_GROUP_NAME, TRIGGER_NAME + onlineOrderId,
    					TRIGGER_GROUP_NAME, FinishOnlineOrderJob.class, triggerTimeString, dataLoadMap);
    		} catch (Exception e) {
    			logger.error("do create task for online order " + onlineOrderId + " failed");
    			logger.error(e.getMessage());
    			throw new BusinessException();
    		}
    	}
    	if (needUpdate) {
    		ShopOrderDetail sod = new ShopOrderDetail();
    		sod.setOrderId(shopOrder.getOrderId());
    		sod.setStatus(status);
    		shopOrderDetailMapper.updateByShopOrder(sod);
    		shopOrder.setStatus(status);
    		shopOrderMapper.update(shopOrder);
    	}
    	return null;
    }
    
    @Override
    public Integer updateForJob(ShopOrder shopOrder) {
    	return shopOrderMapper.update(shopOrder);
    }

    @Override
    public Integer delete(String orderId) {
        return shopOrderMapper.delete(orderId);
    }

	@Override
	public Integer getOneNearMarketByShopOrder(ShopOrder shopOrder) {
		/*
		 * 地图api获取收货地址(location)附近最近的菜市场
		 * 若不存在可用的菜市场,throw异常终止操作
		 */
//		assert(shopOrder.getLocation()!=null);
//		GeodeYuntuDatasearchAroundRequest gydar = new GeodeYuntuDatasearchAroundRequest();
//		gydar.setCenter(shopOrder.getLocation());
//		GeodeYuntuDatasearchAroundResponse gydaResponse;
//		try {
//			gydaResponse = GeoDeUtils.getDatasearchAroundResponse(gydar);
//		} catch (Exception e) {
//			logger.error("调用getDatasearchAroundResponse接口报错");
//			logger.error(e.getMessage());
//			throw new BusinessException();//调用geode接口报错
//		}
//		List<GeodeYuntuDatasearchAroundResponseLocationComponent> datas = gydaResponse.getDatas();
//		if (datas==null || datas.isEmpty())
//			throw new BusinessException(ResultUtils.RECEIVE_LOCATION_NOT_AVALIABLE, ResultUtils.RECEIVE_LOCATION_NOT_AVALIABLE_MSG);//收获位置不在任何菜市场范围之内
//		Integer marketGeodeId = Integer.valueOf(datas.get(0).get_id());
//		Market market = new Market();
//		market.setGeodeId(marketGeodeId);
//		List<Market> mList = marketMapper.findList(market);
//		assert(mList!=null && !mList.isEmpty());//正常情况下不能没有对应的geodeId的marketId
//		return mList.get(0).getId();
		String location = shopOrder.getLocation();
		List<Market> mList = marketService.findListMarketByLocation(location);
		if(null==mList || mList.isEmpty()) {
			return null;
		}
		return mList.get(0).getId();
	}
}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.dao.DelivererMarketMapper;
import com.wqwy.zhnm.base.entity.DelivererMarket;

/**
 * createTime: 2018-05-08 18:50:59
 * @author seven
 * @version
 */
@Service
public class DelivererMarketServiceImpl implements DelivererMarketService {

    @Autowired
    private DelivererMarketMapper delivererMarketMapper;

    private static final Logger logger = LoggerFactory.getLogger(DelivererMarketServiceImpl.class);

    @Override
    public DelivererMarket get(String id) {
        return delivererMarketMapper.get(id);
    }

    @Override
    public List<DelivererMarket> findList(DelivererMarket delivererMarket) {
        return delivererMarketMapper.findList(delivererMarket);
    }

    @Override
    public Page<DelivererMarket> findListByPage(DelivererMarket delivererMarket, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return delivererMarketMapper.findListByPage(delivererMarket);
    }

    @Override
    public Integer insert(DelivererMarket delivererMarket) {
//        delivererMarket.setCreateTime(new Date());
        return delivererMarketMapper.insert(delivererMarket);
    }

    @Override
    public Integer update(DelivererMarket delivererMarket) {
//        delivererMarket.setUpdateTime(new Date());
        return delivererMarketMapper.update(delivererMarket);
    }

    @Override
    public Integer delete(String id) {
        return delivererMarketMapper.delete(id);
    }
    
    @Override
	public DelivererMarket getOneDelivererByShopOrder(Integer marketId) {
    	Assert.notNull(marketId, "marketId not null");
		/*
		 *  TODO 
		 *  通过单个订单 找到应该配送该订单的配送人员
		 *  改为配送人员抢单实现后将不再需要
		 */
		/*
		 * 通过marketId获取配送人员,随机选择一个
		 */
    	DelivererMarket dm = new DelivererMarket();
    	dm.setMarketId(marketId);
		List<DelivererMarket> dmList = delivererMarketMapper.findList(dm);
		if (dmList==null || dmList.isEmpty())
			throw new BusinessException(ResultUtils.MARKET_HAS_NO_DELIVERER, ResultUtils.MARKET_HAS_NO_DELIVERER_MSG);
		int index = ThreadLocalRandom.current().nextInt(dmList.size());
		return dmList.get(index);
	}
    
}

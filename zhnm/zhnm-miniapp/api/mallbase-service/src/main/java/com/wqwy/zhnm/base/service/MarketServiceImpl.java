/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.wqwy.zhnm.base.dao.MarketMapper;
import com.wqwy.zhnm.base.entity.Market;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.request.GeodeYuntuDatasearchAroundRequest;
import com.wqwy.zhnm.base.component.response.GeodeYuntuDatasearchAroundResponse;
import com.wqwy.zhnm.base.component.response.GeodeYuntuDatasearchAroundResponseLocationComponent;
import com.wqwy.zhnm.base.component.utils.GeoDeUtils;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.service.MarketService;

/**
 * createTime: 2018-05-08 18:51:01
 * @author seven
 * @version
 */
@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketMapper marketMapper;

    private static final Logger logger = LoggerFactory.getLogger(MarketServiceImpl.class);

    @Override
    public Market get(String id) {
        return marketMapper.get(id);
    }

    @Override
    public List<Market> findList(Market market) {
        return marketMapper.findList(market);
    }
    
    @Override
    public List<Market> findListMarketByLocation(String location) {
    	GeodeYuntuDatasearchAroundRequest gydar = new GeodeYuntuDatasearchAroundRequest();
		gydar.setCenter(location);
		GeodeYuntuDatasearchAroundResponse gydaResponse;
		try {
			gydaResponse = GeoDeUtils.getDatasearchAroundResponse(gydar);
		} catch (Exception e) {
			logger.error("调用getDatasearchAroundResponse接口报错");
			logger.error(e.getMessage());
			//throw new BusinessException();//调用geode接口报错
			return null;
		}
		List<GeodeYuntuDatasearchAroundResponseLocationComponent> datas = gydaResponse.getDatas();
		if (datas==null || datas.isEmpty()) {
			logger.error("收货位置不在任何菜市场范围之内");
			return null;
			//throw new BusinessException(ResultUtils.RECEIVE_LOCATION_NOT_AVALIABLE, ResultUtils.RECEIVE_LOCATION_NOT_AVALIABLE_MSG);//收获位置不在任何菜市场范围之内
		}
			
		return datas.stream().map(d -> {
			Integer marketGeodeId = Integer.valueOf(d.get_id());
			Market market = new Market();
			market.setGeodeId(marketGeodeId);
			List<Market> mList = marketMapper.findList(market);
			if (mList == null || mList.isEmpty()) {
				  logger.error("收货位置不在任何菜市场范围之内");
				return null;
			}
				
				//throw new BusinessException(ResultUtils.GEODE_MAP_CONFLICT_WITH_DB, ResultUtils.GEODE_MAP_CONFLICT_WITH_DB_MSG);
			return mList.get(0);
		}).collect(Collectors.toList());
    }

    @Override
    public Page<Market> findListByPage(Market market, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return marketMapper.findListByPage(market);
    }

    @Override
    public Integer insert(Market market) {
        market.setCreateTime(new Date());
        return marketMapper.insert(market);
    }

    @Override
    public Integer update(Market market) {
        market.setUpdateTime(new Date());
        return marketMapper.update(market);
    }

    @Override
    public Integer delete(String id) {
        return marketMapper.delete(id);
    }
}

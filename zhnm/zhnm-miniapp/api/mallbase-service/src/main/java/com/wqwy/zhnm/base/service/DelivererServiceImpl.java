/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.request.DelivererRegisterRequest;
import com.wqwy.zhnm.base.component.response.DelivererDetailResponse;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.component.utils.ValidateUtils;
import com.wqwy.zhnm.base.dao.DelivererDynamicMapper;
import com.wqwy.zhnm.base.dao.DelivererMapper;
import com.wqwy.zhnm.base.entity.Deliverer;
import com.wqwy.zhnm.base.entity.DelivererDynamic;

/**
 * createTime: 2018-05-08 18:50:56
 * @author seven
 * @version
 */
@Service
public class DelivererServiceImpl implements DelivererService {

    @Autowired
    private DelivererMapper delivererMapper;
    
    @Autowired
    private DelivererDynamicMapper delivererDynamicMapper;

    private static final Logger logger = LoggerFactory.getLogger(DelivererServiceImpl.class);

    @Override
    public Deliverer get(String id) {
        return delivererMapper.get(id);
    }

    @Override
    public List<Deliverer> findList(Deliverer deliverer) {
        return delivererMapper.findList(deliverer);
    }

    @Override
    public Page<Deliverer> findListByPage(Deliverer deliverer, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return delivererMapper.findListByPage(deliverer);
    }

    @Override
    public DelivererDetailResponse insert(DelivererRegisterRequest deliverer) {
    	logger.info("DelivererRegisterRequest: " + deliverer.toString());
    	/*
    	 * 1.配送人员account不存在
    	 */
    	Deliverer delivererForAuth = new Deliverer();
    	delivererForAuth.setAccount(deliverer.getAccount());
    	List<Deliverer> delivererForAuthList = delivererMapper.findList(delivererForAuth);
    	if (delivererForAuthList!=null && !delivererForAuthList.isEmpty())
    		throw new BusinessException(ResultUtils.USER_ALREADY_EXIST, ResultUtils.USER_ALREADY_EXIST_MSG);
    	/*
    	 * 1.创建配送人员账户
    	 * 2.创建配送人员动态数据
    	 */
    	/*
    	 * 1
    	 */
    	String token = ValidateUtils.GetToken(deliverer.getAccount(), deliverer.getPassword());
    	deliverer.setToken(token);
    	deliverer.setStatus(DefaultConstants.DelivererEnum.STATUS_NOMAL.getDelivererEnum());
    	delivererMapper.insert(deliverer);
    	Deliverer d = new Deliverer();
    	d.setToken(token);
    	d = delivererMapper.findList(d).get(0);
    	
    	/*
    	 * 2
    	 */
    	DelivererDynamic delivererDynamic = new DelivererDynamic();
    	delivererDynamic.setDelivererId(d.getId());
    	delivererDynamic.setEvaluationTotal(DefaultConstants.ZERO_INTEGER);
    	delivererDynamic.setEvaluationCount(DefaultConstants.ZERO_INTEGER);
    	delivererDynamic.setPoints(DefaultConstants.ZERO_INTEGER);
    	delivererDynamic.setWallet(BigDecimal.ZERO);
    	delivererDynamicMapper.insert(delivererDynamic);
    	
    	DelivererDetailResponse delivererDetailResponse = new DelivererDetailResponse();
    	delivererDetailResponse.setDeliverer(d);
    	delivererDetailResponse.setDelivererDynamic(delivererDynamic);
    	return delivererDetailResponse;
    }

    @Override
    public Integer update(Deliverer deliverer) {
//        deliverer.setUpdateTime(new Date());
        return delivererMapper.update(deliverer);
    }

    @Override
    public Integer delete(String id) {
        return delivererMapper.delete(id);
    }

}

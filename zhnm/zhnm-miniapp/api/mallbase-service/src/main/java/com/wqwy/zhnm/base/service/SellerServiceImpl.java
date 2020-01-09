/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.component.SellerCategoryNameComponent;
import com.wqwy.zhnm.base.component.component.SellerMarketComponent;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.request.SellerRegisterRequest;
import com.wqwy.zhnm.base.component.response.SellerDetailResponse;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.component.utils.ValidateUtils;
import com.wqwy.zhnm.base.dao.BalanceMapper;
import com.wqwy.zhnm.base.dao.MarketMapper;
import com.wqwy.zhnm.base.dao.SellerBalanceMapper;
import com.wqwy.zhnm.base.dao.SellerDynamicMapper;
import com.wqwy.zhnm.base.dao.SellerMapper;
import com.wqwy.zhnm.base.dao.ShopCategoryMapper;
import com.wqwy.zhnm.base.entity.Balance;
import com.wqwy.zhnm.base.entity.Market;
import com.wqwy.zhnm.base.entity.Seller;
import com.wqwy.zhnm.base.entity.SellerBalance;
import com.wqwy.zhnm.base.entity.SellerDynamic;
import com.wqwy.zhnm.base.entity.ShopCategory;
import com.wqwy.zhnm.base.service.async.RabbitMQAsyncJobService;
import com.wqwy.zhnm.base.service.SellerService;

/**
 * createTime: 2018-05-08 18:51:02
 * @author seven
 * @version
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerMapper sellerMapper;
    
    @Autowired
    private SellerDynamicMapper sellerDynamicMapper;
    
    @Autowired
    private ShopCategoryMapper shopCategoryMapper;
    
    @Autowired
    private SellerBalanceMapper sellerBalanceMapper;
    
    @Autowired
    private BalanceMapper balanceMapper;
    
    @Autowired
    private MarketMapper marketMapper;
    
    @Autowired
    private RabbitMQAsyncJobService rabbitMQAsyncJobService;

    private static final Logger logger = LoggerFactory.getLogger(SellerServiceImpl.class);

    @Override
    public Seller get(String id) {
        return sellerMapper.get(id);
    }
    
    @Override
    public SellerMarketComponent getWithMarket(String id) {
    	return sellerMapper.getWithMarket(id);
    }

    @Override
    public List<Seller> findList(Seller seller) {
        return sellerMapper.findList(seller);
    }

    @Override
    public Page<Seller> findListByPage(Seller seller, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return sellerMapper.findListByPage(seller);
    }

    @Override
    public SellerDetailResponse insert(SellerRegisterRequest seller) {
    	logger.info("SellerRegisterRequest: " + seller.toString());
    	/*
    	 * 1.商户account不存在
    	 * 2.称未绑定
    	 */
    	Seller sellerForAuth = new Seller();
    	sellerForAuth.setAccount(seller.getAccount());
    	List<Seller> sellerForAuthList = sellerMapper.findList(sellerForAuth);
    	if (sellerForAuthList!=null && !sellerForAuthList.isEmpty())
    		throw new BusinessException(ResultUtils.USER_ALREADY_EXIST, ResultUtils.USER_ALREADY_EXIST_MSG);
    	Assert.isTrue(seller.getBalanceImei()!=null || seller.getBalanceId()!=null, "need balance information");
    	Balance balanceForAuth = new Balance();
    	balanceForAuth.setId(seller.getBalanceId());
    	balanceForAuth.setBalanceImei(seller.getBalanceImei());
    	List<Balance> balanceForAuthList = balanceMapper.findList(balanceForAuth);
    	if (balanceForAuthList == null || balanceForAuthList.isEmpty())
    		throw new BusinessException(ResultUtils.BALANCE_IMEI_WRONG, ResultUtils.BALANCE_IMEI_WRONG_MSG);
    	balanceForAuth = balanceForAuthList.get(0);
    	if (balanceForAuth==null || DefaultConstants.BalanceEnum.USED.getBalanceEnum()==balanceForAuth.getUsed().booleanValue())
    		throw new BusinessException(ResultUtils.BALANCE_ALREADY_BINDED_SELLER, ResultUtils.BALANCE_ALREADY_BINDED_SELLER_MSG);
    	
    	/*
    	 * 1.创建商户账户
    	 * 2.创建商户动态数据
    	 * 3.创建商户-称绑定
    	 * 4.修改称为已经使用
    	 * 5.返回response
    	 * 6.同时将response发入MQ
    	 */
    	/*
    	 * 1
    	 */
    	String token = ValidateUtils.GetToken(seller.getAccount(), seller.getPassword());
		seller.setToken(token);
    	sellerMapper.insert(seller);
    	Seller s = new Seller();
    	s.setToken(token);
    	s = sellerMapper.findList(s).get(0);
    	
    	/*
    	 * 2
    	 */
    	SellerDynamic sellerDynamic = new SellerDynamic();
    	sellerDynamic.setSellerId(s.getId());
    	sellerDynamic.setEvaluationTotal(DefaultConstants.ZERO_INTEGER);
    	sellerDynamic.setEvaluationCount(DefaultConstants.ZERO_INTEGER);
    	sellerDynamic.setSellerPoints(DefaultConstants.ZERO_INTEGER);
    	sellerDynamic.setSellerWallet(BigDecimal.ZERO);
    	sellerDynamicMapper.insert(sellerDynamic);
    	
    	/*
    	 * 3
    	 */
    	SellerBalance sellerBalance = new SellerBalance();
    	sellerBalance.setBalanceId(balanceForAuth.getId());
    	sellerBalance.setSellerId(s.getId());
    	sellerBalanceMapper.insert(sellerBalance);
    	
    	/*
    	 * 4
    	 */
    	Balance balance = balanceForAuth;
    	balance.setUsed(DefaultConstants.BalanceEnum.USED.getBalanceEnum());
    	balanceMapper.update(balance);
    	
    	/*
    	 * 5
    	 */
    	SellerDetailResponse sellerDetailResponse = new SellerDetailResponse();
    	//商户品类名称
		ShopCategory sc = new ShopCategory();
		sc = shopCategoryMapper.get(seller.getSellerCategory());
		//商户所属菜市场名称
		Market m = marketMapper.get(seller.getBelongMarket().toString());
		
		SellerCategoryNameComponent scnc = new SellerCategoryNameComponent();
		BeanUtils.copyProperties(s, scnc);
		scnc.setCategoryName(sc.getCategoryName());
		scnc.setMarketName(m.getMarketName());
		
    	sellerDetailResponse.setSeller(scnc);
    	sellerDetailResponse.setSellerDynamic(sellerDynamic);
    	sellerDetailResponse.setBalance(balance);
    	
    	rabbitMQAsyncJobService.doSendRegisterOrLoginMessage(sellerDetailResponse);
    	return sellerDetailResponse;
    }

    @Override
    public Integer update(Seller seller) {
//        seller.setUpdateTime(new Date());
        return sellerMapper.update(seller);
    }

    @Override
    public Integer delete(String id) {
        return sellerMapper.delete(id);
    }
	
}

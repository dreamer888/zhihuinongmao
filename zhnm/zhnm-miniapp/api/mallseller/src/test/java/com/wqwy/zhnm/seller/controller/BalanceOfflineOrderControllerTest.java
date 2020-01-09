/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.wqwy.zhnm.base.component.component.BalanceOfflineOrderGoodsComponent;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.request.BalanceOfflineOrderWithGoodsRequest;
import com.wqwy.zhnm.base.component.response.UnionPayQRCodeGenerateResponseToClient;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.seller.constant.TestConsts;

/**
 * createTime: 2018-05-08 18:51:13
 * @author seven
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value=false)
@Transactional
public class BalanceOfflineOrderControllerTest {

	@Autowired
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
    	
    }
    
    @After
    public void tearDown() throws Exception {
    	
    }
    
    /**
     * findByPage
     */
    @Test
    public void testGetBalanceOfflineOrders() throws Exception {
        mockMvc.perform(get("/v1/balanceOfflineOrders?sellerId=1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findBalanceOfflineOrderDetail 
     */
    @Test
    public void testGetOneBalanceOfflineOrderDetail() throws Exception {
        mockMvc.perform(get("/v1/balanceOfflineOrders/1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void testAddBalanceOfflineOrders() throws Exception {
//    	0d32bc229af84724bd3a94f337975abd
//    	ab7107925a6647cfae4b1de208386a16
//    	af2512255d3a4dd283b1f67e23019171
//    	f6cb87b276214eb9a9899092db1b82d0
//    	b8f5fcc6e4e24b6a807905037e23911e

    	BalanceOfflineOrderWithGoodsRequest boowgr = new BalanceOfflineOrderWithGoodsRequest();
    	boowgr.setSellerId("74");
    	boowgr.setBalanceId("74");
//    	boowgr.setPayWay("3");
    	boowgr.setPayWay("2");
    	List<BalanceOfflineOrderGoodsComponent> boogcList = new ArrayList<BalanceOfflineOrderGoodsComponent>();
    	BalanceOfflineOrderGoodsComponent boogc1 = new BalanceOfflineOrderGoodsComponent();
    	boogc1.setGoodsId("5");
    	boogc1.setGoodsCount("0.131");
    	boogc1.setGoodsSort("1");
    	boogc1.setGoodsPrice("6");
    	BalanceOfflineOrderGoodsComponent boogc2 = new BalanceOfflineOrderGoodsComponent();
    	boogc2.setGoodsId("6");
    	boogc2.setGoodsCount("0.131");
    	boogc2.setGoodsSort("2");
    	boogc2.setGoodsPrice("7");
    	BalanceOfflineOrderGoodsComponent boogc3 = new BalanceOfflineOrderGoodsComponent();
    	boogc3.setGoodsId("7");
    	boogc3.setGoodsCount("0.131");
    	boogc3.setGoodsSort("3");
     	boogc3.setGoodsPrice("8");
    	BalanceOfflineOrderGoodsComponent boogc4 = new BalanceOfflineOrderGoodsComponent();
    	boogc4.setGoodsId("8");
    	boogc4.setGoodsCount("0.131");
    	boogc4.setGoodsSort("4");
    	boogc4.setGoodsPrice("9");
    	boogcList.add(boogc1);
    	boogcList.add(boogc2);
    	boogcList.add(boogc3);
    	boogcList.add(boogc4);
    	boowgr.setBoogcList(boogcList);
    	System.out.println(JsonUtils.AsJsonString(boowgr));
    	System.out.println(new UnionPayQRCodeGenerateResponseToClient());
        mockMvc.perform(
        		post("/v1/balanceOfflineOrders")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(JsonUtils.AsJsonString(boowgr)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findByPage
     */
    @Test
    public void testGetBalanceOfflineOrder() throws Exception {
        mockMvc.perform(get("/v1/getBalanceOfflineOrder/138").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    
}

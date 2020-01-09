/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

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

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.seller.constant.TestConsts;

/**
 * createTime: 2018-05-08 18:51:10
 * @author seven
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value=true)
@Transactional
public class SellerGoodsControllerTest {

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
    public void testGetSellerGoodss() throws Exception {
        mockMvc.perform(get("/v1/sellerGoods?sellerId=5")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * 
     * @Title: testAddSellerGoodss  
     * @Description: 新增  
     * @date 25 May 2018 9:50:53 AM  
     * @param @throws Exception  
     * @return void  
     * @throws
     */
    @Test
    public void testAddSellerGoodss() throws Exception {
    	SellerGoods sg = new SellerGoods();
    	sg.setBalanceHotkey("O");
    	sg.setCurrentStock(new BigDecimal(123.45).setScale(2, BigDecimal.ROUND_HALF_UP));
    	sg.setPrice(new BigDecimal(1.45).setScale(2, BigDecimal.ROUND_HALF_UP));
    	sg.setGoodsId(42);
    	sg.setSellerId(7);
    	sg.setStatus(1);
    	sg.setMarketId(42);
    	System.out.println(JsonUtils.AsJsonString(sg));
        mockMvc.perform(post("/v1/sellerGoods")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(JsonUtils.AsJsonString(sg)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * 
     * @Title: testAddSellerGoodss  
     * @Description: 更新  
     * @date 25 May 2018 9:51:06 AM  
     * @param @throws Exception  
     * @return void  
     * @throws
     */
    @Test
    public void testUpdateSellerGoodss() throws Exception {
    	SellerGoods sg = new SellerGoods();
    	sg.setBalanceHotkey("");
    	sg.setCurrentStock(new BigDecimal(13.00).setScale(2, BigDecimal.ROUND_HALF_UP));
    	sg.setPrice(new BigDecimal(13.00).setScale(2, BigDecimal.ROUND_HALF_UP));
    	sg.setSellerId(88);
    	sg.setStatus(1);
    	System.out.println(JsonUtils.AsJsonString(sg));
        mockMvc.perform(patch("/v1/sellerGoods/88")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(JsonUtils.AsJsonString(sg)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * 
     * @Title: testGetOneSellerGoodsDetail  
     * @Description: TODO  
     * @date 25 May 2018 2:28:28 PM  
     * @param @throws Exception  
     * @return void  
     * @throws
     */
    @Test
    public void testDeleteSellerGoodss() throws Exception {
        mockMvc.perform(delete("/v1/sellerGoods/47").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findSellerGoodsDetail 
     */
    @Test
    public void testGetOneSellerGoodsDetail() throws Exception {
        mockMvc.perform(get("/v1/sellerGoodss/1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
}

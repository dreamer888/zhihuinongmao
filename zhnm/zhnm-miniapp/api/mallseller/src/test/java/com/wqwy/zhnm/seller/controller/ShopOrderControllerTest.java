/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.seller.constant.TestConsts;

/**
 * createTime: 2018-05-15 14:11:17
 * @author seven
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value=true)
@Transactional
public class ShopOrderControllerTest {

	@Autowired
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
    	
    }
    
    @After
    public void tearDown() throws Exception {
    	
    }
    
    /**
     * 
     * @Title: testGetShopOrders  
     * @Description: get shopOrders with one seller  
     * @date 15 May 2018 2:47:59 PM  
     * @param @throws Exception  
     * @return void  
     * @throws
     */
    @Test
    public void testGetSellerShopOrders() throws Exception {
        mockMvc.perform(get("/v1/shopOrders/seller/5?pageNum=1&pageSize=20").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * 
     * @Title: testGetSellerAllOrders  
     * @Description: union all online&offline orders  
     * @date 28 May 2018 4:05:29 PM  
     * @param @throws Exception  
     * @return void  
     * @throws
     */
    @Test
    public void testGetSellerAllOrders() throws Exception {
        mockMvc.perform(get("/v1/orders/seller/5?searchString=&pageNum=1&pageSize=20").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findByPage
     */
    @Test
    public void testGetShopOrders() throws Exception {
        mockMvc.perform(get("/v1/shopOrders").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findShopOrderDetail 
     */
    @Test
    public void testGetOneShopOrderDetail() throws Exception {
        mockMvc.perform(get("/v1/shopOrders/1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void afterOrderPayedTest() throws Exception { //TestConsts.TokenValue
        mockMvc.perform(get("/v1/afterOrderPayedTest/1533109855949").header(DefaultConstants.TOKEN, "1cc157d5f5e94060b2e5097bc74681ee"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
        
    }
    
}

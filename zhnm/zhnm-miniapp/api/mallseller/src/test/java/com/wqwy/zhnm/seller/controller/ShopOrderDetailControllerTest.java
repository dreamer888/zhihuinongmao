/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.request.SellerPreemptRequest;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.seller.constant.TestConsts;

/**
 * createTime: 2018-05-15 11:51:43
 * @author seven
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value=false)
@Transactional
public class ShopOrderDetailControllerTest {

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
    public void testGetShopOrderDetails() throws Exception {
        mockMvc.perform(get("/v1/shopOrderDetails?orderId=1531206352566&sellerId=102").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)) 
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * 
     * @Title: testUpdateMultipleShopOrderDetailDetail  
     * @Description: 商户抢单  
     * @date 23 May 2018 3:19:29 PM  
     * @param @throws Exception  
     * @return void  
     * @throws
     */
    @Test
    public void testUpdateMultipleShopOrderDetail() throws Exception {
    	SellerPreemptRequest spr = new SellerPreemptRequest();
    	List<ShopOrderDetail> sodList = new ArrayList<ShopOrderDetail>();
    	ShopOrderDetail sod1 = new ShopOrderDetail();
    	sod1.setOrderDetailId("5c790d2a7b6740dfb5552773defbbe0d");
    	sod1.setSellerId(90);
    	ShopOrderDetail sod2 = new ShopOrderDetail();
    	sod2.setOrderDetailId("74d66d36bc3f486b8cfcbdfa6c0ad366");
    	sod2.setSellerId(90);
    	ShopOrderDetail sod3 = new ShopOrderDetail();
    	sod3.setOrderDetailId("c3beb24b589b4166ae6ce6b3e8e0bb13");
    	sod3.setSellerId(90);
    	ShopOrderDetail sod4 = new ShopOrderDetail();
    	sod4.setOrderDetailId("d04eedc59ba54ef9bcd490a168720b07");
    	sod4.setSellerId(90);
    	
    	sodList.add(sod1);
    	sodList.add(sod2);
    	sodList.add(sod3);
    	sodList.add(sod4);

    	spr.setShopOrderDetailList(sodList);
    	System.out.println("spr: " + JsonUtils.AsJsonString(spr));
        mockMvc.perform(patch("/v1/shopOrderDetails")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(JsonUtils.AsJsonString(spr)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * 
     * @Title: testUpdateMultipleShopOrderDetail  
     * @Description: 商户备货完成  
     * @date 23 May 2018 6:08:50 PM  
     * @param @throws Exception  
     * @return void  
     * @throws
     */
    @Test
    public void testUpdateMultipleShopOrderDetailForPrepared() throws Exception {
        mockMvc.perform(patch("/v1/shopOrderDetails/seller/5/shopOrder/1528787157998")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findShopOrderDetailDetail 
     */
    @Test
    public void testGetOneShopOrderDetailDetail() throws Exception {
        mockMvc.perform(get("/v1/shopOrderDetails/1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
}

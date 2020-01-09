/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.delivery.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.entity.DelivererBankAccount;
import com.wqwy.zhnm.delivery.constant.TestConsts;

/**
 * createTime: 2018-05-08 18:50:57
 * @author seven
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value=false)
@Transactional
public class DelivererBankAccountControllerTest {

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
    public void testGetDelivererBankAccounts() throws Exception {
        mockMvc.perform(get("/v1/delivererBankAccounts?delivererId=1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * 
     * @Title: testUpdateDelivererBankAccounts  
     * @Description: TODO  
     * @date 30 May 2018 4:08:31 PM  
     * @param @throws Exception  
     * @return void  
     * @throws
     */
    @Test
    public void testUpdateDelivererBankAccounts() throws Exception {
    	DelivererBankAccount sba = new DelivererBankAccount();
    	sba.setAccountName("saefwaf");
    	sba.setAccountPhone("10101111111");
        mockMvc.perform(patch("/v1/delivererBankAccounts/1")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(JsonUtils.AsJsonString(sba)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findDelivererBankAccountDetail 
     */
    @Test
    public void testGetOneDelivererBankAccountDetail() throws Exception {
        mockMvc.perform(get("/v1/delivererBankAccounts/1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}

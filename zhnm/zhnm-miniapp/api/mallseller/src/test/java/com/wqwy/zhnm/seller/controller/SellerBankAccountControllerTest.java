/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.entity.SellerBankAccount;
import com.wqwy.zhnm.base.entity.ValidateCode.OperationTypeEnum;
import com.wqwy.zhnm.base.entity.ValidateCode.UserTypeEnum;
import com.wqwy.zhnm.seller.constant.TestConsts;

/**
 * createTime: 2018-05-08 18:51:07
 * @author seven
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value=true)
@Transactional
public class SellerBankAccountControllerTest {

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
    public void testGetSellerBankAccounts() throws Exception {
        mockMvc.perform(get("/v1/sellerBankAccounts?sellerId=11").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * 
     * @Title: testGetSellerBankAccounts  
     * @Description: updateOneBankAccount  
     * @date 23 May 2018 11:31:16 AM  
     * @param @throws Exception  
     * @return void  
     * @throws
     */
    @Test
    public void testUpdateSellerBankAccounts() throws Exception {
    	SellerBankAccount sba = new SellerBankAccount();
    	sba.setOperationType(OperationTypeEnum.BINDING);
    	sba.setUserType(UserTypeEnum.SELLER);
    	sba.setAccountPhone("13768527030");
    	sba.setCode("100000");
        mockMvc.perform(patch("/v1/sellerBankAccounts/10")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(JsonUtils.AsJsonString(sba)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * 
     * @Title: testGetSellerBankAccounts  
     * @Description: updateOneBankAccount  
     * @date 23 May 2018 11:31:16 AM  
     * @param @throws Exception  
     * @return void  
     * @throws
     */
    @Test
    public void testAddSellerBankAccount() throws Exception {
    	SellerBankAccount sba = new SellerBankAccount();
    	sba.setOperationType(OperationTypeEnum.BINDING);
    	sba.setUserType(UserTypeEnum.SELLER);
    	sba.setAccountPhone("15820406561");
    	sba.setCode("430991");
        mockMvc.perform(post("/v1/sellerBankAccounts")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(JsonUtils.AsJsonString(sba)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    
    /**
     * findSellerBankAccountDetail 
     */
    @Test
    public void testGetOneSellerBankAccountDetail() throws Exception {
        mockMvc.perform(get("/v1/sellerBankAccounts/1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
}

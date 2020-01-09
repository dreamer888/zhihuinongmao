/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.delivery.controller;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.request.DelivererRegisterRequest;
import com.wqwy.zhnm.base.component.request.ForgotPasswordRequest;
import com.wqwy.zhnm.base.component.request.LoginRequest;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.entity.Deliverer;
import com.wqwy.zhnm.base.entity.ValidateCode;
import com.wqwy.zhnm.delivery.constant.TestConsts;

/**
 * createTime: 2018-05-08 18:50:56
 * @author seven
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value=false)
@Transactional
public class DelivererControllerTest {

	@Autowired
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
    	
    }
    
    @After
    public void tearDown() throws Exception {
    	
    }
    
    @Test
    public void deliverersLogin() throws Exception {
    	LoginRequest lc = new LoginRequest();
    	lc.setAccount("17777777777");
    	lc.setPassword("1231231123");
        mockMvc.perform(post("/v1/login")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(asJsonString(lc)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void deliverersRegister() throws Exception {
    	DelivererRegisterRequest drr = new DelivererRegisterRequest();
    	drr.setAccount("17777777777");
    	drr.setPassword("1231231123");
    	drr.setValidateCode("486161");
//    	lc.setAccount("s");
//    	lc.setPassword("s");
        mockMvc.perform(post("/v1/register")
//        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(asJsonString(drr)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void forgotPassword() throws Exception {
    	ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest();
    	forgotPasswordRequest.setPhone("17777777777");
    	forgotPasswordRequest.setOperationType(ValidateCode.OperationTypeEnum.FORGOT_PASSWORD);
    	forgotPasswordRequest.setUserType(ValidateCode.UserTypeEnum.SELLER);
    	forgotPasswordRequest.setCode("486161");
    	forgotPasswordRequest.setPassword("123456789");
    	System.out.println(JsonUtils.AsJsonString(forgotPasswordRequest));
        mockMvc.perform(patch("/v1/deliverers/password")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(asJsonString(forgotPasswordRequest)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void testPatchDeliverers() throws Exception {
    	Deliverer d = new Deliverer();
    	d.setAge(54);
    	d.setCnname("wrefeesfsef");
        mockMvc.perform(patch("/v1/deliverers/3")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(asJsonString(d)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findByPage
     */
    @Test
    public void testGetDeliverers() throws Exception {
        mockMvc.perform(get("/v1/deliverers").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findDelivererDetail 
     */
    @Test
    public void testGetOneDelivererDetail() throws Exception {
        mockMvc.perform(get("/v1/deliverers/1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
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

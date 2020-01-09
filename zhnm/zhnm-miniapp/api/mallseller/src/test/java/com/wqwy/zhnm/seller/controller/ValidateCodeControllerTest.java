/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

import com.wqwy.zhnm.base.entity.ValidateCode;
import com.wqwy.zhnm.base.service.ValidateCodeService;
import com.wqwy.zhnm.seller.constant.TestConsts;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.constant.PhoneMessageConstants;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-25 13:13:34
 * @author seven
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value=false)
@Transactional
public class ValidateCodeControllerTest {

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
    public void testGetValidateCodes() throws Exception {
        mockMvc.perform(get("/v1/validateCodes").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * post
     */
    @Test
    public void testPostValidateCodes() throws Exception {
    	ValidateCode validateCode = new ValidateCode();
    	validateCode.setOperationType(ValidateCode.OperationTypeEnum.FORGOT_PASSWORD);
    	validateCode.setUserType(ValidateCode.UserTypeEnum.SELLER);
    	validateCode.setPhone("17682317297");
    	System.out.println(JsonUtils.AsJsonString(validateCode));
        mockMvc.perform(post("/v1/validateCodes")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(JsonUtils.AsJsonString(validateCode)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * patch
     */
    @Test
    public void testPatchValidateCodes() throws Exception {
    	ValidateCode validateCode = new ValidateCode();
        mockMvc.perform(patch("/v1/validateCodes")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(JsonUtils.AsJsonString(validateCode)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findValidateCodeDetail 
     */
    @Test
    public void testGetOneValidateCodeDetail() throws Exception {
        mockMvc.perform(get("/v1/validateCodes/1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
}

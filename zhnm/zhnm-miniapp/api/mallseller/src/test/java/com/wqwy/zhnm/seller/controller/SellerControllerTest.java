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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.request.ForgotPasswordRequest;
import com.wqwy.zhnm.base.component.request.LoginRequest;
import com.wqwy.zhnm.base.component.request.SellerLoginRequest;
import com.wqwy.zhnm.base.component.request.SellerRegisterRequest;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.entity.Seller;
import com.wqwy.zhnm.base.entity.ValidateCode;
import com.wqwy.zhnm.seller.constant.TestConsts;

/**
 * createTime: 2018-05-08 18:51:02
 * @author seven
 * @version
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(value=true)
@Transactional
public class SellerControllerTest {

	@Autowired
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
    	
    }
    
    @After
    public void tearDown() throws Exception {
    	
    }
    
    @Test
    public void sellersLogin() throws Exception {
    	SellerLoginRequest lc = new SellerLoginRequest();
    	lc.setRole(0);
    	//lc.setAndroidIMEI("123456");
    	lc.setAccount("13135955673");
    	lc.setPassword("40bd001563085fc35165329ea1ff5c5ecbdbbeef");
        mockMvc.perform(post("/v1/login")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(asJsonString(lc)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void balanceLoginByQRCode() throws Exception {
    	SellerLoginRequest lc = new SellerLoginRequest();
//    	lc.setAccount("s");
//    	lc.setPassword("s");
    	lc.setSellerId(100);
    	lc.setBalanceId(21);
        mockMvc.perform(post("/v1/loginByQRCode")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(asJsonString(lc)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void testUpdateSellers() throws Exception {
    	Seller seller = new Seller();
//    	seller.setId(48);
    	seller.setPassword("1234567");
        mockMvc.perform(patch("/v1/sellers/48")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(asJsonString(seller)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findByPage
     */
    @Test
    public void testGetSellers() throws Exception {
        mockMvc.perform(get("/v1/sellers").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    /**
     * findSellerDetail 
     */
    @Test
    public void testGetOneSellerDetail() throws Exception {
        mockMvc.perform(get("/v1/sellers/1").header(DefaultConstants.TOKEN, TestConsts.TokenValue))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void addOneSeller() throws Exception {
    	SellerRegisterRequest sellerRegisterRequest = new SellerRegisterRequest();
    	sellerRegisterRequest.setAccount("17682317297");
    	sellerRegisterRequest.setPassword("123456");
//    	sellerRegisterRequest.setBalanceId(46);
    	sellerRegisterRequest.setBalanceImei("IMEI000019");
    	sellerRegisterRequest.setValidateCode("290296");
    	sellerRegisterRequest.setName("sefwefwef");
    	sellerRegisterRequest.setBelongMarket(11);
    	sellerRegisterRequest.setSellerCategory("bcaf1e20a5ef4a1c8e0c0710ffd9b41b");
        mockMvc.perform(post("/v1/register")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(asJsonString(sellerRegisterRequest)))
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
        mockMvc.perform(patch("/v1/sellers/password")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(asJsonString(forgotPasswordRequest)))
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

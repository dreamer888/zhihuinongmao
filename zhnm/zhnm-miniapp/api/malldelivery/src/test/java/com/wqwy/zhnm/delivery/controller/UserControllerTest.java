package com.wqwy.zhnm.delivery.controller;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.delivery.constant.TestConsts;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    @Test
    public void getUsers() throws Exception {
    	System.setProperty("system.properties.test", "test");
        mockMvc.perform(MockMvcRequestBuilders.get("/v2/sysUsers")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

}
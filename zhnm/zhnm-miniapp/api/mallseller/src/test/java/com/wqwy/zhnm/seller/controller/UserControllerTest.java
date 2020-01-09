package com.wqwy.zhnm.seller.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.utils.wxpay.WXPayUtil;
import com.wqwy.zhnm.seller.constant.TestConsts;

@RunWith(SpringRunner.class)
@SpringBootTest
//@TestPropertySource("classpath:test.properties")
@ActiveProfiles("test")
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
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/sysUsers")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    
    /////////////////other test
    @Test
    public void wechatNotifyTest() throws Exception {
    	Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("return_code", "SUCCESS");
		resultMap.put("return_msg", "OK");
        mockMvc.perform(MockMvcRequestBuilders.post("/wxpay/notify")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(WXPayUtil.mapToXml(resultMap))).andDo(print());
    }
    
    @Test
    public void sendMessageToSellerAndBalanceTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/afterOrderCreateTest/1500647836067")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    
    ////////////////redis test
    @Autowired
    private RedisTemplate<String, String> template;

    // inject the template as ListOperations
    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

//    public void addLink(String userId, URL url) {
//      listOps.leftPush(userId, url.toExternalForm());
//    }
    @Test
    public void redisTest() throws Exception {
    	listOps.leftPush("key_1", "value_1_1");
    	listOps.leftPush("key_2", "value_2");
    	listOps.leftPush("key_3", "value_3");
    	listOps.leftPush("key_4", "value_4");
    	listOps.leftPush("key_5", "value_5");
    	listOps.leftPush("key_6", "value_6");
    	listOps.leftPush("key_7", "value_123");
    	Set<String> keySet = template.keys("key_*");
    	Long l1 = listOps.size("key_dount_have");
    	Long l2 = listOps.size("key_1");
    	System.out.println(l1);
    	System.out.println(l2);
    	String s1 = listOps.leftPop("key_1");
//    	String s2 = listOps.leftPop("key_1");
//    	String s3 = listOps.leftPop("key_1");
//    	String s4 = listOps.leftPop("key_1");
//    	String s5 = listOps.leftPop("key_1");
//    	String s6 = listOps.leftPop("key_1");
//    	String s7 = listOps.leftPop("key_1");
//    	String s8 = listOps.leftPop("key_1");
//    	System.out.println(s1);System.out.println(s2);System.out.println(s3);System.out.println(s4);
//    	System.out.println(s5);System.out.println(s6);System.out.println(s7);System.out.println(s8);
    	List<String> keyList = listOps.range("key_2", 0, -1);
    	
    	keyList.forEach(System.out::println);
    	/**
    	 * 商户抢单列表数据
    	 * 1.key='seller_{sellerId}' value={orderDetail}
    	 * 2.多个key的value中的orderDetail组成list 每个orderDetail有超时时间
    	 * 3.取出数据时判断超时时间 超时则删除数据
    	 * 4.定时取出数据判断超时时间 超时则删除数据
    	 * 
    	 * 单线程情况考虑如何判断超时(分布式暂时不考虑)
    	 * f(x) = {
    	 *     e = list.rightPop
    	 *     if (e == null)
    	 *         return;
    	 *     if (e.expireLimitTime <= now())// 到期即为超时
    	 *         f(x);
    	 *     else
    	 *         list.rightPush(e); return;
    	 * }
    	 * 1.取出数据前调用f(x)先check数据 => 再 return listOps.range(key, 0, -1)
    	 * 2.定时check数据调用f(x) 后return
    	 */
    }
    
    @Test
    public void configMQTest() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/v1/mq")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

}
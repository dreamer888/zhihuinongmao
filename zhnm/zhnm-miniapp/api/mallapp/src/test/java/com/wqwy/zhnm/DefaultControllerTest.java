package com.wqwy.zhnm;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import com.wqwy.zhnm.mallapp.constant.TestConsts;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    @Test
    public void getIndex() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
        mockMvc.perform(MockMvcRequestBuilders.get("/")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void getGoods() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
        mockMvc.perform(MockMvcRequestBuilders.get("/test/goods/info?goods_id=36&marketId=40")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void getGoodslist() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
        mockMvc.perform(MockMvcRequestBuilders.get("/test/app/goodslist?category_id=b2193f10f6464315a1d84a9ccda133a5&super_id=0&gtui=0&gsales=2&gprice=0&goods_name=%&currentPage=1&location=115.852662%2C28.743668&marketId=40")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void getCartList() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
        mockMvc.perform(MockMvcRequestBuilders.get("/test/cart/list?location=&marketId=&user_id=6c87f9cb21874218ac4d1651c567fce2")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void getOrderlist() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
        mockMvc.perform(MockMvcRequestBuilders.get("/test/orderlist?status=2&user_id=6c87f9cb21874218ac4d1651c567fce2")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void getAddOrder() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
//    	int num = 100;
//    	for (int i = 0; i < num; i++) {
    		long startTime = System.currentTimeMillis();
    		mockMvc.perform(MockMvcRequestBuilders.get("/test/addorder?coupon_id=0&goods_id=36&goods_count=1&cart_id=92fc40ba1b864a72ba12452d3afbc5b8&address_id=2dd8eda022ad43148f9c5391ee4f7294&pay_way=2&attribute_detail_id=d59dd43f928f44a79b203b3ef7f00b13&remark=&delivery_time_slice=&marketId=40")
            		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                    .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    		long endTime = System.currentTimeMillis();
    		long time = endTime-startTime;
    		System.out.println("-->"+time);
//    	}
    	
//    	for (int i = 0; i < num; i++) {
//    		long startTime = System.currentTimeMillis();
//    		mockMvc.perform(MockMvcRequestBuilders.get("/test/addorder?coupon_id=73e76c5240ab4cffaf55494105a66f0e&goods_id=36&goods_count=2&cart_id=84e7432b6f3e4889a7e6193be367e639&address_id=2dd8eda022ad43148f9c5391ee4f7294&pay_way=2&attribute_detail_id=0c23981514ad4015b7e31d05345bba99&remark=&delivery_time_slice=&marketId=40")
//            		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
//                    .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
//    		long endTime = System.currentTimeMillis();
//    		long time = endTime-startTime;
//    		System.out.println("-->"+time);
//    	}
//    	
//    	for (int i = 0; i < num; i++) {
//    		long startTime = System.currentTimeMillis();
//    		mockMvc.perform(MockMvcRequestBuilders.get("/test/addorder?coupon_id=73e76c5240ab4cffaf55494105a66f0e&goods_id=36&goods_count=2&cart_id=84e7432b6f3e4889a7e6193be367e639&address_id=2dd8eda022ad43148f9c5391ee4f7294&pay_way=2&attribute_detail_id=0c23981514ad4015b7e31d05345bba99&remark=&delivery_time_slice=&marketId=40")
//            		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
//                    .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
//    		long endTime = System.currentTimeMillis();
//    		long time = endTime-startTime;
//    		System.out.println("-->"+time);
//    	}
    	
        
    }
    
    @Test
    public void deliveryDate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/deliveryDate")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void addCart() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
        mockMvc.perform(MockMvcRequestBuilders.get("/test/cart/add?goods_id=36&goods_count=1&attribute_detail_id=d59dd43f928f44a79b203b3ef7f00b13&marketId=40")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void addComment() throws Exception {
    	String str = "{\n" + 
    			"    \"order_id\":\"1531478606257\",\n" + 
    			"    \"order\":\"[{\"order_detail_id\":\"3140c8e6da6449708fb4f74548a2fa6e\",\"goods_name\":\"红薯叶\",\"goods_pic\":\"https://goodssort.oss-cn-shenzhen.aliyuncs.com/9f412a9d-c7c2-433f-a861-8336d1fb8d0b\",\"goods_price\":1.8,\"goods_total\":5.4,\"goods_id\":52,\"pay_total\":5.4,\"goods_count\":3,\"sort\":0,\"order_id\":\"1531478606257\",\"attribute_detail_name\":\"300g\",\"status\":5,\"comment_title\":\"5\",\"img\":[],\"comment_pic\":\"\"},{\"order_detail_id\":\"574a3e132df945c7aa482e8bab821ad1\",\"goods_name\":\"卷心菜\",\"goods_pic\":\"https://goodssort.oss-cn-shenzhen.aliyuncs.com/c58ed89b-53a6-4687-ae11-9bf2e6dd079d\",\"goods_price\":1.7,\"goods_total\":3.4,\"goods_id\":98,\"pay_total\":3.4,\"goods_count\":2,\"sort\":1,\"order_id\":\"1531478606257\",\"attribute_detail_name\":\"500g\",\"status\":5,\"comment_title\":\"5\",\"img\":[],\"comment_pic\":\"\"},{\"order_detail_id\":\"09142b39200b47e9becf38887dd8b9bd\",\"goods_name\":\"玉米\",\"goods_pic\":\"https://goodssort.oss-cn-shenzhen.aliyuncs.com/acddfc11-8d8e-4a1b-bed1-59431de11d7f\",\"goods_price\":100,\"goods_total\":100,\"goods_id\":147,\"pay_total\":100,\"goods_count\":1,\"sort\":2,\"order_id\":\"1531478606257\",\"attribute_detail_name\":\"150g\",\"status\":5,\"comment_title\":\"5\",\"img\":[],\"comment_pic\":\"\"}]\"\n" + 
    			"}";
        mockMvc.perform(post("/test/comment/add")
        		.content(str))
        .andDo(print())
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void addAddress() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
        mockMvc.perform(MockMvcRequestBuilders.get("/test/address/edit?addr_realname=lisi&addr_phone=15820406561&addr_city=广东省 深圳市 宝安区&is_default=1&address_id=66096e138922460ea593ff1e52de9979&address=宝源南路农贸市场007")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void getOrderTotal() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
        mockMvc.perform(MockMvcRequestBuilders.get("/test/order_total?coupon_id=a1eaa2b41db9435ead78850422baf0ae&goods_id=36&goods_count=5&attribute_detail_id=0c23981514ad4015b7e31d05345bba99&marketId=40")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void getOrderPay() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
        mockMvc.perform(MockMvcRequestBuilders.get("/test/getorder?order_id=1532070028776&pay_way=2")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void getUserInfo() throws Exception {
//    	https://www.wqwy2014.com/mallapp/goods/info?goods_id=38
        mockMvc.perform(MockMvcRequestBuilders.get("/test/user/info")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    
    @Test
    public void getUsercouponInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/user/info")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void refundHandle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/test/refundHandle")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    
    @Test
    public void usercouponList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/usercoupon/list?user_id=db9450f0e5eb482badc31721fcbdbf61")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    @Test
    public void handleCoupon() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test/handleCoupon")
        		.header(DefaultConstants.TOKEN, TestConsts.TokenValue)
                .accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
    
    String[] str=new String[]{"a","b"};
    public static void main(String[] args) {
    	BigDecimal currentStock = new BigDecimal(100000);
    	BigDecimal stock = currentStock.divide(new BigDecimal(150), 0, BigDecimal.ROUND_FLOOR); //当前库存 b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString()
    	
    	System.out.println("-->"+stock);
    	
//		String[] times = new String[] { "10:00-11:00", "10:30-11:30", "11:00-12:00", "11:30-12:30", "12:00-13:00",
//				                        "12:30-13:30", "13:00-14:00", "13:30-14:30", "14:00-15:00", "14:30-15:30",
//				                        "15:00-16:00", "15:30-16:30", "16:00-17:00", "16:30-17:30", "17:00-18:00",
//				                        "17:30-18:30", "18:00-19:00"};
//		JSONArray arr = new JSONArray();
//        for(int i=0;i<4;i++) {
//        	String day = getDate(i);
//        	System.out.println("day-->"+day);
//        	JSONObject json = new JSONObject();
//        	json.put("type", i);
//        	json.put("day", day);
//        	json.put("times", times);
//        }
	}
    
    public static String getDate(int day){  
    	Format f = new SimpleDateFormat("MM月dd日");
        Date today = new Date();
        
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, day);// 天数追加
 
        Date tomorrow = c.getTime();
        String dayName = "今天";
        switch (day) {
		case 0:
			dayName = "今天";
			break;
		case 1:
			dayName = "明天";
			break;
		case 2:
			dayName = "后天";
			break;
		case 3:
			dayName = "大后天";
			break;
		default:
			break;
		}
        //System.out.println("当前是:" + dayName+f.format(tomorrow));
        return dayName+f.format(tomorrow);
    }
    
}
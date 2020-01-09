package com.wqwy.zhnm.seller;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rabbitmq.client.ConnectionFactory;
import com.wqwy.zhnm.base.component.constant.ConstantsFileProperties;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.constant.WechatApiConstants;
import com.wqwy.zhnm.base.component.response.WechatQRCodeGenerateResponseToClient;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.component.utils.wxpay.WXPayUtil;

public class DefaultTest2 {
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy[' ']['T'][H:mm[:ss[.S]]][X]");

	public LocalDate getRobustLocalDate(String value) {
	    try {
	    	LocalDate ld = LocalDate.parse(value, formatter);
	    	System.out.println(ld);
	        return ld;
	    } catch (DateTimeParseException e) {
	        return null;
	    }
	}

	
	@Test
	public void t1() {
		getRobustLocalDate("03/07/2016");               // 2016-07-03
	    getRobustLocalDate("3/7/2016");                 // 2016-07-03
	    getRobustLocalDate("3/7/2016 00:00:00");        // 2016-07-03
	    getRobustLocalDate("3/7/2016 00:00:00.0+0100"); // 2016-07-03
	    getRobustLocalDate("3/7/2016T00:00:00.0+0100"); // 2016-07-03
	}
	
	@Test
	public void t2() {
		List<String> l1 = Arrays.asList("A", "B", "C", "D", "E", "F");
//		Set<String> s1 = new HashSet<String>(l1);
		
		//
//		HashMap<String, Integer> m1 = new HashMap<String, Integer>(){{
//			put("A", 0);put("B", 0);put("C", 0);put("D", 0);put("E", 0);put("F", 0);put("G", 0);put("H", 0);put("I", 0);put("J", 0);put("K", 0);put("L", 0);
//			put("M", 0);put("N", 0);put("O", 0);
//		}};
//		Set<String> s2 = new HashSet<String>(m1.keySet());
		//
//		s2.removeAll(s1);
		Map<String, Integer> m2 = new HashMap<String, Integer>(DefaultConstants.BalanceSellerGoodsHotkeyMap);
		new HashSet<String>(l1).stream().forEach(s -> {
			if (m2.get(s)!=null)
				m2.put(s, m2.get(s)+1);
		});
		
		List<Result> lr = new ArrayList<Result>();
		m2.forEach((k,v) -> {
			Result r = new Result();
			r.setName(k);
			r.setStatus(v);
			lr.add(r);
		});
		
		System.out.println(JsonUtils.AsJsonString(lr));
	}
	
	class Result {
		private String name;
		private Integer status;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
	}
	
	@Test
	public void t3() throws IllegalAccessException, InvocationTargetException {
		HashMap<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值");// 商品简单描述，该字段请按照规范传递，具体请见参数规定
        data.put("out_trade_no", "");// 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。详见商户订单号
//        data.put("device_info", "");// 自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
//        data.put("fee_type", "CNY");// 符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型
//        data.put("total_fee", "");//  	订单总金额，单位为分，详见支付金额
//        data.put("spbill_create_ip", "123.12.12.123");// APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
//        data.put("notify_url", "http://test.letiantian.me/wxpay/notify");// 异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
//        data.put("trade_type", "NATIVE");// JSAPI 公众号支付 NATIVE 扫码支付 APP APP支付 说明详见参数规定
//        data.put("product_id", "12");// trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
        // data.put("time_expire", "20170112104120");
        String s = JsonUtils.AsJsonString(data);
        MapToObjectTest bean = (MapToObjectTest) JsonUtils.AsJsonObject(s, DefaultTest2.MapToObjectTest.class);
//        BeanUtils.populate(bean, data);
        System.out.println(bean);
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class MapToObjectTest {
		private String body;
		
		@JsonProperty("out_trade_no")
		private String outTradeNo;
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public String getOutTradeNo() {
			return outTradeNo;
		}
		public void setOutTradeNo(String outTradeNo) {
			this.outTradeNo = outTradeNo;
		}
		@Override
		public String toString() {
			return "MapToObjectTest [body=" + body + ", outTradeNo=" + outTradeNo + "]";
		}
		
	}

	@Test
    public void t4(){
        @SuppressWarnings("rawtypes")
        HashMap map = new HashMap();
        map.put("username","admin");
        map.put("password","secret");
        map.put("age","52");
        
        User bean = new User();
        try{
              BeanUtils.populate(bean,map);
        }catch(Exception e){
              e.printStackTrace();
        }
        
        System.out.println("Username: "+bean.getUsername());
        System.out.println("Password: "+bean.getPassword());
        System.out.println("Age: "+bean.getAge());
    }
	public class User {
	    private String username;
	    private String password;
	    private String age;
	    
	    public String getUsername(){
	        return username;
	    }
	    
	    public void setUsername(String username){
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }
		
	    public void setPassword(String password){
	        this.password = password;
	    }

	    public String getAge() {
	        return age;
	    }
		
	    public void setAge(String age){
	        this.age = age;
	    }
	}
	
	@Test
	public void t5() {
		WechatQRCodeGenerateResponseToClient w = new WechatQRCodeGenerateResponseToClient();
		w.setOrderId(123);
		w.setAppId("123123124");
		w.setNonceStr("egeiugheirugh");
		System.out.println(JsonUtils.AsJsonString(w));
		System.out.println(JsonUtils.AsJsonStringWithoutGetAndSetAndCreator2(w));
	}
	
	@Test
	public void t6() throws Exception {
		String str = "<xml><appid><![CDATA[wx993fa013a962f5de]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1503478341]]></mch_id><nonce_str><![CDATA[b899c915a42842e3814b4ad0e2d94f51]]></nonce_str><openid><![CDATA[oJWYoxFxwGWjR9mEiaqtujhymbOY]]></openid><out_trade_no><![CDATA[SZ201806051000000030721564]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[60B1369FF8F134A0D46586891FBFE826F6C8944789753A4EFB5EBADD0F2F0C05]]></sign><time_end><![CDATA[20180605190125]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[NATIVE]]></trade_type><transaction_id><![CDATA[4200000142201806059629700856]]></transaction_id></xml>";
		boolean isValidSign = WXPayUtil.isSignatureValid(str, WechatApiConstants.SIGN_KEY);
		System.out.println(isValidSign);
	}
	
//	@Test
//	public void t7() {
//		ConnectionFactory cf = new ConnectionFactory();
//		cf.set
//	}
}

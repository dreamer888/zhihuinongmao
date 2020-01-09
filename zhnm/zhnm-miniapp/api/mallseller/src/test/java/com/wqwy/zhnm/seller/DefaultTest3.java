package com.wqwy.zhnm.seller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;

import com.wqwy.zhnm.base.component.component.LimitOrderComponent;
import com.wqwy.zhnm.base.component.utils.DateUtils;
import com.wqwy.zhnm.base.component.utils.JsonUtils;

public class DefaultTest3 {
	
	@Test
	public void t1() {
		System.out.println(DateUtils.GetDeliveryTimeSlice());
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 19);
		System.out.println(DateUtils.GetDeliveryTimeSlice(c));
	}
	
	@Test
	public void t2() {
		String s = "{\"orderId\":\"1528530284629\",\"addtime\":\"2018-06-09 15:44:44\",\"totalPrice\":0,\"orderTotal\":0.01,\"couponPrice\":0.00,\"couponId\":\"0\",\"freightPrice\":0.00,\"payWay\":\"2\",\"userId\":\"70b36c0305b74240b603ba41bdbac779\",\"addrRealname\":\"das大叔大婶\",\"addrPhone\":\"13310872356\",\"addrCity\":\"广东省 深圳市 宝安区\",\"address\":\"福永地铁zh站\",\"ipAddress\":\"内网IP 内网IP\",\"userIp\":\"192.168.1.103\",\"status\":37,\"expressTitle\":null,\"expressName\":null,\"expressNum\":null,\"transactionId\":null,\"marketId\":null,\"delivererId\":null,\"deliveryCost\":null,\"cancelTime\":null,\"deliveryFinishTime\":null,\"finishTime\":null,\"location\":\"113.814250,22.670430\",\"deliveryTimeSlice\":null,\"sellerId\":null,\"sellerSeizeTime\":null,\"shopOrderDetailList\":null,\"shopOrderDetailDTOList\":[{\"orderDetailId\":\"9bdb5212e91943688074c839d13d0cf5\",\"goodsId\":6,\"goodsPic\":\"https://goodssort.oss-cn-shenzhen.aliyuncs.com/11ffb282-6179-430a-8603-15204dce431d\",\"goodsName\":\"洋葱\",\"goodsPrice\":0.01,\"goodsCount\":1.00,\"goodsTotal\":0.01,\"attributeDetailId\":null,\"attributeDetailName\":\"\",\"payTotal\":0.01,\"orderId\":\"1528530284629\",\"sort\":0,\"status\":0,\"sellerId\":null,\"sellerSeizeTime\":null,\"sellerPrepareTime\":null,\"delivererReceiveTime\":null,\"preSellerId\":16,\"marketId\":5,\"preSellerGoodsStatus\":0,\"sellerGoods\":null}],\"isToday\":null,\"currentGoodsTotalPrice\":null,\"delivererName\":null,\"delivererPhone\":null,\"errorMessage\":null,\"shopUser\":null,\"smcSet\":null,\"ssodcSet\":null,\"searchString\":null}";
		LimitOrderComponent loc = (LimitOrderComponent) JsonUtils.AsJsonObject(s, LimitOrderComponent.class);
		System.out.println(loc.getAddtime());
		System.out.println(loc.getOrderId());
		System.out.println(loc.getStatus());
		System.out.println(StringEscapeUtils.unescapeJava(s));
	}
	
	@Test
	public void t3() {
		LimitOrderComponent loc = new LimitOrderComponent();
		loc.setAddtime(new Date());
		loc.setOrderId("5616516516516");
		loc.setStatus(5);
		System.out.println(JsonUtils.AsJsonString(loc));
	}
	
}

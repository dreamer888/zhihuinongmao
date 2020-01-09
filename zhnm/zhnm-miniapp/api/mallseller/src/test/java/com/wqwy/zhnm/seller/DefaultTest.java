package com.wqwy.zhnm.seller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.OrderedJSONObject;
import org.junit.Test;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.constant.DefaultConstants.WechatResponseEnum;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderDTO;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderGoodsDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailDTO;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.component.utils.MD5Utils;
import com.wqwy.zhnm.base.component.utils.UnionPayQRCodeUtils;
import com.wqwy.zhnm.base.component.utils.wxpay.WXPayUtil;
import com.wqwy.zhnm.base.entity.ShopOrder;

public class DefaultTest {

	@Test
	public void t1() throws JSONException {
		BalanceOfflineOrderDTO b = new BalanceOfflineOrderDTO();
		b.setAddtime(new Date());
		b.setBalanceId(12);
		b.setId(232);
		b.setOrderNumber("");
		List<BalanceOfflineOrderGoodsDTO> boogList = new ArrayList<BalanceOfflineOrderGoodsDTO>();
		BalanceOfflineOrderGoodsDTO boog1 = new BalanceOfflineOrderGoodsDTO();
		boog1.setGoodsId(13);
		boog1.setOrderNumber("");
		boog1.setSort(9);
		BalanceOfflineOrderGoodsDTO boog2 = new BalanceOfflineOrderGoodsDTO();
		boog2.setGoodsId(2);
		boog2.setGoodsPrice(null);
		boog2.setGoodsName("");
		boog2.setPayTotal(new BigDecimal(123.23).setScale(2, BigDecimal.ROUND_HALF_UP));
		boogList.add(boog1);
		boogList.add(boog2);
		b.setBoogList(boogList);
		System.out.println(UnionPayQRCodeUtils.GetCanSignString(JsonUtils.AsJsonString(b)));
//		//对象去空字符串转string
//		String s = JsonUtils.AsJsonString(b);
//		System.out.println(s);
//		
//		//字符串转jsonobject
//		JSONObject jObject = new JSONObject(s);
//		//取出jsonobject的key放入List<String>
//		JSONArray ja = jObject.names();
//		List<String> jaList = new ArrayList<String>();
//		for (int i=0; i<ja.length(); i++) {
//			jaList.add(ja.getString(i));
//		}
//		Collections.sort(jaList);
//		
//		StringBuilder sb = new StringBuilder();
//		for (int i=0; i<jaList.size(); i++) {
//			sb.append(jaList.get(i) + "=" + jObject.getString(jaList.get(i)));
//			if (i!=jaList.size()-1)
//				sb.append("&");
//		}
//		System.out.println(sb.toString());
//		System.out.println();
//		System.out.println();
//		System.out.println();
	}
	
	@Test
	public void t2() throws Exception {
		String parameters="{\"walletOption\":\"SINGLE\",\"billNo\":\"31940000201700002\",\"billDate\":\"2017-06-26\",\"requestTimestamp\":\"2017-06-26 17:28:02\",\"instMid\":\"QRPAYDEFAULT\",\"msgSrc\":\"WWW.TEST.COM\",\"totalAmount\":\"1\",\"goods\":[{\"body\":\"微信二维码测试\",\"price\":\"1\",\"goodsName\":\"微信二维码测试\",\"goodsId\":\"1\",\"quantity\":\"1\",\"goodsCategory\":\"TEST\"}],\"msgType\":\"bills.getQRCode\",\"mid\":\"898340149000005\",\"tid\":\"88880001\"}";
		String resultString = f1(parameters);
		String shouldResultString="billDate=2017-06-26&billNo=31940000201700002&goods=[{\"body\":\"微信二维码测试\",\"price\":\"1\",\"goodsName\":\"微信二维码测试\",\"goodsId\":\"1\",\"quantity\":\"1\",\"goodsCategory\":\"TEST\"}]&instMid=QRPAYDEFAULT&mid=898340149000005&msgSrc=WWW.TEST.COM&msgType=bills.getQRCode&requestTimestamp=2017-06-26 17:28:02&tid=88880001&totalAmount=1&walletOption=SINGLE";
		System.out.println(resultString);
		System.out.println(shouldResultString);
		System.out.println(resultString.equals(shouldResultString));
	}
	
//	public String f2(String s) throws JSONException {
//		JSONObject jObject = new JSONObject(s);
//		return jObject.toString();
//	}
	
	public String f1(String s) throws JSONException {
		//字符串转jsonobject
		OrderedJSONObject jObject = new OrderedJSONObject(s);
		//取出jsonobject的key放入List<String>
		JSONArray ja = jObject.names();
		List<String> jaList = new ArrayList<String>();
		for (int i=0; i<ja.length(); i++) {
			jaList.add(ja.getString(i));
		}
		Collections.sort(jaList);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<jaList.size(); i++) {
			String str = jObject.getString(jaList.get(i));
			str = StringEscapeUtils.unescapeJava(str);
			sb.append(jaList.get(i) + "=" + str);
			if (i!=jaList.size()-1)
				sb.append("&");
		}
		return sb.toString();
	}
	
	@Test
	public void t3() throws Exception {
		String str = "\\u5fae\\u4fe1\\u4e8c\\u7ef4\\u7801\\u6d4b\\u8bd5";
		System.out.println(str);
//		微信二维码测试
		System.out.println(new String("\u5fae\u4fe1\u4e8c\u7ef4\u7801\u6d4b\u8bd5".getBytes("utf-8"), "utf-8"));
		
		String utf8Text = "\u0048\u0065\u006C\u006C\u006F World";
		String utf8Text2 = "Hello World";
		System.out.println(utf8Text.equals(utf8Text2));
		byte[] bytes = utf8Text.getBytes(StandardCharsets.UTF_8);
		String text = new String(bytes, StandardCharsets.UTF_8);
	}
	
	@Test
	public void t4() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String yourString = "billDate=2017-06-26&billNo=31940000201700002&goods=[{\"body\":\"微信二维码测试\",\"price\":\"1\",\"goodsName\":\"微信二维码测试\",\"goodsId\":\"1\",\"quantity\":\"1\",\"goodsCategory\":\"TEST\"}]&instMid=QRPAYDEFAULT&mid=898340149000005&msgSrc=WWW.TEST.COM&msgType=bills.getQRCode&requestTimestamp=2017-06-26 17:28:02&tid=88880001&totalAmount=1&walletOption=SINGLEfcAmtnx7MwismjWNhNKdHC44mNXtnEQeJkRrhKJwyrW2ysRR";
		
//		byte[] bytesOfMessage = yourString.getBytes("UTF-8");
//
//		MessageDigest md = MessageDigest.getInstance("MD5");
//		byte[] thedigest = md.digest(bytesOfMessage);
		System.out.println(MD5Utils.getMD5String(yourString).toUpperCase());
	}
	
	@Test
	public void t5() {
		ShopOrderDetailDTO sod1 = new ShopOrderDetailDTO();
		sod1.setGoodsId(1);
		sod1.setSellerId(1);
		ShopOrderDetailDTO sod2 = new ShopOrderDetailDTO();
		sod2.setGoodsId(2);
		sod2.setSellerId(3);
		ShopOrderDetailDTO sod3 = new ShopOrderDetailDTO();
		sod3.setGoodsId(13);
		sod3.setSellerId(1);
		ShopOrderDetailDTO sod4 = new ShopOrderDetailDTO();
		sod4.setGoodsId(15);
		sod4.setSellerId(1);
		ShopOrderDetailDTO sod5 = new ShopOrderDetailDTO();
		sod5.setGoodsId(17);
		sod5.setSellerId(1);
		ShopOrderDetailDTO sod6 = new ShopOrderDetailDTO();
		sod6.setGoodsId(19);
		sod6.setSellerId(1);
		ShopOrderDetailDTO sod7 = new ShopOrderDetailDTO();
		sod7.setGoodsId(19);
		sod7.setSellerId(1);
		ShopOrderDetailDTO sod8 = new ShopOrderDetailDTO();
		sod8.setGoodsId(19);
		sod8.setSellerId(1);
		ShopOrderDetailDTO sod9 = new ShopOrderDetailDTO();
		sod9.setGoodsId(1);
		sod9.setSellerId(2);
		ShopOrderDetailDTO sod10 = new ShopOrderDetailDTO();
		sod10.setGoodsId(1);
		sod10.setSellerId(3);
		List<ShopOrderDetailDTO> shopOrderDetailDTOList = new ArrayList<ShopOrderDetailDTO>();
		shopOrderDetailDTOList.add(sod1);
		shopOrderDetailDTOList.add(sod2);
		shopOrderDetailDTOList.add(sod3);
		shopOrderDetailDTOList.add(sod4);
		shopOrderDetailDTOList.add(sod5);
		shopOrderDetailDTOList.add(sod6);
		shopOrderDetailDTOList.add(sod7);
		shopOrderDetailDTOList.add(sod8);
		shopOrderDetailDTOList.add(sod9);
		shopOrderDetailDTOList.add(sod10);
		Map<Integer, List<ShopOrderDetailDTO>> result =
				shopOrderDetailDTOList.stream().collect(Collectors.groupingBy(ShopOrderDetailDTO::getSellerId));
		System.out.println(result);
	}
	
	@Test
	public void t6() {
		Queue<Integer> fifo = new CircularFifoQueue<Integer>(3);
	    fifo.add(1);
	    fifo.add(2);
	    fifo.add(3);
	    fifo.add(4);
//	    fifo.poll();
	    System.out.println(fifo.peek());
//	    fifo.poll();
	    System.out.println(fifo);

	    // Observe the result: 
	    // [2, 3]
	}
	
	@Test
	public void v7() {
		DecimalFormat df = new DecimalFormat("###.####");
		BigDecimal bd1 = new BigDecimal(12.35600000).setScale(5, BigDecimal.ROUND_HALF_UP);
		System.out.println(bd1);
		System.out.println(df.format(bd1));
	}
	
	@Test
	public void t8() {
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("return_code", "SUCCESS");
		resultMap.put("return_msg", "OK");
		String xmlStr = null;
		try {
			xmlStr = WXPayUtil.mapToXml(resultMap);
		} catch (Exception e) {
			throw new BusinessException();
		}
		System.out.println(xmlStr);
		String xmlStr2 = DefaultConstants.WechatResponseXmlMap.get(WechatResponseEnum.SUCCESS);
		System.out.println(xmlStr.equals(xmlStr2));
	}
	
	
	public static void main(String[] args) {
	    ShopOrder order = new ShopOrder();
	    order.setAddtime("1");
	    ShopOrder order1 = new ShopOrder();
	    order1.setAddtime("4");
	    ShopOrder order2 = new ShopOrder();
	    order2.setAddtime("3");
	    List<ShopOrder> list = new ArrayList<>();
	    list.add(order);
	    list.add(order1);
	    list.add(order2);
		Collections.sort(list, Comparator.comparing(ShopOrder::getAddtime).reversed());
	    System.out.println(list.toString());
	}
}

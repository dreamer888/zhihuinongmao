package com.yq.controller.order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.change.controller.base.BaseController;
import org.change.util.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.weixin.util.Package;
import com.wqwy.zhnm.base.component.dto.GoodsDTO;
import com.wqwy.zhnm.base.component.dto.MarketDTO;
import com.wqwy.zhnm.base.component.request.GeoGetLocationByAddressStringRequest;
import com.wqwy.zhnm.base.component.utils.GeoDeUtils;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.service.ShopOrderDetailService;
import com.wqwy.zhnm.base.service.ShopOrderService;
import com.wqwy.zhnm.base.service.base.AboutOrderService;
import com.yq.controller.pay.ReturnController;
import com.yq.service.address.AddressManager;
import com.yq.service.attribute.Attribute_detailManager;
import com.yq.service.cart.CartManager;
import com.yq.service.coupon.CouponManager;
import com.yq.service.freight.FreightManager;
import com.yq.service.goods.GoodsManager;
import com.yq.service.order.OrderDetailManager;
import com.yq.service.order.OrderManager;
import com.yq.service.user.ShopUserManager;
import com.yq.service.usercoupon.UsercouponManager;
import com.yq.util.DatetimeUtil;
import com.yq.util.GetIp;
import com.yq.util.StringUtil;

/**
 * 订单自动批量下单
 */
@Controller
@RequestMapping(value = "/automate")
public class AutomateController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(AutomateController.class);
	@Resource(name = "shopUserService")
	private ShopUserManager shopUserService;
	@Resource(name = "orderService")
	private OrderManager orderService;

	@Resource(name = "orderDetailService")
	private OrderDetailManager orderDetailService;
	@Resource(name = "goodsService")
	private GoodsManager goodsService;
	@Resource(name = "cartService")
	private CartManager cartService;
	@Resource(name = "couponService")
	private CouponManager couponService;

	@Resource(name = "addressService")
	private AddressManager addressService;
	@Resource(name = "usercouponService")
	private UsercouponManager usercouponService;
	@Resource(name = "freightService")
	private FreightManager freightService;

	@Resource(name = "attribute_detailService")
	private Attribute_detailManager attribute_detailService;
	
	@Autowired
	private ShopOrderService shopOrderService;
	
	@Autowired
	private ShopOrderDetailService shopOrderDetailService;
	
	@Autowired
	private AboutOrderService aboutOrder;
	
	public ReturnController returnController = new ReturnController();
	private Gson gson = new Gson();
	
 
	/**
	 * 保存
	 * 
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/addorder", produces = "application/json;charset=UTF-8")
	public String addorder() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// PageData pay = new PageData();
		//Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		String ip = GetIp.getIp(this.getRequest());
		String ipAddr = GetIp.getAddresses("ip=" + ip, "UTF-8");
		PageData pd = new PageData();
		pd = this.getPageData();
		int result = 0;
		String message = "";
		String cart_id = pd.getString("cart_id");
		String goods_id = pd.getString("goods_id");
		String goods_count = pd.getString("goods_count");
		String attribute_detail_id = pd.getString("attribute_detail_id");
		String pay_way = pd.getString("pay_way");
		String remark = pd.getString("remark");
		String delivery_time_slice = pd.getString("delivery_time_slice");
		String order_id = StringUtil.getId();
		String goods_name = "";
		BigDecimal order_total = new BigDecimal(0);// 订单总价
		BigDecimal total_price = new BigDecimal(0);// 订单原价
		List<PageData> detaillist = new LinkedList<PageData>();
		if (StringUtils.isNotEmpty(goods_id)) {
			if (goods_id.contains(",")) {// 多个商品
				String[] idsArray = goods_id.split(",");
				String[] countsArray = goods_count.split(",");
				String[] detail_idArray = attribute_detail_id.split(",");
				for (int i = 0; i < idsArray.length; i++) {
					PageData goods = new PageData();
					goods.put("goods_id", idsArray[i]);
					// 某商品的信息
					PageData info = goodsService.findById(goods);
					BigDecimal goods_price = new BigDecimal(0);
//					int count = Integer.parseInt(countsArray[i]);
					BigDecimal count = new BigDecimal(countsArray[i]);
					PageData detail = null;
					PageData detailpd = new PageData();
					if(!detail_idArray[i].equals("1")){//如果属性id不等于1，则商品有属性，根据属性获取属性详情
						detailpd.put("attribute_detail_id", detail_idArray[i]);
						detail = attribute_detailService.findById(detailpd);
					}
					
					PageData pda = new PageData();
					pda.put("goods_id", goods.getString("goods_id"));
					pda.put("market_id", pd.getString("marketId"));
					List<PageData> goodsList = goodsService.listSpecialMarketAll(pda);
					pda = goodsList.get(0);
				    BigDecimal avgPrice = (BigDecimal) pda.get("avg_price");  //商品平均价
				    
					if(detail==null){//没有属性，则取一口价
						//goods_price = (BigDecimal) info.get("goods_price");
						goods_price = avgPrice;
						goods.put("attribute_detail_name", "");
					}else{
						String attr_value = detail.getString("attribute_detail_name").replace("g", "");
						BigDecimal weight = new BigDecimal(0); //规格重量
						weight = new BigDecimal(attr_value).divide(new BigDecimal(1000)); //单位KG
						goods_price = avgPrice.multiply(weight);  //规格价按平均价计算
						
						//goods_price = (BigDecimal)detail.get("attribute_detail_price");	
						goods.put("attribute_detail_name", detail.getString("attribute_detail_name"));
					}
					
					goods.put("goods_count", count);
					goods.put("goods_price", goods_price);
					goods.put("goods_name", info.getString("goods_name"));
					if (i == 0) {
						goods_name = info.getString("goods_name") + " 等多件";
					}
					String goods_pic = info.getString("goods_pic");
					if (StringUtils.isNotEmpty(goods_pic)) {
						if (goods_pic.contains(",")) {
							goods_pic = goods_pic.split(",")[0];
						}
					}
					BigDecimal goods_total = goods_price.multiply(count);
					goods.put("goods_pic", goods_pic);
					goods.put("order_id", order_id);
					goods.put("goods_total", goods_total);
					goods.put("status", 0);
					goods.put("sort", i);
					goods.put("order_detail_id", this.get32UUID());
					goods.put("avg_price", avgPrice);
					detaillist.add(goods);
					order_total = order_total.add(goods_total);
				}
			} else {// 单个商品
				PageData goods = new PageData();
				goods.put("goods_id", goods_id);
				PageData info = goodsService.findById(goods);
				BigDecimal goods_price = new BigDecimal("0");
				PageData detail = null;
				PageData detailpd = new PageData();
				if(!attribute_detail_id.equals("1")){//如果属性id不等于1，则商品有属性，根据属性获取属性详情
					detailpd.put("attribute_detail_id", attribute_detail_id);
					detail = attribute_detailService.findById(detailpd);
				}
				PageData pda = new PageData();
				pda.put("goods_id", goods.getString("goods_id"));
				pda.put("market_id", pd.getString("marketId"));
				List<PageData> goodsList = goodsService.listSpecialMarketAll(pda);
				pda = goodsList.get(0);
			    BigDecimal avgPrice = (BigDecimal) pda.get("avg_price");  //商品平均价
			    
				if(detail==null){//没有属性，则取一口价
					//goods_price = (BigDecimal) info.get("goods_price");
					goods_price = avgPrice;
					goods.put("attribute_detail_name", "");
				}else{
					String attr_value = detail.getString("attribute_detail_name").replace("g", "");
					BigDecimal weight = new BigDecimal(0); //规格重量
					weight = new BigDecimal(attr_value).divide(new BigDecimal(1000)); //单位KG
					goods_price = avgPrice.multiply(weight);  //规格价按平均价计算
					
					//goods_price = (BigDecimal)detail.get("attribute_detail_price");	
					goods.put("attribute_detail_name", detail.getString("attribute_detail_name"));
				}
				
				int count = Integer.parseInt(goods_count);
				goods.put("goods_count", count);
				goods.put("goods_price", goods_price);
				goods.put("goods_name", info.get("goods_name"));
				goods_name = info.getString("goods_name");
				String goods_pic = info.getString("goods_pic");
				if (StringUtils.isNotEmpty(goods_pic)) {
					if (goods_pic.contains(",")) {
						goods_pic = goods_pic.split(",")[0];
					}
				}
				BigDecimal goods_total = goods_price.multiply(new BigDecimal(count));
				goods.put("goods_pic", goods_pic);
				goods.put("order_id", order_id);
				goods.put("goods_total", goods_total);
				goods.put("status", 0);
				goods.put("sort", 0);
				goods.put("order_detail_id", this.get32UUID());
				goods.put("avg_price", avgPrice);
				detaillist.add(goods);
				order_total = goods_total;
			}
			
			// 收货地址
			PageData address = addressService.findById(pd);
            
//			if(null==address) {
//				 //收货位置不在任何菜市场范围之内 
//				 map.put("result", 2);
//			     map.put("message", "收货位置不在任何菜市场范围之内！");
//			     return gson.toJson(map);
//			}
//			
//			MarketDTO marketDTO = isMarket(address);
//			if(marketDTO.isFlag()) {
//				 //收货位置不在任何菜市场范围之内 
//				 map.put("result", 2);
//			     map.put("message", "收货位置不在任何菜市场范围之内！");
//			     return gson.toJson(map);
//			}
//			
//			if(isStock(marketDTO.getMarketId(), detaillist)) {
//				 //已售订单中的商品在最近的市场已售罄
//				 map.put("result", 2);
//			     map.put("message", "已售订单中的商品在最近的市场已售罄！");
//			     return gson.toJson(map);
//			}
			
			//因高德访问次数上限，临时设置菜市场、经纬度
			MarketDTO marketDTO = new MarketDTO();
			marketDTO.setMarketId(5);
			marketDTO.setLocation("118.374150,31.409224");
			
			// 获取运费
			PageData freight = freightService.findById(pd);
			BigDecimal freight_price = (BigDecimal) freight.get("freight_price");
			BigDecimal freight_free_price = (BigDecimal) freight.get("freight_free_price");
			// 运费不为0
			if (freight_price.compareTo(new BigDecimal("0")) != 0) {
				// 免邮金额小于等于订单金额，运费为0
				if (freight_free_price.compareTo(order_total) <= 0) {
					freight_price = new BigDecimal("0");
				}
			}
			order_total = order_total.add(freight_price);
			total_price = order_total;
			// 优惠券信息
			BigDecimal coupon_price = new BigDecimal(0);
			String coupon_id = pd.getString("coupon_id");
			if (!coupon_id.equals("0")) {
				PageData coupon = couponService.findById(pd);
				coupon_price = (BigDecimal) coupon.get("coupon_price");
				// 优惠券与订单金额比较
				if (order_total.compareTo(coupon_price) <= 0) {
					order_total = new BigDecimal("0");
				} else {
					order_total = order_total.subtract(coupon_price);
				}
			}
			List<PageData> list = new LinkedList<PageData>();
			BigDecimal no_last_pay_total = new BigDecimal("0");
			for (int i = 0; i < detaillist.size(); i++) {
				PageData goods = detaillist.get(i);
				BigDecimal pay_total = new BigDecimal("0");
				if (detaillist.size() == 1) {
					goods.put("pay_total", order_total);
				} else {
					if (i < detaillist.size() - 1) {
						BigDecimal rate = order_total.divide(total_price, 10, RoundingMode.HALF_UP);
						BigDecimal goods_total = (BigDecimal) goods.get("goods_total");
						pay_total = goods_total.multiply(rate.setScale(2, RoundingMode.HALF_UP));
						goods.put("pay_total", pay_total);
						// 计算优惠之后的价格总和
						no_last_pay_total = no_last_pay_total.add(pay_total);
					} else {
						goods.put("pay_total", order_total.subtract(no_last_pay_total));
					}
				}
				list.add(goods);
			}

			PageData order = new PageData();
			order.put("order_id", order_id);
			order.put("addtime", DatetimeUtil.getDatetime());
			order.put("order_total", order_total);
			order.put("total_price", total_price);
			order.put("coupon_price", coupon_price);
			order.put("coupon_id", coupon_id);
			order.put("freight_price", freight_price);
			order.put("pay_way", pay_way);
			//order.put("user_id", shopUser.get("user_id")); 
			order.put("user_id", "automateceshiuser"); 
			order.put("addr_realname", address.getString("addr_realname"));
			order.put("addr_phone", address.getString("addr_phone"));
			order.put("addr_city", address.getString("addr_city"));
			order.put("address", address.getString("address"));
			order.put("ip_address", ipAddr);
			order.put("user_ip", ip);
			order.put("status", 0);
			order.put("cart_id", cart_id);
			order.put("detaillist", list);
			order.put("record_id", this.get32UUID());
			order.put("record_note", "下单时间");
			order.put("remark", remark);
			order.put("delivery_time_slice", delivery_time_slice);
			order.put("market_id", marketDTO.getMarketId());
			order.put("location", marketDTO.getLocation());
			
			/**
			 * 用户创建订单
			 */
			result = orderService.save(order);
			switch (result) {
			case 0:
				message = "购买商品异常！";
				break;
			case 1:
				//pd.put("user_id", shopUser.get("user_id"));
				//int cart_count = cartService.count(pd);
				//map.put("cart_count", cart_count);
				// 预支付的参数
				// 商户id
				map.put("order_id", order_id);
				// 消费金额
				map.put("order_total", order_total);
				// 商品名称
				map.put("goods_name", goods_name);
				PageData return_pay = new PageData();
				if (pay_way.equals("2")) {// 微信
					// 微信用户的openid
					//map.put("openid", shopUser.get("openid"));
					logger.info("传递支付信息到微信--> " + gson.toJson(map));
					// 微信预支付返回的信息
					return_pay = Package.getPackage(this.getRequest().getSession(), map);
				} else if (pay_way.equals("3")) {// 商城币

				}
				map.put("return_pay", return_pay);
				//HttpSession session = StringUtil.session(this.getRequest());
				//shopUser.put("cart_count", cart_count);
				//session.setAttribute("shopUser", shopUser);
				//StringUtil.add_session(session);
				message = "提交成功！";
				break;
//			case 2:
//				message = "已售订单中的商品在最近的市场已售罄！";
//				break;
//			case 3:
//				result = 2;
//				message = "收货位置不在任何菜市场范围之内！";
//				break;
			default:
				message = "购买商品异常！";
				break;
			}
			returnController.updateorder(order_id, orderService);
			aboutOrder.doAfterUserPayedOnlineOrder(order_id);
			map.put("result", result);
			map.put("message", message);

		} else {
			map.put("result", 0);
			map.put("message", "购买商品异常！");
		}
		
		
		return gson.toJson(map);
	}
    
	//验证收货地址是否在制定范围内
	private MarketDTO isMarket(PageData address) {
		MarketDTO marketDTO = new MarketDTO();
		marketDTO.setFlag(false);
		GeoGetLocationByAddressStringRequest gglbasRequest = new GeoGetLocationByAddressStringRequest();
		gglbasRequest.setAddress(address.getString("addr_city").trim() + address.getString("address").trim());
		String location = null;
		try {
			location = GeoDeUtils.getLocationByAddressByGeoMap(gglbasRequest).getLocation();
		} catch (Exception e1) {
			marketDTO.setFlag(true); //收货位置不在任何菜市场范围之内
		}
		ShopOrder shopOrder = new ShopOrder();
		shopOrder.setLocation(location);
		Integer marketId = shopOrderService.getOneNearMarketByShopOrder(shopOrder);
		if(null==marketId) {
			marketDTO.setFlag(true); //收货位置不在任何菜市场范围之内
		}
		
		marketDTO.setLocation(location);
		marketDTO.setMarketId(marketId);
		return marketDTO;
	}
	
	//验证库存
	private boolean isStock(Integer marketId,List<PageData> detailList) {
		boolean flag = false;
		if(null==detailList) {
			flag = true;
		}
		for(PageData detail : detailList) {
			try {
				GoodsDTO goodsInfo = new GoodsDTO();
				goodsInfo.setGoodsId(Integer.parseInt(detail.getString("goods_id")));
				goodsInfo.setMarketId(marketId);
				GoodsDTO goodsDTO = goodsService.getCurrentStock(goodsInfo);
				BigDecimal currentStock = goodsDTO.getCurrentStock();  //库存重量
				
				String attr_value = detail.getString("attribute_detail_name").replace("g", "");
				BigDecimal weight = new BigDecimal(0); //规格重量
				weight = new BigDecimal(attr_value).divide(new BigDecimal(1000)); //单位KG
				BigDecimal goodsCount = new BigDecimal(detail.get("goods_count").toString());
				BigDecimal saleStock = weight.multiply(goodsCount); //下单重量
				if(saleStock.compareTo(currentStock)>0) {  //库存不足时提示
					flag = true;
					break;
				}
			} catch (Exception e) {
				flag = true;
			}
		}
		return flag;
	}
	
    //Integer delivererId = delivererMarketService.getOneDelivererByShopOrder(so.getMarketId()).getDelivererId();
	public static void main(String[] args) {
		PageData detail = new PageData();
		System.out.println(detail.equals(""));
	}

}

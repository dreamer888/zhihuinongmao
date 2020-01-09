package com.yq.controller.order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.weixin.util.Package;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.GoodsDTO;
import com.wqwy.zhnm.base.component.dto.MarketDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderDetailDTO;
import com.wqwy.zhnm.base.component.request.GeoGetLocationByAddressStringRequest;
import com.wqwy.zhnm.base.component.utils.DateUtils;
import com.wqwy.zhnm.base.component.utils.GeoDeUtils;
import com.wqwy.zhnm.base.entity.ShopOrder;
import com.wqwy.zhnm.base.entity.ShopOrderDetail;
import com.wqwy.zhnm.base.service.DelivererMarketService;
import com.wqwy.zhnm.base.service.ShopOrderDetailService;
import com.wqwy.zhnm.base.service.ShopOrderService;
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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 说明：订单 创建人：壹仟科技 qq 357788906 创建时间：2017-01-05
 */
@Controller
public class OrderController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
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
	
	public ReturnController returnController = new ReturnController();
	private Gson gson = new Gson();
	
	@ResponseBody
	@RequestMapping(value = "/toorder" , produces = "application/json;charset=UTF-8")
	public String toorder(HttpServletRequest request) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		pd.put("user_id", shopUser.get("user_id"));
		// String cart_id = pd.getString("cart_id");
		String goods_id = pd.getString("goods_id");
		String goods_count = pd.getString("goods_count");
		String attribute_detail_id = pd.getString("attribute_detail_id");
		int ishavenum = 1 ;//1，库存充足；0，库存不足
		if(StringUtils.isEmpty(goods_count)){
			goods_count = "1";
		}
		List<PageData> list = new LinkedList<PageData>();
		BigDecimal order_total = new BigDecimal(0);// 订单总价
		if (StringUtils.isNotEmpty(goods_id)) {
			if (goods_id.contains(",")) {// 多个商品
				String[] idsArray = goods_id.split(",");
				String[] countsArray = goods_count.split(",");
				String[] detail_idArray = attribute_detail_id.split(",");

				for (int i = 0; i < idsArray.length; i++) {
					PageData goods = new PageData();
					goods.put("goods_id", idsArray[i]);
					PageData info = goodsService.findById(goods);
					BigDecimal goods_price = new BigDecimal(0);
					int count = Integer.parseInt(countsArray[i]);
					int detail_num = 0;
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
						detail_num = (int) info.get("goods_num");
					}else{
						//goods_price = (BigDecimal)detail.get("attribute_detail_price");	
						
						String attr_value = detail.getString("attribute_detail_name").replace("g", "");
						BigDecimal weight = new BigDecimal(0); //规格重量
						weight = new BigDecimal(attr_value).divide(new BigDecimal(1000)); //单位KG
						goods_price = avgPrice.multiply(weight);  //规格价按平均价计算
						
						goods.put("attribute_detail_name", detail.getString("attribute_detail_name"));
						detail_num = (int) detail.get("attribute_detail_num");
					}
					if(detail_num < count){
						ishavenum = 0;
						break;
					}
					goods.put("goods_count", count);
					//金额保留小数点后两位
					goods_price=goods_price.setScale(2, BigDecimal.ROUND_HALF_UP); 
					goods.put("goods_price", goods_price);
					goods.put("goods_name", info.get("goods_name"));

					String goods_pic = info.getString("goods_pic");
					if (StringUtils.isNotEmpty(goods_pic)) {
						if (goods_pic.contains(",")) {
							goods_pic = goods_pic.split(",")[0];
						}
					}
					goods.put("goods_pic", goods_pic);
					list.add(goods);
					// order_total = BigDecimalUtil.add(order_total,
					// BigDecimalUtil.mul(goods_price, count));
					order_total = order_total.add(goods_price.multiply(new BigDecimal(count)));
					
				}
			} else {// 单个商品
				PageData goods = new PageData();
				goods.put("goods_id", goods_id);
				PageData info = goodsService.findById(goods);
				BigDecimal goods_price = new BigDecimal(0);
				int count = Integer.parseInt(goods_count);
				int detail_num = 0;
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
					detail_num = (int) info.get("goods_num");
				}else{
					
					String attr_value = detail.getString("attribute_detail_name").replace("g", "");
					BigDecimal weight = new BigDecimal(0); //规格重量
					weight = new BigDecimal(attr_value).divide(new BigDecimal(1000)); //单位KG
					goods_price = avgPrice.multiply(weight);  //规格价按平均价计算
					
					//goods_price = (BigDecimal)detail.get("attribute_detail_price");	
					goods.put("attribute_detail_name", detail.getString("attribute_detail_name"));
					detail_num = (int) detail.get("attribute_detail_num");
				}
				
				if(detail_num < count){
					ishavenum = 0;
				}
				goods.put("goods_count", count);
				//金额保留小数点后两位
				goods_price=goods_price.setScale(2, BigDecimal.ROUND_HALF_UP); 
				goods.put("goods_price", goods_price);	
				goods.put("goods_name", info.get("goods_name"));

				String goods_pic = info.getString("goods_pic");
				if (StringUtils.isNotEmpty(goods_pic)) {
					if (goods_pic.contains(",")) {
						goods_pic = goods_pic.split(",")[0];
					}
				}
				goods.put("goods_pic", goods_pic);
				list.add(goods);
				order_total = goods_price.multiply(new BigDecimal(count));
			}

		}
		if(ishavenum==1){
			// 查询收货地址
			String address_id = pd.getString("address_id");
			PageData address = null;
			if (StringUtils.isNotEmpty(address_id)) {
				address = addressService.findById(pd);
			} else {
				//address = addressService.finddefault(pd);  // 无需返回默认地址
			}
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
			// 获取可用优惠券
			pd.put("order_total", order_total);
			pd.put("nowtime", DatetimeUtil.getDate());
			pd.put("max", 1);
			List<PageData> couponlist = usercouponService.listAll(pd);
			PageData coupon = new PageData();
			// 订单总额减去优惠券价格
			if (couponlist.size() > 0) {
				coupon = couponlist.get(0);
				order_total = order_total.subtract((BigDecimal) coupon.get("coupon_price"));
			}
			map.put("pd", pd);
			map.put("list", list);
			map.put("address", address);
			map.put("freight_price", freight_price);
			map.put("couponlist", couponlist);
			map.put("coupon", coupon);
			map.put("coupon_count", couponlist.size());
			map.put("order_total", order_total);
		}
		map.put("ishavenum",ishavenum);
		return gson.toJson(map);

	}

	/**
	 * 根据优惠券等 计算总价
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = { "/order_total", "/", "/test/order_total" }, produces = "application/json;charset=UTF-8")
	public String order_total() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		String goods_id = pd.getString("goods_id");
		String goods_count = pd.getString("goods_count");
		String attribute_detail_id = pd.getString("attribute_detail_id");
		BigDecimal order_total = new BigDecimal(0);// 订单总价
		if (StringUtils.isNotEmpty(goods_id)) {
			if (goods_id.contains(",")) {// 多个商品
				String[] idsArray = goods_id.split(",");
				String[] countsArray = goods_count.split(",");
				String[] detail_idArray = attribute_detail_id.split(",");
				for (int i = 0; i < idsArray.length; i++) {
					PageData goods = new PageData();
					goods.put("goods_id", idsArray[i]);
					PageData info = goodsService.findById(goods);
					BigDecimal goods_price = new BigDecimal(0);
					int count = Integer.parseInt(countsArray[i]);
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
					}else{
						goods_price = (BigDecimal)detail.get("attribute_detail_price");	
//						goods.put("attribute_detail_name", detail.getString("attribute_detail_name"));
						
						String attr_value = detail.getString("attribute_detail_name").replace("g", "");
						BigDecimal weight = new BigDecimal(0); //规格重量
						weight = new BigDecimal(attr_value).divide(new BigDecimal(1000)); //单位KG
						goods_price = avgPrice.multiply(weight);  //规格价按平均价计算
						
					}
					//金额保留小数点后两位
					goods_price=goods_price.setScale(2, BigDecimal.ROUND_HALF_UP); 
					order_total = order_total.add(goods_price.multiply(new BigDecimal(count)));
				}
			} else {// 单个商品
				PageData goods = new PageData();
				goods.put("goods_id", goods_id);
				PageData info = goodsService.findById(goods);
				
				BigDecimal goods_price = new BigDecimal(0);
				int count = Integer.parseInt(goods_count);
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
				}else{
					//goods_price = (BigDecimal)detail.get("attribute_detail_price");	
					String attr_value = detail.getString("attribute_detail_name").replace("g", "");
					BigDecimal weight = new BigDecimal(0); //规格重量
					weight = new BigDecimal(attr_value).divide(new BigDecimal(1000)); //单位KG
					goods_price = avgPrice.multiply(weight);  //规格价按平均价计算
				}
				//金额保留小数点后两位
				goods_price=goods_price.setScale(2, BigDecimal.ROUND_HALF_UP); 
				order_total = goods_price.multiply(new BigDecimal(count));
			}

		}
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
		// 根据coupon_id查询优惠券金额
		PageData coupon = new PageData();
		if (pd.getString("coupon_id") != null) {
			if (!pd.getString("coupon_id").equals("0")) {
				coupon = couponService.findById(pd);
				BigDecimal coupon_price = (BigDecimal) coupon.get("coupon_price");
				order_total = order_total.subtract(coupon_price);
			}else{
				coupon.put("coupon_id", "0");
				coupon.put("coupon_name", "不使用优惠");
				
			}
		}
		map.put("coupon", coupon);
		map.put("order_total", order_total);
		return gson.toJson(map);
	}
 
	/**
	 * 保存
	 * 
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = { "/addorder", "/", "/test/addorder" }, produces = "application/json;charset=UTF-8")
	public String addorder() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// PageData pay = new PageData();
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
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
					//金额保留小数点后两位
					goods_price=goods_price.setScale(2, BigDecimal.ROUND_HALF_UP); 
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
				//金额保留小数点后两位
				goods_price=goods_price.setScale(2, BigDecimal.ROUND_HALF_UP); 
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
            
			if(null==address) {
				 //收货位置不在任何菜市场范围之内 
				 map.put("result", 2);
			     map.put("message", "收货位置不在任何菜市场范围之内！");
			     return gson.toJson(map);
			}
			
			MarketDTO marketDTO = isMarket(address);
			if(marketDTO.isFlag()) {
				 //收货位置不在任何菜市场范围之内 
				 map.put("result", 2);
			     map.put("message", "收货位置不在任何菜市场范围之内！");
			     return gson.toJson(map);
			}
			
			if(isStock(marketDTO.getMarketId(), detaillist)) {
				 //已售订单中的商品在最近的市场已售罄
				 map.put("result", 2);
			     map.put("message", "已售订单中的商品在最近的市场已售罄！");
			     return gson.toJson(map);
			}
			
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
			order.put("user_id", shopUser.get("user_id")); 
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
				pd.put("user_id", shopUser.get("user_id"));
				int cart_count = cartService.count(pd);
				map.put("cart_count", cart_count);
				// 预支付的参数
				// 商户id
				map.put("order_id", order_id);
				
				//金额保留小数点后两位
				order_total=order_total.setScale(2, BigDecimal.ROUND_HALF_UP);  
				 
				// 消费金额
				map.put("order_total", order_total);
				// 商品名称
				map.put("goods_name", goods_name);
				PageData return_pay = new PageData();
				if (pay_way.equals("2")) {// 微信
					// 微信用户的openid
					map.put("openid", shopUser.get("openid"));
					logger.info("传递支付信息到微信--> " + gson.toJson(map));
					// 微信预支付返回的信息
					return_pay = Package.getPackage(this.getRequest().getSession(), map);
				} else if (pay_way.equals("3")) {// 商城币

				}
				map.put("return_pay", return_pay);
				HttpSession session = StringUtil.session(this.getRequest());
				shopUser.put("cart_count", cart_count);
				session.setAttribute("shopUser", shopUser);
				StringUtil.add_session(session);
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
	
	/**
	 * 获取订单
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = { "/getorder", "/", "/test/getorder" }, produces = "application/json;charset=UTF-8")
	public String getorder(HttpSession session) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// PageData pay = new PageData();
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		PageData pd = new PageData();
		pd = this.getPageData();
		int result = 0;
		String message = "";
		String pay_way = pd.getString("pay_way");
		String goods_name = "";
		PageData order = orderService.findById(pd);
		if (order != null) {
			
			//当前支付的商品
			ShopOrderDetail shopOrderDetail = new ShopOrderDetail();
			shopOrderDetail.setOrderId(order.getString("order_id"));
			List<ShopOrderDetail> shopOrderDetailList = shopOrderDetailService.findList(shopOrderDetail);
			List<Integer> shopOrderDetailGoodsIdList = shopOrderDetailList.stream().map(ShopOrderDetail::getGoodsId).collect(Collectors.toList());
			
			//查询商品库存
			ShopOrderDetailDTO shopOrderDetailDTO = new ShopOrderDetailDTO();
			shopOrderDetailDTO.setMarketId(Integer.parseInt(order.get("market_id").toString()));
			shopOrderDetailDTO.setOrderId(order.getString("order_id"));
			shopOrderDetailDTO.setPreSellerGoodsStatus(DefaultConstants.SellerGoodsEnum.ON_SALE.getSellerGoodsEnum());
			List<ShopOrderDetailDTO> shopOrderDetailDTOList = shopOrderDetailService.findListByCondition(shopOrderDetailDTO);
			List<Integer> shopOrderDetailDTOGoodsIdList = shopOrderDetailDTOList.stream().map(ShopOrderDetailDTO::getGoodsId).collect(Collectors.toList());
			
			if (!shopOrderDetailDTOGoodsIdList.containsAll(shopOrderDetailGoodsIdList)){
				message = "已售订单中的商品在最近的市场已售罄！";
				map.put("result", result);
				map.put("message", message);
				gson.toJson(map);
			}
			
			String order_id = pd.getString("order_id");
			BigDecimal order_total = (BigDecimal) order.get("order_total");// 订单总价
			pd.put("order_id", order_id);
			List<PageData> list = orderDetailService.listAll(pd);
			if (list.size() > 1) {
				goods_name = list.get(0).getString("goods_name") + " 等多件";
			} else {
				goods_name = list.get(0).getString("goods_name");
			}
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
				map.put("openid", shopUser.get("openid"));
				logger.info("传递支付信息到微信--> " + gson.toJson(map));
				// 微信预支付返回的信息
				return_pay = Package.getPackage(this.getRequest().getSession(), map);
			} else if (pay_way.equals("3")) {// 商城币

			}
			map.put("return_pay", return_pay);
			result = 1;
			message = "提交成功！";
		} else {
			message = "订单异常！";
		}
		map.put("result", result);
		map.put("message", message);

		return gson.toJson(map);
	}

	/**
	 * 订单查看
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = { "/orderlist", "/", "/test/orderlist"}, produces = "application/json;charset=UTF-8")
	public String orderlist(Page page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		pd.put("user_id", shopUser.get("user_id"));
		page.setPd(pd);
		List<PageData> orderlist = orderService.list(page); // 列出Order列表
		List<PageData> list = new LinkedList<PageData>();
		for (int i = 0; i < orderlist.size(); i++) {
			PageData order = orderlist.get(i);
			pd.put("order_id", order.getString("order_id"));
			List<PageData> orderdetail = orderDetailService.listAll(pd);
//			int goods_total = 0 ;
			BigDecimal goods_total = BigDecimal.ZERO;
			for(PageData detail:orderdetail){
				goods_total = goods_total.add((BigDecimal)detail.get("goods_count"));
			}
			order.put("goods_total", goods_total);
			order.put("orderdetail", orderdetail);
			list.add(order);
		}
		map.put("list", list);
		map.put("page", page);
		return gson.toJson(map);
	}

	/**
	 * 订单查看
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/order", produces = "application/json;charset=UTF-8")
	public String order() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		pd.put("user_id", shopUser.get("user_id"));
		PageData order = orderService.findById(pd); // 列出Order列表
		List<PageData> orderdetail = orderDetailService.listAll(pd);
		map.put("order", order);
		map.put("orderdetail", orderdetail);
		return gson.toJson(map);
	}

	/**
	 * 订单删除
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/order/delete", produces = "application/json;charset=UTF-8")
	public String delete() throws Exception {
		int result = 0;
		String message = "";
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		result = orderService.delete(pd);
		if (result == 1) {
			message = StringUtil.success_message;
		} else {
			message = StringUtil.error_message;
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}

	/**
	 * 修改订单状态
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/order/status", produces = "application/json;charset=UTF-8")
	public String orderstatus() throws Exception {
		int result = 0;
		String message = "";
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		String status = pd.getString("status");
		if (status.equals("5")) {
			pd.put("record_note", "确认收货");
			pd.put("addtime", DatetimeUtil.getDatetime());
			pd.put("record_id", this.get32UUID());
		}
		result = orderService.edit(pd);
		if (result == 1) {
			message = StringUtil.success_message;
		} else {
			message = StringUtil.error_message;
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}

	@RequestMapping(value = "/order_list")
	public ModelAndView order_list() throws Exception {
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("order/order-list");
		mv.addObject("pd", pd);
		return mv;
	}

	@RequestMapping(value = "/order_info")
	public ModelAndView order_info() throws Exception {
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("order/order-info");
		mv.addObject("pd", pd);
		return mv;
	}

	/**
	 * 申请退款
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/order_refund", produces = "application/json;charset=UTF-8")
	public String order_refund() throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = orderDetailService.findById(pd);
		return gson.toJson(pd);
	}

	@RequestMapping(value = "/order/result")
	public ModelAndView result() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pay/result");
		return mv;
	}
	
	@Autowired
	private DelivererMarketService delivererMarketService;
	
	/**
	 * 配送日期列表
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = { "/deliveryDate", "/", "/test/deliveryDate" }, produces = "application/json;charset=UTF-8")
	public String deliveryDate() throws Exception {
		
		JSONObject result = new JSONObject();
		try {
			JSONArray arr = new JSONArray();
			//默认配送范围4天
			for(int i=0;i<4;i++) {
				String[] times = new String[] { "10:00-11:00", "10:30-11:30", "11:00-12:00", "11:30-12:30", "12:00-13:00",
			            "12:30-13:30", "13:00-14:00", "13:30-14:30", "14:00-15:00", "14:30-15:30",
			            "15:00-16:00", "15:30-16:30", "16:00-17:00", "16:30-17:30", "17:00-18:00",
			            "17:30-18:30", "18:00-19:00"};
				String day = DateUtils.getDate(i);
				//System.out.println("day-->"+day);
				JSONObject json = new JSONObject();
				List<String> timeList = new ArrayList<>();
				if(i==0) {
					for(int n=0;n<times.length;n++) {
				    	String hour = times[n];
				    	hour = hour.substring(0, 5); //截取配送开始时间
				    	if(DateUtils.compare_date(hour.substring(0, 5),DateUtils.getHour())==1) {
				    	 	timeList.add(times[n]);
				    	}
				    }
					times = timeList.toArray(new String[timeList.size()]);
					if(timeList.size()==0) {
						continue;
					}
				}
			    
			    String dayName = "今天";
			    switch (i) {
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
			    json.put("type", i);
				json.put("day", dayName+day);
				json.put("time", day.replace("月", "-").replace("日", ""));
				json.put("times", times);
				arr.add(json);
			}
			result.put("result", StringUtil.success_result);
			result.put("message", StringUtil.success_message);
			result.put("data", arr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", StringUtil.except_result);
			result.put("message", StringUtil.except_message);
		}
		return result.toString();
		
	}
	
    //Integer delivererId = delivererMarketService.getOneDelivererByShopOrder(so.getMarketId()).getDelivererId();
	public static void main(String[] args) {
		PageData detail = new PageData();
		System.out.println(detail.equals(""));
	}

}

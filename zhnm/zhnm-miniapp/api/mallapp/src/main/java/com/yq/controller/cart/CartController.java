package com.yq.controller.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.wqwy.zhnm.base.entity.Market;
import com.wqwy.zhnm.base.service.MarketService;
import com.yq.service.attribute.Attribute_detailManager;
import com.yq.service.cart.CartManager;
import com.yq.service.goods.GoodsManager;
import com.yq.util.DatetimeUtil;
import com.yq.util.StringUtil;

/**
 * 说明：购物车 创建人： qq 357788906 创建时间：2017-01-05
 */
@Controller
public class CartController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	String menuUrl = "cart/list.do"; // 菜单地址(权限用)
	@Resource(name = "cartService")
	private CartManager cartService;
	
	@Resource(name = "goodsService")
	private GoodsManager goodsService;
	
	@Resource(name = "attribute_detailService")
	private Attribute_detailManager attribute_detailService;
    
	@Autowired
	private MarketService marketService;
	
	private Gson gson = new Gson();
	
	@RequestMapping(value = "/cart/tolist")
	public ModelAndView tolist() throws Exception {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("cart/list");
		return mv;
	}

	/**
	 * 保存
	 * 
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = { "/cart/add", "/", "/test/cart/add" }, produces = "application/json;charset=UTF-8")
	public String add() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		int result = 0;
		String message = "";
		String attribute_detail_id = pd.getString("attribute_detail_id");
		// try {
		if (pd.getString("goods_count") != null) {
			int goods_count = Integer.parseInt(pd.getString("goods_count"));
			Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
			
			pd.put("user_id", shopUser.get("user_id"));
			String marketId = pd.getString("marketId");
			pd.put("market_id",marketId);
			
			PageData cart = cartService.findById(pd);
			pd.put("addtime", DatetimeUtil.getDatetime()); // 加入购物车时间
			pd.put("goods_count", goods_count);
			int cart_count = 0;
			if (cart == null) {// 购物车中无本商品，那么则添加
				
				pd.put("cart_id", this.get32UUID()); // 主键
				
				PageData goods = goodsService.findById(pd);
				String goods_pic = goods.getString("goods_pic").contains(",")?goods.getString("goods_pic").split(",")[0]:goods.getString("goods_pic").concat(",");
                
				List<PageData> goodsList = goodsService.listSpecialMarketAll(pd);
				PageData pda = goodsList.get(0);
			    BigDecimal avgPrice = (BigDecimal) pda.get("avg_price");  //商品平均价
				
				String attribute_detail_name = "";
				BigDecimal goods_price = new BigDecimal(0);
				if(!attribute_detail_id.equals("1")){
					PageData detail = attribute_detailService.findById(pd);
					attribute_detail_name = detail.getString("attribute_detail_name");
					
					//goods_price = (BigDecimal) detail.get("attribute_detail_price");
					String attr_value = attribute_detail_name.replace("g", "");
					
					BigDecimal weight = new BigDecimal(0); //规格重量
					weight = new BigDecimal(attr_value).divide(new BigDecimal(1000)); //单位KG
					goods_price = avgPrice.multiply(weight);  //规格价按平均价计算
					
				}else{
					//goods_price = (BigDecimal) goods.get("goods_price");
					goods_price = avgPrice;  //市场的平均价
				}
				pd.put("attribute_detail_name",attribute_detail_name);
				pd.put("goods_name", goods.getString("goods_name"));
				pd.put("goods_pic", goods_pic);
				pd.put("goods_price", goods_price);
				cartService.save(pd);
				result = 1;
				message = "提交成功！";
				cart_count = cartService.count(pd);
				map.put("cart_count", cart_count);
				
			} else {// 购物车中含本商品，那么修改
				result = 1;
				message = "该商品已经在您的购物车了~";
				cartService.edit(pd);
				cart_count = cartService.count(pd);
				map.put("cart_count", cart_count);
			}
			shopUser.put("cart_count", cart_count);
			HttpSession session = StringUtil.session(this.getRequest());
			session.setAttribute("shopUser", shopUser);
			StringUtil.add_session(session);
		} else {
			result = 0;
			message = "请输入正确数量！";
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}

	/**
	 * 修改购物车数量
	 * 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/cart/update", produces = "application/json;charset=UTF-8")
	public String update() {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		int result = 0;
		String message = "";

		try {
			cartService.edit(pd);
			result = 1;
			message = "提交成功！";
			Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
			
			pd.put("user_id", shopUser.get("user_id"));
			String marketId = pd.getString("marketId");
			pd.put("market_id",marketId);
			
			if (shopUser.get("cart_count") != null) {
				int cart_count = cartService.count(pd);
				HttpSession session = StringUtil.session(this.getRequest());
				shopUser.put("cart_count", cart_count);
				session.setAttribute("shopUser", shopUser);
				StringUtil.add_session(session);
				map.put("cart_count", cart_count);
			}
		} catch (Exception e) {
			result = 0;
			message = "提交失败！";
		}
		map.put("shopUser", StringUtil.shopUser(this.getRequest()));
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}

	/**
	 * 删除
	 * 
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/cart/delete", produces = "application/json;charset=UTF-8")
	public String delete() {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		int result = 0;
		String message = "";
		try {
			cartService.delete(pd);
			result = 1;
			message = "提交成功！";
			Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
			
			pd.put("user_id", shopUser.get("user_id"));
			String marketId = pd.getString("marketId");
			pd.put("market_id",marketId);
			
			if (shopUser.get("cart_count") != null) {
				int cart_count = cartService.count(pd);
				shopUser.put("cart_count", cart_count);
				HttpSession session = StringUtil.session(this.getRequest());
				shopUser.put("cart_count", cart_count);
				session.setAttribute("shopUser", shopUser);
				StringUtil.add_session(session);	
				map.put("cart_count", cart_count);
			}
		} catch (Exception e) {
			result = 0;
			message = "提交失败！";
		}
		map.put("shopUser", StringUtil.shopUser(this.getRequest()));
		this.getRequest().getSession().setAttribute(StringUtil.get_session_id(this.getRequest()), map);
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}

	/**
	 * 列表
	 * @param page
	 * @throws Exception
	 */

	@ResponseBody
	@RequestMapping(value = { "/cart/list", "/", "/test/cart/list"}, produces = "application/json;charset=UTF-8")
	public String list() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		
		/**
		 * TODO
		 */
		String marketId = pd.getString("marketId");
		if (StringUtils.isEmpty(marketId)) {
			try {
				List<Market> marketList = marketService.findListMarketByLocation(pd.getString("location"));
				if(null!=marketList && marketList.size()>0){
					marketId = marketList.get(0).getId().toString();
				}
			} catch (Exception e) {
				logger.error("index page get location failed");
			}
		}
		pd.put("market_id", marketId);
		pd.put("user_id", shopUser.get("user_id"));
		List<PageData> list = cartService.listAll(pd); // 列出Cart列表
		List<PageData> cartlist = new ArrayList<>();
		int cartCount = 0;
		if(StringUtils.isNotEmpty(pd.getString("market_id"))) {
			for (int i = 0; i < list.size(); i++) {
				PageData goods = list.get(i);
				String pic = goods.getString("goods_pic");
				if (StringUtils.isNotEmpty(pic)) {
					if (pic.contains(",")) {
						pic = pic.split(",")[0];
					}
				}
				goods.put("goods_pic", pic);
				cartlist.add(goods);
			}
			//获取购物车数量
			if(null!=shopUser) {
				cartCount = cartService.count(pd);
			}
			map.put("cart_count", cartCount);
		}else {
			map.put("cart_count", "0");
		}
		map.put("cartlist", cartlist);
		return gson.toJson(map);
	}

	/**
	 * 批量删除
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/app/cartdeleteAll", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object deleteAll() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		int result = 0;
		String message = "";
		String DATA_IDS = pd.getString("CART_IDS");
		if (null != DATA_IDS && !"".equals(DATA_IDS)) {
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			cartService.deleteAll(ArrayDATA_IDS);
			result = 1;
			message = "提交成功！";
		} else {
			result = 0;
			message = "请选择！";
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}
	public static void main(String[] args) {
		String goods_pic = "adsfadf,asdf";
		System.err.println(goods_pic.contains(","));		
				
//				?goods_pic.split(",")[0]:goods_pic.concat(",");

	}

}

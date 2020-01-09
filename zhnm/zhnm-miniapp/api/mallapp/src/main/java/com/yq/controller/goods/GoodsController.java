package com.yq.controller.goods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
import com.google.gson.GsonBuilder;
import com.wqwy.zhnm.base.entity.Market;
import com.wqwy.zhnm.base.entity.SellerGoods;
import com.wqwy.zhnm.base.service.MarketService;
import com.wqwy.zhnm.base.service.SellerGoodsService;
import com.yq.service.attribute.AttributeManager;
import com.yq.service.attribute.Attribute_detailManager;
import com.yq.service.cart.CartManager;
import com.yq.service.category.CategoryManager;
import com.yq.service.collection.CollectionManager;
import com.yq.service.comment.CommentManager;
import com.yq.service.coupon.CouponManager;
import com.yq.service.freight.FreightManager;
import com.yq.service.goods.GoodsManager;
import com.yq.util.DatetimeUtil;
import com.yq.util.StringUtil;

/**
 * 说明：商品管理 创建人：易钱科技 创建时间：2016-12-19
 */
@Controller
public class GoodsController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

	@Resource(name = "goodsService")
	private GoodsManager goodsService;
	@Resource(name = "categoryService")
	private CategoryManager categoryService;
	@Resource(name = "collectionService")
	private CollectionManager collectionService;
	@Resource(name = "commentService")
	private CommentManager commentService;

	@Resource(name = "couponService")
	private CouponManager couponService;
	@Resource(name = "freightService")
	private FreightManager freightService;

	@Resource(name = "attributeService")
	private AttributeManager attributeService;

	@Resource(name = "attribute_detailService")
	private Attribute_detailManager attribute_detailService;
	
	@Resource(name = "cartService")
	private CartManager cartService;
	
	@Autowired
	private SellerGoodsService sellerGoodsService;
	
	@Autowired
	private MarketService marketService;

	private Gson gson = new GsonBuilder().serializeNulls().create();

	@RequestMapping(value = "/goods/list")
	public ModelAndView togoodslist() throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		String goods_name = pd.getString("goods_name");
		if (goods_name != null) {
			if (StringUtils.isEmpty(goods_name.trim())) {
				pd.put("goods_name", "");
			}
		}
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("goods/list");
		mv.addObject("pd", pd);
		return mv;
	}

	/**
	 * 列表
	 * 
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchlist")
	public ModelAndView list() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		// String goods_name = pd.getString("goods_name");
		// String title = pd.getString("title");
		// if(StringUtils.isNotEmpty(goods_name)){
		// goods_name = java.net.URLDecoder.decode(goods_name,"UTF-8");
		// pd.put("goods_name",goods_name);
		//
		// }
		// if(StringUtils.isNotEmpty(title)){
		// title = java.net.URLDecoder.decode(title,"UTF-8");
		// pd.put("title",title);
		// }
		List<PageData> varList = goodsService.listAll(pd); // 列出Goods列表

		mv.setViewName("goods/search-list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/goods/info", "/", "/test/goods/info" }, produces = "application/json;charset=UTF-8")
	public String goodscontent(Page page) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		logger.info("pd to string " + pd.toString());
		
//		pd.forEach((Object k,Object v) -> {
//			System.out.println("key: " + k + " value: " + v);
//		});
		
		
		SellerGoods sg = new SellerGoods();
		sg.setMarketId(Integer.parseInt(pd.getString("marketId")));
		sg.setGoodsId(Integer.parseInt(pd.getString("goods_id")));
		List<SellerGoods> list = sellerGoodsService.findList(sg);
		
		SellerGoods sellerGoods = list.get(0); //获取库存最大的商户
		BigDecimal currentStock = sellerGoods.getCurrentStock().multiply(new BigDecimal(1000)); //克/g
		
		PageData goods = goodsService.findById(pd);
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		if (shopUser != null) {
			pd.put("user_id", shopUser.get("user_id"));
			map.put("collection", collectionService.findById(pd));// 用户是否已收藏商品
		}
		pd.put("nowtime", DatetimeUtil.getDate());
		page.setPd(pd);
		List<PageData> couponlist = couponService.list(page);// 可领优惠券
		PageData freight = freightService.findById(pd);// 商品运费
		pd.put("super_id", "0");
		
		PageData pda = new PageData();
		pda.put("goods_id", pd.getString("goods_id"));
		pda.put("market_id", pd.getString("marketId"));
		List<PageData> goodsList = goodsService.listSpecialMarketAll(pda);
		pda = goodsList.get(0);
	  
	    BigDecimal avgPrice = (BigDecimal) pda.get("avg_price");  //商品平均价
		
		List<PageData> th_list = attributeService.listAll(pd); // 商品属性名称
		//如果商品有属性
		if (th_list.size() > 0) {
			List<PageData> attr_list = new ArrayList<PageData>();
			List<PageData> detail_list = attribute_detailService.listAll(pd);// 商品属性详情，已经组合
			for (int i = 0; i < detail_list.size(); i++) {
				PageData  goods_detail = new PageData();
				
				List<PageData> attr_key_value_list = new ArrayList<PageData>();
				goods_detail.put("attribute_detail_id", detail_list.get(i).getString("attribute_detail_id"));
				goods_detail.put("attribute_detail_price", detail_list.get(i).get("attribute_detail_price"));
				//goods_detail.put("attribute_detail_num", detail_list.get(i).get("attribute_detail_num"));
				
				//计算实时库存
				String[] goods_attr = detail_list.get(i).getString("attribute_detail_name").split(",");
				String attr_value = goods_attr[0].replace("g", "");
				if(!StringUtil.isInteger(attr_value) || currentStock==null) {
					continue;
				}
				
				BigDecimal weight = new BigDecimal(0); //规格重量
				weight = new BigDecimal(attr_value).divide(new BigDecimal(1000)); //单位KG
				
				BigDecimal attr_avg_price = avgPrice.multiply(weight);
				attr_avg_price = attr_avg_price.setScale(2, BigDecimal.ROUND_HALF_UP);
						
				goods_detail.put("attribute_detail_avg_price", attr_avg_price);  //规格按平均价计算
				
				BigDecimal stock = currentStock.divide(new BigDecimal(attr_value), 0, BigDecimal.ROUND_FLOOR); //当前库存
				goods_detail.put("attribute_detail_num", stock);
				
				for (int j = 0; j < goods_attr.length; j++) {//分割组合过的属性
					if(j==0) {
						PageData  attr_key_value = new PageData();
						attr_key_value.put("attr_key", th_list.get(j).getString("attribute_name"));
						attr_key_value.put("attr_value", goods_attr[j]);
						attr_key_value_list.add(attr_key_value);
					}
				}
				
				goods_detail.put("goods_attr", goods_attr);
				goods_detail.put("attr_key_value_list", attr_key_value_list);
				attr_list.add(goods_detail);
				
			}

			map.put("attribute_detail_id", "0");
			map.put("attr_list", attr_list);
		}else{
			map.put("attribute_detail_id", "1");
		}
		//评论
		PageData cm = new PageData();
		cm.put("goods_id", pd.getString("goods_id"));
		//cm.put("user_id", pd.getString("user_id"));
		cm.put("currentPage", 1);
		page.setPd(cm);
		List<PageData>	commentlist = commentService.list(page);
		
		int cartCount = 0;  //购物车数量
		String marketId = pd.getString("marketId");
		if(null!=shopUser && StringUtils.isNotEmpty(marketId)) {
			pd.put("user_id",shopUser.get("user_id"));
			pd.put("market_id",marketId);
			cartCount = cartService.count(pd);
		}
		map.put("cart_count", cartCount);
		map.put("commentlist", commentlist);
		map.put("page", page);
		
		goods.put("avg_price", pda.get("avg_price"));  //市场商品平均价
		goods.put("attr_min_price", pda.get("attr_min_price"));  //市场商品最小规格价格
		map.put("goods", goods);
		map.put("couponlist", couponlist);
		map.put("freight", freight);
		return gson.toJson(map);
	}

	@ResponseBody
	@RequestMapping(value = { "/app/goodslist", "/", "/test/app/goodslist" }, produces = "application/json;charset=UTF-8")
	public String goodslist(Page page) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		
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
		String super_id = pd.getString("super_id");
		if (StringUtils.isEmpty(super_id)) {
			super_id = "0";
			pd.put("super_id", super_id);
		}
		String goods_name = pd.getString("goods_name");
		if (goods_name != null) {
			if (StringUtils.isEmpty(goods_name.trim())) {
				pd.put("goods_name", "");
			} else {
				pd.put("goods_name", java.net.URLDecoder.decode(goods_name, "utf-8"));
			}
		}
		page.setPd(pd);
		List<PageData> goodslist = goodsService.listSpecialMarket(page);
		List<PageData> list = new ArrayList<PageData>();
		if(StringUtils.isNotEmpty(pd.getString("market_id"))) {
			for (int i = 0; i < goodslist.size(); i++) {
				PageData goods = goodslist.get(i);
				String pic = goods.getString("goods_pic");
				if (StringUtils.isNotEmpty(pic)) {
					if (pic.contains(",")) {
						pic = pic.split(",")[0];
					}
				}
				goods.put("goods_pic", pic);
				list.add(goods);
			}
		}
		
		PageData data = new PageData();
		data.put("goodslist", list);
		data.put("page", page);
		
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		int cartCount = 0;  //购物车数量
		if(null!=shopUser && StringUtils.isNotEmpty(marketId)) {
			pd.put("user_id",shopUser.get("user_id"));
			pd.put("market_id",marketId);
			cartCount = cartService.count(pd);
		}
		
		data.put("cart_count", cartCount);
		return gson.toJson(data);
	}
	
	@ResponseBody
	@RequestMapping(value = "/app/searchlist", produces = "application/json;charset=UTF-8")
	public String searchlist() throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		// String GOODS_NAME = pd.getString("GOODS_NAME");
		/*
		 * if(StringUtils.isNotEmpty(GOODS_NAME)){ GOODS_NAME =
		 * java.net.URLDecoder.decode(GOODS_NAME,"UTF-8");
		 * pd.put("GOODS_NAME",GOODS_NAME); }
		 */

		List<PageData> varList = goodsService.listAll(pd); // 列出Goods列表
		List<PageData> list = new ArrayList<>();
		for (int i = 0; i < varList.size(); i++) {
			PageData goods = varList.get(i);
			String pic = goods.getString("GOODS_PIC");
			if (StringUtils.isNotEmpty(pic)) {
				if (pic.contains(",")) {
					pic = pic.split(",")[0];
				}
			}
			goods.put("GOODS_PIC", pic);
			list.add(goods);
		}

		return gson.toJson(list);
	}

}

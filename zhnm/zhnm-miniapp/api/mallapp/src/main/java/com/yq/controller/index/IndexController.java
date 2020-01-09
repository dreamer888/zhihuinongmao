package com.yq.controller.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wqwy.zhnm.base.component.request.UserIndexRequest;
import com.wqwy.zhnm.base.entity.Market;
import com.wqwy.zhnm.base.service.MarketService;
import com.yq.service.banner.BannerManager;
import com.yq.service.cart.impl.CartService;
import com.yq.service.goods.GoodsManager;
import com.yq.service.navigation.NavigationManager;
import com.yq.service.news.NewsManager;
import com.yq.util.StringUtil;

@Controller
public class IndexController extends BaseController {
	@Resource(name = "bannerService")
	private BannerManager bannerService;

	@Resource(name = "navigationService")
	private NavigationManager navigationService;

	@Resource(name = "newsService")
	private NewsManager newsService;

	@Resource(name = "goodsService")
	private GoodsManager goodsService;
    
	@Resource(name = "cartService")
	private CartService cartService;
	
	@Autowired
	private MarketService marketService;

	private Gson gson = new GsonBuilder().serializeNulls().create();
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@ResponseBody
	@RequestMapping(value = { "/index", "/", "/test/index" }, produces = "application/json;charset=UTF-8")
	public String index(UserIndexRequest uir, Page page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<PageData> newslist = newsService.list(page); // 列出新闻列表
		List<PageData> tuijianlist = new LinkedList<PageData>();
		List<PageData> goodslist = new LinkedList<PageData>();
		int cartCount = 0;  //购物车数量
		pd.put("tuijian", "1");

		/**
		 * 若前端参数中存在用户基本位置信息(location)
		 * 需要重新定位首页获取数据 定位需要获取到位置附近的相关菜市场的列表
		 */
		List<Market> marketList = new ArrayList<Market>();
		Integer marketId = uir.getMarketId();
		boolean hasMarketNear = true;
		if (marketId == null) {
			try {
				marketList = marketService.findListMarketByLocation(uir.getLocation());
				marketId = marketList.get(0).getId();
			} catch (Exception e) {
				logger.error("index page get location failed");
				hasMarketNear = false;
			}
		}
		
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		
		if(null!=marketId) {
			Market market = marketService.get(marketId.toString());
			marketList.add(market);
			pd.put("market_id", marketId);
			//获取购物车数量
			if(null!=shopUser) {
				pd.put("user_id",shopUser.get("user_id"));
				cartCount = cartService.count(pd);
			}
		
		}
		
		if (hasMarketNear && null!=marketId) {
			List<PageData> list = goodsService.listSpecialMarketAll(pd);
			for (int i = 0; i < list.size(); i++) {
				PageData goods = list.get(i);
				String pic = goods.getString("goods_pic");
				if (StringUtils.isNotEmpty(pic)) {
					if (pic.contains(",")) {
						pic = pic.split(",")[0];
					}
				}
				goods.put("goods_pic", pic);
				tuijianlist.add(goods);
			}

			pd.put("tuijian", "");
			page.setPd(pd);
			List<PageData> glist = goodsService.listSpecialMarket(page);
			for (int i = 0; i < glist.size(); i++) {
				PageData goods = glist.get(i);
				String pic = goods.getString("goods_pic");
				pic = pic.contains(",") == true ? pic.split(",")[0] : pic;
				// if(StringUtils.isNotEmpty(pic)){
				// if(pic.contains(",")){
				// pic = pic.split(",")[0];
				// }
				// }
				goods.put("goods_pic", pic);
				goodslist.add(goods);
			}
		}
        
		List<PageData> bannerlist = bannerService.listAll(pd); // 列出Banner列表
		if(bannerlist.size()==0) {
			//pd.remove("market_id");
			PageData pdb = new PageData();
			bannerlist = bannerService.listAll(pdb);
		}
		
		List<PageData> navigationlist = navigationService.listAll(pd);// 列出导航图标列表
		
		if(navigationlist.size()==0) {
			//pd.remove("market_id");
			PageData pdn = new PageData();
			navigationlist = navigationService.listAll(pdn);
		}
	
		map.put("cart_count", cartCount);
		map.put("tuijianlist", tuijianlist);
		map.put("goodslist", goodslist);
		map.put("newslist", newslist);
		map.put("bannerlist", bannerlist);
		map.put("navigationlist", navigationlist);
		map.put("marketlist", marketList);
		map.put("result", 1);
		return gson.toJson(map);
	}

}

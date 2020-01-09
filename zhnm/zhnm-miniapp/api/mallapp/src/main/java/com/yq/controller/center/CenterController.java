package com.yq.controller.center;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.change.controller.base.BaseController;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yq.service.cart.CartManager;
import com.yq.service.order.OrderManager;
import com.yq.service.user.ShopUserManager;
import com.yq.util.StringUtil;

@Controller
public class CenterController extends BaseController{
	private Gson gson = new Gson();
	
	@Resource(name = "orderService")
	private OrderManager orderService;
	
	@Resource(name = "cartService")
	private CartManager cartService;
	
	@Resource(name = "shopUserService")
	private ShopUserManager shopUserService;
	
	
	@ResponseBody
	@RequestMapping(value="center/index", produces = "application/json;charset=UTF-8")
	public String index() throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData count = new PageData();
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		if(shopUser!=null){
		pd.put("user_id", shopUser.get("user_id"));
		pd.put("status", 0);
		count.put("d_fk", orderService.count(pd));//待付款
		
		pd.put("status", 1);
		count.put("d_fh", orderService.count(pd));//待发货
		
		pd.put("status", 2);
		count.put("d_sh", orderService.count(pd));//待收货
		
		pd.put("status", 5);
		count.put("d_pj", orderService.count(pd));//待评价
		}
		
		int cartCount = 0;  //购物车数量
		String marketId = pd.getString("marketId");
		if(null!=shopUser && StringUtils.isNotEmpty(marketId)) {
			pd.put("user_id",shopUser.get("user_id"));
			pd.put("market_id",marketId);
			cartCount = cartService.count(pd);
		}
		map.put("cart_count", cartCount);
		map.put("count",count);
		
		pd.put("user_id", shopUser.get("user_id"));
		PageData user = shopUserService.findById(pd);
		
		map.put("shopUser",user);
		return gson.toJson(map);
	}
}

package com.yq.controller.url;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yq.service.banner.BannerManager;
import com.yq.service.category.CategoryManager;
import com.yq.service.coupon.CouponManager;
import com.yq.service.goods.GoodsManager;

@Controller
public class UrlController {
	
	@Resource(name = "categoryService")
	private CategoryManager categoryService;
	
	@Resource(name = "goodsService")
	private GoodsManager goodsService;
	
	@Resource(name = "couponService")
	private CouponManager couponService;
	
	private Gson gson = new Gson();
	
	@ResponseBody
	@RequestMapping(value = "/get_url", produces = "application/json;charset=UTF-8")
	public String getUrl() throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd = new PageData();
		//分类
		pd.put("super_id", 0);
		List<PageData> super_list = categoryService.listAll(pd);
		for (int i = 0; i < super_list.size(); i++) {
			pd.put("super_id", super_list.get(i).getString("category_id"));
			List<PageData> child_list = categoryService.listAll(pd);
			super_list.get(i).put("child_list", child_list);
			//商品
			for (int j = 0; j < child_list.size(); j++) {
				pd.put("super_id", 0);
				pd.put("category_id", child_list.get(j).getString("category_id"));
				child_list.get(j).put("goods_list", goodsService.listAll(pd));
			}
		}
		//优惠券
		List<PageData> coupon_list = couponService.listAll(pd);
		map.put("super_list", super_list);
		map.put("coupon_list", coupon_list);
		return gson.toJson(map);
	}
}

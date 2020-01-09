package com.yq.controller.category;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.change.controller.base.BaseController;
import org.change.util.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yq.service.cart.CartManager;
import com.yq.service.category.CategoryManager;
import com.yq.util.StringUtil;

/**
 * 说明：分类 创建人：易钱科技 创建时间：2016-12-17
 */
@Controller
public class CategoryController extends BaseController {

	String menuUrl = "category/list.do"; // 菜单地址(权限用)
	@Resource(name = "categoryService")
	private CategoryManager categoryService;
	
	@Resource(name = "cartService")
	private CartManager cartService;

	private Gson gson = new GsonBuilder().serializeNulls().create();
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	/**
	 * 保存
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/category/save")
	public ModelAndView save() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("CATEGORY_ID", this.get32UUID()); // 主键
		categoryService.save(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 列表
	 * 
	 * @param page
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/app/category/list", produces = "application/json;charset=UTF-8")
	public String list() throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String super_id = pd.getString("super_id");
		if(StringUtils.isEmpty(super_id)){
			super_id = "0" ;
			pd.put("super_id", super_id);
		}
		List<PageData>	category_list = new LinkedList<PageData>();
		List<PageData>	categoryList = categoryService.listAll(pd);
		for (int i = 0; i < categoryList.size(); i++) {
			PageData category = categoryList.get(i);
			pd.put("super_id", category.getString("category_id"));
			List<PageData>	childcategory = categoryService.listAll(pd);//分类
			category.put("childcategory", childcategory);
			category_list.add(category);
		}
		
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		int cartCount = 0;  //购物车数量
		String marketId = pd.getString("marketId");
		if(null!=shopUser && StringUtils.isNotEmpty(marketId)) {
			pd.put("user_id",shopUser.get("user_id"));
			pd.put("market_id",marketId);
			cartCount = cartService.count(pd);
		}
		
		map.put("cart_count", cartCount);
		map.put("category_list", category_list);
		return gson.toJson(map);
	}
	@ResponseBody
	@RequestMapping(value = "/app/categoryList", produces = "application/json;charset=UTF-8")
	public String applist() throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> categoryList = categoryService.listAll(pd); // 列出Category列表
		return gson.toJson(categoryList);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}

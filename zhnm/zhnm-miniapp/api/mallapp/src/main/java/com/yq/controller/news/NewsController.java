package com.yq.controller.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yq.service.news.NewsManager;

/**
 * 说明：新闻信息 创建人：壹仟科技 qq 357788906 创建时间：2016-12-29
 */
@Controller
public class NewsController extends BaseController {

	String menuUrl = "news/list.do"; // 菜单地址(权限用)
	@Resource(name = "newsService")
	private NewsManager newsService;
	private Gson gson = new GsonBuilder().serializeNulls().create();

	/**
	 * 列表
	 * 
	 * @param page
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/news/list", produces = "application/json;charset=UTF-8")
	public String applist(Page page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<PageData> list = newsService.list(page);
		map.put("list", list);
		map.put("page", page);
		return gson.toJson(map);
	}

	/**
	 * 详情
	 * 
	 * @param page
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/news/info", produces = "application/json;charset=UTF-8")
	public String appnews() throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData news = newsService.findById(pd);
		return gson.toJson(news);
	}

	/**
	 * 去列表页面
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/news/tolist")
	public ModelAndView tolist() throws Exception {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("news/list");
		return mv;
	}

	/**
	 * 去详情页面
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/news/toinfo")
	public ModelAndView toinfo() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("news/info");
		mv.addObject("pd",pd);
		return mv;
	}

}

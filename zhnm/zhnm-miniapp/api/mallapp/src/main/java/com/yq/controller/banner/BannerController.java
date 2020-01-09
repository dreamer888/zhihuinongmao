package com.yq.controller.banner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.change.controller.base.BaseController;
import org.change.util.PageData;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yq.service.banner.BannerManager;

/** 
 * 说明：轮播图片
 * 创建时间：2016-12-12
 */
@Controller
@RequestMapping(value="/app/banner")
public class BannerController extends BaseController {
	
	String menuUrl = "banner/list.do"; //菜单地址(权限用)
	@Resource(name="bannerService")
	private BannerManager bannerService;
	private Gson gson = new Gson();

	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/list", produces = "application/json;charset=UTF-8")
	public String list() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData>	bannerlist = bannerService.listAll(pd);	//列出Banner列表
		return gson.toJson(bannerlist);
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}

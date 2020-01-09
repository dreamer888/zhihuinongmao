package com.yq.controller.search;

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
import com.yq.service.search.SearchManager;

/** 
 * 说明：搜索热词
 * 创建人：壹仟科技 qq 357788906
 * 创建时间：2017-02-06
 */
@Controller
public class SearchController extends BaseController {
	
	@Resource(name="searchService")
	private SearchManager searchService;
	private Gson gson = new Gson();
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/search")
	public ModelAndView list() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData>	varList = searchService.listAll(pd);	//列出search列表
		mv.setViewName("index/search");
		mv.addObject("varList", varList);
		return mv;
	}
	@ResponseBody
	@RequestMapping(value="/app/search", produces = "application/json;charset=UTF-8")
	public String searchlist() throws Exception{ 
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData>	varList = searchService.listAll(pd);	//列出search列表
		return gson.toJson(varList) ;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}

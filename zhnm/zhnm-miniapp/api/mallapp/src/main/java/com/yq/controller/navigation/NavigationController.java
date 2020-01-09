package com.yq.controller.navigation;

import java.util.List;

import javax.annotation.Resource;

import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yq.service.navigation.NavigationManager;

/** 
 * 说明：首页导航
 * 创建人：壹仟科技 qq 357788906
 * 创建时间：2016-12-29
 */
@Controller
@RequestMapping(value="/navigation")
public class NavigationController extends BaseController {
	
	String menuUrl = "navigation/list.do"; //菜单地址(权限用)
	@Resource(name="navigationService")
	private NavigationManager navigationService;
	

	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
//		page.setPd(pd);
		List<PageData>	varList = navigationService.listAll(pd);	//列出Navigation列表
		mv.setViewName("navigation/navigation_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		return mv;
	}

}

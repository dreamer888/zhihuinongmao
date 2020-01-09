package com.yq.controller.news;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.AppUtil;
import org.change.util.PageData;
import com.fh.util.Jurisdiction;
import com.google.gson.Gson;
import com.yq.service.news.NewsManager;
import com.yq.util.DatetimeUtil;

/**
 * 说明：新闻信息 创建人：壹仟科技 qq 357788906 创建时间：2016-12-29
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController extends BaseController {

	String menuUrl = "news/list.do"; // 菜单地址(权限用)
	@Resource(name = "newsService")
	private NewsManager newsService;
	private Gson gson = new Gson();
	/**
	 * 保存
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
	public ModelAndView save() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "新增News");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		System.out.println("save》》》》》》》》》》》》"+pd);
		pd.put("addtime", DatetimeUtil.getDate());
		pd.put("news_id", this.get32UUID()); // 主键
		newsService.save(pd);
		mv.setViewName("redirect:/news/list?type=" + pd.get("type"));
		return mv;
	}

	/**
	 * 删除
	 * 
	 * @param out
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/delete",produces = "application/json;charset=UTF-8")
	public String delete() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除News");
		int result = 0;
		String message = "";
		Map<String,Object> map = new HashMap<>();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			if (Jurisdiction.buttonJurisdiction(menuUrl, "del")) {// 校验权限
				newsService.delete(pd);
				result = 1;
			}
		} catch (Exception e) {
			result = 0;
			message = "系统异常";
		}
		map.put("result",result);
		map.put("message",message);
		return gson.toJson(map);
	}

	/**
	 * 修改
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "修改News");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		System.out.println("pd》》》》》》》》》》》》"+pd);
		newsService.edit(pd);
		mv.setViewName("redirect:/news/list?type=" + pd.get("type"));
		return mv;
	}

	/**
	 * 列表
	 * 
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(Page page) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "列表News");
		// if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		// //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords"); // 关键词检索条件
		if (null != keywords && !"".equals(keywords)) {
			pd.put("keywords", keywords.trim());
		}
		pd.put("type", pd.getString("type"));
		page.setPd(pd);
		List<PageData> varList = newsService.list(page); // 列出News列表
		mv.setViewName("news/news_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("qx", Jurisdiction.getHC()); // 按钮权限
		return mv;
	}

	/**
	 * 去新增页面
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/goAdd")
	public ModelAndView goAdd() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		mv.setViewName("news/news_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}

	/**
	 * 去修改页面
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/goEdit")
	public ModelAndView goEdit() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = newsService.findById(pd); // 根据ID读取
		mv.setViewName("news/news_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}

	/**
	 * 批量删除
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "批量删除News");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return null;
		} // 校验权限
		PageData pd = new PageData();
		Map<String, Object> map = new HashMap<String, Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if (null != DATA_IDS && !"".equals(DATA_IDS)) {
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			newsService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		} else {
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}

	
}

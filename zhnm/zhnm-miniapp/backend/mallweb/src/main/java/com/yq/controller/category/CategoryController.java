package com.yq.controller.category;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.AppUtil;
import org.change.util.PageData;
import com.google.gson.Gson;
import com.fh.util.Jurisdiction;
import com.yq.service.category.CategoryManager;
import com.yq.service.goods.GoodsManager;


/**
 * 说明：分类 创建人：易钱科技 创建时间：2016-12-17
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

	String menuUrl = "category/list.do"; // 菜单地址(权限用)
	@Resource(name = "categoryService")
	private CategoryManager categoryService;
	@Resource(name="goodsService")
	private GoodsManager goodsService;
	private Gson gson = new Gson();

	/**
	 * 保存
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
	public ModelAndView save() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "新增Category");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("category_id", this.get32UUID()); // 主键
		String super_id = pd.getString("super_id");
		if (StringUtils.isEmpty(super_id)) {
			super_id = "0";
		}
		categoryService.save(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 删除
	 * 
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
	public void delete(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除Category");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
		String result = "" ;
		PageData pd = new PageData();
		pd = this.getPageData();
		String super_id = pd.getString("super_id");
		String category_id = pd.getString("category_id");
		if (super_id.equals("0")) {
			pd.put("super_id", category_id);
			List<PageData> list = categoryService.listAll(pd);
			if (list.size() == 0) {
				categoryService.delete(pd);
				result = "success" ;
			} else {
				result = "error" ;
			}
		}else{
			List<PageData> list = goodsService.listAll(pd);
			if (list.size() == 0) {
				categoryService.delete(pd);
				result = "success" ;
			} else {
				result = "error" ;
			}
		}
		out.write(result);
		out.close();
	}

	/**
	 * 修改
	 * 
	 * @param  怎么把文件流引进来
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "修改Category");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		categoryService.edit(pd);
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
	@RequestMapping(value = "/list")
	public ModelAndView list(Page page) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "列表Category");
		// if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		// //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String super_id = pd.getString("super_id");
		/*
		 * if(StringUtils.isEmpty(super_id)){ super_id = "0" ;
		 * pd.put("super_id", super_id); }
		 */
		page.setPd(pd);
		List<PageData> varList = categoryService.list(page); // 列出Category列表
		mv.setViewName("category/category_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("qx", Jurisdiction.getHC()); // 按钮权限
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = "/jsonlist", produces = "application/json;charset=UTF-8")
	public String jsonlist() throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> varList = categoryService.listAll(pd); // 列出Category列表
		return gson.toJson(varList);
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
		System.out.println("pd》》》》》》》》》》》》》》》》》》》"+pd);
		mv.setViewName("category/category_edit");
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
		pd = categoryService.findById(pd); // 根据ID读取
		mv.setViewName("category/category_edit");
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
		logBefore(logger, Jurisdiction.getUsername() + "批量删除Category");
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
			categoryService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		} else {
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}

}

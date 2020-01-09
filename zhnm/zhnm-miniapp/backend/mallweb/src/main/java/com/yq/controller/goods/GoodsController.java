package com.yq.controller.goods;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.AppUtil;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.util.Jurisdiction;
import com.yq.service.attribute.AttributeManager;
import com.yq.service.attribute.Attribute_detailManager;
import com.yq.service.category.CategoryManager;
import com.yq.service.goods.GoodsManager;
import com.yq.util.MacUtil;
import com.yq.util.Turns;

/**
 * 说明：商品管理 创建人：易钱科技 创建时间：2016-12-19
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController extends BaseController {

	String menuUrl = "goods/list.do"; // 菜单地址(权限用)
	@Resource(name = "goodsService")
	private GoodsManager goodsService;

	@Resource(name = "categoryService")
	private CategoryManager categoryService;

	@Resource(name = "attributeService")
	private AttributeManager attributeService;

	@Resource(name = "attribute_detailService")
	private Attribute_detailManager attribute_detailService;

	/**
	 * 保存
	 * 
	 * @param
	 * @throws Exception
	 */

	@RequestMapping(value = "/save")
	public ModelAndView save() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "新增Goods");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> thead_th_list = new ArrayList<PageData>();
		List<PageData> tbody_td_list = new ArrayList<PageData>();
		List<PageData> detail_list = new ArrayList<PageData>();
		String goods_id = this.get32UUID();
		String thead_th = pd.getString("thead_th");// 属性名
		String attribute_detail_num = pd.getString("attribute_detail_num");// 库存
		String attribute_detail_price = pd.getString("attribute_detail_price");// 价格
		String detail_name = pd.getString("detail_name");
		if (StringUtils.isNotEmpty(thead_th)) {
			String attr_td = pd.getString("attr_td");// 属性详情名
			String[] thead_th_arry = thead_th.split(",");
			String[] tbody_td_arry = attr_td.split("qp");
			String[] detail_name_arry = detail_name.split("qp");
			String[] detail_num_array = attribute_detail_num.split(",");
			String[] detail_price_array = attribute_detail_price.split(",");
			for (int i = 0; i < thead_th_arry.length; i++) {
				// String attribute_detail_id =
				PageData attribute = new PageData();// 总属性
				//String attribute_id = this.get32UUID();
				//attribute.put("attribute_id", attribute_id);
				attribute.put("goods_id", goods_id);
				attribute.put("attribute_name", thead_th_arry[i]);
				attribute.put("super_id", "0");
				attribute.put("sort", i);
				thead_th_list.add(attribute);
				String[] td_arry = detail_name_arry[i].split(",");
				for (int j = 0; j < td_arry.length; j++) {
					PageData attribute_detail = new PageData();// 子属性
					String attribute_detail_id = this.get32UUID();
					attribute_detail.put("attribute_id", attribute_detail_id);
					attribute_detail.put("goods_id", goods_id);
					attribute_detail.put("attribute_name", td_arry[j]);
					//attribute_detail.put("super_id", attribute_id);
					attribute_detail.put("sort", j);
					tbody_td_list.add(attribute_detail);
				}
			}
			for (int j = 0; j < tbody_td_arry.length; j++) {

				System.out.println("------------" + detail_num_array[j]);
				PageData detail = new PageData();// 属性详情
				detail.put("goods_id", goods_id);
				detail.put("attribute_detail_id", this.get32UUID());
				detail.put("attribute_detail_num", detail_num_array[j]);
				detail.put("attribute_detail_price", detail_price_array[j]);
				detail.put("attribute_detail_name", tbody_td_arry[j]);
				detail.put("sort", j);
				detail_list.add(detail);
			}

		}
		pd.put("goods_id", goods_id); // 主键
		pd.put("thead_th_list", thead_th_list);
		pd.put("tbody_td_list", tbody_td_list);
		pd.put("detail_list", detail_list);
		goodsService.save(pd);
		mv.setViewName("redirect:/goods/list.do");
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
		logBefore(logger, Jurisdiction.getUsername() + "删除Goods");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		goodsService.delete(pd);
		goodsService.deleteSellerGoods(pd); //同时删除附表
		out.write("success");
		out.close();
	}

	/**
	 * 修改
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "修改Goods");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> thead_th_list = new ArrayList<PageData>();
		List<PageData> tbody_td_list = new ArrayList<PageData>();
		List<PageData> detail_list = new ArrayList<PageData>();
		String goods_id = pd.getString("goods_id");
		String thead_th = pd.getString("thead_th");// 属性名
		String attribute_detail_num = pd.getString("attribute_detail_num");// 库存
		String attribute_detail_price = pd.getString("attribute_detail_price");// 价格
		String detail_name = pd.getString("detail_name");
		if (StringUtils.isNotEmpty(thead_th)) {
			String attr_td = pd.getString("attr_td");// 属性详情名
			String[] thead_th_arry = thead_th.split(",");
			String[] tbody_td_arry = attr_td.split("qp");
			String[] detail_name_arry = detail_name.split("qp");
			String[] detail_num_array = attribute_detail_num.split(",");
			String[] detail_price_array = attribute_detail_price.split(",");
			for (int i = 0; i < thead_th_arry.length; i++) {
				PageData attribute = new PageData();// 总属性
				String attribute_id = this.get32UUID();
				attribute.put("attribute_id", attribute_id);
				attribute.put("goods_id", goods_id);
				attribute.put("attribute_name", thead_th_arry[i]);
				attribute.put("super_id", "0");
				attribute.put("sort", i);
				thead_th_list.add(attribute);
				System.err.println("th -->" +attribute );
				String[] td_arry = detail_name_arry[i].split(",");
				for (int j = 0; j < td_arry.length; j++) {
					PageData attribute_detail = new PageData();// 子属性
					String attribute_detail_id = this.get32UUID();
					attribute_detail.put("attribute_id", attribute_detail_id);
					attribute_detail.put("goods_id", goods_id);
					attribute_detail.put("attribute_name", td_arry[j]);
					attribute_detail.put("super_id", attribute_id);
					attribute_detail.put("sort", j);
					tbody_td_list.add(attribute_detail);
					System.err.println("td -->" +attribute_detail );
				}
			}
			for (int j = 0; j < tbody_td_arry.length; j++) {

				PageData detail = new PageData();// 属性详情
				detail.put("goods_id", goods_id);
				detail.put("attribute_detail_id", this.get32UUID());
				detail.put("attribute_detail_num", detail_num_array[j]);
				detail.put("attribute_detail_price", detail_price_array[j]);
				detail.put("attribute_detail_name", tbody_td_arry[j]);
				detail.put("sort", j);
				detail_list.add(detail);
				System.err.println("detail" +detail );
			}

		}
		pd.put("goods_id", goods_id); // 主键
		pd.put("thead_th_list", thead_th_list);
		pd.put("tbody_td_list", tbody_td_list);
		pd.put("detail_list", detail_list);
		goodsService.edit(pd);
		mv.setViewName("redirect:/goods/list.do");
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
		logBefore(logger, Jurisdiction.getUsername() + "列表Goods");
		// if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		// //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		// PageData category = new PageData();
		PageData pd = new PageData();
		pd = this.getPageData();
		String super_id = pd.getString("super_id");
		pd.put("super_id", "0");
		List<PageData> superlist = categoryService.listAll(pd);// 总分类
		if (super_id != null) {
			if (!super_id.equals("0")) {
				pd.put("super_id", super_id);
				List<PageData> categorylist = categoryService.listAll(pd);// 子分类
				mv.addObject("categorylist", categorylist);
			}
		}

		page.setPd(pd);
		List<PageData> goodslist = goodsService.list(page); // 列出Goods列表
		mv.setViewName("goods/goods_list");
		mv.addObject("goodslist", goodslist);
		mv.addObject("superlist", superlist);
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
		PageData category = new PageData();
		String super_id = pd.getString("super_id");
		if (StringUtils.isEmpty(super_id)) {
			super_id = "0";
			pd.put("super_id", super_id);
		}
		List<PageData> categoryList = categoryService.listAll(pd);
		for (int i = 0; i < categoryList.size(); i++) {
			pd.put("super_id", categoryList.get(i).getString("category_id"));
			List<PageData> childcategory = categoryService.listAll(pd);// 分类
			category.put("childcategory" + i, childcategory);
		}
		category.put("categoryList", categoryList);
		mv.setViewName("goods/goods_edit");
		mv.addObject("msg", "save");
		mv.addObject("category", category);
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
		pd = goodsService.findById(pd); // 根据ID读取
		PageData category = new PageData();
		String super_id = pd.getString("super_id");
		if (StringUtils.isEmpty(super_id)) {
			super_id = "0";
			pd.put("super_id", super_id);
		}
		List<PageData> categoryList = categoryService.listAll(pd);
		for (int i = 0; i < categoryList.size(); i++) {
			pd.put("super_id", categoryList.get(i).getString("category_id"));
			List<PageData> childcategory = categoryService.listAll(pd);// 分类
			category.put("childcategory" + i, childcategory);
		}
		category.put("categoryList", categoryList);
		pd.put("super_id", "0");
		List<PageData> attr_list =new ArrayList<PageData>(); 
		List<PageData> th_list = attributeService.listAll(pd);
		if(th_list.size()!=0){
	
		String thead_th = "";
		String[] thead_th_arry = new String[th_list.size()] ; 
		String detail_name = "";
		String attribute_detail_num = "";
		String attribute_detail_price = "";
		
		List<Object> td_list_arry = new ArrayList<Object>();
		for (int i = 0; i < th_list.size(); i++) {
			PageData th_pageData = th_list.get(i);
			pd.put("super_id", th_pageData.getString("attribute_id"));
			List<PageData> td_list = attributeService.listAll(pd);
			String[] td_arry = new String[td_list.size()];
			String attr_list_td = "";
			for (int j = 0; j < td_list.size(); j++) {//获取属性内容
				td_arry[j] = td_list.get(j).getString("attribute_name");
				if (j == 0) {
					attr_list_td = td_list.get(j).getString("attribute_name");
				} else {
					attr_list_td = attr_list_td + "," + td_list.get(j).getString("attribute_name");
				}
			}
			td_list_arry.add(td_arry);
			th_pageData.put("td_list", td_list);
			attr_list.add(th_pageData);
			if (i == 0) {
				detail_name = attr_list_td ;
				thead_th = th_pageData.getString("attribute_name");
			} else {
				detail_name = detail_name+ "qp" + attr_list_td ;
				thead_th = thead_th + "," + th_pageData.getString("attribute_name");
			}
			thead_th_arry[i] = th_pageData.getString("attribute_name");
		}
		List<PageData> detail_list = attribute_detailService.listAll(pd);
		
//		List<Object> attribute = new ArrayList<Object>();
//		List<Object> attr_td_arry = Turns.list(td_list_arry);
		
		for (int i = 0; i < detail_list.size(); i++) {
			if (i == 0) {
				attribute_detail_num = detail_list.get(i).get("attribute_detail_num")+"";
				attribute_detail_price = ((BigDecimal)detail_list.get(i).get("attribute_detail_price")).toString();
			} else {
				attribute_detail_num = attribute_detail_num + "," + detail_list.get(i).get("attribute_detail_num");
				attribute_detail_price = attribute_detail_price + ","
						+ ((BigDecimal)detail_list.get(i).get("attribute_detail_price")).toString();
			}
		}
		pd.put("thead_th", thead_th);//拼接属性名/表格头
		pd.put("attr_td",Turns.attr(td_list_arry));;//拼接属性值/表格内容
		pd.put("detail_name",detail_name );
		
		
		pd.put("attribute_detail_num", attribute_detail_num);
		pd.put("attribute_detail_price", attribute_detail_price);
		mv.addObject("thead_th_arry", thead_th_arry);
		mv.addObject("detail_list", detail_list);//多规格组合 
		
		}
		mv.addObject("msg", "edit");
		mv.addObject("attr_list", attr_list);
		mv.addObject("category", category);
		mv.addObject("pd", pd);
		mv.setViewName("goods/goods_edit");
		return mv;
	}
	
	 /**批量删除
		 * @param
		 * @throws Exception
		 */
		@RequestMapping(value="/deleteAll")
		@ResponseBody
		public Object deleteAll() throws Exception{
			logBefore(logger, Jurisdiction.getUsername()+"批量删除Goods");
			if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
			PageData pd = new PageData();		
			Map<String,Object> map = new HashMap<String,Object>();
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
				String ArrayDATA_IDS[] = DATA_IDS.split(",");
				goodsService.deleteAll(ArrayDATA_IDS);
				goodsService.deleteAllSellerGoods(ArrayDATA_IDS);
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
        
		/**根据条形码获取产地
		 * @param
		 * @throws Exception
		 */
		@RequestMapping(value="/getProPlace")
		@ResponseBody
		public Object getProPlace() throws Exception{
			logBefore(logger, Jurisdiction.getUsername()+"根据条形码获取产地");
			Map<String, String> map = new HashMap<String,String>();
			PageData pd = new PageData();
			pd = this.getPageData();
			logger.info("gtin:"+pd.getString("gtin"));
			String place = MacUtil.getProductMadeIn(pd.getString("gtin"));
			map.put("place", place);
			logger.info("place:"+place);
			return AppUtil.returnObject(pd, map);
		}
		
}

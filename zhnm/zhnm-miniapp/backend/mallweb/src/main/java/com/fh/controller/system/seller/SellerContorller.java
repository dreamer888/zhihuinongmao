package com.fh.controller.system.seller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.AppUtil;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.entity.system.Category;
import com.fh.entity.system.Market;
import com.fh.service.system.market.MarketManager;
import com.fh.service.system.seller.SellerManager;
import com.yq.service.category.CategoryManager;

/**
 * @author zangmaoyuan
 *2018-5-8
 * 
 */
@Controller
@RequestMapping(value="/seller")
public class SellerContorller  extends BaseController{
	@Resource(name="sellerService")
	private SellerManager sellerService;
	String menuUrl = "seller/listSellers.do"; //菜单地址(权限用)
	@Resource(name="marketService")
	private MarketManager marketService;
	@Resource(name = "categoryService")
	private CategoryManager categoryService;
	
	/**显示商户列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/listSellers")
	public ModelAndView listSellers(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	sellerList = sellerService.listSellers(page);//列出用户列表
		mv.setViewName("seller/baseImformation/seller_list");
		mv.addObject("sellerList", sellerList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**去修改商户页面(系统商户列表修改)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goEditS")
	public ModelAndView goEditS() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.addObject("fx", "seller");
		pd = sellerService.findById(pd);
		pd.put("keywords", null);
		Page page = new Page();
		page.setPd(pd);
		List<Market>	marketList = marketService.listmarketAll(page);//列出市场列表 
		List<Category>	categoryList = sellerService.listCategoryAll(page);//列出市场列表
		mv.addObject("marketList", marketList);
		mv.addObject("categoryList", categoryList);
		mv.setViewName("seller/baseImformation/seller_edit");
		mv.addObject("msg", "editS");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**去新增页面
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value="/goAddS")
	public ModelAndView goAddU()throws Exception{
		ModelAndView mv = this.getModelAndView();
		Page page = new Page();
		PageData pd = new PageData();
		pd.put("keywords", null);
		page.setPd(pd);
		List<Market>	marketList = marketService.listmarketAll(page);//列出市场列表 
		
		List<Category>	categoryList = sellerService.listCategoryAll(page);//列出市场列表
		
		mv.addObject("marketList", marketList);
		mv.addObject("categoryList", categoryList);
		mv.setViewName("seller/baseImformation/seller_add");
		mv.addObject("msg", "saveS");
		return mv;
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value="/findByCategorySortName")
	@ResponseBody
	public Object findByCategorySortName(){
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "error";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(null != sellerService.findByCategorySortName(pd)){
				pd = sellerService.findByCategorySortName(pd);	
				map.put("result", pd);	//返回结果
			}else{
			  map.put("result", errInfo);	//返回结果
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}		
		return AppUtil.returnObject(new PageData(), map);
	}

	/**
	 * 修改商户信息
	 */
	@RequestMapping(value="/editS")
	public ModelAndView editS() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("PASSWORD", new SimpleHash("SHA-1", pd.getString("PASSWORD")).toString());
		sellerService.editS(pd);	//执行修改
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除用户
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteS")
	public void deleteU(PrintWriter out) throws Exception{
		PageData pd = new PageData();
		pd = this.getPageData();
		sellerService.deleteS(pd);
		out.write("success");
		out.close();
	}

	/**
	 * @return
	 */
	@RequestMapping(value="/findSellerByAccount")
	@ResponseBody
	public Object findSellerByAccount(){
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "error";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(null != sellerService.findSellerByAccount(pd)){
				pd = sellerService.findSellerByAccount(pd);	
				map.put("result", pd);	//返回结果
			}else{
			  map.put("result", errInfo);	//返回结果
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}		
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveS")
	public ModelAndView saveU() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("PASSWORD", new SimpleHash("SHA-1", pd.getString("PASSWORD")).toString());	//密码加密
		if(null == sellerService.findSellerByAccount(pd)){
			sellerService.saveS(pd); 					
			mv.addObject("msg","success");
		}else{
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}
}

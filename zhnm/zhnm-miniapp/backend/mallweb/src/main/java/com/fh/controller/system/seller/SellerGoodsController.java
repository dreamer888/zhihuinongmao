package com.fh.controller.system.seller;

import java.util.List;
import javax.annotation.Resource;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.service.system.seller.SellerGoodsManager;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
@Controller
@RequestMapping(value="/sellerGoods")
public class SellerGoodsController extends BaseController{
	@Resource(name="sellerGoodsService")
	private SellerGoodsManager sellerGoodsService;

	/**
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goods")
	public ModelAndView listGoods(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	goodsList = sellerGoodsService.listGoods(page);//列出用户列表
		mv.setViewName("seller/goods/goods_list");
		mv.addObject("goodsList", goodsList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**去修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goEditSGoods")
	public ModelAndView goEditBalance() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = sellerGoodsService.findById(pd);
		mv.setViewName("seller/goods/goods_edit");
		mv.addObject("msg", "editGoods");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/editGoods")
	public ModelAndView editD() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
	    sellerGoodsService.editGoods(pd);	//执行修改
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv ;
	}	
}

package com.fh.controller.system.seller;

import java.util.List;
import javax.annotation.Resource;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.service.system.seller.SellerCreditAndWalletManager;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
@Controller
@RequestMapping(value="/sellerCreditAndWallet")
public class SellerCreditAndWalletController extends BaseController{
	@Resource(name="sellerCreditAndWalletService")
	private SellerCreditAndWalletManager sellerCreditAndWalletService;
	
	/**
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/creditAndWallet")
	public ModelAndView listcreditAndWallet(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	creditAndWalletList = sellerCreditAndWalletService.listcreditAndWallet(page);//列出用户列表
		mv.setViewName("seller/creditAndWallet/creditAndWallet_list");
		mv.addObject("creditAndWalletList", creditAndWalletList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**去修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goEditSCW")
	public ModelAndView goEditBalance() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = sellerCreditAndWalletService.findById(pd);
		mv.setViewName("seller/creditAndWallet/creditAndWallet_edit");
		mv.addObject("msg", "editD");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/editD")
	public ModelAndView editD() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		sellerCreditAndWalletService.editD(pd);	//执行修改
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv ;
	}	
}

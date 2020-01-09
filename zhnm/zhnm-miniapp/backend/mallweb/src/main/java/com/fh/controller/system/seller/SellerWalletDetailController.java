package com.fh.controller.system.seller;

import java.util.List;
import javax.annotation.Resource;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.service.system.seller.SellerWalletDetailManager;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
@Controller
@RequestMapping(value="/sellerWalletDetail")
public class SellerWalletDetailController extends BaseController{

	@Resource(name="sellerWalletDetailService")
	private SellerWalletDetailManager sellerWalletDetailService;
	
	/**
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/walletDetail")
	public ModelAndView listWalletDetail(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	walletDetailList = sellerWalletDetailService.listWalletDetail(page);//列出用户列表
		mv.setViewName("seller/walletDetail/walletDetail_list");
		mv.addObject("walletDetailList", walletDetailList);
		mv.addObject("pd", pd);
		return mv;
	}
}

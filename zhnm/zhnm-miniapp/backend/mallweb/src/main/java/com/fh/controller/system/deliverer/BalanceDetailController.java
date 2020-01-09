package com.fh.controller.system.deliverer;

import java.util.List;
import javax.annotation.Resource;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.service.system.deliverer.BalanceDetailManager;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Controller
@RequestMapping(value="/balanceDetail")
public class BalanceDetailController extends BaseController {

	@Resource(name="balanceDetailService")
	private BalanceDetailManager balanceDetailService;
	  
	/**显示配送员罚单列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/balanceDetailList")
	public ModelAndView listDelivererBalanceDetails(Page page)throws Exception{     
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	balanceDetailList = balanceDetailService.listDelivererBalanceDetails(page);//列表
		mv.setViewName("deliverer/balanceDetail/balanceDetail_list");
		mv.addObject("balanceDetailList",balanceDetailList);
		mv.addObject("pd", pd);
		return mv;
	}
}

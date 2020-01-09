package com.fh.controller.system.deliverer;

import java.util.List;
import javax.annotation.Resource;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.service.system.deliverer.DBalanceManager;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Controller
@RequestMapping(value="/dBalance")
public class DBalanceController  extends BaseController{

	@Resource(name="dBalanceService")
	private DBalanceManager dBalanceService;
	  
	/**显示配送员罚单列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/DBalancesList")
	public ModelAndView listDelivererBankAccounts(Page page)throws Exception{      
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	DBalancesList = dBalanceService.listDelivererDBalances(page);//列表
		mv.setViewName("deliverer/balance/balance_list");
		mv.addObject("DBalancesList",DBalancesList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**去修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goEditBalance")
	public ModelAndView goEditBalance() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = dBalanceService.findById(pd);
		mv.setViewName("deliverer/balance/balance_edit");
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
		dBalanceService.editD(pd);	//执行修改
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv ;
	}
}

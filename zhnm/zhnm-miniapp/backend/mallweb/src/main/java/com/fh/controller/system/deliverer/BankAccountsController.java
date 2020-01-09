package com.fh.controller.system.deliverer;

import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.service.system.deliverer.BankAccountsManager;
import com.fh.util.Jurisdiction;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Controller
@RequestMapping(value="/bankAccounts")
public class BankAccountsController extends BaseController {

	@Resource(name="bankAccountsService")
	private BankAccountsManager bankAccountsService;

	/**显示配送员罚单列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/bankAccountList")
	public ModelAndView listDelivererBankAccounts(Page page)throws Exception{       
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	bankAccountList = bankAccountsService.listDelivererBankAccounts(page);//列表
		mv.setViewName("deliverer/bankAccount/bankAccount_list");
		mv.addObject("bankAccountList",bankAccountList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteDB")
	public void deleteDM(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除delivererBankAccount");
		PageData pd = new PageData();
		pd = this.getPageData();
		bankAccountsService.deleteDB(pd);
		out.write("success");
		out.close();
	}
	
	/**去修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goEditDB")
	public ModelAndView goEditD() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = bankAccountsService.findByDBId(pd);
		mv.setViewName("deliverer/bankAccount/bankAccount_edit");
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
		bankAccountsService.editD(pd);	//执行修改
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv ;
	}
}

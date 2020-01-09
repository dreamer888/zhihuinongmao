package com.fh.controller.system.seller;

import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.service.system.seller.SellerBankAccountManager;
import com.fh.util.Jurisdiction;

/**
 * @author zangmaoyuan
 *2018-5-24
 * 
 */
@Controller
@RequestMapping(value="/sellerBankAccount")
public class SellerBankAccountController extends BaseController {
	@Resource(name="sellerBankAccountService")
	private SellerBankAccountManager sellerBankAccountService;
	
	/**
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/bankAccount")
	public ModelAndView listBankAccount(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	bankAccountList = sellerBankAccountService.listBankAccount(page);//列出用户列表
		mv.setViewName("seller/bankAccount/bankAccount_list");
		mv.addObject("bankAccountList", bankAccountList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deletebankAccount")
	public void deleteDM(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除sellerBankAccount");
		PageData pd = new PageData();
		pd = this.getPageData();
		sellerBankAccountService.deleteSDB(pd);
		out.write("success");
		out.close();
	}

	/**去修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goEditSBA")
	public ModelAndView goEditD() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = sellerBankAccountService.findByDBId(pd);
		mv.setViewName("seller/bankAccount/bankAccount_edit");
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
		sellerBankAccountService.editD(pd);	//执行修改
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv ;
	}	
}

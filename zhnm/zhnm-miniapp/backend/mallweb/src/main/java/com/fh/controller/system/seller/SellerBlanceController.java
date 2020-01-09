package com.fh.controller.system.seller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.AppUtil;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.entity.system.Balance;
import com.fh.entity.system.Seller;
import com.fh.service.system.seller.SellerBlanceManager;
import com.fh.service.system.seller.SellerManager;

/**
 * @author zangmaoyuan
 *2018-6-4
 * 
 */
@Controller
@RequestMapping(value="/sellerBlance")
public class SellerBlanceController extends BaseController  {
	
	@Resource(name="sellerBlaneceService")
	private SellerBlanceManager sellerBlaneceService;
	@Resource(name="sellerService")
	private SellerManager sellerService;
	
	/**
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/blance")
	public ModelAndView listBankAccount(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	balanceList = sellerBlaneceService.listBlances(page);//列出用户列表
		mv.setViewName("seller/balance/balance_list");
		mv.addObject("balanceList", balanceList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteSB")
	public void deleteU(PrintWriter out) throws Exception{
		PageData pd = new PageData();
		pd = this.getPageData();
		sellerBlaneceService.deleteSB(pd);
		sellerBlaneceService.changeBStatus(pd);
		out.write("success");
		out.close();
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goEditSB")
	public ModelAndView goEditS() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.addObject("fx", "seller");
		
		pd = sellerBlaneceService.findById(pd);
		Page page = new Page();
		List<Balance>	balanceList = sellerBlaneceService.getBalanceAll(page);//列出
		mv.setViewName("seller/balance/balance_edit");
		mv.addObject("msg", "editSB");
		mv.addObject("balanceList", balanceList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**去新增页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goAddSB")
	public ModelAndView goAddU()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Page page = new Page();
		List<Seller>	sellerList = sellerBlaneceService.listSellerAll(page);//列出用户列表 
		List<Balance>	balanceList = sellerBlaneceService.getBalanceAll(page);//列出用户列表
		mv.setViewName("seller/balance/balance_add");
		mv.addObject("msg", "saveSB");
		mv.addObject("pd", pd);
		mv.addObject("balanceList", balanceList);
		mv.addObject("sellerList", sellerList);
		return mv;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/editSB")
	public ModelAndView editS() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		sellerBlaneceService.editSB(pd);	//执行修改
		sellerBlaneceService.changeStatus(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**保存
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSB")
	public ModelAndView saveU() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(null == sellerBlaneceService.findBySellerId(pd)){	//判断该商户有没有绑定秤
			sellerBlaneceService.saveSB(pd); 					//执行保存
			sellerBlaneceService.changeStatus(pd);
			mv.addObject("msg","success");
		}else{
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**查重
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/hasI")
	@ResponseBody
	public Object QuerySellerId() throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(sellerBlaneceService.findBySellerId(pd) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//返回结果
		return AppUtil.returnObject(new PageData(), map);	
	}
	
}

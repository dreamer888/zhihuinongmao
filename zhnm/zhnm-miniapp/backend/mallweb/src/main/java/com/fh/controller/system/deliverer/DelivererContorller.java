package com.fh.controller.system.deliverer;

import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.fh.service.system.deliverer.DelivererManager;
import com.fh.util.Jurisdiction;

/**
 * @author zangmaoyuan
 *2018-5-11
 * 
 */
@Controller
@RequestMapping(value="/deliverer")
public class DelivererContorller extends BaseController {

	@Resource(name="delivererService")
	private DelivererManager delivererService;
	String menuUrl = "deliverer/listDeliverers.do"; //菜单地址(权限用)

	/**显示配送员列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/listDeliverers")
	public ModelAndView listDeliverers(Page page)throws Exception{        
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	delivererList = delivererService.listDeliverers(page);//列表
		mv.setViewName("deliverer/baseInformation/deliverer_list");
		mv.addObject("delivererList",delivererList);
		System.out.println(page.getPageStr());
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**显示配送员银行卡列表
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/bankAccounts")
	public ModelAndView listDelivererBankAccount(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	bankAccountList = delivererService.listBankAccount(page);//列表
		mv.setViewName("deliverer/bankAccount/bankAccount_list");
		mv.addObject("bankAccountList",bankAccountList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**显示配送员奖励单列表
	 * @param deliverer_bank_account
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/bonus")
	public ModelAndView listDelivererBonus(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	bonusList = delivererService.listBonus(page);//列表
		mv.setViewName("deliverer/bonus/bonus_list");
		mv.addObject("bonusList",bonusList);
		mv.addObject("pd", pd);
		return mv;
	}

	/**显示配送员中金额 列表
	 * @param deliverer_bank_account
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/balance")
	public ModelAndView listBalance(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	balanceList = delivererService.listBalance(page);//列表
		mv.setViewName("deliverer/balance/balance_list");
		mv.addObject("balanceList",balanceList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteD")
	public void deleteU(PrintWriter out) throws Exception{
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		logBefore(logger, Jurisdiction.getUsername()+"删除deliverer");
		PageData pd = new PageData();
		pd = this.getPageData();
		delivererService.deleteM(pd);
		out.write("success");
		out.close();
	}
	
	/**去新增
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goAddD")
	public ModelAndView goAddU()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("deliverer/baseInformation/deliverer_add");
		mv.addObject("msg", "saveD");
		mv.addObject("pd", pd);
		return mv;
	}

	/**保存
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/saveD")
	public ModelAndView saveB() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		delivererService.saveD(pd); 					
	    mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**判断账号是否存在
	 * @return
	 */
	@RequestMapping(value="/findByAccount")
	@ResponseBody
	public Object findByAccount(){
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			
			if(delivererService.findByAccount(pd) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//返回结果
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * 批量删除
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteAllD")
	@ResponseBody
	public Object deleteAllD() throws Exception {
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DELIVERER_IDS = pd.getString("DELIVERER_IDS");
		if(null != DELIVERER_IDS && !"".equals(DELIVERER_IDS)){
			String ArrayDELIVERER_IDS[] = DELIVERER_IDS.split(",");
			delivererService.deleteAllD(ArrayDELIVERER_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	/**查看
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/view")
	public ModelAndView view() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = delivererService.findByAccount(pd);						
		mv.setViewName("deliverer/baseInformation/deliverer_view");
		mv.addObject("msg", "editD");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**去修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goEditD")
	public ModelAndView goEditD() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = delivererService.findByAccount(pd);
		mv.setViewName("deliverer/baseInformation/deliverer_edit");
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
		delivererService.editD(pd);	
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv ;
	}	
}

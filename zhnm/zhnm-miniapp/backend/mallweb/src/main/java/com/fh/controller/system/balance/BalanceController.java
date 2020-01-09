/**
 * 
 */
package com.fh.controller.system.balance;

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
import com.fh.service.system.balance.BalanceManager;

/**
 * @author zangmaoyuan
 *2018-5-15
 * 
 */
@Controller
@RequestMapping(value="/balance")
public class BalanceController  extends BaseController{
	
	@Resource(name="balanceService")
	private BalanceManager balanceService;
	
	/**显示所有称信息列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/listbalances")
	public ModelAndView listBalances(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		String used = pd.getString("used");
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		if(null != used && !"".equals(used)){
			pd.put("used", used.trim());
		}
		page.setPd(pd);
	    List<PageData>	balanceList = balanceService.listBalances(page);//
		mv.setViewName("balance/balance_list");
		mv.addObject("balanceList", balanceList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**删除智能秤
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteB")
	public void deleteB(PrintWriter out) throws Exception{
		PageData pd = new PageData();
		pd = this.getPageData();
		balanceService.deleteB(pd);
		out.write("success");
		out.close();
	}
	
	/**
	 * 批量删除
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteAllB")
	@ResponseBody
	public Object deleteAllU() throws Exception {
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String BALANCE_IDS = pd.getString("BALANCE_IDS");
		if(null != BALANCE_IDS && !"".equals(BALANCE_IDS)){
			String ArrayBALANCE_IDS[] = BALANCE_IDS.split(",");
			balanceService.deleteAllB(ArrayBALANCE_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	/**去修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goEditB")
	public ModelAndView goEditB() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = balanceService.findById(pd);
		mv.setViewName("balance/balance_view");
		mv.addObject("msg", "editB");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 修改智能秤
	 */
	@RequestMapping(value="/editB")
	public ModelAndView editU() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		balanceService.editB(pd);	//执行修改
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv ;
	}
	
	/**去新增
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goAddB")
	public ModelAndView goAddU()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("balance/balance_edit");
		mv.addObject("msg", "saveB");
		mv.addObject("pd", pd);
		return mv;
	}

	/**保存智能秤
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveB")
	public ModelAndView saveB() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(null == balanceService.findByImei(pd)){	
			balanceService.saveB(pd); 					
			mv.addObject("msg","success");
		}else{
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}
	
	/**判断IMEI号是否存在
	 * @return
	 */
	@RequestMapping(value="/hasI")
	@ResponseBody
	public Object hasI(){
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(balanceService.findByImei(pd) != null){
				errInfo = "error";
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);				//返回结果
		return AppUtil.returnObject(new PageData(), map);
	}	
}

package com.fh.controller.system.market;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.fh.service.system.market.MarketManager;
import com.fh.util.Jurisdiction;

/**
 * @author zangmaoyuan
 *2018-5-11
 * 
 */
@Controller
@RequestMapping(value="/market")
public class MarketController  extends BaseController{

	@Resource(name="marketService")
	private MarketManager marketService;

	/**显示市场列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/listMarkets")
	public ModelAndView listmarkets(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	marketList = marketService.listmarkets(page);//列出市场列表
		mv.setViewName("market/market_list");
		mv.addObject("marketList", marketList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**删除农贸市场
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteM")
	public void deleteU(PrintWriter out) throws Exception{	
		logBefore(logger, Jurisdiction.getUsername()+"删除market");
		PageData pd = new PageData();
		pd = this.getPageData();
		marketService.deleteM(pd);
		out.write("success");
		out.close();
	}
	
	/**批量删除农贸市场
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteAllM")
	@ResponseBody
	public Object deleteAllM() throws Exception {
		logBefore(logger, Jurisdiction.getUsername()+"批量删除market");
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String MARKET_IDS = pd.getString("MARKET_IDS");
		if(null != MARKET_IDS && !"".equals(MARKET_IDS)){
			 String ArrayMARKET_IDS[] = MARKET_IDS.split(",");
			 marketService.deleteAllM(ArrayMARKET_IDS);//删除主表信息
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
	@RequestMapping(value="/goEditM")
	public ModelAndView goEditU() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = marketService.findById(pd);
		mv.setViewName("market/market_edit");
		mv.addObject("msg", "editM");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 修改 保存
	 */
	@RequestMapping(value="/editM")
	public ModelAndView editU() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		marketService.editB(pd);	//执行修改
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv ;//;
	}
	
	/**去新增
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goAddM")
	public ModelAndView goAddU()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("market/market_add");
		mv.addObject("msg", "saveM");
		mv.addObject("pd", pd);
		return mv;
	}

	/**保存
	 * @return
	 * @throws Exception
	 */		
	@RequestMapping(value="/saveM")
	public ModelAndView saveB() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String CLOSE_TIMES = pd.getString("MARKET_CLOSETIME");
		String OPEN_TIMES = pd.getString("MARKET_OPENTIME");
		pd.put("CLOSE_TIMES", CLOSE_TIMES);
		pd.put("OPEN_TIMES", OPEN_TIMES);
		Date createTime = new Date();
		pd.put("CREATE_TIME", createTime);
		marketService.saveM(pd);                                                                  
	    mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}	
}

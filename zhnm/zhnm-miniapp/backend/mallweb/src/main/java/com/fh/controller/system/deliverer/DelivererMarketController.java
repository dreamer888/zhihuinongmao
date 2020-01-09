package com.fh.controller.system.deliverer;

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

import com.fh.entity.system.Deliverer;
import com.fh.entity.system.Market;
import com.fh.service.system.deliverer.DelivererManager;
import com.fh.service.system.deliverer.DelivererMarketManager;
import com.fh.service.system.market.MarketManager;
import com.fh.util.Jurisdiction;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Controller
@RequestMapping(value="/delivererMarket")
public class DelivererMarketController  extends  BaseController{

	@Resource(name="delivererMarketService")
	private DelivererMarketManager delivererMarketService;
	@Resource(name="marketService")
	private MarketManager marketService;
	@Resource(name="delivererService")
	private DelivererManager delivererService;
	
	/**显示配送员列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/listMarkets")
	public ModelAndView listDeliverers(Page page)throws Exception{          
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	marketList = delivererMarketService.listDelivererMs(page);//列表
		mv.setViewName("deliverer/market/market_list");
		mv.addObject("marketList",marketList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**去新增
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goAddM")
	public ModelAndView goAddM()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Page page = new Page();
		List<Market>	marketList = marketService.listmarketAll(page);//列出市场列表 
		List<Deliverer>	delivererList = delivererMarketService.listDelivererAll(page);//列表
		mv.setViewName("deliverer/market/market_add");
		mv.addObject("msg", "saveM");
		mv.addObject("marketList", marketList);
		mv.addObject("delivererList", delivererList);
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
		String market_id = pd.getString("marketName");
		String deliverer_id = pd.getString("dAccount");
		pd.put("MARKET_ID", market_id);
		pd.put("DELIVERER_ID", deliverer_id);
		//查重
		if( delivererMarketService.queryDelivererMarket(pd) != null){
			 mv.addObject("msg","已经关联");
			 mv.setViewName("save_result");
		}else{
			delivererMarketService.saveD(pd); 					
		    mv.addObject("msg","success");
			mv.setViewName("save_result");
		}
		return mv;
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value="/findByMarketName")
	@ResponseBody
	public Object findByName(){
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "error";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(null != delivererMarketService.findByName(pd)){
				pd = delivererMarketService.findByName(pd);	
				map.put("result", pd);	//返回结果
			}else{
			  map.put("result", errInfo);	//返回结果
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}		
		return AppUtil.returnObject(new PageData(), map);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findByDAccount")
	@ResponseBody
	public Object findByAccount(){
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "error";
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			if(null != delivererMarketService.findByAccount(pd)){
				pd = delivererMarketService.findByAccount(pd);	
				map.put("result", pd);	//返回结果
			}else{
			  map.put("result", errInfo);	//返回结果
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**删除
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteDM")
	public void deleteDM(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除delivererMarket");
		PageData pd = new PageData();
		pd = this.getPageData();
		delivererMarketService.deleteDM(pd);
		out.write("success");
		out.close();
	}
}

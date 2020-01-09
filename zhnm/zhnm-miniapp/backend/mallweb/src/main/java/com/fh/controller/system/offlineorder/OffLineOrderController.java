package com.fh.controller.system.offlineorder;

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
import com.fh.service.system.offlineorder.OffLineOrderManager;
import com.fh.util.Jurisdiction;

/**
 * @author zangmaoyuan
 *2018-5-11
 * 
 */
@Controller
@RequestMapping(value="/offLineOrder")
public class OffLineOrderController  extends BaseController{
	@Resource(name="offLineOrderService")
	private OffLineOrderManager offLineOrderService;
	
	/**显示线下订单
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/listoffLineOrders")
	public ModelAndView listoffLineOrders(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	offLineOrderList = offLineOrderService.listOffLineOrders(page);//
		mv.setViewName("offlineorder/order_list");
		mv.addObject("offLineOrderList", offLineOrderList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**
	 * 查看
	 * 
	 */
	@RequestMapping(value = "/order")
	public ModelAndView order() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String orderNumber = pd.getString("ORDER_NUMBER");
		if(!pd.isEmpty()){
			List<PageData> orderGoodsList = offLineOrderService.listAllOrderGoods(pd);
			mv.setViewName("offlineorder/order_view");
			mv.addObject("pd", pd);
			mv.addObject("orderGoodsList", orderGoodsList);
			mv.addObject("orderNumber",orderNumber);
		}else{
			mv.setViewName("offlineorder/order_error");
		}
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteO")
	public void deleteU(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除offLineOrder");
		PageData pd = new PageData();
		pd = this.getPageData();
		offLineOrderService.deleteO(pd);
		offLineOrderService.deleteAppendix(pd);
		out.write("success");
		out.close();
	}
	
	/**
	 * 批量删除
	 * @throws Exception 
	 */
	@RequestMapping(value="/deleteAllO")
	@ResponseBody
	public Object deleteAllU() throws Exception {
		logBefore(logger, Jurisdiction.getUsername()+"批量删除offLineOrder");
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String ORDER_NUMBERS = pd.getString("ORDER_NUMBERS");
		if(null != ORDER_NUMBERS && !"".equals(ORDER_NUMBERS)){
			String ArrayORDER_NUMBERS[] = ORDER_NUMBERS.split(",");
			offLineOrderService.deleteAllO(ArrayORDER_NUMBERS);//删除主表信息
		    offLineOrderService.deleteAllAppendix(ArrayORDER_NUMBERS);   //删除附表信息
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}	
}

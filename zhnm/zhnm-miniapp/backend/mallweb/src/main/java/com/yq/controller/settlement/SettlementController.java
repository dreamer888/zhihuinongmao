package com.yq.controller.settlement;

import java.util.List;

import javax.annotation.Resource;

import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.util.Jurisdiction;
import com.google.gson.Gson;
import com.yq.service.address.AddressManager;
import com.yq.service.category.CategoryManager;
import com.yq.service.express.ExpressManager;
import com.yq.service.goods.GoodsManager;
import com.yq.service.order.OrderDetailManager;
import com.yq.service.order.OrderManager;
import com.yq.service.record.RecordManager;
import com.yq.util.StringUtil;

/**
 * 说明：订单 创建人：万擎伟业科技  创建时间：2018-08-22
 */
@Controller
@RequestMapping(value = "/settlement")
public class SettlementController extends BaseController {
	
	@Resource(name = "orderService")
	private OrderManager orderService;
	@Resource(name="addressService")
	private AddressManager addressService;
	
	@Resource(name = "orderDetailService")
	private OrderDetailManager orderDetailService;
	
	@Resource(name="recordService")
	private RecordManager recordService;
	
	@Resource(name="expressService")
	private ExpressManager expressService;
	
	@Resource(name = "goodsService")
	private GoodsManager goodsService;

	@Resource(name = "categoryService")
	private CategoryManager categoryService;
	
	private Gson gson = new Gson();
	
	/**
	 * 订单流水列表
	 * 
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value = "/orderFlow")
	public ModelAndView list(Page page) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "订单流水");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(StringUtil.checkStr(pd.getString("keyword"))) {
			pd.put("keyword", pd.getString("keyword").trim());
		}
		List<PageData> orderFlowList = orderService.orderFlow(pd); // 列出Goods列表
		mv.setViewName("settlement/order_flow");
		mv.addObject("orderFlowList", orderFlowList);
		mv.addObject("qx", Jurisdiction.getHC()); // 按钮权限
		return mv;
	}
	
	/**
	 * 订单结算列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value = "/orderSellerSettle")
	public ModelAndView orderSellerSettle(Page page) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "订单结算");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(StringUtil.checkStr(pd.getString("keyword"))) {
			pd.put("keyword", pd.getString("keyword").trim());
		}
		List<PageData> orderSettleList = orderService.orderSellerSettle(pd); 
		mv.setViewName("settlement/order_seller_settle");
		mv.addObject("orderSettleList", orderSettleList);
		mv.addObject("qx", Jurisdiction.getHC()); // 按钮权限
		return mv;
		
	}
	
	/**
	 * 商户结算列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value = "/sellerSettle")
	public ModelAndView sellerSettle(Page page) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "商户结算");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(StringUtil.checkStr(pd.getString("keyword"))) {
			pd.put("keyword", pd.getString("keyword").trim());
		}
		List<PageData> sellerSettleList = orderService.sellerSettle(pd); 
		mv.setViewName("settlement/seller_settle");
		mv.addObject("sellerSettleList", sellerSettleList);
		mv.addObject("qx", Jurisdiction.getHC()); // 按钮权限
		return mv;
		
	}
	
}

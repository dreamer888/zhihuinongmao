package com.yq.controller.order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.change.controller.base.BaseController;
import org.change.util.AppUtil;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fh.entity.system.Seller;
import com.fh.service.system.offlineorder.OffLineOrderManager;
import com.fh.service.system.seller.SellerManager;
import com.google.gson.Gson;
import com.yq.service.order.OrderDetailManager;
import com.yq.service.order.OrderManager;

/**
 * 说明：订单 创建人：zss 创建时间：2018-07-12
 */
@Controller
public class PrintOrderController extends BaseController {
	//private Logger log = Logger.getLogger(this.getClass());
	@Resource(name = "orderService")
	private OrderManager orderService;
	
	@Resource(name = "orderDetailService")
	private OrderDetailManager orderDetailService;
	
	@Resource(name="offLineOrderService")
	private OffLineOrderManager offLineOrderService;
	
	@Resource(name = "sellerService")
	private SellerManager sellerService;
	
	private Gson gson = new Gson();
	
	/**
	 * 打印订单
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/login_printOrder" ,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object login_printOrder() throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("order_id", pd.get("order_id"));
		pd.put("seller_id", pd.get("seller_id"));
		PageData payInfo = orderDetailService.printOrder(pd); 
		List<PageData> orderDetailList = orderDetailService.printOrderDetail(pd);
		BigDecimal totalPrice = new BigDecimal(0);
		for(PageData pageData :orderDetailList) {
			totalPrice = totalPrice.add((BigDecimal) pageData.get("pay_total"));
		}
		PageData pda = new PageData();
		pda.put("SELLER_ID", pd.get("seller_id"));
		PageData seller = sellerService.findById(pda);
		if(seller!=null) {
			payInfo.put("seller_name", seller.getString("NAME"));
		}
		payInfo.put("order_total", totalPrice);
		Map<String, String> map = new HashMap<String,String>();
		map.put("payInfo", gson.toJson(payInfo));
		map.put("orderDetailInfo", gson.toJson(orderDetailList));
		return AppUtil.returnObject(new PageData(), map);
	}
    
	/**
	 * 打印称的线下订单
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/login_printOfflineOrder" ,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object login_printOfflineOrder() throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("order_id", pd.get("order_id"));
		PageData payInfo = offLineOrderService.printOfflineOrder(pd); 
		pd.put("ORDER_NUMBER", payInfo.get("order_number"));
		List<PageData> orderGoodsList = offLineOrderService.listAllOrderGoods(pd);
		
		PageData pda = new PageData();
		pda.put("SELLER_ID", payInfo.get("seller_id"));
		PageData seller = sellerService.findById(pda);
		if(seller!=null) {
			payInfo.put("seller_name", seller.getString("NAME"));
		}
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("payInfo", gson.toJson(payInfo));
		map.put("orderDetailInfo", gson.toJson(orderGoodsList));
		return AppUtil.returnObject(new PageData(), map);
	}
	

}

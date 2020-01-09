package com.yq.controller.order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.change.controller.base.BaseController;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yq.service.order.OrderDetailManager;
import com.yq.service.refund.RefundManager;
import com.yq.util.DatetimeUtil;
import com.yq.util.StringUtil;

@Controller
public class OrderDetailController extends BaseController {

	@Resource(name = "orderDetailService")
	private OrderDetailManager orderDetailService;
	@Resource(name = "refundService")
	private RefundManager refundService;

	private Gson gson = new GsonBuilder().serializeNulls().create();

	/**
	 * 根据order_id获取订单详情
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/orderDetail/list", produces = "application/json;charset=UTF-8")
	public String list() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> list = orderDetailService.listAll(pd);
		map.put("result", 1);
		map.put("list", list);
		return gson.toJson(map);
	}

	/**
	 * 根据order_detail_id修改订单详情
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/order/refund", produces = "application/json;charset=UTF-8")
	public String update() throws Exception {
		int result = 0;
		String message = "";
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		String refund_price = pd.getString("refund_price");

		PageData order_detail = orderDetailService.findById(pd);
		PageData order_refund = refundService.findById(pd);
		BigDecimal pay_total = (BigDecimal) order_detail.get("pay_total");
		if (order_refund == null) {
			// 比对退款金额，超出支付金额
			if (new BigDecimal(refund_price).compareTo(pay_total) == 1) {
				message = StringUtil.error_message;
			} else {
				String refund_explain = pd.getString("refund_explain");
				if (StringUtils.isNotEmpty(refund_explain)) {
					pd.put("refund_explain", java.net.URLDecoder.decode(refund_explain, "utf-8"));
				}
				pd.put("status", 3);
				pd.put("refund_id", this.get32UUID());
				pd.put("addtime", DatetimeUtil.getDatetime());
				
				List<PageData> order_list =  orderDetailService.listAll(pd);
				int status_count = 0 ;
				for (int i = 0; i < order_list.size(); i++) {
					int order_detail_status = (int)order_list.get(i).get("status");
					if(order_detail_status==1||order_detail_status==2){
						status_count++;
					}
				}
				//status_count==1,只有一件待/发货商品，修改总订单状态
				pd.put("status_count", status_count);
				result = orderDetailService.edit(pd);
				if (result == 1) {
					message = StringUtil.success_message;
				} else {
					message = StringUtil.error_message;
				}
			}
		} else {
			message = StringUtil.error_message;
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}
	 

}

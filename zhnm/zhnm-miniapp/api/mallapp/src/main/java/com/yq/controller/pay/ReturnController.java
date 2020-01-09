package com.yq.controller.pay;
import org.change.controller.base.BaseController;
import org.change.util.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yq.service.order.OrderManager;
import com.yq.util.DatetimeUtil;

@Controller
public class ReturnController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ReturnController.class);
	
	/**
	 * 根据订单总编号更新支付状态
	 * 
	 * @param SIGN
	 *            总编号
	 * @throws Exception
	 */
	public void updateorder(String order_id, OrderManager orderService) throws Exception {
		PageData pd = new PageData();
		pd.put("order_id", order_id);
		PageData order = orderService.findById(pd);
		logger.info("微信支付成功，返回order=="+order);
		if((int)order.get("status")==0){
			pd.put("status", "11");
			pd.put("record_note", "付款时间");
			pd.put("record_id", this.get32UUID());
			pd.put("addtime", DatetimeUtil.getDatetime());
			orderService.edit(pd);
		}
	}
	
	@RequestMapping(value = "/app/repay")
	public String test() throws Exception {
		// updateorder("27aa0352714d4d1caed0b659d0d6939b");
		return "";
	}

	public static void main(String[] args) {
		String PRIZE = (int) (10000000 + Math.random() * (10000688 - 10000000 + 1)) + "";
		System.out.println(PRIZE);
	}
}

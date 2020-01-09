package com.yq.controller.order;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.AppUtil;
import com.fh.util.ObjectExcelView;
import org.change.util.PageData;
import com.google.gson.Gson;
import com.fh.util.Jurisdiction;
import com.yq.service.address.AddressManager;
import com.yq.service.express.ExpressManager;
import com.yq.service.order.OrderDetailManager;
import com.yq.service.order.OrderManager;
import com.yq.service.record.RecordManager;
import com.yq.util.DatetimeUtil;
import com.yq.util.GetIp;
import com.yq.util.StringUtil;

/**
 * 说明：订单 创建人：壹仟科技 qq 357788906 创建时间：2017-01-05
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController {
	//private Logger log = Logger.getLogger(this.getClass());
	String menuUrl = "order/list.do"; // 菜单地址(权限用)
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
	
	private Gson gson = new Gson();
	/**
	 * 保存
	 * 
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/save")
	public ModelAndView save() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "新增Order");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			return null;
		} // 校验权限
		PageData shopUser = StringUtil.shopUser(this.getRequest().getSession());
		
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String addtime = sf.format(new Date());
		pd.put("addtime", addtime);
		pd.put("user_ip", GetIp.getIp(this.getRequest())); //用户ip
		pd.put("ip_address", GetIp.getAddresses(GetIp.getIp(this.getRequest()), "UTF-8")); //用户ip地址
		pd.put("user_id", shopUser.get("user_id"));
		pd.put("order_id", StringUtil.getId()); // 主键
		orderService.save(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 删除
	 * 
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
	public void delete(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除Order");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		orderService.delete(pd);
		out.write("success");
		out.close();
	}

	
	/**
	 * 发货
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/send" , produces = "application/json;charset=UTF-8")
	public String send() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		String message = "";
		PageData pd = new PageData();
		pd = this.getPageData();
		String express_name = pd.getString("express_name");
		if (StringUtils.isNotEmpty(express_name)) {
			pd.put("express_name", java.net.URLDecoder.decode(express_name, "utf-8"));
		}
		pd.put("record_note","发货时间");
		pd.put("addtime",DatetimeUtil.getDatetime());
		pd.put("record_id",this.get32UUID());
		pd.put("status",2);
		result = orderService.edit(pd);
		if(result==1){
			message = StringUtil.success_message;
		}else{
			message = StringUtil.error_message;
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}
	
	/*@ResponseBody
	@RequestMapping(value = "/refund" , produces = "application/json;charset=UTF-8")
	public String refund() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		String message = "";
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("record_note","退款时间");
		pd.put("addtime",DatetimeUtil.getDatetime());
		pd.put("record_id",this.get32UUID());
		pd.put("status",4);
		result = orderService.refund(pd);
		if(result==1){
			message = StringUtil.success_message;
		}else{
			message = StringUtil.error_message;
		}
		map.put("result", result);
		map.put("message", message);
		return gson.toJson(map);
	}*/
	/**
	 * 列表
	 * 
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(Page page) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "列表Order");
		// if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		// //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
//		String status = pd.getString("status");
//		pd.put("status", null);
		page.setPd(pd);
		List<PageData> orderlist = orderService.list(page); // 列出Order列表
//		pd.put("status", status);
//		page.setPd(pd);
		List<PageData> list = new LinkedList<PageData>();
		for (int i = 0; i < orderlist.size(); i++) {
			PageData order = orderlist.get(i);
			List<PageData> orderdetail = orderDetailService.listAll(order);
				order.put("orderdetail", orderdetail);
				order.put("detaillength", orderdetail.size());
				list.add(order);	
			
		}
		mv.setViewName("order/order_list");
		mv.addObject("list", list);
		mv.addObject("pd", pd);
		mv.addObject("qx", Jurisdiction.getHC()); // 按钮权限
		return mv;
	}


	/**
	 * 查看
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/order")
	public ModelAndView order() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = orderService.findById(pd); // 根据ID读取
		List<PageData> orderdetail =  orderDetailService.listAll(pd);
		if(!orderdetail.isEmpty()){
			List<PageData> record = recordService.listAll(pd);
			List<PageData> express = expressService.listAll(pd);
			pd.put("detaillength", orderdetail.size());
			mv.setViewName("order/order_edit");
			mv.addObject("pd", pd);
			mv.addObject("record", record);
			mv.addObject("express", express);
			mv.addObject("orderdetail",orderdetail);
		}else{
			mv.setViewName("order/order_error");
		}
		return mv;
	}

	/**
	 * 批量删除
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "批量删除Order");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return null;
		} // 校验权限
		PageData pd = new PageData();
		Map<String, Object> map = new HashMap<String, Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if (null != DATA_IDS && !"".equals(DATA_IDS)) {
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			orderService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		} else {
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
}

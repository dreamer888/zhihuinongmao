package com.yq.controller.refund;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.util.Jurisdiction;
import com.google.gson.Gson;
import com.weixin.util.Refund;
import com.yq.service.order.OrderDetailManager;
import com.yq.service.order.OrderManager;
import com.yq.service.refund.RefundManager;

/** 
 * 说明：退款
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-05-20
 */
@Controller
@RequestMapping(value="/refund")
public class RefundController extends BaseController {
	
	String menuUrl = "refund/list.do"; //菜单地址(权限用)
	@Resource(name="refundService")
	private RefundManager refundService;
	
	@Resource(name="orderDetailService")
	private OrderDetailManager orderDetailService;
	
	@Resource(name="orderService")
	private OrderManager orderService;
	private Gson gson = new Gson();
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Refund");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("refund_id", this.get32UUID());	//主键
		refundService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Refund");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		refundService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Refund");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		refundService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Refund");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = refundService.list(page);	//列出Refund列表
		mv.setViewName("refund/refund_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("qx",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**去退款页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/torefund")
	public ModelAndView torefund()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = refundService.findById(pd);	//根据ID读取
		mv.setViewName("refund/refund_info");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/refund", produces = "application/json;charset=UTF-8")
	public String refund(HttpServletRequest request,HttpServletResponse response)throws Exception{
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = refundService.findById(pd);	//根据ID读取
		PageData order  = orderService.findById(pd);
		int result = 0 ;
		pd.put("order_total",(BigDecimal)order.get("order_total"));
		PageData data = Refund.refund(pd, request,response);
		if((int)data.get("result")==1){
			pd.put("status",4);
			List<PageData> order_list =  orderDetailService.listAll(pd);
			int status_count = 0 ;
			for (int i = 0; i < order_list.size(); i++) {
				int order_detail_status = (int)order_list.get(i).get("status");
				if(order_detail_status==1||order_detail_status==2){
					status_count++;
				}
			}
			pd.put("status_count", status_count);
			result = orderDetailService.edit(pd);
			data.put("result",result);
		}
		return gson.toJson(data);
	}	

}

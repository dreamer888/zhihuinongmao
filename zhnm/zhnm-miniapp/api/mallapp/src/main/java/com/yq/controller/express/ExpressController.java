package com.yq.controller.express;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.change.controller.base.BaseController;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yq.service.express.ExpressManager;
import com.yq.util.Express;

/** 
 * 说明：快递公司信息
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-05-21
 */
@Controller
@RequestMapping(value="/express")
public class ExpressController extends BaseController {
	
	String menuUrl = "express/list.do"; //菜单地址(权限用)
	@Resource(name="expressService")
	private ExpressManager expressService;
	private Gson gson = new Gson();
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/toinfo")
	public ModelAndView toinfo() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String expCode = pd.getString("express_title");
		if(expCode.equals("wxkd")){
			pd.put("express_name", "无需快递");
			pd.put("express_num", "");
			pd.put("express_title", "wxkd");
		}
		mv.addObject("pd",pd);
		mv.setViewName("order/express");
		return mv;
	}

	/**
	 * 发货
	 * @param
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/info" , produces = "application/json;charset=UTF-8")
	public String send() throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		String expCode = pd.getString("express_title");
		String expNo = pd.getString("express_num");
		String express = "";
		if(!expCode.equals("wxkd")){
			express = Express.getOrderTracesByJson(expCode, expNo);
		}
//		try {
		
//		} catch (Exception e) {
//			e.getStackTrace();
//			express = "{\"EBusinessID\": \"1289307\",  \"Success\": false,  \"Reason\": \"系统异常\"}";
//		}
		PageData return_express = new PageData();
		return_express = gson.fromJson(express, PageData.class);
		map.put("result", 1);
		map.put("express",return_express);
		return gson.toJson(map);
	}
	
	
}

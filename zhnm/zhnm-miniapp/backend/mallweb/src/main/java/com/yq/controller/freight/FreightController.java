package com.yq.controller.freight;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.change.controller.base.BaseController;
import org.change.util.PageData;
import com.fh.util.Jurisdiction;
import com.yq.service.freight.FreightManager;

/** 
 * 说明：运费
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-05-14
 */
@Controller
@RequestMapping(value="/freight")
public class FreightController extends BaseController {
	
	String menuUrl = "freight/list.do"; //菜单地址(权限用)
	@Resource(name="freightService")
	private FreightManager freightService;
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Freight");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		freightService.edit(pd);
		mv.setViewName("redirect:goEdit");
		return mv;
	}
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = freightService.findById(pd);	//根据ID读取
		mv.setViewName("freight/freight_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 
}

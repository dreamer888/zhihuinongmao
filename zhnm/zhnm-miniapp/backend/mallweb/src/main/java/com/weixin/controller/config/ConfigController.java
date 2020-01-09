package com.weixin.controller.config;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.change.controller.base.BaseController;
import org.change.util.PageData;
import com.fh.util.Jurisdiction;
import com.weixin.service.config.ConfigManager;

/** 
 * 说明：微信配置
 * 创建人：千派网络  www.qanpai.com
 * 创建时间：2017-04-10
 */
@Controller
@RequestMapping(value="/config")
public class ConfigController extends BaseController {
	
	String menuUrl = "config/list.do"; //菜单地址(权限用)
	@Resource(name="configService")
	private ConfigManager configService;
	
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改config");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("config_id",pd.get("config_id"));
		configService.edit(pd);
		mv.setViewName("redirect:/config/goEdit?config_id="+pd.get("config_id"));
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
		pd.put("config_id", pd.get("config_id"));
		pd = configService.findById(pd);	//根据ID读取
		mv.setViewName("weixin/config/config_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	
}

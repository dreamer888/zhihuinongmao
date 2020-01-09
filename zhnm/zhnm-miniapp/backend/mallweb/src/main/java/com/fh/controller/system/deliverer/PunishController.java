package com.fh.controller.system.deliverer;

import java.util.List;
import javax.annotation.Resource;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.service.system.deliverer.PunishManager;

/**
 * @author zangmaoyuan
 *2018-5-23
 * 
 */
@Controller
@RequestMapping(value="/punish")
public class PunishController extends BaseController{
	
	@Resource(name="punishService")
	private PunishManager punishService;
	  
	/**显示配送员罚单列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/listPunishs")
	public ModelAndView listDelivererPs(Page page)throws Exception{        
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();  
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
	    List<PageData>	punishList = punishService.listDelivererPs(page);//列表
		mv.setViewName("deliverer/punish/punish_list");
		mv.addObject("punishList",punishList);
		mv.addObject("pd", pd);
		return mv;
	}
}

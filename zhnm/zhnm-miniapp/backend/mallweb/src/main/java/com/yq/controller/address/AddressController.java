package com.yq.controller.address;

import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import com.yq.service.address.AddressManager;

import net.sf.json.JSONObject;

/** 
 * 说明：收货地址
 * 创建人：壹仟科技 qq 357788906
 * 创建时间：2017-02-21
 */
@Controller
public class AddressController extends BaseController {
	
	String menuUrl = "address/list.do"; //菜单地址(权限用)
	@Resource(name="addressService")
	private AddressManager addressService;
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/address/save")
	public ModelAndView save() throws Exception{
		
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("address_id", this.get32UUID());	//主键
		addressService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/address/delete")
	public void delete(PrintWriter out) throws Exception{
	
		PageData pd = new PageData();
		pd = this.getPageData();
		addressService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/address/edit")
	public ModelAndView edit() throws Exception{
		
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		addressService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/address/list")
	public ModelAndView list(Page page) throws Exception{
			ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = addressService.list(page);	//列出Address列表
		mv.setViewName("address/address_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/address/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("address/address_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/address/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = addressService.findById(pd);	//根据ID读取
		mv.setViewName("address/address_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	
}

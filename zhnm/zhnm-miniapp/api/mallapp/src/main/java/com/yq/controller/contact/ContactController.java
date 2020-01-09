package com.yq.controller.contact;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.change.controller.base.BaseController;
import org.change.entity.Page;
import org.change.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yq.service.contact.ContactManager;
import com.yq.util.StringUtil;

/** 
 * 说明：意见反馈
 * 创建人：壹仟科技 qq 357788906
 * 创建时间：2017-03-01
 */
@Controller
public class ContactController extends BaseController {
	
	@Resource(name="contactService")
	private ContactManager contactService;
	private Gson gson = new GsonBuilder().serializeNulls().create();
	
	@RequestMapping(value="/contactindex")
	public ModelAndView into() throws Exception{
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("contact/index");
		return mv;
	}
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	
	@ResponseBody
	@RequestMapping(value="/contact/save", produces = "application/json;charset=UTF-8")
	public String save() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String, Object>  shopUser  = StringUtil.shopUser(this.getRequest());
		
		pd.put("USER_ID", shopUser.get("USER_ID"));
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String addtime = sd.format(new Date());
		pd.put("ADDTIME",addtime);	
		
		String content = pd.getString("CONTENT");
		if(StringUtils.isNotEmpty(content)){
			pd.put("CONTENT", java.net.URLDecoder.decode(content,"UTF-8"));	
		}
		pd.put("CONTACT_ID", this.get32UUID());	//主键
		contactService.save(pd);
		map.put("result", 1);
		map.put("message", "提交成功");
		return gson.toJson(map);
	}

	@ResponseBody
	@RequestMapping(value = "/app/contact/add", produces = "application/json;charset=UTF-8")
	public String appuserintegral(Page page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String addtime = sd.format(new Date());
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("CONTACT_ID", this.get32UUID());	//主键
		pd.put("ADDTIME",addtime);	
		contactService.save(pd);
		map.put("result", 1);
		map.put("message", "提交成功");
		return gson.toJson(map);
	}
	
	
	 
}

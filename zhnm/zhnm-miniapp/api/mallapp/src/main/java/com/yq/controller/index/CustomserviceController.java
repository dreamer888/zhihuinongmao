package com.yq.controller.index;

import org.change.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CustomserviceController {
	
	@ResponseBody
	@RequestMapping(value="/app/customservice")
	public String cssc(){
		BaseController bc = new BaseController();
		String custom = "";
		if (bc.getApp().getAttribute("custom") == null) {
			custom = "https://qanpai.qiyukf.com/client?k=f7dc0f9e5b2b4e5e3acbffeb7326f107&wp=1";
			bc.getApp().setAttribute("custom",custom);
		}else{
			custom  =  (String) bc.getApp().getAttribute("custom");
		}
		return custom;
	}
}

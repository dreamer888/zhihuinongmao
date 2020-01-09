package com.yq.controller.kefu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KefuController {
	
	@RequestMapping(value = "app/kefu")
	public ModelAndView kefu(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("kefu/kefu");
		return mv ;
	}
}

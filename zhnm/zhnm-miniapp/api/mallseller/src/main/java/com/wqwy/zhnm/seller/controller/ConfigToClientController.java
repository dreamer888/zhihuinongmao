package com.wqwy.zhnm.seller.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.config.ComponentProperties;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

@RestController
@RequestMapping("/v1")
public class ConfigToClientController {

	@Autowired
	private ComponentProperties componentProperties;
	
	@RequestMapping(value="mq", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ComponentProperties.Amqp> getMQConfig(HttpServletRequest request){
		ComponentProperties.Amqp cpA = new ComponentProperties.Amqp();
		BeanUtils.copyProperties(componentProperties.getAmqp(), cpA);
		cpA.setRabbitmqUsername(null);
		cpA.setRabbitmqPassword(null);
		return new JsonResponse<ComponentProperties.Amqp>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, cpA);
	}
	
}

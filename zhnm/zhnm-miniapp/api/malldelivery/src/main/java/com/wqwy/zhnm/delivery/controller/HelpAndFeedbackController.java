/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.delivery.controller;

import com.github.pagehelper.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.wqwy.zhnm.base.entity.HelpAndFeedback;
import com.wqwy.zhnm.base.service.HelpAndFeedbackService;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-23 12:05:29
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class HelpAndFeedbackController {

	@Autowired
	private HelpAndFeedbackService  helpAndFeedbackService;

	/**
	 * 
	 * @date 2018-05-23 12:05:29
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param helpAndFeedback
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<HelpAndFeedback>>
	 * @throws
	 */
	@RequestMapping(value="helpAndFeedbacks", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<HelpAndFeedback>> findByPage(HelpAndFeedback helpAndFeedback, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<HelpAndFeedback> queryResultList = helpAndFeedbackService.findListByPage(helpAndFeedback, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<HelpAndFeedback>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-23 12:05:29
	 * @Title: findHelpAndFeedbackDetail 
	 * @Description: TODO
	 * @param @param helpAndFeedback
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<HelpAndFeedback>
	 * @throws
	 */
	@RequestMapping(value="helpAndFeedbacks/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<HelpAndFeedback> findHelpAndFeedbackDetail(@PathVariable("id")Integer id, HelpAndFeedback helpAndFeedback, HttpServletRequest request){
		helpAndFeedback = helpAndFeedbackService.get(id.toString());
		return new JsonResponse<HelpAndFeedback>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, helpAndFeedback);
	}

	
	/**
	 * 
	 * @date 2018-05-23 12:05:29
	 * @Title: modifyHelpAndFeedbackDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param helpAndFeedback
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<HelpAndFeedback>
	 * @throws
	 */
	@RequestMapping(value="helpAndFeedbacks/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<HelpAndFeedback> modifyHelpAndFeedbackDetail(@PathVariable("id")Integer id, @RequestBody HelpAndFeedback helpAndFeedback, HttpServletRequest request){
		helpAndFeedback.setId(id);
		helpAndFeedbackService.update(helpAndFeedback);
		return new JsonResponse<HelpAndFeedback>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, helpAndFeedbackService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-23 12:05:29
	 * @Title: addHelpAndFeedback 
	 * @Description: TODO
	 * @param @param helpAndFeedback
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<HelpAndFeedback>
	 * @throws
	 */
	@RequestMapping(value="helpAndFeedbacks", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> addHelpAndFeedback(@RequestBody HelpAndFeedback helpAndFeedback, HttpServletRequest request){
		helpAndFeedbackService.insert(helpAndFeedback);
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
	/**
	 * 
	 * @date 2018-05-23 12:05:29
	 * @Title: removeHelpAndFeedback 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="helpAndFeedbacks/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeHelpAndFeedback(@PathVariable("id")Integer id, HttpServletRequest request){
		helpAndFeedbackService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

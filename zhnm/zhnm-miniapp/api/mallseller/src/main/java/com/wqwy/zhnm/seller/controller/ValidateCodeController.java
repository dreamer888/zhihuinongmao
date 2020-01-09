/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

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

import com.wqwy.zhnm.base.entity.ValidateCode;
import com.wqwy.zhnm.base.service.ValidateCodeService;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-25 13:03:49
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class ValidateCodeController {

	@Autowired
	private ValidateCodeService  validateCodeService;

	/**
	 * 
	 * @date 2018-05-25 13:03:49
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param validateCode
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<ValidateCode>>
	 * @throws
	 */
	@RequestMapping(value="validateCodes", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<ValidateCode>> findByPage(ValidateCode validateCode, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<ValidateCode> queryResultList = validateCodeService.findListByPage(validateCode, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<ValidateCode>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-25 13:03:49
	 * @Title: findValidateCodeDetail 
	 * @Description: TODO
	 * @param @param validateCode
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ValidateCode>
	 * @throws
	 */
	@RequestMapping(value="validateCodes/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ValidateCode> findValidateCodeDetail(@PathVariable("id")Integer id, ValidateCode validateCode, HttpServletRequest request){
		validateCode = validateCodeService.get(id.toString());
		return new JsonResponse<ValidateCode>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, validateCode);
	}

	
	/**
	 * 
	 * @date 2018-05-25 13:03:49
	 * @Title: modifyValidateCodeDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param validateCode
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ValidateCode>
	 * @throws
	 */
	@RequestMapping(value="validateCodes/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<ValidateCode> modifyValidateCodeDetail(@PathVariable("id")Integer id, @RequestBody ValidateCode validateCode, HttpServletRequest request){
		validateCode.setId(id);
		validateCodeService.update(validateCode);
		return new JsonResponse<ValidateCode>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, validateCodeService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-25 13:03:49
	 * @Title: addValidateCode 
	 * @Description: 发送验证码
	 * @param @param validateCode
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<ValidateCode>
	 * @throws
	 */
	@RequestMapping(value="validateCodes", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> addValidateCode(@RequestBody ValidateCode validateCode, HttpServletRequest request){
		validateCodeService.insertOrUpdate(validateCode);
		validateCode.setSendTime(null);
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
	/**
	 * 
	 * @date 2018-05-25 13:03:49
	 * @Title: removeValidateCode 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="validateCodes/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeValidateCode(@PathVariable("id")Integer id, HttpServletRequest request){
		validateCodeService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

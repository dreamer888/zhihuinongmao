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
	
}

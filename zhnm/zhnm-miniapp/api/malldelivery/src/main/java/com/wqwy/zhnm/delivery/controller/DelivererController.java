/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.delivery.controller;

import com.github.pagehelper.Page;

import org.springframework.beans.BeanUtils;
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

import com.wqwy.zhnm.base.entity.Balance;
import com.wqwy.zhnm.base.entity.Deliverer;
import com.wqwy.zhnm.base.entity.DelivererDynamic;
import com.wqwy.zhnm.base.entity.Seller;
import com.wqwy.zhnm.base.entity.SellerBalance;
import com.wqwy.zhnm.base.entity.SellerDynamic;
import com.wqwy.zhnm.base.entity.ValidateCode;
import com.wqwy.zhnm.base.service.DelivererDynamicService;
import com.wqwy.zhnm.base.service.DelivererService;
import com.wqwy.zhnm.base.service.ValidateCodeService;
import com.wqwy.zhnm.delivery.base.BaseController;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.request.DelivererRegisterRequest;
import com.wqwy.zhnm.base.component.request.ForgotPasswordRequest;
import com.wqwy.zhnm.base.component.request.LoginRequest;
import com.wqwy.zhnm.base.component.request.SellerRegisterRequest;
import com.wqwy.zhnm.base.component.response.DelivererDetailResponse;
import com.wqwy.zhnm.base.component.response.SellerDetailResponse;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.component.utils.ValidateUtils;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * createTime: 2018-05-08 18:50:56
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class DelivererController extends BaseController {

	@Autowired
	private DelivererService  delivererService;
	
	@Autowired
	private DelivererDynamicService delivererDynamicService;
	
	@Autowired
	private ValidateCodeService validateCodeService;

	@RequestMapping(value="login", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererDetailResponse> login(@RequestBody LoginRequest loginComponent) {
		Deliverer deliverer = new Deliverer();
		deliverer.setAccount(loginComponent.getAccount());
		List<Deliverer> sList = delivererService.findList(deliverer);
		if (sList == null || sList.isEmpty())
			throw new BusinessException(ResultUtils.ACCOUNT_NOT_EXIST, ResultUtils.ACCOUNT_NOT_EXIST_MSG);
		if (!loginComponent.getPassword().equals(sList.get(0).getPassword()))
			throw new BusinessException(ResultUtils.PASSWORD_WRONG, ResultUtils.PASSWORD_WRONG_MSG);
		deliverer = sList.get(0);
		if (!deliverer.getStatus().equals(DefaultConstants.DelivererEnum.STATUS_NOMAL.getDelivererEnum()))
			throw new BusinessException(ResultUtils.ACCOUNT_STATUS_EXCEPTION, ResultUtils.ACCOUNT_STATUS_EXCEPTION_MSG);
		//登录后修改token并把新的token返回客户端
		String token = ValidateUtils.GetToken(loginComponent.getAccount(), loginComponent.getPassword());
		deliverer.setToken(token);
		delivererService.update(deliverer);
		//制空密码
		deliverer.setPassword(null);
		
		//配送人员动态数据
		DelivererDetailResponse delivererDetailComponent = new DelivererDetailResponse();
		DelivererDynamic delivererDynamic = new DelivererDynamic();
		delivererDynamic.setDelivererId(deliverer.getId());
		List<DelivererDynamic> sdList = delivererDynamicService.findList(delivererDynamic);
		if (sdList != null && !sdList.isEmpty())
			delivererDynamic = sdList.get(0);
		
		delivererDetailComponent.setDeliverer(deliverer);;
		delivererDetailComponent.setDelivererDynamic(delivererDynamic);
		return new JsonResponse<DelivererDetailResponse>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererDetailComponent);
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:50:56
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param deliverer
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<Deliverer>>
	 * @throws
	 */
	@RequestMapping(value="deliverers", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<Deliverer>> findByPage(Deliverer deliverer, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<Deliverer> queryResultList = delivererService.findListByPage(deliverer, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<Deliverer>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:50:56
	 * @Title: findDelivererDetail 
	 * @Description: TODO
	 * @param @param deliverer
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Deliverer>
	 * @throws
	 */
	@RequestMapping(value="deliverers/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Deliverer> findDelivererDetail(@PathVariable("id")Integer id, Deliverer deliverer, HttpServletRequest request){
		deliverer = delivererService.get(id.toString());
		return new JsonResponse<Deliverer>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, deliverer);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:50:56
	 * @Title: modifyDelivererDetail 
	 * @Description: 修改基本信息
	 * @param @param id
	 * @param @param deliverer
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Deliverer>
	 * @throws
	 */
	@RequestMapping(value="deliverers/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Deliverer> modifyDelivererDetail(@PathVariable("id")Integer id, @RequestBody Deliverer deliverer, HttpServletRequest request){
		deliverer.setId(id);
		deliverer.setCredit(null);
		delivererService.update(deliverer);
		return new JsonResponse<Deliverer>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @Title: modifySellerDetail  
	 * @Description: 修改密码  
	 * @date 26 May 2018 10:33:37 AM  
	 * @param @param id
	 * @param @param forgotPasswordRequest
	 * @param @param request
	 * @param @return  
	 * @return JsonResponse<Seller>  
	 * @throws
	 */
	@RequestMapping(value="deliverers/password", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Seller> modifySellerDetail(@RequestBody ForgotPasswordRequest forgotPasswordRequest, HttpServletRequest request){
		Deliverer deliverer = new Deliverer();
		deliverer.setAccount(forgotPasswordRequest.getPhone());
		List<Deliverer> sList = delivererService.findList(deliverer);
		if (sList==null || sList.isEmpty())
			throw new BusinessException(ResultUtils.ACCOUNT_NOT_EXIST, ResultUtils.ACCOUNT_NOT_EXIST_MSG);
		deliverer = sList.get(0);
		// 不是当前用户(token -> user -> account != forgotPasswordRequest.phone)
//		if (!seller.getAccount().equals(forgotPasswordRequest.getPhone()))
//			throw new BusinessException(ResultUtils.NOT_SELF_ACCOUNT, ResultUtils.NOT_SELF_ACCOUNT_MSG);
		ValidateCode vc = new ValidateCode();
		BeanUtils.copyProperties(forgotPasswordRequest, vc);
		vc.setCode(null);
		List<ValidateCode> vcList = validateCodeService.findList(vc);
		// 并未发送验证码
		if (vcList==null || vcList.isEmpty())
			throw new BusinessException(ResultUtils.NO_VERIFYCODE_AVALIABLE, ResultUtils.NO_VERIFYCODE_AVALIABLE_MSG);
		vc = vcList.get(0);
		// code错误
		if (!vc.getCode().equals(forgotPasswordRequest.getCode()))
			throw new BusinessException(ResultUtils.VERIFYCODE_FAIL, ResultUtils.VERIFYCODE_FAIL_MSG);
		// 验证码超时
		if (vc.getSendTime().getTime() + DefaultConstants.VALIDATE_CODE_VALID_TIME < new Date().getTime())
			throw new BusinessException(ResultUtils.VERIFYCODE_TIME_OUT, ResultUtils.VERIFYCODE_TIME_OUT_MSG);
		
		/*
		 * 修改密码
		 */
		deliverer.setPassword(forgotPasswordRequest.getPassword());
		String token = ValidateUtils.GetToken(forgotPasswordRequest.getPhone(), forgotPasswordRequest.getPassword());
		deliverer.setToken(token);
		delivererService.update(deliverer);
		return new JsonResponse<Seller>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:51:02
	 * @Title: addSeller 
	 * @Description: 商户注册
	 * @param @param seller
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<Seller>
	 * @throws
	 */
	@RequestMapping(value="register", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererDetailResponse> addDeliverer(@RequestBody DelivererRegisterRequest deliverer, HttpServletRequest request){
		/*
		 * validateCode校验
		 */
		ValidateCode vc = new ValidateCode();
		vc.setPhone(deliverer.getAccount());
		vc.setOperationType(deliverer.getOperationType());
		vc.setUserType(deliverer.getUserType());
		List<ValidateCode> vcList = validateCodeService.findList(vc);
		// 并未发送验证码
		if (vcList==null || vcList.isEmpty())
			throw new BusinessException(ResultUtils.NO_VERIFYCODE_AVALIABLE, ResultUtils.NO_VERIFYCODE_AVALIABLE_MSG);
		vc = vcList.get(0);
		// code错误
		if (!vc.getCode().equals(deliverer.getValidateCode()))
			throw new BusinessException(ResultUtils.VERIFYCODE_FAIL, ResultUtils.VERIFYCODE_FAIL_MSG);
		// 验证码超时
		if (vc.getSendTime().getTime() + DefaultConstants.VALIDATE_CODE_VALID_TIME < new Date().getTime())
			throw new BusinessException(ResultUtils.VERIFYCODE_TIME_OUT, ResultUtils.VERIFYCODE_TIME_OUT_MSG);
		
		return new JsonResponse<DelivererDetailResponse>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererService.insert(deliverer));
	}
	
}

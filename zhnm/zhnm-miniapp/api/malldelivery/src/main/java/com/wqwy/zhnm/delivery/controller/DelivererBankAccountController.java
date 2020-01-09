/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.component.PageJsonResponse;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.DelivererBankAccount;
import com.wqwy.zhnm.base.service.DelivererBankAccountService;
import com.wqwy.zhnm.delivery.base.BaseController;

/**
 * createTime: 2018-05-08 18:50:57
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class DelivererBankAccountController extends BaseController {

	@Autowired
	private DelivererBankAccountService  delivererBankAccountService;

	/**
	 * 
	 * @date 2018-05-08 18:50:57
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param delivererBankAccount
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<DelivererBankAccount>>
	 * @throws
	 */
	@RequestMapping(value="delivererBankAccounts", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<DelivererBankAccount>> findByPage(DelivererBankAccount delivererBankAccount, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<DelivererBankAccount> queryResultList = delivererBankAccountService.findListByPage(delivererBankAccount, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<DelivererBankAccount>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-08 18:50:57
	 * @Title: findDelivererBankAccountDetail 
	 * @Description: TODO
	 * @param @param delivererBankAccount
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererBankAccount>
	 * @throws
	 */
	@RequestMapping(value="delivererBankAccounts/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererBankAccount> findDelivererBankAccountDetail(@PathVariable("id")Integer id, DelivererBankAccount delivererBankAccount, HttpServletRequest request){
		delivererBankAccount = delivererBankAccountService.get(id.toString());
		return new JsonResponse<DelivererBankAccount>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererBankAccount);
	}

	
	/**
	 * 
	 * @date 2018-05-08 18:50:57
	 * @Title: modifyDelivererBankAccountDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param delivererBankAccount
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererBankAccount>
	 * @throws
	 */
	@RequestMapping(value="delivererBankAccounts/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererBankAccount> modifyDelivererBankAccountDetail(@PathVariable("id")Integer id, @RequestBody DelivererBankAccount delivererBankAccount, HttpServletRequest request){
		delivererBankAccount.setId(id);
		delivererBankAccountService.update(delivererBankAccount);
		return new JsonResponse<DelivererBankAccount>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererBankAccountService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-08 18:50:57
	 * @Title: addDelivererBankAccount 
	 * @Description: TODO
	 * @param @param delivererBankAccount
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<DelivererBankAccount>
	 * @throws
	 */
	@RequestMapping(value="delivererBankAccounts", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<DelivererBankAccount> addDelivererBankAccount(@RequestBody DelivererBankAccount delivererBankAccount, HttpServletRequest request){
		delivererBankAccountService.insert(delivererBankAccount);
		return new JsonResponse<DelivererBankAccount>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, delivererBankAccountService.findList(delivererBankAccount).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-08 18:50:57
	 * @Title: removeDelivererBankAccount 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="delivererBankAccounts/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeDelivererBankAccount(@PathVariable("id")Integer id, HttpServletRequest request){
		delivererBankAccountService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

/**
 * Copyright (c) 2015-2017 <a href="">caishigou</a> All rights reserved.
 */
package com.wqwy.zhnm.seller.controller;

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
import com.wqwy.zhnm.base.entity.SysUser;
import com.wqwy.zhnm.base.service.SysUserService2;
import com.wqwy.zhnm.seller.base.BaseController;
import com.wqwy.zhnm.base.component.utils.ResultUtils;

/**
 * createTime: 2018-05-05 17:58:46
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService2  sysUserService;

	/**
	 * 
	 * @date 2018-05-05 17:58:46
	 * @Title: findByPage 
	 * @Description: TODO
	 * @param @param sysUser
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<SysUser>>
	 * @throws
	 */
	@RequestMapping(value="sysUsers", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public PageJsonResponse<List<SysUser>> findByPage(SysUser sysUser, Pagenation pagenation, HttpServletRequest request, Model model) {
		Page<SysUser> queryResultList = sysUserService.findListByPage(sysUser, pagenation);
		pagenation.setTotal(queryResultList.getTotal());
		return new PageJsonResponse<List<SysUser>>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, queryResultList, pagenation);
	}


	/**
	 * 
	 * @date 2018-05-05 17:58:46
	 * @Title: findSysUserDetail 
	 * @Description: TODO
	 * @param @param sysUser
	 * @param @param pagenation
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SysUser>
	 * @throws
	 */
	@RequestMapping(value="sysUsers/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SysUser> findSysUserDetail(@PathVariable("id")Integer id, SysUser sysUser, HttpServletRequest request){
		sysUser = sysUserService.get(id.toString());
		return new JsonResponse<SysUser>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sysUser);
	}

	
	/**
	 * 
	 * @date 2018-05-05 17:58:46
	 * @Title: modifySysUserDetail 
	 * @Description: TODO
	 * @param @param id
	 * @param @param sysUser
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SysUser>
	 * @throws
	 */
	@RequestMapping(value="sysUsers/{id}", method=RequestMethod.PATCH, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SysUser> modifySysUserDetail(@PathVariable("id")Integer id, @RequestBody SysUser sysUser, HttpServletRequest request){
		sysUser.setUserId(id.toString());
		sysUserService.update(sysUser);
		return new JsonResponse<SysUser>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sysUserService.get(id.toString()));
	}
	
	
	/**
	 * 
	 * @date 2018-05-05 17:58:46
	 * @Title: addSysUser 
	 * @Description: TODO
	 * @param @param sysUser
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<SysUser>
	 * @throws
	 */
	@RequestMapping(value="sysUsers", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<SysUser> addSysUser(@RequestBody SysUser sysUser, HttpServletRequest request){
		sysUserService.insert(sysUser);
		return new JsonResponse<SysUser>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sysUserService.findList(sysUser).get(0));
	}
	
	/**
	 * 
	 * @date 2018-05-05 17:58:46
	 * @Title: removeSysUser 
	 * @Description: TODO
	 * @param @param id
	 * @param @param request
	 * @param @return
	 * @return JsonResponse<>
	 * @throws
	 */
	@RequestMapping(value="sysUsers/{id}", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> removeSysUser(@PathVariable("id")Integer id, HttpServletRequest request){
		sysUserService.delete(id.toString());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
}

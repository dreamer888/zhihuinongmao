/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */
package com.wqwy.zhnm.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.request.VersionRequest;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.entity.Version;
import com.wqwy.zhnm.base.service.VersionService;

/**
 * createTime: 2018-07-18 13:03:49
 * @author seven
 * @version
 */
@RestController
@RequestMapping("/v1/")
public class VersionController {
    
	private static final Logger logger = LoggerFactory.getLogger(VersionController.class);
	
	@Autowired
	private VersionService versionService;

	/**
	 * 
	 * @date 2018-05-25 13:03:49
	 * @Title: getVersions 
	 * @Description: TODO
	 * @param @param version
	 * @param @param request
	 * @param @return
	 * @return PageJsonResponse<List<ValidateCode>>
	 * @throws
	 */
	@RequestMapping(value="getVersions", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<Version> getVersions(VersionRequest versionRequest, HttpServletRequest request){
		logger.info("version-->start");
		
		Assert.notNull(versionRequest.getAppType(), "appType not null");
		Assert.notNull(versionRequest.getVersionCode(), "versionCode not null");
		
		List<Version> list = versionService.findByType(versionRequest.getAppType());
		Version newVersion= list.get(0);
		Integer oldCode = Integer.parseInt(versionRequest.getVersionCode());
		Integer newCode = Integer.parseInt(newVersion.getVersionCode());
		
		//1、强制升级  2、需要更新  3、无需更新
		if(newCode==oldCode){
			newVersion.setLastForce(3);  
		}
		
		if(newCode>oldCode){
			if(newVersion.getLastForce()==1){
				return new JsonResponse<Version>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, newVersion);
			}else {
				newVersion.setLastForce(2);
			}
		}
		
		logger.info("version-->"+newVersion.toString());
		return new JsonResponse<Version>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, newVersion);
	}
	
}

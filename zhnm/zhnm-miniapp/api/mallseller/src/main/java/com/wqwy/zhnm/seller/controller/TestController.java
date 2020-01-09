package com.wqwy.zhnm.seller.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wqwy.zhnm.base.component.component.JsonResponse;
import com.wqwy.zhnm.base.component.request.QuartzJobOperationRequest;
import com.wqwy.zhnm.base.component.utils.DateUtils;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.service.ShopCategoryService;
import com.wqwy.zhnm.base.service.base.AboutOrderService;
import com.wqwy.zhnm.base.service.base.QuartzManager;
import com.wqwy.zhnm.base.service.job.MyJob;
import com.wqwy.zhnm.seller.config.SellerJobAfterContextRefreshedService;

@RestController
@RequestMapping("/v1/")
public class TestController {

	@Autowired
	private QuartzManager quartzManager;
	
	public static String JOB_NAME = "job_groupPurchase_";
	public static String TRIGGER_NAME = "trigger_groupPurchase_";
	public static String JOB_GROUP_NAME = "job_lawstore_groupPurchase";
	public static String TRIGGER_GROUP_NAME = "trigger_lawstore_groupPurchase";
	
	@RequestMapping(value="quartzTest1/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> quartzTest1(@PathVariable("id")Integer id, HttpServletRequest request){
//		quartzManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron, dataLoadMap);
		Date d = new Date(new Date().getTime() + 10000);
		String triggerTimeString = DateUtils.GetCron(d);
		Map<String, String> dataLoadMap = new HashMap<String, String>();
		dataLoadMap.put(id.toString(), "id is : " + id);
		quartzManager.addJob(JOB_NAME + id, JOB_GROUP_NAME, TRIGGER_NAME + id,
				TRIGGER_GROUP_NAME, MyJob.class, triggerTimeString, dataLoadMap);
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
	@RequestMapping(value="quartzTest2/{id}", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> quartzTest2(@PathVariable("id")Integer id, HttpServletRequest request){
//		quartzManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron, dataLoadMap);
		Date d = new Date(new Date().getTime() - 10000);
		String triggerTimeString = DateUtils.GetCron(d);
		Map<String, String> dataLoadMap = new HashMap<String, String>();
		dataLoadMap.put(id.toString(), "id is : " + id);
		quartzManager.addJob(JOB_NAME + id, JOB_GROUP_NAME, TRIGGER_NAME + id,
				TRIGGER_GROUP_NAME, MyJob.class, triggerTimeString, dataLoadMap);
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
	@Autowired
	private AboutOrderService aboutOrderService;
	
	@RequestMapping(value = { "afterOrderPayedTest/{id}", "/", "/test/afterOrderPayedTest/{id}" } , method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> apiAfterOrderCreateTest(@PathVariable("id")String id, HttpServletRequest request){
//		aboutOrderService.doAfterUserCreateOnlineOrder(id);
		aboutOrderService.doAfterUserPayedOnlineOrder(id);
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
	@RequestMapping(value="quartzJobTest1", method=RequestMethod.DELETE, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> apiAfterOrderCreateTest(@RequestBody QuartzJobOperationRequest quartzJobOperationRequest, HttpServletRequest request){
//		aboutOrderService.doAfterUserCreateOnlineOrder(id);
		quartzManager.removeJob(quartzJobOperationRequest.getJobName(), quartzJobOperationRequest.getJobGroupName(), quartzJobOperationRequest.getTriggerName(), quartzJobOperationRequest.getTriggerGroupName());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG);
	}
	
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	@Autowired
	private SellerJobAfterContextRefreshedService sellerJobAfterContextRefreshedService;
	
	@RequestMapping(value="categoryRefresh", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE+";charset=utf-8"})
	public JsonResponse<?> apicategoryTest(HttpServletRequest request){
//		aboutOrderService.doAfterUserCreateOnlineOrder(id);
//		quartzManager.removeJob(quartzJobOperationRequest.getJobName(), quartzJobOperationRequest.getJobGroupName(), quartzJobOperationRequest.getTriggerName(), quartzJobOperationRequest.getTriggerGroupName());
		return new JsonResponse<>(ResultUtils.SUCCESS, ResultUtils.SUCCESS_MSG, sellerJobAfterContextRefreshedService.getShopCategoryLevelImmediately());
	}
}

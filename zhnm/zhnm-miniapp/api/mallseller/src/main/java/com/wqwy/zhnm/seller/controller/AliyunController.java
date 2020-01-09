package com.wqwy.zhnm.seller.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.wqwy.zhnm.base.component.constant.AliyunApiConstants;
import com.wqwy.zhnm.base.component.utils.ReadUtils;

import net.sf.json.JSONObject;

@Controller
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
@RequestMapping("/v1/aliyun/oss")
public class AliyunController {

	private String policy;
	
	@RequestMapping(value = "/securityToken", method = RequestMethod.GET)
	public void securityToken(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String data = ReadJson(new ClassPathResource("policy/config.json").getInputStream());
//
//		System.out.println("用户输入url:" + data);
//		if (data.equals("")) {
//			response(request, response, "./config.json is empty or not found");
//			return;
//		}
//		System.out.println(data);
//		JSONObject jsonObj = JSONObject.fromObject(data);
//
//		// 只有 RAM用户（子账号）才能调用 AssumeRole 接口
//		// 阿里云主账号的AccessKeys不能用于发起AssumeRole请求
//		// 请首先在RAM控制台创建一个RAM用户，并为这个用户创建AccessKeys
//		String accessKeyId = jsonObj.getString("AccessKeyID");
//		String accessKeySecret = jsonObj.getString("AccessKeySecret");
//
//		// RoleArn 需要在 RAM 控制台上获取
//		String roleArn = jsonObj.getString("RoleArn");
//		long durationSeconds = jsonObj.getLong("TokenExpireTime");
		if (this.policy== null)
			policy = ReadUtils.ReadJson(new ClassPathResource(AliyunApiConstants.POLICY_FILE_PATH).getInputStream());
		// RoleSessionName 是临时Token的会话名称，自己指定用于标识你的用户，主要用于审计，或者用于区分Token颁发给谁
		// 但是注意RoleSessionName的长度和规则，不要有空格，只能有'-' '_' 字母和数字等字符
		// 具体规则请参考API文档中的格式要求
		String roleSessionName = "wqwy_seller";

		// 此处必须为 HTTPS
		ProtocolType protocolType = ProtocolType.HTTPS;

		try {
			final AssumeRoleResponse stsResponse = assumeRole(AliyunApiConstants.ALI_OSS_RAM_KEY, AliyunApiConstants.ALI_OSS_RAM_SECRET, AliyunApiConstants.ALI_OSS_ROLE_ARN, roleSessionName,
					this.policy, protocolType, AliyunApiConstants.ALI_OSS_TOKEN_EXPIRE);

			Map<String, String> respMap = new LinkedHashMap<String, String>();
			respMap.put("status", "200");
			respMap.put("endPoint", AliyunApiConstants.REGION);
			respMap.put("bucketName", AliyunApiConstants.BUCKETNAME);
			respMap.put("accessKeyId", stsResponse.getCredentials().getAccessKeyId());
			respMap.put("accessKeySecret", stsResponse.getCredentials().getAccessKeySecret());
			respMap.put("securityToken", stsResponse.getCredentials().getSecurityToken());
			respMap.put("expiration", stsResponse.getCredentials().getExpiration());
			// respMap.put("afterSales", PicturePrefixCofig.AFTERSALES);
			// respMap.put("userPhoto", PicturePrefixCofig.USERPHOTO);
			// respMap.put("comment", PicturePrefixCofig.COMMENT);
			// respMap.put("picturePrefixCofig", PicturePrefixCofig.PICTUREPREFIX);
			// respMap.put("feedback", PicturePrefixCofig.FEEDBACK);
			JSONObject ja1 = JSONObject.fromObject(respMap);
			response(request, response, ja1.toString());

		} catch (ClientException e) {

			Map<String, String> respMap = new LinkedHashMap<String, String>();
			respMap.put("status", e.getErrCode());
			respMap.put("endPoint", "");
			respMap.put("bucketName", "");
			respMap.put("accessKeyId", "");
			respMap.put("accessKeySecret", "");
			respMap.put("securityToken", "");
			respMap.put("expiration", "");
			// respMap.put("afterSales", PicturePrefixCofig.AFTERSALES);
			// respMap.put("userPhoto", PicturePrefixCofig.USERPHOTO);
			// respMap.put("comment", PicturePrefixCofig.COMMENT);
			// respMap.put("picturePrefixCofig", PicturePrefixCofig.PICTUREPREFIX);
			// respMap.put("feedback", PicturePrefixCofig.FEEDBACK);
			JSONObject ja1 = JSONObject.fromObject(respMap);
			response(request, response, ja1.toString());
		}

	}

	// 目前只有"cn-hangzhou"这个region可用, 不要使用填写其他region的值
	// oss-cn-shenzhen.aliyuncs.com
	public static final String REGION = "cn-hangzhou";
	public static final String STS_API_VERSION = "2015-04-01";

	protected AssumeRoleResponse assumeRole(String accessKeyId, String accessKeySecret, String roleArn,
			String roleSessionName, String policy, ProtocolType protocolType, long durationSeconds)
			throws ClientException {
		try {
			// 创建一个 Aliyun Acs Client, 用于发起 OpenAPI 请求
			IClientProfile profile = DefaultProfile.getProfile(REGION, accessKeyId, accessKeySecret);
//			profile.setLocationConfig("cn-hangzhou", "cn-hangzhou", "oss-cn-shenzhen.aliyuncs.com");
			DefaultAcsClient client = new DefaultAcsClient(profile);

			// 创建一个 AssumeRoleRequest 并设置请求参数
			final AssumeRoleRequest request = new AssumeRoleRequest();
			request.setVersion(STS_API_VERSION);
			request.setMethod(MethodType.POST);
			request.setProtocol(protocolType);

			request.setRoleArn(roleArn);
			request.setRoleSessionName(roleSessionName);
			request.setPolicy(policy);
			request.setRegionId("cn-shenzhen");
			request.setDurationSeconds(durationSeconds);

			// 发起请求，并得到response
			final AssumeRoleResponse response = client.getAcsResponse(request);

			return response;
		} catch (ClientException e) {
			throw e;
		}
	}
	
	private void response(HttpServletRequest request, HttpServletResponse response, String results) throws IOException {
		String callbackFunName = request.getParameter("callback");
		if (callbackFunName==null || callbackFunName.equalsIgnoreCase(""))
			response.getWriter().println(results);
		else
			response.getWriter().println(callbackFunName + "( "+results+" )");
		response.setStatus(HttpServletResponse.SC_OK);
        response.flushBuffer();
	}
	
}

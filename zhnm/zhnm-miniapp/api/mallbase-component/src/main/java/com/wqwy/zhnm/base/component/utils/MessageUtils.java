package com.wqwy.zhnm.base.component.utils;

import com.aliyuncs.exceptions.ClientException;
import com.wqwy.zhnm.base.component.utils.alisms.SmsUtils;
import com.wqwy.zhnm.base.entity.ValidateCode;

public class MessageUtils {

	/**
	 * @throws ClientException 
	 * 
	 * @Title: DoSendPhoneMessageToUser  
	 * @Description: 根据操作类型 发送消息到指定手机号码  
	 * @date 25 May 2018 1:47:32 PM  
	 * @param @param phone
	 * @param @param operateType  
	 * @return void  
	 * @throws
	 */
	public static void DoSendValidateCodePhoneMessageToUser(ValidateCode validateCode) throws ClientException {
		String phone = validateCode.getPhone();
		String code = validateCode.getCode();
		ValidateCode.OperationTypeEnum operateType = validateCode.getOperationType();
		// TODO
		SmsUtils.sendSmsForValidateCode(phone, code);
	}
	
}

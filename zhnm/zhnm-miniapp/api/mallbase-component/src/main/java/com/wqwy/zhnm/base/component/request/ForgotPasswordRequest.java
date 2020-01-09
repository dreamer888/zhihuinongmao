package com.wqwy.zhnm.base.component.request;

import com.wqwy.zhnm.base.entity.ValidateCode.OperationTypeEnum;
import com.wqwy.zhnm.base.entity.ValidateCode.UserTypeEnum;

public class ForgotPasswordRequest {

	private String phone; 
	
	private String password;
	
	private String code;
	
	/**
     * 操作类型
     */
    private OperationTypeEnum operationType;
    
    /**
     * 发送请求方类型
     */
    private UserTypeEnum userType;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public OperationTypeEnum getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationTypeEnum operationType) {
		this.operationType = operationType;
	}

	public UserTypeEnum getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}
	
}

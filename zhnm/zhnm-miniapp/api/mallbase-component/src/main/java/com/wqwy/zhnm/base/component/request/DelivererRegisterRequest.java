package com.wqwy.zhnm.base.component.request;

import com.wqwy.zhnm.base.entity.Deliverer;
import com.wqwy.zhnm.base.entity.ValidateCode.OperationTypeEnum;
import com.wqwy.zhnm.base.entity.ValidateCode.UserTypeEnum;

public class DelivererRegisterRequest extends Deliverer {

	/**
	 * 验证码值
	 */
	private String validateCode;
	
	/**
     * 操作类型
     */
    private OperationTypeEnum operationType;
    
    /**
     * 发送请求方类型
     */
    private UserTypeEnum userType;

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
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

	@Override
	public String toString() {
		return "DelivererRegisterRequest [validateCode=" + validateCode + ", operationType=" + operationType
				+ ", userType=" + userType + ", toString()=" + super.toString() + "]";
	}
    
}

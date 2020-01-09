package com.wqwy.zhnm.base.component.request;

import com.wqwy.zhnm.base.entity.Seller;
import com.wqwy.zhnm.base.entity.ValidateCode.OperationTypeEnum;
import com.wqwy.zhnm.base.entity.ValidateCode.UserTypeEnum;

public class SellerRegisterRequest extends Seller {

	@Deprecated
	private Integer balanceId;
	
	private String balanceImei;
	
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

	public Integer getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(Integer balanceId) {
		this.balanceId = balanceId;
	}

	public String getBalanceImei() {
		return balanceImei;
	}

	public void setBalanceImei(String balanceImei) {
		this.balanceImei = balanceImei;
	}

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
		return "SellerRegisterRequest [balanceId=" + balanceId + ", validateCode=" + validateCode + ", operationType="
				+ operationType + ", userType=" + userType + ", toString()=" + super.toString() + "]";
	}

}

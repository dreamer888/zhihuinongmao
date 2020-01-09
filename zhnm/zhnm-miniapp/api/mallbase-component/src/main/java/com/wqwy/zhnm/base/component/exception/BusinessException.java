package com.wqwy.zhnm.base.component.exception;

import com.wqwy.zhnm.base.component.utils.ResultUtils;

/**
 * 
 * @author seven
 *
 */
public class BusinessException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1962836176178650118L;
	
	private Integer code;
	
	private Object data;
	
	public BusinessException() {
		super(ResultUtils.FAIL_MSG);
    	this.code = ResultUtils.FAIL;
	}
    
	public BusinessException(Integer code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }
	
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
    	super(message);
    	this.code = ResultUtils.DEFAULT_EXCEPTION_CODE;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
}

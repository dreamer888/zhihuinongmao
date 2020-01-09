package com.wqwy.zhnm.base.component.exception;

import com.wqwy.zhnm.base.component.utils.ResultUtils;

public class WechatException extends RuntimeException {

	/**  
	 * @Fields field:field:{todo}  
	 */
	private static final long serialVersionUID = 1L;

	public WechatException() {
		super(ResultUtils.FAIL_MSG);
	}
	
	public WechatException(String message) {
    	super(message);
    }
	
}

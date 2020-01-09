package com.wqwy.zhnm.base.component.component;

public class JsonResponseForMQ<T> extends JsonResponse<T> {

	public JsonResponseForMQ(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
}

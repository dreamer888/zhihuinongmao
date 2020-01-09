package com.wqwy.zhnm.base.component.component;

public class PageJsonResponse<T> extends JsonResponse<T>{
	
	Pagenation pagenation;
	
	public Pagenation getPagenation() {
		return pagenation;
	}

	public void setPagenation(Pagenation pagenation) {
		this.pagenation = pagenation;
	}
	
	public PageJsonResponse() {
		super();
	}

	public PageJsonResponse(Integer code, String message, T data, Pagenation pagenation) { 
		this.code = code;
		this.message = message;
		this.data = data;
		this.pagenation =pagenation;
	}
	
}

package com.wqwy.zhnm.base.component.request;

public class UserIndexRequest {

	/*
	 * 传递菜市场Id
	 * 优先级大于location
	 */
	private Integer marketId;
	
	/*
	 * 位置经纬度
	 */
	private String location;
	
	/**
	 * @deprecated: 暂时不支持定位参数中直接传递位置字符串 
	 */
	@Deprecated
	private String locationString;

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationString() {
		return locationString;
	}

	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}
	
}

package com.wqwy.zhnm.base.component.dto;

public class MarketDTO{

    /**
     * 是否配送范围内
     */
    private boolean flag;
    
	/**
     * 经纬度
     */
    private String Location;
    
	/**
     * 市场ID
     */
    private Integer marketId;
    
    public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public Integer getMarketId() {
		return marketId;
	}

	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}

	
}

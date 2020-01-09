/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-08 18:51:01
 * @author seven
 * @version
 */
public class Market{

    /**
     * 
     */
    private Integer id;

    /**
     * 农贸市场名称
     */
    private String marketName;

    /**
     * 省
     */
    private String marketProvince;

    /**
     * 市
     */
    private String marketCity;

    /**
     * 区
     */
    private String marketDistrict;

    /**
     * 详细地址
     */
    private String marketAddress;

    /**
     * 坐标，格式为：经度,纬度
     */
    private String marketCoords;

    /**
     * 市场开启时间
     */
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private String marketOpendTime;

    /**
     * 市场关闭时间
     */
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private String marketClosedTime;

    /**
     * 添加时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date updateTime;

    /**
     * 市场图片
     */
    private String marketImg;

    /**
     * 市场状态：0正常，1关闭
     */
    private Integer marketStatus;

    /**
     * 描述
     */
    private String marketDesc;

    /**
     * 高德云图id
     */
    private Integer geodeId;

    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }

    public void setMarketName(String value){
        this.marketName = value;
    }

    public String getMarketName(){
        return this.marketName;
    }

    public void setMarketProvince(String value){
        this.marketProvince = value;
    }

    public String getMarketProvince(){
        return this.marketProvince;
    }

    public void setMarketCity(String value){
        this.marketCity = value;
    }

    public String getMarketCity(){
        return this.marketCity;
    }

    public void setMarketDistrict(String value){
        this.marketDistrict = value;
    }

    public String getMarketDistrict(){
        return this.marketDistrict;
    }

    public void setMarketAddress(String value){
        this.marketAddress = value;
    }

    public String getMarketAddress(){
        return this.marketAddress;
    }

    public void setMarketCoords(String value){
        this.marketCoords = value;
    }

    public String getMarketCoords(){
        return this.marketCoords;
    }

    public String getMarketOpendTime() {
		return marketOpendTime;
	}

	public void setMarketOpendTime(String marketOpendTime) {
		this.marketOpendTime = marketOpendTime;
	}

	public String getMarketClosedTime() {
		return marketClosedTime;
	}

	public void setMarketClosedTime(String marketClosedTime) {
		this.marketClosedTime = marketClosedTime;
	}

	public void setCreateTime(java.util.Date value){
        this.createTime = value;
    }

    public java.util.Date getCreateTime(){
        return this.createTime;
    }

    public void setUpdateTime(java.util.Date value){
        this.updateTime = value;
    }

    public java.util.Date getUpdateTime(){
        return this.updateTime;
    }

    public void setMarketImg(String value){
        this.marketImg = value;
    }

    public String getMarketImg(){
        return this.marketImg;
    }

    public void setMarketStatus(Integer value){
        this.marketStatus = value;
    }

    public Integer getMarketStatus(){
        return this.marketStatus;
    }

    public void setMarketDesc(String value){
        this.marketDesc = value;
    }

    public String getMarketDesc(){
        return this.marketDesc;
    }

	public Integer getGeodeId() {
		return geodeId;
	}

	public void setGeodeId(Integer geodeId) {
		this.geodeId = geodeId;
	}

}

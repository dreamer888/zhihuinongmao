/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-23 12:05:29
 * @author seven
 * @version
 */
public class HelpAndFeedback{

    /**
     * 
     */
    private Integer id;

    /**
     * 发送对象id
     */
    private Integer objectId;

    /**
     * 发送对象类型: 1.用户 2.商户 3.配送员
     */
    private Integer objectType;

    /**
     * 标题
     */
    private String title;

    /**
     * 具体内容
     */
    private String content;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private java.util.Date createTime;


    public void setId(Integer value){
        this.id = value;
    }

    public Integer getId(){
        return this.id;
    }

    public void setObjectId(Integer value){
        this.objectId = value;
    }

    public Integer getObjectId(){
        return this.objectId;
    }

    public void setObjectType(Integer value){
        this.objectType = value;
    }

    public Integer getObjectType(){
        return this.objectType;
    }

    public void setTitle(String value){
        this.title = value;
    }

    public String getTitle(){
        return this.title;
    }

    public void setContent(String value){
        this.content = value;
    }

    public String getContent(){
        return this.content;
    }

    public void setCreateTime(java.util.Date value){
        this.createTime = value;
    }

    public java.util.Date getCreateTime(){
        return this.createTime;
    }

}

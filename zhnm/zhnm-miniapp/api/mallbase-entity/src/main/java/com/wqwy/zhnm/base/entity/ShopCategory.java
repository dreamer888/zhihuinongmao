/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-05-09 11:52:14
 * @author seven
 * @version
 */
public class ShopCategory{

    /**
     * 
     */
    private String categoryId;

    /**
     * 
     */
    private String categoryName;

    /**
     * 
     */
    private String categoryEnName;

    /**
     * 
     */
    private String categoryImg;

    /**
     * 
     */
    private String superId;

    /**
     * 排序
     */
    private Integer sort;


    public void setCategoryId(String value){
        this.categoryId = value;
    }

    public String getCategoryId(){
        return this.categoryId;
    }

    public void setCategoryName(String value){
        this.categoryName = value;
    }

    public String getCategoryName(){
        return this.categoryName;
    }

    public void setCategoryEnName(String value){
        this.categoryEnName = value;
    }

    public String getCategoryEnName(){
        return this.categoryEnName;
    }

    public void setCategoryImg(String value){
        this.categoryImg = value;
    }

    public String getCategoryImg(){
        return this.categoryImg;
    }

    public void setSuperId(String value){
        this.superId = value;
    }

    public String getSuperId(){
        return this.superId;
    }

    public void setSort(Integer value){
        this.sort = value;
    }

    public Integer getSort(){
        return this.sort;
    }

}

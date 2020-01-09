/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * createTime: 2018-06-01 14:12:29
 * @author seven
 * @version
 */
public class ShopUser{

    /**
     * 
     */
    private String userId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String username;

    /**
     * 等级
     */
    private String level;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 注册时间
     */
    private String addtime;

    /**
     * 
     */
    private String openid;

    /**
     * 积分
     */
    private String integralCount;

    /**
     * 推荐人
     */
    private String recommend;

    /**
     * 
     */
    private String alipayAccount;

    /**
     * 
     */
    private String alipayName;

    /**
     * 全平台唯一id
     */
    private String unionid;


    public void setUserId(String value){
        this.userId = value;
    }

    public String getUserId(){
        return this.userId;
    }

    public void setPhone(String value){
        this.phone = value;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPassword(String value){
        this.password = value;
    }

    public String getPassword(){
        return this.password;
    }

    public void setUsername(String value){
        this.username = value;
    }

    public String getUsername(){
        return this.username;
    }

    public void setLevel(String value){
        this.level = value;
    }

    public String getLevel(){
        return this.level;
    }

    public void setHeadImg(String value){
        this.headImg = value;
    }

    public String getHeadImg(){
        return this.headImg;
    }

    public void setAddtime(String value){
        this.addtime = value;
    }

    public String getAddtime(){
        return this.addtime;
    }

    public void setOpenid(String value){
        this.openid = value;
    }

    public String getOpenid(){
        return this.openid;
    }

    public void setIntegralCount(String value){
        this.integralCount = value;
    }

    public String getIntegralCount(){
        return this.integralCount;
    }

    public void setRecommend(String value){
        this.recommend = value;
    }

    public String getRecommend(){
        return this.recommend;
    }

    public void setAlipayAccount(String value){
        this.alipayAccount = value;
    }

    public String getAlipayAccount(){
        return this.alipayAccount;
    }

    public void setAlipayName(String value){
        this.alipayName = value;
    }

    public String getAlipayName(){
        return this.alipayName;
    }

    public void setUnionid(String value){
        this.unionid = value;
    }

    public String getUnionid(){
        return this.unionid;
    }

}

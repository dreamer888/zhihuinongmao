<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--底部导航-->
<div class="foot-black"></div>
<div class="weui-tabbar wy-foot-menu">
  <a href="index" class="weui-tabbar__item">
    <div class="weui-tabbar__icon foot-menu-home"></div>
    <p class="weui-tabbar__label">首页</p>
  </a>
  <a href="category/list" class="weui-tabbar__item weui-bar__item--on">
    <div class="weui-tabbar__icon foot-menu-list"></div>
    <p class="weui-tabbar__label">分类</p>
  </a>
  <a href="cart/tolist" class="weui-tabbar__item" id="c_num">
   <c:if test="${cart_count!=0&&!empty cart_count }"><span class="weui-badge" style="position: absolute;top: -.4em;right: 1em;" id="cart_count">${cart_count}</span></c:if>
    <div class="weui-tabbar__icon foot-menu-cart"></div>
    <p class="weui-tabbar__label">购物车</p>
  </a>
  <a href="center/index" class="weui-tabbar__item">
    <div class="weui-tabbar__icon foot-menu-member"></div>
    <p class="weui-tabbar__label">我的</p>
  </a>
</div>

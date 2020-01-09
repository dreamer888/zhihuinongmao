<%@page import="java.net.URL"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
<base href="<%=basePath%>">    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
<link href="static/css/showTip.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="static/js/showTip.js"></script>
</head>
<body ontouchstart id="wrap">
<header class="wy-header">
  <div class="wy-header-icon-back"><span onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">登录</div>
</header>
<!--主体-->
<div class="login-box">

  	<div class="lg-title">欢迎登录商城</div>
    <div class="login-form">
    	<form action="app/to_checklogin" method="post" id="Form">
        	<div class="login-user-name common-div">
            	<span class="eamil-icon common-icon">
                	<img src="static/images/eamil.png" />
                </span>
                <input type="tel" name="phone" id="phone" value="" placeholder="请输入您的手机号" /> 
                <input type="hidden" name="url" id="url" value="${pd.url}" />         
            </div>
            <div class="login-user-pasw common-div">
            	<span class="pasw-icon common-icon">
                	<img src="static/images/password.png" />
                </span>
                <input type="password" name="password" id="password" value=""  placeholder="请输入您的密码" />        
            </div>
            <a href="JavaScript:login();" class="login-btn common-div">登录</a>
            <a href="app/wxlogin?url=${pd.url}" class="login-oth-btn common-div" id="wl">微信登录</a>
        </form>
    </div>
    <div class="forgets">
    	<a href="app/to_forget">忘记密码？</a>
        <a href="app/to_regist">免费注册</a>
    </div>
</div>
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/js/jquery-weui.js"></script>
<script>
$(function(){
	//判断是否微信浏览器
	 var ua = navigator.userAgent.toLowerCase();  
	 if(ua.match(/MicroMessenger/i)!="micromessenger") { 
	    	$('#wl').hide()
	 }
	 //提示
	 var result ='${pd.result}';
	 if(result!=null&&result!=''){
	 if(result==-1){
		 showTip("用户不存在，请注册！");
	 }
	 else if(result==-2){
		 showTip("请输入手机号！");
	 }
	 else if(result==0){
		 showTip("密码错误！");
	 }
	 }
})
function login(){
	var phone =$('#phone').val();
	var password =$('#password').val();
	if(phone==''){
		return ;
	}
	$('#Form').submit();
	/* $.showLoading();
	var phone =$('#phone').val();
	var password =$('#password').val();
	$.ajax({
		url:'app/to_checklogin',
		type:'post',
		data:{phone:phone,password:password},
		success:function(data){
			$.hideLoading();
			if(data.result==1){
				$.toast(data.message);
				setTimeout('location.href="'+data.url+'"', 2000);
			}
			else{
				$.alert(data.message);
			}
		}
	}) */
}	
</script>
</body>
</html>

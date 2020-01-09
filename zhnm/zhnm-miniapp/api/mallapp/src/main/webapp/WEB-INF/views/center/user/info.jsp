<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
<title>会员中心</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
<style>

.header{
text-align: center;
padding: 10px 0
}
.header img{
height: 82px;
width: 82px
}
</style>
</head>
<body ontouchstart>
<header class="wy-header">
  <div class="wy-header-icon-back"><span onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">手机注册</div>
</header>
<!--主体-->
<div class='weui-content'>
<div class="header">
<div id="img_upload">
<c:if test="${empty shopUser.head_img}">
<img class="weui-media-box__thumb radius" src="static/upload/headimg.jpg" alt="">
</c:if>
<c:if test="${!empty shopUser.head_img}">
<img class="weui-media-box__thumb radius" src="${shopUser.head_img}" alt="">
</c:if>
</div>
<div>
<input type="file" id="file" name="file" style="opacity:0;margin-top: -82px;width: 82px;height: 82px" onchange="upload()" />
</div>
<div>
<!--   -->
</div>
</div>
  <div class="weui-panel">
        <div class="weui-panel__bd">
          <div class="weui-media-box weui-media-box_small-appmsg">
            <div class="weui-cells">
               <a class="weui-cell weui-cell_access" href="user/username">
                <div class="weui-cell__bd weui-cell_primary">
                  <p class="center-list-txt">昵称</p>
                </div>
                <span class="weui-cell__ft"><c:if test="${empty shopUser.username}">请完善</c:if><c:if test="${!empty shopUser.username}">${shopUser.username}</c:if></span>
             	</a>
             	 <a class="weui-cell weui-cell_access" href="user/phone">
                <div class="weui-cell__bd weui-cell_primary">
                  <p class="center-list-txt">手机</p>
                </div>
                <span class="weui-cell__ft"><c:if test="${empty shopUser.phone}">请完善</c:if><c:if test="${!empty shopUser.phone}">${shopUser.phone}</c:if></span>
             	</a>
            </div>
          </div>
        </div>
      </div>
</div>
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/js/jquery-weui.js"></script> 
<script type="text/javascript" src="static/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="static/js/upload.js"></script> 
<script>
function img_upload(){
	$('#file').click();
}
</script>
</body>
</html>

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
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
<link href="static/css/showTip.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="static/js/showTip.js"></script>
</head>
<body ontouchstart id="wrap">
<!--主体-->
<header class="wy-header">
  <div class="wy-header-icon-back"><span onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">昵称修改</div>
</header>
<div class="weui-content">
  <div class="weui-cells weui-cells_form wy-address-edit">
  
    <div class="weui-cell">
      <div class="weui-cell__bd"><input class="weui-input" id="username" type="text" value="${shopUser.username }" placeholder="请输入昵称"></div>
    </div>
  </div>
  <div class="weui-btn-area"><a href="javascript:update();" class="weui-btn weui-btn_primary">确认修改</a></div>
</div>

<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/js/jquery-weui.js"></script><script src="static/js/jquery.cookie.js" ></script>

<script>
function update(){
	var username =$('#username').val();
	if (username=='') {
		showTip('请填写昵称！');
		return;
	}
	$.showLoading();
	$.ajax({
		url:'user/update',
		type:'post',
		data:{username:username},
		success:function(data){
			$.hideLoading();
			
			if(data.result==1){
				$.toast(data.message);
				setTimeout('location.href=document.referrer', 2000);
			}else{
				$.alert(data.message);
			}
		}
	})
}	

</script>
</body>
</html>

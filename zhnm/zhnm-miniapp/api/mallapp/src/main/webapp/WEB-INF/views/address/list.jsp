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
<title>地址管理</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body ontouchstart>
<!--主体-->
<header class="wy-header">
  <div class="wy-header-icon-back"><span onclick="window.location.href='app/center/index'"></span></div>
  <div class="wy-header-title">地址管理</div>
</header>
<div class="weui-content">
  <div class="weui-panel address-box" id="show-addr-list">
  
    <div class="weui-loadmore" id="addr-loading">
    <i class="weui-loading"></i>
    <span class="weui-loadmore__tips">正在加载</span>
  </div>
  </div>
  <div class="weui-btn-area">
    <a class="weui-btn weui-btn_primary" href="center/address/info?msg=save" id="showTooltips">添加收货地址</a>
  </div>
</div>
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/lib/fastclick.js"></script> 
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script>
<script src="static/js/jquery-weui.js"></script>
<script>
$(function(){
	$.ajax({
		url:'address/list',
		type:'post',
		success:function(data){
			$('#show-addr-list').html('');
			$.each(data,function(i,item){
				var defalut_html = '';
				if(item.is_default==1){
					defalut_html = '<span class="default-add">默认地址</span>';
				}
				$('#show-addr-list').append('<div class="weui-panel__bd"  onclick="window.location.href=\'center/address/info?msg=edit&address_id='+item.address_id+'\'">'+
					    '<div class="weui-media-box weui-media-box_text address-list-box">'+
				        '<a class="address-edit"></a>'+
				        '<h4 class="weui-media-box__title"><span>'+item.addr_realname+'</span><span>'+item.addr_phone+'</span></h4>'+
				        '<p  class="weui-media-box__desc address-txt">'+item.addr_city+' '+item.address+'</p>'+
				        defalut_html+
				      '</div>'+
				    '</div>');
			})
		}
	})
})
</script>
</body>
</html>

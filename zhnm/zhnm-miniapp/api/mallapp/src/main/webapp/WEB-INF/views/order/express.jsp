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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body ontouchstart style="height: auto">
<header class="wy-header" style="position:fixed; top:0; left:0; right:0; z-index:200;">
  <div class="wy-header-icon-back"><span onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">查看物流</div>
</header>

<div class='weui-content'>
<input type="hidden" value="${pd.express_title}" id="express_title"/>
<input type="hidden" value="${pd.express_name}" id="express_name"/>
<input type="hidden" value="${pd.express_num}" id="express_num"/>
<div class="wy-center-top" style="margin-top:44px">
    <div class="weui-media-box weui-media-box_appmsg">
      <div class="weui-media-box__hd"></div>
      <div class="weui-media-box__bd">
        <h4 class="weui-media-box__title user-name" id="status">${pd.express_name}：${pd.express_num}</h4>
       
      </div>
    </div>

  </div>
  
  <div class="weui-panel weui-panel_access"  id="express">

  </div>
</div> 
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/lib/fastclick.js"></script> 
<script src="static/js/jquery-weui.js"></script>
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script> 
<script>
	$(function(){
		var express_name=$('#express_name').val();
		var express_title=$('#express_title').val();
		if(express_title=='wxkd'){
			return;
		}
		var express_num=$('#express_num').val();
		$.showLoading();
		var express_title = $('#express_title').val();
			var express_num = $('#express_num').val();
			$.ajax({
				url : 'express/info',
				type : 'post',
				data : {
					express_title : express_title,
					express_num : express_num
				},
				success : function(data) {
					$.hideLoading();
					if(data!=''){
					if (data.Success == true) {
						if(data.State==0){
							$('#express').html('<div class="weui-media-box weui-media-box_text" ><p class="weui-media-box__desc">'+data.Reason+'</p></div>');
							return;
						}
						$.each(data.Traces.reverse(),function(i,item){
							$('#express').append('<div class="weui-media-box weui-media-box_text" ><p class="weui-media-box__desc">'+item.AcceptStation+'</p>'
				                    +'<ul class="weui-media-box__info">'
				                    +'<li class="weui-media-box__info__meta">'+item.AcceptTime+'</li>'
				                    +'</ul></div>');
						})
					}
					else{
						$('#express').html('<div class="weui-media-box weui-media-box_text" ><p class="weui-media-box__desc">'+data.Reason+'</p></div>');
					}
					}
				}
			})
		
	})
	
	
</script> 
<script src="static/js/jquery-weui.js"></script>
</body>
</html>

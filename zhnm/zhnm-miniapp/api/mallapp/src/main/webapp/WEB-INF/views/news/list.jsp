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
<title>新闻列表</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body ontouchstart>
<!--主体-->
<header class="wy-header">
  <div class="wy-header-icon-back"><span onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">新闻列表</div>
</header>
<div class="weui-content">
  <div class="weui-cells wy-news-list" id="list">
    
     
  </div>
  
</div><div class="weui-loadmore" id="loading" style="display: none">
    <i class="weui-loading"></i>
    <span class="weui-loadmore__tips">正在加载</span>
  </div>
      <input type="hidden" id="currentPage"/>
      <input type="hidden" id="totalPage" />
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/lib/fastclick.js"></script> 
<script type="text/javascript" src="static/js/jquery.Spinner.js"></script>
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script>

<script src="static/js/jquery-weui.js"></script>
<script>
$(function(){
	$.showLoading();
	$('#list').html('');
	list(1);
})

var loading = false;
  $(document.body).infinite().on("infinite", function() {
    if(loading) return;
    loading = true
    var totalPage =$('#totalPage').val();
	var currentPage =$('#currentPage').val();
	if(parseInt(currentPage) < parseInt(totalPage)){
		currentPage = parseInt(currentPage) +1 ;
	}else{
		return ;
	}
	$('#loading').show();
	list(currentPage);
  });
function list(currentPage){
	$.ajax({
		url:'news/list',
		type:'post',
		data:{currentPage:currentPage},
		success:function(data){
			$.hideLoading();
			$('#loading').hide();
			$('#currentPage').val(data.page.currentPage);
			$('#totalPage').val(data.page.totalPage);
			var list = data.list;
			$.each(list,function(i,item){
				$('#list').append('<div class="weui-media-box weui-media-box_text" onclick="window.location.href=\'news/toinfo?news_id='+item.news_id+'\'">'
	                    +'<h4 class="weui-media-box__title">'+item.news_title+'</h4>'
	                    +'<p class="weui-media-box__desc">'+item.news_content+'</p>'
	                    +'<ul class="weui-media-box__info">'
	                    +'<li class="weui-media-box__info__meta">时间：'+item.addtime+'</li>'
	                    +'</ul>'
	                    +'</div>');
				})
				}
				})
			}
			
</script>
</body>
</html>

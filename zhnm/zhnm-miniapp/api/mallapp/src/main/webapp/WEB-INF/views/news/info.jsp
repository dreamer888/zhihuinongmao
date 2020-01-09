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
<title>新闻详情</title>
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
  <div class="wy-header-title">新闻详情</div>
</header>
  <div class="weui-content">
  <article class="weui-article" id="list">
    
  </article>
  
</div>
  

  <input type="hidden" id="news_id" value="${pd.news_id}"/>
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
	var news_id =$('#news_id').val();
	info(news_id);
})


function info(news_id){
	$.ajax({
		url:'news/info',
		type:'post',
		data:{news_id:news_id},
		success:function(data){
			$.hideLoading();
			$('#list').append('<h1>'+data.news_title+'</h1>'
				    +'<h3 class="wy-news-time">'+data.addtime+'</h3>'
				    +'<section class="wy-news-info">'
				    +'<p>'+data.news_content+'</p>'
				    +'</section>');
			
			}
		})
}
			
</script>
</body>
</html>

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
<link rel="stylesheet" href="static/css/coupon.css">
</head>
<body ontouchstart>
<!--顶部搜索-->
<header class="wy-header">
  <div class="wy-header-icon-back"><span onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">优惠券列表</div>
</header>
<!--主体-->
<div class="weui-content">
  <div class='proListWrap' id="tab1">
    

  </div>
</div>
      <input type="hidden" id="currentPage"/>
      <input type="hidden" id="totalPage" />
<div class="weui-loadmore" id="loading" style="display: none">
    <i class="weui-loading"></i>
    <span class="weui-loadmore__tips">正在加载</span>
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
	$.showLoading();
	$('#tab1').html('');
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
		url:'coupon/list',
		type:'post',
		data:{currentPage:currentPage},
		success:function(data){
			$.hideLoading();
			$('#loading').hide();
			$('#currentPage').val(data.page.currentPage);
			$('#totalPage').val(data.page.totalPage);
			var list = data.list;
			$.each(list,function(i,item){
				$('#tab1').append('<div class="stamp stamp01" onclick="add(\''+item.coupon_id+'\')">'
						+'<div class="par"><p>'+item.coupon_name+'</p><sub class="sign">￥</sub><span>'+item.coupon_price+'</span><sub>优惠券</sub><p>订单满'+item.use_price+'元</p></div>'
						+'<div class="copy">副券<p>'+item.starttime+'<br>'+item.endtime+'</p></div>'
						+'<i></i>'
						+'</div>');
			})
		}
	})
}
function add(coupon_id){
	$.showLoading('兑换中，请稍等');
	$.ajax({
		url:'usercoupon/save',
		type:'post',
		data:{coupon_id:coupon_id},
		success:function(data){
			$.hideLoading();
			if(data.result==1){
				$.toast("兑换成功");
				setTimeout('window.location.href=document.referrer', 2000);
			}else{
				$.alert(data.message);
			}
		}
	})
}		
</script>
</body>
</html>

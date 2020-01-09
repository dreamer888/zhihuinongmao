<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>产品列表</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body ontouchstart id="wrap">
<!--顶部搜索-->
<header class='weui-header fixed-top'>
  <div class="weui-search-bar" id="searchBar">
    <form class="weui-search-bar__form" method="post" action="goods/list">
      <div class="weui-search-bar__box">
        <i class="weui-icon-search"></i>
        <input type="search" value="${pd.goods_name}" class="weui-search-bar__input" name="goods_name" id="goods_name" placeholder="搜索您想要的商品" required>
        <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
      </div>
      <label class="weui-search-bar__label" id="searchText" style="transform-origin: 0px 0px 0px; opacity: 1; transform: scale(1, 1);">
        <i class="weui-icon-search"></i>
        <span><c:if test="${empty pd.goods_name}">搜索您想要的商品</c:if><c:if test="${!empty pd.goods_name}">${pd.goods_name}</c:if></span>
      </label>
     <input type="hidden" value="${pd.super_id}" id="super_id" name="super_id"/>
     <input type="hidden" value="${pd.category_id}" id="category_id" name="category_id"/>
    </form>
   
    <a href="javascript:" class="weui-search-bar__cancel-btn" id="searchCancel">取消</a>
  </div>
  <input type="hidden" id="gtui" value="${pd.gtui }"/>
  <input type="hidden" id="gsales" value="${pd.gsales }"/>
  <input type="hidden" id="gprice" value="${pd.gprice }"/>
  <input type="hidden" id="currentPage"/>
  <input type="hidden" id="totalPage"/>
  <div class="pro-sort">
    <div class="weui-flex">
      <div class="weui-flex__item"><div class="placeholder NormalCss" id="zonghe" onclick="goodslist('${pd.category_id}','${pd.super_id}','1','','','1');">综合</div></div>
      <div class="weui-flex__item"><div class="placeholder NormalCss" id="xiaoliang" onclick="goodslist('${pd.category_id}','${pd.super_id}','','1','','1');">按销量</div></div>
      <div class="weui-flex__item"><div class="placeholder NormalCss" id="jiage" onclick="goodslist('${pd.category_id}','${pd.super_id}','','','1','1');">按价格</i></div></div>
    </div>
  </div>
</header>
<!--主体-->
<div class="weui-content" style="padding-top:85px;">
  <!--产品列表--滑动加载-->
  <!-- <div class="weui-pull-to-refresh__layer">
    <div class='weui-pull-to-refresh__arrow'></div>
    <div class='weui-pull-to-refresh__preloader'></div>
    <div class="down">下拉刷新</div>
    <div class="up">释放刷新</div>
    <div class="refresh">正在刷新</div>
  </div> -->
 <div id="list" class='demos-content-padded proListWrap'>
    
</div>
  <div class="weui-loadmore" id="loading" style="display: none">
    <i class="weui-loading"></i>
    <span class="weui-loadmore__tips">正在加载</span>
  </div>
<jsp:include page="../footer2.jsp"></jsp:include>
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/lib/fastclick.js"></script>
<script>
var loading = false;
var super_id =$('#super_id').val();
var category_id =$('#category_id').val();

$(function(){
	$.showLoading();
	goodslist(category_id, super_id,'','','',1);
})
function goodslist(category_id,super_id,gtui,gsales,gprice,currentPage){
	var goods_name = encodeURI($('#goods_name').val());
	$('#xiaoliang').attr('class','placeholder NormalCss');
	$('#xiaoliang').attr('onclick',"goodslist(\'"+category_id+"',\'"+super_id+"\','','1','',\'"+goods_name+"\','1');");
	$('#jiage').attr('class','placeholder NormalCss');
	$('#jiage').attr('onclick',"goodslist(\'"+category_id+"\',\'"+super_id+"\','','','1',\'"+goods_name+"\','1');");
	$('#gtui').val(gtui);
	$('#gsales').val('');
	$('#gprice').val('');
	if(gtui==1){
		$('#xiaoliang').attr('class','placeholder NormalCss');
		$('#xiaoliang').attr('onclick',"goodslist(\'"+category_id+"',\'"+super_id+"\','','1','',\'"+goods_name+"\','1');");
		$('#jiage').attr('class','placeholder NormalCss');
		$('#jiage').attr('onclick',"goodslist(\'"+category_id+"\',\'"+super_id+"\','','','1',\'"+goods_name+"\','1');");
		$('#gtui').val(gtui);
		$('#gsales').val('');
		$('#gprice').val('');
	}
	if(gsales==1){
		$('#xiaoliang').attr('class','placeholder SortAscCss');
		$('#xiaoliang').attr('onclick',"goodslist(\'"+category_id+"\',\'"+super_id+"\','','2','',\'"+goods_name+"\','1');");
		$('#jiage').attr('class','placeholder NormalCss');
		$('#jiage').attr('onclick',"goodslist(\'"+category_id+"\',\'"+super_id+"\','','','1',\'"+goods_name+"\','1');");
		$('#gtui').val('');
		$('#gsales').val(gsales);
		$('#gprice').val('');
	}
	if(gsales==2){
		$('#xiaoliang').attr('class','placeholder SortDescCss');
		$('#xiaoliang').attr('onclick',"goodslist(\'"+category_id+"',\'"+super_id+"\','','1','',\'"+goods_name+"\','1');");
		$('#jiage').attr('class','placeholder NormalCss');
		$('#jiage').attr('onclick',"goodslist(\'"+category_id+"\',\'"+super_id+"\','','','1',\'"+goods_name+"\','1');");
		$('#gtui').val('');
		$('#gsales').val(gsales);
		$('#gprice').val('');
	}
	
	if(gprice==1){
		$('#jiage').attr('class','placeholder SortAscCss');
		$('#jiage').attr('onclick',"goodslist(\'"+category_id+"\',\'"+super_id+"\','','','2',\'"+goods_name+"\','1');");
		$('#xiaoliang').attr('class','placeholder NormalCss');
		$('#xiaoliang').attr('onclick',"goodslist(\'"+category_id+"',\'"+super_id+"\','','1','',\'"+goods_name+"\','1');");
		$('#gtui').val('');
		$('#gsales').val('');
		$('#gprice').val(gprice);
	}
	if(gprice==2){
		$('#jiage').attr('class','placeholder SortDescCss');
		$('#jiage').attr('onclick',"goodslist(\'"+category_id+"\',\'"+super_id+"\','','','1',\'"+goods_name+"\','1');");
		$('#xiaoliang').attr('class','placeholder NormalCss');
		$('#xiaoliang').attr('onclick',"goodslist(\'"+category_id+"',\'"+super_id+"\','','1','',\'"+goods_name+"\','1');");
		$('#gtui').val('');
		$('#gsales').val('');
		$('#gprice').val(gprice);
	}

	$.ajax({
		url:'goodslist',
		type:'post',
		data:{category_id:category_id,super_id:super_id,gtui:gtui,gsales:gsales,gprice:gprice,goods_name:goods_name,currentPage:1},
		success:function(data){
			
			$('#wrap').height('100%');
			$('#list').html('');
			loading = false;
			$.hideLoading();
			$('#currentPage').val(data.page.currentPage);
			$('#totalPage').val(data.page.totalPage);
			var goodslist = data.goodslist;
			$.each(goodslist,function(i,item){
				$('#list').append('<div class="pro-items">'+
				      	'<a href="goods/info/'+item.goods_id+'" class="weui-media-box weui-media-box_appmsg">'+
				        '<div class="weui-media-box__hd"><img class="weui-media-box__thumb" src="'+item.goods_pic+'" alt=""></div>'+
				        '<div class="weui-media-box__bd">'+
				        '<h1 class="weui-media-box__desc">'+item.goods_name+'</h1>'+
				        '<div class="wy-pro-pri">¥<em class="num font-15">'+item.goods_price.toFixed(2)+'</em></div>'+
				        '<ul class="weui-media-box__info prolist-ul">'+
				        '<li class="weui-media-box__info__meta"><em class="num">'+item.comment_count+'</em>条评价</li>'+
				        '<li class="weui-media-box__info__meta"><em class="num">'+item.comment_rate+'%</em>好评</li>'+
				        '</ul>'+
				        '</div>'+
				      	'</a>'+
				   		'</div>');
			})
		}
	})
}
</script> 
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script> 
<script src="static/js/jquery-weui.js"></script>
<script>
    /*   $(document.body).pullToRefresh().on("pull-to-refresh", function() {
    	  var gtui =$('#gtui').val();
      	  var gsales =$('#gsales').val();
    	  var gprice =$('#gprice').val();    	  
    	  goodslist(category_id,super_id,gtui,gsales,gprice,goods_name,1);
    	  $(document.body).pullToRefreshDone();
      }); */
      // infinite
  //    loading = false;
      $('#loading').infinite(50);
      $(document.body).infinite().on("infinite", function() {
    	 
    	var goods_name = encodeURI($('#goods_name').val());
        if(loading) return;
        loading = true
    	var totalPage =$('#totalPage').val();
    	var currentPage =$('#currentPage').val();
    	var gtui =$('#gtui').val();
    	var gsales =$('#gsales').val();
    	var gprice =$('#gprice').val();
    	if(parseInt(currentPage) < parseInt(totalPage)){
    		currentPage = parseInt(currentPage) +1 ;
    	}else{
    		return ;
    	}
    	$('#loading').show();
        $.ajax({
    		url:'goodslist',
    		type:'post',
    		data:{category_id:category_id,super_id:super_id,gtui:gtui,gsales:gsales,gprice:gprice,goods_name:goods_name,currentPage:currentPage},
    		success:function(data){
    			$('#currentPage').val(data.page.currentPage);
    			$('#loading').hide();
    			if(parseInt(currentPage) < parseInt(totalPage)){
    				loading = false;
    	    	}
    			var goodslist = data.goodslist;
    			$.each(goodslist,function(i,item){
    				$('#list').append('<div class="pro-items">'+
    				      	'<a href="goods/info/'+item.goods_id+'" class="weui-media-box weui-media-box_appmsg">'+
    				        '<div class="weui-media-box__hd"><img class="weui-media-box__thumb" src="'+item.goods_pic+'" alt=""></div>'+
    				        '<div class="weui-media-box__bd">'+
    				        '<h1 class="weui-media-box__desc">'+item.goods_name+'</h1>'+
    				        '<div class="wy-pro-pri">¥<em class="num font-15">'+item.goods_price.toFixed(2)+'</em></div>'+
    				        '<ul class="weui-media-box__info prolist-ul">'+
    				        '<li class="weui-media-box__info__meta"><em class="num">'+item.comment_count+'</em>条评价</li>'+
    				        '<li class="weui-media-box__info__meta"><em class="num">'+item.comment_rate+'%</em>好评</li>'+
    				        '</ul>'+
    				        '</div>'+
    				      	'</a>'+
    				   		'</div>');
    			})
    		}
    	}) 
      });
</script>
</body>
</html>

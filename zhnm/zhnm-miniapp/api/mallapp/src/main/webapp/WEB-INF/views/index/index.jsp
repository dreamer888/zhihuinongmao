<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>千派网络-专业的软件服务商</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
<!--顶部搜索-->
<header class='weui-header'>
  <div class="weui-search-bar" id="searchBar">
    <form class="weui-search-bar__form" method="post" action="goods/list">
      <div class="weui-search-bar__box">
        <i class="weui-icon-search"></i>
        <input type="search" class="weui-search-bar__input" id="searchInput" name="goods_name" placeholder="搜索您想要的商品">
        <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
      </div>
      <label class="weui-search-bar__label" id="searchText" style="transform-origin: 0px 0px 0px; opacity: 1; transform: scale(1, 1);">
        <i class="weui-icon-search"></i>
        <span>搜索您想要的商品</span>
      </label>
    </form>
    <a href="javascript:" class="weui-search-bar__cancel-btn" id="searchCancel">取消</a>
  </div>
</header>
<!--主体-->
<div class='weui-content'>
  <!--顶部轮播-->
  <div class="swiper-container swiper-banner">
    <div class="swiper-wrapper">
    <c:forEach items="${bannerlist}" var="bannerlist">
      <div class="swiper-slide"><a href="${bannerlist.url}"><img src="${bannerlist.ban_img}" /></a></div>
     </c:forEach> 
    </div>
    <div class="swiper-pagination"></div>
  </div>
  <!--图标分类-->
  <div class="weui-flex wy-iconlist-box">
  <c:forEach items="${navigationlist}" var="navigationlist">
    <div class="weui-flex__item"><a href="${navigationlist.navigation_url}" class="wy-links-iconlist"><div class="img"><img src="${navigationlist.navigation_img}"></div><p>${navigationlist.navigation_name}</p></a></div>
   </c:forEach> 
     </div>
  <!--新闻切换-->
  <div class="wy-ind-news" onclick="location.href='news/tolist'">
    <i class="news-icon-laba"></i>
    <div class="swiper-container swiper-news">
      <div class="swiper-wrapper">
        <c:forEach items="${newslist}" var="newslist">
        <div class="swiper-slide"><a>${newslist.news_title}</a></div>
        </c:forEach>
      </div>
      <div class="swiper-pagination"></div>
    </div>
    <a class="newsmore"><i class="news-icon-more"></i></a>
  </div>
  <!--精选推荐-->
  <div class="wy-Module">
    <div class="wy-Module-tit"><span>精选推荐</span></div>
    <div class="wy-Module-con">
      <div class="swiper-container swiper-jingxuan" style="padding-top:34px;">
        <div class="swiper-wrapper">
        <c:forEach items="${tuijianlist}" var="tuijianlist">
          <div class="swiper-slide"><a href="goods/info/${tuijianlist.goods_id}"><img src="${tuijianlist.goods_pic}" /></a></div>
         </c:forEach> 
        </div>
        <div class="swiper-pagination jingxuan-pagination"></div>
      </div>
    </div>
  </div>
  
  <!--猜你喜欢-->
  <div class="wy-Module">
    <div class="wy-Module-tit-line"><span>猜你喜欢</span></div>
    <div class="wy-Module-con">
      <ul class="wy-pro-list clear">
       <c:forEach items="${goodslist}" var="goodslist">
       <li>
          <a href="goods/info/${goodslist.goods_id}">
            <div class="proimg"><img src="${goodslist.goods_pic}"></div>
            <div class="protxt">
              <div class="name">${goodslist.goods_name}</div>
              <div class="wy-pro-pri">¥<span class="span_left">${goodslist.goods_price}</span> <span class="span_right">销量 ${goodslist.sell_count}</span></div>
            </div>
          </a>
        </li> 
        </c:forEach>
      </ul> 
      
      
      <div class="morelinks"><a href="goods/list">查看更多 >></a></div>
    </div>
  </div>
</div>
<jsp:include page="../footer1.jsp"></jsp:include>

<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/lib/fastclick.js"></script> 
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script> 
<script src="static/js/jquery-weui.js"></script>
<script src="static/js/swiper.js"></script>
<script>
	$(".swiper-banner").swiper({
        loop: true,
        autoplay: 3000
      });
	$(".swiper-news").swiper({
		loop: true,
		direction: 'vertical',
		paginationHide :true,
        autoplay: 3000
      });
	 $(".swiper-jingxuan").swiper({
		pagination: '.swiper-pagination',
		loop: true,
		paginationType:'fraction',
        slidesPerView:3,
        paginationClickable: true,
        spaceBetween: 2
      });
	 $(".swiper-jiushui").swiper({
		pagination: '.swiper-pagination',
		paginationType:'fraction',
		loop: true,
        slidesPerView:3,
		slidesPerColumn: 2,
        paginationClickable: true,
        spaceBetween:2
      });
</script>
</body>
</html>

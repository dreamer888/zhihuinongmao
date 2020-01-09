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
<title>商城分类</title>
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
<!--顶部搜索-->
<!--主体-->
<div class="wy-content">
  <div class="category-top">
    <header class='weui-header'>
  <div class="weui-search-bar" id="searchBar">
    <form class="weui-search-bar__form">
      <div class="weui-search-bar__box">
        <i class="weui-icon-search"></i>
        <input type="search" class="weui-search-bar__input" id="searchInput" placeholder="搜索您想要的商品">
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
  </div>
  <aside>
    <div class="menu-left scrollbar-none" id="sidebar">
      <ul>
      <c:forEach items="${category['categoryList']}" var="categoryList" varStatus="ctg">
        <li <c:if test="${ctg.index==0}"> class="active" </c:if>>${categoryList.category_name }</li>
        </c:forEach>
      </ul>
    </div>
  </aside>
  <c:forEach items="${category['categoryList']}" var="categoryList" varStatus="ctg">
  <c:set value="childcategory${ctg.index}" var="childcategory"></c:set>
  <section class="menu-right padding-all j-content" <c:if test="${ctg.index!=0}"> style="display:none" </c:if>>
    <h5>${categoryList.category_name }</h5>
    <ul>
    <c:forEach items="${category[childcategory]}" var="childcategory" varStatus="ctg">
      <li class="w-3"><a href="goods/list?category_id=${childcategory.category_id }"></a> <img src="${childcategory.category_img}"><span>${childcategory.category_name }</span></li>
      </c:forEach>
    </ul>
  </section>
  </c:forEach>
</div>
<jsp:include page="../footer2.jsp"></jsp:include>
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/lib/fastclick.js"></script> 
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script>
<script src="static/js/jquery-weui.js"></script>
<script type="text/javascript">
	$(function($){
		$('#sidebar ul li').click(function(){
			$(this).addClass('active').siblings('li').removeClass('active');
			var index = $(this).index();
			$('.j-content').eq(index).show().siblings('.j-content').hide();
		})
	})
</script>
</body>
</html>

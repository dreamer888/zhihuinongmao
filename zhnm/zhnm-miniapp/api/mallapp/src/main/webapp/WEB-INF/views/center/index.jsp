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
</head>
<body ontouchstart>
<!--主体-->
<div class='weui-content'>
  <div class="wy-center-top">
    <div class="weui-media-box weui-media-box_appmsg">
    <c:if test="${!empty shopUser}">
      <div class="weui-media-box__hd"><img class="weui-media-box__thumb radius" src="${shopUser.head_img}" alt=""></div>
      <div class="weui-media-box__bd">
        <h4 class="weui-media-box__title user-name">${shopUser.username }</h4>
      </div>
       </c:if>
       
      <c:if test="${empty shopUser}">
      <div class="weui-media-box__hd" onclick="location.href='app/to_login?url=app/center/index'"><img class="weui-media-box__thumb radius" src="static/upload/headimg.jpg" alt=""></div>
      <div class="weui-media-box__bd" onclick="location.href='app/to_login?url=app/center/index'">
        <h4 class="weui-media-box__title user-name">点击登录</h4>
      </div>
       </c:if>
    </div>

  </div>
  <div class="weui-panel weui-panel_access">
    <div class="weui-panel__hd">
      <a href="order_list" class="weui-cell weui-cell_access center-alloder">
        <div class="weui-cell__bd wy-cell">
          <div class="weui-cell__hd"><img src="static/images/center-icon-order-all.png" alt="" class="center-list-icon"></div>
          <div class="weui-cell__bd weui-cell_primary"><p class="center-list-txt">全部订单</p></div>
        </div>
        <span class="weui-cell__ft"></span>
      </a>   
    </div>
    <div class="weui-panel__bd">
      <div class="weui-flex">
        <div class="weui-flex__item">
          <a href="order_list?status=0" class="center-ordersModule">
          	<c:if test="${count.d_fk !=0&&!empty count.d_fk}">
            <span class="weui-badge" style="position: absolute;top:5px;right:10px; font-size:10px;">${count.d_fk }</span>
            </c:if>
            <div class="imgicon"><img src="static/images/center-icon-order-dfk.png" /></div>
            <div class="name">待付款</div>
          </a>
        </div>
        <div class="weui-flex__item">
          <a href="order_list?status=1" class="center-ordersModule">
          <c:if test="${count.d_fh !=0&&!empty count.d_fh}">
            <span class="weui-badge" style="position: absolute;top:5px;right:10px; font-size:10px;">${count.d_fh }</span>
           </c:if> 
            <div class="imgicon"><img src="static/images/center-icon-order-dfh.png" /></div>
            <div class="name">待发货</div>
          </a>
        </div>
        <div class="weui-flex__item">
          <a href="order_list?status=2" class="center-ordersModule">
          <c:if test="${count.d_sh !=0&&!empty count.d_sh}">
          	<span class="weui-badge" style="position: absolute;top:5px;right:10px; font-size:10px;">${count.d_sh }</span>
          </c:if>	
          	<div class="imgicon"><img src="static/images/center-icon-order-dsh.png" /></div>
            <div class="name">待收货</div>
          </a>
        </div>
        <div class="weui-flex__item">
          <a href="order_list?status=5" class="center-ordersModule">
          <c:if test="${count.d_pj !=0&&!empty count.d_pj}">
            <span class="weui-badge" style="position: absolute;top:5px;right:10px; font-size:10px;">${count.d_pj }</span>
            </c:if>
            <div class="imgicon"><img src="static/images/center-icon-order-dpj.png" /></div>
            <div class="name">待评价</div>
          </a>
        </div>
      </div>
    </div>
  </div>
  
  <div class="weui-panel">
        <div class="weui-panel__bd">
          <div class="weui-media-box weui-media-box_small-appmsg">
            <div class="weui-cells">
              
             
               <a class="weui-cell weui-cell_access" href="collection/tolist">
                <div class="weui-cell__hd"><img src="static/images/center-icon-sc.png" alt="" class="center-list-icon"></div>
                <div class="weui-cell__bd weui-cell_primary">
                  <p class="center-list-txt">我的收藏</p>
                </div>
                <span class="weui-cell__ft"></span>
              </a>
              <a class="weui-cell weui-cell_access" href="center/address/tolist">
                <div class="weui-cell__hd"><img src="static/images/center-icon-dz.png" alt="" class="center-list-icon"></div>
                <div class="weui-cell__bd weui-cell_primary">
                  <p class="center-list-txt">地址管理</p>
                </div>
                <span class="weui-cell__ft"></span>
              </a>
               <a class="weui-cell weui-cell_access" href="coupon/touser_list">
                <div class="weui-cell__hd"><img src="static/images/center-icon-coupon.png" alt="" class="center-list-icon"></div>
                <div class="weui-cell__bd weui-cell_primary">
                  <p class="center-list-txt">我的优惠券</p>
                </div>
                <span class="weui-cell__ft"></span>
              </a>
              <c:if test="${!empty shopUser}">
              <a class="weui-cell weui-cell_access" href="user/info">
                <div class="weui-cell__hd"><img src="static/images/center-icon-set.png" alt="" class="center-list-icon"></div>
                <div class="weui-cell__bd weui-cell_primary">
                  <p class="center-list-txt">个人资料</p>
                </div>
                <span class="weui-cell__ft"></span>
              </a>
              
             <!--  <a class="weui-cell weui-cell_access" href="app/to_forget">
                <div class="weui-cell__hd"><img src="static/images/center-icon-dlmm.png" alt="" class="center-list-icon"></div>
                <div class="weui-cell__bd weui-cell_primary">
                  <p class="center-list-txt">密码修改</p>
                </div>
                <span class="weui-cell__ft"></span>
              </a>
              
              <a class="weui-cell weui-cell_access" href="JavaScript:login_out();">
                <div class="weui-cell__hd"><img src="static/images/center-icon-out.png" alt="" class="center-list-icon"></div>
                <div class="weui-cell__bd weui-cell_primary">
                  <p class="center-list-txt">退出账号</p>
                </div>
                <span class="weui-cell__ft"></span>
              </a> -->
              </c:if>
            </div>
          </div>
        </div>
      </div>
</div>
<jsp:include page="../footer4.jsp"></jsp:include>
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/js/jquery-weui.js"></script> 
<script>
function login_out(){
	$.confirm("您确定要退出登录吗?", "确认?", function() {
		location.href='login_out';
	})
}

</script>
</body>
</html>

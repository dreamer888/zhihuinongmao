<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<!-- 下拉框 -->
<link rel="stylesheet" href="static/ace/css/chosen.css" />
<!-- jsp文件头和头部 -->
<%@ include file="../system/index/top.jsp"%>
<!-- 日期框 -->
<link rel="stylesheet" href="static/ace/css/datepicker.css" />
<style type="text/css">
p {
	padding-top: 7px;
}
</style>
</head>

<body class="no-skin">

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="hr hr-18 dotted hr-double"></div>
					<div class="row">
						<div class="col-xs-12">

							<!-- 存放生成的hmlt开头  -->
							<!-- <form class="form-horizontal" role="form"> -->
							<form action="/" name="Form" id="Form"
								method="post" class="form-horizontal">
								<div class="col-md-12">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">
									    </label>
										<div class="col-sm-9">
										     <span>订单编号:&nbsp;&nbsp;&nbsp;<a>${orderNumber}&nbsp;&nbsp;&nbsp;</a></span>
											<a class="btn btn-mini btn-danger" onclick="window.location.href = document.referrer;">返回</a>
										</div>
									</div>
								</div>
								<table id="simple-table" class="table table-striped table-bordered table-hover" style="margin-top:5px;">
								<thead>
								<tr>
									<th class="center" style="width:35px;">
									<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>
									</th>
									<th class="center">商品名称</th>
									<th class="center">单价</th>
									<th class="center">数量</th>
									<th class="center">总额</th>
								</tr>
							</thead>
							<c:choose>
								<c:when test="${not empty orderGoodsList}">
									<c:forEach items="${orderGoodsList}" var="offLineOrderGoods" varStatus="vs">	
										<tr>
											<td class='center' style="width: 30px;">${vs.index+1}</td>  <!-- 序列 -->							
											<td class="center">${offLineOrderGoods.GOODS_NAME }</td>
											<td class="center">${offLineOrderGoods.GOODS_PRICE}</td>
											<td class="center">${offLineOrderGoods.GOODS_COUNT }</td>
											<td class="center">${offLineOrderGoods.PAY_TOTAL}</td>
										</tr>
									
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="10" class="center">没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
								</table>
							</form>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				
			</div>
		</div>
		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
</body>
</html>
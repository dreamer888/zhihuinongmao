<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
<!-- 百度echarts -->
<script src="plugins/echarts/echarts.min.js"></script>
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

							<div class="alert alert-block alert-success">
								<button type="button" class="close" data-dismiss="alert">
									<i class="ace-icon fa fa-times"></i>
								</button>
								<i class="ace-icon fa fa-check green"></i>
								欢迎使用商城后台管理系统&nbsp;&nbsp;
						
							</div>
							<div class="row">
									<div class="space-6"></div>

									<div class="col-sm-7 infobox-container">
										<div class="infobox infobox-green  ">
											<div class="infobox-icon">
												<i class="icon-comments"></i>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">${pd.userCount}</span>
												<div class="infobox-content">用户数</div>
											</div>
										</div>

										<div class="infobox infobox-blue  ">
											<div class="infobox-icon">
												<i class="icon-twitter"></i>
											</div>

											<div class="infobox-data" onclick="location.href='order/list?status=1'">
												<span class="infobox-data-number">${pd.pend_send_order}</span>
												<div class="infobox-content">待发货</div>
											</div>
											
										</div>

										<div class="infobox infobox-pink  ">
											<div class="infobox-icon">
												<i class="icon-shopping-cart"></i>
											</div>

											<div class="infobox-data"  onclick="location.href='order/list?status=3'">
												<span class="infobox-data-number">${pd.pend_refund_order}</span>
												<div class="infobox-content">待退款</div>
											</div>
										</div>

										<div class="infobox infobox-red  ">
											<div class="infobox-icon">
												<i class="icon-beaker"></i>
											</div>  
											<div class="infobox-data" >
												<span class="infobox-data-number">7</span>
												<div class="infobox-content">商户数</div>
											</div>
										</div>

										<div class="infobox infobox-orange2  ">
											<div class="infobox-chart">
												<span class="sparkline" data-values="196,128,202,177,154,94,100,170,224"><canvas width="44" height="32" style="display: inline-block; width: 44px; height: 32px; vertical-align: top;"></canvas></span>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">6,251</span>
												<div class="infobox-content">昨日线上订单总数</div>
											</div>
										</div>
										<div class="infobox infobox-orange2  ">
											<div class="infobox-chart">
												<span class="sparkline" data-values="196,128,202,177,154,94,100,170,224"><canvas width="44" height="32" style="display: inline-block; width: 44px; height: 32px; vertical-align: top;"></canvas></span>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">6,251</span>
												<div class="infobox-content">昨日线下订单总数</div>
											</div>
										</div>
                                    
                                         <div class="infobox infobox-orange2  ">
											<div class="infobox-chart">
												<span class="sparkline" data-values="196,128,202,177,154,94,100,170,224"><canvas width="44" height="32" style="display: inline-block; width: 44px; height: 32px; vertical-align: top;"></canvas></span>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">6,2851</span>
												<div class="infobox-content">本月线上订单总数</div>
											</div>
									  	 </div>
                                         <div class="infobox infobox-orange2  ">
											<div class="infobox-chart">
												<span class="sparkline" data-values="196,128,202,177,154,94,100,170,224"><canvas width="44" height="32" style="display: inline-block; width: 44px; height: 32px; vertical-align: top;"></canvas></span>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">6,28531</span>
												<div class="infobox-content">本月线下订单总数</div>
											</div>
									  	  </div>
                                    
                                    <%--
										<div class="infobox infobox-blue2  ">
											<div class="infobox-progress">
												<div class="easy-pie-chart percentage easyPieChart" data-percent="42" data-size="46" style="width: 46px; height: 46px; line-height: 46px;">
												<canvas width="57" height="57" style="width: 46px; height: 46px;"></canvas></div>
											</div>

											<div class="infobox-data">
												<span class="infobox-text">交易使用</span>

												<div class="infobox-content">
													<span class="bigger-110">~</span>
													剩余58GB
												</div>
											</div><-- --%>
										</div>

										<div class="space-6"></div>

									</div>

									<div class="vspace-sm"></div>

									<div class="col-sm-5">
										
									</div><!-- /span -->
								</div>
							
							<div id="main" style="width: 600px;height:300px;"></div>
							
							
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->


		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		$(top.hangge());
	</script>
<script type="text/javascript" src="static/ace/js/jquery.js"></script>
</body>
</html>
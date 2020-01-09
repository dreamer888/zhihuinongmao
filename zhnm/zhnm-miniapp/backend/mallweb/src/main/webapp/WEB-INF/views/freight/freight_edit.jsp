<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
					
					<form action="freight/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="freight_id" id="freight_id" value="${pd.freight_id}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">运费价格:</td>
								<td><input type="number" name="freight_price" id="freight_price" value="${pd.freight_price}" maxlength="255" placeholder="这里输入运费价格，免运费时请填入0" title="运费价格" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">免邮价格:</td>
								<td><input type="number" name="freight_free_price" id="freight_free_price" value="${pd.freight_free_price}" maxlength="255" placeholder="这里输入免邮价格，填入0时代表无免邮价格" title="免邮价格" style="width:98%;"/></td>
							</tr>
							<tr><td colspan="10">
							<div class="step-content row-fluid position-relative">
														<ul class="unstyled spaced2">
															<li class="text-warning green"><i class="icon-star blue"></i>
																运费价格：免费包邮时请填入0
															</li>
															<li class="text-warning green"><i class="icon-star blue"></i>
																免邮价格：没有免邮行为请填入0；当免费包邮时，此栏无效
															</li>
															
														</ul>
												</div>
							</td>					
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
								</td>
							</tr>
						</table>
						</div>
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
					</form>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			if($("#freight_price").val()==""){
				$("#freight_price").tips({
					side:3,
		            msg:'请输入运费价格',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#freight_price").focus();
			return false;
			}
			if($("#freight_free_price").val()==""){
				$("#freight_free_price").tips({
					side:3,
		            msg:'请输入免邮价格',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#freight_free_price").focus();
			return false;
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>
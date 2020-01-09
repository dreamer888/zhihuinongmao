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
					
					<form action="rrecord/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="rrecord_id" id="rrecord_id" value="${pd.rrecord_id}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">订单id:</td>
								<td><input type="text" name="order_id" id="order_id" value="${pd.order_id}" maxlength="255" placeholder="这里输入订单id" title="订单id" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">订单详情id:</td>
								<td><input type="text" name="order_detail_id" id="order_detail_id" value="${pd.order_detail_id}" maxlength="255" placeholder="这里输入订单详情id" title="订单详情id" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">退款金额:</td>
								<td><input type="text" name="record_price" id="record_price" value="${pd.record_price}" maxlength="255" placeholder="这里输入退款金额" title="退款金额" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">时间:</td>
								<td><input type="text" name="addtime" id="addtime" value="${pd.addtime}" maxlength="255" placeholder="这里输入时间" title="时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
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
			if($("#order_id").val()==""){
				$("#order_id").tips({
					side:3,
		            msg:'请输入订单id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#order_id").focus();
			return false;
			}
			if($("#order_detail_id").val()==""){
				$("#order_detail_id").tips({
					side:3,
		            msg:'请输入订单详情id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#order_detail_id").focus();
			return false;
			}
			if($("#record_price").val()==""){
				$("#record_price").tips({
					side:3,
		            msg:'请输入退款金额',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#record_price").focus();
			return false;
			}
			if($("#addtime").val()==""){
				$("#addtime").tips({
					side:3,
		            msg:'请输入时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#addtime").focus();
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
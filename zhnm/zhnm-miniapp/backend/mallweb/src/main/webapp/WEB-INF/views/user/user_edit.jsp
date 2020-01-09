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
					
					<form action="user/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="user_id" id="user_id" value="${pd.user_id}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">手机号:</td>
								<td><input type="text" name="phone" id="phone" value="${pd.phone}" maxlength="255" placeholder="这里输入手机号" title="手机号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">密码:</td>
								<td><input type="text" name="password" id="password" value="${pd.password}" maxlength="255" placeholder="这里输入密码" title="密码" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">昵称:</td>
								<td><input type="text" name="username" id="username" value="${pd.username}" maxlength="255" placeholder="这里输入昵称" title="昵称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">等级:</td>
								<td><input type="text" name="level" id="level" value="${pd.level}" maxlength="255" placeholder="这里输入等级" title="等级" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">头像:</td>
								<td><input type="text" name="head_img" id="head_img" value="${pd.head_img}" maxlength="255" placeholder="这里输入头像" title="头像" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">注册时间:</td>
								<td><input type="text" name="addtime" id="addtime" value="${pd.addtime}" maxlength="255" placeholder="这里输入注册时间" title="注册时间" style="width:98%;"/></td>
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
			if($("#phone").val()==""){
				$("#phone").tips({
					side:3,
		            msg:'请输入手机号',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#phone").focus();
			return false;
			}
			if($("#password").val()==""){
				$("#password").tips({
					side:3,
		            msg:'请输入密码',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#password").focus();
			return false;
			}
			if($("#username").val()==""){
				$("#username").tips({
					side:3,
		            msg:'请输入昵称',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#username").focus();
			return false;
			}
			if($("#level").val()==""){
				$("#level").tips({
					side:3,
		            msg:'请输入等级',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#level").focus();
			return false;
			}
			if($("#head_img").val()==""){
				$("#head_img").tips({
					side:3,
		            msg:'请输入头像',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#head_img").focus();
			return false;
			}
			if($("#addtime").val()==""){
				$("#addtime").tips({
					side:3,
		            msg:'请输入注册时间',
		            bg:'#ae81ff',
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
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
					
					<form action="reply/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="reply_id" id="reply_id" value="${pd.reply_id}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">关键词:</td>
								<td><input type="text" name="key" id="key" value="${pd.key}" maxlength="255" placeholder="这里输入关键词" title="关键词" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">类型:</td>
								<td><input type="text" name="type" id="type" value="${pd.type}" maxlength="255" placeholder="这里输入类型" title="类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">回复内容:</td>
								<td><input type="text" name="content" id="content" value="${pd.content}" maxlength="255" placeholder="这里输入回复内容" title="回复内容" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">标题:</td>
								<td><input type="text" name="title" id="title" value="${pd.title}" maxlength="255" placeholder="这里输入标题" title="标题" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">简介:</td>
								<td><input type="text" name="intro" id="intro" value="${pd.intro}" maxlength="255" placeholder="这里输入简介" title="简介" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">图片:</td>
								<td><input type="text" name="pic_url" id="pic_url" value="${pd.pic_url}" maxlength="255" placeholder="这里输入图片" title="图片" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">链接:</td>
								<td><input type="text" name="url" id="url" value="${pd.url}" maxlength="255" placeholder="这里输入链接" title="链接" style="width:98%;"/></td>
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
			if($("#key").val()==""){
				$("#key").tips({
					side:3,
		            msg:'请输入关键词',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#key").focus();
			return false;
			}
			if($("#type").val()==""){
				$("#type").tips({
					side:3,
		            msg:'请输入类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#type").focus();
			return false;
			}
			if($("#content").val()==""){
				$("#content").tips({
					side:3,
		            msg:'请输入回复内容',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#content").focus();
			return false;
			}
			if($("#title").val()==""){
				$("#title").tips({
					side:3,
		            msg:'请输入标题',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#title").focus();
			return false;
			}
			if($("#intro").val()==""){
				$("#intro").tips({
					side:3,
		            msg:'请输入简介',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#intro").focus();
			return false;
			}
			if($("#pic_url").val()==""){
				$("#pic_url").tips({
					side:3,
		            msg:'请输入图片',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#pic_url").focus();
			return false;
			}
			if($("#url").val()==""){
				$("#url").tips({
					side:3,
		            msg:'请输入链接',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#url").focus();
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
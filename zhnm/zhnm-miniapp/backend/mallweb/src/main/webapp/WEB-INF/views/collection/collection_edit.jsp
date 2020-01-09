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
					
					<form action="collection/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="collection_id" id="collection_id" value="${pd.collection_id}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">商品id:</td>
								<td><input type="text" name="goods_id" id="goods_id" value="${pd.goods_id}" maxlength="255" placeholder="这里输入商品id" title="商品id" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">图片:</td>
								<td><input type="text" name="goods_pic" id="goods_pic" value="${pd.goods_pic}" maxlength="255" placeholder="这里输入图片" title="图片" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">价格:</td>
								<td><input type="text" name="goods_price" id="goods_price" value="${pd.goods_price}" maxlength="255" placeholder="这里输入价格" title="价格" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">用户id:</td>
								<td><input type="text" name="user_id" id="user_id" value="${pd.user_id}" maxlength="255" placeholder="这里输入用户id" title="用户id" style="width:98%;"/></td>
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
			if($("#goods_id").val()==""){
				$("#goods_id").tips({
					side:3,
		            msg:'请输入商品id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#goods_id").focus();
			return false;
			}
			if($("#goods_pic").val()==""){
				$("#goods_pic").tips({
					side:3,
		            msg:'请输入图片',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#goods_pic").focus();
			return false;
			}
			if($("#goods_price").val()==""){
				$("#goods_price").tips({
					side:3,
		            msg:'请输入价格',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#goods_price").focus();
			return false;
			}
			if($("#user_id").val()==""){
				$("#user_id").tips({
					side:3,
		            msg:'请输入用户id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#user_id").focus();
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
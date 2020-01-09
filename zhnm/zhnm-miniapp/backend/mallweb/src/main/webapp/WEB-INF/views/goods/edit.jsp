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
					
					<form action="goods/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="GOODS_ID" id="GOODS_ID" value="${pd.GOODS_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">分类:</td>
								<td>
								<select >
								<c:forEach items="${varList}" var="varList">
								<option>${varList.CATEGORY_NAME} </option>
								</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">图片:</td>
								<td><input type="text" name="GOODS_PIC" id="GOODS_PIC" value="${pd.GOODS_PIC}" maxlength="255" placeholder="这里输入图片" title="图片" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">名称:</td>
								<td><input type="text" name="GOODS_NAME" id="GOODS_NAME" value="${pd.GOODS_NAME}" maxlength="255" placeholder="这里输入名称" title="名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注:</td>
								<td><input type="text" name="GOODS_TITLE" id="GOODS_TITLE" value="${pd.GOODS_TITLE}" maxlength="255" placeholder="这里输入备注" title="备注" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">总价:</td>
								<td><input type="number" name="GOODS_PRICE" id="GOODS_PRICE" value="${pd.GOODS_PRICE}" maxlength="32" placeholder="这里输入总价" title="总价" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">元/人次:</td>
								<td><input type="number" name="GOODS_TIME" id="GOODS_TIME" value="${pd.GOODS_TIME}" maxlength="32" placeholder="这里输入元/人次" title="元/人次" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">详情:</td>
								<td><input type="text" name="GOODS_DETAIL" id="GOODS_DETAIL" value="${pd.GOODS_DETAIL}" maxlength="255" placeholder="这里输入详情" title="详情" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">分类:</td>
								<td><input type="text" name="CATEGORY_ID" id="CATEGORY_ID" value="${pd.CATEGORY_ID}" maxlength="255" placeholder="这里输入分类" title="分类" style="width:98%;"/></td>
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
			if($("#GOODS_PIC").val()==""){
				$("#GOODS_PIC").tips({
					side:3,
		            msg:'请输入图片',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GOODS_PIC").focus();
			return false;
			}
			if($("#GOODS_NAME").val()==""){
				$("#GOODS_NAME").tips({
					side:3,
		            msg:'请输入名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GOODS_NAME").focus();
			return false;
			}
			if($("#GOODS_TITLE").val()==""){
				$("#GOODS_TITLE").tips({
					side:3,
		            msg:'请输入备注',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GOODS_TITLE").focus();
			return false;
			}
			if($("#GOODS_PRICE").val()==""){
				$("#GOODS_PRICE").tips({
					side:3,
		            msg:'请输入总价',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GOODS_PRICE").focus();
			return false;
			}
			if($("#GOODS_TIME").val()==""){
				$("#GOODS_TIME").tips({
					side:3,
		            msg:'请输入元/人次',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GOODS_TIME").focus();
			return false;
			}
			if($("#GOODS_DETAIL").val()==""){
				$("#GOODS_DETAIL").tips({
					side:3,
		            msg:'请输入详情',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GOODS_DETAIL").focus();
			return false;
			}
			if($("#CATEGORY_ID").val()==""){
				$("#CATEGORY_ID").tips({
					side:3,
		            msg:'请输入分类',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CATEGORY_ID").focus();
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
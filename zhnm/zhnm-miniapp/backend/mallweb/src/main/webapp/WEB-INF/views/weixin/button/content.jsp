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
<%@ include file="../../system/index/top.jsp"%>
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

							<form action="button/${msg }.do" name="Form" id="Form"
								method="post">
								<input type="hidden" name="button_id" id="button_id"
									value="${button.button_id}" /> <input type="hidden" name="msg"
									id="msg" value="button/${msg}" />
								<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report"
										class="table table-striped table-bordered table-hover">
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">名称:</td>
											<td><input type="text" name="name" id="name"
												value="${button.name}" maxlength="255" placeholder="这里输入名称"
												title="名称" style="width: 98%;" /></td>
										</tr>
										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">级别:</td>
											<td><select id="level" name="level" style="width: 98%;"
												onclick="supper()">
													<option value="1"
														<c:if test="${button.level==1 }">selected</c:if>>主菜单</option>
													<option value="2"
														<c:if test="${button.level==2 }">selected</c:if>>子菜单</option>
											</select></td>
										</tr>

										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">类型:</td>
											<td><select id="type" name='type' style="width: 98%;">
													<option value="view"
														<c:if test="${button.type eq 'view' }">selected</c:if>>链接事件</option>
													<%-- <option value="click" <c:if test="${button.type eq 'click' }">selected</c:if>>点击事件</option> --%>
											</select></td>
										</tr>
										<tr id="supper" style="display: none">
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">所属主菜单:</td>
											<td><select id="super_id" style="width: 98%;">
													<c:forEach items="${mainBtn}" var="mainBtn">
														<option value="${mainBtn.button_id}"
															<c:if test="${button.super_id eq mainBtn.button_id }">selected</c:if>>${mainBtn.name}</option>
													</c:forEach>
											</select></td>
										</tr>

										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">值/链接:</td>
											<td><input type="text" name="value" id="value"
												value="${button.value}" maxlength="255" placeholder="这里输入值/链接"
												title="值/链接" style="width: 98%;" /></td>
										</tr>

										<tr>
											<td
												style="width: 75px; text-align: right; padding-top: 13px;">排序:</td>
											<td><input type="number" name="sort" id="sort"
												value="${button.sort}" maxlength="32" placeholder="这里输入排序"
												title="排序" style="width: 98%;" /></td>
										</tr>

										<tr>
											<td style="text-align: center;" colspan="10"><a
												class="btn btn-mini btn-primary" onclick="save();">保存</a> <a
												class="btn btn-mini btn-danger"
												onclick="top.Dialog.close();">取消</a></td>
										</tr>
									</table>
								</div>
								<div id="zhongxin2" class="center" style="display: none">
									<br /> <br /> <br /> <br /> <br /> <img
										src="static/images/jiazai.gif" /><br />
									<h4 class="lighter block green">提交中...</h4>
								</div>
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
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script type="text/javascript">
		$(top.hangge());
		$(function(){
			supper();
		})
		function supper(){
			var level = $('#level').val();
			if(level==1){
				$("#supper").hide(); 
			}
			if(level==2){
				$("#supper").show(); 
			}
		}
		//保存
		function save(){
			var msg = $('#msg').val();
			var name = $('#name').val();
			var type = $('#type').val();
			var value = $('#value').val();
			var super_id = $('#super_id').val();
			var sort = $('#sort').val();
			var level = $('#level').val();
			var button_id = $('#button_id').val();
			if($("#name").val()==""){
				$("#name").tips({
					side:3,
		            msg:'请输入名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#name").focus();
			return false;
			}
			if(type==""){
				$("#type").tips({
					side:3,
		            msg:'请选择级别',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#type").focus();
			return false;
			}
			if(level==2){
			if(value==""){
				$("#value").tips({
					side:3,
		            msg:'请输入值/链接',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#value").focus();
			return false;
			}
			}
			if(super_id==""){
				$("#super_id").tips({
					side:3,
		            msg:'请选择父级',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#super_id").focus();
			return false;
			}
			if(sort==""){
				$("#sort").tips({
					side:3,
		            msg:'请输入排序',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#sort").focus();
			return false;
			}
			if(level==""){
				$("#level").tips({
					side:3,
		            msg:'请输入菜单等级',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#level").focus();
			return false;
			}
			$.ajax({
				url:msg,
				type:'post',
				data:{
				 button_id:button_id,
				 name:name,
				 type:type  ,
				 value:value ,
				 super_id:super_id  ,
				 sort:sort  ,
				 level:level  },
				 success:function(data){
					 if(data.rs==1){
						$("#zhongxin").hide();
						//$("#zhongxin2").show();
						top.Dialog.close();
					 }else{
						 alert(data.message);
						 // $("#zhongxin").hide();
						// $("#zhongxin2").show();
					 }
				 }
			})
			
			
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>
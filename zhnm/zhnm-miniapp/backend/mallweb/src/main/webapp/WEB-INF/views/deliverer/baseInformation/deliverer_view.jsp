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
<!-- 下拉框 -->
<link rel="stylesheet" href="static/ace/css/chosen.css" />
<!-- jsp文件头和头部 -->
<%@ include file="../../system/index/top.jsp"%>
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
								<form action="deliverer/${msg }.do" name="delivererForm" id="delivererForm" method="post">
									<input type="hidden" name="deliverer_ID" id="deliverer_id" value="${pd.ID }"/>
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">账号:</td>
											<td><input type="text" name="delivererNAME" id="loginname" value="${pd.ACCOUNT}" maxlength="32" title="账号" style="width:98%;" disabled="disabled"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">姓名:</td>
											<td><input type="text" name="CNNAME" id="cnname" value="${pd.CNNAME }" maxlength="32" title="姓名" style="width:98%;" disabled="disabled"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">身份证后六位:</td>
											<td><input type="text" name="ID_CARD" id="id_card"  value="${pd.ID_CARD }"  maxlength="32" placeholder="身份证后六位" title="身份证后六位" style="width:98%;" disabled="disabled"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">保证金（￥）:</td>
											<td><input type="number" name="CREDIT" id="credit"  value="${pd.CREDIT }"  maxlength="32" title="保证金" style="width:98%;" disabled="disabled"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">年龄:</td>
											<td><input type="email" name="AGE" id="AGE"  value="${pd.AGE }" maxlength="32" title="年龄"  style="width:98%;" disabled="disabled"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">性别:</td>
											<td style="width:98%;" >
											 <c:if test="${pd.GENDER=='true' }">
											   男
											 </c:if>
											<c:if test="${pd.GENDER=='false' }">
											   女
											 </c:if>
											</td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">账户状态:</td>
											<td style="width:98%;" >
											 <c:if test="${pd.STATUS==0 }">
											   正常
											 </c:if>
											<c:if test="${pd.STATUS==1 }">
											   冻结
											 </c:if>
											 <c:if test="${pd.STATUS==2 }">
											   关闭 
											 </c:if>
											</td>
										</tr>
									</table>
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
	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- inline scripts related to this page -->
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
</body>
<script type="text/javascript">
	$(top.hangge());
	$(document).ready(function(){
		if($("#deliverer_id").val()!=""){
			$("#loginname").attr("readonly","readonly");
			$("#loginname").css("color","gray");
		}
	});
	
	//判断用户名是否存在
	function hasU(){
		var delivererNAME = $.trim($("#loginname").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>deliverer/hasU.do',
	    	data: {delivererNAME:delivererNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" == data.result){
					$("#delivererForm").submit();
					$("#zhongxin").hide();
					$("#zhongxin2").show();
				 }else{
					$("#loginname").css("background-color","#D16E6C");
					setTimeout("$('#loginname').val('此用户名已存在!')",500);
				 }
			}
		});
	}
	
	//判断邮箱是否存在
	function hasE(delivererNAME){
		var EMAIL = $.trim($("#EMAIL").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>deliverer/hasE.do',
	    	data: {EMAIL:EMAIL,delivererNAME:delivererNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" != data.result){
					 $("#EMAIL").tips({
							side:3,
				            msg:'邮箱 '+EMAIL+' 已存在',
				            bg:'#AE81FF',
				            time:3
				        });
					 $("#EMAIL").val('');
				 }
			}
		});
	}
	
	$(function() {
		//下拉框
		if(!ace.vars['touch']) {
			$('.chosen-select').chosen({allow_single_deselect:true}); 
			$(window)
			.off('resize.chosen')
			.on('resize.chosen', function() {
				$('.chosen-select').each(function() {
					 var $this = $(this);
					 $this.next().css({'width': $this.parent().width()});
				});
			}).trigger('resize.chosen');
			$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
				if(event_name != 'sidebar_collapsed') return;
				$('.chosen-select').each(function() {
					 var $this = $(this);
					 $this.next().css({'width': $this.parent().width()});
				});
			});
			$('#chosen-multiple-style .btn').on('click', function(e){
				var target = $(this).find('input[type=radio]');
				var which = parseInt(target.val());
				if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
				 else $('#form-field-select-4').removeClass('tag-input-style');
			});
		}
	});
</script>
</html>
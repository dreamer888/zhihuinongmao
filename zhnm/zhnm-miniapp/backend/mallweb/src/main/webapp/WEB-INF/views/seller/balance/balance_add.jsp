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
								<form action="sellerBlance/${msg }.do" name="userForm" id="userForm" method="post">
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<!--<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户账号:</td>
											<td><input type="text" name="ACCOUNT" id="ACCOUNT" value="${pd.ACCOUNT }" maxlength="32" placeholder="商户账号" disabled="disabled" title="商户姓名" style="width:98%;"/></td>
										</tr>  -->
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户账号:</td>
											<td id="jueses">
											<select class="chosen-select form-control" name="SELLER_ID" id="seller_id" data-placeholder="请选择商户账号" style="vertical-align:top;" style="width:98%;" >
											<option value=""></option>
											<c:forEach items="${sellerList}" var="seller">
												<option value="${seller.ID }" >${seller.ACCOUNT }</option>
											</c:forEach>
											</select>
											</td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">绑定秤:</td>
											<td id="juese">
											<select class="chosen-select form-control" name="BALANCE_ID" id="balance_id" data-placeholder="请绑定秤" style="vertical-align:top;" style="width:98%;" >
											<option value=""></option>
											<c:forEach items="${balanceList}" var="balance">
												<option value="${balance.ID }" <c:if test="${balance.BALANCE_IMEI == pd.BALANCE_IMEI }">selected</c:if>>${balance.BALANCE_IMEI }</option>
											</c:forEach>
											</select>
											</td>
										</tr>
										<tr>
											<td style="text-align: center;" colspan="10">
												<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
												<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
											</td>
										</tr>
									</table>
									</div>
									<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
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

	
   function save(){
			if($("#seller_id").val()==""){
				$("#jueses").tips({
					side:3,
		            msg:'选择商户',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#seller_id").focus();
				return false;
			}
			if($("#balance_id").val()==""){
				$("#juese").tips({
					side:3,
		            msg:'选择秤',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#balance_id").focus();
				return false;
			}
			hasIMEI();
	}
	
  function hasIMEI(){
			var SELLER_ID = $.trim($("#seller_id").val());
			if($("#seller_id").val()==""){
				$("#jueses").tips({
					side:3,
		            msg:'选择商户',
		            bg:'#AE81FF',
		            time:3
		        });
				$("#seller_id").focus();
				return false;
			}
			$.ajax({
				type: "POST",
				url: '<%=basePath%>sellerBlance/hasI.do',
		    	data: {SELLER_ID:SELLER_ID,tm:new Date().getTime()},
				dataType:'json',
				cache: false,
				success: function(data){
					 if("success" == data.result){
						    $("#userForm").submit();
							$("#zhongxin").hide();
							$("#zhongxin2").show();
					 }else{
						$("#jueses").css("background-color","#D16E6C");
						setTimeout("$('#jueses').val('该商户已绑定秤!')",500);
						alert("该商户已经绑定秤");
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
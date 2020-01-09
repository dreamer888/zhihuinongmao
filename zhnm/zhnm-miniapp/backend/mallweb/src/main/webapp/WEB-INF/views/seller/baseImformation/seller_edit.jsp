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
								<form action="seller/${msg }.do" name="userForm" id="userForm" method="post">
									<input type="hidden" name="SELLER_ID" id="SELLER_ID" value="${pd.SELLER_ID }"/>
									<input type="hidden" name="MARKET_ID" id="market_id" value="${pd.MARKET_ID }" />
						            <input type="hidden" name="CATEGORY_ID" id="category_id" value="${pd.CATEGORY_ID }"/>
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
									   <tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户名:</td>
											<td><input type="text" name="NAME" id="SELLER_NAME" value="${pd.NAME }" maxlength="32" disabled="disabled" placeholder="这里输入商户名" title="商户名" style="width:98%;"/></td>
										</tr>
									    <tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户账号:</td>
											<td><input type="text" name="SELLER_ACCOUNT" id="SELLER_ACCOUNT" value="${pd.ACCOUNT }" maxlength="32" disabled="disabled" placeholder="这里输入商户账号" title="商户账号" style="width:98%;"/></td>
										</tr>
									    <tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">绑定市场:</td>
											<td id="juese">
											<select class="chosen-select form-control" name="MARKET_ID" id="market_id" data-placeholder="绑定市场" style="vertical-align:top;" style="width:98%;" >
											<option value=""></option>
											<c:forEach items="${marketList}" var="market">
												<option value="${market.ID }" <c:if test="${market.ID == pd.MARKET_ID }">selected</c:if>>${market.MARKET_NAME }</option>
											</c:forEach>
											</select>
											</td>
									   </tr>
									   <tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">绑定分类:</td>
											<td id="juese">
											<select class="chosen-select form-control" name="CATEGORY_ID" id="category_id" data-placeholder="绑定分类" style="vertical-align:top;" style="width:98%;" >
											<option value=""></option>
											<c:forEach items="${categoryList}" var="category">
												<option value="${category.CATEGORY_ID }" <c:if test="${category.CATEGORY_ID == pd.CATEGORY_ID }">selected</c:if>>${category.CATEGORY_NAME }</option>
											</c:forEach>
											</select>
											</td>
									  </tr>
									  <tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">新密码:</td>
											<td><input type="password" name="PASSWORD" id="password"  maxlength="32" placeholder="输入密码" title="密码" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">确认密码:</td>
											<td><input type="password" name="chkpwd" id="chkpwd"  maxlength="32" placeholder="确认密码" title="确认密码" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">店铺号:</td>
											<td><input type="text" name="SHOP_CODE" id="SHOP_CODE" value="${pd.SHOP_CODE }"  maxlength="32" placeholder="店铺号" title="店铺号" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">店铺名:</td>
											<td><input type="text" name="SHOP_NAME" id="SHOP_NAME" value="${pd.SHOP_NAME }"  maxlength="32" placeholder="店铺名" title="店铺名" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">营业照号码:</td>
											<td><input type="text" name="BUSINESS_LICENSE_CODE" id="BUSINESS_LICENSE_CODE"  value="${pd.BUSINESS_LICENSE_CODE }"  maxlength="32" placeholder="这里输入营业照号码" title="营业照号码" style="width:98%;"/></td>
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
	//保存
    function save(){
		if($("#SHOP_CODE").val()==""){
			$("#SHOP_CODE").tips({
				side:3,
	            msg:'填写店铺号',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SHOP_CODE").focus();
			return false;
		}else{
			$("#SHOP_CODE").val($.trim($("#SHOP_CODE").val()));
		}
		 if($("#password").val() ==""){
				
				$("#password").tips({
					side:3,
		            msg:'输入密码',
		            bg:'#AE81FF',
		            time:3
		        });
				$("#password").focus();
				return false;
			}
		
     if($("#password").val()!=$("#chkpwd").val()){
			
			$("#chkpwd").tips({
				side:3,
	            msg:'两次密码不相同',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#chkpwd").focus();
			return false;
		}
     
		if($("#SHOP_NAME").val()==""){
			$("#SHOP_NAME").tips({
				side:3,
	            msg:'输入店铺名',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#SHOP_NAME").focus();
			return false;
		}else{
			$("#SHOP_NAME").val($.trim($("#SHOP_NAME").val()));
		}
		
		if($("#BUSINESS_LICENSE_CODE").val()==""){
			$("#BUSINESS_LICENSE_CODE").tips({
				side:3,
	            msg:'输入营业执照号码',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#BUSINESS_LICENSE_CODE").focus();
			return false;
		}else{
			$("#BUSINESS_LICENSE_CODE").val($.trim($("#BUSINESS_LICENSE_CODE").val()));
		}
		
		
		if($("#CATEGORY_NAME").val()==""){
			
			$("#CATEGORY_NAME").tips({
				side:3,
	            msg:'输入邮箱',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#CATEGORY_NAME").focus();
			return false;
		}
			$("#userForm").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
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
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
								<form action="sellerCreditAndWallet/${msg }.do" name="userForm" id="userForm" method="post">
									<input type="hidden" name="CREDITANDWALLET_ID" id="CREDITANDWALLET_ID" value="${pd.ID }"/>
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户账号:</td>
											<td><input type="text" name="ACCOUNT" id="ACCOUNT" value="${pd.ACCOUNT }" maxlength="32" disabled="disabled" placeholder="商户账号" title="商户账号" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户姓名:</td>
											<td><input type="text" name="NAME" id="NAME" value="${pd.NAME }" maxlength="32" disabled="disabled" placeholder="商户姓名" title="商户姓名"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户积分:</td>
											<td><input type="NUMBER" name="SELLER_POINTS" id="SELLER_POINTS"  value="${pd.SELLER_POINTS }" maxlength="32" placeholder="商户积分" title="商户积分" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户余额:</td>
											<td><input type="text" name="SELLER_WALLET" id="SELLER_WALLET" value="${pd.SELLER_WALLET }"  maxlength="32" placeholder="商户余额" title="商户余额" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">评价总分:</td>
											<td><input type="text" name="EVALUATION_TOTAL" id="EVALUATION_TOTAL"  value="${pd.EVALUATION_TOTAL }"  maxlength="32"  placeholder="评价总分" title="评价总分" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">评价总次数:</td>
											<td><input type="text" name="EVALUATION_COUNT" id="EVALUATION_COUNT"  value="${pd.EVALUATION_COUNT }"  maxlength="32"  placeholder="评价总次数" title="评价总次数" style="width:98%;"/></td>
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
		
		if($("#SELLER_POINTS").val()=="" ){
			$("#SELLER_POINTS").tips({
				side:3,
	            msg:'输入商户积分',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SELLER_POINTS").focus();
			return false;
		}else{
			$("#SELLER_POINTS").val($.trim($("#SELLER_POINTS").val()));
		}
		if($("#SELLER_POINTS").val()<0 ){
			$("#SELLER_POINTS").tips({
				side:3,
	            msg:'商户积分非负数',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#SELLER_POINTS").focus();
			return false;
		}
		
	   if($("#SELLER_WALLET").val()==""){
			$("#SELLER_WALLET").tips({
				side:3,
	            msg:'输入钱包余额',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#SELLER_WALLET").focus();
			return false;
		}else{
			$("#SELLER_WALLET").val($.trim($("#SELLER_WALLET").val()));
		}
	   if($("#SELLER_WALLET").val()<0){
			$("#SELLER_WALLET").tips({
				side:3,
	            msg:'钱包余额非负数',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#SELLER_WALLET").focus();
			return false;
		}
		if($("#EVALUATION_TOTAL").val()==""){
			$("#EVALUATION_TOTAL").tips({
				side:3,
	            msg:'输入评价总分',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#EVALUATION_TOTAL").focus();
			return false;
		}else{
			$("#EVALUATION_TOTAL").val($.trim($("#EVALUATION_TOTAL").val()));
		}
		if($("#EVALUATION_TOTAL").val() < 0){
			$("#EVALUATION_TOTAL").tips({
				side:3,
	            msg:'评价总分非负数',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#EVALUATION_TOTAL").focus();
			return false;
		}
		if($("#EVALUATION_COUNT").val()==""){
			$("#EVALUATION_COUNT").tips({
				side:3,
	            msg:'输入评价总次数',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#EVALUATION_COUNT").focus();
			return false;
		}else{
			$("#EVALUATION_COUNT").val($.trim($("#EVALUATION_COUNT").val()));
		}
		if($("#EVALUATION_COUNT").val() < 0 ){
			$("#EVALUATION_COUNT").tips({
				side:3,
	            msg:'评价总次数非负数',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#EVALUATION_COUNT").focus();
			return false;
		}
			$("#userForm").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		
	}
	//判断用户名是否存在
	function hasU(){
		var USERNAME = $.trim($("#loginname").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasU.do',
	    	data: {USERNAME:USERNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" == data.result){
					$("#userForm").submit();
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
	function hasE(USERNAME){
		var EMAIL = $.trim($("#EMAIL").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasE.do',
	    	data: {EMAIL:EMAIL,USERNAME:USERNAME,tm:new Date().getTime()},
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
	
	//判断编码是否存在
	function hasN(USERNAME){
		var NUMBER = $.trim($("#NUMBER").val());
		$.ajax({
			type: "POST",
			url: '<%=basePath%>user/hasN.do',
	    	data: {NUMBER:NUMBER,USERNAME:USERNAME,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" != data.result){
					 $("#NUMBER").tips({
							side:3,
				            msg:'编号 '+NUMBER+' 已存在',
				            bg:'#AE81FF',
				            time:3
				        });
					 $("#NUMBER").val('');
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
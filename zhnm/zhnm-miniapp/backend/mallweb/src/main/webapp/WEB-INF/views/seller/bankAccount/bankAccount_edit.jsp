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
								<form action="sellerBankAccount/${msg }.do" name="userForm" id="userForm" method="post">
									<input type="hidden" name="BANKACCOUNT_ID" id="BANKACCOUNT_ID" value="${pd.ID }"/>
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户姓名:</td>
											<td><input type="text" name="NAME" id="NAME" value="${pd.NAME }" maxlength="32" placeholder="商户姓名" disabled="disabled" title="商户姓名" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户身份证:</td>
											<td><input type="text" name="ID_CARD_LAST" id="ID_CARD_LAST" value="${pd.ID_CARD_LAST }" maxlength="32" disabled="disabled" placeholder="身份证" title="身份证" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">开户行:</td>
											<td><input type="text" name="ACCOUNT_BANK" id="ACCOUNT_BANK" value="${pd.ACCOUNT_BANK }"  maxlength="32" placeholder="开户行" title="开户行" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">开户名:</td>
											<td><input type="text" name="ACCOUNT_NAME" id="ACCOUNT_NAME" value="${pd.ACCOUNT_NAME }"  maxlength="32" placeholder="确认密码" title="确认密码" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">银行账号:</td>
											<td><input type="text" name="ACCOUNT" id="ACCOUNT"  value="${pd.ACCOUNT }"  maxlength="32" placeholder="银行账号" title="银行账号" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">预留电话:</td>
											<td><input type="text" name="ACCOUNT_PHONE" id="ACCOUNT_PHONE"  value="${pd.ACCOUNT_PHONE }"  maxlength="32" placeholder="预留电话" title="预留电话" style="width:98%;"/></td>
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
		if($("#NAME").val()==""){
			$("#NAME").tips({
				side:3,
	            msg:'选择姓名',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#NAME").focus();
			return false;
		}else{
			$("#NAME").val(jQuery.trim($('#NAME').val()));
		}
		if($("#ID_CARD_LAST").val()==""){
			$("#ID_CARD_LAST").tips({
				side:3,
	            msg:'输入身份证后六位',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ID_CARD_LAST").focus();
			return false;
		}else{
			$("#ID_CARD_LAST").val($.trim($("#ID_CARD_LAST").val()));
		}
		if($("#ACCOUNT_BANK").val()==""){
			$("#ACCOUNT_BANK").tips({
				side:3,
	            msg:'输入开户行',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ACCOUNT_BANK").focus();
			return false;
		}else{
			$("#ACCOUNT_BANK").val($.trim($("#ACCOUNT_BANK").val()));
		}
		
		if($("#ACCOUNT_BANK").val().length > 30){
			$("#ACCOUNT_BANK").tips({
				side:3,
	            msg:'开户行最多14位长度',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ACCOUNT_BANK").focus();
			return false;
		}else{
			$("#ACCOUNT_BANK").val($.trim($("#ACCOUNT_BANK").val()));
		}
		
		if($("#ACCOUNT").val()==""){
			$("#ACCOUNT").tips({
				side:3,
	            msg:'输入开户行',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ACCOUNT").focus();
			return false;
		}else{
			$("#ACCOUNT").val($.trim($("#ACCOUNT").val()));
		}
		if($("#ACCOUNT").val().length >20){
			$("#ACCOUNT").tips({
				side:3,
	            msg:'输入正确的银行卡号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ACCOUNT").focus();
			return false;
		}
		var myreg = /^(((13[0-9]{1})|159)+\d{8})$/;
			if($("#ACCOUNT_PHONE").val()==""){
				
				$("#ACCOUNT_PHONE").tips({
					side:3,
		         msg:'输入银行预留手机号',
		         bg:'#AE81FF',
		         time:3
		     });
				$("#ACCOUNT_PHONE").focus();
				return false;
			}else if($("#ACCOUNT_PHONE").val().length != 11 && !myreg.test($("#ACCOUNT_PHONE").val())){
				$("#ACCOUNT_PHONE").tips({
					side:3,
		         msg:'手机号格式不正确',
		         bg:'#AE81FF',
		         time:3
		     });
				$("#ACCOUNT_PHONE").focus();
				return false;
			}
			$("#userForm").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		
	}
	
	
	
	
</script>
</html>
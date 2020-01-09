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
								<form action="bankAccounts/${msg }.do" name="balanceForm" id="balanceForm" method="post">
								    <input type="hidden" name="BANKACCOUNT_ID" id="BANKACCOUNT_ID" value="${pd.ID }"/>
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">姓名:</td>
											<td><input type="text" name="CNNAME" id="CNNAME" value="${pd.CNNAME }" maxlength="32" placeholder="这里输入姓名" disabled="disabled" title="姓名" style="width:98%;"/></td>
										</tr>
										
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">身份证:</td>
											<td><input type="text" name="ID_CARD" id="ID_CARD" value="${pd.ID_CARD }" maxlength="32" placeholder="身份证" title="身份证" disabled="disabled"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">开户行:</td>
											<td><input type="text" name="ACCOUNT_BANK" id="ACCOUNT_BANK" value="${pd.ACCOUNT_BANK }" maxlength="32" placeholder="开户行" title="开户行"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">开户名:</td>
											<td><input type="text" name="ACCOUNT_NAME" id="ACCOUNT_NAME" value="${pd.ACCOUNT_NAME }" maxlength="32" placeholder="开户名" title="开户名"   style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">账号:</td>
											<td><input type="text" name="ACCOUNT" id="ACCOUNT" value="${pd.ACCOUNT }" maxlength="32" placeholder="账号" title="账号"  style="width:98%;"/></td>
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
		
		if($("#ACCOUNT_BANK").val()==""){
			$("#ACCOUNT_BANK").tips({
				side:3,
	            msg:'输入开户行',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ACCOUNT_BANK").focus();
			return false;
		}
		if($("#ACCOUNT_BANK").val().length > 30){
			$("#ACCOUNT_BANK").tips({
				side:3,
	            msg:'输入开户行 30位数以内',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ACCOUNT_BANK").focus();
			return false;
		}
		
		if($("#ACCOUNT_NAME").val()==""){
			$("#ACCOUNT_NAME").tips({
				side:3,
	            msg:'输入开户名',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ACCOUNT_NAME").focus();
			return false;
		}
		if($("#ACCOUNT_NAME").val().length > 10){
			$("#ACCOUNT_NAME").tips({
				side:3,
	            msg:'开户名10位数以内',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ACCOUNT_NAME").focus();
			return false;
		}
		if($("#ACCOUNT").val()==""){
			$("#ACCOUNT").tips({
				side:3,
	            msg:'输入银行卡号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ACCOUNT").focus();
			return false;
		}
		if($("#ACCOUNT").val().length>20){
			$("#ACCOUNT").tips({
				side:3,
	            msg:'银行卡号不正确',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#ACCOUNT").focus();
			return false;
		}
		$("#balanceForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
	
</script>
</html>
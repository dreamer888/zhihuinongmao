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
								<form action="dBalance/${msg }.do" name="balanceForm" id="balanceForm" method="post">
								   <input type="hidden" name="ID" id="dBalance_id" value="${pd.ID }"/>
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">姓名:</td>
											<td><input type="text" name="CNNAME" id="CNNAME" value="${pd.CNNAME }" maxlength="32" disabled="disabled" placeholder="姓名" title="姓名"  style="width:98%;"/></td>
										</tr>
										
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">账号:</td>
											<td><input type="text" name="ACCOUNT" id="ACCOUNT" value="${pd.ACCOUNT }" maxlength="32" placeholder="账号" title="账号" disabled="disabled"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">积分:</td>
											<td><input type="text" name="POINTS" id="POINTS" value="${pd.POINTS }" maxlength="32" placeholder="积分" title="积分"   style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">总额:</td>
											<td><input type="text" name="WALLET" id="WALLET" value="${pd.WALLET }" maxlength="32" placeholder="总额" title="总额"   style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">评价总分:</td>
											<td><input type="text" name="EVALUATION_TOTAL" id="EVALUATION_TOTAL" value="${pd.EVALUATION_TOTAL }" maxlength="32"   disabled="disabled"  placeholder="评价总分" title="评价总分"   style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">评价总次数:</td>
											<td><input type="text" name="EVALUATION_COUNT" id="EVALUATION_COUNT" value="${pd.EVALUATION_COUNT }" maxlength="32"  disabled="disabled"  placeholder="评价总次数" title="评价总次数"   style="width:98%;"/></td>
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
		if($("#WALLET").val()==""){
			$("#WALLET").tips({
				side:3,
	            msg:'输入总额',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#WALLET").focus();
			return false;
		}
		if($("#WALLET").val() < 0){
			$("#WALLET").tips({
				side:3,
	            msg:'总额非负数',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#WALLET").focus();
			return false;
		}
		if($("#POINTS").val()==""){
			$("#POINTS").tips({
				side:3,
	            msg:'输入积分数',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#POINTS").focus();
			return false;
		}
		if($("#POINTS").val()  < 0){
			$("#POINTS").tips({
				side:3,
	            msg:'输入积分数 非负数',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#POINTS").focus();
			return false;
		}
		$("#balanceForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}

</script>
</html>
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
<%@ include file="../system/index/top.jsp"%>
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
								<form action="balance/${msg }.do" name="balanceForm" id="balanceForm" method="post">
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">IMEI&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
											<td><input type="text" name="IMEI" id="IMEI" value="${pd.IMEI }" maxlength="32" placeholder="这里输入IMEI号" title="IMEI号"  style="width:98%;"/></td>
										</tr>
										
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
											<td><input type="text" name="MODEL" id="MODEL" value="${pd.MODEL }" maxlength="32" placeholder="这里输入型号" title="型号"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</td>
											<td>
											<select name="USED" id="USED" style="width:98%;">
								             <option value="1">使用</option>
								             <option value="0">未使用</option>
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
	<%@ include file="../system/index/foot.jsp"%>
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
		if($("#IMEI").val()==""){
			$("#IMEI").tips({
				side:3,
	            msg:'输入IMEI号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#IMEI").focus();
			return false;
		}
		if($("#IMEI").val().length >20){
			$("#IMEI").tips({
				side:3,
	            msg:'IMEI号 20位以内',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#IMEI").focus();
			return false;
		}
		
		
		
		if($("#IMEI").val()=="此IMEI号已存在!"){
			$("#IMEI").tips({
				side:3,
	            msg:'输入IMEI号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#IMEI").focus();
			return false;
		}
		
		if($("#MODEL").val()==""){
			$("#MODEL").tips({
				side:3,
	            msg:'输入型号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#MODEL").focus();
			return false;
		}
		if($("#MODEL").val().length > 15){
			$("#MODEL").tips({
				side:3,
	            msg:'型号15位以内',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#MODEL").focus();
			return false;
		}
		hasIMEI();
		
		
	}
	
	//判断IMEI号是否存在
	function hasIMEI(){
        
		var balanceIMEI = $.trim($("#IMEI").val());
		
		if($("#IMEI").val()==""){
			$("#IMEI").tips({
				side:3,
	            msg:'输入IMEI号',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#IMEI").focus();
			return false;
		}
		
		$.ajax({
			type: "POST",
			url: '<%=basePath%>balance/hasI.do',
	    	data: {BALANCE_IMEI:balanceIMEI,tm:new Date().getTime()},
			dataType:'json',
			cache: false,
			success: function(data){
				 if("success" == data.result){
					$("#balanceForm").submit();
					$("#zhongxin").hide();
					$("#zhongxin2").show();
				 }else{
					$("#IMEI").css("background-color","#D16E6C");
					setTimeout("$('#IMEI').val('此IMEI号已存在!')",500);
				 }
			}
		});
	}

	
</script>
</html>
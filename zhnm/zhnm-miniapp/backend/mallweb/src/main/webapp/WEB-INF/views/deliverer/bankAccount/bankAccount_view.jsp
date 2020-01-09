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
					
					<form action="balance/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="balance_id" id="balance_id" value="${pd.ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">IMEI&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
								<td><input type="text" name="imei" id="imei" value="${pd.BALANCE_IMEI}" maxlength="255" placeholder="这里输入IMEI号" title="IMEI号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
								<td><input type="text" name="model" id="model" value="${pd.BALANCE_MODEL}" maxlength="255" placeholder="这里输入型号" title="型号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">是否使用:</td>
								<td><input type="text" name="used" id="used" value="${pd.USED}" maxlength="255" placeholder="这里输入状态" title="状态" style="width:98%;"/> 
								   <!--  <select id="used" style="width:98%;" maxlength="255" >
								    <c:if test="${ balance.USED =='false' }">
								    <option  id="0" value="未使用">未使用</option>
								    </c:if>
								    <c:if test="${ balance.USED =='true' }">
								     <option  id="1" value="使用">使用</option>
								     </c:if>
								    </select>-->
								
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
		<%@ include file="../../system/index/foot.jsp"%>
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
			if($("#imei").val()==""){
				$("#imei").tips({
					side:3,
		            msg:'请输入IMEI号',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#imei").focus();
			return false;
			}
			
			if($("#model").val()==""){
				$("#model").tips({
					side:3,
		            msg:'请输入型号',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#model").focus();
			return false;
			}
			if($("#used").val()==""){
				$("#used").tips({
					side:3,
		            msg:'请输入状态',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#used").focus();
			return false;
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		</script>
</body>
</html>
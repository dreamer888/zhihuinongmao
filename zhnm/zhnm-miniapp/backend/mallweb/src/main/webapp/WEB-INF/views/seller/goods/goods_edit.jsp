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
								<form action="sellerGoods/${msg }.do" name="userForm" id="userForm" method="post">
									<input type="hidden" name="GOODS_ID" id="GOODS_ID" value="${pd.ID }"/>
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户账号:</td>
											<td><input type="text" name="ACCOUNT" id="ACCOUNT" value="${pd.ACCOUNT }" maxlength="32" placeholder="这里输入商户账号" disabled="disabled" title="商户账号" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商户姓名:</td>
											<td><input type="text" name="NAME" id="NAME" value="${pd.NAME }" maxlength="32" placeholder="这里输入编号" disabled="disabled" title="编号" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">商品名:</td>
											<td><input type="text" name="GOODS_NAME" id="GOODS_NAME"  maxlength="32" value="${pd.GOODS_NAME }"  placeholder="商品名" title="商品名" disabled="disabled" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">上/下架:</td>
											<td>
											<c:if test="${pd.STATUS==0 }" >
											  <select style="width:98%;" name="STATUS" id="STATUS" >
											   <option value="0">上架</option>
											   <option value="1">下架</option>
											  </select>
											</c:if>
											<c:if test="${pd.STATUS==1 }">
											  <select style="width:98%;"  name="STATUS" id="STATUS">
											   <option value="1">下架</option>
											   <option value="0">上架</option>
											  </select>
											</c:if>
											</td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">初始库存（KG）:</td>
											<td><input type="NUMBER" name="START_STOCK" id="START_STOCK"  value="${pd.START_STOCK }"  maxlength="32" placeholder="初始库存" title="初始库存" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">当前库存（KG）:</td>
											<td><input type="NUMBER" name="CURRENT_STOCK" id="CURRENT_STOCK"  value="${pd.CURRENT_STOCK }"  maxlength="32" placeholder="当前库存" title="当前库存" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">单价（/KG）:</td>
											<td><input type="text" name="PRICE" id="PRICE"  value="${pd.PRICE }"  maxlength="32" placeholder="单价" title="单价" style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">秤快捷键:</td>
											<td><input type="text" name="BALANCE_HOTKEY" id="BALANCE_HOTKEY"  value="${pd.BALANCE_HOTKEY }"  maxlength="32" placeholder="秤快捷键" title="秤快捷键" style="width:98%;"/></td>
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
		if($("#START_STOCK").val()==""){
			$("#START_STOCK").tips({
				side:3,
	            msg:'输入初始库存',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#START_STOCK").focus();
			return false;
		}else{
			$("#START_STOCK").val(jQuery.trim($('#START_STOCK').val()));
		}
		if($("#START_STOCK").val() < 0 ){
			$("#START_STOCK").tips({
				side:3,
	            msg:'初始库存非负数',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#START_STOCK").focus();
			return false;
		}

		if($("#CURRENT_STOCK").val()==""){
			$("#CURRENT_STOCK").tips({
				side:3,
	            msg:'输入当前库存',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#CURRENT_STOCK").focus();
			return false;
		}else{
			$("#CURRENT_STOCK").val($.trim($("#CURRENT_STOCK").val()));
		}
		if($("#CURRENT_STOCK").val() < 0){
			$("#CURRENT_STOCK").tips({
				side:3,
	            msg:'当前库存非负数',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#CURRENT_STOCK").focus();
			return false;
		}
		if($("#PRICE").val()==""){
			$("#PRICE").tips({
				side:3,
	            msg:'输入单价',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#PRICE").focus();
			return false;
		}else{
			$("#PRICE").val($.trim($("#PRICE").val()));
		}
		if($("#PRICE").val()  < 0 ){
			$("#PRICE").tips({
				side:3,
	            msg:'单价非负数',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#PRICE").focus();
			return false;
		}
		if($("#BALANCE_HOTKEY").val()==""){
			$("#BALANCE_HOTKEY").tips({
				side:3,
	            msg:'输入快捷键',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#BALANCE_HOTKEY").focus();
			return false;
		}
		if($("#BALANCE_HOTKEY").val().length > 6){
			$("#BALANCE_HOTKEY").tips({
				side:3,
	            msg:'快捷键最多6位数',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#BALANCE_HOTKEY").focus();
			return false;
		}
		
			$("#userForm").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		
	}
	
	
</script>
</html>
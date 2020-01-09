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
	<%@ include file="../system/index/top.jsp"%>
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
					
					<form action="market/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="market_id" id="market_id" value="${pd.ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">市场名称:</td>
								<td><input type="text" name="market_name" id="market_name" value="${pd.MARKET_NAME}" maxlength="255" placeholder="这里输入市场名称" title="市场名称" style="width:98%;"/></td>
							</tr>
							<tr>  
								<td style="width:75px;text-align: right;padding-top: 13px;">所在省:</td>
								<td><input type="text" name="market_province" id="market_province" value="${pd.MARKET_PROVINCE}" maxlength="255" placeholder="这里输入所在省" title="所在省" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">所在市:</td>
								<td><input type="text" name="market_city" id="market_city" value="${pd.MARKET_CITY}" maxlength="255" placeholder="这里输入所在市" title="所在市" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">所在区:</td>
								<td><input type="text" name="market_district" id="market_district" value="${pd.MARKET_DISTRICT}" step="1" maxlength="255" placeholder="这里输入所在区" title="所在区" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">详细地址:</td>
								<td><input type="text" name="market_address" id="market_address" value="${pd.MARKET_ADDRESS}" maxlength="32" placeholder="这里输入详细地址" title="详细地址" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">经纬度:</td>
								<td><input type="text" name="market_coords" id="market_coords" value="${pd.MARKET_COORDS}" maxlength="32" placeholder="这里输入经纬度" title="经纬度" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">高德ID:</td>
								<td><input type="NUMBER" name="gaode_id" id="gaode_id" value="${pd.GEODE_ID}" maxlength="32" placeholder="这里输入高德地图ID" title="高德地图ID" style="width:98%;"/></td>
							</tr>
							
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">状态:</td>
								<td>
								<select name="type" id="type" style="width:98%;">
								<option value="1" <c:if test="${pd.MARKET_STATUS==1}">selected</c:if>>关闭</option>
								<option value="0" <c:if test="${pd.MARKET_STATUS== 0}">selected</c:if>>正常</option>
								</select>
								</td>
							</tr>
							<!--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">开始时间:</td>
								<td><input type="text" class="span10 date-picker" data-date-format="yyyy-mm-dd" readonly="readonly" name="starttime" id="starttime" value="${pd.starttime}" maxlength="255" placeholder="这里输入开始时间" title="开始时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">结束时间:</td>
								<td><input type="text" class="span10 date-picker" data-date-format="yyyy-mm-dd" readonly="readonly" name="endtime" id="endtime" value="${pd.endtime}" maxlength="255" placeholder="这里输入结束时间" title="结束时间" style="width:98%;"/></td>
							</tr>-->
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
	<%@ include file="../system/index/foot.jsp"%>
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
			var type = $('#type').val();
			
			if($("#market_name").val()==""){
				$("#market_name").tips({
					side:3,
		            msg:'请输入市场名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_name").focus();
			return false;
			}
			if($("#market_name").val().length > 30){
				$("#market_name").tips({
					side:3,
		            msg:'市场名称长度为30位以内',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_name").focus();
			return false;
			}
			if($("#market_province").val()==""){
				$("#market_province").tips({
					side:3,
		            msg:'请输入所在省',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_province").focus();
			return false;
			}
			if($("#market_province").val().length > 18){
				$("#market_province").tips({
					side:3,
		            msg:'所在省长度在18位数以内',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_province").focus();
			return false;
			}
			if($("#market_city").val()==""){
				$("#market_city").tips({
					side:3,
		            msg:'请输入所在市',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_city").focus();
			return false;
			}
			if($("#market_city").val().length > 20){
				$("#market_city").tips({
					side:3,
		            msg:'所在市在20位数以内',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_city").focus();
			return false;
			}
			
			if($("#market_district").val()==""){
				$("#market_district").tips({
					side:3,
		            msg:'所在区',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_district").focus();
			return false;
			}
			if($("#market_district").val().length > 20){
				$("#market_district").tips({
					side:3,
		            msg:'所在区在20位数以内',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_district").focus();
			return false;
			}
			if($("#market_address").val()==""){
				$("#market_address").tips({
					side:3,
		            msg:'请输入详细地址',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_address").focus();
			return false;
			}
			if($("#market_address").val().length > 50){
				$("#market_address").tips({
					side:3,
		            msg:'详细地址在50位数以内',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_address").focus();
			return false;
			}
			if($("#market_coords").val()==""){
				$("#market_coords").tips({
					side:3,
		            msg:'请输入经纬度',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_coords").focus();
			return false;
			}
			if($("#market_coords").val().length > 30){
				$("#market_coords").tips({
					side:3,
		            msg:'经纬度在30位数以内',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#market_coords").focus();
			return false;
			}
			if($("#gaode_id").val() == ""){
				$("#gaode_id").tips({
					side:3,
		            msg:'输入高德ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#gaode_id").focus();
			return false;
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>
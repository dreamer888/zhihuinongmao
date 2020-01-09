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
<link rel="stylesheet" type="text/css" href="static/css/timePicker.css">

<link rel="stylesheet" type="text/css" href="static/clockpicker-gh-pages/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="static/clockpicker-gh-pages/dist/bootstrap-clockpicker.min.css">
<link rel="stylesheet" type="text/css" href="static/clockpicker-gh-pages/assets/css/github.min.css">
<script type="text/javascript" src="static/clockpicker-gh-pages/assets/js/jquery.min.js"></script>
<script type="text/javascript" src="static/clockpicker-gh-pages/assets/js/bootstrap.min.js"></script>

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
								<form action="market/${msg }.do" name="marketForm" id="marketForm" method="post">
									<div id="zhongxin" style="padding-top: 13px;">
									<table id="table_report" class="table table-striped table-bordered table-hover">
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">市场名称:</td>
											<td><input type="text" name="MARKET_NAME" id="marke_tname" value="${pd.MARKET_NAME }" maxlength="32" placeholder="这里输入这里市场名" title="市场名"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">所在省:</td>
											<td><input type="text" name="MARKET_PROVINCE" id="market_province" value="${pd.MARKET_PROVINCE }" maxlength="32" placeholder="这里输入省" title="省"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">所在市:</td>
											<td><input type="text" name="MARKET_CITY" id="market_city" value="${pd.MARKET_CITY }" maxlength="32" placeholder="这里输入城市" title="城市"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">所在区:</td>
											<td><input type="text" name="MARKET_DISTRICT" id="market_district" value="${pd.MARKET_DISTRICT }" maxlength="32" placeholder="这里输入区" title="区"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">详细地址:</td>
											<td><input type="text" name="MARKET_ADDRESS" id="market_address" value="${pd.MARKET_ADDRESS }" maxlength="32" placeholder="这里输入详细地址" title="详细地址"  style="width:98%;"/></td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">经纬度:</td>
											<td><input type="text" name="MARKET_COORDS" id="market_coords" value="${pd.MARKET_COORDS }" maxlength="32" placeholder="这里输入经纬度" title="经纬度"  style="width:98%;"/></td>
										</tr>
										<tr>
										<td style="width:79px;text-align: right;padding-top: 13px;">开市时间:</td>
										<td>
										  <div class="input-group clockpicker" style="width:100%;">
			                                <input type="text" class="form-control" style="width:98%;" name="MARKET_OPENTIME" value="06:00">
		                                   </div>
										</td>
										</tr>
										<tr>
										<td style="width:79px;text-align: right;padding-top: 13px;">闭市时间:</td>
										<td>
										   <div class="input-group clockpicker" style="width:100%;">
			                                <input type="text" class="form-control" style="width:98%;" name="MARKET_CLOSETIME" value="22:00">
		                                   </div>
										</td>
										</tr>
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">高德ID:</td>
											<td><input type="NUMBER" name="GAODE_ID" id="gaode_id" value="${pd.GAODE_ID}" maxlength="32" placeholder="这里输入高德ID" title="高德ID"  style="width:98%;"/></td>
										</tr>
										
										<tr>
											<td style="width:79px;text-align: right;padding-top: 13px;">市场状态:</td>
											<td>
											<select name="MARKET_STATUS" id="market_status" style="width:98%;">
								             <option value="1">关闭</option>
								             <option value="0">正常</option>
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
	
	<script type="text/javascript" src="static/js/timepicker/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="static/js/timepicker/jquery-timepicker.js"></script>
	<!-- /.main-container -->
	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/js/ACalendar.js"></script>
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
		if($("#marke_tname").val()==""){
			$("#marke_tname").tips({
				side:3,
	            msg:'输入市场名称',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#marke_tname").focus();
			return false;
		}
		if($("#market_province").val()==""){
			$("#market_province").tips({
				side:3,
	            msg:'输入所在省',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#market_province").focus();
			return false;
		}
		if($("#market_city").val()==""){
			$("#market_city").tips({
				side:3,
	            msg:'输入所在城市',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#market_city").focus();
			return false;
		}
		if($("#market_district").val()==""){
			$("#market_district").tips({
				side:3,
	            msg:'输入详细地址',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#market_district").focus();
			return false;
		}
		if($("#market_coords").val()==""){
			$("#market_coords").tips({
				side:3,
	            msg:'输入所在经纬度',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#market_coords").focus();
			return false;
		}
		if($("#gaode_id").val()==""){
			$("#gaode_id").tips({
				side:3,
	            msg:'输入高德地图ID',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#gaode_id").focus();
			return false;
		}
		if($("#gaode_id").val() < 0){
			$("#gaode_id").tips({
				side:3,
	            msg:'输入正确的高德地图ID',
	            bg:'#AE81FF',
	            time:3
	        });
			$("#gaode_id").focus();
			return false;
		}
		$("#marketForm").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
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
<script type="text/javascript" src="static/clockpicker-gh-pages/dist/bootstrap-clockpicker.min.js"></script>
<script type="text/javascript">
$('.clockpicker').clockpicker()
	.find('input').change(function(){
		console.log(this.value);
	});
var input = $('#single-input').clockpicker({
	placement: 'bottom',
	align: 'left',
	autoclose: true,
	'default': 'now'
});
$('.clockpicker-with-callbacks').clockpicker({
		donetext: 'Done',
		init: function() { 
			console.log("colorpicker initiated");
		},
		beforeShow: function() {
			console.log("before show");
		},
		afterShow: function() {
			console.log("after show");
		},
		beforeHide: function() {
			console.log("before hide");
		},
		afterHide: function() {
			console.log("after hide");
		},
		beforeHourSelect: function() {
			console.log("before hour selected");
		},
		afterHourSelect: function() {
			console.log("after hour selected");
		},
		beforeDone: function() {
			console.log("before done");
		},
		afterDone: function() {
			console.log("after done");
		}
	})
	.find('input').change(function(){
		console.log(this.value);
	});
$('#check-minutes').click(function(e){
	// Have to stop propagation here
	e.stopPropagation();
	input.clockpicker('show')
			.clockpicker('toggleView', 'minutes');
});
if (/mobile/i.test(navigator.userAgent)) {
	$('input').prop('readOnly', true);
}
</script>
</html>
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
					
					<form action="coupon/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="coupon_id" id="coupon_id" value="${pd.coupon_id}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">名称:</td>
								<td><input type="text" name="coupon_name" id="coupon_name" value="${pd.coupon_name}" maxlength="255" placeholder="这里输入优惠券名称" title="优惠券名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">领取方式:</td>
								<td>
								<select name="type" id="type" style="width:98%;" onchange="showdui()">
								<option value="1" <c:if test="${pd.type==1}">selected</c:if>>网页</option>
								<option value="2" <c:if test="${pd.type==2}">selected</c:if>>兑换码</option>
								</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">开始时间:</td>
								<td><input type="text" class="span10 date-picker" data-date-format="yyyy-mm-dd" readonly="readonly" name="starttime" id="starttime" value="${pd.starttime}" maxlength="255" placeholder="这里输入开始时间" title="开始时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">结束时间:</td>
								<td><input type="text" class="span10 date-picker" data-date-format="yyyy-mm-dd" readonly="readonly" name="endtime" id="endtime" value="${pd.endtime}" maxlength="255" placeholder="这里输入结束时间" title="结束时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">优惠券价格:</td>
								<td><input type="number" name="coupon_price" id="coupon_price" value="${pd.coupon_price}" maxlength="255" placeholder="这里输入优惠券价格" title="优惠券价格" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">使用额度:</td>
								<td><input type="number" name="use_price" id="use_price" value="${pd.use_price}" maxlength="255" placeholder="这里输入订单金额满多少可以使用优惠券" title="使用额度" style="width:98%;"/></td>
							</tr>
							<tr id="dui" <c:if test="${pd.type!=2}">style="display: none"</c:if>>
								<td style="width:75px;text-align: right;padding-top: 13px;">兑换码:</td>
								<td><input type="number" name="coupon_num" id="coupon_num" value="${pd.coupon_num}" step="1" maxlength="255" placeholder="这里输入兑换码" title="兑换码" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">优惠券数量:</td>
								<td><input type="number" name="coupon_count" id="coupon_count" value="${pd.coupon_count}" maxlength="32" placeholder="这里输入优惠券数量" title="优惠券数量" style="width:98%;"/></td>
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
		
		function showdui(){
			var type = $('#type').val();
			if(type==2){
				$('#dui').show();
			}else{
				$('#dui').hide();
			}
		}
		function save(){
			var type = $('#type').val();
			if($("#coupon_name").val()==""){
				$("#coupon_name").tips({
					side:3,
		            msg:'请输入优惠券名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#coupon_name").focus();
			return false;
			}
			if($("#starttime").val()==""){
				$("#starttime").tips({
					side:3,
		            msg:'请输入开始时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#starttime").focus();
			return false;
			}
			if($("#endtime").val()==""){
				$("#endtime").tips({
					side:3,
		            msg:'请输入结束时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#endtime").focus();
			return false;
			}
			if($("#starttime").val()>$("#endtime").val()){
				$("#endtime").tips({
					side:3,
		            msg:'结束时间必须大于等于开始时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#endtime").focus();
				return ;
			}
			if($("#coupon_price").val()==""){
				$("#coupon_price").tips({
					side:3,
		            msg:'请输入优惠券价格',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#coupon_price").focus();
			return false;
			}
			if($("#use_price").val()==""){
				$("#use_price").tips({
					side:3,
		            msg:'请输入使用额度',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#use_price").focus();
			return false;
			}
			if(parseFloat($("#use_price").val())<parseFloat($("#coupon_price").val())){
				$("#use_price").tips({
					side:3,
		            msg:'使用额度必须大于等于优惠券价格',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#use_price").focus();
				return ;
			}
			if(type==2){
			if($("#coupon_num").val()==""){
				$("#coupon_num").tips({
					side:3,
		            msg:'请输入兑换码',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#coupon_num").focus();
			return false;
			}
			}
			if($("#coupon_count").val()==""){
				$("#coupon_count").tips({
					side:3,
		            msg:'请输入优惠券数量',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#coupon_count").focus();
			return false;
			}
			if($("#type").val()==""){
				$("#type").tips({
					side:3,
		            msg:'请输入类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#type").focus();
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
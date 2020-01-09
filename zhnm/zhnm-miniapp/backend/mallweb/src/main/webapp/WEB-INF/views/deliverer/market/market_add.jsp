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
					
					<form action="delivererMarket/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="market_id" id="market_id" />
						<input type="hidden" name="deliverer_id" id="deliverer_id"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							
							<!--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">市场名称:</td>
								<td><input type="text" name="marketName" id="marketName" value="${pd.marketName}" maxlength="255" placeholder="这里输入市场名称" disabled="disabled" title="市场名称" style="width:98%;"/></td>
							</tr> -->
							 <tr>
								<td style="width:79px;text-align: right;padding-top: 13px;">绑定市场:</td>
								<td id="market">
								<select class="chosen-select form-control" name="marketName" id="marketName" data-placeholder="绑定市场" style="vertical-align:top;" style="width:98%;" >
								<option value=""></option>
								<c:forEach items="${marketList}" var="market">
								<option value="${market.ID }" >${market.MARKET_NAME }</option>
								</c:forEach>
								</select>
								</td>
							 </tr>
							<tr>
								<td style="width:79px;text-align: right;padding-top: 13px;">配送员账号:</td>
								<td id="market">
								<select class="chosen-select form-control" name="dAccount" id="dAccount" data-placeholder="系统账号" style="vertical-align:top;" style="width:98%;" >
								<option value=""></option>
								<c:forEach items="${delivererList}" var="deliverer">
								<option value="${deliverer.ID }" >${deliverer.ACCOUNT }</option>
								</c:forEach>
								</select>
								</td>
							 </tr>
							
							
							
							<!--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">系统账号:</td>
								<td><input type="text" name="dAccount" id="dAccount" value="${pd.dAccount}" maxlength="255" placeholder="这里输入系统账号" disabled="disabled" title="系统账号" style="width:98%;"/></td>
							</tr>  -->
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
     
     
     function searchMarket(){
    	 if($("#searchMarket").val()==""){
				$("#searchMarket").tips({
					side:3,
		            msg:'请输入市场名称',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#searchMarket").focus();
			return false;
			}else{
				var marketName = $("#searchMarket").val();
				$.ajax({
					type: "POST",
					url: '<%=basePath%>delivererMarket/findByMarketName.do',
			    	data: {MARKET_NAME:marketName,tm:new Date().getTime()},
					dataType:'json',
					cache: false,
					success: function(data){
						if("error" == data.result){
							$("#searchMarket").css("background-color","#D16E6C");
							setTimeout("$('#searchMarket').val('此市场不存在!')",500);
						 }else{
							var marketName = data.result.MARKET_NAME;
							var marketId = data.result.ID;
							document.getElementById("marketName").value = marketName;
							document.getElementById("market_id").value = marketId;
							
						 }
					}
				});
			} 
     }
     
     function searchAccount(){
    	 if($("#account").val()==""){
				$("#account").tips({
					side:3,
		            msg:'请输入配送员账号',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#account").focus();
			return false;
			}else{
				var delivererAccount = $("#account").val();
				$.ajax({
					type: "POST",
					url: '<%=basePath%>delivererMarket/findByDAccount.do',
			    	data: {DELIVERER_ACCOUNT:delivererAccount,tm:new Date().getTime()},
					dataType:'json',
					cache: false,
					success: function(data){
						if("error" == data.result){
							$("#account").css("background-color","#D16E6C");
							setTimeout("$('#account').val('此账号不存在!')",500);
						 }else{
							var delivererId = data.result.ID;
							var delivererAccount = data.result.ACCOUNT;
							var delivererName = data.result.CNNAME;
							document.getElementById("deliverer_id").value = delivererId;
							document.getElementById("Dname").value = delivererName;
							document.getElementById("dAccount").value = delivererAccount;
						 }
					}
				});
			} 
     }
     
		//保存
	function save(){

		if($("#marketName").val()==""){
				$("#marketName").tips({
					side:3,
		            msg:'请输入市场名称搜索',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#marketName").focus();
			return false;
		 }
			
		if($("#Dname").val()==""){
				$("#Dname").tips({
					side:3,
		            msg:'请输入配送员账号搜索',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#Dname").focus();
			return false;
		}
		if($("#dAccount").val()==""){
				$("#used").tips({
					side:3,
		            msg:'请输入配送员账号搜索',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#dAccount").focus();
			return false;
		}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
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
</body>
</html>
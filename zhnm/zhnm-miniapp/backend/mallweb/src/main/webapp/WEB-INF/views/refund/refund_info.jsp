<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
<!-- 日期框 -->
<link rel="stylesheet" href="static/ace/css/datepicker.css" />
<style type="text/css">
p {
	padding-top: 7px;
}
</style>
</head>

<body class="no-skin">

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="hr hr-18 dotted hr-double"></div>
					<div class="row">
						<div class="col-xs-12">

							<!-- 存放生成的hmlt开头  -->
							<!-- <form class="form-horizontal" role="form"> -->
							<form action="order/refund" name="Form" id="Form"
								method="post" class="form-horizontal">
								<table id="simple-table" class="table table-striped table-bordered table-hover" style="margin-top:5px;">
								<thead>
								<tr>
									<th class="center">商品</th>
									<th class="center">单价</th>
									<th class="center">数量</th>
									<th class="center">售后</th>
									<th class="center">理由</th>
									<th class="center">实收款</th>
									<th class="center">退款</th>
								</tr>
							</thead>
								<tr>
								<td style="width:360px">
								<input type="hidden" id="pay_total" name="pay_total" value="${pd.pay_total }">
								<input type="hidden" id="order_id" name="order_id" value="${pd.order_id }">
								<input type="hidden" id="refund_id" name="refund_id" value="${pd.refund_id }">
								<input type="hidden" id="order_detail_id" name="order_detail_id" value="${pd.order_detail_id }">
											<div style="float:left;width:60px;text-align: center;"><img src="${pd.goods_pic}" style="width: 50px;"></div>
											<div style=""> ${pd.goods_name}</div>
											</td>
											<td class='center' style="width:100px;vertical-align:middle;">${pd.goods_price}</td>
											<td class='center' style="width:100px;vertical-align:middle;">${pd.goods_count}</td>
											<td class='center' style="width:100px;vertical-align:middle;">
											<a>
											<c:if test="${pd.status==3}">待退款</c:if>
											<c:if test="${pd.status==4}">退款完成</c:if>
											</a>
											</td>
											<td class='center' style="vertical-align:middle;">
											${pd.refund_explain }
											</td>
											
											<td class='center' style="width:100px;vertical-align:middle;">
											${pd.pay_total }
											
											</td>
											<td class='center' style="width:50px;vertical-align:middle;">
											<c:if test="${pd.status==3}">
											<input type="text" value="${pd.refund_price }" style="width: 80px" id="refund_price" onkeyup="check(this)" name="refund_price" placeholder="最多${pd.pay_total }">
											</c:if>
											<c:if test="${pd.status==4}">
											${pd.refund_price }
											</c:if>
											</td>
										</tr>
								</table>
 									<div class="col-md-12">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1"></label>
										<div class="col-sm-9">
											<c:if test="${pd.status==3}">
											<a class="btn btn-mini btn-primary" onclick="refund()">退款</a>
											</c:if>
											<a class="btn btn-mini btn-danger"
												onclick="window.location.href = document.referrer;">返回</a>
										</div>
									</div>
								</div>
							</form>
							<!-- 存放生成的hmlt结尾 -->

						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->


		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>

	<script type="text/javascript">
	function check(obj){   
		var pay_total = $('#pay_total').val();
	 	obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符  
	    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
	    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
	    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数  
	    if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额 
	        obj.value= parseFloat(obj.value); 
	    } 
	    if(parseFloat(obj.value) > parseFloat(pay_total)){
	    	obj.value = pay_total;
	    }
	}
	
		function refund() {
			var refund_price = $('#refund_price').val();
			var order_id = $('#order_id').val();
			var order_detail_id = $('#order_detail_id').val();
//			var refund_id = $('#refund_id').val();
//			var pay_total = $('#pay_total').val();
			if (refund_price == ''||refund_price == 0) {
				alert('请输入退款金额');
				return;
			}
			$.ajax({
				url : 'refund/refund',
				type : 'post',
				data : {
					order_id : order_id,
					order_detail_id : order_detail_id,
					refund_price : refund_price
//					refund_id:refund_id,
//					pay_total:pay_total
				},
				success : function(data) {
					alert(data.message);
					if (data.result == 1) {
						window.location.href = document.referrer;
					}
				}
			})
		}
	</script>


</body>
</html>
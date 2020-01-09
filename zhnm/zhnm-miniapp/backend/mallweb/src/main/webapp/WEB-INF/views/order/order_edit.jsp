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
							<form action="goods/${msg}.do" name="Form" id="Form"
								method="post" class="form-horizontal">
						
								<div class="col-md-12" >
									<div class="form-group" style="margin-bottom: 0">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">商城单号：</label>
										<div class="col-sm-9" style="width:20%">
											<p>${pd.order_id}</p>
										</div>
										<c:forEach items="${record}" var="record">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">${record.record_note}：</label>
										<div class="col-sm-9"  style="width:20%">
											<p>${record.addtime}</p>
										</div>
										</c:forEach>
										
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">用户昵称：</label>
										<div class="col-sm-9" style="width:20%">
											<p>${pd.username}</p>
										</div>
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">用户手机：</label>
										<div class="col-sm-9"style="width:20%" >
											<p>${pd.phone}</p>
										</div>
									</div>
							
								
									<div class="form-group" style="margin-bottom: 0"> 
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">收货地址：</label>
										<div class="col-sm-9">
											<p>${pd.addr_realname}${pd.addr_phone}
											${pd.addr_city} ${pd.address}</p>
										</div>
									</div>
									
									<div class="form-group" style="margin-bottom:10px">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">选择快递：</label>
										<div class="col-sm-9" style="width:20%">
								  	 <select class="chosen-select form-control" name="express_title" id="express_title" onchange="dh()" style="height:27px;width:200px;margin-top: 5px">
								  	 <option value="">请选择</option>
								  	<option value="wxkd" <c:if test="${'wxkd' eq pd.express_title}">selected</c:if>>无需快递</option>
								  	 <c:forEach items="${express}" var="express">
								  	 <option value="${express.express_title}" <c:if test="${'wxkd' ne pd.express_title}"><c:if test="${express.express_title eq pd.express_title}">selected</c:if></c:if> >${express.express_name}</option>
								  	 </c:forEach>
								  	 </select>
									</div>
									<div id="dh" <c:if test="${'wxkd' eq pd.express_title}">style="display:none"</c:if>>
									<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">快递单号：</label>
										<div class="col-sm-9"style="width:20%" >
											<input type="text" id="express_num"  value="${pd.express_num}" style="height: 27px;width:180px;margin-top: 5px"> 
											<c:if test="${!empty pd.express_num}">
											<a id="getdiv"  data-toggle="modal" data-target="#myModal">查询</a><!--  -->
											</c:if>
										</div>
									</div>		
								</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1"></label>
										<div class="col-sm-9">
											<c:if test="${pd.status==1||pd.status==2}">
											<a class="btn btn-mini btn-primary" onclick="send('${pd.order_id}')">发货</a>
											</c:if>
											<a class="btn btn-mini btn-danger"
												onclick="window.location.href = document.referrer;">返回</a>

										</div>
									</div>
								</div>
								<table id="simple-table" class="table table-striped table-bordered table-hover" style="margin-top:5px;">
								<thead>
								<tr>
									
									<th class="center">商品</th>
									<th class="center">单价</th>
									<th class="center">数量</th>
									<th class="center">售后</th>
									<th class="center">状态</th>
									<th class="center">优惠</th>
									<th class="center">运费</th>
									<th class="center">实收款</th>
								</tr>
							</thead>
								<c:forEach items="${orderdetail}" var="order" varStatus="os">
								<tr>
								<td style="width:360px">
											<div style="float:left;width:60px;text-align: center;"><img src="${order.goods_pic}" style="width: 50px;"></div>
											<div style=""> ${order.goods_name}<p style="color:#868484;font-size: 10px ">${order.attribute_detail_name}</p></div>
											</td>
											<td class='center' style="width:100px;vertical-align:middle;">${order.goods_price}</td>
											<td class='center' style="width:100px;vertical-align:middle;">${order.goods_count}</td>
											<td class='center' style="width:100px;vertical-align:middle;">
											<a href="refund/torefund?order_detail_id=${order.order_detail_id}">
											<c:if test="${order.status==3}">待退款</c:if>
											<c:if test="${order.status==4}">退款完成</c:if>
											</a>
											</td>
											<td class='center' style="width:100px;vertical-align:middle;<c:if test="${os.count!=pd.detaillength}"> border-bottom: 1px solid #f5f5f5;</c:if>">
											<c:if test="${os.index==0}">
											<c:if test="${order.status==0}">
											未支付
											</c:if>
											<c:if test="${order.status==1}">
											已支付
											</c:if>
											<c:if test="${order.status==2}">
											已发货
											</c:if>
											<c:if test="${order.status==3}">
											待退款
											</c:if>
											<c:if test="${order.status==4}">
											退款成功
											</c:if>
											<c:if test="${order.status==5}">
											交易成功,待评价
											</c:if>
											<c:if test="${order.status==6}">
											评价完成
											</c:if>
											<c:if test="${order.status==11}">
											待接单
											</c:if>
											<c:if test="${order.status==13}">
											已接单
											</c:if>
											<c:if test="${order.status==15}">
											待备货
											</c:if>
											<c:if test="${order.status==17}">
											待取货 
											</c:if>
											<c:if test="${order.status==19}">
											配送中
											</c:if>
											<c:if test="${order.status==21}">
											已送达 
											</c:if>
											<c:if test="${order.status==23}">
											待用户确认
											</c:if>
											<c:if test="${order.status==25}">
											已完成
											</c:if>
											<c:if test="${order.status==27}">
											已取消
											</c:if>
											<c:if test="${order.status==29}">
											商户已抢单
											</c:if>
											<c:if test="${order.status==37}">
											超时已取消
											</c:if>
											</c:if> 
											</td>
											<td class='center' style="width:100px;vertical-align:middle;<c:if test="${os.count!=pd.detaillength}"> border-bottom: 1px solid #f5f5f5;</c:if>">${order.coupon_price}</td>
											<td class='center' style="width:100px;vertical-align:middle;<c:if test="${os.count!=pd.detaillength}"> border-bottom: 1px solid #f5f5f5;</c:if>">${order.freight_price}</td>
											<td class='center' style="width:100px;vertical-align:middle;<c:if test="${os.count!=pd.detaillength}"> border-bottom: 1px solid #f5f5f5;</c:if>">
											<c:if test="${os.index==0}">${pd.order_total }</c:if>
											</td>
										</tr>
								</c:forEach>
								</table>
 
  
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">  
    <div class="modal-dialog" role="document">  
        <div class="modal-content">  
            <div class="modal-header">  
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">  
                    <span aria-hidden="true">×</span>  
                </button>  
                <h4 class="modal-title" id="myModalLabel">${pd.express_name}：${pd.express_num}</h4>  
            </div>  
            <div class="modal-body" id="show-express">  
                <p>loading…</p>  
            </div>  
            <div class="modal-footer">  
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
            </div>  
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

		function send(order_id) {
			var express_title = $('#express_title').val();
			var express_name = encodeURIComponent($('#express_title').find(
					"option:selected").text());
			var express_num = $('#express_num').val();
			if (express_title == '') {
				alert('请选择快递');
				return;
			}

			if (express_title != 'wxkd') {
				if (express_num == '') {
					alert('请填写快递单号');
					return;
				}
			}
			$.ajax({
				url : 'order/send',
				type : 'post',
				data : {
					order_id : order_id,
					express_name : express_name,
					express_title : express_title,
					express_num : express_num
				},
				success : function(data) {
					alert(data.message);
					if (data.result == 1) {
						window.location.href = document.referrer;
					}
				}
			})
		}

		function dh() {
			var express_title = $('#express_title').val();
			if (express_title == 'wxkd') {
				$('#dh').hide();
			} else {
				$('#dh').show();
			}
		}
			$('#myModal').on('shown.bs.modal', function (e) {  
	        	var express_title = $('#express_title').val();
	 			var express_num = $('#express_num').val();
	 			$.ajax({
	 				url : 'express/info',
	 				type : 'post',
	 				data : {
	 					express_title : express_title,
	 					express_num : express_num
	 				},
	 				success : function(data) {
	 					if (data.Success == true) {
	 						$('#show-express').html('');
	 						if(data.State==0){
	 							$('#show-express').html('<p>'+data.Reason+'</p>');
	 							return;
	 						}
	 						$.each(data.Traces,function(i,item){
	 							$('#show-express').append('<p>'+item.AcceptTime+'&nbsp;&nbsp;'+item.AcceptStation+'</p>');
	 						})
	 					}
	 					else{
	 						$('#show-express').html('<p>'+data.Reason+'</p>');
	 					}
	 				}
	 			})
	         });
	</script>


</body>
</html>
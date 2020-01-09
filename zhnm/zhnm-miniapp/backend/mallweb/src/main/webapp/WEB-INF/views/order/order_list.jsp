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
<!-- 日期框 -->
<link rel="stylesheet" href="static/ace/css/datepicker.css" />
<style type="text/css">

.order {
border:0 solid;
vertical-align: middle;
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
					<div class="row">
						<div class="col-xs-12">
							
						<!-- 检索  -->
						<form action="order/list.do" method="post" name="Form" id="Form">
						<table style="margin-top:5px;">
							<tr>
							<td><a href="order/list" class="btn btn-xs" style="width: 90px">全部</a></td>
							<td><a href="order/list?status=1" class="btn btn-xs" style="width: 90px">待发货</a></td>
							<td><a href="order/list?status=2" class="btn btn-xs" style="width: 90px">已发货</a></td>
							<td><a href="order/list?status=3" class="btn btn-xs" style="width: 90px">待退款</a></td>
							<td><a href="order/list?status=4" class="btn btn-xs" style="width: 90px">退款成功</a></td>
								<td style="padding-left: 15px">
									<div class="nav-search">
										<span class="input-icon">
											<input type="text" style="width: 300px" placeholder="这里输入订单号" class="nav-search-input" id="order_id" autocomplete="off" name="order_id" value="${pd.order_id }" />
											<i class="ace-icon fa fa-search nav-search-icon"></i>
										</span>
									</div>
								</td>
								&nbsp;
								<td  style="padding-left: 15px">
									<div class="nav-search">
										<span class="input-icon">
											<input type="text" style="width: 300px" placeholder="这里输入用户名称或者手机号" class="nav-search-input" id="nav-search-input" autocomplete="off" name="username" value="${pd.username }" />
											<i class="ace-icon fa fa-search nav-search-icon"></i>
										</span>
									</div>
								</td>
								<c:if test="${qx.cha == 1 }">
								<td style="vertical-align:top;padding-left:2px"><a class="btn btn-light btn-xs" onclick="tosearch();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
								</c:if>
							</tr>
						</table>
						<!-- 检索  -->
					
						<table id="simple-table" class="table table-striped table-bordered table-hover" style="margin-top:5px;">	
							<thead>
								<tr>
									<th class="center" style="width:35px;">
									<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>
									</th>
									<th class="center" style="width:50px;">序号</th>
									<th class="center">商品</th>
									<th class="center">单价（￥/kg）</th>
									<th class="center">数量（kg）</th>
									<th class="center">售后</th>
									<th class="center">状态</th>
									<th class="center">实收款（￥）</th>
									<th class="center">操作</th>
								</tr>
							</thead>
													
							<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty list}">
									<c:if test="${qx.cha == 1 }">
									<c:forEach items="${list}" var="var" varStatus="vs">
										<tr style="background: #dfe9f6">
											<td class='center'>
												<label class="pos-rel"><input type='checkbox' name='ids' value="${var.order_id}" class="ace" /><span class="lbl"></span></label>
											</td>
											<td class='center' style="width: 30px;">${vs.index+1}</td>
										
											<td colspan="1">订单号：${var.order_id}</td>
											<td colspan="2">买家：${var.username}</td>
											<td colspan="5">下单时间：${var.addtime}</td>
										</tr>
									
									<c:forEach items="${var.orderdetail}" var="order" varStatus="os">
										<tr class="order">
											<td class='center'>
												<label class="pos-rel"><span class="lbl"></span></label>
											</td>
											<td class='center' style="width: 30px;"></td>
											<td style="width:360px">
											<div style="float:left;width:60px;text-align: center;"><img src="${order.goods_pic}" style="width: 50px;"></div>
											<div> ${order.goods_name}<p style="color:#868484;font-size: 10px ">${order.attribute_detail_name}</p></div>
											</td>
											<td class='center' style="width:100px;vertical-align:middle;">${order.goods_price}</td>
											<td class='center' style="width:100px;vertical-align:middle;">${order.goods_count}</td>
											<td class='center' style="width:100px;vertical-align:middle;">
											<c:if test="${var.status==3}">待退款</c:if>
											<c:if test="${var.status==4}">退款完成</c:if>
											</td>
											<td class='center' style="width:100px;vertical-align:middle;<c:if test="${os.count!=var.detaillength}"> border-bottom: 1px solid #f5f5f5;</c:if>">
											<c:if test="${os.index==0}">
											<c:if test="${var.status==0}">
											未支付
											</c:if>
											<c:if test="${var.status==1}">
											已支付
											</c:if>
											<c:if test="${var.status==2}">
											已发货
											</c:if>
											<c:if test="${var.status==3}">
											待退款
											</c:if>
											<c:if test="${var.status==4}">
											退款成功
											</c:if>
											<c:if test="${var.status==5}">
											交易成功,待评价
											</c:if>
											<c:if test="${var.status==6}">
											评价完成
											</c:if>
											<c:if test="${var.status==11}">
											待接单
											</c:if>
											<c:if test="${var.status==13}">
											已接单
											</c:if>
											<c:if test="${var.status==15}">
											待备货
											</c:if>
											<c:if test="${var.status==17}">
											待取货 
											</c:if>
											<c:if test="${var.status==19}">
											配送中
											</c:if>
											<c:if test="${var.status==21}">
											已送达 
											</c:if>
											<c:if test="${var.status==23}">
											待用户确认
											</c:if>
											<c:if test="${var.status==25}">
											已完成
											</c:if>
											<c:if test="${var.status==27}">
											已取消
											</c:if>
											<c:if test="${var.status==29}">
											商户已抢单
											</c:if>
											<c:if test="${var.status==37}">
											超时已取消
											</c:if>
											</c:if> 
											</td>
											<td class='center' style="width:100px;vertical-align:middle;<c:if test="${os.count!=var.detaillength}"> border-bottom: 1px solid #f5f5f5;</c:if>">
											<c:if test="${os.index==0}">${var.order_total }</c:if>
											</td>
											<td class="center" style="width:100px;vertical-align:middle;<c:if test="${os.count!=var.detaillength}"> border-bottom: 1px solid #f5f5f5;</c:if>">
											<c:if test="${os.index==0}">
												<c:if test="${qx.edit != 1 && qx.del != 1 }">
												<span class="label label-large label-grey arrowed-in-right arrowed-in"><i class="ace-icon fa fa-lock" title="无权限"></i></span>
												</c:if>
												<div class="hidden-sm hidden-xs btn-group">
													<c:if test="${qx.edit == 1 }">
													<a class="btn btn-xs btn-success" title="编辑" href="order/order?order_id=${var.order_id}">
														<i class="ace-icon fa fa-pencil-square-o bigger-120" title="编辑"></i>
													</a>
													</c:if>
												</div>
												<div class="hidden-md hidden-lg">
													<div class="inline pos-rel">
														<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
															<i class="ace-icon fa fa-cog icon-only bigger-110"></i>
														</button>
														<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
															<c:if test="${qx.edit == 1 }">
															<li>
																<a style="cursor:pointer;" href="order/order?order_id=${var.order_id}" class="tooltip-success" data-rel="tooltip" title="修改">
																	<span class="green">
																		<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																	</span>
																</a>
															</li>
															</c:if>
														</ul>
													</div>
												</div>
										</c:if>		
											</td>
										</tr>
									</c:forEach>	
									</c:forEach>
									</c:if>
									<c:if test="${qx.cha == 0 }">
										<tr>
											<td colspan="100" class="center">您无权查看</td>
										</tr>
									</c:if>
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="100" class="center" >没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
						<div class="page-header position-relative">
						<table style="width:100%;">
							<tr>
								<td style="vertical-align:top;">
									
									<c:if test="${qx.del == 1 }">
									<a class="btn btn-sm btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" title="批量删除" ><i class='ace-icon fa fa-trash-o bigger-120'></i></a>
									</c:if>
								</td>
								<td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div></td>
							</tr>
						</table>
						</div>
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

		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
	<!-- 删除时确认窗口 -->
	<script src="static/ace/js/bootbox.js"></script>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script type="text/javascript">
		$(top.hangge());//关闭加载状态
		//检索
		function tosearch(){
			top.jzts();
			$("#Form").submit();
		}
		$(function() {
		
			//日期框
			$('.date-picker').datepicker({
				autoclose: true,
				todayHighlight: true
			});
			
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
			
			
			//复选框全选控制
			var active_class = 'active';
			$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
				var th_checked = this.checked;//checkbox inside "TH" table header
				$(this).closest('table').find('tbody > tr').each(function(){
					var row = this;
					if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
					else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
				});
			});
		});
		
		
		
		//删除
		function del(Id){
			bootbox.confirm("确定要删除吗?", function(result) {
				if(result) {
					top.jzts();
					var url = "<%=basePath%>order/delete.do?order_id="+Id+"&tm="+new Date().getTime();
					$.get(url,function(data){
						nextPage(${page.currentPage});
					});
				}
			});
		}
		
		//修改
		function edit(Id){
			 top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = '<%=basePath%>order/goEdit.do?order_id='+Id;
			 diag.Width = 450;
			 diag.Height = 355;
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					 nextPage(${page.currentPage});
				}
				diag.close();
			 };
			 diag.show();
		}
		
		//批量操作
		function makeAll(msg){
			bootbox.confirm(msg, function(result) {
				if(result) {
					var str = '';
					for(var i=0;i < document.getElementsByName('ids').length;i++){
					  if(document.getElementsByName('ids')[i].checked){
					  	if(str=='') str += document.getElementsByName('ids')[i].value;
					  	else str += ',' + document.getElementsByName('ids')[i].value;
					  }
					}
					if(str==''){
						bootbox.dialog({
							message: "<span class='bigger-110'>您没有选择任何内容!</span>",
							buttons: 			
							{ "button":{ "label":"确定", "className":"btn-sm btn-success"}}
						});
						$("#zcheckbox").tips({
							side:1,
				            msg:'点这里全选',
				            bg:'#AE81FF',
				            time:8
				        });
						return;
					}else{
						if(msg == '确定要删除选中的数据吗?'){
							top.jzts();
							$.ajax({
								type: "POST",
								url: '<%=basePath%>order/deleteAll.do?tm='+new Date().getTime(),
						    	data: {DATA_IDS:str},
								dataType:'json',
								//beforeSend: validateData,
								cache: false,
								success: function(data){
									 $.each(data.list, function(i, list){
											nextPage(${page.currentPage});
									 });
								}
							});
						}
					}
				}
			});
		};
		
		//导出excel
		function toExcel(){
			window.location.href='<%=basePath%>order/excel.do';
		}
	</script>


</body>
</html>
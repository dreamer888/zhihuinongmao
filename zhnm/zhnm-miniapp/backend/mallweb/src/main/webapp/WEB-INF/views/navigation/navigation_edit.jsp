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
					
					<form action="navigation/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="navigation_id" id="navigation_id" value="${pd.navigation_id}"/>
						<input type="hidden" name="navigation_img" id="filepath" value="${pd.navigation_img}"/>
						<input type="hidden" name="type" id="type" value="${pd.type}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">图标:</td>
								<td><input type="file" name="file" id="file" maxlength="255"  style="width:98%;" onchange="upload()"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">图标预览:</td>
								<td id="img">
								<c:if test="${!empty pd.navigation_img}">
								<img alt="" id="preview" src="${pd.navigation_img}"  width='100'>
								</c:if>
								 </td>
							</tr>
							
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">名称:</td>
								<td><input type="text" name="navigation_name" id="navigation_name" value="${pd.navigation_name}" maxlength="255" placeholder="这里输入名称" title="名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">公众号链接:</td>
								<td><input type="text" name="navigation_url" id="navigation_url" value="${pd.navigation_url}" maxlength="255" placeholder="这里输入链接" title="链接" style="width:98%;"/></td>
								<td><a id="getdiv"  data-toggle="modal" data-target="#myModal">选择</a></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">小程序链接:</td>
								<td><input type="text" name="navigation_app_url" id="navigation_app_url" value="${pd.navigation_app_url}" maxlength="255" placeholder="这里输入小程序链接:" title="小程序链接:" style="width:98%;" readonly="readonly"/></td>
							</tr>
							<tr><!-- 添加农贸市场 -->
								<td style="width:90px;text-align: right;padding-top: 13px;">选择市场:</td>
								<td id="market">
								  <select class="chosen-select form-control" name="MARKET_ID" id="market_id" data-placeholder="绑定市场" style="vertical-align:top;" style="width:98%;" >
								  <option value="0"></option>
								  <c:forEach items="${marketList}" var="market">
								  <option value="${market.ID }" <c:if test="${market.ID == pd.market_id }">selected</c:if>>${market.MARKET_NAME }</option>
								  </c:forEach>
								  </select>
							    </td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">排序:</td>
								<td><input type="number" name="sort" id="sort" value="${pd.sort}" maxlength="32" placeholder="这里输入排序" title="排序" style="width:98%;"/></td>
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">  
    <div class="modal-dialog" role="document">  
        <div class="modal-content">  
            <div class="modal-header">  
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">  
                    <span aria-hidden="true">×</span>  
                </button>  
                <h4 class="modal-title" id="myModalLabel"></h4>  
            </div>  
            <div class="modal-body" id="show">
                <p>loading…</p> 
            </div>  
            <div class="modal-footer">  
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
            </div>  
        </div>  
    </div>  
</div> 

	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<!--<script type="text/javascript" src="static/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="static/js/myjs/upload.js"></script>  -->
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			if($("#filepath").val()==""){
				$("#filepath").tips({
					side:3,
		            msg:'请上传图片',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#navigation_img").focus();
				return false;
				}
				if($("#navigation_name").val()==""){
					$("#navigation_name").tips({
						side:3,
			            msg:'请输入名称',
			            bg:'#ae81ff',
			            time:2
			        });
					$("#navigation_name").focus();
				return false;
				}
				if($("#navigation_url").val()==""){
					$("#navigation_url").tips({
						side:3,
			            msg:'请输入公众号链接',
			            bg:'#ae81ff',
			            time:2
			        });
					$("#navigation_url").focus();
				return false;
				}
				
				if($("#sort").val()==""){
					$("#sort").tips({
						side:3,
			            msg:'请输入排序',
			            bg:'#ae81ff',
			            time:2
			        });
					$("#sort").focus();
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
		$('#myModal').on('shown.bs.modal', function (e) {  
 			$.ajax({
 				url : 'get_url',
 				type : 'post',
 				success : function(data) {
 					$('#show').html('<h3 class="center">分类/商品</h3>');
 					var super_list = data.super_list;
 					var coupon_list = data.coupon_list;
 					$.each(super_list,function(i,item){
 						var child_list =item.child_list;
 						$('#show').append('<p style="font-size:15px;color:#d15b47"><b>'+item.category_name+'</b></p>');
 						$.each(child_list,function(j,jtem){
 							var goods_list = jtem.goods_list;
 							$('#show').append('<p onclick="chose_category_url(\''+jtem.category_id+'\')"><b>'+jtem.category_name+'</b></p>');
 							$.each(goods_list,function(k,ktem){
 								var sort_num = ++k
 								$('#show').append('<p onclick="chose_goods_url(\''+ktem.goods_id+'\')">'+sort_num+'、'+ktem.goods_name+'</p>');
 							})
 						})
 					})
 					$('#show').append('<h3 class="center">优惠券列表</h3>');
 					$('#show').append('<p onclick="chose_coupon_url()">优惠券列表</p>');
 				}
 			})
         });
		function chose_category_url(category_id){
			$('#navigation_url').val('goods/list?category_id='+category_id);
			$('#navigation_app_url').val('goods_list/'+category_id);
			$('#myModal').modal("hide");
		}
		function chose_goods_url(goods_id){
			$('#navigation_url').val('goods/info/'+goods_id);
			$('#navigation_app_url').val('goods_info/'+goods_id);
			$('#myModal').modal("hide");
		}
		function chose_coupon_url(){
			$('#navigation_url').val('coupon/tolist');
			$('#navigation_app_url').val('coupon_list');
			$('#myModal').modal("hide");
		}
function upload(){
			var files = document.getElementById("file").files;
		    var form = new FormData();
		    form.append("file", files[0]);
		    $.ajax({
		        url:"categoryPictureController/banner.do",
		        type: "post",
		        data: form,
		        processData: false,
		        contentType: false,
		        success: function (data) {
		         var ImgId = data;
		         document.getElementById("filepath").value = ImgId;
		         setImg(ImgId);
		        }
		    });		
		 }	
		 
function setImg(ImgId){
	$("#preview").remove();
	$("#img").append(
	 '<img id="preview" name="preview" src="'+ImgId+'" width="100" >'); 
 }	
</script>

</body>
</html>
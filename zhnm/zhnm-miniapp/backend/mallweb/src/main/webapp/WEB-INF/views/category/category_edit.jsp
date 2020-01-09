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
					<form action="category/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="category_id" id="category_id" value="${pd.category_id}"/>
						<input type="hidden" name="category_img" id="filepath" value="${pd.category_img}"/>
						<input type="hidden" name="super_id" id="super_id" value="${pd.super_id}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">名称:</td>
								<td><input type="text" name="category_name" id="category_name" value="${pd.category_name}" maxlength="255category_img" placeholder="这里输入名称" title="名称" style="width:98%;"/></td>
							</tr>
			
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">图片:</td>
								<td><input type="file" name="file" id="file" maxlength="255"  style="width:98%;"  onchange="upload()"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">图片预览:</td>
								<td id="img">
								<c:if test="${!empty pd.category_img}">
								<img alt=""  id="preview"  name="preview" src="${pd.category_img}"  width='100'>
								</c:if>
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
	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<!-- <script type="text/javascript" src="static/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="static/js/myjs/upload.js"></script>  -->
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			if($("#category_name").val()==""){
				$("#category_name").tips({
					side:3,
		            msg:'请输入名称',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#category_name").focus();
			return false;
			}
			
			if($("#filepath").val()==""){
				$("#file").tips({
					side:3,
		            msg:'请上传图片',
		            bg:'#ae81ff',
		            time:2
		        });
				$("#category_img").focus();
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
function upload(){
	var files = document.getElementById("file").files;
    var form = new FormData();
    form.append("file", files[0]);
    $.ajax({
        url:"categoryPictureController/categorySortP.do",
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
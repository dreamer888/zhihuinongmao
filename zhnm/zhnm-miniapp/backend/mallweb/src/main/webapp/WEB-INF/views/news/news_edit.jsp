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
<head><base href="<%=basePath%>">
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
					<div class="hr hr-18 dotted hr-double"></div>
					<div class="row">
						<div class="col-xs-12">
<!-- 存放生成的hmlt开头  -->
<!-- <form class="form-horizontal" role="form"> -->
<form action="news/${msg}.do" name="Form" id="Form" method="post" class="form-horizontal">
<input type="hidden" name="news_id" id="news_id" value="${pd.news_id}"/>
<input type="hidden" name="type" id="type" value="1"/>
<input type="hidden" name="img" id="img" value="1"/>
<div class="col-md-12">
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">标题：</label>
        <div class="col-sm-9" style="width:55%;">
           <input type="text" name="news_title" id="news_title" value="${pd.news_title}" maxlength="255" placeholder="这里输入标题" title="标题" class="col-xs-10 col-sm-5" style="width:100%"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">内容：</label>
        <div class="col-sm-9" style="width:55%;">
            <textarea rows="" cols="" name="news_content" id= "content" style="width: 100%">${pd.news_content}</textarea>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">排序：</label>
        <div class="col-sm-9" style="width:55%;">
        <input type="number" name="sort" id="sort" value="${pd.sort}" maxlength="32" placeholder="这里输入排序" title="排序" class="col-xs-10 col-sm-5" style="width:100%"/>
        </div>
    </div>
</div>
 <div class="col-md-12">
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"></label>
        <div class="col-sm-9"> <a class="btn btn-mini btn-primary" onclick="save()">保存</a>
        <a class="btn btn-mini btn-danger" onclick="window.location.href = document.referrer;">返回</a>
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
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
	<!-- 富文本编辑框-->
	<link rel="stylesheet" href="plugins/kindeditor/themes/default/default.css" />
    <script charset="utf-8" src="plugins/kindeditor/kindeditor-min.js"></script>
	<script charset="utf-8" src="plugins/kindeditor/lang/zh_CN.js"></script>
   
	<!-- end富文本编辑框-->
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!-- 上传控件 -->
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<!--<script src="static/ace/js/ace/elements.fileinput.js"></script>
    <script type="text/javascript" src="static/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="static/js/myjs/upload.js"></script>  -->
	<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[id="content"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : true,
					afterBlur : function() {
						this.sync();
					},
					items : [
						'source','fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons','image','link','fullscreen'] 
				});
			});
	</script>
	<script type="text/javascript">
		$(top.hangge());
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
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
<script type="text/javascript">
function save(){
	if($("#news_title").val()==""){
		$("#news_title").tips({
			side:3,
            msg:'请输入标题',
            bg:'#ae81ff',
            time:2
        });
		$("#news_title").focus();
	return false;
	}
	if($("#news_content").val()==""){
		$("#news_content").tips({
			side:3,
            msg:'请输入内容',
            bg:'#ae81ff',
            time:2
        });
		$("#news_content").focus();
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
	if($("#type").val()==""){
		$("#type").tips({
			side:3,
            msg:'请输入类别',
            bg:'#ae81ff',
            time:2
        });
		$("#type").focus();
	     return false;
	}
    var ImgId = document.getElementById("content").value;
    
	$("#Form").submit();
	$("#zhongxin").hide();
	$("#zhongxin2").show();
}

</script>
</body>
</html>
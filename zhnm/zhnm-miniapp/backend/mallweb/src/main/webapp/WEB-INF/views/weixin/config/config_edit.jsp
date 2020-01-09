<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
					<div class="hr hr-18 dotted hr-double"></div>
					<div class="row">
						<div class="col-xs-12">

<!-- 存放生成的hmlt开头  -->
<!-- <form class="form-horizontal" role="form"> -->
<form action="config/${msg}.do" name="Form" id="Form" method="post" class="form-horizontal">
<input type="hidden" name="config_id" id="config_id" value="${pd.config_id}"/>
<div class="col-md-12">
    
      
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">appid：</label>
        <div class="col-sm-9" style="width:55%;">
            <input type="text" name="appid" id="appid" value="${pd.appid}" maxlength="255" placeholder="这里输入微信公众平台appid"  class="col-xs-10 col-sm-5" style="width:100%">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">appsecret：</label>
        <div class="col-sm-9" style="width:55%;">
            <input type="text" name="appsecret" id="appsecret" value="${pd.appsecret}" maxlength="255" placeholder="这里输入微信公众平台appsecret"  class="col-xs-10 col-sm-5" style="width:100%">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">商户号：</label>
        <div class="col-sm-9" style="width:55%;">
            <input type="text" name="partner" id="partner" value="${pd.partner}" maxlength="255" placeholder="这里输入微信公众平台商户号"  class="col-xs-10 col-sm-5" style="width:100%">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">商户密钥：</label>
        <div class="col-sm-9" style="width:55%;">
            <input type="text" name="partnerkey" id="partnerkey" value="${pd.partnerkey}" maxlength="255" placeholder="这里输入微信公众平台商户密钥"  class="col-xs-10 col-sm-5" style="width:100%">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">域名：</label>
        <div class="col-sm-9" style="width:55%;">
            <input type="text" name="link" id="link" value="${pd.link}" maxlength="255" placeholder="这里输入域名"  class="col-xs-10 col-sm-5" style="width:100%">
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right" for="form-field-1">证书路径：</label>
        <div class="col-sm-9" style="width:55%;">
            <input type="text" name="path" id="path" value="${pd.path}" maxlength="255" placeholder="这里输入路径，用于退款操作   如E:/apiclient_cert.p12"  class="col-xs-10 col-sm-5" style="width:100%">
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
	<%@ include file="../../system/index/foot.jsp"%>
	
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!-- 上传控件 -->
	<script src="static/ace/js/ace/elements.fileinput.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>

<script type="text/javascript">
$(top.hangge());
function save(){
	var appid = $('#appid').val();
	var appsecret = $('#appsecret').val();
	var partner = $('#partner').val();
	var partnerkey = $('#partnerkey').val();
	var link = $('#link').val();
	if(appid==""){
		$("#appid").tips({
			side:3,
            msg:'请输入appid',
            bg:'#AE81FF',
            time:2
        });
		$("#appid").focus();
	return false;
	}
	if(appsecret==""){
		$("#appsecret").tips({
			side:3,
            msg:'请输入appsecret',
            bg:'#AE81FF',
            time:2
        });
		$("#appsecret").focus();
	return false;
	}
	if(partner==""){
		$("#partner").tips({
			side:3,
            msg:'请输入商户号',
            bg:'#AE81FF',
            time:2
        });
		$("#partner").focus();
	return false;
	}
	if($("#partnerkey").val()==""){
		$("#partnerkey").tips({
			side:3,
            msg:'请输入商户密钥',
            bg:'#AE81FF',
            time:2
        });
		$("#partnerkey").focus();
	return false;
	}
	if((link.indexOf('http://')&&link.indexOf('https://'))==-1){
		$("#link").tips({
			side:3,
            msg:'请输入域名(必须以http://或者https://开头)',
            bg:'#AE81FF',
            time:2
        });
		$("#link").focus();
	return false;
	}
	if($("#path").val()==""){
		$("#path").tips({
			side:3,
            msg:'请输入证书路径，用于退款操作',
            bg:'#AE81FF',
            time:2
        });
		$("#path").focus();
	return false;
	}
	$("#Form").submit();
}
</script>

</body>
</html>
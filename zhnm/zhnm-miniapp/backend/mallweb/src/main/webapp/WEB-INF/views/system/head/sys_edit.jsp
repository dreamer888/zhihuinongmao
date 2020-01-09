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

<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
<script type="text/javascript" src="static/ace/js/jquery.js"></script>
<!-- 上传图片插件 -->
<link href="plugins/uploadify/uploadify.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="plugins/uploadify/swfobject.js"></script>
<script type="text/javascript" src="plugins/uploadify/jquery.uploadify.v2.1.4.min.js"></script>
<!-- 上传图片插件 -->
<script type="text/javascript">
var jsessionid = "<%=session.getId()%>";  //勿删，uploadify兼容火狐用到
</script>
<!--引入属于此页面的js -->
<script type="text/javascript" src="static/js/myjs/sys.js"></script>	
<!--提示框-->
<script type="text/javascript" src="static/js/jquery.tips.js"></script>
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
						<div id="zhongxin" style="margin-top: 10px;">
						 <div class="span6">
							<div class="tabbable">
						            <ul class="nav nav-tabs" id="myTab">
						              <li class="active"><a data-toggle="tab" href="#home"><i class="green icon-home bigger-110"></i> 配置</a></li>
						              <!-- <li><a data-toggle="tab" href="#profile"><i class="green icon-cog bigger-110"></i>配置 NO2</a></li>
						              <li><a data-toggle="tab" href="#profile3"><i class="green icon-cog bigger-110"></i>配置 NO3</a></li> -->
						            </ul>
						            <div class="tab-content">
									  <div id="home" class="tab-pane in active">
										<form action="head/saveSys.do" name="Form" id="Form" method="post">
										<table id="table_report" class="table table-striped table-bordered table-hover">
											<tr>
												<td style="width:76px;text-align: right;padding-top: 13px;">系统名称:</td>
												<td><input type="text" name="YSYNAME" id="YSYNAME" value="${pd.YSYNAME }" placeholder="这里输入系统名称" style="width:90%" title="系统名称"/></td>
											
												<td style="width:76px;text-align: right;padding-top: 13px;">每页条数:</td>
												<td><input type="number" name="COUNTPAGE" id="COUNTPAGE" value="${pd.COUNTPAGE }" placeholder="这里输入每页条数" style="width:90%" title="每页条数"/></td>
											</tr>
										</table>
										
										<table class="center" style="width:100%" >
											<tr>
												<td style="text-align: center;" colspan="100">
													<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
													<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
												</td>
											</tr>
										</table>
										</form>
									  </div>
									  
									  <div style="display: none;" id="fhsmsobjsys"></div>
									  
						            </div>
							</div>
						 </div><!--/span-->
						</div>
		
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green"></h4></div>
							
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

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		$(top.hangge());
		$(document).ready(function(){
			if("${pd.isCheck1 }" == "yes"){
				$("#check1").attr("checked",true);
			}else{
				$("#check1").attr("checked",false);
			}
			if("${pd.isCheck2 }" == "yes"){
				$("#check2").attr("checked",true);
			}else{
				$("#check2").attr("checked",false);
			}
		});
	</script>


</body>
</html>
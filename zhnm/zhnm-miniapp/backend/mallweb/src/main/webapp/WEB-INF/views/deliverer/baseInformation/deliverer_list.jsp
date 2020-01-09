<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
					<div class="row">
						<div class="col-xs-12">
						
						<!-- 检索  -->
						<form action="deliverer/listDeliverers.do" method="post" name="userForm" id="userForm">
						<table style="margin-top:5px;">
							<tr>
								<td>
									<div class="nav-search">
									<span class="input-icon">
										<input class="nav-search-input" autocomplete="off" id="nav-search-input" type="text" name="keywords" value="${pd.keywords }" placeholder="这里输入关键词" />
										<i class="ace-icon fa fa-search nav-search-icon"></i>
									</span>
									</div>
								</td> 
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="searchs();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
								<!--<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="toExcel();" title="导出到EXCEL"><i id="nav-search-icon" class="ace-icon fa fa-download bigger-110 nav-search-icon blue"></i></a></td>
								<td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="fromExcel();" title="从EXCEL导入"><i id="nav-search-icon" class="ace-icon fa fa-cloud-upload bigger-110 nav-search-icon blue"></i></a></td>
							  -->
							</tr>
						</table>
						<!-- 检索  -->
					
						<table id="simple-table" class="table table-striped table-bordered table-hover"  style="margin-top:5px;">
							<thead>
								<tr>
									<th class="center" style="width:35px;">
									<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>
									</th>
									<th class="center" style="width:50px;">序号</th>
									<th class="center">账号</th>
									<th class="center">姓名</th>
									<th class="center">身份证（后六位）</th>
									<th class="center">账户状态</th>
									<th class="center">保证金（￥）</th>
									<th class="center">性别</th>
									<th class="center">年龄</th>
									<th class="center">操作</th>
								</tr>
							</thead>				
							<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty delivererList}">
									<c:forEach items="${delivererList}" var="deliverer" varStatus="vs">	
										<tr>
											<td class='center' style="width: 30px;">
											<label><input type='checkbox' name='ids' value="${deliverer.ID }" id="${deliverer.ACCOUNT }" alt="${deliverer.CNNAME }" title="${deliverer.CNNAME }" class="ace"/><span class="lbl"></span></label>
											</td>
											<td class='center' style="width: 30px;">${vs.index+1}</td>  <!-- 序列 -->
											<td class="center"><a onclick="viewDeliverer('${deliverer.ACCOUNT}')" style="cursor:pointer;">${deliverer.ACCOUNT }</a></td>
											<td class="center">${deliverer.CNNAME }</td>
											<td class="center">${deliverer.ID_CARD }</td>
											<td class="center">
											<c:if test="${deliverer.STATUS==0}">
											正常
											</c:if>
											<c:if test="${deliverer.STATUS==1}">
											冻结
											</c:if>
											<c:if test="${deliverer.STATUS==2}">
											关闭
											</c:if>
											</td>
											<td class="center">${deliverer.CREDIT }</td>
											<td class="center">
											<c:if test="${ deliverer.GENDER =='false' }">
											男
											</c:if>
											<c:if test="${ deliverer.GENDER =='true' }">
											女
											</c:if>
											</td>
											<td class="center">${deliverer.AGE}</td>
											<td class="center">
												<div class="hidden-sm hidden-xs btn-group">
													<a class="btn btn-xs btn-success" title="编辑" onclick="editDeliverer('${deliverer.ACCOUNT}');">
														<i class="ace-icon fa fa-pencil-square-o bigger-120" title="编辑"></i>
													</a>
													<a class="btn btn-xs btn-danger" onclick="delDeliverer('${deliverer.ID }','${deliverer.CNNAME }');">
														<i class="ace-icon fa fa-trash-o bigger-120" title="删除"></i>
													</a>
												</div>
											</td>
										</tr>
									
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="10" class="center">没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
						
					<div class="page-header position-relative">
					<table style="width:100%;">
						<tr>
							<td style="vertical-align:top;">
								<a class="btn btn-mini btn-success" onclick="add();">新增</a>
								<a title="批量删除" class="btn btn-mini btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" ><i class='ace-icon fa fa-trash-o bigger-120'></i></a>
								
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
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- 删除时确认窗口 -->
	<script src="static/ace/js/bootbox.js"></script>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	</body>

<script type="text/javascript">
$(top.hangge());

//window.onload=function(){
	// console.log(${delivererList});
//};

//检索
function searchs(){
	top.jzts();
	$("#userForm").submit();
}

//删除
function delDeliverer(DELIVERER_ID,msg){
	bootbox.confirm("确定要删除["+msg+"]吗?", function(result) {
		if(result) {
			top.jzts();
			var url = "<%=basePath%>deliverer/deleteD.do?DELIVERER_ID="+DELIVERER_ID+"&tm="+new Date().getTime();
			$.get(url,function(data){
				nextPage(${page.currentPage});
			});
		};
	});
}


//新增
function add(){
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="新增配送员";
	 diag.URL = '<%=basePath%>deliverer/goAddD.do';
	 diag.Width = 469;
	 diag.Height = 450;
	 diag.CancelEvent = function(){ //关闭事件
		 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
			 if('${page.currentPage}' == '0'){
				 top.jzts();
				 setTimeout("self.location=self.location",100);
			 }else{
				 nextPage(${page.currentPage});
			 }
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
			
			for(var i=0;i < document.getElementsByName('ids').length;i++)
			{
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
					side:3,
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
						url: '<%=basePath%>deliverer/deleteAllD.do?tm='+new Date().getTime(),
				    	data: {DELIVERER_IDS:str},
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
}
//查看用户
function viewDeliverer(ACCOUNT){
	
	 top.jzts();
	 var diag = new top.Dialog();
	 diag.Drag=true;
	 diag.Title ="资料";
	 diag.URL = '<%=basePath%>deliverer/view.do?DELIVERER_ACCOUNT='+ACCOUNT;
	 diag.Width = 469;
	 diag.Height = 420;
	 diag.CancelEvent = function(){ //关闭事件
		diag.close();
	 };
	 diag.show();
}

//修改
function editDeliverer(DELIVERER_ACCOUNT){
	// 转过来的是 商户id，菜市场ID，分类ID
	 top.jzts();
	 var diag = new top.Dialog();  //deliverer
	 diag.Drag=true;
	 diag.Title ="修改配送员信息";
	 diag.URL = '<%=basePath%>deliverer/goEditD.do?DELIVERER_ACCOUNT='+DELIVERER_ACCOUNT;
	 diag.Width = 469;
	 diag.Height = 510;
	 diag.CancelEvent = function(){ //关闭事件
		 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
			nextPage(${page.currentPage});
		}
		diag.close();
	 };
	 diag.show();
}

$(function() {
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


		
</script>
</html>

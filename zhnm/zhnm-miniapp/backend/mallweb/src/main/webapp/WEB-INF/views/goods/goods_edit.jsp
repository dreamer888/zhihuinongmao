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
							<form action="goods/${msg}.do" name="Form" id="Form" method="post" class="form-horizontal">
								<input type="hidden" name="goods_id" id="goods_id" value="${pd.goods_id}" />
								<input type="hidden" name="goods_pic" id="filepath" value="${pd.goods_pic}" />
								<div class="col-md-12">
									<div class="form-group">
										<label class="col-md-3 control-label">分类：</label>
										<div class="col-md-9" style="width: 55%;">
											<select id="select_selectsplitter1" class="form-control"
												style="height: 100px" size="4" >
												<c:forEach items="${category['categoryList']}"
													var="categoryList" varStatus="s">
													<optgroup label="${categoryList.category_name}"
														value="${categoryList.category_id}">
														<c:set value="childcategory${s.index}" var="childcategory"></c:set>
														<c:forEach items="${category[childcategory]}"
															var="childcategory">
															<option value="${childcategory.category_id}"
																<c:if test="${childcategory.category_id eq pd.category_id }">selected="selected"</c:if>>${childcategory.category_name}</option>
														</c:forEach>
													</optgroup>
												</c:forEach>
											</select>
										</div>
										<input type="hidden" value="${pd.category_id}" id="category_id"
											name="category_id"> 
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">图片：</label>
										<div class="col-sm-9" style="width: 55%;">
											<label class="ace-file-input">
											<input type="file" id="file" name="file" onchange="upload()">
											 <span class="ace-file-container" data-title="选择"> 
											 <span class="ace-file-name" data-title="请选择文件 ...">
											    <i class=" ace-icon fa fa-upload"></i>
											 </span>
											 </span>
											 <a class="remove" href="#"><i class=" ace-icon fa fa-times"></i></a>
											 </label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">图片预览：</label>
										<div class="col-sm-9" style="width: 55%;" id="img">
											<c:if test="${!empty pd.goods_pic}">
											  <!-- 先隐藏后台的数据 -->
												<c:forEach items="${fn:split(pd.goods_pic,',')}" var="pic"
													varStatus="index">
													<img alt="" class="icList" name="preview" src="${pic}" width='100' id="${index.index}"
														onclick="delimg('${index.index}')">
													<input type="hidden" name="picvalue" id="v${index.index}"
														value="${pic}" />
												</c:forEach>
											</c:if>
											<input type="hidden" id="picsize"
												value="${fn:length(fn:split(pd.goods_pic,','))}">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">名称：</label>
										<div class="col-sm-9" style="width: 55%;">
											<input type="text" name="goods_name" id="goods_name"
												value="${pd.goods_name}" maxlength="255"
												placeholder="这里输入名称" title="名称" class="col-xs-10 col-sm-5"
												style="width: 100%">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">备注：</label>
										<div class="col-sm-9" style="width: 55%;">
											<input type="text" name="goods_title" id="goods_title"
												value="${pd.goods_title}" maxlength="255"
												placeholder="这里输入备注" title="备注" class="col-xs-10 col-sm-5"
												style="width: 100%">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">价格：</label>
										<div class="col-sm-9" style="width: 55%;">
											<input type="number" name="goods_price" id="goods_price"
												value="${pd.goods_price}" maxlength="32"
												placeholder="这里输入价格" title="价格" class="col-xs-10 col-sm-5"
												style="width: 100%">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">规格：</label>
										<div class="col-sm-9" style="width: 55%;">
											<a class="btn btn-mini btn-primary" id="attr" >添加规格</a>
										</div>
									</div>
									<c:if test="${empty attr_list}">
									<input type="hidden" value="0" id="attr_num" >
									</c:if>
										<c:if test="${!empty attr_list}">
									<input type="hidden" value="${fn:length(attr_list)}" id="attr_num" >
									</c:if>
									<input type="hidden" value="${pd.thead_th}" id="thead_th" name="thead_th">
									<input type="hidden" value="0" id="detail_type" name="detail_type">
									<input type="hidden" value="${pd.attr_td}" id="attr_td" name="attr_td">
									<input type="hidden" value="${pd.detail_name}" id="detail_name" name="detail_name">
									<input type="hidden" value="${pd.attribute_detail_num}" id="attribute_detail_num" name="attribute_detail_num">
									<input type="hidden" value="${pd.attribute_detail_price}" id="attribute_detail_price" name="attribute_detail_price">
									<!-- <div id="attribute"> -->
									<div id="attr_div">
										<c:if test="${!empty attr_list}">
										<c:forEach items="${attr_list}" var="attr_list">	
										<div class="attrdiv">
												<i class="menu-icon fa fa-ban" style="float: right;"
													></i>
												<div class="form-group">
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"></label>
													<div class="col-sm-9" style="width: 55%;">
														<input type="text" name="attribute_name" value="${attr_list.attribute_name}"
															placeholder="销售属性名称" class="col-xs-10 col-sm-5"
															style="width: 20%" onchange="generate()">：
													</div>
													<label class="col-sm-3 control-label no-padding-right"
														for="form-field-1"></label>
													<div class="col-sm-9" style="width: 55%;">
														<c:forEach items="${attr_list.td_list}" var="td_list">	
														<input type="text" name="attribute_detail_name" value="${td_list.attribute_name}"
															class="col-xs-10 col-sm-5" style="width: 20%"
															onchange="generate()">
														</c:forEach>	
														<c:if test="${fn:length(attr_list.td_list)<10}">
														<c:forEach  var="itnum" begin="0" end="${9-fn:length(attr_list.td_list)}">	
														<input type="text" name="attribute_detail_name" 
															class="col-xs-10 col-sm-5" style="width: 20%"
															onchange="generate()">
														</c:forEach>
														</c:if>	
													</div>
												</div>
											</div>
										</c:forEach>
										</c:if>
									</div>
									<!-- 展示属性 -->
									<div id="attr_detail_div">
										<c:if test="${!empty thead_th_arry}">
										<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"></label>
										<div class="col-sm-9" style="width: 55%;"> 
										<table class="table table-striped table-bordered table-hover">
										<thead>
										<tr>
										<c:forEach items="${thead_th_arry}" var="thead_th_arry">
											<th>${thead_th_arry}</th>
										</c:forEach>
										<th>价格</th>
										<th>库存</th>
										</tr>
										</thead>
										<tbody>
										<c:forEach items="${detail_list}" var="detail_list">
										<tr>
										<c:forEach items="${fn:split(detail_list.attribute_detail_name,',')}" var="td">
										<td>${td}</td>
										</c:forEach>
										<td><input type="number" name="adp" value="${detail_list.attribute_detail_price}" min="0.01" step="0.01" class="col-xs-10 col-sm-5" style="width:100%" onchange="detailtype()"></td>
										<td><input type="number" name="adn" value="${detail_list.attribute_detail_num}" min="0" step="1" class="col-xs-10 col-sm-5" style="width:100%" onblur="sum_goods_num()" onchange="detailtype()"></td>
										</tr>
										</c:forEach>
										</tbody>
										</table>
										</div></div>
										</c:if>
									</div>
									<!-- </div> -->
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">数量：</label>
										<div class="col-sm-9" style="width: 55%;">
											<input type="number" name="goods_num" id="goods_num"
												value="${pd.goods_num}" maxlength="32"
												placeholder="这里输入总数量" title="数量" class="col-xs-10 col-sm-5"
												style="width: 100%">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">人气推荐：</label>
										<div class="col-sm-9">
											<div class="col-sm-9">
												<input name="tuijian" id="tuijian" value="1"
													class="ace ace-switch ace-switch-5" type="checkbox"
													<c:if test="${pd.tuijian==1}">checked="checked" </c:if>>
												<span class="lbl"></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">七天无理由：</label>
										<div class="col-sm-9">
											<div class="col-sm-9">
												<input name="reason_return" id="reason_return" value="1"
													class="ace ace-switch ace-switch-5" type="checkbox"
													<c:if test="${pd.reason_return==1}">checked="checked" </c:if>>
												<span class="lbl"></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">条形码：</label>
										<div class="col-sm-9" style="width: 55%;">
											<input type="text" name="gtin" id="gtin"
												value="${pd.gtin}" maxlength="32"
												placeholder="这里输入条形码" title="条形码" class="col-xs-10 col-sm-5"
												style="width: 100%"> 
												<input type="button" onclick="getPlace()" name="gtin" id="gtin"
												value="获取产地" style="width:80px;"> 
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">产地：</label>
										<div class="col-sm-9" style="width: 55%;">
											<input type="text" name="production_place" id="production_place"
												value="${pd.production_place}" maxlength="32"
												placeholder="这里输入产地" title="产地" class="col-xs-10 col-sm-5"
												style="width: 100%">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">保质期：</label>
										<div class="col-sm-9" style="width: 55%;">
											<input type="text" name="effective_date" id="effective_date"
												value="${pd.effective_date}" maxlength="32"
												placeholder="这里输入保质期" title="保质期" class="col-xs-10 col-sm-5"
												style="width: 100%">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">包装：</label>
										<div class="col-sm-9" style="width: 55%;">
											<input type="text" name="pack" id="pack"
												value="${pd.pack}" maxlength="32"
												placeholder="这里输入总包装" title="包装" class="col-xs-10 col-sm-5"
												style="width: 100%">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">储存条件：</label>
										<div class="col-sm-9" style="width: 55%;">
											<input type="text" name="storage_condition" id="storage_condition"
												value="${pd.storage_condition}" maxlength="32"
												placeholder="这里输入储存条件" title="储存条件" class="col-xs-10 col-sm-5"
												style="width: 100%">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1">详情：</label>
										<div class="col-sm-9" style="width: 55%;">
											<textarea rows="" cols="" name="goods_detail" id="content"
												style="width: 100%">${pd.goods_detail}</textarea>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right"
											for="form-field-1"></label>
										<div class="col-sm-9">
											<a class="btn btn-mini btn-primary" onclick="save()">保存</a> <a
												class="btn btn-mini btn-danger"
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
	<!-- 富文本编辑框-->
	<link rel="stylesheet" href="plugins/kindeditor/themes/default/default.css" />
	<script charset="utf-8" src="plugins/kindeditor/kindeditor-min.js"></script>
	<script charset="utf-8" src="plugins/kindeditor/lang/zh_CN.js"></script>
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
				items : [ 'source', 'fontname', 'fontsize', '|', 'forecolor',
						'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter',
						'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image',
						'link', 'fullscreen' ]
			});
		});
	</script>
	<!-- end富文本编辑框-->
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<!--提示框-->
	
	<script src="static/ace/js/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script src="static/ace/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript"
		src="static/ace/js/components-form-tools2.js"></script>
	<script src="static/ace/js/bootstrap-selectsplitter.min.js"
		type="text/javascript"></script>
	<script src="static/ace/js/metronic.js" type="text/javascript"></script>
	<script src="static/ace/js/layout.js" type="text/javascript"></script>
	<script src="static/ace/js/demo.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			// initiate layout and plugins
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			Demo.init(); // init demo features
			ComponentsFormTools2.init();
		});
	</script>

	<script type="text/javascript">
	
	function getPlace(){
 		var gtin = $("#gtin").val();
		var param = {
				gtin:gtin,
        };
		
		$.ajax(
		{
	  		async: true,
	      	type:'get',
	      	url: "<%=basePath%>goods/getProPlace",
	  		cache:false,
	  		dataType: 'json',
	  		data:param,
	  		success: function(data)
	  		{       
					$("#production_place").val(data.place);
		  	}
       })
       
     }
	
		function delimg(id) {
			if(window.confirm('确定要删除该张图片么？')){
				var picsize = $("#picsize").val();
				picsize = picsize - 1;
				$("#picsize").val(picsize);
				$('#' + id).remove();
				$('#v' + id).remove();
				var totalImg = "";
			    $(".icList").each(function(i,l){
			        totalImg = totalImg + $(l).attr('src') + ",";
			      });   
			    var str1 = totalImg.substring(0,totalImg.length-1);
			    document.getElementById("filepath").value = str1;
                return true;
             }else{
                return false;
            }   
		}
		$(function(){
			$('#attr').click(function(){
				$('#attr_div').append('<div class="attrdiv">'//<div id="ad'+attr_num+'">
						+'<i class="menu-icon fa fa-ban" style="float:right;" ></i>'
						+'<div class="form-group">'
						+'<label class="col-sm-3 control-label no-padding-right"'
						+'for="form-field-1"></label>'
						+'<div class="col-sm-9"  style="width: 55%;">'
						+'<input type="text" name="attribute_name" '
						+'	value="" placeholder="销售属性名称" class="col-xs-10 col-sm-5"'
						+'	style="width:20%"  onchange="generate()">：'
						+'</div>'
						+'<label class="col-sm-3 control-label no-padding-right"'
						+'	for="form-field-1"></label>'
						+'<div class="col-sm-9" style="width: 55%;">'
						+'<input type="text" name="attribute_detail_name" '
						+'value="" class="col-xs-10 col-sm-5" style="width:20%" onchange="generate()">'
							
						+'<input type="text" name="attribute_detail_name" '
						+'value=""  class="col-xs-10 col-sm-5" style="width:20%" onchange="generate()">'
								
						+'<input type="text" name="attribute_detail_name"'
						+'value=""  class="col-xs-10 col-sm-5" style="width:20%" onchange="generate()">	'	
								
						+'<input type="text" name="attribute_detail_name"'
						+'value=""  class="col-xs-10 col-sm-5" style="width:20%" onchange="generate()">'
								
						+'<input type="text" name="attribute_detail_name"'
						+'value=""  class="col-xs-10 col-sm-5" style="width:20%" onchange="generate()">'
								
						+'<input type="text" name="attribute_detail_name"'
						+'value=""  class="col-xs-10 col-sm-5" style="width:20%" onchange="generate()">'
							
						+'<input type="text" name="attribute_detail_name"'
						+'value=""  class="col-xs-10 col-sm-5" style="width:20%" onchange="generate()">'
								
						+'<input type="text" name="attribute_detail_name"'
						+'	value=""  class="col-xs-10 col-sm-5" style="width:20%" onchange="generate()">	'	
								
						+'<input type="text" name="attribute_detail_name"'
						+'	value=""  class="col-xs-10 col-sm-5" style="width:20%" onchange="generate()">'
								
						+'	<input type="text" name="attribute_detail_name"'
						+'	value=""  class="col-xs-10 col-sm-5" style="width:20%" onchange="generate()">'	
						+'</div>'
						//+'</div>'
						+'</div>');
			})
		})
			$(function() {
			//$('.fa-ban').click(function(){
			$(document).on("click",".fa-ban",function(){  	
				$(this).parent().remove();
				generate();
			})
		})
	</script>
<script type="text/javascript">
	function generate(){
		var attrdiv = $('.attrdiv');//
		$('#detail_type').val(1);
		var att_th = "" ;
		var att_td = "" ;
		var thead_th ="" ;
		var att_th_arry = new Array() ;
		var att_td_arry = new Array() ;
		var detail_name = "" ;
		var status = 0 ;
		$.each(attrdiv,function(i,item){
			var attribute_name = $(item).find('input[name=attribute_name]').val();
			if(attribute_name!=''){
				if(attribute_name.indexOf(',')!=-1){
					attribute_name=attribute_name.replace(/,/g, "，");
					$(this).val(attribute_name);
				}
				att_th = att_th + '<th>'+attribute_name+'</th>';
				if(i==0){
					thead_th = attribute_name ;
				}else{
					thead_th = thead_th + ',' + attribute_name ;
				}
				att_th_arry[i] = attribute_name ; //当前属性名称
				var attribute_detail_name_arry = $(item).find('input[name=attribute_detail_name]');
				var detail_td =  new Array() ;
				var td_detail_name = "" ;
				$.each(attribute_detail_name_arry,function(j,jtem){
					var attribute_detail_name = jtem.value;
					if(attribute_detail_name.indexOf(',')>0){
						attribute_detail_name=attribute_detail_name.replace(/,/g, "，");
						$(this).val(attribute_detail_name);
					}
					if(attribute_detail_name!=''){
						detail_td[j] = attribute_detail_name ; //当前属性值
						status = 1;
						if(j==0){
							td_detail_name = attribute_detail_name ;
						}else{
							td_detail_name = td_detail_name + "," + attribute_detail_name;
						}
					}
				})
				if(i==0){
					detail_name = td_detail_name ;
				}else{
					detail_name =detail_name  + "qp" + td_detail_name;
				}
				$('#detail_name').val(detail_name);
				att_td_arry[i] = detail_td ; //当前属性值
			}
		})
		var sarr = [[]];
		for (var i = 0; i < att_td_arry.length; i++) {
		    var tarr = [];
		    for (var j = 0; j < sarr.length; j++)
		        for (var k = 0; k < att_td_arry[i].length; k++)
		            tarr.push(sarr[j].concat(att_td_arry[i][k]));
		   			sarr = tarr;
		}
		if(status == 1){
			var tbody_td = sarr.join("qp");
			$('#thead_th').val(thead_th);
			$('#attr_td').val(tbody_td);
			$.each(tbody_td.split('qp'),function(i,item){
				att_td = att_td + '<tr>' ;
				$.each(item.split(','),function(j,jtem){
					att_td = att_td + '<td>' + jtem + '</td>';
				})
				att_td = att_td + '<td><input type="number" name="adp" min="0.01" step="0.01"'
				+'class="col-xs-10 col-sm-5" style="width:100%" onchange="detailtype()"></td><td><input type="number" name="adn" min="0" step="1"'
				+'class="col-xs-10 col-sm-5" style="width:100%" onblur="sum_goods_num()" onchange="detailtype()"></td></tr>' ;
			})
			att_th = att_th + '<th>价格</th><th>库存</th>';
		 	$('#attr_detail_div').html('<div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1"></label>'
				+'<div class="col-sm-9" style="width: 55%;"> <table class="table table-striped table-bordered table-hover"><thead><tr>'+att_th+'</tr></thead><tbody>'+att_td+'</tbody></table></div></div>');
		} 
	
	}
	function sum_goods_num(){
		var attribute_detail_num = $('input[name="adn"]');
		var sum_num = 0 ;
		$.each(attribute_detail_num, function(i, item) {
			sum_num = parseInt(sum_num) + parseInt(item.value);
			$('#goods_num').val(sum_num);
		})
	}
	function  detailtype(){
		$('#detail_type').val(1);
	}
</script>
<script type="text/javascript">
		function save() {
			 var category_id = $("#select-2").val();
			$("#category_id").val(category_id);
			if ($("#select-1").val() == ""||$("#select-1").val() == null) {
				$("#select-1").tips({
					side : 3,
					msg : '请选择分类',
					bg : '#ae81ff',
					time : 2
				});
				$("#select-1").focus();
				return false;
			}
			if ($("#select-2").val() == ""||$("#select-2").val() == null) {
				$("#select-2").tips({
					side : 3,
					msg : '请选择分类',
					bg : '#ae81ff',
					time : 2
				});
				$("#select-2").focus();
				return false;
			}
			var goods_pic = "";
			var picvalue = $('input[name="picvalue"]');
			$.each(picvalue, function(i, item) {
				if (i == 0) {
					goods_pic = picvalue[i].value;
				} else {
					goods_pic = goods_pic + "," + picvalue[i].value;
				}
			})
			if ($("#goods_name").val() == "") {
				$("#goods_name").tips({
					side : 3,
					msg : '请输入名称',
					bg : '#ae81ff',
					time : 2
				});
				$("#goods_name").focus();
				return false;
			}
			if ($("#goods_name").val().length >10) {
				$("#goods_name").tips({
					side : 3,
					msg : '名称不能超过十个汉字',
					bg : '#ae81ff',
					time : 2
				});
				$("#goods_name").focus();
				return false;
			}
			if ($("#goods_title").val() == "") {
				$("#goods_title").tips({
					side : 3,
					msg : '请输入备注',
					bg : '#ae81ff',
					time : 2
				});
				$("#goods_title").focus();
				return false;
			} 
			var attribute_detail_price = $('input[name="adp"]');
			var adp = '' ;
			$.each(attribute_detail_price, function(i, item) {
				if(item.value ==''|| item.value < 0){
					$(this).tips({
						side : 3,
						msg : '请输入价格,价格为正数且最多两位小数',
						bg : '#ae81ff',
						time : 2
					});
					$(this).focus();
					return false;
				}
				if(i==0){
					adp = item.value ;
				}else{
					adp = adp + ',' +item.value ;
				}
				$('#attribute_detail_price').val(adp);
			})
			var attribute_detail_num = $('input[name="adn"]');
			var adn = '' ;
			$.each(attribute_detail_num, function(i, item) {
				if(item.value ==''|| item.value < 0){
					$(this).tips({
						side : 3,
						msg : '请输入数量',
						bg : '#ae81ff',
						time : 2
					});
					$(this).focus();
					return false;
				}
				if(i==0){
					adn = item.value ;
				}else{
					adn = adn + ',' +item.value ;
				}
				$('#attribute_detail_num').val(adn);
			})

			if ($("#goods_num").val() == "") {
				$("#goods_num").tips({
					side : 3,
					msg : '请输入总数量',
					bg : '#ae81ff',
					time : 2
				});
				$("#goods_num").focus();
				return false;
			}
			var pricevd = /^([1-9]\d{0,15}|0)(\.\d{1,2})?$/;
			if (!pricevd.test($("#goods_price").val())) {
				$("#goods_price").tips({
					side : 3,
					msg : '请输入价格,价格为正数且最多两位小数',
					bg : '#ae81ff',
					time : 2
				});
				$("#goods_price").focus();
				return false;
			}
			if ($("#content").val() == "") {
				$(this).tips({
					side : 3,
					msg : '请输入详情',
					bg : '#ae81ff',
					time : 2
				});
				$(this).focus();
				return false;
			}
			
			if ($("#attribute_detail_num").val() == "") {
				$(this).tips({
					side : 3,
					msg : '请输入库存',
					bg : '#ae81ff',
					time : 2
				});
				$(this).focus();
				return false;
			}
			
			if ($("#attribute_detail_price").val() == "") {
				$(this).tips({
					side : 3,
					msg : '请输入价格',
					bg : '#ae81ff',
					time : 2
				});
				$(this).focus();
				return false;
			}
			
			
			//var ImgValues = "";
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
var ImgId = "";
function upload(){
			var files = document.getElementById("file").files;
		    var form = new FormData();
		    form.append("file", files[0]);
		    $.ajax({
		        url:"categoryPictureController/goodsSortP.do",
		        type: "post",
		        data: form,
		        processData: false,
		        contentType: false,
		        success: function (data) { //
		         //ImgId = ImgId + data + ",";
		         setValue(data+",");
		        }
		    });		
		 }
//传过来的是单张照片的请求地址
function setValue(ImgValues){
	var totalImg = "";
	var k = 0;
    $(".icList").each(function(i,l){
        totalImg = totalImg + $(l).attr('src') + ",";
        k = k + 1;
      });
     if(totalImg !=""){
    	 totalImg += ImgValues; 
    	 var str1 = totalImg.substring(0,totalImg.length-1);
    	 document.getElementById("filepath").value = str1;
    	 createForEach(str1,k);
     }else{
    	 var str2 = ImgValues.substring(0,ImgValues.length-1);
    	 document.getElementById("filepath").value = str2;
    	 createForEach(str2,k);
     }
} 

function createForEach(ImgStr,k){
	  //循环生成<img>标签
	  var Imgarr= new Array();
	  Imgarr = ImgStr.split(",");
	  $('.icList').remove();
      $.each(Imgarr, function(i, val) {  //i是数组下标，val是数组元素
         $("#img").append(
        		 '<img  class="icList" name="preview" src="'+ val +'"  width="100" id="'+ k +'" onclick="delimg('+ k +')">'
        		 );
         k = k + 1;
        })  
}
</script>
</body>
</html>

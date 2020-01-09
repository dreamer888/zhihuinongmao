<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description"
	content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body ontouchstart >
	<!--主体-->
	<header class="wy-header">
	<div class="wy-header-icon-back">
		<span onclick="javascript:history.back()"></span>
	</div>
	<div class="wy-header-title">申请退款</div>
	</header>


	
		<input type="hidden" id="pay_total" name="pay_total"
			value="${pd.pay_total }">
		<input type="hidden" id="order_id" name="order_id"
			value="${pd.order_id }">	
		<input type="hidden" id="order_detail_id" name="order_detail_id"
			value="${pd.order_detail_id }">		
		<div class="weui-content clear" id="list">
			<div class="order-list-Below clear">
				<h1>退款金额</h1>
			</div>
			<div class="weui-cells weui-cells_form com-txt-area">
				<div class="weui-cell">

					<div class="weui-cell__bd">
						<input class="weui-textarea txt-area" type="number" onkeyup="check(this)"
						name="refund_price" id="refund_price"	placeholder="请输入退款金额，最多${pd.pay_total}">
					</div>
				</div>
			</div>

			<div class="order-list-Below clear">
				<h1>退款说明</h1>
			</div>
			<div class="weui-cells weui-cells_form com-txt-area">
				<div class="weui-cell">

					<div class="weui-cell__bd">
						<textarea class="weui-textarea txt-area" placeholder="请输入退款说明"
							rows="3" name="refund_explain" id="refund_explain"></textarea>
					</div>
				</div>
			</div>
		</div>
	<div class="foot-black"></div>
	<div class="foot-black"></div>
	<div class="com-button">
		<a href="javascript:add();">提交申请</a>
	</div>

	<script src="static/lib/jquery-2.1.4.js"></script>

	<script src="static/js/jquery-weui.js"></script>


	<script type="text/javascript">
	
	function add(){
		var refund_price = $('#refund_price').val();
		if(refund_price==''){
			$.alert('请输入退款金额');
			return;
		}
		var order_id = $('#order_id').val();
		var order_detail_id = $('#order_detail_id').val();
		var refund_explain = encodeURI($('#refund_explain').val());
		$.showLoading();
		$.ajax({
			url:'order/refund',
			type:'post',
			data:{order_id:order_id,order_detail_id:order_detail_id,refund_price:refund_price,refund_explain:refund_explain},
			success:function(data){
				$.hideLoading();
				if(data.result==1){
					$.toast(data.message);
   					setTimeout('location.href=document.referrer',2000);
				}else{
					$.alert(data.message);
				}
			}
		})
	}
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
	</script>
</body>
</html>

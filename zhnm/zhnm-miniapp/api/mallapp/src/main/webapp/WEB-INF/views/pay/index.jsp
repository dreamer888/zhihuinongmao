<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta id="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport">
<meta name="apple-themes-web-app-capable" content="yes">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<meta content="email=no" name="format-detection">
<meta name="format-detection" content="telephone=no">
<title>支付</title>
<link rel="stylesheet" href="static/css/main.css" type="text/css"
	media="all">
</head>

<body>

	<!--页面加载 开始-->
	<div id="preloader">
		<div id="status">
			<p class="center-text">
				<span>拼命加载中···</span>
			</p>
		</div>
	</div>
	<!--页面加载 结束-->
	<header id="header">
		<div class="header_con">
			<a href="javascript:history.go(-1);"><span></span></a>
			<div class="top_tit">支付</div>
		</div>
	</header>

	<div id="content_div">
		<div class="pay_01">
			商品合计<span><em>${ORDER_TOTAL}夺宝币</em></span>
		</div>
		<div class="pay_02">
			<p>
				支付总额 ：${ORDER_TOTAL}元<span></span>
			</p>
			<ul>

				<li><label class="ui-checkbox2"> <span>夺宝币支付(账户余额：${shopUser.CURRENCY_COUNT})</span>
					<c:if test="${shopUser.CURRENCY_COUNT+0<ORDER_TOTAL+0 }">
							<font style="font-size: 12px" color="#e0e0e0"> 余额不足</font>
						</c:if> <c:if test="${shopUser.CURRENCY_COUNT>=ORDER_TOTAL }">
							<input type="radio" name="PAY_WAY" value="3">
						</c:if>
				</label></li>
			</ul>
			<ul>
				<li><label class="ui-checkbox2"> <span>微信支付</span><input
						type="radio" value="2" name="PAY_WAY" checked="checked">
				</label></li>
			</ul>
		</div>
		<input type="hidden" value="${pd.GOODS_ID }" id="GOODS_ID"> <input
			type="hidden" value="${pd.GOODS_COUNT }" id="GOODS_COUNT"> <input type="hidden" value="${pd.CART_ID }" id="CART_ID">
		
		<div class="pay_04">
			<a class="ui-btn" onclick="order()">立即支付</a>
		</div>
	</div>
	<script src="static/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="static/js/common.js"></script>
	<script type="text/javascript">
		function order() {
			var GOODS_ID = $('#GOODS_ID').val();
			var GOODS_COUNT = $('#GOODS_COUNT').val();
			var CART_ID = $('#CART_ID').val();
			var PAY_WAY = $('input[name="PAY_WAY"]:checked').val();
			$.ajax({
				url : 'addorder',
				type : 'post',
				data : {
					GOODS_ID : GOODS_ID,
					GOODS_COUNT : GOODS_COUNT,
					CART_ID : CART_ID,
					PAY_WAY : PAY_WAY,
					USER_COUPON_ID:0
				},
				success : function(data) {
					if(data.result==1){
						if(PAY_WAY==3){
							window.location.href = 'order/result';
						}
						else if(PAY_WAY==2){
							callpay(data.pk.appId,data.pk.timeStamp,data.pk.nonceStr,data.pk.package,data.pk.paySign);
							
						}
					}else{
						showTip('本次夺宝只有人'+data+'次啦');
					}
				}
			})
		}
		
		function callpay(appId,timeStamp,nonceStr,package,paySign){
	  		
			 WeixinJSBridge.invoke('getBrandWCPayRequest',{
				 "appId" : appId,"timeStamp" : timeStamp, "nonceStr" : nonceStr, "package" : package,"signType" : "MD5", "paySign" :paySign
	   			},function(res){
					WeixinJSBridge.log(res.err_msg);
		            if(res.err_msg == "get_brand_wcpay_request:ok"){  
		                alert("微信支付成功!");  
		                window.location.href = 'order/result';
		            }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
		                alert("用户取消支付!");  
		            }else{  
		               alert("支付失败!");  
		            }  
				})
			}
	</script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>订单详情</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
<link href="static/css/showTip.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="static/js/showTip.js"></script>
</head>
<body ontouchstart id="wrap">
<!--主体-->
<div id="order">
<header class="wy-header">
  <div class="wy-header-icon-back"><span onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">订单详情</div>
</header>
<div class="weui-content">
  <div class="wy-media-box weui-media-box_text address-select">
    <div class="weui-media-box_appmsg" onclick="window.location.href='order/address/tolist?cart_id=${pd.cart_id}&goods_id=${pd.goods_id}&goods_count=${pd.goods_count}&attribute_detail_id=${pd.attribute_detail_id}'">
      <div class="weui-media-box__hd proinfo-txt-l" style="width:20px;"><span class="promotion-label-tit"><img src="static/images/icon_nav_city.png" /></span></div>
      <div class="weui-media-box__bd">
        <a  class="weui-cell_access">
        <c:if test="${empty address}">
          <h4 class="address-name"><span>点击添加收货地址</span></h4>
        </c:if>
        <c:if test="${!empty address}">
          <h4 class="address-name"><span>${address.addr_realname}</span><span>${address.addr_phone}</span></h4>
          <div class="address-txt">${address.addr_city}  ${address.address}</div>
        </c:if>
        </a>
      </div>
      <div class="weui-media-box__hd proinfo-txt-l" style="width:16px;"><div class="weui-cell_access"><span class="weui-cell__ft"></span></div></div>
    </div>
  </div>
  <div class="wy-media-box weui-media-box_text">
    <div class="weui-media-box__bd">
    <c:forEach items="${list}" var="list">
     <div class="weui-media-box_appmsg ord-pro-list">
        <div class="weui-media-box__hd"><a href="goods/info/${list.goods_id}"><img class="weui-media-box__thumb" src="${list.goods_pic}" alt=""></a></div>
        <div class="weui-media-box__bd">
          <h1 class="weui-media-box__desc"><a href="goods/info/${list.goods_id}" class="ord-pro-link">${list.goods_name}</a></h1>
          <p class="weui-media-box__desc">${list.attribute_detail_name}</p>
          <div class="clear mg-t-10">
            <div class="wy-pro-pri fl">¥<em class="num font-15">${list.goods_price}</em></div>
            <div class="pro-amount fr"><span class="font-13">数量×<em class="name">${list.goods_count}</em></span></div>
          </div>
        </div>
      </div>
     </c:forEach>
     <!-- 上步传值信息goods_id,goods_count -->
     <input type="hidden" value="${address.address_id }" id="address_id"/>
     <input type="hidden" value="${pd.goods_id }" id="goods_id"/>
     <input type="hidden" value="${pd.goods_count }" id="goods_count"/>
     <input type="hidden" value="${pd.cart_id }" id="cart_id"/>
     <input type="hidden" value="${pd.attribute_detail_id }" id="attribute_detail_id"/>
     <input type="hidden" value="${coupon.coupon_id }" id="coupon_id"/>
     </div>
    </div>
  </div>
  <div class="weui-panel">
    <div class="weui-panel__bd">
      <div class="weui-media-box weui-media-box_small-appmsg">
        <div class="weui-cells">
          <div class="weui-cell weui-cell_access">
            <div class="weui-cell__bd weui-cell_primary">
              <p class="font-14"><span class="mg-r-10">配送方式</span><span class="fr">快递</span></p>
            </div>
          </div>
          <div class="weui-cell weui-cell_access" href="javascript:;">
            <div class="weui-cell__bd weui-cell_primary">
              <p class="font-14"><span class="mg-r-10">运费</span><span class="fr txt-color-red"><c:if test="${freight_price==0}">包邮</c:if><c:if test="${freight_price!=0}">￥<em class="num">${freight_price}</em></c:if> </span></p>
            </div>
          </div>
          
          <a class="weui-cell weui-cell_access" <c:if test="${coupon_count!=0}">href="javascript:showcoupon()"</c:if>>
            <div class="weui-cell__bd weui-cell_primary">
              <p class="font-14"><span class="mg-r-10">优惠券</span><span class="sitem-tip"><em class="num">${coupon_count}</em>张可用</span>
              <c:if test="${coupon_count!=0}">
              <span class="fr" id="coupon">${coupon.coupon_name}   ${coupon.coupon_price}元</span>
              </c:if>
              </p>
            </div>
            <span class="weui-cell__ft"></span>
          </a>
        </div>
      </div>
    </div>
  </div>
  <div class="wy-media-box weui-media-box_text">
    <div class="mg10-0 t-c">总金额：<span class="wy-pro-pri mg-tb-5">¥<em class="num font-20" id="order_total">${order_total}</em></span></div>
    <div class="mg10-0"><a href="javascript:addorder()" class="weui-btn weui-btn_primary">微信付款</a></div>
  </div>
  <!-- 优惠券 -->
  <div id="join_cart" class='weui-popup__container popup-bottom' style="z-index: 600;">
		<div class="weui-popup__overlay" style="opacity: 1;"></div>
		<div class="weui-popup__modal">
			<div class="modal-content">
				<div class="weui-msg" style="padding-top: 0;">
				<div class="weui-msg__text-area">
						<h3 class="weui-msg__title">可用优惠券</h3>
					</div>
			<div class="weui-cells weui-cells_radio">
				<c:forEach items="${couponlist}" var="couponlist">
				<label class="weui-cell weui-check__label" for="c${couponlist.coupon_id}">
					<div class="weui-cell__bd">
						<p id="t${couponlist.coupon_id}">${couponlist.coupon_name} <span style="float: right;">${couponlist.coupon_price}元</span></p>
					</div>
					<div class="weui-cell__ft">
						<input type="radio" <c:if test="${coupon.coupon_id eq couponlist.coupon_id}">checked</c:if> class="weui-check" name="radio1" id="c${couponlist.coupon_id}" value="${couponlist.coupon_price}" onclick="window.location.href='javascript:chosecoupon(\'${couponlist.coupon_id}\');'">
							<span class="weui-icon-checked"></span>
					</div>
				</label>
				</c:forEach>
				 <label class="weui-cell weui-check__label" for="c0">

					<div class="weui-cell__bd">
						<p id="t0">不使用优惠</p>
					</div>
					<div class="weui-cell__ft">
						<input type="radio" name="radio1" class="weui-check" id="c0" value="0" onclick="window.location.href='javascript:chosecoupon(\'0\');'"> <span class="weui-icon-checked"></span>
					</div>
				</label>
			</div>
					<div class="weui-msg__opr-area">
						<p class="weui-btn-area">
							<a href="javascript:;"
								class="weui-btn weui-btn_default close-popup">关闭</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
function showcoupon(){
	$('#join_cart').attr('class','weui-popup__container popup-bottom weui-popup__container--visible');
}

</script>
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/lib/fastclick.js"></script> 
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script> 
<script src="static/js/jquery-weui.js"></script>
<script>
function chosecoupon(coupon_id){
	var goods_id = $('#goods_id').val();
	var goods_count = $('#goods_count').val();
	var attribute_detail_id = $('#attribute_detail_id').val();
	var coupon_name = $('#t'+coupon_id).text();
	$.showLoading();
	$.ajax({
		url:'order_total',
		type:'post',
		data:{coupon_id:coupon_id,goods_id:goods_id,goods_count:goods_count,attribute_detail_id:attribute_detail_id},
		success:function(data){
			$.hideLoading();
			$('#coupon_id').val(coupon_id)
			$('#coupon').text(coupon_name);
			$('#order_total').text(data.order_total.toFixed(2));
			$('#join_cart').attr('class','weui-popup__container popup-bottom');
		}
	})
	
}
function addorder(){
	var attribute_detail_id = $('#attribute_detail_id').val();
	var address_id = $('#address_id').val();
	if(address_id==''||address_id==null){
		showTip('请添加收货地址！');
		return ;
	}
	var cart_id = $('#cart_id').val();
	var goods_id = $('#goods_id').val();
	var goods_count = $('#goods_count').val();
	var coupon_id = $('#coupon_id').val();
	if(coupon_id==''||coupon_id==null){
		coupon_id = 0;
	}
	var pay_way = 2 ;
	$.showLoading();
	$.ajax({
		url:'addorder',
		type:'post',
		data:{coupon_id:coupon_id,goods_id:goods_id,goods_count:goods_count,cart_id:cart_id,address_id:address_id,pay_way:pay_way,attribute_detail_id:attribute_detail_id},
		success:function(data){
			$.hideLoading();
			$('#cart_count').text(data.cart_count);
			if(data.result==1){
				if(pay_way==3){
					window.location.href = 'order/result';
				}
				else if(pay_way==2){
					
					callpay(data.return_pay.appId,data.return_pay.timeStamp,data.return_pay.nonceStr,data.return_pay.package,data.return_pay.paySign);
			
				}
			}else{
				$.alert(data.message);
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
        	   $.toast("支付成功!");  
        	   setTimeout('window.location.href="order_list"',2000);
           }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
        	   $.toast("支付已取消!"); 
        	   setTimeout('window.location.href="order_list"',2000);
           }else{  
              $.alert("支付失败!",'微信支付');  
           }  
		})
	}
</script>

</body>
</html>

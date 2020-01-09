<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>  
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body ontouchstart>
<header class="wy-header" style="position:fixed; top:0; left:0; right:0; z-index:200;">
  <div class="wy-header-icon-back"><span onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">订单详情</div>
</header>

<div class='weui-content'>
<input type="hidden" value="${pd.order_id}" id="order_id"/>
<div class="wy-center-top" style="margin-top:44px">
    <div class="weui-media-box weui-media-box_appmsg">
      <div class="weui-media-box__hd"></div>
      <div class="weui-media-box__bd">
        <h4 class="weui-media-box__title user-name" id="status"></h4>
       
      </div>
    </div>

  </div>

  <div class="wy-media-box weui-media-box_text address-select">
    <div class="weui-media-box_appmsg" id="express-div" style="border-bottom: 1px solid #ddd;padding-bottom:5px" onclick="express()">
    <form action="express/toinfo" method="post" id="Form">
  	<input type="hidden" id="express_title" name="express_title" />
	<input type="hidden" id="express_name" name="express_name"/>
	<input type="hidden" id="express_num" name="express_num"/>
  </form>
      <div class="weui-media-box__hd proinfo-txt-l" style="width:20px;"><span class="promotion-label-tit"><img src="static/images/center-icon-order-dsh.png" /></span></div>
      <div class="weui-media-box__bd">
        <a class="weui-cell_access" id="express">
          
        </a>
      </div>
      <div class="weui-media-box__hd proinfo-txt-l" style="width:16px;"><div class="weui-cell_access"></div></div>
    </div>
    
    <div class="weui-media-box_appmsg">
      <div class="weui-media-box__hd proinfo-txt-l" style="width:20px;"><span class="promotion-label-tit"><img src="static/images/icon_nav_city.png" /></span></div>
      <div class="weui-media-box__bd">
        <a class="weui-cell_access" id="address">
          
        </a>
      </div>
      <div class="weui-media-box__hd proinfo-txt-l" style="width:16px;"><div class="weui-cell_access"></div></div>
    </div>
  </div>
  <!-- 商品 -->
  <div class="weui-panel weui-panel_access" id="order">
  
  </div>
</div> 
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/lib/fastclick.js"></script> 
<script src="static/js/jquery-weui.js"></script>
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script> 
<script>
	$(function(){
		var order_id=$('#order_id').val();
		$.showLoading();
		$.ajax({
			url:'order',
			type:'post',
			data:{order_id:order_id},
			success:function(data){
				$.hideLoading();
				var order = data.order;
				var expresshtml = '';
				if(order.express_title!='wxkd'){
					expresshtml = '<h4 class="address-name"><span>'+order.express_name+'</span></h4>'
				       +'<div class="address-txt">'+order.express_num+'</div>';
				}else{
					expresshtml = '<h4 class="address-name"><span>无需快递</span></h4>';
					$('#express-div').attr('onclick','');
				}
				$('#address').append('<h4 class="address-name"><span>'+order.addr_realname+'</span><span>'+order.addr_phone+'</span></h4>'
					       +'<div class="address-txt">'+order.addr_city+' '+order.address+'</div>');				
				$('#order').append('<div class="weui-panel__hd"><span>单号：'+order.order_id+'</span></div>');
				$('#express_name').val(order.express_name);
				$('#express_title').val(order.express_title);
				$('#express_num').val(order.express_num);
					var title = '';
					var operation_html = '';
					var refund_html = '';
					if(order.status==0){
						$('#express-div').hide();
						title = '待付款';
						operation_html = '<a href="javascript:del(\''+order.order_id+'\');" class="ords-btn-dele">删除订单</a><a href="javascript:getorder(\''+order.order_id+'\')" class="ords-btn-com receipt">付款</a>';
						
					}else if(order.status==1){
						$('#express-div').hide();
						title = '待发货';
						operation_html = '商品正在打包中，请您耐心等待....';
					}
					else if(order.status==2){
						$('#express').html(expresshtml);
						title = '待收货';
						operation_html = '<a href="javascript:;" class="ords-btn-com receipt">查看物流</a><a href="javascript:status(\''+order.order_id+'\');" class="ords-btn-com receipt">确认收货</a>';
					}
					else if(order.status==3){
						$('#express-div').hide();
						title = '待退款';
						operation_html = '<a class="ords-btn-com receipt">待商家处理</a>';
					}
					else if(order.status==4){
						$('#express-div').hide();
						title = '退款成功';
						operation_html = '<a href="order_info?order_id='+order.order_id+'" class="ords-btn-com receipt">查看详情</a>';
					}
					else if(order.status==5){
						$('#express').html(expresshtml);
						title = '待评价';
						operation_html = '<a href="comment/goAdd?order_id='+order.order_id+'" class="ords-btn-com">去评价</a>';
					}
					else if(order.status==6){
						$('#express').html(expresshtml);
						title = '交易完成';
						operation_html = '<a href="order_info?order_id='+order.order_id+'" class="ords-btn-com">交易完成</a>';
					}
					$('#status').html(title);
					$.each(data.orderdetail,function(j,jtem){
					if(jtem.status==1){
						refund_html =  '<div style="text-align: right;"><a href="order_refund?order_id='+order.order_id+'&order_detail_id='+jtem.order_detail_id+'" class="ords-btn-com receipt">退款</a></div>';
					}
					else if(jtem.status==3){
						refund_html =  '<div style="text-align: right;"><a class="ords-btn-com receipt">等待退款</a></div>';
					}
					else if(jtem.status==4){
						refund_html =  '<div style="text-align: right;"><a class="ords-btn-com receipt">退款成功</a></div>';
					}
					$('#order').append('<div class="weui-media-box__bd  pd-10">'
								+ '<div class="weui-media-box_appmsg ord-pro-list">'
								+ '<div class="weui-media-box__hd"><a ><img class="weui-media-box__thumb" src="'+jtem.goods_pic+'" alt=""></a></div>'
								+ '<div class="weui-media-box__bd">'
								+ '<h1 class="weui-media-box__desc"><a  class="ord-pro-link">'+jtem.goods_name+'</a></h1>'
								+ '<p class="weui-media-box__desc"><span></span><span>&nbsp</span></p>' 
								+ '<div class="clear mg-t-10">'
								+ '<div class="wy-pro-pri fl">¥<em class="num font-15">'+jtem.goods_price.toFixed(2)+'</em></div>'
								+ '<div class="pro-amount fr"><span class="font-13">数量×<em class="name">'+jtem.goods_count+'</em></span></div>'
								+ '</div>'
								+ '</div>'
								+ '</div>'
								+refund_html);
				})
				
				$('#order').append('<div class="weui-panel__hd">'
								+ '<span>商品总价</span><span class="ord-status-txt-ts fr"> '+order.total_price.toFixed(2)+' </span><br>'
							//	+ '<span class="wy-pro-pri">总金额：¥<em class="num font-15">'+item.order_total+'</em></span>'
								+ '<span>运费(快递)</span><span class="ord-status-txt-ts fr">'+order.freight_price.toFixed(2)+'</span><br>'
								+ '<span>店铺优惠</span><span class="ord-status-txt-ts fr">-'+order.coupon_price.toFixed(2)+'</span><br>'
								+ '<span>订单总价</span><span class="ord-status-txt-ts fr">'+order.order_total.toFixed(2)+'</span>'
								+ '</div>'
								+ '<div class="weui-panel__ft">'
								+ '<div class="weui-cell weui-cell_access weui-cell_link oder-opt-btnbox">'
								+ operation_html
								+ '</div>'
								+ '</div>'
								+ '</div>');
					}
				})
	})
	
	
</script> 
<script src="static/js/jquery-weui.js"></script>
<script>
function express(){
	$('#Form').submit();
}
function getorder(order_id){
	var pay_way = 2 ;
	$.showLoading();
	$.ajax({
		url:'getorder',
		type:'post',
		data:{order_id:order_id,pay_way:pay_way},
		success:function(data){
			$.hideLoading();
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
        	   setTimeout('location.reload()',2000);
               
           }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
        	   $.toast("支付已取消!"); 
        	   setTimeout('location.reload()',2000);
           }else{  
              $.alert("支付失败!",'微信支付'); 
           }  
		})
	}

</script>
<script>
function del(order_id){
    $.confirm("您确定要删除此订单吗?", "确认删除?", function() {
    	$.ajax({
			url:'order/delete',
			type:'post',
			data:{order_id:order_id},
			success:function(data){
				if(data.result==1){
					$.toast("订单已经删除!");
					setTimeout('window.location.href=document.referrer',2000);
				}else{
					$.alert(data.message);
				}
			}
    	})
      
    
    })}
function status(order_id){
	   var status = 5;
    $.confirm("您确定要确认收货吗?", "确认收货?", function() {
    	$.ajax({
			url:'order/status',
			type:'post',
			data:{order_id:order_id,status:status},
			success:function(data){
				if(data.result==1){
					$.toast("确认收货成功!");
					setTimeout('location.reload()',2000);
				}else{
					$.alert(data.message);
				}
			}
    	})
    
    })} 
    </script>
</body>
</html>

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
<title>全部订单</title>
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
  <div class="wy-header-icon-back"><span onclick="location.href='center/index'"></span></div>
  <div class="wy-header-title">订单管理</div>
</header>
<div class='weui-content'>
  <div class="weui-tab">
    <div class="weui-navbar" style="position:fixed; top:44px; left:0; right:0; height:44px; background:#fff;">
      <span class="weui-navbar__item proinfo-tab-tit font-14" href="#tab1" id="h" onclick="otherlist('',1)">全部</span>
      <span class="weui-navbar__item proinfo-tab-tit font-14" href="#tab2" id="h0" onclick="otherlist('0',1)">待付款</span>
      <span class="weui-navbar__item proinfo-tab-tit font-14" href="#tab3" id="h1" onclick="otherlist('1',1)">待发货</span>
      <span class="weui-navbar__item proinfo-tab-tit font-14" href="#tab4" id="h2" onclick="otherlist('2',1)">待收货</span>
      <span class="weui-navbar__item proinfo-tab-tit font-14" href="#tab5" id="h5" onclick="otherlist('5',1)">待评价</span>
      <input type="hidden" id="currentPage"/>
      <input type="hidden" id="status" value="${pd.status}"/>
      <input type="hidden" id="totalPage"/>
    </div>
    <div class="weui-tab__bd proinfo-tab-con" style="padding-top:87px;">
      <div id="tab1" class="weui-tab__bd-item-show">
        
      </div>
  </div>
</div>
 <div class="weui-loadmore" id="loading" style="display: none">
    <i class="weui-loading"></i>
    <span class="weui-loadmore__tips">正在加载</span>
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
		$.showLoading();
		var status =$('#status').val();
		$('#h'+status).attr('class','weui-navbar__item proinfo-tab-tit font-14 weui-bar__item--on');
		list(status,1);
	})
	
	var loading = false;
      $(document.body).infinite().on("infinite", function() {
        if(loading) return;
        loading = true
        var status =$('#status').val();
        var totalPage =$('#totalPage').val();
    	var currentPage =$('#currentPage').val();
    	if(parseInt(currentPage) < parseInt(totalPage)){
    		currentPage = parseInt(currentPage) +1 ;
    	}else{
    		return ;
    	}
    	$('#loading').show();
    	list(status,currentPage);
      });
	
      function otherlist(status,currentPage){
    	  $('#tab1').html('');
    	  list(status,currentPage);
      }
	function list(status,currentPage){
		$.ajax({
			url:'orderlist',
			type:'post',
			data:{status:status,currentPage:currentPage},
			success:function(data){
				$.hideLoading();
				$('#loading').hide();
				$('#status').val(status); 
				$('#currentPage').val(data.page.currentPage);
				$('#totalPage').val(data.page.totalPage);
				var list = data.list;
				
				$.each(list,function(i,item){
					var goods_total = 0;
					var title = '';
					var operation_html = '';
					if(item.status==0){
						title = '待付款';
						operation_html = '<a href="javascript:del(\''+item.order_id+'\');" class="ords-btn-dele">删除订单</a><a href="order_info?order_id='+item.order_id+'" class="ords-btn-com receipt">付款</a>';
						
					}else if(item.status==1){
						title = '待发货';
						operation_html = '商品正在打包中，请您耐心等待....<a href="order_info?order_id='+item.order_id+'" class="ords-btn-com receipt">退款</a>';
					}
					else if(item.status==2){
						title = '待收货';
						operation_html = '<form action="express/toinfo" method="post" id="Form'+item.order_id+'">'
						  	+'<input type="hidden" id="express_title" name="express_title" value="'+item.express_title+'" />'
						  	+'<input type="hidden" id="express_name" name="express_name" value="'+item.express_name+'" />'
						  	+'<input type="hidden" id="express_num" name="express_num" value="'+item.express_num+'" />'
						  	+'</form><a href="javascript:express(\''+item.order_id+'\');" class="ords-btn-com receipt">查看物流</a><a href="javascript:status(\''+item.order_id+'\');" class="ords-btn-com receipt">确认收货</a>';
					}
					else if(item.status==3){
						title = '待退款';
						operation_html = '<a href="order_info?order_id='+item.order_id+'" class="ords-btn-com receipt">查看详情</a>';
					}
					else if(item.status==4){
						title = '退款成功';
						operation_html = '<a href="order_info?order_id='+item.order_id+'" class="ords-btn-com receipt">查看详情</a>';
					}
					else if(item.status==5){
						title = '待评价';
						operation_html = '<a href="comment/goAdd?order_id='+item.order_id+'" class="ords-btn-com">去评价</a>';
					}
					else if(item.status==6){
						title = '交易完成';
						operation_html = '<a href="order_info?order_id='+item.order_id+'" class="ords-btn-com">交易完成</a>';
					}
					$('#tab1').append('<div><div class="weui-panel weui-panel_access" id="div'+item.order_id+'">'
			          	 	+ '<div class="weui-panel__hd"><span>单号：'+item.order_id+'</span><span class="ord-status-txt-ts fr">'+title+'</span></div>');
					$.each(item.orderdetail,function(j,jtem){
					$('#tab1').append('<div id="info'+item.order_id+'""> <div class="weui-media-box__bd  pd-10"  onclick="window.location.href=\'order_info?order_id='+jtem.order_id+'\'">'
								+ '<div class="weui-media-box_appmsg ord-pro-list">'
								+ '<div class="weui-media-box__hd"><a ><img class="weui-media-box__thumb" src="'+jtem.goods_pic+'" alt=""></a></div>'
								+ '<div class="weui-media-box__bd">'
								+ '<h1 class="weui-media-box__desc"><a  class="ord-pro-link">'+jtem.goods_name+'</a></h1>'
								+ '<p class="weui-media-box__desc"><span></span><span>'+jtem.attribute_detail_name+'</span></p>' 
								+ '<div class="clear mg-t-10">'
								+ '<div class="wy-pro-pri fl">¥<em class="num font-15">'+jtem.goods_price.toFixed(2)+'</em></div>'
								+ '<div class="pro-amount fr"><span class="font-13">数量×<em class="name">'+jtem.goods_count+'</em></span></div>'
								+ '</div>'
								+ '</div>'
								+ '</div></div>');
					goods_total = parseInt(goods_total) + parseInt(jtem.goods_count) ;
				})
				
				$('#tab1').append('<div id="foot'+item.order_id+'"><div class="ord-statistics">'
								+ '<span>共<em class="num">'+goods_total+'</em>件商品，</span>'
								+ '<span class="wy-pro-pri">总金额：¥<em class="num font-15">'+item.order_total.toFixed(2)+'</em></span>'
								+ '<span>(含运费<b>'+item.freight_price.toFixed(2)+'</b>)</span>'
								+ '</div>'
								+ '<div class="weui-panel__ft">'
								+ '<div class="weui-cell weui-cell_access weui-cell_link oder-opt-btnbox">'
								+operation_html
								+ '</div>'
								+ '</div>'
								+ '</div></div>');
						})
					}
				})
	}
</script> 
<script src="static/js/jquery-weui.js"></script>
<script>

       function del(order_id){
        $.confirm("您确定要删除此订单吗?", "确认删除?", function() {
        	$.ajax({
    			url:'order/delete',
    			type:'post',
    			data:{order_id:order_id+""},
    			success:function(data){
    				if(data.result==1){
    					$.toast("订单已经删除!");
    					$('#div'+order_id).remove();
    					$('#info'+order_id).remove();
    					$('#foot'+order_id).remove();
    				}else{
    					$.alert(data.message);
    				}
    			}
        	})
          
        })}
       function express(order_id){
    	 $('#Form'+order_id).submit();
    	}
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

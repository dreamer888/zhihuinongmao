<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
<title>购物车</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
<link rel="stylesheet" href="static/css/showTip.css">
<script src="static/js/showTip.js"></script> 
</head>
<body id="wrap">
<!--主体-->
<header class="wy-header">
  <div class="wy-header-icon-back"><span onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">购物车</div>
</header>
<form action="toorder" method="post" id="form">
<div class="weui-content">
 <!-- 选中值，需要传回服务端 -->
  <input type="hidden" value="" id="cart_id" name="cart_id"/>
  <input type="hidden" value="" id="goods_count" name="goods_count"/>
  <input type="hidden" value="" id="goods_id" name="goods_id"/>
  <input type="hidden" value="" id="attribute_detail_id" name="attribute_detail_id"/>
  
<div id="list">
  </div> 
</div>
<!--底部导航-->
<div class="foot-black"></div>
<div class="weui-tabbar wy-foot-menu" style="bottom: 45px">
  <div class="npd cart-foot-check-item weui-cells_checkbox allselect">
    <label class="weui-cell allsec-well weui-check__label" for="all">
        <div class="weui-cell__hd">
          <input type="checkbox" class="weui-check" name="all-sec" id="all">
          <i class="weui-icon-checked"></i>
        </div>
        <div class="weui-cell__bd">
          <p class="font-14">全选</p>
        </div>
    </label>
  </div>
  <div class="weui-tabbar__item  npd">
    <p class="cart-total-txt">合计：<i>￥</i><em class="num font-16" id="zong1">0.00</em></p>
  </div>
  <a href="javascript:showTip('您还未选中任何商品');" class="red-color npd w-90 t-c" id="order">
    <p class="promotion-foot-menu-label">去结算</p>
  </a>
</div>
</form>
<div class="weui-loadmore" id="loading" style="display: none">
    <i class="weui-loading"></i>
    <span class="weui-loadmore__tips">正在加载</span>
  </div>
<jsp:include page="../footer3.jsp"></jsp:include>
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/lib/fastclick.js"></script> 
<!-- <script>
  $(function() {
    FastClick.attach(document.body);
  });
</script> -->
<script src="static/js/jquery-weui.js"></script>

<script type="text/javascript">
<!--单个勾选-->
function selectbox(){
      var cartpro = $("input[name=cartpro]:checked");
      var price = 0;
      var cart_id="";
      var goods_id="";
      var goods_count="";
      var attribute_detail_id="";
      $.each(cartpro,function(c,item){
    	  price = parseFloat(price) + parseFloat($('#price'+item.value).val()*$('#count'+item.value).val());
    	  if(c==0){
    		  cart_id = item.value;
    		  goods_id = $('#id'+item.value).val();
    		  goods_count = $('#count'+item.value).val();
    		  attribute_detail_id = $('#attribute_detail_id'+item.value).val();
    	  }else{
    		  cart_id = cart_id+','+item.value;
    		  goods_id = goods_id+','+$('#id'+item.value).val();
    		  goods_count = goods_count+','+$('#count'+item.value).val();
    		  attribute_detail_id = attribute_detail_id +','+$('#attribute_detail_id'+item.value).val();
    	  }
      })
      $('#cart_id').val(cart_id);
      $('#goods_id').val(goods_id);
      $('#goods_count').val(goods_count);
      $('#attribute_detail_id').val(attribute_detail_id);
      if(cartpro.length>0){
    	  $('#order').attr('href','javascript:toorder();');
      }else{
    	  $('#order').attr('href','javascript:showTip(\'您还未选中任何商品\')');
      }
     
    $('#zong1').text(price.toFixed(2));
}

$(document).ready(function () { 
	var cartpro = $("input[name=cartpro]:checked");
	
	<!---全选按钮-->
	$(".allselect").click(function () {
		if($(this).find("input[name=all-sec]").prop("checked")){
			$("input[name=cartpro]").each(function () {
				$(this).prop("checked", true);
			});
			
			 var price = 0;
			 var goods_price = $("input[name=goods_price]");
			 var goods_count = $("input[name=count]");
			 $.each(goods_price,function(i,item){
				 price = parseFloat(price) + parseFloat(item.value*goods_count[i].value);
			});
			 
			 $('#zong1').text(price.toFixed(2));
			 selectbox();
//			 if($("input[name=cartpro]").length>0){
//		    	  $('#order').attr('href','javascript:toorder();');
//		      }else{
//		    	  $('#order').attr('href','javascript:;');
//		      }
		}
		else
   		{
			$("input[name=cartpro]").each(function () {
				if ($(this).prop("checked")) {
					$(this).prop("checked", false);
				} else {
					$(this).prop("checked", true);
				} 
			});
			 $('#order').attr('href','javascript:showTip(\'您还未选中任何商品\')');
			$('#zong1').text('0.00');
   		}
		
	});

});
</script>
<script>
   //  $(document).on("click", ".wy-dele", function(e) {
    	function del(cart_id){
        $.confirm("您确定要把此商品从购物车删除吗?", "确认删除?", function() {
        	$.ajax({
    			url:'cart/delete',
    			type:'post',
    			data:{cart_id:cart_id},
    			success:function(data){
    				if(data.result==1){
    					 $('#cd'+cart_id).remove();
    					 if(data.cart_count==0){
    						 $('#cart_count').remove();
    					 }
    					 else{
    					 	$('#cart_count').text(data.cart_count);
    					 }
    					 $.toast("商品已删除!");
    					 
    					 setTimeout('location.reload()',2000);
    				}
    			}
    		}) 
        }, function() {
          //取消操作
        });
    	 }
    	//  });
    	function update(cart_id,type){
    		var goods_num =$('#num'+cart_id).val();
    		var goods_count =$('#count'+cart_id).val();
 			if(goods_count==''||goods_count<1){
 				goods_count = $('#count'+cart_id).val(1);
 			}
    			if(type==0){
    				if(goods_count>1){
    					goods_count = goods_count-1;
    				}else{
    					
    				}
    			}
    			else if(type==1){
    				goods_count = parseInt(goods_count)+1;
    				
    			}
    			if(goods_num < goods_count){
					showTip('已超出库存');
					return;
				}
            	$.ajax({
        			url:'cart/update',
        			type:'post',
        			data:{cart_id:cart_id,goods_count:goods_count},
        			success:function(data){
        				if(data.result==1){
        					$('#count'+cart_id).val(goods_count);
        					selectbox();
        					$('#cart_count').text(data.cart_count);
        					if(goods_count==1){
        						$('#minus'+cart_id).attr('class','DisDe');
        					}else{
        						$('#minus'+cart_id).attr('class','Decrease');
        					}
        				}
        			}
        	 })
    	}
    	function toorder(){
    		var cart_id =$('#cart_id').val();
    		var goods_id =$('#goods_id').val();
    		var goods_count =$('#goods_count').val();
    		var attribute_detail_id =$('#attribute_detail_id').val();
	   		var cartpro = $("input[name=cartpro]:checked"); //cart_id
	   		if(cartpro.length>0){
	   			window.location.href='toorder?goods_id='+goods_id+'&goods_count='+goods_count+'&cart_id='+cart_id+'&attribute_detail_id='+attribute_detail_id;
		    	//$('#form').submit();
		    }
    	}
    </script>
 <!--列表 -->   
<script>
$(function(){
	//移除全选按钮的全选状态
	$("input[name=all-sec]").removeAttr("checked");
	$.showLoading();
	$.ajax({
		url:'cart/list',
		type:'post',
		success:function(data){
			$('#list').html('');
			$.hideLoading();
			$.each(data.cartlist,function(i,item){
				var defalut_html = '';
				if(item.goods_count==1){
					defalut_html = '<a id="minus'+item.cart_id+'" class="DisDe" onclick="update(\''+item.cart_id+'\',\'0\')"> <i>-</i></a> ';
				}else{
					defalut_html = '<a id="minus'+item.cart_id+'" class="Decrease" onclick="update(\''+item.cart_id+'\',\'0\')"><i>-</i></a>';
				}
				var panel__bd_style = '';
				var goods_num_tip = '';
				if(item.goods_num < item.goods_count){
					panel__bd_style = 'background:#fff1f1;opacity:0.5;';
					goods_num_tip = '库存不足';
				}
				
				
			$('#list').append('<input type="hidden" value="'+item.goods_price+'" id="price'+item.cart_id+'" name="goods_price"/>'+
							'<input type="hidden" value="'+item.attribute_detail_id+'" id="attribute_detail_id'+item.cart_id+'" name="attribute_detail_id"/>'+
							  '<input type="hidden" value="'+item.goods_id+'" id="id'+item.cart_id+'" name="id"/>'+
							  '<div class="weui-panel weui-panel_access" id="cd'+item.cart_id+'">'+
							    '<div class="weui-panel__hd"><span>&nbsp;</span><a href="javascript:del(\''+item.cart_id+'\');" class="wy-dele"></a></div>'+
							    '<div class="weui-panel__bd" style="'+panel__bd_style+'">'+
							      '<div class="weui-media-box_appmsg pd-10">'+
							        '<div class="weui-media-box__hd check-w weui-cells_checkbox">'+
							          '<label class="weui-check__label" for="cart-pto'+item.cart_id+'">'+
							            '<div class="weui-cell__hd cat-check">'+
							            '<input type="checkbox" class="weui-check" name="cartpro" value="'+item.cart_id+'" id="cart-pto'+item.cart_id+'" onclick="selectbox()"><i class="weui-icon-checked"></i>'+
							            '</div>'+
							          '</label>'+
							        '</div>'+
							        '<div class="weui-media-box__hd"><a href="goods/info/'+item.goods_id+'"><img class="weui-media-box__thumb" src="'+item.goods_pic+'" alt=""></a></div>'+
							        '<div class="weui-media-box__bd">'+
							         '<h1 class="weui-media-box__desc"><a href="goods/info/'+item.goods_id+'" class="ord-pro-link">'+item.goods_name+'</a></h1>'+
							         '<p class="weui-media-box__desc"><span>'+item.attribute_detail_name+'</span><span style="float:right">'+goods_num_tip+'</span></p>'+
							          '<div class="clear mg-t-10">'+
							           '<div class="wy-pro-pri fl">¥<em class="num font-15">'+item.goods_price.toFixed(2)+'</em></div>'+
							            '<div class="pro-amount fr">'+
									'<div class="Spinner">'+
									defalut_html+
									'<input type="hidden" value="'+item.goods_num+'" id="num'+item.cart_id+'"><input class="Amount" name="count" type="number" onkeyup="check(this)"  value="'+item.goods_count+'" id="count'+item.cart_id+'" onchange="update(\''+item.cart_id+'\',\'3\')" autocomplete="off" maxlength="3"><a class="Increase" onclick="update(\''+item.cart_id+'\',\'1\')"><i>+</i></a>'+									
										 '</div>'+
										'</div>'+
							          '</div>'+
							        '</div>'+
							      '</div>'+
							   '</div>'+
							  '</div>');

			})
		}
	})
})
function check(obj){   
		
	 	obj.value = obj.value.replace(/[^\d]/g,"");  //清除“数字”和“.”以外的字符  
	   // obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的  
	   // obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); 
	    //obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数  
	   // if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额 
	      obj.value= parseInt(obj.value); 
	    //} 
	   // if(obj.value < 1){
	   //	obj.value = 1 ;
	   // }
	   
	}
</script>
</body>
</html>

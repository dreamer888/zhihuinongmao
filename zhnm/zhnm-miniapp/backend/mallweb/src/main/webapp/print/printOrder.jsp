<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	 String order_id = request.getParameter("order_id") ;
	 String seller_id = request.getParameter("seller_id") ;
%>
<html>
    <head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
        <title>小票打印</title>
        <style type="text/css">
        *{padding:0;margin: 0;}
        h1{font-size: 20px;}
        h3{font-size: 16px;}
        .left{
            float: left;
        }
        .center{
            float:center;
        }
        .clearfix{
            clear: both;
        }
        ul{list-style: none;}
        .print_container{
            padding: 20px;
            width: 97%;
        }
        .section1{
        }
        .section2 label{
            display: block;
        }
        .section3 label{
            display: block;
        }
        .section4{
        }
        .section4 .total label{
            display: block;
        }
        .section4 .other_fee{
            border-bottom: 1px solid #DADADA;
        }
        .section5 label{
            display: block;
        }
        </style>
        <script type="text/javascript" src="<%=basePath%>static/js/jquery-1.7.2.js"></script>
        
        <script language="javascript">
            var order_id = '<%=order_id%>';
            var seller_id = '<%=seller_id%>';
            
	     	$(function () {
	     		  loadList(order_id,seller_id);
	     	})
	     	
	     	function loadList(order_id,seller_id){
	     		
				var param = {
		                    order_id:order_id,
		                    seller_id:seller_id
		        };
				
				$.ajax(
				{
			  		async: false,
			      	type:'POST',
			      	url: "<%=basePath%>login_printOrder",
			  		cache:false,
			  		dataType: 'json',
			  		data:param,
			  		success: function(data)
			  		{
			  			    
			  			    var payInfo = JSON.parse(data.payInfo);
			  			    if(payInfo.hasOwnProperty("shop_code")){
			  			        var shop_code = payInfo.shop_code;
				  			    if (isEmpty(shop_code)) {
				  			    	shop_code = "";
				  			    }
			  			    }else{
			  			    	shop_code = "";
			  			    }
			  			  
			  			    var account = payInfo.account;
			  			    if (isEmpty(account)) {
			  			    	account = "";
			  			    }
			  			    var payInfoHtml = "";
			  			    payInfoHtml +=  "<label>订单编号："+payInfo.order_id+"</label>";
			  			    payInfoHtml +=  "<label>下单时间："+formatDate(payInfo.addtime)+"</label>";
			  			    payInfoHtml +=  "<label>农贸市场："+payInfo.market_name+"</label>";
			  			    payInfoHtml +=  "<label>档口号："+shop_code+"</label>";
			  			    payInfoHtml +=  "<label>商户手机："+account+"</label>";
			  			    $("#payInfo").html(payInfoHtml);
			  			    $("#seller_name").text(payInfo.seller_name);
			  				$("#order_total").text(payInfo.order_total);
			  			    var orderDetailHtml= "";
						    //订单明细
							var orderDetailArr = JSON.parse(data.orderDetailInfo);
							if(orderDetailArr.length>0){
							   for(var i=0;i<orderDetailArr.length;i++){  
								   orderDetailHtml += "<tr>";
								   var goodsName = orderDetailArr[i].goods_name;
								   if (typeof(goodsName) == "undefined"){
									   goodsName = "其他";
								   }
								   orderDetailHtml += "<td>"+goodsName+"</td>";
								   orderDetailHtml += "<td>"+orderDetailArr[i].goods_price+"</td>";
								   orderDetailHtml += "<td>"+orderDetailArr[i].goods_count+"</td>";
								   orderDetailHtml += "<td>"+orderDetailArr[i].goods_total+"</td>";
								   var production_place = orderDetailArr[i].production_place;
								   if (typeof(production_place) == "undefined"){
									   production_place = "";
								   }else{
									   production_place = production_place.substring(0,3);
								   }
								   orderDetailHtml += "<td>"+production_place+"</td>";
								   orderDetailHtml += "</tr>";
							   }
							}
							$("#orderDetail").html(orderDetailHtml);
				  	}
		       })
		}
	    
     	function isEmpty(obj){
     	    if(typeof obj == "undefined" || obj == null || obj == ""){
     	        return true;
     	    }else{
     	        return false;
     	    }
     	}
	    
     	/**
     	 * 格式化日期
     	 * @param {Object} strTime
     	 * @return {TypeName} 
     	 */
     	function formatDate(strTime) {
     	    //var date = new Date(strTime);
     	    //date = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()
     	    //date = date.replace(new RegExp(/-/gm) ,"/");
     	    return strTime;
     	}
     	 
        </script>
    </head>
    <body style="background-color:#fff;">
        <div class="print_container">
            <h1 align="center" id = "seller_name">万擎伟业</h1>
            <span>***********************************************</span>
            <div class="section3" id = "payInfo">
                <!-- <label>订单编号：2018010201</label>
                <label>下单时间：2018-06-08</label>
				<label>农贸市场：福永桥头农贸市场</label>
				<label>商铺：001号</label>
				<label>联系电话：15820406561</label> -->
            </div>
            <span>***********************************************</span>
            <div class="section4">
                <div style="border-bottom: 1px solid #DADADA;">
                  
                    <table style="width: 100%;">
                        <thead id = "head" >
                            <tr>
                                <td width="20%">名称</td>
								<td width="20%">单价(元/kg)</td>
                                <td width="20%">数量</td>
                                <td width="20%">金额(元)</td>
                                <td width="20%">产地</td>
                            </tr>
                        </thead>
                        <tbody id= "orderDetail">
                            <!-- <tr>
                                <td>五花肉</td>
								<td>28.00</td>
                                <td>2</td>
                                <td>28.00</td>
                            </tr>
                             -->
                        </tbody>
                    </table>
                </div>
                
                <div class="total" style="width: 90%;">
                    <label style="text-align: right;">合计</label>
                    <label style="text-align: right;" id = "order_total"></label>
                    <div class="clearfix"></div>
                </div>
             
                <span>***********************************************</span>
            </div>
            <div class="section5">
                <label>服务监督电话：0755-23719069</label>
                <label>技术支持：深圳市万擎伟业通信服务有限公司</label>
                <label>温馨提示：请截图保留电子凭证</label>
            </div>    
             <span>***********************************************</span>
        </div>
    </body>
</html>
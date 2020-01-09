<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>产品详情</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description"
	content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
<link href="static/css/showTip.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="static/js/showTip.js"></script>
</head>
<body ontouchstart id="wrap">
	<!--主体-->
	<div class="weui-content">
		<!--产品详情-->
	
		<div class="weui-tab">
		
			<div class="weui-navbar"
				style="position: fixed; top: 0; left: 0; right: 0; height: 44px;">
				<a class="weui-navbar__item proinfo-tab-tit" onclick="javascript:history.back()"><div class="wy-header-icon-back">
				<span></span>
				</div></a>
				
				<span class="weui-navbar__item proinfo-tab-tit weui-bar__item--on" href="#tab1">商品</span> 
				<span class="weui-navbar__item proinfo-tab-tit" href="#tab2">详情</span>
				<span class="weui-navbar__item proinfo-tab-tit" href="#tab3" id="comment" onclick="comment()">评价</span>
				<span class="weui-navbar__item proinfo-tab-tit"></span>
			</div>
			<div class="weui-tab__bd proinfo-tab-con">
				<div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
					<!--主图轮播-->
					<div class="swiper-container swiper-zhutu">
						<div class="swiper-wrapper">

							<c:forEach items="${fn:split(pd.goods_pic,',')}" var="pic">
								<div class="swiper-slide">
									<img src="${pic }" />
								</div>
							</c:forEach>
						</div>
						<div class="swiper-pagination swiper-zhutu-pagination"></div>
					</div>
					<div class="wy-media-box-nomg weui-media-box_text">
						<input type="hidden"  value="${pd.goods_id}" id="goods_id"/>
						<h4 class="wy-media-box__title">${pd.goods_name }</h4>
						<div class="wy-pro-pri mg-tb-5">
							¥<em class="num font-20">${pd.goods_price }</em>
						</div>
						<p class="weui-media-box__desc">${pd.goods_title}</p>
					</div>
					<c:if test="${!empty couponlist}">
					<div class="wy-media-box2 weui-media-box_text">
						<div class="weui-media-box_appmsg">
							<div class="weui-media-box__hd proinfo-txt-l">
								<span class="promotion-label-tit">优惠</span>
							</div>
							
							<div class="weui-media-box__bd">
								<c:forEach items="${couponlist}" var="couponlist">
								<div class="promotion-message clear">
									<i class="yhq"><span class="label-text">优惠券</span></i> <span
										class="promotion-item-text">满${couponlist.use_price}减${couponlist.coupon_price}</span>
								</div>
								</c:forEach>
					
								<div class="yhq-btn clear">
									<a href="coupon/tolist">去领券</a>
								</div>
							</div>
						</div>
					</div>
					</c:if>
					
					<div class="wy-media-box2 txtpd weui-media-box_text">
						
						<div class="weui-media-box_appmsg">
							<div class="weui-media-box__hd proinfo-txt-l">
								<span class="promotion-label-tit">运费</span>
							</div>
							<div class="weui-media-box__bd">
								<div class="promotion-message clear">
									<span class="promotion-item-text">
									<c:if test="${freight.freight_price.unscaledValue() == 0}">免</c:if>运费
									<c:if test="${freight.freight_price.unscaledValue()!=0 }">
									<div class="wy-pro-pri">¥<span class="num">${freight.freight_price}</span>(满${freight.freight_free_price}免运费)</div>
									</c:if>
									</span>
								</div>
							</div>
						</div>
						
						<div class="weui-media-box_appmsg">
							<div class="weui-media-box__hd proinfo-txt-l">
								<span class="promotion-label-tit">提示</span>
							</div>
							<div class="weui-media-box__bd">
								<div class="promotion-message clear">
									<span class="promotion-item-text"><p
											class="txt-color-ml">
											<c:if test="${pd.reason_return==1}">支持7天无理由退换货</c:if>
											<c:if test="${pd.reason_return!=1}">不支持7天无理由退换货</c:if>
											</p></span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="tab2" class="weui-tab__bd-item ">
					<div class="pro-detail">${pd.goods_detail}</div>
				</div>
				<div id="tab3" class="weui-tab__bd-item">
					<!--评价-->
				<div id="list"></div>	
				 <input type="hidden" id="currentPage"/>
					    <input type="hidden" id="totalPage" />
						<div class="weui-loadmore" id="loading" style="display: none">
					    <i class="weui-loading"></i>
					    <span class="weui-loadmore__tips">正在加载</span>
				  		</div>
				</div>
				
			</div>
		</div>
	</div>
	<span id="tophovertree" title="返回顶部"></span>
	<!--底部导航-->
	<div class="foot-black"></div>
	<div class="weui-tabbar wy-foot-menu">
		<a href="https://qanpai.qiyukf.com/client?k=f7dc0f9e5b2b4e5e3acbffeb7326f107&wp=1" target="main" class="promotion-foot-menu-items">
			<div class="weui-tabbar__icon promotion-foot-menu-kefu"></div>
			<p class="weui-tabbar__label">客服</p>
		</a> <a href="javascript:;" id='show-toast'
			class="promotion-foot-menu-items">
			<c:if test="${empty collection }">
			<input type="hidden" value="0" id="collection"/>
			<div class="weui-tabbar__icon promotion-foot-menu-collection" id="collection-css"></div>
			</c:if>
			<c:if test="${!empty collection }">
			<input type="hidden" value="1" id="collection"/>
			<div class="weui-tabbar__icon promotion-foot-menu-collection-ed" id="collection-css"></div>
			</c:if>
			<p class="weui-tabbar__label">收藏</p>
		</a> <a href="cart/tolist" class="promotion-foot-menu-items"> 
			<div  id="cart_count">
			<c:if test="${cart_count!=0&&!empty cart_count }"><span class="weui-badge" style="position: absolute;top: -.4em;right:0.2em;">${cart_count}</span></c:if>
			</div>			
			<div class="weui-tabbar__icon promotion-foot-menu-cart"></div>
			<p class="weui-tabbar__label">购物车</p>
		</a> <a href="javascript:;"
			class="weui-tabbar__item yellow-color open-popup">
			
			<p class="promotion-foot-menu-label" onclick="begin_order(1)">加入购物车</p>
		</a> <a href="javascript:;" class="weui-tabbar__item red-color open-popup">
			<p class="promotion-foot-menu-label" onclick="begin_order(2)">立即购买</p>
		</a>
	</div>
	<!-- class="weui-popup__container popup-bottom weui-popup__container--visible" -->
	<div id="join_cart" class='weui-popup__container popup-bottom'
		style="z-index: 600;">
		<div class="weui-popup__overlay" style="opacity: 1;"></div>
		<%-- <input type="hidden" value="${detail_json}" id="sys_item"/> --%>
		<input type="hidden" value="${attribute_detail_id}" id="attribute_detail_id"/>
		<div class="weui-popup__modal">
			<div class="modal-content">
			<div class="wy-media-box2 weui-media-box_text">
					<div class="weui-media-box_appmsg">
					<div style="margin-right:10px">
					<c:forEach items="${fn:split(pd.goods_pic,',')}" var="pic" end="0">
					<img src="${pic }" style="width: 50px;height: 50px"/>
					</c:forEach>
					</div>
					<div class="wy-pro-pri fl" style="margin-right:10px">¥<em class="num font-15">${pd.goods_price }</em></div>
					<div>
					<h4 class="wy-media-box__title">库存：<font id="sys_num">${pd.goods_num}</font> 件</h4>
					</div>
					</div>
						<c:forEach items="${attr_list}" var="attr_list">
						<div class="attr">
						 <div class="weui-media-box_appmsg">
							<div class="weui-media-box__hd proinfo-txt-l">
								<span class="promotion-label-tit">${attr_list.attribute_name}</span>
							</div>
							<div class="weui-media-box__bd">
								<div class="promotion-sku clear">
									<ul>
										<c:forEach items="${attr_list.td_list}" var="td_list">
										<li data-aid="${td_list.attribute_name}"><a href="javascript:;">${td_list.attribute_name}</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
						</div>
						</c:forEach>
					 <div class="weui-media-box_appmsg">
							<div class="weui-media-box__hd proinfo-txt-l">
								<span class="promotion-label-tit">数量</span>
							</div>
							<div class="weui-media-box__bd">
								<div class="promotion-sku clear">
								<div class="Spinner">
								 <a class="DisDe" id='minus' href="javascript:updatecount(0)"><i>-</i></a><input
										class="Amount" id="goods_count" value="1" autocomplete="off" maxlength="3"><a
										class="Increase" href="javascript:updatecount(1)"><i>+</i></a>
								</div>
							</div>
							</div>
						</div>
					
					<div class="weui-msg__opr-area">
						<p class="weui-btn-area">
							<a href="javascript:;" id="sure_herf"
								class="weui-btn weui-btn_default" onclick="addcart()">确定</a>
						</p>
					</div>
					</div>
				
			</div>
		</div>
	</div>

	<script src="static/lib/jquery-2.1.4.js"></script>
	<script src="static/lib/fastclick.js"></script>
	<script src="static/js/jquery-weui.js"></script>
	<script src="static/js/swiper.js"></script>
	<script type="text/javascript" src="static/js/jquery.Spinner.js"></script>
	<script>
	//修改数量
	function updatecount(type){
		var goods_count =$('#goods_count').val();
		if(type==0){
			if(goods_count>1){
				goods_count = goods_count-1;
			}
		}
		else if(type==1){
			goods_count = parseInt(goods_count)+1;
			
		}
		if(goods_count==1){
			$('#minus').attr('class','DisDe');
		}else{
			$('#minus').attr('class','Decrease');
		}
		$('#goods_count').val(goods_count);
		
		
	}
	//弹出属性、数量选择框
	function begin_order(type){
		$('#join_cart').attr('class','weui-popup__container popup-bottom weui-popup__container--visible');
		if(type==2){
			$('#sure_herf').attr('onclick','toorder()');
		}
		
	}
	
	//价格json
	if('${detail_json}'!=0){
	var sys_item =  ${detail_json};//$('#sys_item').val();
	//商品规格选择
	$(function(){
		$(".attr").each(function(){
			var i=$(this);
			var p=i.find("ul>li");
			p.click(function(){
				if(!!$(this).hasClass("active")){
					$(this).removeClass("active");
					i.removeAttr("data-attrval");
				}else{
					$(this).addClass("active").siblings("li").removeClass("active");
					i.attr("data-attrval", $(this).attr("data-aid"));
				}
				getattr() //输出价格
			})
		})
		
		//获取对应属性的价格
		function getattr(){
			
			var defaultstats=true;
			var _val='';
			var _resp={
				price:".font-15",
				num:"#sys_num",
				attribute_detail_id:"#attribute_detail_id"
			}  //输出对应的class
			$(".attr").each(function(j,jtem){
				var i=$(this);
				var v=i.attr("data-attrval");
				if(!v){
					defaultstats=false;
				}else{
					_val+=_val!=""?",":"";
					_val+=v;
				}
				/* alert('第'+ j +'行， '+ '选中值 = ' + _val); */
			})
			/* return ; */
			if(!!defaultstats){
				_price=sys_item['attr_detail'][_val]['price'];
				_num=sys_item['attr_detail'][_val]['num'];
				_attribute_detail_id = sys_item['attr_detail'][_val]['attribute_detail_id'];
			}else{
				_price=sys_item['goods_price'];
				_num=sys_item['goods_num'];
				_attribute_detail_id = 0;
			}
			
			//输出价格
			$(_resp.price).text(_price.toFixed(2));
			$(_resp.num).text(_num);
			$(_resp.attribute_detail_id).val(_attribute_detail_id);
		}
	})
	}else{
		$('#detail_id').val(1);
	}
	
	//加入购物车
	function addcart(){
		var goods_id = $('#goods_id').val();
		var goods_count = $('#goods_count').val();
		var attribute_detail_id = $('#attribute_detail_id').val();
		var sys_num = $('#sys_num').text();
		if(attribute_detail_id==0){
			showTip('请选择商品规格属性');
			return ;
		}
		if(goods_count > sys_num){
			showTip('库存不足');
			return ;
		}
		$.ajax({
			url:'cart/add',
			type:'post',
			data:{goods_id:goods_id,goods_count:goods_count,attribute_detail_id:attribute_detail_id},
			success:function(data){
				if(data.result==1){
					showTip(data.message);
					$('#cart_count').html('<span class="weui-badge" style="position: absolute;top: -.4em;right:0.2em;" id="cart_count">'+data.cart_count+'</span>');
					$('#join_cart').attr('class','weui-popup__container popup-bottom');				
				}
				else if(data.result==1005){
					showTip(data.message);
					setTimeout('location.href="app/to_login?url=goods/info/'+goods_id+'"', 2000);
				}
			}
		})
	}
	function toorder(){
		var goods_id = $('#goods_id').val();
		var goods_count = $('#goods_count').val();
		var attribute_detail_id = $('#attribute_detail_id').val();
		if(attribute_detail_id==0){
			showTip('请选择商品规格属性');
			return ;
		}
		if($('#sys_num').text()==0){
			showTip('库存不足');
			return ;
		}
		window.location.href='toorder?goods_id='+goods_id+'&goods_count='+goods_count+'&attribute_detail_id='+attribute_detail_id;
		
	}
	
	 var loading = false;
	  function comment(){
		  $('#comment').removeAttr("onclick");
		  $('#loading').show();
		  loading = false;
		  list(1);
	  }
	  $(document.body).infinite().on("infinite", function() {
	    if(loading) return;
	    loading = true
	    var totalPage =$('#totalPage').val();
		var currentPage =$('#currentPage').val();
		if(parseInt(currentPage) < parseInt(totalPage)){
			currentPage = parseInt(currentPage) +1 ;
		}else{
			return ;
		}
		$('#loading').show();
		list(currentPage);
	  });
	
	function list(currentPage){
		var goods_id = $('#goods_id').val();
		$.ajax({
			url:'app/comment/list',
			type:'post',
			data:{goods_id:goods_id,currentPage:currentPage},
			success:function(data){
				var totalPage = data.page.totalPage;
		    	var currentPage = data.page.currentPage;
				$.hideLoading();
				$('#loading').hide();
				$('#currentPage').val(currentPage);
				$('#totalPage').val(totalPage);
    			if(parseInt(currentPage) < parseInt(totalPage)){
    				loading = false;
    	    	}
				$.each(data.list,function(i,item){
					var html ='';
					var pic = item.comment_pic.split(',');
					$.each(pic,function(j,jtem){
						if(jtem!=''){
							html=html+('<li class="weui-uploader__file" style="background-image: url('+jtem+')"></li>');
						}
					})
					
					var comment_star = '';
					if(item.comment_title == 5){
						comment_star = '<ul>'
					    +'<li class="on"></li>'
					    +'<li class="on"></li>'
					    +'<li class="on"></li>'
					    +'<li class="on"></li>'
					    +'<li class="on"></li>'
					    +'</ul>'
					}else if(item.comment_title == 4){
						comment_star = '<ul>'
						    +'<li class="on"></li>'
						    +'<li class="on"></li>'
						    +'<li class="on"></li>'
						    +'<li class="on"></li>'
						    +'<li></li>'
						    +'</ul>'
						}
					else if(item.comment_title == 3){
						comment_star = '<ul>'
						    +'<li class="on"></li>'
						    +'<li class="on"></li>'
						    +'<li class="on"></li>'
						    +'<li></li>'
						    +'<li></li>'
						    +'</ul>'
						}
					else if(item.comment_title == 2){
						comment_star = '<ul>'
						    +'<li class="on"></li>'
						    +'<li class="on"></li>'
						    +'<li></li>'
						    +'<li></li>'
						    +'<li></li>'
						    +'</ul>'
						}
					else if(item.comment_title == 1){
						comment_star = '<ul>'
						    +'<li class="on"></li>'
						    +'<li></li>'
						    +'<li></li>'
						    +'<li></li>'
						    +'<li></li>'
						    +'</ul>'
						}
					$('#list').append('<div class="weui-panel__bd">'
							+'<div class="wy-media-box weui-media-box_text">'
							+'<div class="weui-cell nopd weui-cell_access">'
							+'<div class="weui-cell__hd">'
							+'<img src="'+item.head_img+'" alt="" style="width: 20px; margin-right: 5px; display: block">'
							+'</div>'
							+'<div class="weui-cell__bd weui-cell_primary">'
							+'<p>'+item.username+ item.comment_title + (item.comment_title ==5)+'</p>'
							+'</div>'
							+'<span class="weui-cell__time">'+item.addtime+'</span>'
							+'</div>'
							+'<div class="order-list-comment clear">'
							+comment_star
							
							/* +'<span class="real-star comment-stars-width5"></span>' */
							+'</div>'
							+'<p class="weui-media-box__desc">'+item.comment_content+'</p>'
							+'<ul class="weui-uploader__files clear mg-com-img">'
							+ html
							+'</ul>'
							+'</div>'
							+'</div>');
				})
					
			}
		})
	}
	</script>
	<script>
		$(function() {
			FastClick.attach(document.body);
		});
	</script>
	
	<script>
		$(".swiper-zhutu").swiper({
			loop : true,
			paginationType : 'fraction',
			autoplay : 5000
		});
	</script>

	<!-- <script>
		//属性切换
		$(function() {
			$(".promotion-sku li").click(
					function() {
						$(this).addClass("active").siblings("li").removeClass(
								"active");
					})
		})
	</script> -->
	<script>
		$(document).on("click", "#show-toast", function() {
			var goods_id = $('#goods_id').val();
			var collection = $('#collection').val();
			var url = ""; 
			var collectioncss = "" ;
			var title ="";
			var cltvalue = 0;
			if(collection==1){
				url = "collection/delete";
				collectioncss = "weui-tabbar__icon promotion-foot-menu-collection" ;
				title = '取消收藏';
			}else{
				url = "collection/add"; 
				collectioncss = "weui-tabbar__icon promotion-foot-menu-collection-ed" ;
				title = '收藏成功';
				cltvalue = 1;
			}
			$.ajax({
				url:url,
				type:'post',
				data:{goods_id:goods_id},
				success:function(data){
					//alert(data.result);
					if(data.result==1){
						$('#collection-css').attr('class',collectioncss);
						$.toast(title);
						$('#collection').val(cltvalue);
					}
					else if(data.result==1005){
						showTip(data.message);
						setTimeout('location.href="app/to_login?url=goods/info/'+goods_id+'"', 2000);
					}
				}
			})
		})
	</script>
	<!-- <script>
		$(document).on("open", ".weui-popup-modal", function() {
			console.log("open popup");
		}).on("close", ".weui-popup-modal", function() {
			console.log("close popup");
		});
	</script> -->
	<script>
		$(function() {
			initTopHoverTree("tophov" + "ertree", 30, 10, 10);
		})
	</script>
	<script>
		function initTopHoverTree(hvtid, times, right, bottom) {
			$("#" + hvtid).css("right", right).css("bottmo", bottom);
			$("#" + hvtid).on("click", function() {
				goTopHovetree(times);
			})
			$(window).scroll(function() {
				if ($(window).scrollTop() > 268) {
					$("#" + hvtid).fadeIn(100);
				} else {
					$("#" + hvtid).fadeOut(100);
				}
			});
		}
		//返回顶部动画
		//goTop(500);//500ms内滚回顶部
		function goTopHovetree(times) {
			if (!!!times) {
				$(window).scrollTop(0);
				return;
			}
			var sh = $('body').scrollTop();//移动总距离
			var inter = 13.333;//ms,每次移动间隔时间
			var forCount = Math.ceil(times / inter);//移动次数
			var stepL = Math.ceil(sh / forCount);//移动步长
			var timeId = null;
			function aniHovertree() {
				!!timeId && clearTimeout(timeId);
				timeId = null;
				//console.log($('body').scrollTop());
				if ($('body').scrollTop() <= 0 || forCount <= 0) {//移动端判断次数好些，因为移动端的scroll事件触发不频繁，有可能检测不到有<=0的情况
					$('body').scrollTop(0);
					return;
				}
				forCount--;
				sh -= stepL;
				$('body').scrollTop(sh);
				timeId = setTimeout(function() {
					aniHovertree();
				}, inter);
			}
			aniHovertree();
		}
	</script>
</body>
</html>

 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>发表评价</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
<link rel="stylesheet" href="static/css/showTip.css" type="text/css">
<script type="text/javascript" src="static/js/showTip.js"></script>	
</head>
<body ontouchstart id="wrap">
<!--主体-->
<header class="wy-header">
  <div class="wy-header-icon-back"><span  onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">发表评价</div>
</header>


<!-- <input type="hidden" name="comment_title" id="comment_title" /> -->
<form action="comment/add" method="post" id="Form">
<input type="hidden" id="order_id" name="order_id" value="${pd.order_id }"> 
<div class="weui-content clear" id="list">
</div>
</form>
<div class="foot-black"></div><div class="foot-black"></div>
<div class="com-button"><a href="javascript:add();">发表评价</a></div>

<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/lib/fastclick.js"></script> 
<script>
  $(function() {
    FastClick.attach(document.body);
  });
</script> 
<script src="static/js/jquery-weui.js"></script>
<script type="text/javascript">

    function clickstar(len,order_detail_id){
    	$('[name=li'+order_detail_id+']').removeClass();
    	for(var i=0;i<len;i++){
    		$('#li'+i+order_detail_id).addClass("on");
    	}
    	$('#comment_title'+order_detail_id).val(len);
    }

</script>
<script type="text/javascript" src="static/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="static/js/uploadimgs.js"></script> 
	<script type="text/javascript">
	
	$(function(){
		var order_id = $('#order_id').val();
		$.ajax({
			url:'orderDetail/list',
			type:'post',
			data:{order_id:order_id},
			success:function(data){
				$.each(data,function(i,item){
				$('#list').append('<div class="order-list-Below clear">'
						/* +'<input type="hidden" name="comment_pic'+item.order_detail_id+'" id="filepath'+item.order_detail_id+'"/>' */
						+'<input type="hidden" name="comment_title'+item.order_detail_id+'" id="comment_title'+item.order_detail_id+'" value="5"/>'
						+'<input type="hidden" name="picsize" id="picsize'+item.order_detail_id+'" value="0"/>'
						+'<span style="float:left;"><img src="'+item.goods_pic+'" style="width:20px;"></span>'
					    +'<h1>商品评价</h1>'
					    +'<ul>'
					    +'<li class="on" name="li'+item.order_detail_id+'" id="li0'+item.order_detail_id+'" onclick="clickstar(1,\''+item.order_detail_id+'\')"></li>'
					    +'<li class="on" name="li'+item.order_detail_id+'" id="li1'+item.order_detail_id+'" onclick="clickstar(2,\''+item.order_detail_id+'\')"></li>'
					    +'<li class="on" name="li'+item.order_detail_id+'" id="li2'+item.order_detail_id+'" onclick="clickstar(3,\''+item.order_detail_id+'\')"></li>'
					    +'<li class="on" name="li'+item.order_detail_id+'" id="li3'+item.order_detail_id+'" onclick="clickstar(4,\''+item.order_detail_id+'\')"></li>'
					    +'<li class="on" name="li'+item.order_detail_id+'" id="li4'+item.order_detail_id+'" onclick="clickstar(5,\''+item.order_detail_id+'\')"></li>'
					    +'</ul>'
					    +'</div>'
					    +'<div class="weui-cells weui-cells_form com-txt-area">'
					    +'<div class="weui-cell">'
					    +'<div class="weui-cell__bd">'
					    +'<textarea class="weui-textarea txt-area" name="comment_content'+item.order_detail_id+'" id="comment_content'+item.order_detail_id+'" placeholder="这个商品满足你的期待吗？说说你的使用心得，分享给想买的他们吧" rows="3"></textarea>'
					    /* +'<div class="weui-textarea-counter font-12 num"><span>0</span>/200</div>' */
					    +'</div>'
					    +'</div>'
					    +'</div>'
					    +'<div class="weui-cells weui-cells_form">'
					    +'<div class="weui-cell">'
					    +'<div class="weui-cell__bd">'
					    +'<div class="weui-uploader">'
					    +'<div class="weui-uploader__hd">'
					    +'<p class="weui-uploader__title font-14">图片上传</p>'
					    /* +'<div class="weui-uploader__info font-12">0/2</div>' */
					    +'</div>'
					    +'<div class="weui-uploader__bd">'
					    +'<ul class="weui-uploader__files" id="img'+item.order_detail_id+'">'
					    +'</ul>'
					    +'<div class="weui-uploader__input-box">'
					    +'<input name="file" id="file'+item.order_detail_id+'"  onchange="upload(\''+item.order_detail_id+'\')" class="weui-uploader__input" type="file">'
					    +'</div>'
					    +'</div>'
					    +'</div>'
					    +'</div>'
					    +'</div>'
					    +'</div>');
				})
			}
		})
	})
	function add(){
		$("#Form").submit();
	}
	
	</script>
</body>
</html>

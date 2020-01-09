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
<title></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.">
<link rel="stylesheet" href="static/lib/weui.min.css">
<link rel="stylesheet" href="static/css/jquery-weui.css">
<link rel="stylesheet" href="static/css/style.css">
<link href="static/css/showTip.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="static/js/showTip.js"></script>
</head>
<body ontouchstart id="wrap">
<!--主体-->
<header class="wy-header">
  <div class="wy-header-icon-back"><span onclick="javascript:history.back()"></span></div>
  <div class="wy-header-title">手机修改</div>
</header>
<div class="weui-content">
  <div class="weui-cells weui-cells_form wy-address-edit">
    
    <div class="weui-cell weui-cell_vcode">
      <div class="weui-cell__hd"><label class="weui-label wy-lab">手机号</label></div>
      <div class="weui-cell__bd"><input class="weui-input" name="phone" id="phone" value="${shopUser.phone}" type="number" pattern="[0-9]*" placeholder="请输入手机号"></div>
      <div class="weui-cell__ft"><button class="weui-vcode-btn" onclick="getcode()" id="getcode">获取验证码</button></div>
    </div>
    <div class="weui-cell">
      <div class="weui-cell__hd"><label class="weui-label wy-lab">验证码</label></div>
      <div class="weui-cell__bd"><input class="weui-input" id="code" type="number"  pattern="[0-9]*"  placeholder="请输入验证码"></div>
    </div>
  <div class="weui-btn-area"><a href="javascript:update();" class="weui-btn weui-btn_primary">确认修改</a></div>
</div>

<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/js/jquery-weui.js"></script><script src="static/js/jquery.cookie.js" ></script>

<script>
var myreg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$/;
function update(){
	
	var phone =$('#phone').val();
	if (!myreg.test(phone)) {
		showTip('请填写正确的手机号码！');
		return;
	}
	$.showLoading();
	var code =$('#code').val();
	
	$.ajax({
		url:'user/update_phone',
		type:'post',
		data:{phone:phone,code:code},
		success:function(data){
			$.hideLoading();
			if(data.result==1){
				$.toast(data.message);
				setTimeout('location.href=document.referrer', 2000);
			}else{
				$.alert(data.message);
			}
		}
	})
}	
function getcode(){
	var phone =$('#phone').val();
	if (!myreg.test(phone)) {
		showTip('请填写正确的手机号码！');
		return;
	}
	$.showLoading();
	$.ajax({
		url:'app/getcode',
		type:'post',
		data:{phone:phone},
		success:function(data){
			$.hideLoading();
			$.toast(data.message);
		}
	})
}	
</script>
<script type="text/javascript">
$(function(){
    /*仿刷新：检测是否存在cookie*/
    if($.cookie("captcha")){
        var count = $.cookie("captcha");
        var btn = $('#getcode');
        btn.text(count+'秒后可重新获取').attr('disabled',true).css('cursor','not-allowed');
        var resend = setInterval(function(){
            count--;
            if (count > 0){
                btn.text(count+'秒后可重新获取').attr('disabled',true).css('cursor','not-allowed');
                $.cookie("captcha", count, {path: '/', expires: (1/86400)*count});
            }else {
                clearInterval(resend);
                btn.text("获取验证码").removeClass('disabled').removeAttr('disabled style');
            }
        }, 1000);
    }
    /*点击改变按钮状态，已经简略掉ajax发送短信验证的代码*/
    $('#getcode').click(function(){
    	var phone =$('#phone').val();
    	if (myreg.test(phone)) {
        var btn = $(this);
        var count = 60;
        var resend = setInterval(function(){
            count--;
            if (count > 0){
                btn.text(count+"秒后可重新获取");
                $.cookie("captcha", count, {path: '/', expires: (1/86400)*count});
            }else {
                clearInterval(resend);
                btn.text("获取验证码").removeAttr('disabled style');
            }
        }, 1000);
        btn.attr('disabled',true).css('cursor','not-allowed');
	}
    });
}
    );
</script>
</body>
</html>

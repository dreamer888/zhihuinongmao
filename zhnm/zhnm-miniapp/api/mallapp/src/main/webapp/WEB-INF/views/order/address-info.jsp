<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
<base href="<%=basePath%>">
<!DOCTYPE>
<html>
<head>
<title>编辑地址</title>
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
<header class="wy-header">
  <div class="wy-header-icon-back"><span onclick="history.back()"></span></div>
  <div class="wy-header-title">编辑地址</div>
</header>
<div class="weui-content">
<input type="hidden" value="${pd.address_id} " id='address_id'>
<input type="hidden" value="address/${msg}" id='msg'>
  <div class="weui-cells weui-cells_form wy-address-edit">
    <div class="weui-cell">
      <div class="weui-cell__hd"><label class="weui-label wy-lab">收货人</label></div>
      <div class="weui-cell__bd"><input class="weui-input" type="text" value="${pd.addr_realname}" id="addr_realname" placeholder="请填写收货人"></div>
    </div>
    <div class="weui-cell">
      <div class="weui-cell__hd"><label class="weui-label wy-lab">手机号</label></div>
      <div class="weui-cell__bd"><input class="weui-input" type="tel" value="${pd.addr_phone}" id="addr_phone" pattern="[0-9]*" placeholder="请填写手机号"></div>
    </div>
    <div class="weui-cell">
      <div class="weui-cell__hd"><label for="name" class="weui-label wy-lab">所在地区</label></div>
      <div class="weui-cell__bd">
      <c:if test="${msg eq 'edit'}">
      <input class="weui-input" id="address" type="text" value="${pd.addr_city}" readonly="">
      </c:if>
      <c:if test="${msg eq 'save'}">
      <input class="weui-input" id="address" type="text" value="江苏省 南京市 玄武区" readonly="">
      </c:if>
      </div>
    </div>
    <div class="weui-cell">
      <div class="weui-cell__hd"><label class="weui-label wy-lab">详细地址</label></div>
      <div class="weui-cell__bd">
        <textarea class="weui-textarea" id="address_info" placeholder="请输入详细地址">${pd.address}</textarea>
      </div>
    </div>
     <div class="weui-cell weui-cell_switch">
      <div class="weui-cell__bd">设为默认地址</div>
      <div class="weui-cell__ft"><input class="weui-switch" type="checkbox" <c:if test="${msg eq 'edit'}" > <c:if test="${pd.is_default==1}" >checked="checked"  </c:if> <c:if test="${empty pd.is_default}" > </c:if> </c:if> <c:if test="${msg eq 'save'}" > checked="checked" </c:if> onclick="cho()"></div>
     <input type="hidden" <c:if test="${msg eq 'edit'}" > value="${pd.is_default }" </c:if> <c:if test="${msg eq 'save'}" > value="1" </c:if> id='is_default'>
    </div>
     <%-- <div class="weui-cell weui-cell_switch">
      <div class="weui-cell__bd">设为默认地址</div>
      <div class="weui-cell__ft">    <c:if test="${msg eq 'edit'}" >
    <c:if test="${pd.is_default==1}" >
    <input class="weui-switch" type="checkbox" checked="checked" onclick="cho()">
    </c:if>
    <c:if test="${pd.is_default!=1}" >
    <input class="weui-switch" type="checkbox" onclick="cho()">
    </c:if>
    <input type="hidden"  value="${pd.is_default }"  id='is_default'>
    </c:if>
    
    <c:if test="${msg eq 'save'}" >
    <input class="weui-switch" type="checkbox" onclick="cho()">
    <input type="hidden"  value=""  id='is_default'>
    </c:if>
    </div>
    
    </div> --%>
  </div> 
  <div class="weui-btn-area">
    <a class="weui-btn weui-btn_primary" href="javascript:addradd();" id="showTooltips">保存此地址</a>
    <c:if test="${msg eq 'edit'}" >
    <a href="javascript:del('${pd.address_id}');" class="weui-btn weui-btn_warn">删除此地址</a>
    </c:if>
  </div>

</div>
<script src="static/lib/jquery-2.1.4.js"></script> 
<script src="static/js/jquery-weui.js"></script>
<script src="static/js/city-picker.js"></script>
<script>
<!--新增/修改地址-->
function addradd(){
	var msg = $('#msg').val();
	var address_id = $('#address_id').val();
	var addr_realname = $('#addr_realname').val();
	if(addr_realname==''){
		showTip('请输入联系人');
		return ;
	}
	var addr_phone = $('#addr_phone').val();
	if(addr_phone==''){
		showTip('请输入手机号');
		return ;
	}
	var addr_city = $('#address').val();
	
	if(addr_city==''){
		showTip('选择所在地区');
		return ;
	}

	var address = $('#address_info').val();
	if(address==''){
		showTip('请输入地址');
		return ;
	}
	var is_default = $('#is_default').val();
	$.ajax({
		url:msg,
		type:'post',
		data:{addr_realname:addr_realname,addr_phone:addr_phone,addr_city:addr_city,is_default:is_default,address_id:address_id,address:address},
		success:function(data){
			showTip(data.message);
			setTimeout('window.location.href=document.referrer',2000);
		}
	})
	
}

function del(address_id){
	$.confirm("您确定要把此商品从购物车删除吗?", "确认删除?", function() {
	$.ajax({
		url:'address/delete',
		type:'post',
		data:{address_id:address_id},
		success:function(data){
			showTip(data.message);
			setTimeout('window.location.href=document.referrer',2000);
		}
	})
	})
}

function cho(){
	var is_default =$('#is_default').val();
	if(is_default==1){
		$('#is_default').val('');
	}else{
		$('#is_default').val(1);
	}
}

</script>
<script>
      $("#address").cityPicker({
        title: "选择所在地区",
        onChange: function (picker, values, displayValues) {
          console.log(values, displayValues);
        }
      });
</script>
</body>
</html>

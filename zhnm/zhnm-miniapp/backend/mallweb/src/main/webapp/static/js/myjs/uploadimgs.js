function upload() {
	
	var picsize = $("#picsize").val();
	var fp = document.getElementById("file").value;
	// 为了避免转义反斜杠出问题，这里将对其进行转换

	var re = /(\\+)/g;
	var fn = fp.replace(re, "#");
	// 对路径字符串进行剪切截取
	var one = fn.split("#");
	// 获取数组中最后一个，即文件名
	var two = one[one.length - 1];
	// 再对文件名进行截取，以取得后缀名
	var three = two.split(".");
	// 获取截取的最后一个字符串，即为后缀名
	var last = three[three.length - 1];
	last = last.toLowerCase();

	if (last != 'png' && last != 'jpg' && last != 'gif' && last != 'PNG'
			&& last != 'JPG' && last != 'GIF') {
		alert("请上传png、jpg或者gif文件！");
		return;
	}
	$.ajaxFileUpload({
		url : 'upload', // 需要链接到服务器地址
		secureuri : false,
		fileElementId : "file", // 文件选择框的id属性
		dataType : 'text', // 服务器返回的格式，可以是json
		success : function(rs) // 相当于java中try语句块的用法
		{
			var data = eval('(' + rs + ')');
			if (data.result == 1) {
				picsize = parseInt(picsize)+parseInt(1);
				// $('#img').html("");
				$('#img').append(
						"<img src='" + data.url + "' width='70' hegiht='70' id = '"+picsize+"' onclick='delimg("+picsize+")'>")
						.append("<input type='hidden' name='picvalue' id = 'v"+picsize+"' value='" + data.url + "'/>");
				$("#picsize").val(picsize);
				//$("#filepath").val(data.url);
			} else {
				alert('失败');
				// document.getElementById("msg"+m[1]).value="失败";
			}
		},
		error : function(data, status, e) // 相当于java中catch语句块的用法
		{
			alert('异常');

		}
	});
	
	/**
	 * 根据图片id ，移除商品图片
	 */
	function delimg(id){
//		$('#'+id).remove();
	}
}

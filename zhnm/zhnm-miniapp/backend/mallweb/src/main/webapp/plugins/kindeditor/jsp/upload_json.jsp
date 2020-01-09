<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="com.fh.controller.system.CateforyPictureController.*" %>
<%

/**
 * KindEditor JSP
 * 
 * 本JSP程序是演示程序，建议不要直接在实际项目中使用。
 * 如果您确定直接使用本程序，使用之前请仔细确认相关安全设置。
 * 
 */

//文件保存目录路径
String savePath = pageContext.getServletContext().getRealPath("/")+ "../mallupload";
//文件保存目录URL
String saveUrl = request.getContextPath()+"../mallupload";
//定义允许上传的文件扩展名
HashMap<String, String> extMap = new HashMap<String, String>();
extMap.put("image", "gif,jpg,jpeg,png,bmp");
extMap.put("flash", "swf,flv");
extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
//最大文件大小
long maxSize = 10000000;
response.setContentType("text/html; charset=UTF-8");
if(!ServletFileUpload.isMultipartContent(request)){
	out.println(getError("请选择文件。"));
	return;
}
FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
upload.setHeaderEncoding("UTF-8");
List items = upload.parseRequest(request);
Iterator itr = items.iterator();
String ImgUrl = "";
//上传至阿里云后的图片路径
CateforyPictureController cateforyPictureController = new CateforyPictureController();
ImgUrl = cateforyPictureController.newsImage(itr);
JSONObject obj = new JSONObject();
obj.put("error", 0);
obj.put("url", ImgUrl);
out.println(obj.toJSONString());
%>
<%!
private String getError(String message) {
	JSONObject obj = new JSONObject();
	obj.put("error", 1);
	obj.put("message", message);
	return obj.toJSONString();
}
%>





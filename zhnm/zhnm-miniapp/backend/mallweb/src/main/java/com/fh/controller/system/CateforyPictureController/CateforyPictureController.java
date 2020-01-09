package com.fh.controller.system.CateforyPictureController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.change.controller.base.BaseController;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yq.util.ALiYunOss;

/**
 * @author zangmaoyuan
 *2018-5-28
 * 
 */
@Controller
@RequestMapping(value = "/categoryPictureController")
public class CateforyPictureController  extends BaseController{
	
	private static String categoryUrl = "";
	private static String goodsUrl = "";
	//private static String bannerUrl = "";
	/**
	 * 读取配置文件
	 */
	public static void getProperties(){
		
		try {
	    	  Properties prop = null;
	    	  prop = PropertiesLoaderUtils.loadAllProperties("oss.properties");
	    	  categoryUrl = prop.getProperty("categoryUrl");
	    	  goodsUrl = prop.getProperty("goodsUrl");
	          } catch (IOException e) {
	              e.printStackTrace();     
	         }
	}
	
	/**
	 * 添加蔬菜类 图片上传
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/categorySortP")
	@ResponseBody
	public Object categorySort(@RequestParam("file") MultipartFile file) {	
		getProperties();
		String urlImg = "";
		String url = "";
	    try {
	    	InputStream ins = file.getInputStream();  
            File f=new File(file.getOriginalFilename());  
            inputStreamToFile(ins, f); 
			 urlImg = ALiYunOss.CategorySortupLoadImg(f);
			 url = categoryUrl+urlImg;
			 f.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	/**
	 * 添加具体商品图片上传
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/goodsSortP")
	@ResponseBody
	public Object goodsSort(@RequestParam("file") MultipartFile file) {	
		getProperties();
		String urlImg = "";
		String url = "";
	    try {
	    	InputStream ins = file.getInputStream();  
            File f=new File(file.getOriginalFilename());  
            inputStreamToFile(ins, f); 
			 urlImg = ALiYunOss.goodsSortupLoadImg(f);
			 url = goodsUrl + urlImg;
			 f.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	/**
	 * 图片转换
	 */
	@RequestMapping(value = "/banner")
	@ResponseBody
	public Object banner(@RequestParam("file") MultipartFile file) {	
		getProperties();
		String urlImg = "";
		String url = "";
	    try {
	    	InputStream ins = file.getInputStream();  
            File f=new File(file.getOriginalFilename());  
            inputStreamToFile(ins, f); 
			 urlImg = ALiYunOss.goodsSortupLoadImg(f);
			 url = goodsUrl + urlImg;
			 f.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	
	@SuppressWarnings("rawtypes")
	public  String  newsImage(Iterator itr){
		getProperties();
		String url = "";
		String  urlImg  = "";
		FileItem item = null;
		String fileName = "";
		while (itr.hasNext()) {//这样上传就会很慢慢
			item = (FileItem) itr.next();
			 fileName = item.getName();
			}
		try {
			InputStream ins = item.getInputStream();
			 File fileNames = new File(fileName);
	         inputStreamToFile(ins, fileNames); 
			 urlImg = ALiYunOss.goodsSortupLoadImg(fileNames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 url = goodsUrl + urlImg;
		
		 return url;
	}
	
	
	/**
	 * 文件转换
	 * @param ins
	 * @param file
	 */
	public static void inputStreamToFile(InputStream ins,File file) {  
	      try {  
	       OutputStream os = new FileOutputStream(file);  
	       int bytesRead = 0;  
	       byte[] buffer = new byte[8192];  
	       while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {  
	        os.write(buffer, 0, bytesRead);  
	       }  
	       os.close();  
	       ins.close();  
	      } catch (Exception e) {  
	       e.printStackTrace();  
	      }  
	     } 
}

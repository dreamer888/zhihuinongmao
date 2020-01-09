package com.wqwy.zhnm.base.component.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil {

	private static final Log log = LogFactory.getLog(StringUtil.class);

	/**
	 * 公共的方法
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean checkObj(Object obj) {
		boolean bool = true;
		if (obj == null || "".equals(obj.toString().trim()))
			bool = false;
		return bool;
	}

	public static boolean checkStr(String str) {
		boolean bool = true;
		if (str == null || "".equals(str.trim()))
			bool = false;
		return bool;
	}

	public static String toString(Object obj) {
		return obj != null ? obj.toString() : "";
	}
	
	public static Long toLong(Object obj) {
		String str = toString(obj);
		return str != "" ? Long.parseLong(str) :0L;
	}
	/***
	 * 基础json数据
	 * 
	 * @param dList
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getBasetJsonData(List dList) {
		StringBuffer data = new StringBuffer();
		if (dList != null) {
			JSONArray ja = JSONArray.fromObject(dList);
			data.append(ja.toString());
		}
		return data.toString();

	}

	/***
	 * 基础json数据
	 * 
	 * @param dMap
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getBasetJsonData(Map dMap) {
		StringBuffer data = new StringBuffer();
		if (dMap != null) {
			JSONObject ja = JSONObject.fromObject(dMap);
			data.append(ja.toString());
		}
		return data.toString();

	}

	public static String formatDateTime(String dTime) {
		String dateTime = "";
		if (dTime != null && !"".equals(dTime)
				&& !dTime.startsWith("1900-01-01")) {
			Timestamp t = Timestamp.valueOf(dTime);
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm");
			dateTime = formatter.format(t);
		}
		return dateTime;
	}

	/**
	 * 用简单的JSONArray数据转为Map
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonArrayToMap(JSONArray jsonArray) {
		List<Map<String, Object>> mapListJson = (List<Map<String, Object>>) jsonArray;
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < mapListJson.size(); i++) {
			Map<String, Object> obj = mapListJson.get(i);
			for (Entry<String, Object> entry : obj.entrySet()) {
				String strkey1 = entry.getKey();
				Object strval1 = entry.getValue();
				map.put(strkey1, strval1);
			}
		}
		return map;
	}

	/**
	 * UTF-8编码 转换为对应的 汉字
	 * 
	 * URLEncoder.encode("上海", "UTF-8") ---> %E4%B8%8A%E6%B5%B7
	 * URLDecoder.decode("%E4%B8%8A%E6%B5%B7", "UTF-8") --> 上 海
	 * 
	 * convertUTF8ToString("E4B88AE6B5B7") E4B88AE6B5B7 --> 上海
	 * 
	 * @param s
	 * @return
	 */
	public static String convertUTF8ToString(String s) {
		if (s == null || s.equals("")) {
			return null;
		}
		try {
			s = s.toUpperCase();
			int total = s.length() / 2;
			int pos = 0;
			byte[] buffer = new byte[total];
			for (int i = 0; i < total; i++) {
				int start = i * 2;
				buffer[i] = (byte) Integer.parseInt(
						s.substring(start, start + 2), 16);
				pos++;
			}
			return new String(buffer, 0, pos, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("convertUTF8ToString异常:", e);
		}
		return s;
	}

	/**
	 * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名.
	 */
	public static String convertStringToUTF8(String s) {
		if (s == null || s.equals("")) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		try {
			char c;
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (c >= 0 && c <= 255) {
					sb.append(c);
				} else {
					byte[] b;

					b = Character.toString(c).getBytes("utf-8");

					for (int j = 0; j < b.length; j++) {
						int k = b[j];
						if (k < 0)
							k += 256;
						sb.append(Integer.toHexString(k).toUpperCase());
					}
				}
			}
		} catch (Exception e) {
			log.error("convertStringToUTF8异常:", e);
		}
		return sb.toString();
	}
    
	// 只允许字母和数字        
    // String   regEx  =  "[^a-zA-Z0-9]";                      
    // 清除掉所有特殊字符  
	public static String StringFilter(String str) {      
	    String regEx="[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";   
	    Pattern p = Pattern.compile(regEx);      
	    Matcher m = p.matcher(str);      
	    return m.replaceAll("").trim();      
    }      
	
	public static String mobileFilter(String str) { 
		String mob = null;
			if(StringUtil.checkObj(str)){
				if(str.length() >=11){
					mob = str.substring(0,str.length()-(str.substring(3)).length())+"****"+str.substring(7);
				}else{
					mob = str;
				}
			}

	    return mob; 
	}
	
	/**
	 * 判断非空
	 *@param @param obj
	 *@param @return
	 *@return boolean
	 *@throws
	 */
	public static boolean isValid(Object obj){
		if(null == obj || "".equals(obj) || "null" == obj)
		{
			return false;
		}
		return true;
	}
	
	
	/**
	 * 得到文件路径separator
	 * （判断系统是windows还是linux）
	 *@param @return
	 *@return String
	 *@throws
	 */
	public static String getFilePathSplit(){
		String separator = "/";
        if("//".equals(File.separator))
        {
        	//Linux
        	separator = "\\";
        }
        else if("/".equals(File.separator))
        {
        	//windows
        	separator = "/";
        }
        return separator;
	}
	
	/**
	 * 根据 数据字典类型JSON和key 获取 数据字典选项名称
	 *@param @param dictType
	 *@param @param value
	 *@param @return
	 *@return String
	 *@throws
	 */
	public static String decodeDict(JSONArray ja, String value){
		
		String name = "";
		if(StringUtil.isValid(ja))
		{
			
			for(int i = 0; i < ja.size(); i++)
			{
				JSONObject jo = ja.getJSONObject(i);
				if(StringUtil.isValid(value) && value.equals(jo.get("id")))
				{
					name = jo.getString("text");
					break;
				}
			}
		}
		
		return name;
	}
	
	/**
	 * 根据 数据字典类型JSON和名称 获取 数据字典选项key
	 *@param @param ja
	 *@param @param text
	 *@param @return
	 *@return String
	 *@throws
	 */
	public static String encodeText(JSONArray ja, String text){
		
		String id = "";
		if(StringUtil.isValid(ja))
		{
			
			for(int i = 0; i < ja.size(); i++)
			{
				JSONObject jo = ja.getJSONObject(i);
				if(StringUtil.isValid(text) && text.equals(jo.get("text")))
				{
					id = jo.getString("id");
					break;
				}
			}
		}
		
		return id;
	}

	// 过滤特殊字符
	public static String StringFiltero(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;'\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’、？_]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
	
	public static String listToString(List list, String separator) {  
		StringBuilder sb = new StringBuilder();  
		for (int i = 0; i < list.size(); i++) {    
			    sb.append(list.get(i)).append(separator);
			}  
		return sb.toString().substring(0,sb.toString().length()-1);
	}
	
	/**
	 * 将字符串中间的字符更替为“*”
	 * @author Lyndon (2018-01-12)
	 * @param str
	 * @return
	 */
	public static String replaceStr(String str) {
		int length = str.length();
		String newStr = "";
		for(int i = 0; i < length; i++) {
			 char item =  str.charAt(i);  
			 if(i == 0 || i+1 == length) {
				 newStr += item;
			 } else {
				 newStr += "*";
			 }
		}
		return newStr;
	}
	
	public static String getId() {
		// int random_num = (int) ((Math.random() * 9 + 1) * 100000);
		return new Date().getTime() + "";
	}
	
	 /**
     * 获得32个长度的十六进制的UUID
     * @return UUID
     */
    public static String get32UUID(){
        UUID id=UUID.randomUUID();
        String[] idd=id.toString().split("-");
        return idd[0]+idd[1]+idd[2]+idd[3]+idd[4];
    }
    
	// public static void main(String[] args) throws
	// UnsupportedEncodingException {
	// System.out.println(URLEncoder.encode("粤A4545454", "UTF-8"));
    //	System.out.println(">>"+StringFilter("中%……&**国"));
	// }
}

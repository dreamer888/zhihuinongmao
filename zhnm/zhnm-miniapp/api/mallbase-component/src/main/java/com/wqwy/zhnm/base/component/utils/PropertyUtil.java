package com.wqwy.zhnm.base.component.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 
 * @ClassName: PropertyUtil  
 * @Description: PropertyUtil  
 * @author seven  
 * @date 21 May 2018 2:28:53 PM  
 *
 */
public class PropertyUtil {

	private static Properties properties;
	static {
		InputStream inputStream = null;
		try {
			inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream("mallbase-component-var.properties");
			assert (inputStream != null);

			properties = new Properties();
			properties.load(new InputStreamReader(inputStream, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
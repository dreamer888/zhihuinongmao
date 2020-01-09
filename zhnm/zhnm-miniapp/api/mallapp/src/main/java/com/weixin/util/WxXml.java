package com.weixin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

public class WxXml {
	
	public static String getWxXml(HttpServletRequest request) {
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(
					(ServletInputStream) request
							.getInputStream()));

			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
			// sb为微信返回的xml
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
}

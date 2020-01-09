package com.wqwy.zhnm.base.component.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QrURL {

	private String SUCCESS;
	private String QRURL;
	public String getQRURL() {
		return QRURL;
	}
	public void setQRURL(String qRURL) {
		QRURL = qRURL;
	}
	public String getSUCCESS() {
		return SUCCESS;
	}
	public void setSUCCESS(String success) {
		SUCCESS = success;
	}
    
	public static void main(String[] args) {
		String t = "https%3A%2F%2Fibsbjstar.ccb.com.cn%2FCCBIS%2FQR%3FQRCODE%3DCCB9980003071706675141091";
		try {
			String gbk=URLEncoder.encode(t,"GBK");
			System.out.println("-->"+gbk);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

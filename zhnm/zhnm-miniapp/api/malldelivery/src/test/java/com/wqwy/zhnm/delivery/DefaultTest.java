package com.wqwy.zhnm.delivery;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import javax.servlet.ServletException;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.wqwy.zhnm.delivery.controller.AliyunController;

public class DefaultTest {
	
	@Test
	public void t1() {
		String sign = DigestUtils.shaHex("123456");
		System.out.println(sign);
	}
	
	@Test
	public void t2() {
		System.out.println(encryptPassword("123456"));
	}
	
	private static String encryptPassword(String password)
	{
	    String sha1 = "";
	    try
	    {
	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(password.getBytes("UTF-8"));
	        sha1 = byteToHex(crypt.digest());
	    }
	    catch(NoSuchAlgorithmException e)
	    {
	        e.printStackTrace();
	    }
	    catch(UnsupportedEncodingException e)
	    {
	        e.printStackTrace();
	    }
	    return sha1;
	}

	private static String byteToHex(final byte[] hash)
	{
	    Formatter formatter = new Formatter();
	    for (byte b : hash)
	    {
	        formatter.format("%02x", b);
	    }
	    String result = formatter.toString();
	    formatter.close();
	    return result;
	}
	
	@Test
	public void t3() throws ServletException, IOException {
		AliyunController aliyunController = new AliyunController();
		aliyunController.securityToken(null, null);
	}

}

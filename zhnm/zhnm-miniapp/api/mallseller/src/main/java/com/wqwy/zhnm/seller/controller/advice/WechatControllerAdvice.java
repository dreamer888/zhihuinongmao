package com.wqwy.zhnm.seller.controller.advice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wqwy.zhnm.base.component.exception.WechatException;
import com.wqwy.zhnm.base.component.utils.wxpay.WXPayUtil;

@ControllerAdvice
public class WechatControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(WechatControllerAdvice.class);
	
	
	@ExceptionHandler(WechatException.class)
    @ResponseBody
    public String handleWechatException(WechatException ex, HttpServletResponse response) {
		logger.info("handle wechat exception" + ex.getMessage());
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("return_code", "SUCCESS");
		resultMap.put("return_msg", "OK");
		String xmlStr = null;
		try {
			xmlStr = WXPayUtil.mapToXml(resultMap);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return xmlStr;// TODO
    }
	
}

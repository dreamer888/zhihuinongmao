package com.wqwy.zhnm.base.component.utils;

import java.util.Date;

import org.apache.wink.json4j.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wqwy.zhnm.base.component.constant.UMSApiConstants;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderDTO;
import com.wqwy.zhnm.base.component.request.UnionPayQRCodeGenerateRequest;
import com.wqwy.zhnm.base.component.response.UnionPayQRCodeGenerateResponse;
import com.wqwy.zhnm.base.component.response.UnionPayQRCodeGenerateResponseToClient;

public class UMSUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(UMSUtils.class);
	
	//TODO
	private static final String notifyUrl = "";
	private static final String tid = "test_tid";//tid
	
	private static final Long OneMinuteMillSecond = 60000L;

	/**
	 * @throws JSONException 
	 * 
	 * @Title: DoGenerateOfflineQRCode  
	 * @Description: 生成UMSQRcode返回客户端  
	 * @date 11 May 2018 4:10:45 PM  
	 * @param @param booDTO
	 * @param @return  
	 * @return UnionPayQRCodeGenerateResponseToClient  
	 * @throws
	 */
	/*
	 * 1.BalanceOfflineOrderDTO -> UnionPayQRCodeGenerateRequest
	 * 2.UnionPayQRCodeGenerateRequest ---http---> UMS
	 * 3.UMS ---http---> UnionPayQRCodeGenerateResponse
	 * 4.UnionPayQRCodeGenerateResponse -> UnionPayQRCodeGenerateResponseToClient
	 * 
	 * 5.return UnionPayQRCodeGenerateResponseToClient;
	 */
	public static final UnionPayQRCodeGenerateResponseToClient DoGenerateOfflineQRCode(BalanceOfflineOrderDTO booDTO) throws JSONException {
		logger.debug("balanceOfflineOrderDTO: " + booDTO.toString());
		/*
		 * 1
		 */
		UnionPayQRCodeGenerateRequest upqrcgr = ConvertUtils.OfflineOrderToUMSQRCodeGR(booDTO);
		
		
		Date now = new Date();
		upqrcgr.setMsgId(OrderUtils.CreateNumWithSpecialHeader(UMSApiConstants.UMS_MSGID_HEADERSTRING));
		upqrcgr.setMsgSrc(UMSApiConstants.UMS_QRCODE_MSGSRC);
		upqrcgr.setMid(UMSApiConstants.UMS_MID);
		upqrcgr.setTid(tid);
		upqrcgr.setRequestTimestamp(now);
		upqrcgr.setBillDate(now);
		upqrcgr.setExpireTime(new Date(now.getTime() + 30*OneMinuteMillSecond));
		upqrcgr.setBillNo(UnionPayQRCodeUtils.GetQRCodeIdOrBillNo());
		upqrcgr.setNotifyUrl(notifyUrl);
		logger.debug("unionPayQRCodeGenerateRequest toString() before sign: " + upqrcgr.toString());
		
		//最后sign
		upqrcgr.setSign(UnionPayQRCodeUtils.GetSignString(upqrcgr));
		
		/*
		 * 2,3
		 */
		logger.debug("unionPayQRCodeGenerateRequest toString(): " + upqrcgr.toString());
		logger.debug("unionPayQRCodeGenerateRequest as json String: " + JsonUtils.AsJsonString(upqrcgr));
		//TODO 封装数据
		String unionPayQRCodeGenerateResponseString = HttpUtil.postUrl(UMSApiConstants.UMS_QRCODE_GENERATE_URI, JsonUtils.AsJsonString(upqrcgr));
		
		logger.debug("unionPayQRCodeGenerateResponseString: " + unionPayQRCodeGenerateResponseString);
		
		UnionPayQRCodeGenerateResponse upqrcgResponse = (UnionPayQRCodeGenerateResponse) JsonUtils.AsJsonObject(unionPayQRCodeGenerateResponseString, UnionPayQRCodeGenerateResponse.class);
		
		/*
		 * 4,5
		 */
		return ConvertUtils.OfflineOrderToUMSQRCodeGRToClient(upqrcgResponse);
	}
	
}

package com.wqwy.zhnm.base.component.constant;

import com.wqwy.zhnm.base.component.utils.PropertyUtil;

public class UMSApiConstants {

	// 生成qrcode接口uri
	public static final String UMS_QRCODE_GENERATE_URI = PropertyUtil.getProperty("ums.qrcode.generate.uri");
	public static final String UMS_QRCODE_REFRESH_URI = PropertyUtil.getProperty("ums.qrcode.refresh.uri");
	public static final String UMS_QRCODE_CANCEL_URI = PropertyUtil.getProperty("ums.qrcode.cancel.uri");
	
	// 此时billNo需要符合银商规范，以银商分配的4位来源编号（msgSrcId）作为账单号的前4位，且在商户系统中此账单号保证唯一
	public static final String UMS_QRCODE_MSGSRCID = PropertyUtil.getProperty("ums.qrcode.msg_src_id");
	public static final String UMS_QRCODE_MSGSRC = PropertyUtil.getProperty("ums.qrcode.msg_src");
	public static final String UMS_SIGN_KEY = PropertyUtil.getProperty("ums.sign.key");
	public static final String UMS_MID = PropertyUtil.getProperty("ums.mid");
	
	public static final String UMS_MSGID_HEADERSTRING = "UMS_QRG";
	
}

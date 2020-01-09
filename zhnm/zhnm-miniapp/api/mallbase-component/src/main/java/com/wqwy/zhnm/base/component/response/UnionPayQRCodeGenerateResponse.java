package com.wqwy.zhnm.base.component.response;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UnionPayQRCodeGenerateResponse {

//	errCode	平台错误码	String	max = 64	true
//	errMsg	平台错误信息	String	max = 255	false
//	msgId	消息ID，原样返回	String	max = 64	false
//	msgType	消息类型，原样返回	String	false
//	msgSrc	消息来源，原样返回	String	max = 32	true
//	responseTimeStamp	报文应答时间，格式yyyy-MM-dd HH:mm:ss	Date	true
//	srcReserve	请求系统预留字段	String	false
//	mid	商户号，原样返回	String	false
//	tid	终端号，原样返回	String	false
//	instMid	业务类型，原样返回	String	false	QRPAYDEFAULT
//	billNo	账单号，原样返回	String	false
//	billDate	账单日期，原样返回	Date	false
//	billQRCode	账单二维码	String	true	二维码URL
//	systemId	系统ID，原样返回	String	true
//	signType	签名算法	String	false	值为：MD5或 SHA256	；若不上送默认为MD5
//	sign	签名	String	true

	private String errCode;
	private String errMsg;
	private String msgId;
	private String msgType;
	private String msgSrc;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date responseTimeStamp;
	
	private String srcReserve;
	private String mid;
	private String tid;
	private String instMid;
	private String billNo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date billDate;
	
	private String billQRCode;
	private String systemId;
	private String signType;
	private String sign;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMsgSrc() {
		return msgSrc;
	}
	public void setMsgSrc(String msgSrc) {
		this.msgSrc = msgSrc;
	}
	public Date getResponseTimeStamp() {
		return responseTimeStamp;
	}
	public void setResponseTimeStamp(Date responseTimeStamp) {
		this.responseTimeStamp = responseTimeStamp;
	}
	public String getSrcReserve() {
		return srcReserve;
	}
	public void setSrcReserve(String srcReserve) {
		this.srcReserve = srcReserve;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getInstMid() {
		return instMid;
	}
	public void setInstMid(String instMid) {
		this.instMid = instMid;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getBillQRCode() {
		return billQRCode;
	}
	public void setBillQRCode(String billQRCode) {
		this.billQRCode = billQRCode;
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "UnionPayQRCodeGenerateResponse [errCode=" + errCode + ", errMsg=" + errMsg + ", msgId=" + msgId
				+ ", msgType=" + msgType + ", msgSrc=" + msgSrc + ", responseTimeStamp=" + responseTimeStamp
				+ ", srcReserve=" + srcReserve + ", mid=" + mid + ", tid=" + tid + ", instMid=" + instMid + ", billNo="
				+ billNo + ", billDate=" + billDate + ", billQRCode=" + billQRCode + ", systemId=" + systemId
				+ ", signType=" + signType + ", sign=" + sign + "]";
	}

}

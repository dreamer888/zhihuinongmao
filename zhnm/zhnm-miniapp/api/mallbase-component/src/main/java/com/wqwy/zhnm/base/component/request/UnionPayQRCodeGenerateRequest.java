package com.wqwy.zhnm.base.component.request;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wqwy.zhnm.base.component.component.UnionPayQRCodeGenerateRequestGoodsComponent;

/**
 * 
 * @ClassName: UnionPayQRCodeGenerateComponent  
 * @Description: TODO  
 * @author seven  
 * @date 10 May 2018 9:59:37 AM  
 *
 */
/*
{
    "qrCodeId": "10001609223224017146368158",
    "systemId": "3003",
    "msgType": " bills.getQRCode",
    "counterNo": "8888",
    "requestTimestamp": "2016-09-22 16:55:00",
    "billDesc": "BillTesting",
    "msgSrc": "CHINATVPAY",
    "sign": "CC193E1F32F978D1E1445BC903F3B42F",
    "goods": [
        {
            "quantity": "1",
            "goodsId": "0002",
            "price": "100",
            "goodsCategory": "Auto",
            "body": "goods body",
            "goodsName": "Goods Name"
        }
    ],
    "mid": "898310060514001",
    "msgId": "800000000010",
    "billDate": "2016-09-22",
    "tid": "0001",
    "instMid": "QRPAYDEFAULT",
    "totalAmount": "1",
    "notifyUrl": "http://www.baidu.com"
}
 */
@JsonInclude(value = Include.NON_EMPTY)
public class UnionPayQRCodeGenerateRequest {
	
	private static final String DEF_INSTMID = "QRPAYDEFAULT";
	private static final String DEF_MSGTYPE = "bills.getQRCode";
	
	private enum WALLET_OPTION {
		SINGLE, MULTIPLE
	}
	
	private enum SING_TYPE {
		MD5, SHA256
	}

	/**
	 * 消息ID，原样返回
	 */
	private String msgId;//CreateNumWithSpecialHeader
	
	/**
	 * 消息来源
	 * need
	 */
	private String msgSrc;
	
	/**
	 * 消息类型
	 */
	private String msgType = DEF_MSGTYPE;
	
	/**
	 * 报文请求时间，格式yyyy-MM-dd HH:mm:ss
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date requestTimestamp;
	
	/**
	 * 请求系统预留字段
	 */
	private String srcReserve;
	
	/**
	 * 商户号
	 * need
	 */
	private String mid;
	
	/**
	 * 终端号
	 * need
	 */
	private String tid;
	
	/**
	 * 业务类型
	 */
	private String instMid = DEF_INSTMID;
	
	/**
	 * 账单号
	 * need
	 */
	private String billNo;
	
	/**
	 * 账单日期，格式yyyy-MM-dd
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date billDate;
	
	/**
	 * 账单描述
	 */
	private String billDesc;
	
	/**
	 * 支付总金额
	 */
	private Long totalAmount;
	
	/**
	 * 会员号
	 * 
	 * 支付通知里原样返回
	 */
	private String memberId;
	
	/**
	 * 桌号、柜台号、房间号
	 * 
	 * 支付通知里原样返回
	 */
	private String counterNo;
	
	/**
	 * 
	 * （获取的二维码若显示在自助机上等类似业务，该字段为必传）
	 * 账单过期时间，为空则不过期，格式yyyy-MM-dd HH:mm:ss
	 * 
	 * 一次性二维码的默认过期时间为30分钟，固定码无期限
	 */
	private Date expireTime;
	
	/**
	 * 支付结果通知地址
	 * need
	 */
	private String notifyUrl;
	
	/**
	 * 网页跳转地址
	 * need
	 */
	private String returnUrl;
	
	/**
	 * 二维码ID
	 * 
	 * 针对需要自行生成二维码的情况
	 */
	private String qrCodeId;
	
	/**
	 * 系统ID
	 * 系统ID，原样返回
	 */
	private String systemId;
	
	/**
	 * 担保交易标识
	 */
	private String secureTransaction;
	
	/**
	 * 钱包选项
	 */
	private WALLET_OPTION walletOption = WALLET_OPTION.SINGLE;
	
	/**
	 * 签名算法
	 */
	private SING_TYPE signType = SING_TYPE.MD5;
	
	/**
	 * 实名认证姓名
	 */
	private String name;
	
	/**
	 * 实名认证手机号
	 */
	private String mobile;
	
	/**
	 * 实名认证证件类型
	 */
	private String certType;
	
	/**
	 * 实名认证证件号
	 */
	private String certNo;
	
	/**
	 * 是否需要实名认证
	 */
	private String fixBuyer;
	
	/**
	 * 签名
	 * need
	 */
	private String sign;

	/**
	 * 生成QRCode的订单中的订单商品列表
	 */
	private List<UnionPayQRCodeGenerateRequestGoodsComponent> goods;
	
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgSrc() {
		return msgSrc;
	}

	public void setMsgSrc(String msgSrc) {
		this.msgSrc = msgSrc;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Date getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(Date requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
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

	public String getBillDesc() {
		return billDesc;
	}

	public void setBillDesc(String billDesc) {
		this.billDesc = billDesc;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCounterNo() {
		return counterNo;
	}

	public void setCounterNo(String counterNo) {
		this.counterNo = counterNo;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getQrCodeId() {
		return qrCodeId;
	}

	public void setQrCodeId(String qrCodeId) {
		this.qrCodeId = qrCodeId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getSecureTransaction() {
		return secureTransaction;
	}

	public void setSecureTransaction(String secureTransaction) {
		this.secureTransaction = secureTransaction;
	}

	public WALLET_OPTION getWalletOption() {
		return walletOption;
	}

	public void setWalletOption(WALLET_OPTION walletOption) {
		this.walletOption = walletOption;
	}

	public SING_TYPE getSignType() {
		return signType;
	}

	public void setSignType(SING_TYPE signType) {
		this.signType = signType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCertType() {
		return certType;
	}

	public void setCertType(String certType) {
		this.certType = certType;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getFixBuyer() {
		return fixBuyer;
	}

	public void setFixBuyer(String fixBuyer) {
		this.fixBuyer = fixBuyer;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public List<UnionPayQRCodeGenerateRequestGoodsComponent> getGoods() {
		return goods;
	}

	public void setGoods(List<UnionPayQRCodeGenerateRequestGoodsComponent> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "UnionPayQRCodeGenerateRequest [msgId=" + msgId + ", msgSrc=" + msgSrc + ", msgType=" + msgType
				+ ", requestTimestamp=" + requestTimestamp + ", srcReserve=" + srcReserve + ", mid=" + mid + ", tid="
				+ tid + ", instMid=" + instMid + ", billNo=" + billNo + ", billDate=" + billDate + ", billDesc="
				+ billDesc + ", totalAmount=" + totalAmount + ", memberId=" + memberId + ", counterNo=" + counterNo
				+ ", expireTime=" + expireTime + ", notifyUrl=" + notifyUrl + ", returnUrl=" + returnUrl + ", qrCodeId="
				+ qrCodeId + ", systemId=" + systemId + ", secureTransaction=" + secureTransaction + ", walletOption="
				+ walletOption + ", signType=" + signType + ", name=" + name + ", mobile=" + mobile + ", certType="
				+ certType + ", certNo=" + certNo + ", fixBuyer=" + fixBuyer + ", sign=" + sign + ", goods=" + goods
				+ "]";
	}
	
}

package com.wqwy.zhnm.base.service.base;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.wqwy.zhnm.base.component.constant.ConstantsFileProperties;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.constant.WechatApiConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.response.WechatQRCodeGenerateResponse;
import com.wqwy.zhnm.base.component.utils.JsonUtils;
import com.wqwy.zhnm.base.component.utils.wxpay.WXPay;
import com.wqwy.zhnm.base.component.utils.wxpay.WXPayConfigImpl;

@Service
//@ConditionalOnProperty(name = "wechat.pay.enable", havingValue = "true")  // refund 存在定时任务, 当前并不存在单独的定时任务服务, 各个服务都是定时任务的执行者 暂时不支持conditional
public class WechatPayPerformance {

	private static final Logger logger = LoggerFactory.getLogger(WechatPayPerformance.class);
	
	private WXPay wxpay;
	private WXPayConfigImpl config;

	public WechatPayPerformance() throws Exception {
        config = WXPayConfigImpl.getInstance();
        wxpay = new WXPay(config);
    }
	
	/**
     * 扫码支付  下单
     */
    public WechatQRCodeGenerateResponse doUnifiedOrder(String out_trade_no, String total_fee) {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("body", "智慧农贸-生鲜");// 商品简单描述，该字段请按照规范传递，具体请见参数规定 -> 店名-销售商品类目
        data.put("out_trade_no", out_trade_no);// 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。详见商户订单号
        data.put("device_info", "");// 自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
        data.put("fee_type", "CNY");// 符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型
        
        data.put("total_fee", total_fee);// TODO 暂时使用1分钱用来测试"1"
        
//        data.put("total_fee", total_fee);//  	订单总金额，单位为分，详见支付金额
        data.put("spbill_create_ip", ConstantsFileProperties.SERVER_PUBLIC_IP);// APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
        data.put("notify_url", WechatApiConstants.WECHAT_NOTIFYURL);// 异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
        data.put("trade_type", "NATIVE");// JSAPI 公众号支付 NATIVE 扫码支付 APP APP支付 说明详见参数规定
        data.put("product_id", out_trade_no);// trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
        // data.put("time_expire", "20170112104120");

        WechatQRCodeGenerateResponse wqrcgr = null;
        try {
        	logger.info(data.toString());
            Map<String, String> r = wxpay.unifiedOrder(data);
            logger.info(r.toString());
            wqrcgr = (WechatQRCodeGenerateResponse) JsonUtils.AsJsonObject(r, WechatQRCodeGenerateResponse.class);
            return wqrcgr;
        } catch (Exception e) {
        	throw new BusinessException(e.getMessage());
        }
    }
    
    /**
     * 
     * @Title: doRefund  
     * @Description: 用户退款  
     * @date 12 Jun 2018 5:30:35 PM  
     * @param @param out_trade_no
     * @param @param total_fee  
     * @return void  
     * @throws
     */
    /*
     * 与付款不同,退款可考虑近返回成功与否
     */
    public void doRefund(String outTradeNo, String totalFee) {
    	logger.info("do ShopOrder Refund : outTradeNo: " + outTradeNo + " totalFee: " + totalFee);
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", outTradeNo);
        data.put("out_refund_no", outTradeNo);
        data.put("total_fee", totalFee);
        data.put("refund_fee", totalFee);
        data.put("refund_fee_type", "CNY");
        data.put("op_user_id", config.getMchID());
        data.put("notify_url", WechatApiConstants.WECHAT_NOTIFYURL_REFUND);

        try {
            Map<String, String> responseMap = wxpay.refund(data);
            logger.info("do ShopOrder refund response map: " + responseMap);
            String returnCode = responseMap.get("return_code");// 通信标识，非交易标识，交易是否成功需要查看result_code来判断
//    		String returnMsg = responseMap.get("return_msg");
    		String resultCode = responseMap.get("result_code");
            if (!DefaultConstants.SUCCESS.equals(returnCode) || !DefaultConstants.SUCCESS.equals(resultCode)) {
            	throw new BusinessException("responseMap: " + JsonUtils.AsJsonString(responseMap));
            }
        } catch (Exception e) {
        	throw new BusinessException(e.getMessage());
        }
        
        
    }

}

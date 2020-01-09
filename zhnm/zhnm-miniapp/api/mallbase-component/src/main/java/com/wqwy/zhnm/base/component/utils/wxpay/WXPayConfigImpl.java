package com.wqwy.zhnm.base.component.utils.wxpay;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.wqwy.zhnm.base.component.constant.WechatApiConstants;

public class WXPayConfigImpl extends WXPayConfig{

    private static byte[] certData;
    private static WXPayConfigImpl INSTANCE;
    static {
    	InputStream certStream = null;
    	try {
	        certStream = WXPayConfigImpl.class.getClassLoader().getResourceAsStream("wechat/apiclient_cert.p12");
	        assert (certStream != null);
	        
	        certData = IOUtils.toByteArray(certStream);
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		if (certStream != null) {
    			try {
    				certStream.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }

//    private WXPayConfigImpl() throws Exception{
//        File file = new File(Thread.currentThread().getContextClassLoader().getResource("wechat/apiclient_cert.p12").getPath());
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
//    }

    public static WXPayConfigImpl getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl();
                }
            }
        }
        return INSTANCE;
    }

//    AppID(小程序ID) 
//    wxd45f95999d77c04b
//    AppSecret(小程序密钥)
//    f947bcf5c23a5130c1d0cb91d702fc27
    
    public String getAppID() {
    	return WechatApiConstants.PUBLIC_COUNT_ID;
    }

    public String getMchID() {
    	return WechatApiConstants.MCH_ID;
    }

    public String getKey() {
    	return WechatApiConstants.SIGN_KEY;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(certData);
        return certBis;
    }


    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    IWXPayDomain getWXPayDomain() {
        return WXPayDomainSimpleImpl.instance();
    }

    public String getPrimaryDomain() {
        return "api.mch.weixin.qq.com";
    }

    public String getAlternateDomain() {
        return "api2.mch.weixin.qq.com";
    }

    @Override
    public int getReportWorkerNum() {
        return 1;
    }

    @Override
    public int getReportBatchSize() {
        return 2;
    }
}

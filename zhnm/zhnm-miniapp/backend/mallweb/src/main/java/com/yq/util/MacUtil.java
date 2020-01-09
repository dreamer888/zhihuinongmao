package com.yq.util;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.http.util.TextUtils;
import org.dom4j.*;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jfinal.kit.HashKit.toHex;

public class MacUtil {
    public static String getMac(String key, String data) {
        Mac m;
        byte[] secretByte;
        SecretKey macKey;
        String resultMac = "";
        byte[] digest;
        try {
            m = Mac.getInstance("HmacSHA256");
            secretByte = DatatypeConverter.parseBase64Binary(key);
            byte[] dataBytes = data.getBytes("ASCII");
            macKey = new SecretKeySpec(secretByte, "HMACSHA256");
            m.init(macKey);
            digest = m.doFinal(dataBytes);
            resultMac = toHex(digest);
            resultMac = resultMac.toUpperCase();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return resultMac;
    }

    /**
     * 通过商品条码获取商品信息
     *
     * @param gtin 商品条形码
     * @return 返回产地信息
     */
    public static String getProductMadeIn(String gtin) {
        String resultMadeIn = "";
        if (TextUtils.isEmpty(gtin)) return resultMadeIn;
        String gln = "6901234501223";
        String key = "WhDky9cAWoD9E8p5zsLSK3ue27rbiBT9KAdFsNKViEU=";
        String data = "/AAQI/v1/ProductData/gtin/" + gtin + "?targetMarket=156&dataVersion=1.1&clientGln=" + gln;
        String url = "http://api.chinatrace.org" + data + "&mac=" + getMac(key, data);
        String json = sendGet(url);
        if (!TextUtils.isEmpty(json)) {
            Pattern regex = Pattern.compile("<stringAVP name=\"产地\">(.*?)<\\/stringAVP>");
            Matcher regexMatcher = regex.matcher(json);
            if (regexMatcher.find()) {
                String result = regexMatcher.group(1);
                resultMadeIn = result;
            }
        }
        return resultMadeIn;
    }

    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "utf-8"));//防止乱码
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url 发送请求的URL
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        	connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            //in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //TODO 新添加设置，返回编码
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public static void parseXML(String xmlStr) {
        try {
            Document document = DocumentHelper.parseText(xmlStr);
            Element rootElement = document.getRootElement();// 获取根节点
            Element element = rootElement.element("productData");//获取子节点
            System.out.println("element===" + element.getName() + "  " + element.getTextTrim());
            Element element2 = element.element("productDataRecord");//获取子节点
            System.out.println("element2===" + element2.getName() + "  " + element2.getTextTrim());
            Element element3 = element2.element("module");//获取子节点
            System.out.println("element3===" + element3.getName() + "  " + element3.getTextTrim());
            Element element4 = element3.element("TSDBasicProductInformationModuleType");//获取子节点
            System.out.println("element4===" + element4.getName() + "  " + element4.getTextTrim());
            Element element5 = element4.element("avpList");//获取子节点
            System.out.println("element5===" + element5.getName() + "  " + element5.getStringValue());
            Iterator<Node> ite = element5.nodeIterator();
            while (ite.hasNext()) {
                Node nod = ite.next();//打印出子节点名称
                System.out.println("element6===" + nod.getName());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String json = getProductMadeIn("06941858722888");
        System.out.println("json===" + json);
        json = json.substring(0, 3);
        System.out.println("json===" + json);
    }

}

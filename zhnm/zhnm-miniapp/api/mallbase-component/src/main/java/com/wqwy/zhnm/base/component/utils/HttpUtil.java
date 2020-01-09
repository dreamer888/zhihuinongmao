package com.wqwy.zhnm.base.component.utils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.List;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Burning
 * @email wenbao163.good@163.com
 * @date 2016年11月27日下午3:25:45
 *
 */
public class HttpUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	private static CloseableHttpClient httpClient = null;

	//http返回字符串编码格式
	public static final String HTTP_RESPONSE_ENCODE = "UTF-8";
	
    private final static Object syncLock = new Object();
    
    private static final int HTTPCLIENT_MAX_TOTAL = 50;
	private static final int HTTPCLIENT_MAX_ROUTE = 50;
	
	/**
	 * 得到http服务器返回字符串参数
	 * @param url
	 * @return
	 */
	public static String getUrl(String url) {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	
	public static String getUrl(URI url) {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	
	/**
	 * 发送post请求返回字符串
	 * @param url post-URL:
	 * @param postData post的数据
	 * @return 返回post请求响应的数据
	 */
	public static String postUrl(String url, String postData){
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());        
        HttpEntity<String> formEntity = new HttpEntity<String>(postData, headers);

        return restTemplate.postForObject(url, formEntity, String.class);
		
	}
	
	/**
	 * 
	 * @date Sep 26, 2017 5:24:46 PM
	 * @Title: getHttpResponseStringByURL 
	 * @Description: 获取url get请求返回string
	 * @param @param url
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 * @throws
	 */
	public static String getHttpResponseStringByURL(String url) throws Exception {
	    HttpGet getMethod = new HttpGet(url);
	    CloseableHttpClient httpclient = HttpClients.createDefault();
	    CloseableHttpResponse response = null;
	    String responseString = StringUtils.EMPTY;
		response = httpclient.execute(getMethod);
		org.apache.http.HttpEntity entity = response.getEntity();
		responseString = EntityUtils.toString(entity, HTTP_RESPONSE_ENCODE);
    	System.out.println(responseString);
    	return responseString;
	}
	
////	public static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
////    static {
////    	cm.setMaxTotal(maxTotal);
////    	cm.setDefaultMaxPerRoute(maxPerRoute);
////    }
    
    public static CloseableHttpClient getDefaultHttpClient() {
        if (httpClient == null) {
            synchronized (syncLock) {
                if (httpClient == null) {
                    httpClient = createHttpClient(HTTPCLIENT_MAX_TOTAL, HTTPCLIENT_MAX_ROUTE, null);
                }
            }
        }
        return httpClient;
    }
    
	/**
	 * 
	 * @date 31 Oct 2017 5:09:31 PM
	 * @Title: createHttpClient 
	 * @Description: createHttpClient
	 * @param @param maxTotal
	 * @param @param maxPerRoute
	 * @param @param maxRoute
	 * @param @param hostname
	 * @param @param port
	 * @param @return
	 * @return CloseableHttpClient
	 * @throws
	 */
    public static CloseableHttpClient createHttpClient(int maxTotal,
            int maxPerRoute, List<HttpClientMaxRouteHost> hcmrhs) {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory
                .getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory
                .getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder
                .<ConnectionSocketFactory> create().register("http", plainsf)
                .register("https", sslsf).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
                registry);
        cm.setMaxTotal(maxTotal);
        cm.setDefaultMaxPerRoute(maxPerRoute);
        if (hcmrhs != null && hcmrhs.size() > 0)
	        for (HttpClientMaxRouteHost hcmrh : hcmrhs) {
	        	HttpHost httpHost = new HttpHost(hcmrh.hostname, hcmrh.port);
	        	cm.setMaxPerRoute(new HttpRoute(httpHost), hcmrh.maxRoute);
	        }

        // 请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception,
                    int executionCount, HttpContext context) {
            	logger.info("请求重试处理");
                if (executionCount >= 5) {// 如果已经重试了5次，就放弃
                    return false;
                }
                if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
                    return true;
                }
                if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
                    return false;
                }
                if (exception instanceof InterruptedIOException) {// 超时
                    return false;
                }
                if (exception instanceof UnknownHostException) {// 目标服务器不可达
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
                    return false;
                }
                if (exception instanceof SSLException) {// SSL握手异常
                    return false;
                }

                HttpClientContext clientContext = HttpClientContext
                        .adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setRetryHandler(httpRequestRetryHandler).build();

        return httpClient;
    }
    
    /*
     * 参数用于构造 PoolingHttpClientConnectionManager
     */
    public class HttpClientMaxRouteHost{
    	//目标hostname port 最大连接数量
    	String hostname;
    	int port;
    	int maxRoute;
		public String getHostname() {
			return hostname;
		}
		public void setHostname(String hostname) {
			this.hostname = hostname;
		}
		public int getPort() {
			return port;
		}
		public void setPort(int port) {
			this.port = port;
		}
		public int getMaxRoute() {
			return maxRoute;
		}
		public void setMaxRoute(int maxRoute) {
			this.maxRoute = maxRoute;
		}
    }
    
}

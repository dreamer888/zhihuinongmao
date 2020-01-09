package com.wqwy.zhnm.base.component.utils;

import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wqwy.zhnm.base.component.constant.GeodeApiConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.request.GeoGetLocationByAddressStringRequest;
import com.wqwy.zhnm.base.component.request.GeodeYuntuDatasearchAroundRequest;
import com.wqwy.zhnm.base.component.response.GeoGetLocationByAddressStringResponse;
import com.wqwy.zhnm.base.component.response.GeoGetLocationByAddressStringResponseComponent;
import com.wqwy.zhnm.base.component.response.GeodeYuntuDatasearchAroundResponse;

public class GeoDeUtils {

	private static final Logger logger = LoggerFactory.getLogger(GeoDeUtils.class);

	/*
	 * 返回的地理位置信息为 经度,纬度 若返回多个地址，仅显示第一个!
	 */
	public static GeoGetLocationByAddressStringResponseComponent getLocationByAddressByGeoMap(String address) throws Exception {
		GeoGetLocationByAddressStringRequest gglbasRequest = new GeoGetLocationByAddressStringRequest();
		gglbasRequest.setAddress(address);
		return getLocationByAddressByGeoMap(gglbasRequest);
	}
	
	public static GeoGetLocationByAddressStringResponseComponent getLocationByAddressByGeoMap(GeoGetLocationByAddressStringRequest gglbasRequest)
			throws Exception {
		logger.info("getLocationByAddressByGeoMap: request=" + gglbasRequest);
		assert(StringUtils.isNotEmpty(gglbasRequest.getAddress()));
//		URIBuilder builder = new URIBuilder();
//		builder.setCharset(StandardCharsets.UTF_8);
//		builder.setScheme("http").setHost(ThirdPartApiConstants.GEO_GET_LOCATION_URL_PREFIX)
//		    .setParameter("key", ConstantsFileProperties.GEODE_WEB_KEY_USER)
//		    .setParameter("address", gglbasRequest.getAddress().trim());
//		if (StringUtils.isNotEmpty(gglbasRequest.getCity()))
//			builder.setParameter("city", gglbasRequest.getCity());
//		URI uri = builder.build();
		
		String uri = "http://restapi.amap.com/v3/geocode/geo?key="+GeodeApiConstants.GEODE_WEB_KEY_USER+"&address="+gglbasRequest.getAddress();
		if (StringUtils.isNotEmpty(gglbasRequest.getCity()))
			uri += "&city="+gglbasRequest.getCity();
		
		logger.info("uri: " + uri);
		String response = HttpUtil.getUrl(uri);
		logger.info(response);
		GeoGetLocationByAddressStringResponse gglbasr = (GeoGetLocationByAddressStringResponse) JsonUtils
				.AsJsonObject(response, GeoGetLocationByAddressStringResponse.class);
		if (Integer.valueOf(gglbasr.getCount()) == 0)
			throw new BusinessException(ResultUtils.RECEIVE_LOCATION_NOT_INVALID, ResultUtils.RECEIVE_LOCATION_NOT_INVALID_MSG);
		return gglbasr.getGeocodes().get(0);
	}
	
	public static GeodeYuntuDatasearchAroundResponse getDatasearchAroundResponse(GeodeYuntuDatasearchAroundRequest gydar) throws Exception{
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost(GeodeApiConstants.GEO_YUNTU_DATASEARCH_AROUND_URI_PREFIX)
		    .setParameter("key", gydar.getKey())
		    .setParameter("tableid", gydar.getTableId())
		    .setParameter("radius", gydar.getRadius())
		    .setParameter("center", gydar.getCenter());
		URI uri = builder.build();
	    HttpGet getMethod = new HttpGet(uri);
	    logger.info("uri: " + uri.toString());

	    CloseableHttpClient httpclient = HttpUtil.getDefaultHttpClient();
	    CloseableHttpResponse response = null;

	    response = httpclient.execute(getMethod);
	    HttpEntity entity = response.getEntity();
    	String responseString = EntityUtils.toString(entity, "UTF-8");
    	
    	GeodeYuntuDatasearchAroundResponse ydaResponse = (GeodeYuntuDatasearchAroundResponse) JsonUtils.AsJsonObject(responseString, GeodeYuntuDatasearchAroundResponse.class);
    	return ydaResponse;
	}

}

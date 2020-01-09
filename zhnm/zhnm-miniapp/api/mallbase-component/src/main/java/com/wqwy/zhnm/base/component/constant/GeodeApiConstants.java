package com.wqwy.zhnm.base.component.constant;

import com.wqwy.zhnm.base.component.utils.PropertyUtil;

/**
 * 
 * @ClassName: ThirdPartApiConstants  
 * @Description: thirdPart api constants define  
 * @author seven  
 * @date 21 May 2018 2:33:11 PM  
 *
 */
public class GeodeApiConstants {

	/**
	 * about geode api
	 * 
	 * http://lbs.amap.com/api/
	 */
	public static final String GEODE_WEB_KEY_USER = PropertyUtil.getProperty("geode.web.key.user");
	public static final String GEO_GET_LOCATION_URL_PREFIX = "http://restapi.amap.com/v3/geocode/geo";
	public static final String GEO_RESPONSE_FORMAT = "JSON";
	public static final String GEO_YUNTU_DATASEARCH_AROUND_URI_PREFIX = "yuntuapi.amap.com/datasearch/around";
	public static final String GEO_YUNTU_AROUNDSEARCH_RADIUS = "3000";
	
	public static final String GEODE_WEB_MARKET_TABLEID = PropertyUtil.getProperty("geode.web.market.table-id");
	
}

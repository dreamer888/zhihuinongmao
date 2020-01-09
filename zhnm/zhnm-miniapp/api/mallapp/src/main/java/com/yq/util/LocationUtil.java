package com.yq.util;

import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wqwy.zhnm.base.component.request.GeoGetLocationByAddressStringRequest;
import com.wqwy.zhnm.base.component.utils.GeoDeUtils;
import com.wqwy.zhnm.base.component.utils.StringUtil;
import com.wqwy.zhnm.base.service.base.AboutOrderService;

public class LocationUtil {
	private static final Logger logger = LoggerFactory.getLogger(AboutOrderService.class);
	
	public static boolean isLocation(String addrCity,String address) {
		GeoGetLocationByAddressStringRequest gglbasRequest = new GeoGetLocationByAddressStringRequest();
		gglbasRequest.setAddress(address.trim());
		boolean flag = false;
		String location = null;
		try {
			location = GeoDeUtils.getLocationByAddressByGeoMap(gglbasRequest).getLocation();
			if(!StringUtil.isValid(location)){
				flag = true;
			}
			logger.info("提交地理位置坐标: ");
			logger.info("city: " + gglbasRequest.getCity());
			logger.info("address: " + gglbasRequest.getAddress());
			logger.info("location: " + location);
		} catch (Exception e1) {
			flag = true;
		}
		return flag;
	}
	
	//港华兴工业区
	public static void main(String[] args) {
		isLocation("江西省 南昌市 青山湖区", "红谷滩新区庐山中大道555号财大购物广场");
		
	}
}

package com.wqwy.zhnm.seller;

import org.junit.Test;

import com.wqwy.zhnm.base.component.request.GeoGetLocationByAddressStringRequest;
import com.wqwy.zhnm.base.component.request.GeodeYuntuDatasearchAroundRequest;
import com.wqwy.zhnm.base.component.utils.GeoDeUtils;
import com.wqwy.zhnm.base.component.utils.JsonUtils;

public class GeoTest {

	@Test
	public void t1() throws Exception {
		System.out.println(GeoDeUtils.getLocationByAddressByGeoMap("玄武湖街道板仓街世界之窗产业园太阳宫1052号"));
	}
	
	@Test
	public void t2() throws Exception {
		GeoGetLocationByAddressStringRequest gglbasRequest = new GeoGetLocationByAddressStringRequest();
		gglbasRequest.setAddress("165165161");
		gglbasRequest.setCity("南京市");
		System.out.println(GeoDeUtils.getLocationByAddressByGeoMap(gglbasRequest));
	}
	
	@Test
	public void t3() throws Exception {
		GeodeYuntuDatasearchAroundRequest gydar = new GeodeYuntuDatasearchAroundRequest();
//		gydar.setCenter("113.80589,22.680105");
		gydar.setCenter("113.807239,22.672963");
		System.out.println(JsonUtils.AsJsonString(GeoDeUtils.getDatasearchAroundResponse(gydar)));
	}
}

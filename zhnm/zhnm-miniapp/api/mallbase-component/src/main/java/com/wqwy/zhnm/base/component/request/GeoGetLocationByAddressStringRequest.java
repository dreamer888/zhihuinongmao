package com.wqwy.zhnm.base.component.request;

import com.wqwy.zhnm.base.component.constant.GeodeApiConstants;

/**
 * 
 * @ClassName: GeoGetLocationByAddressStringRequest  
 * @Description: http://lbs.amap.com/api/webservice/guide/api/georegeo/  
 * @author seven  
 * @date 21 May 2018 3:03:12 PM  
 *
 */
public class GeoGetLocationByAddressStringRequest {

	private String key;
	
	private String address;
	
	private String city;
	
	private String output;
	/*
	 * 其余参数参考文档
	 */

	public GeoGetLocationByAddressStringRequest() {
		super();
		this.output = GeodeApiConstants.GEO_RESPONSE_FORMAT;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	@Override
	public String toString() {
		return "GeoGetLocationByAddressStringRequest [key=" + key + ", address=" + address + ", city=" + city
				+ ", output=" + output + "]";
	}
	
}

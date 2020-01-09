package com.wqwy.zhnm.base.component.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @ClassName: GeoGetLocationByAddressStringResponse  
 * @Description: http://lbs.amap.com/api/webservice/guide/api/georegeo/  
 * @author seven  
 * @date 21 May 2018 3:07:58 PM  
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoGetLocationByAddressStringResponse {

//	 "status" : "1",
//	 "info" : "OK",
//	 "infocode" : "10000",
//	 "count" : "1",
//	 "geocodes" :
	private String status;
	
	private String info;
	
	@JsonProperty("infocode")
	private String infoCode;
	
	private String count;
	
	@JsonProperty("geocodes")
	private List<GeoGetLocationByAddressStringResponseComponent> geocodes;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfoCode() {
		return infoCode;
	}

	public void setInfoCode(String infoCode) {
		this.infoCode = infoCode;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<GeoGetLocationByAddressStringResponseComponent> getGeocodes() {
		return geocodes;
	}

	public void setGeocodes(List<GeoGetLocationByAddressStringResponseComponent> geocodes) {
		this.geocodes = geocodes;
	}
	
}

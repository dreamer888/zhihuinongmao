package com.wqwy.zhnm.base.component.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoGetLocationByAddressStringResponseComponent {

//	{
//	    "formatted_address": "广东省深圳市南山区机会", 
//	    "province": "广东省", 
//	    "citycode": "0755", 
//	    "city": "深圳市", 
//	    "district": "南山区", 
//	    "township": [ ], 
//	    "neighborhood": {
//	        "name": [ ], 
//	        "type": [ ]
//	    }, 
//	    "building": {
//	        "name": [ ], 
//	        "type": [ ]
//	    }, 
//	    "adcode": "440305", 
//	    "street": [ ], 
//	    "number": [ ], 
//	    "location": "113.935333,22.540406", 
//	    "level": "兴趣点"
//	}
	
	@JsonProperty("formatted_address")
	private String formattedAddress;
	
	private String province;
	
	@JsonProperty("citycode")
	private String cityCode;
	
	private String city;
	
	private String district;
	
	private String location;

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "GeoGetLocationByAddressStringResponseComponent [formattedAddress=" + formattedAddress + ", province="
				+ province + ", cityCode=" + cityCode + ", city=" + city + ", district=" + district + ", location="
				+ location + "]";
	}
	
}

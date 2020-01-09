package com.wqwy.zhnm.base.component.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @ClassName: YuntuDatasearchAroundResponseLocationComponent
 * @Description: TODO
 * @author seven
 * @date Sep 25, 2017 3:39:36 PM
 * @Detail http://lbs.amap.com/api/yuntu/reference/cloudsearch
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeodeYuntuDatasearchAroundResponseLocationComponent {
	
	private String _id;
	
	private String _name;
	
	private String _location;
	
	private String _address;
	
	private String _distance;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_location() {
		return _location;
	}

	public void set_location(String _location) {
		this._location = _location;
	}

	public String get_address() {
		return _address;
	}

	public void set_address(String _address) {
		this._address = _address;
	}

	public String get_distance() {
		return _distance;
	}

	public void set_distance(String _distance) {
		this._distance = _distance;
	}

}

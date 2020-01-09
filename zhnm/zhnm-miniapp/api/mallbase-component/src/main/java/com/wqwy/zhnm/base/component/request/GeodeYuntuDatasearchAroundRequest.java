package com.wqwy.zhnm.base.component.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wqwy.zhnm.base.component.constant.ConstantsFileProperties;
import com.wqwy.zhnm.base.component.constant.GeodeApiConstants;

/**
 * 
 * @ClassName: YuntuDatasearchAroundRequest
 * @Description: TODO
 * @author seven
 * @date Sep 25, 2017 3:44:06 PM
 * @Detail http://lbs.amap.com/api/yuntu/reference/cloudsearch
 */
public class GeodeYuntuDatasearchAroundRequest {
	
	private String key;
	
	@JsonProperty("table_id")
	private String tableId;
	
	//中心点坐标规则：经度和纬度用","分割 经纬度小数点后不得超过6位。
	private String center;
	
	//查询半径 规则：取值范围[0,50000]，单位：米。若超出取值范围按默认值
	private String radius;
	
	private String keywords;
	
	@JsonProperty("sortrule")
	private String sortRule;

	public GeodeYuntuDatasearchAroundRequest() {
		super();
		this.key = GeodeApiConstants.GEODE_WEB_KEY_USER;
		this.tableId = GeodeApiConstants.GEODE_WEB_MARKET_TABLEID;
		this.radius = GeodeApiConstants.GEO_YUNTU_AROUNDSEARCH_RADIUS;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getSortRule() {
		return sortRule;
	}

	public void setSortRule(String sortRule) {
		this.sortRule = sortRule;
	}

}

package com.wqwy.zhnm.base.component.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @ClassName: YuntuDatasearchAroundResponse
 * @Description: 云图数据检索 范围检索 返回值信息
 * @author seven
 * @date Sep 25, 2017 3:27:19 PM
 * @Detail http://lbs.amap.com/api/yuntu/reference/cloudsearch
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeodeYuntuDatasearchAroundResponse {
	
	private Integer status;
	
	private String count;
	
	private String info;
	
	private String infocode;
	
	private List<GeodeYuntuDatasearchAroundResponseLocationComponent> datas;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public List<GeodeYuntuDatasearchAroundResponseLocationComponent> getDatas() {
		return datas;
	}

	public void setDatas(List<GeodeYuntuDatasearchAroundResponseLocationComponent> datas) {
		this.datas = datas;
	}

}

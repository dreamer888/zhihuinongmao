package com.wqwy.zhnm.base.component.component;

import java.math.BigDecimal;
import java.util.List;

import com.wqwy.zhnm.base.component.dto.DelivererCostView;

public class DelivererCostViewComponent {

	private BigDecimal totalPrice;
	
	private Integer totalCount;
	
	private List<DelivererCostView> dcvList;

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<DelivererCostView> getDcvList() {
		return dcvList;
	}

	public void setDcvList(List<DelivererCostView> dcvList) {
		this.dcvList = dcvList;
	}
	
}

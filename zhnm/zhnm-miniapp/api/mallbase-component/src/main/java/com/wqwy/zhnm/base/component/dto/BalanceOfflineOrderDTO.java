package com.wqwy.zhnm.base.component.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrder;
import com.wqwy.zhnm.base.entity.BalanceOfflineOrderGoods;

//@JsonInclude(value = Include.NON_EMPTY)
public class BalanceOfflineOrderDTO extends BalanceOfflineOrder{
	
	/**
     * 订单下当前商品的总价格
     */
    private BigDecimal currentGoodsTotalPrice;

	private List<BalanceOfflineOrderGoodsDTO> boogList;

	public BigDecimal getCurrentGoodsTotalPrice() {
		return currentGoodsTotalPrice;
	}

	public void setCurrentGoodsTotalPrice(BigDecimal currentGoodsTotalPrice) {
		this.currentGoodsTotalPrice = currentGoodsTotalPrice;
	}

	public List<BalanceOfflineOrderGoodsDTO> getBoogList() {
		return boogList;
	}

	public void setBoogList(List<BalanceOfflineOrderGoodsDTO> boogList) {
		this.boogList = boogList;
	}

	@Override
	public String toString() {
		return "BalanceOfflineOrderDTO [boogList=" + boogList + ", getId()=" + getId() + ", getBalanceId()="
				+ getBalanceId() + ", getAddtime()=" + getAddtime() + ", getTotalPrice()=" + getTotalPrice()
				+ ", getPayWay()=" + getPayWay() + ", getStatus()=" + getStatus() + ", getRemark()=" + getRemark()
				+ ", getSellerId()=" + getSellerId() + ", getOrderNumber()=" + getOrderNumber() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}

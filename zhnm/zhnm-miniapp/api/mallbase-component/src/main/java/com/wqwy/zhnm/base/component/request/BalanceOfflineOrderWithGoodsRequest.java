package com.wqwy.zhnm.base.component.request;

import java.util.List;

import com.wqwy.zhnm.base.component.component.BalanceOfflineOrderGoodsComponent;

/**
 * 
 * @ClassName: BalanceOfflineOrderWithGoodsRequest  
 * @Description: 称线下订单请求组件  
 * @author seven  
 * @date 10 May 2018 5:41:37 PM  
 *
 */
public class BalanceOfflineOrderWithGoodsRequest {

	private String sellerId;
	
	private String balanceId;
	
	private String payWay;
	
	private List<BalanceOfflineOrderGoodsComponent> boogcList;

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(String balanceId) {
		this.balanceId = balanceId;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public List<BalanceOfflineOrderGoodsComponent> getBoogcList() {
		return boogcList;
	}

	public void setBoogcList(List<BalanceOfflineOrderGoodsComponent> boogcList) {
		this.boogcList = boogcList;
	}

	@Override
	public String toString() {
		return "BalanceOfflineOrderWithGoodsRequest [sellerId=" + sellerId + ", balanceId=" + balanceId + ", payWay="
				+ payWay + ", boogcList=" + boogcList + "]";
	}
	
}

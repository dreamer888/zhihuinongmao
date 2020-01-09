package com.wqwy.zhnm.base.component.response;

import java.util.List;

import com.wqwy.zhnm.base.component.component.SellerCategoryNameComponent;
import com.wqwy.zhnm.base.component.component.SellerGoodsComponent;
import com.wqwy.zhnm.base.entity.Balance;
import com.wqwy.zhnm.base.entity.SellerDynamic;

public class SellerDetailResponse {
	
	private SellerCategoryNameComponent seller;
	
	private SellerDynamic sellerDynamic;
	
	private Balance balance;
	
	private List<SellerGoodsComponent> sellerGoodsList;

	private Integer payWay; 
	
	public Integer getPayWay() {
		return payWay;
	}

	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}

	public SellerCategoryNameComponent getSeller() {
		return seller;
	}

	public void setSeller(SellerCategoryNameComponent seller) {
		this.seller = seller;
	}

	public SellerDynamic getSellerDynamic() {
		return sellerDynamic;
	}

	public void setSellerDynamic(SellerDynamic sellerDynamic) {
		this.sellerDynamic = sellerDynamic;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public List<SellerGoodsComponent> getSellerGoodsList() {
		return sellerGoodsList;
	}

	public void setSellerGoodsList(List<SellerGoodsComponent> sellerGoodsList) {
		this.sellerGoodsList = sellerGoodsList;
	}

}

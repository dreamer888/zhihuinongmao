package com.wqwy.zhnm.base.component.component;

import java.util.List;

import com.wqwy.zhnm.base.component.dto.ShopOrderDetailPrintDTO;
import com.wqwy.zhnm.base.component.dto.ShopOrderPrintDTO;

public class ShopOrderPrintComponent extends ShopOrderPrintDTO{
	
	 /**
     * 商户ID
     */
    private Integer sellerId;
    
	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	private List<ShopOrderDetailPrintDTO> orderDetailPrintDTOs;

	public List<ShopOrderDetailPrintDTO> getOrderDetailPrintDTOs() {
		return orderDetailPrintDTOs;
	}

	public void setOrderDetailPrintDTOs(List<ShopOrderDetailPrintDTO> orderDetailPrintDTOs) {
		this.orderDetailPrintDTOs = orderDetailPrintDTOs;
	}

	
}

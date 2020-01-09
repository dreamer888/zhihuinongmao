package com.wqwy.zhnm.base.component.response;

import com.wqwy.zhnm.base.entity.Deliverer;
import com.wqwy.zhnm.base.entity.DelivererDynamic;

public class DelivererDetailResponse {

	private Deliverer deliverer;
	
	private DelivererDynamic delivererDynamic;

	public Deliverer getDeliverer() {
		return deliverer;
	}

	public void setDeliverer(Deliverer deliverer) {
		this.deliverer = deliverer;
	}

	public DelivererDynamic getDelivererDynamic() {
		return delivererDynamic;
	}

	public void setDelivererDynamic(DelivererDynamic delivererDynamic) {
		this.delivererDynamic = delivererDynamic;
	}
	
}

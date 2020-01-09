package com.wqwy.zhnm.base.component.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.wqwy.zhnm.base.component.component.UnionPayQRCodeGenerateRequestGoodsComponent;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderDTO;
import com.wqwy.zhnm.base.component.dto.BalanceOfflineOrderGoodsDTO;
import com.wqwy.zhnm.base.component.request.UnionPayQRCodeGenerateRequest;
import com.wqwy.zhnm.base.component.response.UnionPayQRCodeGenerateResponse;
import com.wqwy.zhnm.base.component.response.UnionPayQRCodeGenerateResponseToClient;
import com.wqwy.zhnm.base.component.response.WechatQRCodeGenerateResponse;
import com.wqwy.zhnm.base.component.response.WechatQRCodeGenerateResponseToClient;

public class ConvertUtils {

	/**
	 * 
	 * @Title: OfflineOrderToUMSQRCodeGR  
	 * @Description: 线下订单封装到request  
	 * @date 11 May 2018 6:41:33 PM  
	 * @param @param balanceOfflineOrderDTO
	 * @param @return  
	 * @return UnionPayQRCodeGenerateRequest  
	 * @throws
	 */
	/*
	 * 仅封装 订单总价 订单商品列表
	 */
	public static final UnionPayQRCodeGenerateRequest OfflineOrderToUMSQRCodeGR(
			BalanceOfflineOrderDTO balanceOfflineOrderDTO) {
		UnionPayQRCodeGenerateRequest u = new UnionPayQRCodeGenerateRequest();
		
		//总价
		u.setTotalAmount(DoubleMoneyUnitYuanToLongMoneyUnitFen(balanceOfflineOrderDTO.getTotalPrice()));
		
		//商品信息
		List<BalanceOfflineOrderGoodsDTO> boogList = balanceOfflineOrderDTO.getBoogList();
		List<UnionPayQRCodeGenerateRequestGoodsComponent> upqrcgrgcList = new ArrayList<UnionPayQRCodeGenerateRequestGoodsComponent>();
		boogList.forEach(b -> {
			UnionPayQRCodeGenerateRequestGoodsComponent uc = new UnionPayQRCodeGenerateRequestGoodsComponent();
			uc.setGoodsId(b.getGoodsId().toString());
			uc.setGoodsName(b.getGoodsName());
			uc.setPrice(DoubleMoneyUnitYuanToLongMoneyUnitFen(b.getPayTotal()).toString());
			uc.setQuantity(DoubleMoneyUnitYuanToLongMoneyUnitFen(b.getGoodsCount()).toString());
			upqrcgrgcList.add(uc);
		});
		u.setGoods(upqrcgrgcList);
		
		return u;
	}

	/**
	 * 
	 * @Title: OfflineOrderToUMSQRCodeGRToClient  
	 * @Description: 封装返回值给到client
	 * @date 11 May 2018 6:43:17 PM  
	 * @param @param unionPayQRCodeGenerateResponse
	 * @param @return  
	 * @return UnionPayQRCodeGenerateResponseToClient  
	 * @throws
	 */
	public static final UnionPayQRCodeGenerateResponseToClient OfflineOrderToUMSQRCodeGRToClient(
			UnionPayQRCodeGenerateResponse unionPayQRCodeGenerateResponse) {
		UnionPayQRCodeGenerateResponseToClient u = new UnionPayQRCodeGenerateResponseToClient();
		BeanUtils.copyProperties(unionPayQRCodeGenerateResponse, u);
		return u;
	}
	
	public static final WechatQRCodeGenerateResponseToClient OfflineOrderToWechatQRCodeGRToClient (WechatQRCodeGenerateResponse wechatQRCodeGenerateResponse,Integer orderId,String orderNumber) {
		WechatQRCodeGenerateResponseToClient w = new WechatQRCodeGenerateResponseToClient();
		w.setUrl(DefaultConstants.BALANCEPRINTORDERURL+orderId);
		w.setTelephone(DefaultConstants.TELEPHONE);
		w.setCompany(DefaultConstants.COMPANY);
		w.setOrderNumber(orderNumber);
		BeanUtils.copyProperties(wechatQRCodeGenerateResponse, w);
		return w;
	}
	
	public static final Long DoubleMoneyUnitYuanToLongMoneyUnitFen(BigDecimal d) {
		return DoubleMoneyUnitYuanToLongMoneyUnitFen(d.doubleValue());
	}
	
	public static final Long DoubleMoneyUnitYuanToLongMoneyUnitFen(Double d) {
		return ((Double) (d*100)).longValue();
	}

}

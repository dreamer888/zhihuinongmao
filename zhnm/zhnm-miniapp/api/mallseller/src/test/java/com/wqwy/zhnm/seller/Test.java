package com.wqwy.zhnm.seller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wqwy.zhnm.base.component.dto.ShopOrderDetailDTO;

import net.sf.json.JSONArray;

public class Test {
    public static void main(String[] args) {
    	
    
    	List<ShopOrderDetailDTO> shopOrderDetailDTOList = new ArrayList<>();
    	ShopOrderDetailDTO shopOrderDetailDTO = new ShopOrderDetailDTO();
    	shopOrderDetailDTO.setGoodsId(42);
    	shopOrderDetailDTO.setGoodsName("菜心");
    	shopOrderDetailDTO.setPreSellerId(113);
    	shopOrderDetailDTOList.add(shopOrderDetailDTO);
    	
    	ShopOrderDetailDTO shopOrderDetailDTO2 = new ShopOrderDetailDTO();
    	shopOrderDetailDTO2.setGoodsId(42);
    	shopOrderDetailDTO2.setGoodsName("上海青");
    	shopOrderDetailDTO2.setPreSellerId(130);
    	shopOrderDetailDTOList.add(shopOrderDetailDTO2);
    	
    	shopOrderDetailDTOList.stream().collect(Collectors.groupingBy(ShopOrderDetailDTO::getPreSellerId))
		.forEach((key, value) -> {
			System.out.println("doSendOrderGoodsMessageToMQSellerQueue-->key:"+key);
			System.out.println("doSendOrderGoodsMessageToMQSellerQueue-->value:"+JSONArray.fromObject(value));
		});
	}
}

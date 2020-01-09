package com.wqwy.zhnm.seller.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.wqwy.zhnm.base.component.dto.ShopCategoryLevelOneDTO;
import com.wqwy.zhnm.base.service.ShopCategoryService;

@Service
public class SellerJobAfterContextRefreshedService implements ApplicationListener<ContextRefreshedEvent>{
	
	private static final Logger logger = LoggerFactory.getLogger(SellerJobAfterContextRefreshedService.class);

	@Autowired
	private ShopCategoryService shopCategoryService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("mallseller do onApplicationEvent... ");
		getShopCategoryLevelImmediately();
	}
	
	/**
	 * @deprecated 
	 * 暂时将shopCategory放入项目内存
	 * 待移除, 后期可考虑放入缓存
	 * TODO
	 */
	@Deprecated
	private List<ShopCategoryLevelOneDTO> scloDTOList;

	public List<ShopCategoryLevelOneDTO> getShopCategoryLevelImmediately() {
		this.scloDTOList = shopCategoryService.findAllShopCategoriesWithLevel();
		return this.scloDTOList;
	}
	
	public List<ShopCategoryLevelOneDTO> getScloDTOList() {
		return scloDTOList;
	}

}

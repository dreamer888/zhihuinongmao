/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.dto.ShopCategoryLevelOneDTO;
import com.wqwy.zhnm.base.dao.ShopCategoryMapper;
import com.wqwy.zhnm.base.entity.ShopCategory;

/**
 * createTime: 2018-05-09 11:52:14
 * @author seven
 * @version
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    private static final Logger logger = LoggerFactory.getLogger(ShopCategoryServiceImpl.class);

    @Override
    public ShopCategory get(String categoryId) {
        return shopCategoryMapper.get(categoryId);
    }

    @Override
    public List<ShopCategory> findList(ShopCategory shopCategory) {
        return shopCategoryMapper.findList(shopCategory);
    }

    @Override
    public Page<ShopCategory> findListByPage(ShopCategory shopCategory, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return shopCategoryMapper.findListByPage(shopCategory);
    }

    @Override
    public Integer insert(ShopCategory shopCategory) {
//        shopCategory.setCreateTime(new Date());
        return shopCategoryMapper.insert(shopCategory);
    }

    @Override
    public Integer update(ShopCategory shopCategory) {
//        shopCategory.setUpdateTime(new Date());
        return shopCategoryMapper.update(shopCategory);
    }

    @Override
    public Integer delete(String categoryId) {
        return shopCategoryMapper.delete(categoryId);
    }

	@Override
	public List<ShopCategoryLevelOneDTO> findAllShopCategoriesWithLevel() {
		List<ShopCategory> shopCategoryList = shopCategoryMapper.findList(null);
		/*
		 * shopCategory仅可能为2级e.g.:(蔬菜->萝卜 ->具体商品)
		 * 1.获取top level, top level默认parentId="0" :(
		 * 2.按照parentId和category_id对应关系组合
		 * 3.按照sort排序
		 */
//		List<ShopCategory> scList = new ArrayList<ShopCategory>();
		
		Map<String, List<ShopCategory>> scMap = shopCategoryList.stream()
				.filter(c -> !DefaultConstants.ZERO_INTEGER.toString().equals(c.getSuperId()))
				.sorted((c1, c2) -> Integer.compare(c1.getSort(), c2.getSort()))
				.collect(Collectors.groupingBy(ShopCategory::getSuperId));
		return shopCategoryList.stream()
				.filter(c -> DefaultConstants.ZERO_INTEGER.toString().equals(c.getSuperId()))
				.map(temp -> {
					ShopCategoryLevelOneDTO scloDTO = new ShopCategoryLevelOneDTO();
					BeanUtils.copyProperties(temp, scloDTO);
					scloDTO.setShopCategories(scMap.get(temp.getCategoryId()));
					return scloDTO;
				})
				.sorted((c1, c2) -> Integer.compare(c1.getSort(), c2.getSort()))
				.collect(Collectors.toList());
//		shopCategoryList.removeAll(scloDTOList);
//		return null;
	}
}

/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.aliyuncs.exceptions.ClientException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.component.constant.DefaultConstants;
import com.wqwy.zhnm.base.component.exception.BusinessException;
import com.wqwy.zhnm.base.component.utils.MessageUtils;
import com.wqwy.zhnm.base.component.utils.ResultUtils;
import com.wqwy.zhnm.base.component.utils.ValidateUtils;
import com.wqwy.zhnm.base.dao.ValidateCodeMapper;
import com.wqwy.zhnm.base.entity.ValidateCode;

/**
 * createTime: 2018-05-25 13:03:49
 * @author seven
 * @version
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Autowired
    private ValidateCodeMapper validateCodeMapper;

    private static final Logger logger = LoggerFactory.getLogger(ValidateCodeServiceImpl.class);

    @Override
    public ValidateCode get(String id) {
        return validateCodeMapper.get(id);
    }

    @Override
    public List<ValidateCode> findList(ValidateCode validateCode) {
        return validateCodeMapper.findList(validateCode);
    }

    @Override
    public Page<ValidateCode> findListByPage(ValidateCode validateCode, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return validateCodeMapper.findListByPage(validateCode);
    }

    @Override
    public Integer insert(ValidateCode validateCode) {
        validateCode.setSendTime(new Date());
        return validateCodeMapper.insert(validateCode);
    }
    
    @Override
    public Integer insertOrUpdate(ValidateCode validateCode) {
    	Assert.notNull(validateCode.getPhone(), "validate phone not null");
    	Assert.notNull(validateCode.getOperationType(), "operation type not null");
    	
    	List<ValidateCode> vcList = validateCodeMapper.findList(validateCode);
    	Integer resultCount = DefaultConstants.ZERO_INTEGER;
    	validateCode.setSendTime(new Date());
    	validateCode.setCode(ValidateUtils.Get6NumRandomNumber());
    	if (vcList==null || vcList.isEmpty())
    		resultCount = validateCodeMapper.insert(validateCode);
    	else {
    		validateCode.setId(vcList.get(0).getId());
    		resultCount = validateCodeMapper.update(validateCode);
    	}
    	
    	try {
			MessageUtils.DoSendValidateCodePhoneMessageToUser(validateCode);
		} catch (Exception e) {
			throw new BusinessException(ResultUtils.VALIDATE_CODE_SEND_FAIL, ResultUtils.VALIDATE_CODE_SEND_FAIL_MSG);
		}
    	
        return resultCount;
    }

    @Override
    public Integer update(ValidateCode validateCode) {
        validateCode.setSendTime(new Date());
        return validateCodeMapper.update(validateCode);
    }

    @Override
    public Integer delete(String id) {
        return validateCodeMapper.delete(id);
    }
}

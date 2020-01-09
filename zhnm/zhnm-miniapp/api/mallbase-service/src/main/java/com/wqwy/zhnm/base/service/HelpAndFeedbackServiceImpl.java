/**
 * Copyright (c) 2015-2018 <a href="">wqwy</a> All rights reserved.
 */package com.wqwy.zhnm.base.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.wqwy.zhnm.base.dao.HelpAndFeedbackMapper;
import com.wqwy.zhnm.base.entity.HelpAndFeedback;
import com.wqwy.zhnm.base.component.component.Pagenation;
import com.wqwy.zhnm.base.service.HelpAndFeedbackService;

/**
 * createTime: 2018-05-23 12:05:29
 * @author seven
 * @version
 */
@Service
public class HelpAndFeedbackServiceImpl implements HelpAndFeedbackService {

    @Autowired
    private HelpAndFeedbackMapper helpAndFeedbackMapper;

    private static final Logger logger = LoggerFactory.getLogger(HelpAndFeedbackServiceImpl.class);

    @Override
    public HelpAndFeedback get(String id) {
        return helpAndFeedbackMapper.get(id);
    }

    @Override
    public List<HelpAndFeedback> findList(HelpAndFeedback helpAndFeedback) {
        return helpAndFeedbackMapper.findList(helpAndFeedback);
    }

    @Override
    public Page<HelpAndFeedback> findListByPage(HelpAndFeedback helpAndFeedback, Pagenation pagenation) {
        PageHelper.startPage(pagenation.getPageNum(), pagenation.getPageSize());
        return helpAndFeedbackMapper.findListByPage(helpAndFeedback);
    }

    @Override
    public Integer insert(HelpAndFeedback helpAndFeedback) {
        helpAndFeedback.setCreateTime(new Date());
        return helpAndFeedbackMapper.insert(helpAndFeedback);
    }

    @Override
    public Integer update(HelpAndFeedback helpAndFeedback) {
//        helpAndFeedback.setUpdateTime(new Date());
        return helpAndFeedbackMapper.update(helpAndFeedback);
    }

    @Override
    public Integer delete(String id) {
        return helpAndFeedbackMapper.delete(id);
    }
}

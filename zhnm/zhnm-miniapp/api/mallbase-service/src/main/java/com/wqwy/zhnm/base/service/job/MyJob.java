package com.wqwy.zhnm.base.service.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date() + ": doing something...");
        String jobDetail_key_name = jobExecutionContext.getJobDetail().getKey().getName();
        String jobDetail_key_group = jobExecutionContext.getJobDetail().getKey().getGroup();
        String trigger_key_name = jobExecutionContext.getTrigger().getKey().getName();
        String trigger_key_group = jobExecutionContext.getTrigger().getKey().getGroup();
        System.out.println(jobDetail_key_name);
        System.out.println(jobDetail_key_group);
        System.out.println(trigger_key_name);
        System.out.println(trigger_key_group);
    }
}
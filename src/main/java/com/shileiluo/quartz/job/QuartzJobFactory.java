package com.shileiluo.quartz.job;

import com.shileiluo.quartz.model.ScheduleJob;
import com.shileiluo.quartz.service.QuartzService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

/**
 * @description: TODO
 * @author: ShiLeiluo
 * @date: 2021/3/10 21:54
 * @version: v1.0
 */

@Service("quartzJobFactory")
public class QuartzJobFactory extends QuartzJobBean {

    final
    QuartzService quartzService;
    @Autowired
    public QuartzJobFactory(QuartzService quartzService){
        this.quartzService = quartzService;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ScheduleJob object = (ScheduleJob) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");
        if(object.getMethodName()==null || object.getMethodName().equals("")){
            quartzService.executeTask(object.getBeanName());
        }else {
            quartzService.executeTask(object.getBeanName(),object.getMethodName());
        }
    }
}

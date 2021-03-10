package com.shileiluo.quartz.service;

import com.shileiluo.quartz.model.ScheduleJob;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * @description: TODO
 * @author: ShiLeiluo
 * @date: 2021/3/10 21:46
 * @version: v1.0
 */
public interface SchedulerJobService {

    List<ScheduleJob> getAllScheduleJob();

    void checkNotNull(ScheduleJob scheduleJob);

    List<ScheduleJob> getAllRunningJob() throws SchedulerException;

    void saveOrUpdate(ScheduleJob scheduleJob) throws Exception;

    public void pauseJob(String jobName, String jobGroup) throws SchedulerException;

    public void deleteJob(String jobName,String jobGroup) throws SchedulerException;

    public void runOneJob(String jobName, String jobGroup) throws SchedulerException;

    public void resumeJob(String jobName, String jobGroup) throws SchedulerException;



}

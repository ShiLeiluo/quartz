package com.shileiluo.quartz.service;

import com.shileiluo.quartz.model.ScheduleJob;

/**
 * @description: TODO
 * @author: ShiLeiluo
 * @date: 2021/3/10 21:46
 * @version: v1.0
 */
public interface ScheduleJobInService {

    int insert(ScheduleJob scheduleJob);

    int insertSelective(ScheduleJob scheduleJob);

    ScheduleJob selectByJobNameAngJobGroup(String jobName, String groupName);

    ScheduleJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(ScheduleJob scheduleJob);

    int updateByExample(ScheduleJob scheduleJob);

    int deleteByPrimaryKey(Integer id);

    int deleteByJobNameAndJobGroup(String jobName, String jobGroup);



}

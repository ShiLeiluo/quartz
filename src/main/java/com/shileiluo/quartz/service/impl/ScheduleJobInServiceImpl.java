package com.shileiluo.quartz.service.impl;

import com.shileiluo.quartz.dao.ScheduleJobMapper;
import com.shileiluo.quartz.model.ScheduleJob;
import com.shileiluo.quartz.model.ScheduleJobExample;
import com.shileiluo.quartz.service.ScheduleJobInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: TODO
 * @author: ShiLeiluo
 * @date: 2021/3/10 21:49
 * @version: v1.0
 */

@Service("scheduleJobInService")
public class ScheduleJobInServiceImpl implements ScheduleJobInService {

    final
    ScheduleJobMapper scheduleJobMapper;
    @Autowired
    public ScheduleJobInServiceImpl(ScheduleJobMapper scheduleJobMapper){
        this.scheduleJobMapper = scheduleJobMapper;
    }

    @Override
    public int insert(ScheduleJob scheduleJob) {
        int id = scheduleJobMapper.insertSelective(scheduleJob);
        return id;
    }

    @Override
    public int insertSelective(ScheduleJob scheduleJob) {
        int id = scheduleJobMapper.insertSelective(scheduleJob);
        return id;
    }

    @Override
    public ScheduleJob selectByJobNameAngJobGroup(String jobName, String groupName) {
        ScheduleJobExample scheduleJobExample = new ScheduleJobExample();
        scheduleJobExample.createCriteria().andJobGroupEqualTo(groupName).andJobNameEqualTo(jobName);
        List<ScheduleJob> list = scheduleJobMapper.selectByExample(scheduleJobExample);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public ScheduleJob selectByPrimaryKey(Integer id) {
        return scheduleJobMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(ScheduleJob scheduleJob) {
        return scheduleJobMapper.updateByPrimaryKeySelective(scheduleJob);
    }

    @Override
    public int updateByExample(ScheduleJob scheduleJob) {
        ScheduleJobExample scheduleJobExample = new ScheduleJobExample();
        scheduleJobExample.createCriteria().andJobNameEqualTo(scheduleJob.getJobName()).andJobGroupEqualTo(scheduleJob.getJobGroup());
        return scheduleJobMapper.updateByExample(scheduleJob,scheduleJobExample);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scheduleJobMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByJobNameAndJobGroup(String jobName, String jobGroup) {
        ScheduleJobExample scheduleJobExample = new ScheduleJobExample();
        scheduleJobExample.createCriteria().andJobGroupEqualTo(jobGroup).andJobNameEqualTo(jobName);
        return scheduleJobMapper.deleteByExample(scheduleJobExample);
    }
}

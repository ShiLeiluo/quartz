package com.shileiluo.quartz.controller;

import com.shileiluo.quartz.model.ScheduleJob;
import com.shileiluo.quartz.service.SchedulerJobService;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @description: TODO
 * @author: ShiLeiluo
 * @date: 2021/3/14 18:29
 * @version: v1.0
 */

public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private SchedulerJobService schedulerJobService;

    @RequestMapping("/")
    public String index(Model model){
        logger.info("[JobController] the url path:------------/index----------------");
        logger.info("[JobController] the method index is start......");
        List<ScheduleJob> jobList = schedulerJobService.getAllScheduleJob();
        model.addAttribute("jobs",jobList);
        System.out.println(jobList);
        logger.info("[JobController] the method index is end......");
        return "index";
    }
}

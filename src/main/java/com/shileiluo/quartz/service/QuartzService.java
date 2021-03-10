package com.shileiluo.quartz.service;

/**
 * @description: TODO
 * @author: ShiLeiluo
 * @date: 2021/3/10 21:46
 * @version: v1.0
 */
public interface QuartzService {

    void executeTask(String beanName,String methodName);

    void executeTask(String beanName);
}
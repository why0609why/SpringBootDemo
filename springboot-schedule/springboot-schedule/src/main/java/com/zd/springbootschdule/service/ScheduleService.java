package com.zd.springbootschdule.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduleService {

    //指定这个方法是定时任务
    //cron表达式定义了什么时候执行
    @Scheduled(cron = "* * * * * *")
    public void service01() {
        System.out.println("定是任务执行"+new Date());
    }
}

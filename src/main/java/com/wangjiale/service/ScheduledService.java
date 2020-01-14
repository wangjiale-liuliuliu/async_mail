package com.wangjiale.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduledService {

    //在某个特定的时间执行
    //cron表达式 秒 分 时 日 月 周几
    //0/5 43 20 * * ?每天的20点43分每隔5秒执行一次
    //0 15 10 ？ * 1-6 周一到周六，10：15分0秒执行一次
    //具体的表达式可以在百度上面搜
    @Scheduled(cron = "0/5 43 20 * * ?")
    public void hello(){
        System.out.println("定时任务：执行成功！"+new Date());
    }
}

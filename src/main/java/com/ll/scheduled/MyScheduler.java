package com.ll.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyScheduler {
    @Scheduled(fixedRate = 1000)
    public void run() {
        System.out.println("定时任务执行中...");
    }

    @PostConstruct // servlet启动时调用一次
    public void doBuSiness(){
        System.out.println("servlet启动时调用一次");
    }
}

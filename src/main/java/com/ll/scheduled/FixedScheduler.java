package com.ll.scheduled;


import com.ll.task.AsyncTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

@Component
public class FixedScheduler {

    @Autowired
    private AsyncTask asyncTask;


    private LinkedBlockingDeque<Future> queue = new LinkedBlockingDeque<>(1000 * 1000);

    @Scheduled(fixedRate = 10)
    public void run() throws InterruptedException {

        System.out.println("定时任务执行中...");
        asyncTask.doSomethingAsync();

        Future<String> stringFuture = asyncTask.asyncMethodWithReturn();
        queue.add(stringFuture);
    }

    @PostConstruct // servlet启动时调用一次
    public void doBuSiness(){
        System.out.println("servlet启动时调用一次");
    }
}

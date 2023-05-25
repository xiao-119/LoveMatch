package com.ll.demo.scheduled;


import com.ll.demo.task.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class FixedScheduler {

    @Autowired
    private AsyncTask asyncTask;


    private LinkedBlockingDeque<Future> queue = new LinkedBlockingDeque<>(1000 * 1000);

    //    @Scheduled(fixedRate = 10)
    public void run() throws InterruptedException {

        System.out.println("定时任务执行中...");
        asyncTask.doSomethingAsync();

        Future<String> stringFuture = asyncTask.asyncMethodWithReturn();
        queue.add(stringFuture);
    }


    //    @Scheduled(fixedDelay = 1000)
    public void run2() throws InterruptedException {

        long end = System.currentTimeMillis() + (120 * 1000);
        while (System.currentTimeMillis() < end) {
            log.info("定时任务执行中... {}", new Date());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                // Reset interrupt flag and keep going
//                Thread.currentThread().interrupt();
                log.info("遇到中断，继续执行... {}", new Date());
            }
            log.info("定时任务结束... {}", new Date());
        }

    }

    @PostConstruct // servlet启动时调用一次
    public void doBuSiness() {
        System.out.println("servlet启动时调用一次");
    }
}

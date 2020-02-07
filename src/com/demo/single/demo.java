package com.demo.single;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadPool
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class demo {

    public static void main(String[] args) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 提交4个任务，只有一个线程去执行
        for (int i = 0; i < 4; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName()+ " 时间"+simpleDateFormat.format(new Date()));
            });
        }
        executorService.shutdown();
    }
}

package com.demo.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool
 * 创建一个定长线程池，支持定时及周期性任务执行
 */
public class demo {

    public static void main(String[] args) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间" + simpleDateFormat.format(new Date()));

        // 创建一个 newScheduledThreadPool 实现 ScheduledThreadPool , 核心线程树=最大线程树=4 ,采用 LinkBlockingQueue 阻塞队列
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        //延迟5秒执行(只延迟5秒去执行所有任务，不是每个任务延迟5秒执行)
        for (int i = 0; i < 2; i++) {
            executor.schedule(() -> {
                System.out.println(Thread.currentThread().getName()+ " 时间"+simpleDateFormat.format(new Date()));
            }, 5, TimeUnit.SECONDS);
        }
        // 创建并执行并结束一个runnable在延迟指定initialDelay时间，然后，每隔period 时间执行一次
        for (int i = 0; i < 2; i++) {
            executor.scheduleAtFixedRate(() -> {
                System.out.println(Thread.currentThread().getName() + " 时间" + simpleDateFormat.format(new Date()));
            }, 5, 2, TimeUnit.SECONDS);
        }

        // 创建并执行并结束一个runnable在延迟指定initialDelay时间，然后第一次执行完成后，间隔delay时间继续执行一次，无限循环。
        for (int i = 0; i <2; i++) {
            executor.scheduleWithFixedDelay(() -> {
                System.out.println(Thread.currentThread().getName() + " 时间" + simpleDateFormat.format(new Date()));
            }, 5,2, TimeUnit.SECONDS);
        }

        // 关闭任务
        // executor.shutdown();
    }
}

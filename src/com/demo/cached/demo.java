package com.demo.cached;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * cachedThreadPool Demo
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 */
public class demo {
    public static void main(String[] args) {
        // 创建一个 缓存线程池
        // 任务数大于最大线程数 会触发 拒绝策略，抛出拒接异常
        ExecutorService executor = Executors.newCachedThreadPool();
        // pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0
        System.out.println(executor);
        //提交2个任务到线程池,线程池运行任务时，任务先放按顺序放到队列中，放一个，必须取出，然后才能放下去。
        for (int i = 1; i <= 2; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+Thread.currentThread().getName()+"取到任务");
            });
            // 第一次  pool size = 1, active threads = 1, queued tasks = 0, completed tasks = 0
            // 第二次  pool size = 2, active threads = 2, queued tasks = 0, completed tasks =
            System.out.println(executor);
        }
        // 休眠70秒 ，超过 空闲存活时间 60s，会被结束掉。
        // pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 2
        try {
            TimeUnit.SECONDS.sleep(70);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(executor);
        // 关闭任务
        executor.shutdown();
    }
}

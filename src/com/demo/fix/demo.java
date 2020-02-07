package com.demo.fix;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * fixThreadPool Demo
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 */

public class demo {
    public static void main(String[] args) {
        // 创建一个 newFixedThreadPool , 核心线程树=最大线程树=4 ,采用 LinkBlockingQueue 阻塞队列
        ExecutorService executor =  Executors.newFixedThreadPool(4);
        //提交6个任务到线程池,线程池运行任务时，有两个任务会放到阻塞队列中，等待线程池里的线程执行完后再从阻塞队列中获取任务再执行
        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName()+"执行任务"+ taskId);
                try {
                    //休眠 3秒
                    System.out.println(Thread.currentThread().getName()+"休眠");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // 关闭任务
        executor.shutdown();
    }
}



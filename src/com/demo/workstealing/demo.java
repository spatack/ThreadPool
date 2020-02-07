package com.demo.workstealing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newWorkStealingThreadPool
 * 工作窃取线程池，创建一个定长线程，采用抢占机制，不保证任务执行顺序
 */
public class demo {

    public static void main(String[] args) {
        // 提交10个任务，但这个线程池会获取当前可用核心数
        ExecutorService executorService = Executors.newWorkStealingPool();
        int nCPU = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors:" + nCPU);
        for (int i = 1; i <= 8; i++) {
            int taskId = i;
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " 执行task" + taskId)
            );
        }
        //开死循环，不然可能看不到执行结果
        while (true) {

        }
//        创建了5个线程去执行任务，可以看到线程1执行task1后抢到了task4
//        ForkJoinPool-1-worker-1 执行task1
//        ForkJoinPool-1-worker-2 执行task2
//        ForkJoinPool-1-worker-3 执行task3
//        ForkJoinPool-1-worker-3 执行task7
//        ForkJoinPool-1-worker-5 执行task8
//        ForkJoinPool-1-worker-4 执行task6
//        ForkJoinPool-1-worker-1 执行task4
//        ForkJoinPool-1-worker-2 执行task5
    }
}

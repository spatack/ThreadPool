package com.demo.future;

import java.util.concurrent.*;

/**
 * Future使用demo
 */
public class demo {
    static class AddNameTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("######addNameTask::Call######");
            Thread.sleep(5000);
            return "Haha";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 先返回一个future
        Future<String> future = executorService.submit(new AddNameTask());
        System.out.println(Thread.currentThread().getName() + "主线程正在执行其他任务");
        // 获取返回结果，这里会阻塞组线程，让子线程去返回值给主线程。
        String name = future.get();
        System.out.println("name:" + name);
        executorService.shutdown();
    }
}

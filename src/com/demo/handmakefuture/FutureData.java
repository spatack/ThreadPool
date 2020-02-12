package com.demo.handmakefuture;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Future数据
 */
public class FutureData implements Data {

    public volatile static boolean FLAG = false; //取到结果标志
    Lock lock = new ReentrantLock();

    private RealData realData;


    public synchronized void setRealData(RealData realData) {
        //如果取到数据，直接返回
        if (FLAG) {
            return;
        }
        // 没取到数据，传递真实对象
        this.realData = realData;
        FLAG = true;
        // 进行通知
        notify();
    }

    @Override
    public synchronized String getRequest() {
        while (!FLAG) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 获取到数据直接返回
        return realData.getRequest();
    }
}

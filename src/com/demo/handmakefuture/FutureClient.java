package com.demo.handmakefuture;

/**
 * FutureClient
 */
public class FutureClient {

    public Data request(String queryStr) {
        FutureData futureData = new FutureData();
        new Thread(() -> {
            RealData realData = new RealData(queryStr);
            futureData.setRealData(realData);
        }).start();
        return futureData;
    }
}

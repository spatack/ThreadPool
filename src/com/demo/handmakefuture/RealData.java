package com.demo.handmakefuture;

/**
 * 真实数据
 */
public class RealData implements Data {
    private String result;

    public RealData(String data) {
        System.out.println("正在使用DATA:"+data+"网络请求数据，耗时操作需要等待");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("获取完毕，获取结果....");
        result = "jason";
    }

    @Override
    public String getRequest() {
        return result;
    }
}

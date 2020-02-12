package com.demo.handmakefuture;

public class demo {
    public static void main(String[] args) {
        FutureClient client = new FutureClient();
        Data data = client.request("aaa");
        System.out.println("发送成功");
        System.out.println("执行其他任务");
        String result = data.getRequest();
        System.out.println("获取结果..."+result);
    }
}

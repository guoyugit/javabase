package com.gy.concurrent.mode.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {

    private ConcurrentLinkedQueue<Task> workQueue;
    private ConcurrentHashMap<String, Object> resultMap;

    public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (true) {
            Task input = this.workQueue.poll();
            if (null == input)
                break;// 任务全部执行完毕后退出
            // 真正去做业务处理
            Object output = handle(input);
            this.resultMap.put(input.getId() + "", output);
        }
    }

    protected Object handle(Task input) {
        Object output = null;
        System.out.println("所在类：" + this.getClass().getName() + "---工作线程：" + Thread.currentThread().getName() + "---执行任务id：" + input.getId());
        try {
            // 表示处理task任务耗时，可能是数据加工也可能是操作数据库...
            Thread.sleep(500);
            output = input.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }

}
package com.gy.concurrent.mode.masterworker;

public class MyWorker extends Worker {
    @Override
    public Object handle(Task input) {
        Object output = null;
        System.out.println("所在类：" + this.getClass().getName() + "---工作线程：" + Thread.currentThread().getName() + "---执行任务id：" + input.getId());
        try {
            // 表示处理task任务耗时，可能是数据加工也可能是操作数据库...
            Thread.sleep(500);
            output = input.getId();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }
}
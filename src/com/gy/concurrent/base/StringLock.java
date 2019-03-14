package com.gy.concurrent.base;

/**
 * @Description: string字符串常量在常量池中只有一个引用，会出现死循环问题:
 * 更改锁的对象：
 * synchronized (new String("字符串常量"))
 * 不能使用String.class以及普通string常量作为synchronized锁的对象
 * @Author: 郭宇
 * @CreateDate: 2019/3/14 20:30
 */
public class StringLock {
    public void method() {
        //new String("字符串常量")
        synchronized ("字符串常量") {
            try {
                while (true) {
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "开始");
                    Thread.sleep(1000);
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "结束");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final StringLock sl = new StringLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sl.method();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sl.method();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
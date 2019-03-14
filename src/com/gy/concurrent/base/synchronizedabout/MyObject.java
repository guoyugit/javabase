package com.gy.concurrent.base.synchronizedabout;

/**
 * 同步：代表资源共享，达到线程安全
 * 线程安全满足两个特性：
 * 原子性（同步）
 * 可见性
 *
 * 现象：t1，t2同时打印。
     锁住同步实例方法时，其他线程访问同步实例方法（当前同步方法或其他同步方法）需要等待锁释放，访问非同步方法，无需等待。
     根本原因是，两个实例方法锁住的是同一个对象，同一个对象锁住后需要释放锁才可以继续访问。
     若method添加static synchronized则t1与t2也同时打印，因为method此时锁住的是MyObject类class，method1锁住的是mo对象。
 */
public class MyObject {

    public synchronized void method1() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final MyObject mo = new MyObject();
//        final MyObject mo2 = new MyObject();

        Thread t1 = new Thread(new Runnable() {

            public void run() {
                mo.method1();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {

            public void run() {
                mo.method2();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
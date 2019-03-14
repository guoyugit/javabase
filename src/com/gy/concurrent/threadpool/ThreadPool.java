package com.gy.concurrent.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 为什么用线程池?
 1.创建/销毁线程伴随着系统开销，过于频繁的创建/销毁线程，会很大程度上影响处理效率。
 2.线程并发数量过多，抢占系统资源从而导致阻塞。
 3.对线程进行一些简单的管理。

 在Java中，线程池的概念是Executor这个接口，具体实现为ThreadPoolExecutor类，
 学习Java中的线程池，就可以直接学习他了对线程池的配置，就是对ThreadPoolExecutor构造函数的参数的配置。
 */
public class ThreadPool {

    public static void main(String[] args) {
    }

}
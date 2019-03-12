package com.gy.concurrent.base;
/**
* @Description:
  多个线程访问某一个类（对象或方法）时，这个类始终都能表现出正确的行为，那么就是线程安全的
 （线程排队按照cpu分配的先后顺序进行）
 线程要执行synchronized包裹的代码需要首先尝试获得锁，获得锁后执行内部代码，获取不到，不断尝试获取锁。直到拿到为止，多个线程同时竞争。
 * @Author:         郭宇
* @CreateDate:     2019/3/12 13:34
*/
public class MyThread extends Thread {

	private int count = 5;

	//未加synchronized加锁时无法保证随线程操作逐次递减
	//假设有1000个程序，当一个程序释放锁后，会有999个程序同时竞争该锁，使得电脑cpu使用率一下子上升至很大值，
	// 导致应用及其慢甚至是宕机。需要尽量避免多线程抢一把锁的问题。
	public synchronized void run() {
		count--;
		System.out.println(this.currentThread().getName() + " count = " + count);
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread t1 = new Thread(myThread, "t1");
		Thread t2 = new Thread(myThread, "t2");
		Thread t3 = new Thread(myThread, "t3");
		Thread t4 = new Thread(myThread, "t4");
		Thread t5 = new Thread(myThread, "t5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
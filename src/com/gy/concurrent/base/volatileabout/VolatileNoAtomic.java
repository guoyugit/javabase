package com.gy.concurrent.base.volatileabout;

import java.util.concurrent.atomic.AtomicInteger;

/**
* @Description:
 * 中间的数字不是0整数因为eclipse打印有延迟，但是最后一次执行玩后打印结果应当是10000才对。
	volatile不保证原子性，AtomicInteger 保证原子性。
* @Author:         郭宇
* @CreateDate:     2019/3/18 13:18
*/
public class VolatileNoAtomic extends Thread {
//	private static volatile int count = 0;
	 private static AtomicInteger count = new AtomicInteger(0);

	private static void addCount() {
		for (int i = 0; i < 1000; i++) {
//			count++;
			 count.incrementAndGet();
		}
		System.out.println(Thread.currentThread().getName() + "---" + count);
	}

	public void run() {
		addCount();
	}

	public static void main(String[] args) {
		VolatileNoAtomic[] arr = new VolatileNoAtomic[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = new VolatileNoAtomic();
		}
		for (int i = 0; i < 10; i++) {
			arr[i].setName("t" + (i + 1));
			arr[i].start();
		}
	}
}
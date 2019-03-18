package com.gy.concurrent.base.volatileabout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/**
* @Description:    多个addAndGet在一个方法内不是原子性的，需要加synchronized修饰，
 * 					保证四个addAndGet的整体原子性(最终结果是对的)： 每次的添加操作是加10，
 * 					不加synchronized会导致每次加的结果不是整10.
* @Author:         郭宇
* @CreateDate:     2019/3/18 13:21
*/
public class AtomicUse {
	private static AtomicInteger count = new AtomicInteger(0);

	//多个addAndGet在一个方法内不是原子性的，需要加synchronized修饰，保证四个addAndGet的整体原子性
	private int multiAdd() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count.addAndGet(1);
		count.addAndGet(2);
		count.addAndGet(3);
		count.addAndGet(4);
		return count.get();
	}

	public static void main(String[] args) {
		final AtomicUse au = new AtomicUse();
		List<Thread> ts = new ArrayList<Thread>();
		for (int i = 0; i < 100; i++) {
			ts.add(new Thread(new Runnable() {
				public void run() {
					System.out.println(au.multiAdd());
				}
			}));
		}
		for (Thread thread : ts) {
			thread.start();
		}
	}
}
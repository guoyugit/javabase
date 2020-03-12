package com.gy.concurrent.base.communicate;

import java.util.ArrayList;
import java.util.List;
/**
 * @Description: 使用wait/notify 到达某一个节点，停止另一个线程
 * 	notify并不释放锁，只有synchronized锁住的方法结束后才会释放锁。wait会直接释放锁。
	最大的问题在于不是实时的，size是5的时候并没有立刻释放还拥有锁资源，for循环后才释放。
 * @Author:         郭宇
 * @CreateDate:     2019/3/22 10:47
 */
public class ListAdd2 {
	private volatile static List list = new ArrayList();

	public void add() {
		list.add("bjsxt");
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) {

		final ListAdd2 list2 = new ListAdd2();
		final Object lock = new Object();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (lock) {
						System.out.println("t1启动..");
						for (int i = 0; i < 10; i++) {
							list2.add();
							System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素..");
							Thread.sleep(500);
							if (list2.size() == 5) {
								System.out.println("已经发出通知..");
								lock.notify();
							}
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("t2启动..");
					if (list2.size() != 5) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("当前线程：" + Thread.currentThread().getName() + "收到通知线程停止..");
					throw new RuntimeException();
				}
			}
		}, "t2");
		t2.start();
		t1.start();

	}

}
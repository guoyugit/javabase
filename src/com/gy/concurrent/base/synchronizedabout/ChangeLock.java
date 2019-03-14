package com.gy.concurrent.base.synchronizedabout;
/**
 * @Description: 锁住的字符变量修改后，两把锁同时进入，设置的时间间隔无效：
 * @Author:         郭宇
 * @CreateDate:     2019/3/14 20:32
 */
public class ChangeLock {

	private String lock = "lock";

	public void method() {
		synchronized (lock) {
			try {
				while (true) {
					System.out.println("当前线程：" + Thread.currentThread().getName() + "开始");
					lock = "change lock";
					Thread.sleep(10000);
					System.out.println("当前线程：" + Thread.currentThread().getName() + "结束");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final ChangeLock cl = new ChangeLock();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				cl.method();
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				cl.method();
			}
		}, "t2");
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}
}
package com.gy.concurrent.base;

public class ChangeLock {

	private String lock = "lock";

	public void method() {
		synchronized (lock) {
			try {
				while (true) {
					System.out.println("当前线程：" + Thread.currentThread().getName() + "开始");
					lock = "change lock";
					Thread.sleep(2000);
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
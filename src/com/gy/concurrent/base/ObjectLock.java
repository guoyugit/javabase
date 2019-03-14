package com.gy.concurrent.base;
/**
 * @Description: 可以使用任意的object进行加锁
 * @Author:         郭宇
 * @CreateDate:     2019/3/14 20:12
 */
public class ObjectLock {
	public void method1() {
		synchronized (this) {
			try {
				System.out.println("do method1..");
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void method2() {
		synchronized (ObjectLock.class) {
			try {
				System.out.println("do method2..");
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private Object lock = new Object();

	public void method3() {
		synchronized (lock) {
			try {
				System.out.println("do method3..");
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		final ObjectLock ol = new ObjectLock();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ol.method1();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				ol.method2();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				ol.method3();
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}
}
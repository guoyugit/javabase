package com.gy.concurrent.base.synchronizedabout;

/**
 * synchronized获取的都是对象锁，而不是把方法当作锁，多个对象可以拥有多个对象锁
 * num是静态变量，单个对象操作后，会影响其他对象的读取
 */
public class MultiThread {

	private static int num = 0;

	/** static **/
	//num是static属性，printNum是实例方法，多个对象锁住的不是同一个对象，synchronized失效。
	// m1获得的是m1对象的锁，m2获得的是m2对象的锁。
	//加static，保证锁的唯一性：
	public synchronized void printNum(String tag) {
		try {
			if ("a".equals(tag)) {
				num = 100;
				System.out.println(Thread.currentThread().getName()+"tag a , set num over!");
				Thread.sleep(1000);
			} else {
				num = 200;
				System.out.println(Thread.currentThread().getName()+"tag b , set num over!");
			}
			System.out.println(Thread.currentThread().getName()+"tag " + tag + ", num = " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//两个对象
		final MultiThread m1 = new MultiThread();
		final MultiThread m2 = new MultiThread();

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				m1.printNum("a");
			}
		});
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				m2.printNum("b");
			}
		});
		t1.start();
		t2.start();
	}
}
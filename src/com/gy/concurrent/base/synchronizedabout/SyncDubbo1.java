package com.gy.concurrent.base.synchronizedabout;
/**
 * @Description: synchronized可重入功能
 * 使用synchronized时，当一个线程得到了一个对象的锁，再次请求该对象是可以再次得到这个把锁的。
 * web应用程序异常释放锁，如果不及时处理，会对应用程序的业务逻辑产生严重错误，比如执行一个队列任务，很多对象等待第一个对象正确执行完毕后，再释放锁，但由于第一个
 * 对象异常的出现，导致业务逻辑没有正常执行完毕，就释放了锁，后续执行结果也肯定都是错误逻辑。
 * @Author:         郭宇
 * @CreateDate:     2019/3/12 17:14
 */
public class SyncDubbo1 {

	public synchronized void method1() {
		System.out.println("method1..");
		method2();
	}

	public synchronized void method2() {
		System.out.println("method2..");
		method3();
	}

	public synchronized void method3() {
		System.out.println("method3..");
	}

	public static void main(String[] args) {
		final SyncDubbo1 sd = new SyncDubbo1();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				sd.method1();
			}
		});
		t1.start();
	}
}
package com.gy.concurrent.base.synchronizedabout;
/**
 * @Description: synchronized中的异常问题
 * synchronized代码块中碰到异常立即释放锁。
	多线程处理异常的方式：
	1.catch中记录异常日志，continue继续接下来的任务，此时当前任务与后续任务没有关联关系()
	2.有关联关系，可以catch中抛出InterruptedException异常停止继续向下运行；或者直接catch中抛出运行时异常
	throw new RuntimeException();
 * @Author:         郭宇
 * @CreateDate:     2019/3/12 18:40
 */
public class SyncException {
	private int i = 0;

	public synchronized void operation() {
		while (true) {
			try {
				i++;
				Thread.sleep(200);
				System.out.println(Thread.currentThread().getName() + ", i =" + i);
				if (i == 10) {
					Integer.parseInt("a");
					// throw new RuntimeException();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(" log info i =" + i);
				// throw new RuntimeException();
				continue;
			}
		}
	}

	public static void main(String[] args) {
		final SyncException se = new SyncException();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				se.operation();
			}
		}, "t1");
		t1.start();
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				se.operation();
			}
		}, "t2");
		t2.start();
	}
}
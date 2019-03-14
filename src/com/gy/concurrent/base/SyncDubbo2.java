package com.gy.concurrent.base;
/**
 * @Description:子父类继承关系
 * 子类中的synchronized方法中可以调用父类的synchronized方法
 *
 * @Author:         郭宇
 * @CreateDate:     2019/3/12 18:26
 */
public class SyncDubbo2 {

	static class Main {
		public int i = 10;

		public synchronized void opreationSup() {//父类方法
			try {
				i--;
				System.out.println("Main print i = " + i);
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class Sub extends Main {
		public synchronized void opreationSub() {//子类方法
			try {
				while (i > 0) {
					i--;
					System.out.println("Sub print i = " + i);
					Thread.sleep(100);
					this.opreationSup();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Sub sub = new Sub();
				sub.opreationSub();
			}
		});
		t1.start();
	}
}
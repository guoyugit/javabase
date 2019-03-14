package com.gy.concurrent.base;
/**
 * @Description: 脏读
 *	对一个对象的方法进行加锁时，要考虑到业务的整体性，如为set/get方法同时加锁，保证业务的原子性，侧面保证了业务的一致性。
 * @Author:         郭宇
 * @CreateDate:     2019/3/12 16:27
 */
public class DirtyRead {

	private String username = "zhangsan";
	private String password = "123";

	public synchronized void setValue(String username, String password) {
		this.username = username;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("setValue的最终结果：username = " + username + ", password = " + password);
	}

	//此时，getValue方法也需要加上synchronized
	//根据业务需要，如果多个方法之间存在纽带联系，最好多个方法同时同步。保证数据的同步性。
	//数据库中的acid特性：
	//原子，一致，隔离，持久性
	public void getValue() {
		System.out.println("getValue的最终结果：username = " + this.username + ", password = " + this.password);
	}

	public static void main(String[] args) throws Exception {
		final DirtyRead dr = new DirtyRead();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				dr.setValue("lisi", "456");
			}
		});
		t1.start();
		Thread.sleep(1000);
		dr.getValue();
	}
}
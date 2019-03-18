package com.gy.concurrent.mode.producercustomer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable {
	private BlockingQueue<Data> queue;

	public Customer(BlockingQueue<Data> queue) {
		this.queue = queue;
	}

	// 随机对象
	private static Random r = new Random();

	@Override
	public void run() {
		while(true){
			// 获取数据
			try {
				Data data = this.queue.take();
				// 进行数据处理，休眠0-1000毫秒模拟耗时
				Thread.sleep(r.nextInt(1000));
				System.out.println("当前消费线程:" + Thread.currentThread().getName() + "，消费成功，消费数据id为：" + data.getId());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
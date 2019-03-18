package com.gy.concurrent.mode.masterworker;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Master master = new Master(new MyWorker(), 10);
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			Task t = new Task();
			t.setId(i);
			t.setName("任务" + i);
			t.setPrice(1);
			master.submit(t);
		}
		master.execute();
		long start = System.currentTimeMillis();
		while (true) {
			if (master.isComplete()) {
				long end = System.currentTimeMillis() - start;
				int ret = master.getResult();
				System.out.println("最终结果：" + ret + ",最终耗时：" + end);
				break;
			}
		}
	}
}
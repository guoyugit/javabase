package com.gy.concurrent.mode.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

	// 1.装载所有任务的容器
	private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<>();

	// 2.装载所有worker对象的容器
	private HashMap<String, Thread> workers = new HashMap<>();

	// 3.装载每一个worker并发处理任务的结果集集合 任务id对应对应的结果集
	private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

	// 管控所有的工作进程 传入worker和worker数量 为所有的worker填充工作队列和工作结果集
	public Master(Worker worker, int workCount) {
		worker.setWorkQueue(this.workQueue);
		worker.setResultMap(this.resultMap);
		for (int i = 0; i < workCount; i++) {
			workers.put("子线程" + i, new Thread(worker));
		}
	}

	// 添加任务
	public void submit(Task task) {
		this.workQueue.add(task);
	}

	// 启动所有worker去执行任务
	public void execute() {
		for (Map.Entry<String, Thread> me : workers.entrySet()) {
			me.getValue().start();
		}
	}

	// 判断线程是否执行完毕
	public boolean isComplete() {
		for (Map.Entry<String, Thread> me : workers.entrySet()) {
			if (me.getValue().getState() != Thread.State.TERMINATED) {//线程未结束执行
				return false;
			}
		}
		return true;//所有线程执行完毕返回true
	}

	// 返回结果集数据
	public int getResult() {
		int ret = 0;
		for (Map.Entry<String, Object> me : resultMap.entrySet()) {
			// 汇总的逻辑
			ret += (int) me.getValue();
		}
		return ret;
	}
}
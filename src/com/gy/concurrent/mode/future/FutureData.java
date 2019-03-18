package com.gy.concurrent.mode.future;

public class FutureData implements Data {

	private RealData realData;//最终客户需要的数据
	
	private boolean isReady = false;
	
	public synchronized void setRealData(RealData realData) {
		if(isReady){//如果已经装载完毕，就直接返回
			return;
		}
		//如果没装载，进行装载真实对象
		this.realData = realData;
		isReady = true;
		//进行通知
		notify();
	}

	@Override
	public synchronized String getRequest() {
		//如果没装载好 程序一直处于阻塞状态
		while(!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//装载好直接获取数据即可
		return this.realData.getRequest();
	}

	
	
	

}
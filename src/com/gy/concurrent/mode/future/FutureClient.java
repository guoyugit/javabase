package com.gy.concurrent.mode.future;

public class FutureClient {

	public Data request(final String queryStr) {
		// 我想要一个代理对象（Data接口实现类）先返回给发送请求的客户端，告诉他请求已经接收到，可以做其他事情
		final FutureData futureData = new FutureData();
		// 启动一个新的线程，去加载真实的数据，传递给这个代理对象
		new Thread(new Runnable() {
			@Override
			public void run() {
				// 这个新的线程可以慢慢的去加载真实对象，然后传递给代理对象
				RealData realData = new RealData(queryStr);
				futureData.setRealData(realData);
			}
		}).start();
		return futureData;
	}

}
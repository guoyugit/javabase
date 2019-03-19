package com.gy.designpattern.observer.csdn.origin;

//抽象主题角色
public interface Subject {
	// 登记一个新的观察者
	public void attach(Observer observer);

	// 删除一个新的观察者
	public void detach(Observer observer);

	// 通知所有登记过的观察者
	void notifyObserver();
}
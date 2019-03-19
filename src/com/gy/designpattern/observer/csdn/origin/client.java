package com.gy.designpattern.observer.csdn.origin;

//客户端
public class client {
	private static ConcreteSubject subject;
	private static ConcreteObserver observer;

	public static void main(String[] args) {
		// 创建主题对象
		subject = new ConcreteSubject();
		// 创建观察者对象
		observer = new ConcreteObserver();

		// 将观察者对象登记到主题对象是上
		subject.attach(observer);
		// 改变主题对象通知观察者
		subject.notifyObserver();
	}
}
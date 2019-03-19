package com.gy.designpattern.observer.csdn.origin;

//具体观察者角色
public class ConcreteObserver implements Observer {
	@Override
	public void update() {
		System.out.println("我被唤醒更新！");
	}
}
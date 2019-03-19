package com.gy.designpattern.observer.csdn.advance;


//具体主题角色，只需要关系自己的业务逻辑
public class ConcreteSubject extends Subject {

	private String state;

	// 调用此方法更新主题状态
	public void change(String newstate) {
		state = newstate;
		this.notifyObserver();
	}
}
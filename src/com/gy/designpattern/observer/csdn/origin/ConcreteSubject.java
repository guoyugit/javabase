package com.gy.designpattern.observer.csdn.origin;

import java.util.Enumeration;
import java.util.Vector;

//具体主题角色
public class ConcreteSubject implements Subject {

	private Vector observerVector = new java.util.Vector();

	// 登记一个新的观察者
	@Override
	public void attach(Observer observer) {

		observerVector.addElement(observer);
	}

	// 删除一个新的观察者
	@Override
	public void detach(Observer observer) {
		observerVector.removeElement(observer);

	}

	@Override
	public void notifyObserver() {
		Enumeration enumeration = observers();
		while (enumeration.hasMoreElements()) {
			((Observer) enumeration.nextElement()).update();

		}

	}

	// 给出观察者聚集的Enumeration对象
	private Enumeration observers() {
		return ((Vector) observerVector.clone()).elements();
	}

}
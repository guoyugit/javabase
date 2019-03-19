package com.gy.designpattern.observer.csdn.advance;

import com.gy.designpattern.observer.csdn.origin.Observer;

import java.util.Enumeration;
import java.util.Vector;

//抽象主题角色
abstract public class Subject {
	private Vector observerVector = new java.util.Vector();

	// 登记一个新的观察者
	public void attach(Observer observer) {

		observerVector.addElement(observer);
		System.out.println("add an observer");
	}

	// 删除一个新的观察者
	public void detach(Observer observer) {
		observerVector.removeElement(observer);
		System.out.println("delete an observer");

	}

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
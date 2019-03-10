package com.gy.pattern.single;

/**
 * 1.构造函数私有化；
 * 2.静态方法进行new类，提供该类实例。
 */
public class Singleton {
	private static Singleton uniqeInstance = null;
	private Singleton() {
	};
	public static Singleton getInstance() {//存在线程安全问题
		if (uniqeInstance == null) {
			uniqeInstance = new Singleton();
		}
		return uniqeInstance;
	}
}
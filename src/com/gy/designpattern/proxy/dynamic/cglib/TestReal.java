package com.gy.designpattern.proxy.dynamic.cglib;


public class TestReal {
	public static void main(String[] args) {
		
		CglibProxy proxy = new CglibProxy();
		Real real = (Real)proxy.getProxy(Real.class);
		real.removeForum(10);
		real.removeTopic(1023);
	}
}
package com.gy.designpattern.factory.nofactory;

public class CheesePizza extends Pizza {

	@Override
	public void prepare() {
		super.setname("CheesePizza");
		
		System.out.println(name+" preparing;");
	}

}
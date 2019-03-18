package com.gy.designpattern.factory.nofactory;

public class ChinesePizza extends Pizza {

	@Override
	public void prepare() {
		super.setname("ChinesePizza");
		
		System.out.println(name+" preparing;");
	}

}
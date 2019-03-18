package com.gy.designpattern.factory.factorymethod;

import com.gy.designpattern.factory.nofactory.Pizza;

public class LDCheesePizza extends Pizza {

	@Override
	public void prepare() {
		super.setname("LDCheesePizza");
		System.out.println(name+" preparing;");
	}

}
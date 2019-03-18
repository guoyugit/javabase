package com.gy.designpattern.factory.factorymethod;

import com.gy.designpattern.factory.nofactory.Pizza;

public class NYCheesePizza extends Pizza {

	@Override
	public void prepare() {
		super.setname("NYCheesePizza");
		System.out.println(name+" preparing;");
	}

}
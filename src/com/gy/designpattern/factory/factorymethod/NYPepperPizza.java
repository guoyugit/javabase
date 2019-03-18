package com.gy.designpattern.factory.factorymethod;

import com.gy.designpattern.factory.nofactory.Pizza;

public class NYPepperPizza extends Pizza {

	@Override
	public void prepare() {
		super.setname("NYPepperPizza");
		
		System.out.println(name+" preparing;");
	}

}
package com.gy.designpattern.factory.factorymethod;

import com.gy.designpattern.factory.nofactory.Pizza;

public class LDPepperPizza extends Pizza {

	@Override
	public void prepare() {
		super.setname("LDPepperPizza");
		
		System.out.println(name+" preparing;");
	}

}
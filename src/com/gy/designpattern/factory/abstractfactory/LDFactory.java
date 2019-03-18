package com.gy.designpattern.factory.abstractfactory;


import com.gy.designpattern.factory.factorymethod.LDCheesePizza;
import com.gy.designpattern.factory.factorymethod.LDPepperPizza;
import com.gy.designpattern.factory.nofactory.Pizza;

public class LDFactory implements AbsFactory {

	@Override
	public Pizza CreatePizza(String ordertype) {
		Pizza pizza = null;

		if (ordertype.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (ordertype.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		return pizza;

	}

}
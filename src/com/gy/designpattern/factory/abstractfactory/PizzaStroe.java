package com.gy.designpattern.factory.abstractfactory;



public class PizzaStroe {
	public static void main(String[] args) {
		
		OrderPizza mOrderPizza;
		mOrderPizza=new	OrderPizza(new LDFactory());
		
	}

	

}
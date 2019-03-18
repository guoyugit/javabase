package com.gy.designpattern.factory.abstractfactory;


import com.gy.designpattern.factory.nofactory.Pizza;

public interface AbsFactory {
	public Pizza CreatePizza(String ordertype) ;
}
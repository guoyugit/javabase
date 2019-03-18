package com.gy.designpattern.factory.abstractfactory;


import com.gy.designpattern.factory.factorymethod.NYCheesePizza;
import com.gy.designpattern.factory.factorymethod.NYPepperPizza;
import com.gy.designpattern.factory.nofactory.Pizza;

public class NYFactory implements AbsFactory {


    @Override
    public Pizza CreatePizza(String ordertype) {
        Pizza pizza = null;

        if (ordertype.equals("cheese")) {
            pizza = new NYCheesePizza();
        } else if (ordertype.equals("pepper")) {
            pizza = new NYPepperPizza();
        }
        return pizza;

    }

}
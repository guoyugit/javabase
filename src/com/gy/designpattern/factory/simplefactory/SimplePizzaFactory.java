package com.gy.designpattern.factory.simplefactory;


import com.gy.designpattern.factory.nofactory.CheesePizza;
import com.gy.designpattern.factory.nofactory.GreekPizza;
import com.gy.designpattern.factory.nofactory.PepperPizza;
import com.gy.designpattern.factory.nofactory.Pizza;

public class SimplePizzaFactory {

    public Pizza CreatePizza(String ordertype) {
        Pizza pizza = null;

        if (ordertype.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (ordertype.equals("greek")) {
            pizza = new GreekPizza();
        } else if (ordertype.equals("pepper")) {
            pizza = new PepperPizza();
        }
        return pizza;

    }

}
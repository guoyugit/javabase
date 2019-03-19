package com.gy.designpattern.strategymode.advance.flybehavior;


public class GoodFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("--GoodFly--");
    }

}
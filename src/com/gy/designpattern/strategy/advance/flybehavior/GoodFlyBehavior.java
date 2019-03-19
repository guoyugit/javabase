package com.gy.designpattern.strategy.advance.flybehavior;


public class GoodFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("--GoodFly--");
    }

}
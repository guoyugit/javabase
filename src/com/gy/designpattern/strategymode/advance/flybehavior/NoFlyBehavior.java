package com.gy.designpattern.strategymode.advance.flybehavior;


public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("--NoFly--");
    }
}

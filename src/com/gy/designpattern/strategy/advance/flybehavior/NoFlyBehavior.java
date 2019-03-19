package com.gy.designpattern.strategy.advance.flybehavior;


public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("--NoFly--");
    }
}

package com.gy.designpattern.strategy.advance.flybehavior;


public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("--BadFly--");
    }
}

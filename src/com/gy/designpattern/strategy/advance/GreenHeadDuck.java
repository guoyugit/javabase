package com.gy.designpattern.strategy.advance;

import com.gy.designpattern.strategy.advance.flybehavior.GoodFlyBehavior;
import com.gy.designpattern.strategy.advance.quackbehavior.GaGaQuackBehavior;

public class GreenHeadDuck extends Duck {

    public GreenHeadDuck() {
        mFlyBehavior = new GoodFlyBehavior();
        mQuackBehavior = new GaGaQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("**GreenHead**");
    }
}
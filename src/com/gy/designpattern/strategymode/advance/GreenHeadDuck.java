package com.gy.designpattern.strategymode.advance;

import com.gy.designpattern.strategymode.advance.flybehavior.FlyBehavior;
import com.gy.designpattern.strategymode.advance.flybehavior.GoodFlyBehavior;
import com.gy.designpattern.strategymode.advance.quackbehavior.GaGaQuackBehavior;
import com.gy.designpattern.strategymode.advance.quackbehavior.QuackBehavior;

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
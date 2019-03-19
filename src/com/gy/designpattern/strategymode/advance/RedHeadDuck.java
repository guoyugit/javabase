package com.gy.designpattern.strategymode.advance;


import com.gy.designpattern.strategymode.advance.flybehavior.BadFlyBehavior;
import com.gy.designpattern.strategymode.advance.quackbehavior.GeGeQuackBehavior;

public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        mFlyBehavior = new BadFlyBehavior();
        mQuackBehavior = new GeGeQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("**RedHead**");
    }

}

package com.gy.designpattern.strategy.advance;


import com.gy.designpattern.strategy.advance.flybehavior.BadFlyBehavior;
import com.gy.designpattern.strategy.advance.quackbehavior.GeGeQuackBehavior;

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

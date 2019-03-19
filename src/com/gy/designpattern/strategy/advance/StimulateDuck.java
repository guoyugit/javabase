package com.gy.designpattern.strategy.advance;

import com.gy.designpattern.strategy.advance.flybehavior.NoFlyBehavior;
import com.gy.designpattern.strategy.advance.quackbehavior.NoQuackBehavior;

public class StimulateDuck {

    public static void main(String[] args) {

        Duck mGreenHeadDuck = new GreenHeadDuck();
        Duck mRedHeadDuck = new RedHeadDuck();

        mGreenHeadDuck.display();
        mGreenHeadDuck.Fly();
        mGreenHeadDuck.Quack();
        mGreenHeadDuck.swim();

        mRedHeadDuck.display();
        mRedHeadDuck.Fly();
        mRedHeadDuck.Quack();
        mRedHeadDuck.swim();
        mRedHeadDuck.display();
        mRedHeadDuck.SetFlyBehavoir(new NoFlyBehavior());
        mRedHeadDuck.Fly();
        mRedHeadDuck.SetQuackBehavoir(new NoQuackBehavior());
        mRedHeadDuck.Quack();
    }

}

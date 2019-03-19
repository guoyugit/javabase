package com.gy.designpattern.strategy.advance;

import com.gy.designpattern.strategy.advance.flybehavior.FlyBehavior;
import com.gy.designpattern.strategy.advance.quackbehavior.QuackBehavior;

public abstract class Duck {
    FlyBehavior mFlyBehavior;
    QuackBehavior mQuackBehavior;

    public Duck() {
    }

    public void Fly() {
        mFlyBehavior.fly();
    }

    public void Quack() {
        mQuackBehavior.quack();
    }

    public void SetQuackBehavoir(QuackBehavior qb) {
        mQuackBehavior = qb;
    }

    public void SetFlyBehavoir(FlyBehavior fb) {
        mFlyBehavior = fb;
    }

    public abstract void display();

    public void swim() {
        System.out.println("~~im swim~~");
    }
}
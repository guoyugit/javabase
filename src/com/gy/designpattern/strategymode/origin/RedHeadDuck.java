package com.gy.designpattern.strategymode.origin;
public class RedHeadDuck extends Duck {
	@Override
	public void display() {
		System.out.println("**RedHead**");
	}

	public void Fly() {
		System.out.println("~~GOOD fly~~");
	}
}
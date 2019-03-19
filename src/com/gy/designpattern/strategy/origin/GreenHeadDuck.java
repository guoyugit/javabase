package com.gy.designpattern.strategy.origin;
public class GreenHeadDuck extends Duck {
	@Override
	public void display() {
		System.out.println("**GreenHead**");
	}
	public void Fly() {
		System.out.println("~~no fly~~");
	}

}
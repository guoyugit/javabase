package com.gy.designpattern.strategymode.origin;
public class GreenHeadDuck extends Duck {
	@Override
	public void display() {
		System.out.println("**GreenHead**");
	}
	public void Fly() {
		System.out.println("~~no fly~~");
	}

}
package com.gy.designpattern.strategymode.origin;
public abstract class Duck {
	public void Quack() {
		System.out.println("~~gaga~~");
	}
	public abstract void display();
	public void swim() {
		System.out.println("~~im swim~~");
	}
}
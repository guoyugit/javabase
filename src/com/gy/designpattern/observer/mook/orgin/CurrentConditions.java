package com.gy.designpattern.observer.mook.orgin;
/**
 * @Description: 公告板
 * @Author:         郭宇
 * @CreateDate:     2019/3/19 17:02
 */
public class CurrentConditions {

	private float mTemperature;
	private float mPressure;
	private float mHumidity;

	public void update(float mTemperature, float mPressure, float mHumidity) {
		this.mTemperature = mTemperature;
		this.mPressure = mPressure;
		this.mHumidity = mHumidity;
		display();
	}

	public void display() {
		System.out.println("***Today mTemperature: " + mTemperature + "***");
		System.out.println("***Today mPressure: " + mPressure + "***");
		System.out.println("***Today mHumidity: " + mHumidity + "***");
	}
}
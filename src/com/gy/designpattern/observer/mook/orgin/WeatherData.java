package com.gy.designpattern.observer.mook.orgin;

public class WeatherData {

	private float mTemperatrue;// 温度
	private float mPressure;// 气压
	private float mHumidity;// 湿度
	private CurrentConditions mCurrentConditions;

	public WeatherData(CurrentConditions mCurrentConditions) {
		this.mCurrentConditions = mCurrentConditions;
	}

	public float getTemperature() {
		return mTemperatrue;

	}

	public float getPressure() {
		return mPressure;

	}

	public float getHumidity() {
		return mHumidity;

	}

	public void dataChange() {
		mCurrentConditions.update(getTemperature(), getPressure(), getHumidity());
	}

	public void setData(float mTemperature, float mPressure, float mHumidity) {
		this.mTemperatrue = mTemperature;
		this.mPressure = mPressure;
		this.mHumidity = mHumidity;
		dataChange();
	}

}
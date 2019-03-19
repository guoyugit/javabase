package com.gy.designpattern.observer.mook.advance;



public class InternetWeather {

	public static void main(String[] args) {
		
		CurrentConditions mCurrentConditions;//本日天气
		ForcastConditions mForcastConditions;//明日天气
		WeatherDataSt mWeatherDataSt;//具体主题角色
		
		mWeatherDataSt=new WeatherDataSt();
		mCurrentConditions=new CurrentConditions();
		mForcastConditions=new ForcastConditions();
		
		mWeatherDataSt.registerObserver(mCurrentConditions);//注册本日天气
		mWeatherDataSt.registerObserver(mForcastConditions);//注册明日天气
		
		mWeatherDataSt.setData(30, 150, 40);//设置状态
		mWeatherDataSt.removeObserver(mCurrentConditions);//移除本日天气
		mWeatherDataSt.setData(40, 250, 50);//设置状态
	}

}
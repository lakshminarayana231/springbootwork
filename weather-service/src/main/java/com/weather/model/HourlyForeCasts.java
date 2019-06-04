package com.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class HourlyForeCasts {

	private ForeCastLocation forecastLocation;

	@Override
	public String toString() {
		return "HourlyForeCast [forecastLocation=" + forecastLocation + "]";
	}

	public ForeCastLocation getForecastLocation() {
		return forecastLocation;
	}

	public void setForecastLocation(ForeCastLocation forecastLocation) {
		this.forecastLocation = forecastLocation;
	}
}

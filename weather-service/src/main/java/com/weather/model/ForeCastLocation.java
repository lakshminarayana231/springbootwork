package com.weather.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ForeCastLocation {

	private String country;
	private String city;
	private String state;
	private List<ForeCast> forecast;
	@Override
	public String toString() {
		return "ForeCastLocation [country=" + country + ", city=" + city + ", state=" + state + ", forecast=" + forecast
				+ "]";
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<ForeCast> getForecast() {
		return forecast;
	}
	public void setForecast(List<ForeCast> forecast) {
		this.forecast = forecast;
	}
}

package com.weather.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.weather.model.dateformatter.CustomDateSerializer;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ForeCast {

	@Override
	public String toString() {
		return "ForeCast [temperature=" + temperature + ", utcTime=" + utcTime + "]";
	}
	
	private String temperature;
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date utcTime;
	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the utcTime
	 */
	public Date getUtcTime() {
		return utcTime;
	}
	/**
	 * @param utcTime the utcTime to set
	 */
	public void setUtcTime(Date utcTime) {
		this.utcTime = utcTime;
	}
}

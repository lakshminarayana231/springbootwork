package com.weather.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.weather.model.dateformatter.CustomDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastDetails {

	private HourlyForeCasts hourlyForecasts;
	
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date feedCreation;
	
	public HourlyForeCasts getHourlyForecasts() {
		return hourlyForecasts;
	}
	@JsonProperty("hourlyForecasts")
	public void setHourlyForecasts(HourlyForeCasts hourlyForecasts) {
		this.hourlyForecasts = hourlyForecasts;
	}
	@Override
	public String toString() {
		return "WeatherForecastDetails [hourlyForecasts=" + hourlyForecasts + ", feedCreation=" + feedCreation + "]";
	}
	public Date getFeedCreation() {
		return feedCreation;
	}
	public void setFeedCreation(Date feedCreation) {
		this.feedCreation = feedCreation;
	}
	
}

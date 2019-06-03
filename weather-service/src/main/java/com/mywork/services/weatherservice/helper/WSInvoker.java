package com.mywork.services.weatherservice.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.weather.model.WeatherForecastDetails;

@Component
public class WSInvoker {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate rsTemplate;
	
	@Value("${weather.enpoint}")
	private String endPoint;
	
	@Value("${application_ID}")
	private String appID;
	
	@Value("${application_code}")
	private String app_code;
	
	public WeatherForecastDetails getWeatherForecast(String zipCode){
		
		UriComponentsBuilder builder = UriComponentsBuilder
			    .fromUriString(endPoint)
			    // Add query parameter
			    .queryParam("product", "forecast_hourly")
			    .queryParam("zipcode", zipCode)
			    .queryParam("oneobservation", "true")
			    .queryParam("app_id", appID)
			    .queryParam("app_code", app_code);
		
		logger.info("caling URL "+builder.build().getPath());
		WeatherForecastDetails response = rsTemplate.getForObject(builder.build().toUri(), WeatherForecastDetails.class);
		logger.info("response from service is "+response.toString());
		
		return response;
	}
}

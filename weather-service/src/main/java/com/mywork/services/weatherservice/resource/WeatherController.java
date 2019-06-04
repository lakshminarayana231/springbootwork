package com.mywork.services.weatherservice.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywork.services.weatherservice.helper.WSInvoker;
import com.mywork.services.weatherservice.validator.RequestValidator;
import com.weather.model.WeatherForecastDetails;


@RestController
@RequestMapping("weather-forecast/1.0")
public class WeatherController {

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WSInvoker wsInvoker;
	
	@Autowired
	private RequestValidator reqValidator;
	
	
	@RequestMapping(value = "hourly", method = RequestMethod.GET)
	public WeatherForecastDetails getHourlyWeatherForecast(@RequestParam("zipcode") String zipCode){
		System.out.println("In Logger");
		logger.info("Request Received -> zipCode="+zipCode);
		
		reqValidator.doValidate(zipCode);
		WeatherForecastDetails weatherForecastDetails = wsInvoker.getWeatherForecast(zipCode);
		
		logger.info("Request served successfully -> zipCode="+zipCode);
		return weatherForecastDetails;
	}
	
	
}

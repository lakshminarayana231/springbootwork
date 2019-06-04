package com.mywork.services.weatherservice;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URI;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.weather.model.WeatherForecastDetails;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT,
classes=WeatherServiceApplication.class)
@AutoConfigureMockMvc
public class WeatherServiceIntegrationTest {

	@Mock
    private RestTemplate restTemplate;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testWeatherService() throws Exception {

		//Mock only external web service call
		
		when(restTemplate.getForEntity("https://weather.cit.api.here.com/weather/1.0/report.json?product=forecast_hourly&zipcode=30338&oneobservation=true&app_id=MS4giXoZF2F5US8oEYnD&app_code=f0NpJSGSpoo2Dj-6UkMvYA", WeatherForecastDetails.class))
        .thenReturn(new ResponseEntity(new WeatherForecastDetails(), HttpStatus.OK));
		
		String zipCode = "30883";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/weather-forecast/1.0/hourly?zipcode=" + "30338" )
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), 200);
	}
	
	@Test
	public void testWeatherService_BadRequest() throws Exception {

		String zipCode = "abcd";
		//Mock only external web service call
		
		
		when(restTemplate.getForEntity("https://weather.cit.api.here.com/weather/1.0/report.json?product=forecast_hourly&zipcode=30338&oneobservation=true&app_id=MS4giXoZF2F5US8oEYnD&app_code=f0NpJSGSpoo2Dj-6UkMvYA", WeatherForecastDetails.class))
        .thenReturn(new ResponseEntity(new WeatherForecastDetails(), HttpStatus.OK));
		
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/weather-forecast/1.0/hourly?zipcode=" + zipCode )
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		Assert.assertEquals(result.getResponse().getStatus(), 400);
	}
}

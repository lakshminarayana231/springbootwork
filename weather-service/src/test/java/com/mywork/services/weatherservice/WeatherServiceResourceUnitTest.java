package com.mywork.services.weatherservice;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mywork.services.weatherservice.helper.WSInvoker;
import com.mywork.services.weatherservice.validator.RequestValidator;
import com.weather.model.WeatherForecastDetails;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherServiceResourceUnitTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RequestValidator reqValidator;
	
	@MockBean
	private WSInvoker wsInvoker;
	

	@Test
	public void checkStatusCode() throws Exception {
		String zipCode = "30987";
		doNothing().when(reqValidator).doValidate(mock(Object.class));
		doReturn(new WeatherForecastDetails()).when(wsInvoker).getWeatherForecast(zipCode);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/weather-forecast/1.0/hourly?zipcode=" + zipCode)
				.accept(MediaType.APPLICATION_JSON)).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		Assert.assertEquals(result.getResponse().getStatus(), 200);
	}
	
}

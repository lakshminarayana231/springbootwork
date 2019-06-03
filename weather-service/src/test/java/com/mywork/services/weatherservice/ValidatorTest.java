package com.mywork.services.weatherservice;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mywork.services.weatherservice.exception.BadDataException;
import com.mywork.services.weatherservice.validator.RequestValidator;
import com.mywork.services.weatherservice.validator.WeatherServiceValidator;

@SpringBootTest
public class ValidatorTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private RequestValidator requestValidator = new WeatherServiceValidator();

	@Test
	public void testNullZipCode() {
		try {
			requestValidator.doValidate(null);
			Assert.assertTrue(false);
		} catch (BadDataException be) {
			Assert.assertTrue(true);
			if (!be.getMessage().contains("null")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testEmptyZipCode() {
		try {
			requestValidator.doValidate("   ");
			Assert.assertTrue(false);
		} catch (BadDataException be) {
			Assert.assertTrue(true);
			if (!be.getMessage().contains("empty")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testAlphaZipCode() {
		try {
			requestValidator.doValidate("234B");
			Assert.assertTrue(false);
		} catch (BadDataException be) {
			Assert.assertTrue(true);
			if (!be.getMessage().equals("zipCode should contain only numbers")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			Assert.assertTrue(false);
		}
	}
	@Test
	public void testInvaidZipCode() {
		try {
			requestValidator.doValidate("2$%^");
			Assert.assertTrue(false);
		} catch (BadDataException be) {
			Assert.assertTrue(true);
			if (!be.getMessage().equals("zipCode should contain only numbers")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testValidZipCode() {
		try {
			requestValidator.doValidate("23124");
			Assert.assertTrue(true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testInvalidLengthZipCode() {
		try {
			requestValidator.doValidate("231246");
			Assert.assertTrue(false);
		} catch (BadDataException be) {
			Assert.assertTrue(true);
			if (!be.getMessage().equals("zip code should be of length 5")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			Assert.assertTrue(false);
		}
	}
	
}

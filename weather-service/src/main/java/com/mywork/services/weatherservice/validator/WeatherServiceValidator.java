package com.mywork.services.weatherservice.validator;

import org.springframework.stereotype.Component;

import com.mywork.services.weatherservice.exception.BadDataException;

@Component
public class WeatherServiceValidator implements RequestValidator {

	@Override
	public void doValidate(Object input) throws BadDataException {
		String errorMsg = null;
		if(input == null){
			errorMsg = "zipCode Can't be null";
		}
		else if(input.toString().trim().isEmpty()){
			errorMsg ="zipCode can't be empty";
		}
		else if(!input.toString().matches(("[0-9]+"))){
			errorMsg ="zipCode should contain only numbers";
		}else if(input.toString().length() > 5){
			errorMsg ="zip code should be of length 5";
		}

		if(errorMsg != null){
			throw new BadDataException(errorMsg);
		}
	}

}

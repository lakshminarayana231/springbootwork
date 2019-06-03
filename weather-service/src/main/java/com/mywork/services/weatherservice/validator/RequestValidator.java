package com.mywork.services.weatherservice.validator;

import com.mywork.services.weatherservice.exception.BadDataException;

public interface RequestValidator {

	abstract void doValidate(Object input) throws BadDataException;
}

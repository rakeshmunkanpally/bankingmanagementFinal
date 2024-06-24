package com.bankmanagement.client.bao;

import java.time.LocalDate;
import java.time.Period;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidateDate implements ConstraintValidator<CheckDate, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		if(value!=null && Period.between(value,LocalDate.now()).getYears()>=18) {
			return true;
		}
		return false;
	}

}
